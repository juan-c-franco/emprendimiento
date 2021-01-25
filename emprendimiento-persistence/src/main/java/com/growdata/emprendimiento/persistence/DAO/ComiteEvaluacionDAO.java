package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;

public interface ComiteEvaluacionDAO {

    public Comiteevaluacion getComitePorIdFuncionario(long idFuncionario) throws Exception;

}
