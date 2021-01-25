/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import java.math.BigDecimal;
import java.util.List;

public interface CajasDeCompensacionDAO {

    public List<Cajacompensacion> getCajasDeCompensacion() throws Exception;

    public List<Cajacompensacion> getCajasDeCompensacionAdmin() throws Exception;

    public BigDecimal setCajaCompensacion(Cajacompensacion caja) throws Exception;

    public String setCajaCompensacionM(Cajacompensacion caja) throws Exception;

    public Cajacompensacion getCajaCompensacion(BigDecimal idcajacompensacion) throws Exception;

    public Cajacompensacion getCajaCompensacionPorNombre(String nombrecajacompensacion)
            throws Exception;

    public Cajacompensacion getCajaCompensacionPorNombreM(String nombrecajacompensacion,
            BigDecimal idcajacompensacion) throws Exception;

    public void borrarCajaCompensacion(BigDecimal idcajacompensacion) throws Exception;
}
