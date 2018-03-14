/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.menu;

import com.modelo.Usuarios;
import com.vista.Index;
import java.awt.Color;

/**
 *
 * @author Juan Camilo
 */
public class MenuTools extends javax.swing.JPanel {
    Index vista;
    Usuarios usuario;
    /**
     * Creates new form MenuTools
     */
    public MenuTools(Index view,Usuarios user) {
        initComponents();
        vista = view;
        usuario = user;
        nombreUsuario.setText(usuario.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accesoR4 = new javax.swing.JLabel();
        nameLBL4 = new javax.swing.JLabel();
        accesoR2 = new javax.swing.JLabel();
        accesoR3 = new javax.swing.JLabel();
        nameLBL8 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        accesoR1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(53, 92, 125));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accesoR4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        accesoR4.setForeground(new java.awt.Color(255, 255, 255));
        accesoR4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/carteraA.png"))); // NOI18N
        accesoR4.setText("Consultar cartera");
        accesoR4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accesoR4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accesoR4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accesoR4MouseExited(evt);
            }
        });
        add(accesoR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 230, 30));

        nameLBL4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        nameLBL4.setForeground(new java.awt.Color(255, 255, 255));
        nameLBL4.setText("Opciones rápidas");
        add(nameLBL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        accesoR2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        accesoR2.setForeground(new java.awt.Color(255, 255, 255));
        accesoR2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/calendarioc.png"))); // NOI18N
        accesoR2.setText("Consultar cita");
        accesoR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accesoR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accesoR2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accesoR2MouseExited(evt);
            }
        });
        add(accesoR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 230, 30));

        accesoR3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        accesoR3.setForeground(new java.awt.Color(255, 255, 255));
        accesoR3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/carteraA.png"))); // NOI18N
        accesoR3.setText("Añadir cartera");
        accesoR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accesoR3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accesoR3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accesoR3MouseExited(evt);
            }
        });
        add(accesoR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 230, 30));

        nameLBL8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        nameLBL8.setForeground(new java.awt.Color(255, 255, 255));
        nameLBL8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/menu.png"))); // NOI18N
        nameLBL8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(nameLBL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        nombreUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/usuario.png"))); // NOI18N
        nombreUsuario.setText("User");
        nombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 150, 30));

        jTextArea1.setBackground(new java.awt.Color(53, 92, 125));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 250, 120));

        accesoR1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        accesoR1.setForeground(new java.awt.Color(255, 255, 255));
        accesoR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/calendarioA.png"))); // NOI18N
        accesoR1.setText("Crear nueva cita");
        accesoR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accesoR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambio_paso(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                retorna_paso(evt);
            }
        });
        add(accesoR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void cambio_paso(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambio_paso
        // TODO add your handling code here:
        Color n = new Color(95,204,156);
        accesoR1.setForeground(n);
    }//GEN-LAST:event_cambio_paso

    private void retorna_paso(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retorna_paso
        // TODO add your handling code here:
        Color n = new Color(240,240,240);
        accesoR1.setForeground(n);
    }//GEN-LAST:event_retorna_paso

    private void accesoR2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR2MouseExited
        // TODO add your handling code here:
        Color n = new Color(240,240,240);
        accesoR2.setForeground(n);
    }//GEN-LAST:event_accesoR2MouseExited

    private void accesoR3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR3MouseEntered
        // TODO add your handling code here:
        Color n = new Color(95,204,156);
        accesoR3.setForeground(n);
    }//GEN-LAST:event_accesoR3MouseEntered

    private void accesoR3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR3MouseExited
        // TODO add your handling code here:
        Color n = new Color(240,240,240);
        accesoR3.setForeground(n);
    }//GEN-LAST:event_accesoR3MouseExited

    private void accesoR4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR4MouseEntered
        // TODO add your handling code here:
        Color n = new Color(95,204,156);
        accesoR4.setForeground(n);
    }//GEN-LAST:event_accesoR4MouseEntered

    private void accesoR4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR4MouseExited
        // TODO add your handling code here:
        Color n = new Color(240,240,240);
        accesoR4.setForeground(n);
    }//GEN-LAST:event_accesoR4MouseExited

    private void accesoR2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR2MouseEntered
        // TODO add your handling code here:
        Color n = new Color(95,204,156);
        accesoR2.setForeground(n);
    }//GEN-LAST:event_accesoR2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accesoR1;
    private javax.swing.JLabel accesoR2;
    private javax.swing.JLabel accesoR3;
    private javax.swing.JLabel accesoR4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLBL4;
    private javax.swing.JLabel nameLBL8;
    private javax.swing.JLabel nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
