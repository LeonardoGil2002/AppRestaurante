package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.DetalleFacturaPK;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.Menu;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class AgregarProducto extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    int numeroMesa;
    
    
    public AgregarProducto(int numeroMes) {
        initComponents();
        
        //Seteo el número de mesa que recibo de la página anterior y se lo asigno a la variable global "numeroMesa"
        this.numeroMesa = numeroMes;
        
        //Cargo la tabla de detalles de factura
        cargarTabla();
        
        //Cargo el combobox de productos
        cargarComboBoxProductos();
        
        //Cargo las sugerencias del combobox para que se pueda autocompletar
        cargarSugerenciasComboBox();
        
        //Pongo como título el número de mesa seleccionado
        lblMesa.setText("MESA " + numeroMesa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMesa = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        cbMenu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        btnCerrarCuenta = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMesa.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        lblMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Producto:");

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        cbMenu.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Cantidad:");

        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarCuenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarCuenta)
                    .addComponent(lblMensaje))
                .addContainerGap(43, Short.MAX_VALUE))
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
        //Volvemos a la pantalla de main y cerramos la actual
        Cuentas cu = new Cuentas();
        cu .setVisible(true);
        cu .setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        //Validación de que todo está completo
        if(!"".equals(txtCantidad.getText())){
            //Creo un objeto DetalleFactura que será enviado a la BD
            DetalleFactura df = new DetalleFactura();

            //Obtengo el objeto menú que seleccionó el usuario
            Menu men = control.traerUnMenuSegunNombre(String.valueOf(cbMenu.getSelectedItem()));

            //Obtengo la cantidad ingresada
            int cantidad = Integer.valueOf(txtCantidad.getText());

            //Obtengo el número de factura de la mesa ocupada actualmente
            int numeroFactura = control.traerNumeroDeFactura(numeroMesa);

            //Obtengo el próximo número de detalle correspondiente a la factura actual
            int numeroDetalle= control.traerProximoDetalleFactura(numeroFactura);

            //Creo un objeto de tipo DetalleFacturaPK con los datos del número de detalle y número de factura
            DetalleFacturaPK dfPK = new DetalleFacturaPK(numeroDetalle, numeroFactura);

            //Traigo la factura actual
            Factura fac = control.traerUnaFactura(numeroFactura);

            //Seteo todos los atributos correspondientes
            df.setCantidad_DF(cantidad);
            df.setFactura_DF(fac);
            df.setId_DF(dfPK);
            df.setMenu_DF(men);

            //Creo el detalle de factura en la base de datos
            try {
                control.crearDetalleFactura(df);
            } catch (Exception ex) {
                Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Limpio los datos de entrada
            txtCantidad.setText("");
            cbMenu.setSelectedIndex(0);

            //Actualizo la tabla de detalle de factura
            cargarTabla();
        }
        else{
            lblMensaje.setText("Por favor completar todos los campos");
            lblMensaje.setForeground(Color.red);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCerrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCuentaActionPerformed
            
            //Redirecciono a la pantalla de CerrarCuenta y cierro la pantalla actual
            CerrarCuenta cc = new CerrarCuenta(numeroMesa);
            cc.setVisible(true);
            cc.setLocationRelativeTo(null);
            this.dispose();    }//GEN-LAST:event_btnCerrarCuentaActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <=57;
        
        if(!numero){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrarCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JTable tblCuenta;
    private javax.swing.JTextField txtCantidad;
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
    
    public void cargarComboBoxProductos(){
        ArrayList<Menu> menu = control.traerMenu();
        //Llenamos el comboBox de "categorías" con las categorías de nuestra BD
        for(Menu c: menu){
            if(c.getEstado_Me()==true){
                cbMenu.addItem(c.getNombre_Me());
            }
        }
    }
    
    
    //Para que puedas escribir y se autocomplete el combobox
    private void cargarSugerenciasComboBox() {      
        AutoCompleteDecorator.decorate(cbMenu);
    }

}
