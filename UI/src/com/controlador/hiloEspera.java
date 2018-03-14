/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.vista.Index;
import com.vista.espera.Espera;

/**
 *
 * @author Juan Camilo
 */
public class hiloEspera extends Thread{
    Index padre;
    
    public hiloEspera(Index p){
        padre = p;
    }
    
    @Override
	public void run() {
            com.vista.espera.Espera s = new Espera(padre, true);
            s.setVisible(true);
	}
    
}
