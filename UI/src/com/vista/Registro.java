/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.controlador.Control_fuentes;
import com.controlador.LogicaUsuario;
import com.controlador.encriptador;
import com.modelo.Usuarios;
import com.vista.opciones.RespuestaModal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Camilo
 */
public class Registro extends javax.swing.JPanel {
    Index vista;
    /**
     * Creates new form Registro
     * @param view
     */
    public Registro(Index view) {
        vista = view;
        initComponents();
        Control_fuentes df = new Control_fuentes("des");
        jLabel1.setFont(df.MyFont(1, 24f));
        nameLBL5.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JTextField();
        nameLBL4 = new javax.swing.JLabel();
        nameLBL5 = new javax.swing.JLabel();
        lblP1 = new javax.swing.JPasswordField();
        lblP2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameLBL7 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JTextField();
        nameLBL8 = new javax.swing.JLabel();
        nameLBL9 = new javax.swing.JLabel();
        nameLBL10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setMinimumSize(new java.awt.Dimension(480, 410));
        setPreferredSize(new java.awt.Dimension(480, 428));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(151, 7, 71));
        jLabel1.setText("Registro_");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        lblNombre.setBackground(new java.awt.Color(204, 204, 204));
        lblNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblNombre.setText("Ingrese su nombre...");
        lblNombre.setToolTipText("");
        lblNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        lblNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNombre.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        lblNombre.setSelectionColor(new java.awt.Color(81, 173, 207));
        lblNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblNombreSeleccion(evt);
            }
        });
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 270, 30));

        lblCorreo.setBackground(new java.awt.Color(204, 204, 204));
        lblCorreo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        lblCorreo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblCorreo.setText("Ingrese su correo electronico...");
        lblCorreo.setToolTipText("");
        lblCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        lblCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCorreo.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        lblCorreo.setSelectionColor(new java.awt.Color(81, 173, 207));
        lblCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblCorreoSeleccion(evt);
            }
        });
        add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 270, 30));

        nameLBL4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        nameLBL4.setText("Nombre del usuario:");
        add(nameLBL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        nameLBL5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        nameLBL5.setForeground(new java.awt.Color(255, 102, 102));
        nameLBL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLBL5.setText("Registro exitoso");
        add(nameLBL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 190, 70));

        lblP1.setBackground(new java.awt.Color(204, 204, 204));
        lblP1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        lblP1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblP1.setText("jPasswordField1");
        lblP1.setBorder(null);
        lblP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblP1.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        lblP1.setSelectionColor(new java.awt.Color(81, 173, 207));
        lblP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblP1seleccionP(evt);
            }
        });
        add(lblP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 270, 30));

        lblP2.setBackground(new java.awt.Color(204, 204, 204));
        lblP2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        lblP2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblP2.setText("jPasswordField1");
        lblP2.setBorder(null);
        lblP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblP2.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        lblP2.setSelectionColor(new java.awt.Color(81, 173, 207));
        lblP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblP2seleccionP(evt);
            }
        });
        add(lblP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 270, 30));

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
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 110, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/cohete.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 150, 240));

        nameLBL7.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        nameLBL7.setText("Repita la Contraseña");
        add(nameLBL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        lblEdad.setBackground(new java.awt.Color(204, 204, 204));
        lblEdad.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        lblEdad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblEdad.setText("Ingrese su edad...");
        lblEdad.setToolTipText("");
        lblEdad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));
        lblEdad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEdad.setSelectedTextColor(new java.awt.Color(0, 51, 255));
        lblEdad.setSelectionColor(new java.awt.Color(81, 173, 207));
        lblEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblEdadSeleccion(evt);
            }
        });
        add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 270, 30));

        nameLBL8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        nameLBL8.setText("Email");
        add(nameLBL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        nameLBL9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        nameLBL9.setText("Edad");
        add(nameLBL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        nameLBL10.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        nameLBL10.setText("Contraseña");
        add(nameLBL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lblNombreSeleccion(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblNombreSeleccion
        // TODO add your handling code here:
        lblNombre.selectAll();
    }//GEN-LAST:event_lblNombreSeleccion

    private void lblCorreoSeleccion(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblCorreoSeleccion
        // TODO add your handling code here:
        lblCorreo.selectAll();
    }//GEN-LAST:event_lblCorreoSeleccion

    private void lblP1seleccionP(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblP1seleccionP
        // TODO add your handling code here:
        lblP1.selectAll();
    }//GEN-LAST:event_lblP1seleccionP

    private void lblP2seleccionP(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblP2seleccionP
        // TODO add your handling code here:
        lblP2.selectAll();
    }//GEN-LAST:event_lblP2seleccionP

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        com.modelo.Usuarios user = new Usuarios();
        com.controlador.encriptador md5 = new encriptador();
        RespuestaModal response = new RespuestaModal(vista, true);
        try{  
            if(lblCorreo.getText().contains("@") && lblCorreo.getText().contains(".") && !(lblCorreo.getText().equals("agendame@gmail.com"))){
                user.setCorreo(lblCorreo.getText());
                
                if(!lblNombre.getText().equals("Ingrese su nombre...")){
                user.setNombre(lblNombre.getText());
                /** Controlador de interfaz según la edad del usuario
                 * 0 - para personas del grupo de menores a 63 años
                 * 1 - para personas del grupo de mayores o iguales a 63 años
                 */

                if(Integer.parseInt(lblEdad.getText()) >= 63)
                {
                    user.setTipo(Boolean.TRUE);
                }else{
                    user.setTipo(Boolean.FALSE);
                }


                if (lblP1.getText().equals(lblP2.getText()) && lblP1.getText().length() >= 5) {

                    user.setContraseña(md5.getMD5(lblP1.getText()));
                    com.controlador.LogicaUsuario userDao = new LogicaUsuario();
                    com.modelo.Usuarios busqueda = new Usuarios();
                    busqueda.setNombre("");
                    busqueda = userDao.BuscarUsuario(lblCorreo.getText());
                    if(busqueda == null){
                        try {
                            userDao.registrarUsuario(user);
                            nameLBL5.setVisible(true);
                            String texto = "<html><body>Se ha registrado<br>exitosamente.<br></body></html>";
                            response.cargaDatos("¡Exito!", texto, "exito");
                            response.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                      String texto = "<html><body>Ya existe un usuario<br>con ese correo registrado.</body></html>";
                      response.cargaDatos("¡Upps!", texto, "error");
                      response.setVisible(true);  
                    }
                }else{
                    String texto = "<html><body>Las contraseñas no son<br>iguales o la contraseña<br>no supera 5 caracteres.</body></html>";
                    response.cargaDatos("¡Upps!", texto, "error");
                    response.setVisible(true);
                }
            }else{
                String texto = "<html><body>Debe ingresar un nombre<br>valido.</body></html>";
                response.cargaDatos("¡Upps!", texto, "error");
                response.setVisible(true);
            }
          }else{
            String texto = "<html><body>Debe ingresar un correo<br>valido, Ejemplo:<br>agendame@gmail.com.</body></html>";
            response.cargaDatos("¡Upps!", texto, "error");
            response.setVisible(true);
          }
        }
        catch(NumberFormatException nfe)  
        {  
            String texto = "<html><body>Debe ingresar una<br>edad valida.</body></html>";
            response.cargaDatos("¡Upps!", texto, "error");
            response.setVisible(true);  
        } 
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblEdadSeleccion(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblEdadSeleccion
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEdadSeleccion


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lblCorreo;
    private javax.swing.JTextField lblEdad;
    private javax.swing.JTextField lblNombre;
    private javax.swing.JPasswordField lblP1;
    private javax.swing.JPasswordField lblP2;
    private javax.swing.JLabel nameLBL10;
    private javax.swing.JLabel nameLBL4;
    private javax.swing.JLabel nameLBL5;
    private javax.swing.JLabel nameLBL7;
    private javax.swing.JLabel nameLBL8;
    private javax.swing.JLabel nameLBL9;
    // End of variables declaration//GEN-END:variables
}
