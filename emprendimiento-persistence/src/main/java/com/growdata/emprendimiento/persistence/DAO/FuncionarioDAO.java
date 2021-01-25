/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioDAO {

    public Funcionario getFuncionarioPorUserName(String userName, BigDecimal idEstado) throws Exception;

    public Funcionario getFuncionarioPorIdUser(long idUser, BigDecimal idEstado) throws Exception;

    public List<Funcionario> getFuncionariosPorCaja(BigDecimal idcajacompensacion) throws Exception;

    public long setFuncionario(Funcionario funcionario) throws Exception;

    public Funcionario getFuncionarioPorId(long idfuncionario) throws Exception;

    public String modificarFuncionario(Funcionario funcionario) throws Exception;

    public Funcionario getFuncionarioPorCorreo(String email) throws Exception;

    public List getUsuariosComiteLibres(List<String> lstRoles,
            BigDecimal idCajaCompensacion, BigDecimal idEstado) throws Exception;

    public List getUsuariosComite(BigDecimal idCajaCompensacion,
            BigDecimal idEstado) throws Exception;

//    public String updateIntegranteComite(Integrantescomite integranteComite);
    public String updateIntegranteComite(List<Integrantescomite> integrantes) throws Exception;

    public String setIntegranteComite(Integrantescomite integranteComite) throws Exception;

    public Comiteevaluacion getComiteEvaluacion(BigDecimal idCajaCompensacion) throws Exception;

    public Comiteevaluacion getComiteEvaluacionPorId(BigDecimal idComite) throws Exception;

    public String deleteIntegrantesComite(BigDecimal idComite) throws Exception;

    public List getFuncionariosPorGrupoYCaja(BigDecimal grupo, BigDecimal caja) throws Exception;
    
    public Funcionario getFuncionarioPorDocumento(String numerodocumento, BigDecimal idtipodocumento,long idfuncionario) throws Exception;

    public Funcionario isFuncionarioDelGrupo(String userName, String grupo) throws Exception;

    public List getFuncionariosPorGrupoYCaja(String grupo, BigDecimal caja) throws Exception;
}
