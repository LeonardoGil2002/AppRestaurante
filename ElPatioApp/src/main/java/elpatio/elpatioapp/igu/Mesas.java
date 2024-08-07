package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.Mesa;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Mesas extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    
    public Mesas() {
        initComponents();
        cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnEliminarMesa = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        btnMostrarMesasEliminadas = new javax.swing.JButton();
        btnBorrarFiltros = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarMesa = new javax.swing.JButton();
        txtNumeroMesa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEliminarMesa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminarMesa.setText("ELIMINAR");
        btnEliminarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMesaActionPerformed(evt);
            }
        });

        tblMesas.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblMesas);

        btnMostrarMesasEliminadas.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnMostrarMesasEliminadas.setText("MOSTRAR MESAS ELIMINADAS");
        btnMostrarMesasEliminadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarMesasEliminadasActionPerformed(evt);
            }
        });

        btnBorrarFiltros.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBorrarFiltros.setText("BORRAR FILTROS");
        btnBorrarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarFiltrosActionPerformed(evt);
            }
        });

        btnRecuperar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRecuperar.setText("RECUPERAR MESA");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMostrarMesasEliminadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(btnRecuperar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnEliminarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarMesasEliminadas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnAgregarMesa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgregarMesa.setText("AGREGAR");
        btnAgregarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMesaActionPerformed(evt);
            }
        });

        txtNumeroMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroMesaKeyTyped(evt);
            }
        });

        jLabel1.setText("Número de mesa:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mesas");

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

        lblMensaje.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(0, 153, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblMensaje)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnEliminarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMesaActionPerformed

        //Chequeamos que haya una fila seleccionada
        if(tblMesas.getSelectedRow()!=-1){
            
            //Mensaje de confirmación
            int confirmar = JOptionPane.showConfirmDialog(null, "Aceptar o Cancelar",
       "¿Seguro que desea eliminar?", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
            //Si se tocó confirmar, entra acá
            if(confirmar==0){
                //Agarramos el número de mesa de la mesa a eliminar y lo guardamos en una variable
                int numeroMesa = Integer.parseInt(String.valueOf(tblMesas.getValueAt(tblMesas.getSelectedRow(),0)));
                
                Mesa mes = new Mesa();
                mes = control.traerUnaMesa(numeroMesa);
                mes.setEstado_Me("Fuera de servicio");
                
                //Es una baja lógica, por lo que no se va a borrar la mesa, solo se va a poner su estado en "Fuera de servicio"
                control.editarMesa(mes);
                
                //Cargamos nuevamente la tabla para que se actualice
                cargarTabla();
            }
        
        }
        
    }//GEN-LAST:event_btnEliminarMesaActionPerformed

    private void btnAgregarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMesaActionPerformed

        //Confirmamos que todos los campos estén llenos
        if(!"".equals(txtNumeroMesa.getText())){
        
            int numeroMesa = Integer.parseInt(txtNumeroMesa.getText());
            String estado = "Disponible";

            //Comprobamos si la mesa ingresada ya existe
            if(control.existeMesa(numeroMesa) == 0){

                //Cargamos la nueva mesa a la base de datos
                control.crearMesa(numeroMesa, estado);
                txtNumeroMesa.setText("");
                lblMensaje.setText("Se ha agregado correctamente");
                //Refrescamos la tabla
                cargarTabla();


            }
            //Si existe la mesa ingresada, mostramos un error
            else{
                JOptionPane.showConfirmDialog(null, "Error",
                    "Esta mesa ya existe", JOptionPane.CLOSED_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            lblMensaje.setText("Por favor completar todos los campos");
            lblMensaje.setForeground(Color.red);
        }
        
    }//GEN-LAST:event_btnAgregarMesaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //Volvemos a la pantalla de main y cerramos la actual
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    
    //Validamos que solo se puedan ingresar números
    private void txtNumeroMesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroMesaKeyTyped
       
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <=57;
        
        if(!numero){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroMesaKeyTyped

    private void btnMostrarMesasEliminadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarMesasEliminadasActionPerformed

        cargarMesasEliminadas();
        
    }//GEN-LAST:event_btnMostrarMesasEliminadasActionPerformed

    private void btnBorrarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarFiltrosActionPerformed

        cargarTabla();

    }//GEN-LAST:event_btnBorrarFiltrosActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed

        //Chequeamos que haya una fila seleccionada
        if(tblMesas.getSelectedRow()!=-1){
            
            //Agarramos el número de mesa de la mesa a eliminar y lo guardamos en una variable
            int numeroMesa = Integer.parseInt(String.valueOf(tblMesas.getValueAt(tblMesas.getSelectedRow(),0)));
            Mesa mes = new Mesa();
            mes = control.traerUnaMesa(numeroMesa);
            
            if("Fuera de servicio".equals(mes.getEstado_Me())){
            
                //Mensaje de confirmación
                int confirmar = JOptionPane.showConfirmDialog(null, "Aceptar o Cancelar",
                "¿Seguro que desea recuperar la mesa " + numeroMesa + " ?", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);

                //Si se tocó confirmar, entra acá
                if(confirmar==0){

                    //Cambiamos el estado de la mesa
                    mes.setEstado_Me("Disponible");

                    //Actualizamos el estado en la base de datosa
                    control.editarMesa(mes);

                    //Cargamos nuevamente la tabla para que se actualice
                    cargarMesasEliminadas();
                }
            }
            else{
                int confirmar = JOptionPane.showConfirmDialog(null, "Toque 'aceptar' para continuar",
                "Esta mesa no está fuera de servicio", JOptionPane.CLOSED_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        
    }//GEN-LAST:event_btnRecuperarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMesa;
    private javax.swing.JButton btnBorrarFiltros;
    private javax.swing.JButton btnEliminarMesa;
    private javax.swing.JButton btnMostrarMesasEliminadas;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTextField txtNumeroMesa;
    // End of variables declaration//GEN-END:variables

    //Función para cargar la tabla con lo que tenemos en la base de datos
    public void cargarTabla(){

        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Número de mesa","Estado"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList <Mesa> lista = control.traerMesas();
                
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(Mesa me : lista){
                
                if(!"Fuera de servicio".equals(me.getEstado_Me())){
                    Object[] objeto = {me.getNumeroMesa_Me(), me.getEstado_Me()};

                    tab.addRow(objeto);
                }
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblMesas.setModel(tab);
        
        
    }
    
    //Función para cargar la tabla con todas las mesas eliminadas
    public void cargarMesasEliminadas(){

        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Número de mesa","Estado"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList <Mesa> lista = control.traerMesas();
                
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(Mesa me : lista){
                
                if("Fuera de servicio".equals(me.getEstado_Me())){
                    Object[] objeto = {me.getNumeroMesa_Me(), me.getEstado_Me()};

                    tab.addRow(objeto);
                }
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblMesas.setModel(tab);
        
        
    }


}



