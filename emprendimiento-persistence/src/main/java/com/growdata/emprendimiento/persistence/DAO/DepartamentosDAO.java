package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidadSIMPC.Departamentos;
import java.util.List;

public interface DepartamentosDAO {

    public List<Departamentos> getDepartamentos() throws Exception;

}
