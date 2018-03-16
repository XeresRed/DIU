package com.modelo;

import com.modelo.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-16T00:46:07")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, String> descripcion;
    public static volatile SingularAttribute<Gasto, Date> fecha;
    public static volatile SingularAttribute<Gasto, Integer> idgasto;
    public static volatile SingularAttribute<Gasto, Usuarios> usuariosCorreo;
    public static volatile SingularAttribute<Gasto, String> nombre;

}