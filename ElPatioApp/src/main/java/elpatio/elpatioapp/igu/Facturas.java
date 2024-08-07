package elpatio.elpatioapp.igu;

import elpatio.elpatioapp.logica.ControladoraLogica;
import elpatio.elpatioapp.logica.Factura;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Facturas extends javax.swing.JFrame {

    ControladoraLogica control = new ControladoraLogica();
    int total;
    
    public Facturas() {
        initComponents();
        cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jdtDesde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cmbDesde = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdtHasta = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cmbHasta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnCalcularTotal = new javax.swing.JButton();
        btnLimpiarFiltros = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facturas");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFactura);

        btnVerDetalle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnVerDetalle.setText("VER DETALLE");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtro de búsqueda");

        cmbDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel3.setText("Hora:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Hasta:");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora:");

        cmbHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel8.setText("Desde:");

        btnCalcularTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCalcularTotal.setText("CALCULAR TOTAL");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });

        btnLimpiarFiltros.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiarFiltros.setText("LIMPIAR FILTROS");
        btnLimpiarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jdtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jdtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalcularTotal))))))
                .addGap(14, 15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jdtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cmbHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCalcularTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLimpiarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //Volvemos a la pantalla de main y cerramos la actual
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed

        //Chequeamos que haya seleccionada una fila
        if(tblFactura.getSelectedRow()!=-1){
            
            //Obtenemos el número de factura seleccionado
            int numeroFactura = Integer.parseInt(String.valueOf(tblFactura.getValueAt(tblFactura.getSelectedRow(),0)));
            
            //Vamos a la página de VerDetalleFactura con el nro de factura seleccionado
            VerDetalleFactura vdf = new VerDetalleFactura(numeroFactura);
            vdf.setVisible(true);
            vdf.setLocationRelativeTo(null);
            this.dispose();
            
        
        }

    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        
        //Confirmamos que todos los campos estén llenos
        if(jdtDesde.getDate() != null && jdtHasta.getDate() != null){
            //Tomamos el valor de las fechas y horas
            Date fechaDesdeJdt = jdtDesde.getDate();
            int horaDesde = Integer.valueOf(String.valueOf(cmbDesde.getSelectedItem()));
            Date fechaHastaJdt = jdtHasta.getDate();
            int horaHasta = Integer.valueOf(String.valueOf(cmbHasta.getSelectedItem()));

            // Convertir Date a LocalDateTime
            Instant instant = fechaDesdeJdt.toInstant();
            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDateTime fechaDesde = instant.atZone(defaultZoneId).toLocalDateTime().plusHours(horaDesde);

            Instant instant2 = fechaHastaJdt.toInstant();
            ZoneId defaultZoneId2 = ZoneId.systemDefault();
            LocalDateTime fechaHasta = instant2.atZone(defaultZoneId2).toLocalDateTime().plusHours(horaHasta);

            //Cargamos la tabla con el filtro
            cargarTablaFiltro(fechaDesde, fechaHasta);
        }
        else{
            JOptionPane.showConfirmDialog(null, "Debe completar los campos de las fechas para poder filtrar",
                    "Error", JOptionPane.CLOSED_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
        
        JOptionPane.showConfirmDialog(null, "El total de las facturas en pantalla es $" + total,
   "Total", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void btnLimpiarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltrosActionPerformed

        cargarTabla();

    }//GEN-LAST:event_btnLimpiarFiltrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnLimpiarFiltros;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbDesde;
    private javax.swing.JComboBox<String> cmbHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtDesde;
    private com.toedter.calendar.JDateChooser jdtHasta;
    private javax.swing.JTable tblFactura;
    // End of variables declaration//GEN-END:variables


    public void cargarTabla(){
        
        //Seteamos el total en 0
        total = 0;
        
        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Número de Factura","Número de mesa", "Total", "Forma de pago", "Fecha", "Estado"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList <Factura> lista = control.traerFacturas();
                
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(Factura fa : lista){
                
                if("Finalizada".equals(fa.getEstado_Fa())){
                    
                    Object[] objeto = {fa.getId_Fa(), fa.getMesa_Fa().getNumeroMesa_Me(), fa.getTotal_Fa(),
                    fa.getFormaDePago_Fa().getFormaDePago_FP(), obtenerFechaFormateada(fa.getFecha_Fa()), fa.getEstado_Fa()};

                    tab.addRow(objeto);
                    
                    //Vamos sumando el total de todas las facturas en la variable global "total"
                    total += fa.getTotal_Fa();
                    
                }
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblFactura.setModel(tab);
        
    }
    
    public void cargarTablaFiltro(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
        
        //Seteamos el total en 0
        total = 0;
        
        //Definimos el modelo de tabla que queremos cargar
        DefaultTableModel tab = new DefaultTableModel(){
            //Indicamos que las celdas no se pueden modificar
            public boolean isCellEditable(int row, int column){
                return false;
            }    
        };
        
        //Establecemos el nombre de las columnas
        String nombreColumnas[] = {"Número de Factura","Número de mesa", "Total", "Forma de pago", "Fecha", "Estado"};
        tab.setColumnIdentifiers(nombreColumnas);
        
        //Cargamos los datos de la base de datos en un arrayList
        ArrayList <Factura> lista = control.filtroFechaFacturas(fechaDesde, fechaHasta);

                
        //Comprobamos que haya datos cargados
        if(lista!=null){
            
            //Recorremos la lista y lo plasmamos en la tabla
            for(Factura fa : lista){
                
                if("Finalizada".equals(fa.getEstado_Fa())){
                    
                    Object[] objeto = {fa.getId_Fa(), fa.getMesa_Fa().getNumeroMesa_Me(), fa.getTotal_Fa(),
                    fa.getFormaDePago_Fa().getFormaDePago_FP(), obtenerFechaFormateada(fa.getFecha_Fa()), fa.getEstado_Fa()};

                    tab.addRow(objeto);
                    
                    //Vamos sumando el total de todas las facturas en la variable global "total"
                    total += fa.getTotal_Fa();
                    
                }
            }
        }
        
        //Vinculamos la tabla que creamos con la que estamos mostrando en pantalla
        tblFactura.setModel(tab);
        
    }
    
    
    public String obtenerFechaFormateada(LocalDateTime fec){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return fec.format(formato);
    }


}
