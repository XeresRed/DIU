/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Camilo
 */
@Entity
@Table(name = "table_04")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Table04.findAll", query = "SELECT t FROM Table04 t")
    , @NamedQuery(name = "Table04.findByUsuariosCorreo", query = "SELECT t FROM Table04 t WHERE t.usuariosCorreo = :usuariosCorreo")
    , @NamedQuery(name = "Table04.findByTipoLetra", query = "SELECT t FROM Table04 t WHERE t.tipoLetra = :tipoLetra")
    , @NamedQuery(name = "Table04.findByColorFondo", query = "SELECT t FROM Table04 t WHERE t.colorFondo = :colorFondo")})
public class Table04 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuarios_correo")
    private String usuariosCorreo;
    @Column(name = "tipo_letra")
    private String tipoLetra;
    @Column(name = "color_fondo")
    private String colorFondo;
    @JoinColumn(name = "usuarios_correo", referencedColumnName = "correo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Table04() {
    }

    public Table04(String usuariosCorreo) {
        this.usuariosCorreo = usuariosCorreo;
    }

    public String getUsuariosCorreo() {
        return usuariosCorreo;
    }

    public void setUsuariosCorreo(String usuariosCorreo) {
        this.usuariosCorreo = usuariosCorreo;
    }

    public String getTipoLetra() {
        return tipoLetra;
    }

    public void setTipoLetra(String tipoLetra) {
        this.tipoLetra = tipoLetra;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosCorreo != null ? usuariosCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table04)) {
            return false;
        }
        Table04 other = (Table04) object;
        if ((this.usuariosCorreo == null && other.usuariosCorreo != null) || (this.usuariosCorreo != null && !this.usuariosCorreo.equals(other.usuariosCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Table04[ usuariosCorreo=" + usuariosCorreo + " ]";
    }
    
}
