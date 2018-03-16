/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.modelo.*;
import com.persistencia.OrganizadorJpaController;
import com.persistencia.exceptions.IllegalOrphanException;
import com.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author usuario
 */
public class LogicaOrganizador {
    private OrganizadorJpaController organizadorDAO;

    public LogicaOrganizador() {
        organizadorDAO = new OrganizadorJpaController();
    }
    
    public void registrarCita(Organizador nuevoItem) throws Exception{
        if(nuevoItem == null){
            throw new Exception("Objeto vacio");
        }
        if(nuevoItem.getTitulo()==null || nuevoItem.getTitulo().equals("") ){
            throw new Exception("El codigo es obligatorio");
        }
        if(nuevoItem.getFecha()== null){
            throw new Exception("El nombre de la materia es obligatorio");
        }
        if(nuevoItem.getDescripcion()== null){        
            throw new Exception("El numero de creditos es obligatorio");
        }
        if(nuevoItem.getTag()== null || nuevoItem.getTag().equals("")   ){
            throw new Exception("La Hora de inicio es obligatorio");
        }
        if(nuevoItem.getUsuariosCorreo()== null ){
            throw new Exception("La Hora de inicio es obligatorio");
        }


        organizadorDAO.create(nuevoItem);
    }
    
    public List<Organizador> consultarCitas(){
        return organizadorDAO.findOrganizadorEntities();
    }
    
    public Organizador leerCita(int id){
        return organizadorDAO.findOrganizador(id);
    }
    
    public void modificarCita(Organizador id){
         try {
            organizadorDAO.edit(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCita(int id){
        try {
            organizadorDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
