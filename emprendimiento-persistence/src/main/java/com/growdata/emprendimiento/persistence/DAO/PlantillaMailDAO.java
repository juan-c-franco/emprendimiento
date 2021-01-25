package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;

public interface PlantillaMailDAO {

    public PlantillaMail consultaPlantillaXId(long id) throws Exception;
}
