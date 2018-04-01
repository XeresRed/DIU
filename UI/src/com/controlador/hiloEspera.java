/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.vista.Index;
import com.vista.opciones.Espera;
import com.vista.opciones.RespuestaModal;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Camilo
 */
public class hiloEspera extends Thread{
    Index padre;
    String[] datosD;
    FileOutputStream salidaD;
    byte[] byteD;
    
    public hiloEspera(Index p){
        padre = p;
    }
    
    public void paso(String[] datos,FileOutputStream salida,byte[] s){
        datosD = datos;
        salidaD = salida;
        byteD = s;
    }
    
    @Override
	public void run() {
        try {
            com.vista.opciones.RespuestaModal s = new RespuestaModal(padre, true);
            String texto = "<html><body>Se esta descargando tu<br>archivo.<br></body></html>";
            s.cargaDatos("Espera", texto, "espera");
            s.setVisible(true);
            
            salidaD.write(byteD);
            salidaD.close();
        } catch (IOException ex) {
            Logger.getLogger(hiloEspera.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
}
