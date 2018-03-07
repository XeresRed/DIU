/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.google.api.services.drive.model.File;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Camilo
 */
public class controlPaneles implements MouseListener {
    com.vista.Drive.DriveFiles view;
    List<Integer> seleccion;
    
    public controlPaneles(com.vista.Drive.DriveFiles vista){
        view = vista;
        seleccion = new ArrayList<>();
    }
    
    public List<Integer> DevolverSeleccion(){
        return seleccion;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Color noS = new Color(254,244,232);
        for(int i = 0; i < view.representacionA.size(); i++){
            if(e.getSource()  == view.representacionA.get(i)){
                if(noS.equals(view.representacionA.get(i).getBackground())){
                    view.representacionA.get(i).setBackground(new Color(135,223,214));
                    
                    seleccion.add(i);
                }else{
                    view.representacionA.get(i).setBackground(noS);
                    eliminarElemento(i);
                    
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarElemento(int pos) {
        for (int i = 0; i < seleccion.size(); i++) {
            if(pos == seleccion.get(i)){
                seleccion.remove(i);
                
                
            }
        }
    }
    
   
    
}
