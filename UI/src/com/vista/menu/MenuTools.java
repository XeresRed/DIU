/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.menu;

import com.controlador.LogicaOrganizador;
import com.modelo.Organizador;
import com.modelo.Usuarios;
import com.vista.Index;
import com.vista.agenda.ListadoCitas;
import com.vista.agenda.crearEntrada.CrearEntrada;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
        this.setName("MenuHerramientas");
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

        nameLBL4 = new javax.swing.JLabel();
        accesoR2 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        accesoR1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(53, 92, 125));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accesoR2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accesoR2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accesoR2MouseExited(evt);
            }
        });
        add(accesoR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 230, 30));

        nombreUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/usuario.png"))); // NOI18N
        nombreUsuario.setText("User");
        nombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 30));

        accesoR1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        accesoR1.setForeground(new java.awt.Color(255, 255, 255));
        accesoR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metaforas/calendarioA.png"))); // NOI18N
        accesoR1.setText("Crear nueva cita");
        accesoR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accesoR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accesoR1MouseClicked(evt);
            }
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

    private void accesoR2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR2MouseEntered
        // TODO add your handling code here:
        Color n = new Color(95,204,156);
        accesoR2.setForeground(n);
    }//GEN-LAST:event_accesoR2MouseEntered

    private void accesoR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR1MouseClicked
        // TODO add your handling code here:
        com.vista.agenda.crearEntrada.CrearEntrada s = new CrearEntrada(vista,usuario);
        s.setActivador(false);
        s.setVisible(true);
    }//GEN-LAST:event_accesoR1MouseClicked

    private void accesoR2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesoR2MouseClicked
        LogicaOrganizador logDao = new LogicaOrganizador();
        List<Organizador> fest = logDao.consultarCitas();
        ArrayList<Organizador> citasFiltradas = new ArrayList<>();
        
        for (int i = 0; i < fest.size(); i++) {
            if(fest.get(i).getUsuariosCorreo().getCorreo().equals(usuario.getCorreo())){
                citasFiltradas.add(fest.get(i));
            }
        }
        ListadoCitas ListadoCita = new ListadoCitas(vista, usuario, citasFiltradas,true);
        ListadoCita.setVisible(true);
    }//GEN-LAST:event_accesoR2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accesoR1;
    private javax.swing.JLabel accesoR2;
    private javax.swing.JLabel nameLBL4;
    private javax.swing.JLabel nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
