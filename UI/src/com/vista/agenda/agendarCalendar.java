/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.agenda;

import com.controlador.Control_fuentes;
import com.controlador.LogicaOrganizador;
import com.controlador.controlPanelesDias;
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
import javax.swing.JOptionPane;


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
    String[] strDays = new String[]{"Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
    String[] meses = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public List<com.vista.agenda.panelesDias.panelDias> listaPanelesDias = new ArrayList<panelDias>();
    Calendar fecha;
    /**
     * Creates new form agendarCalendar
     * @param view
     */
    public agendarCalendar(Index view, Usuarios user) {
        initComponents();
        this.setName("AgendaCalendario");
        
        Control_fuentes tf = new Control_fuentes("texto");
        this.jLabel1.setFont(tf.MyFont(1, 18f));
        
        vista = view;
        userAccedido = user;
        fecha = Calendar.getInstance();
        year = fecha.get(Calendar.YEAR);

        calcularDiasMes(fecha.get(Calendar.MONTH) + 1);
        
        Calendar ahoraCal = Calendar.getInstance();
        ahoraCal.set(year,fecha.get(Calendar.MONTH),1);
        jLabel1.setText("Dias del mes de " + meses[fecha.get(Calendar.MONTH)] );
        int contadorDias = ahoraCal.get(Calendar.DAY_OF_WEEK) - 1;
        com = new controlPanelesDias(this);
        int y = 25;
        int x = 0;
        int heig = 75;
        int contador = 0;
        int wid = 73;
        for (int i = 0; i < numeroDiasMes; i++) {
            if(contadorDias >= strDays.length ){
                contadorDias = 0;
            }
            if(contador == 7){
                y += heig;   
                contador = 0;
                x = 0;
            }
            String numDia = (i + 1) + "";
            com.vista.agenda.panelesDias.panelDias dia = new panelDias(numDia,strDays[contadorDias]);
   
            listaPanelesDias.add(dia);
            dia.setName("panel dia: " + numDia);
            dia.setVisible(true);
            dia.addMouseListener(com);
            panelCalendario.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, wid, heig));
            x += wid;
            contador++;
            contadorDias++;

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
                //panelCalendario.getComponent(tiempoLis.get(Calendar.DAY_OF_MONTH)+5).setBackground(new Color(255,255,255));
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
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCalendario.setBackground(new java.awt.Color(204, 204, 204));
        panelCalendario.setPreferredSize(new java.awt.Dimension(512, 375));
        panelCalendario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 400));
        panelCalendario.getAccessibleContext().setAccessibleName("panelCalendario");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 20, 500, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel panelCalendario;
    // End of variables declaration//GEN-END:variables

    
}
