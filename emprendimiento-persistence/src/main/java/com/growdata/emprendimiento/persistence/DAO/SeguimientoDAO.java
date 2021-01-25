package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Observacionesseguimiento;
import com.growdata.emprendimiento.persistence.entidad.Seguimiento;
import javax.persistence.PersistenceException;

public interface SeguimientoDAO {

    public long guardarSeguimientoFormalizado(Formalizado formalizado,
            Observacionesseguimiento observaciones,
            Seguimiento seguimiento, Financiacion financiacion, boolean finalizar) throws PersistenceException, Exception;

    public long guardarSeguimientoNoEstablecido(Noestablecido noEstablecido,
            Observacionesseguimiento observaciones,
            Seguimiento seguimiento, Financiacion financiacion, boolean finalizar) throws PersistenceException, Exception;

}
