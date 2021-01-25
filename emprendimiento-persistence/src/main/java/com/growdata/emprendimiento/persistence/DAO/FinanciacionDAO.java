/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;

public interface FinanciacionDAO {

    public long guardarInformacionFinancieraBasica(Financiacion financiacion,
            long idemprendimiento, Estadoemprendimiento estadoEmprendimiento,
            String Aprobado) throws Exception;

    public Financiacion getFinanciacionPorId(long idEmprendimiento) throws Exception;

    public void guardarInformacionFinanciera(Financiacion financiacion,
            long idemprendimiento, Estadoemprendimiento estadoEmprendimiento, int validacionActiva) throws Exception;

}
