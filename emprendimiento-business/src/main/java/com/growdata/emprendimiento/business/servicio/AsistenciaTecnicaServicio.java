/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RequestUpdateListasAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseConsultarAvance;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseEliminarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarSesionAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseGuardarTemaRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTipoDocumento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentoComite;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerDocumentos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEmprendimientos;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerEstadoEmprendimiento;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerListaTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATComplexPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionAATPorId;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerSesionesAATPorFuncionario;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseTraerTemasRutaAAT;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.ResponseUpdateListasAAT;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;

public interface AsistenciaTecnicaServicio {

    public ResponseTraerSesionesAATPorFuncionario getSesionesAAT(RequestTraerSesionesAATPorFuncionario request);

    public ResponseTraerSesionesAATPorFuncionario getSesionesAATAsistencia(RequestTraerSesionesAATPorFuncionario request);

    public ResponseGuardarSesionAAT guardarSesionAAT(RequestGuardarSesionAAT request);

    public ResponseEliminarSesionAAT deleteSesionAAT(RequestEliminarSesionAAT request);

    public ResponseTraerSesionAATPorId getSesionAAT(RequestTraerSesionAATPorId request);

    public ResponseGuardarSesionAAT actualizarSesionAAT(RequestGuardarSesionAAT request);

    public ResponseTraerTemasRutaAAT getTemaRutaAAT(RequestTraerTemasRutaAAT requestTraerTemasRutaAAT);

    public ResponseTraerSesionAATComplexPorId getSesionAATComplex(RequestTraerSesionAATPorId request);

    public ResponseTraerRutaAAT getRutaAAT(RequestTraerRutaAAT requestTraerRutaAAT);

    public ResponseTraerListaAAT getListaAAT(RequestTraerListaAAT requestTraerListaAAT);

    public ResponseUpdateListasAAT updateListasATT(RequestUpdateListasAAT requestUpdateListasAAT);

    public ResponseTraerEmprendimientos getEmprendimientos(RequestTraerEmprendimientos requestEmprendimientos);

    public ResponseTraerEmprendimiento getEmprendimiento(RequestTraerEmprendimiento requestTraerEmprendimiento);

    public ResponseTraerListaTemasRutaAAT getTemasRutaATTPorEmprendimiento(RequestTraerTemasRutaAAT requestTraerTemasRutaAAT);

    public ResponseGuardarTemaRutaAAT guardarTemaRutaATT(RequestGuardarTemaRutaAAT requestGuardarTemaRutaAAT);

    public ResponseConsultarAvance consultarAvanceAAT(RequestConsultarAvance requestConsultarAvance);

    public ResponseTraerEstadoEmprendimiento getEstadoEmprendimiento(RequestTraerEstadoEmprendimiento requestTraerEstadoEmprendimiento);

    public ResponseTraerDocumentoComite getDocumento(RequestTraerDocumentoComite requestTraerDocumentoComite);

    public ResponseTipoDocumento getTipoDocumento(RequestTipoDocumento requestTipoDocumento);

    public ResponseGuardarDocumento guardarDocumento(RequestGuardarDocumento requestGuardarDocumento);

    public ResponseTraerDocumentos getDocumentos(RequestTraerDocumentos requestTraerDocumentos);

    public ResponseEliminarDocumento deleteDocumento(RequestEliminarDocumento request);

    public ResponseDTO liberarSesiones(Sesionacompanamientoat sesion);

    public ResponseDTO registrarAsistenciaAAT(RequestGuardarSesionAAT request);
}
