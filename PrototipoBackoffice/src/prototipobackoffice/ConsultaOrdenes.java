/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvaro.montero
 */
public class ConsultaOrdenes extends javax.swing.JFrame {

    Orden ordenSeleccionada;

    /**
     * Creates new form ConsultaOrdenes
     */
    public ConsultaOrdenes() {
        initComponents();
        
    }

    public void llenarLista(String nombreBusqueda) {
        //Falta añadir el ListarTodos en el DAO
        //Falta añadir el atributo TRN y sus getter y setter  en la clase Orden.
        BackofficeDao dao = new BackofficeDao();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new Object[]{"Tipo de Orden", "Ref. Orden", "Contrapartida", "Sentido", "Importe", "Divisa", "Fecha entrada", "Fecha valor", "Fecha liquidacion", "Estado", "TRN", "Corresponsal propio", "Cuenta corresponsal propio"});
        List<Orden> ordenes = dao.listarTodos(nombreBusqueda);

        TablaConsultaOrden.setModel(dtm);

        for (Orden m : ordenes) {
            Object[] o = new Object[4];
            o[0] = m.getTipo_Orden();
            o[1] = m.getRef_Orden();
            o[2] = m.getContrapartida();
            o[3] = m.getSentido();
            o[4] = m.getImporte();
            o[5] = m.getDivisa();
            o[6] = m.getFecha_Entrada();
            o[7] = m.getFecha_Valor();
            o[8] = m.getFecha_Liquidacion();
            o[9] = m.getEstado();
            o[10] = m.getTrn_orden();
            o[11] = m.getCorresponsal_Propio();
            o[12] = m.getCuenta_Corresponsal_Propio();

            dtm.addRow(o);
        }
        dao.closeConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultaOrden = new javax.swing.JTable();
        btnNuevaOrden = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        btnLiquidarManual = new javax.swing.JButton();
        btnConsultarMensajes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtBICEntidad = new javax.swing.JTextField();
        txtImporteDesde = new javax.swing.JTextField();
        txtRefOrden = new javax.swing.JTextField();
        txtImporteHasta = new javax.swing.JTextField();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo4 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo5 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo6 = new datechooser.beans.DateChooserCombo();
        jLabel16 = new javax.swing.JLabel();
        btnBusqueda = new javax.swing.JButton();
        comboEstado = new javax.swing.JComboBox<>();
        comboSentido = new javax.swing.JComboBox<>();
        btnRecibirMensajes = new javax.swing.JButton();
        comboDivisa = new javax.swing.JComboBox<>();
        comboCorresponsalPropio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaConsultaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Orden", "Ref. Orden", "Contrapartida", "Sentido", "Importe", "Divisa", "Fecha entrada", "Fecha valor", "Fecha liquidacion", "Estado", "TRN", "Corresponsal propio", "Cuenta corresponsal propio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaConsultaOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaConsultaOrdenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaConsultaOrden);
        if (TablaConsultaOrden.getColumnModel().getColumnCount() > 0) {
            TablaConsultaOrden.getColumnModel().getColumn(5).setResizable(false);
        }

        btnNuevaOrden.setText("NUEVA ORDEN");
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrdenActionPerformed(evt);
            }
        });

        btnLiberar.setText("LIBERAR");
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });

        btnLiquidarManual.setText("LIQUIDAR MANUAL");

        btnConsultarMensajes.setText("CONSULTAR MENSAJES");
        btnConsultarMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarMensajesActionPerformed(evt);
            }
        });

        jLabel1.setText("PANTALLA DE CONSULTA DE ÓRDENES");

        jLabel2.setText("BIC Entidad:");

        jLabel3.setText("Sentido:");

        jLabel4.setText("Importe desde:");

        jLabel5.setText("F. Liberación desde:");

        jLabel6.setText("F. Valor desde:");

        jLabel7.setText("F. Liquidacion desde:");

        jLabel8.setText("Estado de la orden:");

        jLabel9.setText("Ref. orden:");

        jLabel10.setText("Divisa:");

        jLabel11.setText("Importe hasta:");

        jLabel12.setText("F. Liberación hasta:");

        jLabel13.setText("F. Valor hasta:");

        jLabel14.setText("F. Liquidacion hasta:");

        jLabel15.setText("Corresponsal Propio:");

        txtBICEntidad.setText("BSCHESMMXXX");
        txtBICEntidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBICEntidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBICEntidadKeyReleased(evt);
            }
        });

        jLabel16.setText("TODOS LOS CAMPOS SON OBLIGATORIOS.");

        btnBusqueda.setText("LANZAR BUSQUEDA");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no liberada", "liberada", "ack", "incidencia", "liquidada" }));

        comboSentido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cobro", "Pago" }));

        btnRecibirMensajes.setText("RECIBIR MENSAJES");
        btnRecibirMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirMensajesActionPerformed(evt);
            }
        });

        comboDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EUR", "USD", "CAD" }));

        comboCorresponsalPropio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BMSXMXMMXXX", "ZYAYESM0XXX", "CITIITMXXXX" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(104, 104, 104)
                                    .addComponent(txtBICEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(86, 86, 86)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtImporteDesde)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addComponent(comboSentido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtRefOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtImporteHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(192, 192, 192)
                                .addComponent(btnBusqueda))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboCorresponsalPropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141)
                                .addComponent(jLabel16))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btnNuevaOrden)
                        .addGap(193, 193, 193)
                        .addComponent(btnLiberar)
                        .addGap(154, 154, 154)
                        .addComponent(btnLiquidarManual)
                        .addGap(89, 89, 89)
                        .addComponent(btnRecibirMensajes)))
                .addGap(75, 75, 75)
                .addComponent(btnConsultarMensajes)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBICEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(comboSentido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImporteDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel14))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboCorresponsalPropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtImporteHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBusqueda)
                                    .addGap(64, 64, 64))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtRefOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(202, 202, 202))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaOrden)
                    .addComponent(btnLiberar)
                    .addComponent(btnLiquidarManual)
                    .addComponent(btnConsultarMensajes)
                    .addComponent(btnRecibirMensajes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrdenActionPerformed
        // TODO add your handling code here:
        AltaOrdenes p1 = new AltaOrdenes();
        p1.setLocationRelativeTo(this);
        p1.setVisible(true);
    }//GEN-LAST:event_btnNuevaOrdenActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        // TODO add your handling code here:
        BackofficeDao dao = new BackofficeDao();
        dao.LiberarOrden(ordenSeleccionada);
    }//GEN-LAST:event_btnLiberarActionPerformed

    
    
    
    
    
    
    
    
    
    private void TablaConsultaOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaConsultaOrdenMouseClicked
        // Cuando seleccionamos una fila de la tabla, cogemos su ref_Orden, y con el metodo getOrden tenemos la orden completa
        //liberarla o lo que corresponda
        int row = TablaConsultaOrden.getSelectedRow();
        String Ref_Orden = TablaConsultaOrden.getModel().getValueAt(row, 1).toString();
        BackofficeDao dao = new BackofficeDao();
        //Falta añadir este getOrden en el DAO
        ordenSeleccionada = dao.getOrden(Ref_Orden);

    }//GEN-LAST:event_TablaConsultaOrdenMouseClicked

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        //si clicko en este boton se lanzara la busqueda correspondiente
        //String nombreBusqueda = txtBusqueda.getText();
        //Llamando al metodo del dao que corresponda.
        //dao.busqueda(nombreBusqueda);
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnConsultarMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarMensajesActionPerformed
        ConsultaComunicaciones p2 = new ConsultaComunicaciones();
        p2.setLocationRelativeTo(this);
        p2.setVisible(true);
    }//GEN-LAST:event_btnConsultarMensajesActionPerformed

    private void txtBICEntidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBICEntidadKeyPressed
        // TODO add your handling code here:
        if (txtBICEntidad.getText().length() >= 11) {
            txtBICEntidad.setText(txtBICEntidad.getText().substring(0, 11));
        }
    }//GEN-LAST:event_txtBICEntidadKeyPressed

    private void txtBICEntidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBICEntidadKeyReleased
        // TODO add your handling code here:
        if (txtBICEntidad.getText().length() >= 11) {
            txtBICEntidad.setText(txtBICEntidad.getText().substring(0, 11));
        }
    }//GEN-LAST:event_txtBICEntidadKeyReleased

    private void btnRecibirMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirMensajesActionPerformed
        // TODO add your handling code here:
        RecepcionMensajes p2 = new RecepcionMensajes(ordenSeleccionada);
        p2.setLocationRelativeTo(this);
        p2.setVisible(true);
        p2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    llenarLista("");
                }
            });
    }//GEN-LAST:event_btnRecibirMensajesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaOrdenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConsultaOrden;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnConsultarMensajes;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnLiquidarManual;
    private javax.swing.JButton btnNuevaOrden;
    private javax.swing.JButton btnRecibirMensajes;
    private javax.swing.JComboBox<String> comboCorresponsalPropio;
    private javax.swing.JComboBox<String> comboDivisa;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboSentido;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private datechooser.beans.DateChooserCombo dateChooserCombo3;
    private datechooser.beans.DateChooserCombo dateChooserCombo4;
    private datechooser.beans.DateChooserCombo dateChooserCombo5;
    private datechooser.beans.DateChooserCombo dateChooserCombo6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBICEntidad;
    private javax.swing.JTextField txtImporteDesde;
    private javax.swing.JTextField txtImporteHasta;
    private javax.swing.JTextField txtRefOrden;
    // End of variables declaration//GEN-END:variables
}
