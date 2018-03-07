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
public class extensionesPresetaciones {
    String[] listaExportaciones = {"Office Power point","Open Office presentaciones","PDF"};
    String[] office = {"application/vnd.openxmlformats-officedocument.presentationml.presentation",".pptx"};
    String[] open = {"application/vnd.oasis.opendocument.presentation",".odp"};
    String[] pdf = {"application/pdf",".pdf"};
    
    public String[] conversiones(){
        return listaExportaciones;
    }
    
    public String[] docx(){
        return office;
    }
    
    public String[] open(){
        return open;
    }
    
    public String[] pdf(){
        return pdf;
    }
}
