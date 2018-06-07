/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.Drive;


import com.controlador.hiloEspera;
import com.vista.Index;

/**
 *
 * @author Juan Camilo
 */
public class autenticacion extends javax.swing.JFrame {
    com.vista.Index vista;
    /**
     * Creates new form NewJFrame
     */
    
    public autenticacion(){
       initComponents(); 
    }
    
    
    public autenticacion(Index view) {
        initComponents();
        vista = view;
        this.setLocationRelativeTo(null);
        
    }
    
    public void BuscarPag(String url){
        texturl.setText(url);
    }
    
    public String retornaCod(){
        String men = "";
        if(textCodigo.getText().contains("ingrese") || textCodigo.getText().equals("")){
            
        }else{
            men = textCodigo.getText();
        }
        return men;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameLBL3 = new javax.swing.JLabel();
        nameLBL4 = new javax.swing.JLabel();
        nameLBL5 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        nameLBL6 = new javax.swing.JLabel();
        nameLBL7 = new javax.swing.JLabel();
        nameLBL8 = new javax.swing.JLabel();
        nameLBL9 = new javax.swing.JLabel();
        texturl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setBounds(new java.awt.Rectangle(0, 0, 280, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/google-plus.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, 90));

        nameLBL3.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL3.setText("1. Por favor copia el siguiente link:");
        jPanel1.add(nameLBL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 280, 30));

        nameLBL4.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL4.setText("Hola, necesitamos tu permiso para");
        jPanel1.add(nameLBL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 40));

        nameLBL5.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL5.setText("   abajo");
        jPanel1.add(nameLBL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 280, 30));

        textCodigo.setBackground(new java.awt.Color(254, 244, 232));
        textCodigo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCodigo.setText("Ingrese su codigo aquí");
        textCodigo.setToolTipText("");
        textCodigo.setBorder(null);
        textCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textCodigo.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        textCodigo.setSelectionColor(new java.awt.Color(81, 173, 207));
        textCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textCodigoSeleccion(evt);
            }
        });
        jPanel1.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 270, 30));

        nameLBL6.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL6.setText("poder acceder a tu drive.");
        jPanel1.add(nameLBL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 30));

        nameLBL7.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL7.setText("2. pegalo en tu navegador");
        jPanel1.add(nameLBL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 280, 30));

        nameLBL8.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL8.setText("3. Presiona en \"allow\".");
        jPanel1.add(nameLBL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 280, 30));

        nameLBL9.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        nameLBL9.setText("4. Copia el codigo y pegalo aquí");
        jPanel1.add(nameLBL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 280, 30));

        texturl.setBackground(new java.awt.Color(254, 244, 232));
        texturl.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        texturl.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        texturl.setText("Ingrese su nombre de usuario...");
        texturl.setToolTipText("");
        texturl.setBorder(null);
        texturl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        texturl.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        texturl.setSelectionColor(new java.awt.Color(81, 173, 207));
        texturl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                texturlSeleccion(evt);
            }
        });
        jPanel1.add(texturl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 210, 30));

        jButton1.setBackground(new java.awt.Color(4, 222, 173));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/comprobado.png"))); // NOI18N
        jButton1.setText("Listo");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCodigoSeleccion(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCodigoSeleccion
        // TODO add your handling code here:
        textCodigo.selectAll();
    }//GEN-LAST:event_textCodigoSeleccion

    private void texturlSeleccion(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texturlSeleccion
        // TODO add your handling code here:
        texturl.selectAll();
    }//GEN-LAST:event_texturlSeleccion

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        vista.llamaDrive(textCodigo.getText());
        com.controlador.hiloEspera espera = new hiloEspera(vista);
        espera.start();
        this.dispose();
        espera.stop();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new autenticacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLBL3;
    private javax.swing.JLabel nameLBL4;
    private javax.swing.JLabel nameLBL5;
    private javax.swing.JLabel nameLBL6;
    private javax.swing.JLabel nameLBL7;
    private javax.swing.JLabel nameLBL8;
    private javax.swing.JLabel nameLBL9;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField texturl;
    // End of variables declaration//GEN-END:variables
}
