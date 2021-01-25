package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidadSIMPC.Municipios;
import java.math.BigDecimal;
import java.util.List;

public interface MunicipiosDAO {

    public List<Municipios> getMunicipiosPorDepartamento(BigDecimal iddepartamento) throws Exception;
    
    public Municipios getMunicipioPorId(BigDecimal id) throws Exception;

}
