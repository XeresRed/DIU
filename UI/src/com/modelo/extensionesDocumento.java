/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Juan Camilo
 */
public class extensionesDocumento {
    
    String[] listaExportaciones = {"Office Word","Open Office Texto","PDF"};
    String[] Word = {"application/vnd.openxmlformats-officedocument.wordprocessingml.document",".docx"};
    String[] open = {"application/vnd.oasis.opendocument.text",".odt"};
    String[] pdf = {"application/pdf",".pdf"};
    
    
    public String[] conversiones(){
        return listaExportaciones;
    }
    
    public String[] docx(){
        return Word;
    }
    
    public String[] open(){
        return open;
    }
    
    public String[] pdf(){
        return pdf;
    }
    
    
    
    
}
