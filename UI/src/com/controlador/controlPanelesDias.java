/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Organizador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Camilo
 */
public class controlPanelesDias implements MouseListener{

    List<Organizador> oa;
    com.vista.agenda.agendarCalendar view;
    List<Integer> seleccion;
    LogicaOrganizador lo = new LogicaOrganizador();
    
    public controlPanelesDias(com.vista.agenda.agendarCalendar vista){
        view = vista;
        seleccion = new ArrayList<>();
    }
    
    public List<Organizador> DevolverSeleccion(){
        return oa;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
         Color Urgente =  new Color(244,67,54);
         Color Importante =  new Color(30,136,229);
         Color Normal =  new Color(255,213,79);
         Color Baja =  new Color(198,255,0);
            for(int i = 0; i < view.listaPanelesDias.size(); i++){
                if(e.getSource()  == view.listaPanelesDias.get(i)){
                    if(seleccion.isEmpty()){
                        if(Urgente.equals(view.listaPanelesDias.get(i).getBackground()) || Importante.equals(view.listaPanelesDias.get(i).getBackground())
                                || Normal.equals(view.listaPanelesDias.get(i).getBackground()) || Baja.equals(view.listaPanelesDias.get(i).getBackground())){
                            view.listaPanelesDias.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
                            oa = view.listaPanelesDias.get(i).getCita();
                            if(oa.size() > 0 && oa.size() < 2){
                                //view.vistaPrevia(oa.get(0).getTitulo(), oa.get(0).getDescripcion());
                            }
                            seleccion.add(i);
                            view.ActivarOpcionesDias(true);
                        }
                    }else{
                       if(e.getSource()  == view.listaPanelesDias.get(seleccion.get(0))){
                           view.listaPanelesDias.get(i).setBorder(BorderFactory.createEmptyBorder());
                           eliminarElemento(i);
                           view.ActivarOpcionesDias(false);
                       }else{
                           JOptionPane.showMessageDialog(view, "Actuamente ya tiene seleccionado un día, deseleccione el dia para poder seleccionar otro dia.");
                       }
                    }
                }
            }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    private void eliminarElemento(int pos) {
        for (int i = 0; i < seleccion.size(); i++) {
            if(pos == seleccion.get(i)){
                seleccion.remove(i);
                oa.remove(i);
            }
        }
    }
    
    public  Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
      }
    
}
