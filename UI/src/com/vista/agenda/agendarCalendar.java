/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.agenda;

import com.controlador.LogicaOrganizador;
import com.controlador.controlPanelesDias;
import com.google.api.services.drive.model.File;
import com.modelo.Organizador;
import com.modelo.Usuarios;
import com.vista.Index;
import com.vista.agenda.panelesDias.panelDias;
import com.vista.opciones.RespuestaModal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Juan Camilo
 */
public class agendarCalendar extends javax.swing.JPanel {
    Color diaActual = new Color(255,95,95);
    Usuarios userAccedido;
    int numeroDiasMes = 0;
    int year = 0;
    controlPanelesDias com;
    LogicaOrganizador logicaDAO = new LogicaOrganizador();
    Index vista;
    String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    public List<com.vista.agenda.panelesDias.panelDias> listaPanelesDias = new ArrayList<panelDias>();
    Calendar fecha;
    /**
     * Creates new form agendarCalendar
     * @param view
     */
    public agendarCalendar(Index view, Usuarios user) {
        initComponents();
        this.setName("AgendaCalendario");
        vista = view;
        userAccedido = user;
        fecha = Calendar.getInstance();
        year = fecha.get(Calendar.YEAR);
        pintaLabelSemana(strDays[fecha.get(Calendar.DAY_OF_WEEK) - 1]);
        calcularDiasMes(fecha.get(Calendar.MONTH) + 1);
        com = new controlPanelesDias(this);
        int y = 25;
        int x = 0;
        int heig = 75;
        int contador = 0;
        int wid = 73;
        for (int i = 0; i < numeroDiasMes; i++) {
            if(contador == 7){
                y += heig;  
                contador = 0;
                x = 0;
            }
            String numDia = (i + 1) + "";
            com.vista.agenda.panelesDias.panelDias dia = new panelDias(numDia);
   
            listaPanelesDias.add(dia);
            dia.setName("panel dia: " + numDia);
            dia.setVisible(true);
            dia.addMouseListener(com);
            panelCalendario.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, wid, heig));
            x += wid;
            contador++;

        }
        
        Actualizar();
    }
    
    public Index obtenerInd(){
        return vista;
    }
    
    public Usuarios user(){
        return userAccedido;
    }
    
    public List<Organizador> llama_archivos_seleccionados_organizador(){
        return com.DevolverSeleccion();
    }
    
    public void vistaPrevia(String titulo, String Des){
        com.vista.opciones.RespuestaModal r = new RespuestaModal(vista, true);
        String texto = "<html><body>No existe un usuario con<br>ese correo electronico.<br></body></html>";
        r.cargaDatos(titulo, Des, "exito");
        r.setVisible(true);
    }
    
    public void Actualizar(){
        List<Organizador> listaOrg = logicaDAO.consultarCitas();
        
        for (int i = 0; i < listaOrg.size(); i++) {
            Calendar tiempoLis = toCalendar(listaOrg.get(i).getFecha());
            if((tiempoLis.get(Calendar.MONTH) + 1) == (fecha.get(Calendar.MONTH) + 1) && listaOrg.get(i).getUsuariosCorreo().getCorreo().equals(userAccedido.getCorreo())){
                switch(listaOrg.get(i).getTag()){
                    case "Urgente":
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setBackground(new Color(244,67,54));
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setCitaId(listaOrg.get(i).getIdorganizador());
                        //panelCalendario.getComponent(tiempoLis.get(Calendar.DAY_OF_MONTH)+6).setBackground(new Color(220,47,47));
                        break;
                    case "Importante":
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setBackground(new Color(30,136,229));
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setCitaId(listaOrg.get(i).getIdorganizador());
                        //panelCalendario.getComponent(tiempoLis.get(Calendar.DAY_OF_MONTH)+6).setBackground(new Color(255,137,93));
                        break;
                    case "Normal":
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setBackground(new Color(255,213,79));
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setCitaId(listaOrg.get(i).getIdorganizador());
                        //panelCalendario.getComponent(tiempoLis.get(Calendar.DAY_OF_MONTH)+6).setBackground(new Color(254,193,0));
                        break;
                    case "Baja":
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setBackground(new Color(198,255,0));
                        listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setCitaId(listaOrg.get(i).getIdorganizador());
                        //panelCalendario.getComponent(tiempoLis.get(Calendar.DAY_OF_MONTH)+6).setBackground(new Color(72,186,149));
                        break;
                }
            }
        }
        
    }
    
    public void desActualizar(){
        List<Organizador> listaOrg = logicaDAO.consultarCitas();
        
        for (int i = 0; i < listaOrg.size(); i++) {
            Calendar tiempoLis = toCalendar(listaOrg.get(i).getFecha());
            if((tiempoLis.get(Calendar.MONTH) + 1) == (fecha.get(Calendar.MONTH) + 1) && listaOrg.get(i).getUsuariosCorreo().getCorreo().equals(userAccedido.getCorreo())){
                listaPanelesDias.get(tiempoLis.get(Calendar.DAY_OF_MONTH)-1).setBackground(new Color(255,255,255));
            }
        }
        
    }
    
    public  Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
      }
    
    public void ActivarOpcionesDias(boolean accion){
        vista.activarOpcionesAgenda(accion);
    }
    
    public void calcularDiasMes(int mes){
            switch (mes) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                  numeroDiasMes = 31;
                  break;
                case 4: case 6: case 9: case 11:
                  numeroDiasMes = 30;
                  break;
                case 2:			
                    if((year%4==0 && year%100!=0) || year%400==0){
                        numeroDiasMes = 29;
                    }
                    else{
                        numeroDiasMes = 28;
                    }
                    break;
			
                default:
                  numeroDiasMes = 0;
              }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCalendario = new javax.swing.JPanel();
        lblDomingo = new javax.swing.JLabel();
        lblLunes = new javax.swing.JLabel();
        lblMarte = new javax.swing.JLabel();
        lblMiercoles = new javax.swing.JLabel();
        lblJueves = new javax.swing.JLabel();
        lblViernes = new javax.swing.JLabel();
        lblSabado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCalendario.setBackground(new java.awt.Color(204, 204, 204));
        panelCalendario.setPreferredSize(new java.awt.Dimension(512, 375));
        panelCalendario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomingo.setBackground(new java.awt.Color(53, 92, 125));
        lblDomingo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblDomingo.setForeground(new java.awt.Color(255, 255, 255));
        lblDomingo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDomingo.setText("Domingo");
        lblDomingo.setOpaque(true);
        lblDomingo.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 0, -1, -1));

        lblLunes.setBackground(new java.awt.Color(53, 92, 125));
        lblLunes.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblLunes.setForeground(new java.awt.Color(255, 255, 255));
        lblLunes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLunes.setText("Lunes");
        lblLunes.setOpaque(true);
        lblLunes.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblMarte.setBackground(new java.awt.Color(53, 92, 125));
        lblMarte.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblMarte.setForeground(new java.awt.Color(255, 255, 255));
        lblMarte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarte.setText("Martes");
        lblMarte.setOpaque(true);
        lblMarte.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblMarte, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 0, -1, -1));

        lblMiercoles.setBackground(new java.awt.Color(53, 92, 125));
        lblMiercoles.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblMiercoles.setForeground(new java.awt.Color(255, 255, 255));
        lblMiercoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMiercoles.setText("Miercoles");
        lblMiercoles.setOpaque(true);
        lblMiercoles.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 0, -1, -1));

        lblJueves.setBackground(new java.awt.Color(53, 92, 125));
        lblJueves.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblJueves.setForeground(new java.awt.Color(255, 255, 255));
        lblJueves.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJueves.setText("Jueves");
        lblJueves.setOpaque(true);
        lblJueves.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 0, -1, -1));

        lblViernes.setBackground(new java.awt.Color(53, 92, 125));
        lblViernes.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblViernes.setForeground(new java.awt.Color(255, 255, 255));
        lblViernes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViernes.setText("Viernes");
        lblViernes.setOpaque(true);
        lblViernes.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 0, -1, -1));

        lblSabado.setBackground(new java.awt.Color(53, 92, 125));
        lblSabado.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblSabado.setForeground(new java.awt.Color(255, 255, 255));
        lblSabado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSabado.setText("Sabado");
        lblSabado.setOpaque(true);
        lblSabado.setPreferredSize(new java.awt.Dimension(73, 25));
        panelCalendario.add(lblSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 0, -1, -1));

        add(panelCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 400));
        panelCalendario.getAccessibleContext().setAccessibleName("panelCalendario");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDomingo;
    private javax.swing.JLabel lblJueves;
    private javax.swing.JLabel lblLunes;
    private javax.swing.JLabel lblMarte;
    private javax.swing.JLabel lblMiercoles;
    private javax.swing.JLabel lblSabado;
    private javax.swing.JLabel lblViernes;
    public javax.swing.JPanel panelCalendario;
    // End of variables declaration//GEN-END:variables

    private void pintaLabelSemana(String strDay) {
        switch(strDay){
            case "Domingo":
                lblDomingo.setBackground(diaActual);
                break;
            case "Lunes":
                lblLunes.setBackground(diaActual);
                break;
            case "Martes":
                lblMarte.setBackground(diaActual);
                break;
            case "Miercoles":
                lblMiercoles.setBackground(diaActual);
                break;
            case "Jueves":
                lblJueves.setBackground(diaActual);
                break;
            case "Viernes":
                lblViernes.setBackground(diaActual);
                break;
            case "Sabado":
                lblSabado.setBackground(diaActual);
                break;
        }
    }
}
