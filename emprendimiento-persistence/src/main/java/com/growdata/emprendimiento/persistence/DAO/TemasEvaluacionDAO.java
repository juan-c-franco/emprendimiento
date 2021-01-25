/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import java.math.BigDecimal;

public interface TemasEvaluacionDAO {

    public Temasevaluacion traerTemasPorTema(BigDecimal idTema) throws Exception;

    public void borrarTemaEvaluacion(BigDecimal idTema, BigDecimal idCajaCompensacion,
            BigDecimal idHerramienta) throws Exception;
}
