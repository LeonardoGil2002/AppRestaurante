package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.FormaDePago;
import elpatio.elpatioapp.logica.Mesa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CerrarCuenta extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    int numeroMesa;    
    float total = 0;
    
    
    public CerrarCuenta(int numMesa) {
        initComponents();
        cargarDetalleFacturaMesa(numMesa);
        cargarFdp();
        this.numeroMesa = numMesa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        btnCerrarCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        cmbFdp = new javax.swing.JComboBox<>();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCuenta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCuenta);

        btnCerrarCuenta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCerrarCuenta.setText("CERRAR CUENTA");
        btnCerrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCuentaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CERRAR CUENTA");

        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Desktop\\AppRestaurante-master\\boton_volver.png")); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cmbFdp.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbFdp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(btnCerrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCerrarCuenta)
                    .addComponent(cmbFdp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCuentaActionPerformed

            //Traemos los datos de la mesa seleccionada
            Mesa mesa = control.traerUnaMesa(numeroMesa);
            
            //Le cambiamos el estado a "Disponible"
            String estadoMesa = "Disponible";
            mesa.setEstado_Me(estadoMesa);
            
            //Actualizamos la mesa en la BD
            control.editarMesa(mesa);
            
            //Traemos los datos de la factura
            int numeroFactura = control.traerNumeroDeFactura(numeroMesa);
            Factura fac = control.traerUnaFactura(numeroFactura);

            //Cambiamos el estado de la factura a "Finalizada"
            String estadoFactura = "Finalizada";
            fac.setEstado_Fa(estadoFactura);
            
            //Le agregamos la forma de pago utilizada
            String formaDePago = String.valueOf(cmbFdp.getSelectedItem());
            FormaDePago fdp = control.traerUnaFormaDePagoPorNombre(formaDePago);
            fac.setFormaDePago_Fa(fdp);
            
            //Seteamos el total
            fac.setTotal_Fa(total);
            
            //Actualizamos la factura en la BD
            control.editarFactura(fac);
            
            //Le mostramos un mensaje confirmando que se editó correctamente la forma de pago
            int confirmar = JOptionPane.showConfirmDialog(null, "Toque 'aceptar' para continuar",
                    "Se ha cerrado la cuenta con éxito", JOptionPane.CLOSED_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            //Mandamos a la página anterior al usuario y cerramos la actual
            if(confirmar == 0){
                Cuentas cu = new Cuentas();
                cu.setVisible(true);
                cu.setLocationRelativeTo(null);
                this.dispose();
            }

    }//GEN-LAST:event_btnCerrarCuentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Cuentas cu = new Cuentas();
        cu.setVisible(true);
        cu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbFdp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCuenta;
    // End of variables declaration//GEN-END:variables

    public void cargarDetalleFacturaMesa(int numeroMesa){
        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Id Factura","Id Detalle Factura", "Producto", "Cantidad", "Precio"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList<DetalleFactura> lista = control.traerDetalleFacturaMesa(numeroMesa);
                
        
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(DetalleFactura df : lista){
                
                Object[] objeto = {df.getId_DF().getId_Fa_DF(), df.getId_DF().getId_DF(),
                df.getMenu_DF().getNombre_Me(), df.getCantidad_DF(), df.getMenu_DF().getPrecio_Me()*df.getCantidad_DF()};

                tab.addRow(objeto);
                
                //Vamos acumulando el total
                total = total + df.getMenu_DF().getPrecio_Me()*df.getCantidad_DF();
                
            }
        }
        
        
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblCuenta.setModel(tab);
        
        //Mostramos el total a pagar
        lblTotal.setText("TOTAL: " + String.valueOf(total));
    }
    
    public void cargarFdp(){
        
        ArrayList<FormaDePago> lista = control.traerFormasDePago();
        
        for(FormaDePago fdp : lista){
            if(fdp.getEstado_FP()){
                cmbFdp.addItem(fdp.getFormaDePago_FP());
            }
            
        }
        
    }
    
    

}
