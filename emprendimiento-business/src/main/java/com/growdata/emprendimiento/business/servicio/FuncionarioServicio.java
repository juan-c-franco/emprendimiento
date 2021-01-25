/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorIdUser;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestTraerUsuariosComiteLibres;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseEliminarIntegrantesComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGuardarIntegranteComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacion;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerComiteEvaluacionPorCaja;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorIdUser;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerFuncionarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComite;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerUsuariosComiteLibres;

import com.growdata.emprendimiento.business.dtos.seguridad.RequestConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.RequestTraerFuncionariosPorGrupoCaja;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseConsultarFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseIsFuncionarioGrupo;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseModificarFuncionario2;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseRegistrarFuncionario;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionarios;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionariosPorGrupoCaja;
import java.math.BigDecimal;

public interface FuncionarioServicio {

    public ResponseConsultarFuncionarios getFuncionariosPorCaja(RequestConsultarFuncionarios request);

    public ResponseTraerFuncionarioPorIdUser getFuncionarioPorIdUser(RequestTraerFuncionarioPorIdUser request);

    public ResponseModificarFuncionario2 setFuncionarioM(RequestModificarFuncionario2 request);

    public ResponseRegistrarFuncionario setFuncionario(RequestRegistrarFuncionario request);

    public ResponseModificarFuncionario getFuncionarioPorId(RequestModificarFuncionario request);

    public ResponseTraerUsuariosComiteLibres getUsuariosComiteLibres(RequestTraerUsuariosComiteLibres requestUsuariosLibres);

    public ResponseTraerUsuariosComite getUsuariosComite(RequestTraerUsuariosComite requestUsuarios);

    public ResponseGuardarIntegranteComite setIntegranteComite(RequestGuardarIntegranteComite request);

    public ResponseTraerComiteEvaluacionPorCaja getComiteEvaluacion(RequestTraerComiteEvaluacionPorCaja requestComiteEvaluacion);

    public ResponseTraerComiteEvaluacion getComiteEvaluacion(RequestTraerComiteEvaluacion requestComiteEvaluacion);

    public ResponseEliminarIntegrantesComite deleteIntegrantesComite(RequestEliminarIntegrantesComite requestEliminarIntegrantes);

    public ResponseTraerFuncionarioPorUserName getFuncionarioPorUserName(RequestTraerFuncionarioPorUserName request);

    public ResponseTraerFuncionarios getFuncionariosPorGrupoYCaja(BigDecimal grupo, BigDecimal caja);

    public ResponseIsFuncionarioGrupo isFuncionarioDelGrupo(RequestIsFuncionarioGrupo requestFuncionarioGrupo);

    public ResponseTraerFuncionariosPorGrupoCaja getFuncionariosPorGrupoYCaja(RequestTraerFuncionariosPorGrupoCaja requestFuncionarioGrupoCaja);
}
