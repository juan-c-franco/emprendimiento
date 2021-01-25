package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import java.util.List;

public interface EstadoSesionDAO {

    public Estadosesion getEstadoSesion(String nombreEstadoSesion) throws Exception;

}
