package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import java.util.List;

public interface ListaasistenciaaatDAO {

    public List<Listaasistenciaaat> getLista(long idSesion) throws Exception;

}
