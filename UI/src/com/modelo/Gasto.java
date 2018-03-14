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
@Table(name = "gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g")
    , @NamedQuery(name = "Gasto.findByIdgasto", query = "SELECT g FROM Gasto g WHERE g.idgasto = :idgasto")
    , @NamedQuery(name = "Gasto.findByNombre", query = "SELECT g FROM Gasto g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Gasto.findByFecha", query = "SELECT g FROM Gasto g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "Gasto.findByDescripcion", query = "SELECT g FROM Gasto g WHERE g.descripcion = :descripcion")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idgasto")
    private Integer idgasto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "usuarios_correo", referencedColumnName = "correo")
    @ManyToOne(optional = false)
    private Usuarios usuariosCorreo;

    public Gasto() {
    }

    public Gasto(Integer idgasto) {
        this.idgasto = idgasto;
    }

    public Integer getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(Integer idgasto) {
        this.idgasto = idgasto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Usuarios getUsuariosCorreo() {
        return usuariosCorreo;
    }

    public void setUsuariosCorreo(Usuarios usuariosCorreo) {
        this.usuariosCorreo = usuariosCorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgasto != null ? idgasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.idgasto == null && other.idgasto != null) || (this.idgasto != null && !this.idgasto.equals(other.idgasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Gasto[ idgasto=" + idgasto + " ]";
    }
    
}
