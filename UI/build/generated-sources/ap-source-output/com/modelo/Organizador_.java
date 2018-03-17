package com.modelo;

import com.modelo.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-16T20:22:07")
@StaticMetamodel(Organizador.class)
public class Organizador_ { 

    public static volatile SingularAttribute<Organizador, String> descripcion;
    public static volatile SingularAttribute<Organizador, Date> fecha;
    public static volatile SingularAttribute<Organizador, Integer> idorganizador;
    public static volatile SingularAttribute<Organizador, Usuarios> usuariosCorreo;
    public static volatile SingularAttribute<Organizador, String> titulo;
    public static volatile SingularAttribute<Organizador, String> tag;

}