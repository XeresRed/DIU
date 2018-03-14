/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Camilo
 */
public class controlPanelesDias implements MouseListener{

    
    com.vista.agenda.agendarCalendar view;
    List<Integer> seleccion;
    
    public controlPanelesDias(com.vista.agenda.agendarCalendar vista){
        view = vista;
        seleccion = new ArrayList<>();
    }
    
    public List<Integer> DevolverSeleccion(){
        return seleccion;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
         Color noS = new Color(240,240,240);
            for(int i = 0; i < view.listaPanelesDias.size(); i++){
                if(e.getSource()  == view.listaPanelesDias.get(i)){
                    if(seleccion.isEmpty()){
                        if(noS.equals(view.listaPanelesDias.get(i).getBackground())){
                            view.listaPanelesDias.get(i).setBackground(new Color(135,223,214));
                            view.panelCalendario.getComponent(i+7).setBackground(new Color(135,223,214));
                            seleccion.add(i);
                            view.ActivarOpcionesDias(true);
                        }
                    }else{
                       if(e.getSource()  == view.listaPanelesDias.get(seleccion.get(0))){
                           view.listaPanelesDias.get(i).setBackground(noS);
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
            }
        }
    }
}
