/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneEmprTemasPorDocBeneficiario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerBeneficiarioPorUserName;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestConfiguraciones;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseRequisitos;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseBeneficiario;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseFindBeneficiarioXDoc;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseGetBeneficiarioXNombreYApellido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGetBeneficiarioXId;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGetBeneficiarioXId;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;

public interface BeneficiarioServicio {

    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarioPorNombreYApellido(RequestGetBeneficiarioXNombreYApellido request);

    public ResponseDTO enviarCorreoRecuperacion(String correo);

    public ResponseGetBeneficiarioXId getBeneficiarioPorCorreo(String correo);

    public BeneficiarioDTO traerBeneficiario(String numDoc);

    public ResponseFindBeneficiarioXDoc consultaBenfeficiario(RequestFindBeneficiarioXDoc request);

    public ResponseGetBeneficiarioXId getBeneficiarioXId(RequestGetBeneficiarioXId request);

    public ResponseBeneficiario guardarBeneficiario(RequestRegBeneficiario request);

    public Beneficiario getBeneficiario(long saveIdBeneficiario);

    public boolean validaBeneficiario(String doc, String email);

    public ResponseTraerBeneEmprTemasPorDocBeneficiario getBeneEmprTemasPorDocBeneficiario(RequestTraerBeneEmprTemasPorDocBeneficiario request);

    public ResponseGetBeneficiarioXNombreYApellido getBeneficiarios(
            Long idbeneficiario,
            String doc,
            String pNombre,
            String sNombre,
            String pApellido,
            String sApellido);

    public ResponseTraerBeneficiarioPorUserName getBeneficiario(RequestTraerBeneficiarioPorUserName requestTraerBeneficiarioPorUserName);

    public ResponseRequisitos verificarRequisitos(MdFDatosBasicos beneficiario, RequestConfiguraciones validaciones);
}
