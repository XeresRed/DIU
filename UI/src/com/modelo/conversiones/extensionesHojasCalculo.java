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
public class extensionesHojasCalculo {
    String[] listaExportaciones = {"Office Excel","Open Office Hoja de calculo","PDF"};
    String[] Excel = {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",".xlsx"};
    String[] open = {"application/x-vnd.oasis.opendocument.spreadsheet",".ods"};
    String[] pdf = {"application/pdf",".pdf"};
    
    public String[] conversiones(){
        return listaExportaciones;
    }
    
    public String[] docx(){
        return Excel;
    }
    
    public String[] open(){
        return open;
    }
    
    public String[] pdf(){
        return pdf;
    }
}
