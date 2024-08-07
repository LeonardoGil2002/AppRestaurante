package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.DetalleFacturaPK;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.Menu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class VerDetalleFactura extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    int numeroFactura;
    
    
    public VerDetalleFactura(int numeroFac) {
        initComponents();
        
        //Seteo el número de factura que recibo de la página anterior y se lo asigno a la variable global "numeroFactura"
        this.numeroFactura = numeroFac;
        
        //Cargo la tabla de detalles de factura
        cargarTabla();
        
        //Pongo como título el número de mesa seleccionado
        lblFactura.setText("FACTURA " + numeroFactura);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFactura = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFactura.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        lblFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/boton_volver.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblDetalle.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //Volvemos a la pantalla de Facturas y cerramos la actual
        Facturas fa = new Facturas();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JTable tblDetalle;
    // End of variables declaration//GEN-END:variables

    
    public void cargarTabla(){
        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Id Detalle Factura", "Producto", "Cantidad", "Precio"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList<DetalleFactura> lista = control.traerDetallesDeFactura(numeroFactura);
                
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(DetalleFactura df : lista){
                
                Object[] objeto = {df.getId_DF().getId_DF(), df.getMenu_DF().getNombre_Me(), df.getCantidad_DF(),
                df.getMenu_DF().getPrecio_Me()*df.getCantidad_DF()};

                tab.addRow(objeto);
                
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblDetalle.setModel(tab);
    }
}
