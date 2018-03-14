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
import com.persistencia.UsuariosJpaController;
import com.persistencia.exceptions.IllegalOrphanException;
import com.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author usuario
 */
public class LogicaUsuario {
    private UsuariosJpaController UsuarioDAO;

    public LogicaUsuario() {
        UsuarioDAO = new UsuariosJpaController();
    }
    
    public void registrarUsuario(Usuarios nuevoItem) throws Exception{
        if(nuevoItem == null){
            throw new Exception("Objeto vacio");
        }
        if(nuevoItem.getCorreo()==null || nuevoItem.getCorreo().equals("") ){
            throw new Exception("El codigo es obligatorio");
        }
        if(nuevoItem.getNombre()== null || nuevoItem.getNombre().equals("")){
            throw new Exception("El nombre de la materia es obligatorio");
        }
        if(nuevoItem.getContraseña()== null){        
            throw new Exception("El numero de creditos es obligatorio");
        }
        


        UsuarioDAO.create(nuevoItem);
    }
    
    public List<Usuarios> BuscarUsuarios(){
        return UsuarioDAO.findUsuariosEntities();
    }
    
    public Usuarios BuscarUsuario(String id){
        return UsuarioDAO.findUsuarios(id);
    }
    
    public void modificarUsuario(Organizador id){
         try {
            UsuarioDAO.edit(id);
        } catch (Exception ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarUsuario(String id) throws IllegalOrphanException{
        try {
            UsuarioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
