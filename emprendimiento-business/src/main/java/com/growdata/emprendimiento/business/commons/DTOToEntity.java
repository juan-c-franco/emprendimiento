/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.business.dtos.intentodto.ActividadInternacionalDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AsociadosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocajacompensacionDTO;

import com.growdata.emprendimiento.business.dtos.parametrizacion.HerramientaValoracionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.PreguntasTemaDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ConfiguracionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.RutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipodocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Estadocajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;

import com.growdata.emprendimiento.persistence.entidad.Herramientasvaloracion;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;

import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Rutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentos;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de transformar un DTO a Entidad.
 *
 * @author Juan Franco
 */
public class DTOToEntity {

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param preguntasDTO DTO.
     * @return Entidad.
     */
    public static Preguntas dtoPreguntaToPregunta(PreguntasDTO preguntasDTO) {
        Preguntas preguntas = new Preguntas();
        preguntas.setTextopregunta(preguntasDTO.getTextopregunta());
        preguntas.setIdpregunta(preguntasDTO.getIdpregunta());
        preguntas.setCajacompensacion(dtoCajaCompensacionToCajaCompensacion(
                preguntasDTO.getCajacompensacion()));
        preguntas.setFecharegistro(preguntasDTO.getFecharegistro());

        return preguntas;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param actividadInternacionalDTO DTO.
     * @return Entidad.
     */
    public static Actividadinternacional
            dtoActividadInernacionalToActividadInternacional(
                    ActividadInternacionalDTO actividadInternacionalDTO) {
        Actividadinternacional actividadInternacional
                = new Actividadinternacional();
        actividadInternacional.setIdactividadinternacional(
                actividadInternacionalDTO.getIdactividadinternacional());
        actividadInternacional.setNombreactividadinternacional(
                actividadInternacionalDTO.getNombreactividadinternacional());
        actividadInternacional.setDescripcion(
                actividadInternacionalDTO.getDescripcion());
        return actividadInternacional;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param asociadosDTO DTO.
     * @return Entidad.
     */
    public static Asociados dtoAsociadosToAsociados(AsociadosDTO asociadosDTO) {
        Asociados asociados = new Asociados();
        asociados.setIdasociado(asociadosDTO.getIdasociado());
        asociados.setFecharegistro(asociadosDTO.getFecharegistro());

        return asociados;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param beneficiarioDTO DTO.
     * @return Entidad.
     */
    public static Beneficiario dtoBeneficiarioToBeneficiario(
            BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setIdbeneficiario(beneficiarioDTO.getIdbeneficiario());
        beneficiario.setPrimernombre(beneficiarioDTO.getPrimernombre());
        beneficiario.setSegundonombre(beneficiarioDTO.getSegundonombre());
        beneficiario.setPrimerapellido(beneficiarioDTO.getPrimerapellido());
        beneficiario.setSegundoapellido(beneficiarioDTO.getSegundoapellido());

        beneficiario.setEmail(beneficiarioDTO.getEmail());
        beneficiario.setTelefono(beneficiarioDTO.getTelefono());
        beneficiario.setNumerodocumento(beneficiarioDTO.getNumerodocumento());
        beneficiario.setFecharegistro(beneficiarioDTO.getFecharegistro());
        beneficiario.setUsers(beneficiarioDTO.getUsers());

        return beneficiario;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param comiteEvaluacionDTO DTO.
     * @return Entidad.
     */
    public static Comiteevaluacion dtoComiteEvalacionToComiteEvaluacion(
            ComiteevaluacionDTO comiteEvaluacionDTO) {
        Comiteevaluacion comiteEvaluacion = new Comiteevaluacion();
        comiteEvaluacion.setIdcomite(comiteEvaluacionDTO.getIdcomite());
        if (comiteEvaluacionDTO.getCajacompensacion() != null) {
            comiteEvaluacion.setCajacompensacion(
                    dtoCajaCompensacionToCajaCompensacion(
                            comiteEvaluacionDTO.getCajacompensacion()));
        }
        comiteEvaluacion.setNombrecomite(comiteEvaluacionDTO.getNombrecomite());
        comiteEvaluacion.setFecharegistro(
                comiteEvaluacionDTO.getFecharegistro());
        comiteEvaluacion.setDescripcion(comiteEvaluacionDTO.getDescripcion());

        return comiteEvaluacion;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param documentosDTO DTO.
     * @return Entidad.
     */
    public static Documentos dtoDocumentosToDocumentos(
            DocumentosDTO documentosDTO) {
        Documentos documentos = new Documentos();
        documentos.setIddocumento(documentosDTO.getIddocumento());
        if (documentosDTO.getBeneficiario() != null) {
            documentos.setBeneficiario(dtoBeneficiarioToBeneficiario(
                    documentosDTO.getBeneficiario()));
        }
        if (documentosDTO.getEmprendimiento() != null) {
            documentos.setEmprendimiento(dtoEmprendimientoToEmprendimiento(
                    documentosDTO.getEmprendimiento()));
        }
        if (documentosDTO.getTipodocumentos() != null) {
            documentos.setTipodocumentos(dtoTipoDocumentosToTipoDocumento(
                    documentosDTO.getTipodocumentos()));
        }

        documentos.setFecharegistro(documentosDTO.getFecharegistro());
        documentos.setUrlarchivo(documentosDTO.getUrlarchivo());
        return documentos;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param emprendimientoDTO DTO.
     * @return Entidad.
     */
    public static Emprendimiento dtoEmprendimientoToEmprendimiento(
            EmprendimientoDTO emprendimientoDTO) {
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setIdemprendimiento(
                emprendimientoDTO.getIdemprendimiento());
        if (emprendimientoDTO.getEstadoemprendimiento() != null) {
            emprendimiento.setEstadoemprendimiento(
                    dtoEstadoEmprendimientoToEstadoEmprendimiento(
                            emprendimientoDTO.getEstadoemprendimiento()));
        }
        return emprendimiento;

    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param entidadesDTO DTO.
     * @return Entidad.
     */
    public static Entidadesfinancieras
            dtoEntidadesFinancierasToEntidadesFinancieras(
                    EntidadesfinancierasDTO entidadesDTO) {
        Entidadesfinancieras entidades = new Entidadesfinancieras();
        entidades.setDescripcion(entidadesDTO.getDescripcion());
        entidades.setEstado(entidadesDTO.getEstado());
        entidades.setNombreentidad(entidadesDTO.getNombreentidad());

        entidades.setIdentidadfinanciera(
                entidadesDTO.getIdentidadesfinanciera());
        return entidades;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param cajaDTO DTO.
     * @return Entidad.
     */
    public static Cajacompensacion dtoCajaCompensacionToCajaCompensacion(
            CajacompensacionDTO cajaDTO) {
        Cajacompensacion caja = new Cajacompensacion();
        caja.setCodigoccf(cajaDTO.getCodigoccf());
        caja.setEstadocajacompensacion(dtoEstadoCajaToEstadoCaja(
                cajaDTO.getEstadocajacompensacion()));
        caja.setNombrecajacompensacion(cajaDTO.getNombrecajacompensacion());
        caja.setFecharegistro(cajaDTO.getFecharegistro());
        caja.setIdcajacompensacion(cajaDTO.getIdcajacompensacion());
        caja.setDepartamento(cajaDTO.getDepartamento());
        return caja;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param estadoDTO DTO.
     * @return Entidad.
     */
    public static Estadocajacompensacion dtoEstadoCajaToEstadoCaja(
            EstadocajacompensacionDTO estadoDTO) {
        Estadocajacompensacion estado = new Estadocajacompensacion();
        estado.setIdestadocajacompensacion(estadoDTO
                .getIdestadocajacompensacion());
        return estado;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param temasEvaluacionDTO DTO.
     * @return Entidad.
     */
    public static Temasevaluacion dtoTemaEvaluacionToTemaEvaluacion(
            TemasEvaluacionDTO temasEvaluacionDTO) {
        Temasevaluacion temasevaluacion = new Temasevaluacion();
        temasevaluacion.setIdtema(temasEvaluacionDTO.getIdtema());
        if (temasEvaluacionDTO.getCajaCompensacionDTO() != null) {
            temasevaluacion.setCajacompensacion(
                    dtoCajaCompensacionToCajaCompensacion(temasEvaluacionDTO
                            .getCajaCompensacionDTO()));
        }
        if (temasEvaluacionDTO.getHerramientaValoracionDTO() != null) {
            temasevaluacion.setHerramientasvaloracion(
                    dtoHerramientasValoracionToHerramientasValoracion(
                            temasEvaluacionDTO.getHerramientaValoracionDTO()));
        }

        temasevaluacion.setNombretema(temasEvaluacionDTO.getNombretema());
        temasevaluacion.setDescripcion(temasEvaluacionDTO.getDescripcion());
        temasevaluacion.setFecharegistro(temasEvaluacionDTO.getFecharegistro());
        temasevaluacion.setHorasbasico(temasEvaluacionDTO.getHorasbasico());
        temasevaluacion.setCalificacionbasico(
                temasEvaluacionDTO.getCalificacionbasico());
        temasevaluacion.setHorasintermedio(
                temasEvaluacionDTO.getHorasintermedio());
        temasevaluacion.setCalificacionintermedio(
                temasEvaluacionDTO.getCalificacionintermedio());
        temasevaluacion.setHorasavanzado(temasEvaluacionDTO.getHorasavanzado());
        temasevaluacion.setCalificacionavanzado(
                temasEvaluacionDTO.getCalificacionavanzado());
        temasevaluacion.setEstado(temasEvaluacionDTO.getEstado());
        return temasevaluacion;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param herramientaValoracionDTO DTO.
     * @return Entidad.
     */
    public static Herramientasvaloracion
            dtoHerramientasValoracionToHerramientasValoracion(
                    HerramientaValoracionDTO herramientaValoracionDTO) {
        Herramientasvaloracion herramientasvaloracion
                = new Herramientasvaloracion();
        herramientasvaloracion.setIdherramienta(
                herramientaValoracionDTO.getIdHerramienta());
        herramientasvaloracion.setNombreherramienta(
                herramientaValoracionDTO.getNombreHerramienta());
        herramientasvaloracion.setDescripcion(
                herramientaValoracionDTO.getDescripcion());
        return herramientasvaloracion;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param preguntaTemaDTO DTO.
     * @return Entidad.
     */
    public static Preguntas dtoPreguntaTemaToPreguntaTema(
            PreguntasTemaDTO preguntaTemaDTO) {
        Preguntas pregunta = new Preguntas();
        pregunta.setIdpregunta(preguntaTemaDTO.getIdpregunta());
        if (preguntaTemaDTO.getTemaEvaluacionDTO() != null) {
            pregunta.setTemasevaluacion(dtoTemaEvaluacionToTemaEvaluacion(
                    preguntaTemaDTO.getTemaEvaluacionDTO()));
        }
        if (preguntaTemaDTO.getCajaCompensacionDTO() != null) {
            pregunta.setCajacompensacion(dtoCajaCompensacionToCajaCompensacion(
                    preguntaTemaDTO.getCajaCompensacionDTO()));
        }
        if (preguntaTemaDTO.getHerramientaValoracionDTO() != null) {
            pregunta.setHerramientasvaloracion(
                    dtoHerramientasValoracionToHerramientasValoracion(
                            preguntaTemaDTO.getHerramientaValoracionDTO()));
        }

        pregunta.setTextopregunta(preguntaTemaDTO.getTextopregunta());
        pregunta.setFecharegistro(preguntaTemaDTO.getFecharegistro());
        return pregunta;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param funcionarioDTO DTO.
     * @return Entidad.
     */
    public static Funcionario dtoFuncionarioToFuncionario(
            FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();

        funcionario.setPrimerapellido(funcionarioDTO.getPrimerapellido());
        funcionario.setSegundoapellido(funcionarioDTO.getSegundoapellido());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setPrimernombre(funcionarioDTO.getPrimernombre());
        funcionario.setSegundonombre(funcionarioDTO.getSegundonombre());
        funcionario.setTelefono(funcionarioDTO.getTelefono());
        funcionario.setNumerodocumento(funcionarioDTO.getNumerodocumento());
        funcionario.setIdfuncionario(funcionarioDTO.getIdfuncionario());
        return funcionario;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param integranteComiteDTO DTO.
     * @return Entidad.
     */
    public static Integrantescomite dtoIntegranteComiteToIntegranteComite(
            IntegrantescomiteDTO integranteComiteDTO) {
        Integrantescomite integranteComite = new Integrantescomite();
        integranteComite.setIdintegrante(
                integranteComiteDTO.getIdintegrantes());
        integranteComite.setFuncionario(dtoFuncionarioToFuncionario(
                integranteComiteDTO.getFuncionario()));
        integranteComite.setComiteevaluacion(
                dtoComiteEvalacionToComiteEvaluacion(integranteComiteDTO
                        .getComiteevaluacion()));
        integranteComite.setFecharegistro(
                integranteComiteDTO.getFecharegistro());
        return integranteComite;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param userDTO DTO.
     * @return Entidad.
     */
    public static Users dtoUserToUsers(UsersDTO userDTO) {
        Users user = new Users();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param sesionesDTO DTO.
     * @return Entidad.
     */
    public static Sesiones dtoSesionesToSesiones(SesionesDTO sesionesDTO) {
        Sesiones sesiones = new Sesiones();
        sesiones.setDescripcion(sesionesDTO.getDescripcion());
        sesiones.setUbicacion(sesionesDTO.getUbicacion());
        if (sesionesDTO.getEstadosesion() != null) {
            sesiones.setEstadosesion(new Estadosesion(
                    sesionesDTO.getEstadosesion().getIdestadosesion()));
        }
        if (sesionesDTO.getFuncionario() != null) {
            sesiones.setFuncionario(new Funcionario(
                    sesionesDTO.getFuncionario().getIdfuncionario()));
        }
        sesiones.setIdsesion(sesionesDTO.getIdsesion());
        sesiones.setMaxAsistentes(sesionesDTO.getMaxAsistentes());

        return sesiones;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param listaasistenciaDTO DTO.
     * @return Entidad.
     */
    public static Listaasistencia dtoListaasistenciaToListaasistencia(
            ListaasistenciaDTO listaasistenciaDTO) {
        Listaasistencia lista = new Listaasistencia();
        lista.setBeneficiario(dtoBeneficiarioToBeneficiario(
                listaasistenciaDTO.getBeneficiario()));
        lista.setSesiones(dtoSesionesToSesiones(
                listaasistenciaDTO.getSesiones()));
        lista.setIdasistencia(listaasistenciaDTO.getIdasistencia());
        lista.setRegistroasistencia(listaasistenciaDTO.getRegistroasistencia());
        lista.setIdasistencia(listaasistenciaDTO.getIdasistencia());
        lista.setJustificacioninasistencia(
                listaasistenciaDTO.getJustificacionInasistencia());
        return lista;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param sesionAATDTO DTO.
     * @return Entidad.
     */
    public static Sesionacompanamientoat dtoSesionAATToSesionAAT(
            SesionacompanamientoatDTO sesionAATDTO) {
        Sesionacompanamientoat sesionAAT = new Sesionacompanamientoat();
        sesionAAT.setIdsesionacompanamientoat(
                sesionAATDTO.getIdsesionacompanamientoat());
        if (sesionAATDTO.getRutaacompanamientoat() != null) {
            sesionAAT.setRutaacompanamientoat(dtoRutaAATToRutaAAT(
                    sesionAATDTO.getRutaacompanamientoat()));
        }
        if (sesionAATDTO.getTemasrutaacompanamientoat() != null) {
            sesionAAT.setTemasrutaacompanamientoat(dtoTemaAATToTemaAAT(
                    sesionAATDTO.getTemasrutaacompanamientoat()));
        }
        if (sesionAATDTO.getEstadosesion() != null) {
            sesionAAT.setEstadosesion(dtoEstadoSesionToEstadoSesion(
                    sesionAATDTO.getEstadosesion()));
        }
        if (sesionAATDTO.getFuncionario() != null) {
            sesionAAT.setFuncionario(dtoFuncionarioToFuncionario(
                    sesionAATDTO.getFuncionario()));
        }
        sesionAAT.setObservaciones(sesionAATDTO.getObservaciones());
        sesionAAT.setFechainicio(sesionAATDTO.getFechainicio());
        sesionAAT.setFechafinal(sesionAATDTO.getFechafinal());
        sesionAAT.setFecharegistro(sesionAATDTO.getFecharegistro());
        sesionAAT.setUbicacion(sesionAATDTO.getUbicacion());

        return sesionAAT;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param estadoSesionDTO DTO.
     * @return Entidad.
     */
    public static Estadosesion dtoEstadoSesionToEstadoSesion(
            EstadosesionDTO estadoSesionDTO) {
        Estadosesion estadoSesion = new Estadosesion();
        estadoSesion.setIdestadosesion(estadoSesionDTO.getIdestadosesion());
        estadoSesion.setNombreestadosesion(
                estadoSesionDTO.getNombreestadosesion());
        estadoSesion.setDescripcion(estadoSesionDTO.getDescripcion());
        return estadoSesion;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param rutaAATDTO DTO.
     * @return Entidad.
     */
    public static Rutaacompanamientoat dtoRutaAATToRutaAAT(
            RutaacompanamientoatDTO rutaAATDTO) {
        Rutaacompanamientoat rutaAAT = new Rutaacompanamientoat();
        rutaAAT.setIdrutaacompanamientoat(
                rutaAATDTO.getIdrutaacompanamientoat());
        if (rutaAATDTO.getEmprendimiento() != null) {
            rutaAAT.setEmprendimiento(dtoEmprendimientoToEmprendimiento(
                    rutaAATDTO.getEmprendimiento()));
        }

        rutaAAT.setFecharegistro(rutaAATDTO.getFecharegistro());
        return rutaAAT;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param temaRutaAATDTO DTO.
     * @return Entidad.
     */
    public static Temasrutaacompanamientoat dtoTemaAATToTemaAAT(
            TemasrutaacompanamientoatDTO temaRutaAATDTO) {
        Temasrutaacompanamientoat temaRutaATT = new Temasrutaacompanamientoat();
        temaRutaATT.setIdtemarutaacompanamientoat(
                temaRutaAATDTO.getIdtemarutaacompanamientoat());
        if (temaRutaAATDTO.getRutaacompanamientoat() != null) {
            temaRutaATT.setRutaacompanamientoat(dtoRutaAATToRutaAAT(
                    temaRutaAATDTO.getRutaacompanamientoat()));
        }
        if (temaRutaAATDTO.getTemasevaluacion() != null) {
            temaRutaATT.setTemasevaluacion(dtoTemaEvaluacionToTemaEvaluacion(
                    temaRutaAATDTO.getTemasevaluacion()));
        }
        temaRutaATT.setDescripciondocumento(
                temaRutaAATDTO.getDescripciondocumento());
        temaRutaATT.setCantidadhorasplaneadas(
                temaRutaAATDTO.getCantidadhorasplaneadas());
        temaRutaATT.setDescripciondocumento(
                temaRutaAATDTO.getDescripciondocumento());
        temaRutaATT.setUrldocumentotema(temaRutaAATDTO.getUrldocumentotema());
        temaRutaATT.setFecharegistro(temaRutaAATDTO.getFecharegistro());
        return temaRutaATT;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param lAATDTO DTO.
     * @return Entidad.
     */
    public static Listaasistenciaaat dtoListaATTTOListaATT(
            ListaasistenciaaatDTO lAATDTO) {
        Listaasistenciaaat listaATT = new Listaasistenciaaat();
        listaATT.setIdasistenciaacompanamientoat(
                lAATDTO.getIdasistacompanamientoat());
        if (lAATDTO.getBeneficiario() != null) {
            listaATT.setBeneficiario(dtoBeneficiarioToBeneficiario(
                    lAATDTO.getBeneficiario()));
        }
        if (lAATDTO.getSesionacompanamientoat() != null) {
            listaATT.setSesionacompanamientoat(dtoSesionAATToSesionAAT(
                    lAATDTO.getSesionacompanamientoat()));
        }

        listaATT.setJustificacioninasistencia(
                lAATDTO.getJustificacioninasistencia());
        listaATT.setRegistroasistencia(lAATDTO.getRegistroasistencia());
        listaATT.setFecharegistro(lAATDTO.getFecharegistro());
        return listaATT;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param temasDTO DTO.
     * @return Entidad.
     */
    public static Temasrutacapacitacion
            temasRutaCapDtoToTemasRutaCap(
                    TemasrutacapacitacionDTO temasDTO) {
        Temasrutacapacitacion temas = new Temasrutacapacitacion();
        temas.setCantidadhorasplaneadas(temasDTO.getCantidadhorasplaneadas());
        temas.setIdtemarutacapacitacion(temasDTO.getIdtemarutacapacitacion());
        temas.setNombretema(temasDTO.getNombretema());
        temas.setRutacapacitacion(rutaCapacitacionToRutaCapacitacionDTO(
                temasDTO.getRutacapacitacion()));
        return temas;
    }

    /**
     * Método para transformar una lista de DTO a lista de Entidad.
     *
     * @param temasDTO Lista de DTOs.
     * @return Lista de Entidades.
     */
    public static List<Temasrutacapacitacion>
            listaTemasRutaCapacitacionDTOToListaTemasRutaCapacitacion(
                    List<TemasrutacapacitacionDTO> temasDTO) {
        List<Temasrutacapacitacion> temas = new ArrayList();
        for (TemasrutacapacitacionDTO t : temasDTO) {
            Temasrutacapacitacion tema
                    = temasRutaCapDtoToTemasRutaCap(t);
            temas.add(tema);
        }
        return temas;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param rutaDTO DTO.
     * @return Entidad.
     */
    public static Rutacapacitacion rutaCapacitacionToRutaCapacitacionDTO(
            RutacapacitacionDTO rutaDTO) {
        Rutacapacitacion ruta = new Rutacapacitacion();
        ruta.setIdrutacapacitacion(rutaDTO.getIdrutacapacitacion());

        return ruta;
    }

    /**
     * Método para transformar una lista de DTO a lista de Entidad.
     *
     * @param temasDTO Lista de DTOs.
     * @return Lista de Entidades.
     */
    public static List<Temasrutaacompanamientoat>
            listaTemasRutaAcompanamientoatDTOToListaTemasRutaAcompanamientoat(
                    List<TemasrutaacompanamientoatDTO> temasDTO) {
        List<Temasrutaacompanamientoat> temas = new ArrayList();
        for (TemasrutaacompanamientoatDTO t : temasDTO) {
            Temasrutaacompanamientoat tema = dtoTemaAATToTemaAAT(t);
            temas.add(tema);
        }
        return temas;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param temaRutaAATDTO DTO.
     * @return Entidad.
     */
    public static Temasrutaacompanamientoat dtoTemaAAT2ToTemaAAT2(
            TemasrutaacompanamientoatDTO temaRutaAATDTO) {
        Temasrutaacompanamientoat temaRutaATT = new Temasrutaacompanamientoat();
        temaRutaATT.setIdtemarutaacompanamientoat(
                temaRutaAATDTO.getIdtemarutaacompanamientoat());
        temaRutaATT.setRutaacompanamientoat(dtoRutaAATToRutaAAT(
                temaRutaAATDTO.getRutaacompanamientoat()));
        temaRutaATT.setTemasevaluacion(dtoTemaEvaluacionToTemaEvaluacionNombre(
                temaRutaAATDTO.getTemasevaluacion()));

        temaRutaATT.setCantidadhorasplaneadas(
                temaRutaAATDTO.getCantidadhorasplaneadas());

        temaRutaATT.setFecharegistro(temaRutaAATDTO.getFecharegistro());
        return temaRutaATT;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param temasEvaluacionDTO DTO.
     * @return Entidad.
     */
    public static Temasevaluacion dtoTemaEvaluacionToTemaEvaluacionNombre(
            TemasEvaluacionDTO temasEvaluacionDTO) {
        Temasevaluacion temasevaluacion = new Temasevaluacion();

        temasevaluacion.setNombretema(temasEvaluacionDTO.getNombretema());
        temasevaluacion.setIdtema(temasEvaluacionDTO.getIdtema());
        return temasevaluacion;
    }

    /**
     * Método para transformar una lista de DTO a lista de Entidad.
     *
     * @param temasDTO Lista de DTOs.
     * @return Lista de Entidades.
     */
    public static List<Temasrutaacompanamientoat>
            listaTemasRutaAcompanamientoatDTO2ToListaTemasRutaAcompanamientoat2(
                    List<TemasrutaacompanamientoatDTO> temasDTO) {
        List<Temasrutaacompanamientoat> temas = new ArrayList();
        for (TemasrutaacompanamientoatDTO t : temasDTO) {
            Temasrutaacompanamientoat tema = dtoTemaAAT2ToTemaAAT2(t);
            temas.add(tema);
        }
        return temas;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param estadoEmprendimientoDTO DTO.
     * @return Entidad.
     */
    public static Estadoemprendimiento
            dtoEstadoEmprendimientoToEstadoEmprendimiento(
                    EstadoemprendimientoDTO estadoEmprendimientoDTO) {
        Estadoemprendimiento estadoEmprendimiento = new Estadoemprendimiento();
        estadoEmprendimiento.setIdestadoemprendimiento(
                estadoEmprendimientoDTO.getIdestadoemprendimiento());
        estadoEmprendimiento.setNombreestadoemprendimiento(
                estadoEmprendimientoDTO.getNombreestadoemprendimiento());
        estadoEmprendimiento.setDescripcion(
                estadoEmprendimientoDTO.getDescripcion());
        return estadoEmprendimiento;
    }

    /**
     * Método para transformar un DTO a Entidad.
     *
     * @param tipoDocumentosDTO DTO.
     * @return Entidad.
     */
    public static Tipodocumentos dtoTipoDocumentosToTipoDocumento(
            TipodocumentosDTO tipoDocumentosDTO) {
        Tipodocumentos tipoDocumentos = new Tipodocumentos();
        tipoDocumentos.setIdtipodocumento(
                tipoDocumentosDTO.getIdtipodocumento());
        tipoDocumentos.setNombretipodocumento(
                tipoDocumentosDTO.getNombretipodocumento());
        tipoDocumentos.setDescripcion(tipoDocumentosDTO.getDescripcion());
        return tipoDocumentos;
    }

    /**
     * Método para transformar una lista de DTO a lista de Entidad.
     *
     * @param list Lista de DTOs.
     * @return Lista de Entidades.
     */
    public static List<Configuracion> listDtoConfiguracionTolistConfiguracion(
            List<ConfiguracionDTO> list) {
        List<Configuracion> dto = new ArrayList<>();
        for (ConfiguracionDTO c : list) {
            Configuracion conf = new Configuracion(c.getIdconfiguracion(),
                    c.getNombreconfiguracion(), c.getFechamodificacion(),
                    c.getValor());
            dto.add(conf);
        }
        return dto;
    }
}
