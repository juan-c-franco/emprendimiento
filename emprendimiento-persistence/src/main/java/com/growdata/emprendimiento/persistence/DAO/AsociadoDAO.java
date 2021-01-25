/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Asociados;
import java.math.BigDecimal;
import java.util.List;

public interface AsociadoDAO {

    public Asociados getAsociadoXId(long idBeneficiario) throws Exception;

    public List<Asociados> getAsociadosPorEmprendimiento(long idemprendimiento) throws Exception;

    public Asociados getAsociadoPorUserName(BigDecimal estadoUsuario, String userName)
            throws Exception;

    public List<Asociados> getAsociadosPorEmprendimiento2(long idemprendimiento) throws Exception;

}
