/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import java.math.BigDecimal;
import java.util.List;

public interface EntidadesFinancierasDAO {

    public List<Entidadesfinancieras> getEntidadesFinancierasAdmin() throws Exception;

    public BigDecimal setEntidadFinanciera(Entidadesfinancieras entidad) throws Exception;

    public Entidadesfinancieras getEntidadFinanciera(BigDecimal identidadfinanciera) throws Exception;

    public String setEntidadFinancieraM(Entidadesfinancieras entidad) throws Exception;

    public Entidadesfinancieras getEntidadFinancieraPorNombre(String nombreentidad) throws Exception;

    public Entidadesfinancieras getEntidadFinancieraPorNombreM(String nombreentidad,
            BigDecimal identidadfinanciera) throws Exception;

    public List<Entidadesfinancieras> getEntidadesFinancieras() throws Exception;

    public void borrarEntidadFinanciera(BigDecimal idEntidadFinanciera) throws Exception;
}
