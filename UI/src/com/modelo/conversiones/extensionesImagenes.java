/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.conversiones;

/**
 *
 * @author Juan Camilo
 */
public class extensionesImagenes {
    String[] listaExportaciones = {"JPEG","PNG","PDF"};
    String[] jp = {"image/jpeg",".jpg"};
    String[] pn = {"image/png",".png"};
    String[] pdf = {"application/pdf",".pdf"};
    
    public String[] conversiones(){
        return listaExportaciones;
    }
    
    public String[] jpg(){
        return jp;
    }
    
    public String[] png(){
        return pn;
    }
    
    public String[] pdf(){
        return pdf;
    }
}
