/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.menu;

import com.controlador.busqueda;
import com.modelo.Usuarios;
import com.vista.Drive.DriveFiles;
import com.vista.Drive.DriveTools;
import com.vista.Drive.autenticacion;
import com.vista.Index;
import com.vista.agenda.agendarCalendar;
import com.vista.agenda.agendarTools;
import javax.swing.JButton;

/**
 *
 * @author Juan Camilo
 */
public class MenuItems extends javax.swing.JPanel {
    Index vista;
    Usuarios userAccedido;
    com.controlador.busqueda Oauth = new busqueda();
    com.vista.Drive.DriveFiles files;
    com.vista.Drive.DriveTools Dtools;
    
    com.vista.agenda.agendarCalendar calendar;
    com.vista.agenda.agendarTools Atools;
    /**
     * Creates new form MenuItems
     */
    public MenuItems(Index view,Usuarios user) {
        initComponents();
        this.setName("MenuItems");
        vista = view;
        userAccedido = user;
    }
    
    public JButton[] getBotonesM(){
        JButton[] b = {jButton1,jButton2,jButton3};
        return b;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(4, 222, 173));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/ajustes.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 120, 100));

        jButton2.setBackground(new java.awt.Color(4, 222, 173));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/conducir.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 120, 100));

        jButton3.setBackground(new java.awt.Color(4, 222, 173));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/calendario.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        vista.set_panel_menu(false);
        
        vista.set_posicion("menu");
        
        vista.instancia_drive_aut(Oauth);
        
        Dtools = new DriveTools(vista);
        vista.instancia_drive_tools(Dtools);
        vista.getContentPane().add(Dtools, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 290, 474));
        
        
        files = new DriveFiles(vista);
        vista.instancia_drive_files(files);
        vista.getContentPane().add(files, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 556, 474));
        
        //falta validacion
        String Url = Oauth.urlPermiso();
        com.vista.Drive.autenticacion au = new autenticacion(vista);
        au.BuscarPag(Url);
        au.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        vista.set_panel_menu(false);
        vista.set_posicion("organizador");
        
        Atools = new agendarTools(vista,userAccedido);
        vista.instancia_agenda_tools(Atools);
        vista.getContentPane().add(Atools, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 290, 474));
        
        
        calendar = new agendarCalendar(vista,userAccedido);
        vista.instancia_agenda_calendar(calendar);
        vista.getContentPane().add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 556, 474));
    }//GEN-LAST:event_jButton3ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
