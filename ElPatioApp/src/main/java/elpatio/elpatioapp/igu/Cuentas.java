package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.Mesa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Cuentas extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    
    int numeroMesaMostrada = -1;
    
    public Cuentas() {
        initComponents();
        cargarMesasOcupadas();
        cargarMesasDisponibles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        cmbMesas = new javax.swing.JComboBox<>();
        btnAgregarProducto = new javax.swing.JButton();
        btnCerrarCuenta = new javax.swing.JButton();
        btnAbrirMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbMesasDisponibles = new javax.swing.JComboBox<>();
        btnMostrarMesa = new javax.swing.JButton();

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

        cmbMesas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnAgregarProducto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAgregarProducto.setText("AGREGAR PRODUCTO");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnCerrarCuenta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCerrarCuenta.setText("CERRAR CUENTA");
        btnCerrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCuentaActionPerformed(evt);
            }
        });

        btnAbrirMesa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAbrirMesa.setText("ABRIR MESA");
        btnAbrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirMesaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CUENTAS");

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

        jLabel2.setText("Seleccionar una de las mesas abiertas:");

        btnMostrarMesa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnMostrarMesa.setText("MOSTRAR MESA");
        btnMostrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMostrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(290, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCerrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAbrirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(cmbMesasDisponibles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarMesa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cmbMesasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrirMesa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarCuenta)
                    .addComponent(btnAgregarProducto))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        
        int numeroMesa = Integer.valueOf(String.valueOf(cmbMesas.getSelectedItem()));
        AgregarProducto ap = new AgregarProducto(numeroMesa);
        ap.setVisible(true);
        ap.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnCerrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCuentaActionPerformed

        if(numeroMesaMostrada!=-1){

            CerrarCuenta cc = new CerrarCuenta(numeroMesaMostrada);
            cc.setVisible(true);
            cc.setLocationRelativeTo(null);
            this.dispose();
            
        }
        

    }//GEN-LAST:event_btnCerrarCuentaActionPerformed

    private void btnAbrirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirMesaActionPerformed

        //Agarramos el número de mesa que nos envían desde el igu y lo ponemos en la variable numeroMesa
        int numeroMesa = Integer.valueOf(String.valueOf(cmbMesasDisponibles.getSelectedItem()));
        
        //Traemos los datos de la mesa seleccionada
        Mesa mesa = control.traerUnaMesa(numeroMesa);
        
        //Le cambiamos el estado a Ocupada
        String estado = "Ocupada";
        mesa.setEstado_Me(estado);
        
        //Actualizamos en la base de datos
        control.editarMesa(mesa);

        
        //Creamos la Factura para permitir el ingreso de distintos DetalleFactura
        
        Factura fac = new Factura();
        fac.setMesa_Fa(mesa);
        fac.setFecha_Fa(LocalDateTime.now());
        fac.setEstado_Fa("En proceso");
        
        
        control.crearFactura(fac);
        
        //Removemos los ítems de los combobox y cargamos los actualizados
        cmbMesas.removeAllItems();
        cmbMesasDisponibles.removeAllItems();
        cargarMesasDisponibles();
        cargarMesasOcupadas();
        
    }//GEN-LAST:event_btnAbrirMesaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnMostrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarMesaActionPerformed

        int numeroMesa = Integer.valueOf(String.valueOf(cmbMesas.getSelectedItem()));
        numeroMesaMostrada = numeroMesa;
        cargarDetalleFacturaMesa(numeroMesa);
        
    }//GEN-LAST:event_btnMostrarMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirMesa;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrarCuenta;
    private javax.swing.JButton btnMostrarMesa;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMesas;
    private javax.swing.JComboBox<String> cmbMesasDisponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
                
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblCuenta.setModel(tab);
    }
    
    public void cargarMesasOcupadas(){
        
        ArrayList<Mesa> lista = control.traerMesas();
        
        for(Mesa m : lista){
            if("Ocupada".equals(m.getEstado_Me()))
            cmbMesas.addItem(String.valueOf(m.getNumeroMesa_Me()));
            
        }
        
    }
    
    public void cargarMesasDisponibles(){
        
        ArrayList<Mesa> lista = control.traerMesas();
        
        for(Mesa m : lista){
            if("Disponible".equals(m.getEstado_Me()))
            cmbMesasDisponibles.addItem(String.valueOf(m.getNumeroMesa_Me()));
            
        }
        
    }
    

}
