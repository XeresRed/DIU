/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "organizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizador.findAll", query = "SELECT o FROM Organizador o")
    , @NamedQuery(name = "Organizador.findByIdorganizador", query = "SELECT o FROM Organizador o WHERE o.idorganizador = :idorganizador")
    , @NamedQuery(name = "Organizador.findByTitulo", query = "SELECT o FROM Organizador o WHERE o.titulo = :titulo")
    , @NamedQuery(name = "Organizador.findByFecha", query = "SELECT o FROM Organizador o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Organizador.findByDescripcion", query = "SELECT o FROM Organizador o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Organizador.findByTag", query = "SELECT o FROM Organizador o WHERE o.tag = :tag")})
public class Organizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idorganizador")
    private Integer idorganizador;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tag")
    private String tag;
    @JoinColumn(name = "usuarios_correo", referencedColumnName = "correo")
    @ManyToOne(optional = false)
    private Usuarios usuariosCorreo;

    public Organizador() {
    }

    public Organizador(Integer idorganizador) {
        this.idorganizador = idorganizador;
    }

    public Integer getIdorganizador() {
        return idorganizador;
    }

    public void setIdorganizador(Integer idorganizador) {
        this.idorganizador = idorganizador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Usuarios getUsuariosCorreo() {
        return usuariosCorreo;
    }

    public void setUsuariosCorreo(Usuarios usuariosCorreo) {
        this.usuariosCorreo = usuariosCorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorganizador != null ? idorganizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizador)) {
            return false;
        }
        Organizador other = (Organizador) object;
        if ((this.idorganizador == null && other.idorganizador != null) || (this.idorganizador != null && !this.idorganizador.equals(other.idorganizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Organizador[ idorganizador=" + idorganizador + " ]";
    }
    
}
