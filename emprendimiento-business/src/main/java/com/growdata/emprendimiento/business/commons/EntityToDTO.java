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
import com.growdata.emprendimiento.business.dtos.intentodto.CajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.EntidadesfinancierasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocajacompensacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadofuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.GestionarFuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.HerramientaValoracionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.PreguntasTemaDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import com.growdata.emprendimiento.business.dtos.parametrizacion.TraerEntidadesFinancierasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupMembersDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.GroupsDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.TipodocumentoidDTO;
import com.growdata.emprendimiento.business.dtos.valoracion.TemasvaloracionindividualDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ActividadInternacionalDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AlumnosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AprobacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AsociadosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CapacitacionprogramaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CategoriaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ComiteevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ConfiguracionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DepartamentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocentesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadocapacitacionprogramaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadodocenteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadoemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EvaluacionemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EvaluacionintegrantescomiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.IntegrantescomiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FinanciacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FormalizadoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.InstitucionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.LogauditoriaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ModulocicloDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.MunicipiosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.NoestablecidoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PaisesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PaisescomercializaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ProgramacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.RutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SectorproductivoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SedesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SeguimientoasistenciaDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesioncomiteDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.SesionesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasevaluacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoconstitucionlegalDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipodocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoemprendimientoDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipofinanciacionDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TipoprioridadDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.UsersDTO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Aprobacion;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Cajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Capacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.entidad.Docentes;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Entidadesfinancieras;
import com.growdata.emprendimiento.persistence.entidad.Estadocapacitacionprograma;
import com.growdata.emprendimiento.persistence.entidad.Estadodocente;
import com.growdata.emprendimiento.persistence.entidad.Estadocajacompensacion;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadofuncionario;
import com.growdata.emprendimiento.persistence.entidad.Estadosesion;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionemprendimientos;
import com.growdata.emprendimiento.persistence.entidad.Evaluacionintegrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Groups;
import com.growdata.emprendimiento.persistence.entidad.Herramientasvaloracion;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.Logauditoria;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.persistence.entidad.Paisescomercializa;
import com.growdata.emprendimiento.persistence.entidad.Preguntas;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Rutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Sectorproductivo;
import com.growdata.emprendimiento.persistence.entidad.Seguimientoasistencia;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Temasvaloracionindividual;
import com.growdata.emprendimiento.persistence.entidad.Tipoconstitucionlegal;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentoid;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentos;
import com.growdata.emprendimiento.persistence.entidad.Tipoemprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Tipofinanciacion;
import com.growdata.emprendimiento.persistence.entidad.Tipoprioridad;
import com.growdata.emprendimiento.persistence.entidad.Users;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Departamentos;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Instituciones;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Municipios;
import com.growdata.emprendimiento.persistence.entidadSIMPC.Sedes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase responsable de transformar una entidad a un DTO.
 *
 * @author Juan Franco
 */
public class EntityToDTO {

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param preguntas Entidad.
     * @return DTO.
     */
    public static PreguntasDTO preguntasToPreguntasDTO(Preguntas preguntas) {
        PreguntasDTO preguntasdto = new PreguntasDTO();
        preguntasdto.setIdpregunta(preguntas.getIdpregunta());
        preguntasdto.setTextopregunta(preguntas.getTextopregunta());
        preguntasdto.setTemasevaluacion(temasEvaluacionToTemasEvaluacionDTO(
                preguntas.getTemasevaluacion()));
        return preguntasdto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param preguntas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<PreguntasDTO> listaPreguntasToListaPreguntasDTO(
            List<Preguntas> preguntas) {
        List<PreguntasDTO> preguntasDTO = new ArrayList();
        for (Preguntas pregunta : preguntas) {
            PreguntasDTO preguntaDTO = preguntasToPreguntasDTO(pregunta);
            preguntasDTO.add(preguntaDTO);
        }
        return preguntasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param entidades Entidad.
     * @return DTO.
     */
    public static TraerEntidadesFinancierasDTO
            entidadesFinancierasToTraerEntidadesFinancierasDTO(
                    Entidadesfinancieras entidades) {
        TraerEntidadesFinancierasDTO entidadesDTO
                = new TraerEntidadesFinancierasDTO();
        entidadesDTO.setNombreentidad(entidades.getNombreentidad());
        entidadesDTO.setDescripcion(entidades.getDescripcion());
        entidadesDTO.setEstado(entidades.getEstado());
        entidadesDTO.setFecharegistro(entidades.getFecharegistro());
        entidadesDTO.setIdentidadfinanciera(entidades.getIdentidadfinanciera());
        return entidadesDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param entidades Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TraerEntidadesFinancierasDTO>
            listaEntidadesFinancierasToListaTraerEntidadesFinancierasDTO(
                    List<Entidadesfinancieras> entidades) {
        List<TraerEntidadesFinancierasDTO> entidadesDTO = new ArrayList();
        for (Entidadesfinancieras entidad : entidades) {
            TraerEntidadesFinancierasDTO entidadDTO
                    = entidadesFinancierasToTraerEntidadesFinancierasDTO(
                            entidad);
            entidadesDTO.add(entidadDTO);
        }
        return entidadesDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param caja Entidad.
     * @return DTO.
     */
    public static CajacompensacionDTO cajaCompensacionToCajaCompensacionDTO(
            Cajacompensacion caja) {
        CajacompensacionDTO cajaDTO = new CajacompensacionDTO();
        cajaDTO.setCodigoccf(caja.getCodigoccf());
        cajaDTO.setEstadocajacompensacion(estadoCajaToEstadoCajaDTO(
                caja.getEstadocajacompensacion()));
        cajaDTO.setFecharegistro(caja.getFecharegistro());
        cajaDTO.setNombrecajacompensacion(caja.getNombrecajacompensacion());
        cajaDTO.setIdcajacompensacion(caja.getIdcajacompensacion());
        cajaDTO.setDepartamento(caja.getDepartamento());
        return cajaDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estado Entidad.
     * @return DTO.
     */
    public static EstadocajacompensacionDTO estadoCajaToEstadoCajaDTO(
            Estadocajacompensacion estado) {
        EstadocajacompensacionDTO estadoDTO = new EstadocajacompensacionDTO();
        estadoDTO.setIdestadocajacompensacion(
                estado.getIdestadocajacompensacion());
        estadoDTO.setDescripcion(estado.getDescripcion());
        estadoDTO.setNombreestadocaja(estado.getNombreestadocaja());
        return estadoDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param cajas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<CajacompensacionDTO>
            listaCajaCompensacionToListaCajaCompensacionDTO(
                    List<Cajacompensacion> cajas) {
        List<CajacompensacionDTO> cajasDTO = new ArrayList();
        for (Cajacompensacion caja : cajas) {
            CajacompensacionDTO cajaDTO
                    = cajaCompensacionToCajaCompensacionDTO(caja);
            cajasDTO.add(cajaDTO);
        }
        return cajasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param caja Entidad.
     * @return DTO.
     */
    public static GestionarFuncionarioDTO
            cajaCompensacionTogestionarFuncionarioDTO(Cajacompensacion caja) {
        GestionarFuncionarioDTO funciDTO = new GestionarFuncionarioDTO();
        funciDTO.setNombrecajacompensacion(caja.getNombrecajacompensacion());
        funciDTO.setIdcajacompensacion(caja.getIdcajacompensacion());
        return funciDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param cajas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<GestionarFuncionarioDTO>
            listaCajaCompensacionTolistaGestionarFuncionarioDTO(
                    List<Cajacompensacion> cajas) {
        List<GestionarFuncionarioDTO> funcisDTO = new ArrayList();
        for (Cajacompensacion caja : cajas) {
            GestionarFuncionarioDTO funciDTO
                    = cajaCompensacionTogestionarFuncionarioDTO(caja);
            funcisDTO.add(funciDTO);
        }
        return funcisDTO;

    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param herramientasValoracion Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<HerramientaValoracionDTO>
            listaHerramientasValoracionToListaTraerHerramientasValoracionDTO(
                    List<Herramientasvaloracion> herramientasValoracion) {
        List<HerramientaValoracionDTO> herramientasValoracionDTO
                = new ArrayList();
        for (Herramientasvaloracion herramientaValoracion
                : herramientasValoracion) {
            HerramientaValoracionDTO herramientaValoracionDTO
                    = herramientaValoracionToHerramientaValoracionDTO(
                            herramientaValoracion);
            herramientasValoracionDTO.add(herramientaValoracionDTO);
        }
        return herramientasValoracionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param herramientaValoracion Entidad.
     * @return DTO.
     */
    public static HerramientaValoracionDTO
            herramientaValoracionToHerramientaValoracionDTO(
                    Herramientasvaloracion herramientaValoracion) {
        HerramientaValoracionDTO herramientaValoracionDTO
                = new HerramientaValoracionDTO();
        herramientaValoracionDTO.setIdHerramienta(
                herramientaValoracion.getIdherramienta());
        herramientaValoracionDTO.setNombreHerramienta(
                herramientaValoracion.getNombreherramienta());
        herramientaValoracionDTO.setDescripcion(
                herramientaValoracion.getDescripcion());
        return herramientaValoracionDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param temasEvaluacion Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TemasEvaluacionDTO>
            listaTemasEvaluacionToListaTemasEvaluacionDTO(
                    List<Temasevaluacion> temasEvaluacion) {
        List<TemasEvaluacionDTO> temasEvaluacionDTO = new ArrayList();
        for (Temasevaluacion temaEvaluacion : temasEvaluacion) {
            TemasEvaluacionDTO temaEvaluacionDTO
                    = traerTemasPorCajaYHerramientaDTO(temaEvaluacion);
            temasEvaluacionDTO.add(temaEvaluacionDTO);
        }
        return temasEvaluacionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temaEvaluacion Entidad.
     * @return DTO.
     */
    public static TemasEvaluacionDTO traerTemasPorCajaYHerramientaDTO(
            Temasevaluacion temaEvaluacion) {
        TemasEvaluacionDTO temasEvaluacionDTO = new TemasEvaluacionDTO();
        temasEvaluacionDTO.setIdtema(temaEvaluacion.getIdtema());
        temasEvaluacionDTO.setNombretema(temaEvaluacion.getNombretema());
        temasEvaluacionDTO.setFecharegistro(temaEvaluacion.getFecharegistro());
        temasEvaluacionDTO.setDescripcion(temaEvaluacion.getDescripcion());
        temasEvaluacionDTO.setEstado(temaEvaluacion.getEstado());
        return temasEvaluacionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temaEvaluacion Entidad.
     * @return DTO.
     */
    public static TemasEvaluacionDTO traerTemaEvaluacionDTO(
            Temasevaluacion temaEvaluacion) {
        TemasEvaluacionDTO temasEvaluacionDTO = new TemasEvaluacionDTO();
        temasEvaluacionDTO.setIdtema(temaEvaluacion.getIdtema());
        temasEvaluacionDTO.setCajaCompensacionDTO(
                cajaCompensacionToCajaCompensacionDTO(
                        temaEvaluacion.getCajacompensacion()));
        temasEvaluacionDTO.setHerramientaValoracionDTO(
                herramientaValoracionToHerramientaValoracionDTO(
                        temaEvaluacion.getHerramientasvaloracion()));
        temasEvaluacionDTO.setNombretema(temaEvaluacion.getNombretema());
        temasEvaluacionDTO.setDescripcion(temaEvaluacion.getDescripcion());
        temasEvaluacionDTO.setFecharegistro(temaEvaluacion.getFecharegistro());
        temasEvaluacionDTO.setHorasbasico(temaEvaluacion.getHorasbasico());
        temasEvaluacionDTO.setCalificacionbasico(
                temaEvaluacion.getCalificacionbasico());
        temasEvaluacionDTO.setHorasintermedio(
                temaEvaluacion.getHorasintermedio());
        temasEvaluacionDTO.setCalificacionintermedio(
                temaEvaluacion.getCalificacionintermedio());
        temasEvaluacionDTO.setHorasavanzado(temaEvaluacion.getHorasavanzado());
        temasEvaluacionDTO.setCalificacionavanzado(
                temaEvaluacion.getCalificacionavanzado());
        temasEvaluacionDTO.setRequieredocumento(
                temaEvaluacion.getRequieredocumento());
        temasEvaluacionDTO.setEstado(temaEvaluacion.getEstado());
        return temasEvaluacionDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param preguntas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<PreguntasTemaDTO>
            listaPreguntasToListaPreguntasHerramientaDTO(
                    List<Preguntas> preguntas) {
        List<PreguntasTemaDTO> preguntasDTO = new ArrayList();
        for (Preguntas pregunta : preguntas) {
            PreguntasTemaDTO preguntaDTO
                    = traerPreguntaXTemaHerramientaCajaDTO(pregunta);
            preguntasDTO.add(preguntaDTO);
        }
        return preguntasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param pregunta Entidad.
     * @return DTO.
     */
    public static PreguntasTemaDTO traerPreguntaXTemaHerramientaCajaDTO(
            Preguntas pregunta) {
        PreguntasTemaDTO preguntaDTO = new PreguntasTemaDTO();
        preguntaDTO.setIdpregunta(pregunta.getIdpregunta());
        preguntaDTO.setCajaCompensacionDTO(
                cajaCompensacionToCajaCompensacionDTO(
                        pregunta.getCajacompensacion()));
        preguntaDTO.setHerramientaValoracionDTO(
                herramientaValoracionToHerramientaValoracionDTO(
                        pregunta.getHerramientasvaloracion()));
        preguntaDTO.setTemaEvaluacionDTO(traerTemaEvaluacionDTO(
                pregunta.getTemasevaluacion()));
        preguntaDTO.setTextopregunta(pregunta.getTextopregunta());
        preguntaDTO.setFecharegistro(pregunta.getFecharegistro());
        return preguntaDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param funcionario Entidad.
     * @return DTO.
     */
    public static FuncionarioDTO funcionarioToFuncionarioDTOShort(
            Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setIdfuncionario(funcionario.getIdfuncionario());
        funcionarioDTO.setCajacompensacion(
                cajaCompensacionToCajaCompensacionDTO(
                        funcionario.getCajacompensacion()));
        return funcionarioDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param sesion Entidad.
     * @return DTO.
     */
    public static SesionesDTO sesionesToSesionesDTO(Sesiones sesion) {
        SesionesDTO sesionesDTO = new SesionesDTO();
        sesionesDTO.setIdsesion(sesion.getIdsesion());
        sesionesDTO.setFechafinal(sesion.getFechafinal());
        sesionesDTO.setFechainicio(sesion.getFechainicio());
        sesionesDTO.setFecharegistro(sesion.getFecharegistro());
        sesionesDTO.setDescripcion(sesion.getDescripcion());
        sesionesDTO.setUbicacion(sesion.getUbicacion());
        sesionesDTO.setMaxAsistentes(sesion.getMaxAsistentes());
        sesionesDTO.setFuncionario(funcionarioToFuncionarioDTO(
                sesion.getFuncionario()));
        sesionesDTO.setEstadosesion(estadoSesionToEstadoSesionDTO(
                sesion.getEstadosesion()));
        return sesionesDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estado Entidad.
     * @return DTO.
     */
    public static EstadosesionDTO estadoSesionToEstadoSesionDTO(
            Estadosesion estado) {
        EstadosesionDTO estadoDTO = new EstadosesionDTO();
        estadoDTO.setDescripcion(estado.getDescripcion());
        estadoDTO.setNombreestadosesion(estado.getNombreestadosesion());
        estadoDTO.setIdestadosesion(estado.getIdestadosesion());
        return estadoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param user Entidad.
     * @return DTO.
     */
    public static UsersDTO userToUserDTO(Users user) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setIduser(user.getIduser());
        usersDTO.setUsername(user.getUsername());
        usersDTO.setFecharegistro(user.getFecharegistro());
        Set<GroupMembersDTO> groupMemberses = new HashSet<GroupMembersDTO>(0);
        for (GroupMembers g : user.getGroupMemberses()) {
            groupMemberses.add(
                    EntityToDTO.groupMembersToGroupMembersDTOLight(g));
        }
        usersDTO.setGroupMemberses(groupMemberses);
        return usersDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estado Entidad.
     * @return DTO.
     */
    public static EstadofuncionarioDTO estadoFuncionarioToEstadoFuncionarioDTO(
            Estadofuncionario estado) {
        EstadofuncionarioDTO estadoDTO = new EstadofuncionarioDTO();
        estadoDTO.setDescripcion(estado.getDescripcion());
        estadoDTO.setIdestadofuncionario(estado.getIdestadofuncionario());
        estadoDTO.setNombreestado(estado.getNombreestado());

        return estadoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param funcionario Entidad.
     * @return DTO.
     */
    public static FuncionarioDTO funcionarioToFuncionarioDTO(
            Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setPrimerapellido(funcionario.getPrimerapellido());
        funcionarioDTO.setSegundoapellido(funcionario.getSegundoapellido());
        funcionarioDTO.setEmail(funcionario.getEmail());
        funcionarioDTO.setFecharegistro(funcionario.getFecharegistro());
        funcionarioDTO.setIdfuncionario(funcionario.getIdfuncionario());
        funcionarioDTO.setTipodocumentoid(tipoDocumentoIdToTipoDocumentoDTO(
                funcionario.getTipodocumentoid()));

        funcionarioDTO.setPrimernombre(funcionario.getPrimernombre());
        funcionarioDTO.setSegundonombre(funcionario.getSegundonombre());
        funcionarioDTO.setTelefono(funcionario.getTelefono());
        funcionarioDTO.setNumerodocumento(funcionario.getNumerodocumento());
        funcionarioDTO.setUsers(EntityToDTO.userToUserDTO(
                funcionario.getUsers()));
        funcionarioDTO.setCajacompensacion(
                cajaCompensacionToCajaCompensacionDTO(
                        funcionario.getCajacompensacion()));
        funcionarioDTO.setEstadofuncionario(
                estadoFuncionarioToEstadoFuncionarioDTO(
                        funcionario.getEstadofuncionario()));
        return funcionarioDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param groups Entidad.
     * @return DTO.
     */
    public static GroupsDTO groupsToGroupsDTO(Groups groups) {
        GroupsDTO groupsDTO = new GroupsDTO();
        groupsDTO.setGroupName(groups.getGroupName());
        groupsDTO.setId(groups.getId());

        return groupsDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param groups Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<GroupsDTO> listaGroupsToGroupsDTO(List<Groups> groups) {
        List<GroupsDTO> groupsDTO = new ArrayList();
        for (Groups group : groups) {
            GroupsDTO gDTO = groupsToGroupsDTO(group);
            groupsDTO.add(gDTO);
        }
        return groupsDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipoD Entidad.
     * @return DTO.
     */
    public static TipodocumentoidDTO tipoDocumentoIdToTipoDocumentoDTO(
            Tipodocumentoid tipoD) {
        TipodocumentoidDTO tipoDDTO = new TipodocumentoidDTO();
        tipoDDTO.setIdtipodocumento(tipoD.getIdtipodocumento());
        tipoDDTO.setDescripcion(tipoD.getDescripcion());
        tipoDDTO.setNombredocumento(tipoD.getNombredocumento());
        return tipoDDTO;
    }

    public static List<TipodocumentoidDTO>
            listaTipoDocumendoIdToListaTipoDocumentoDTO(
                    List<Tipodocumentoid> tiposD) {
        List<TipodocumentoidDTO> tiposDDTO = new ArrayList();
        for (Tipodocumentoid tipo : tiposD) {
            TipodocumentoidDTO tipoDTO
                    = tipoDocumentoIdToTipoDocumentoDTO(tipo);
            tiposDDTO.add(tipoDTO);
        }

        return tiposDDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param gm Entidad.
     * @return DTO.
     */
    public static GroupMembersDTO groupMembersToGroupMembersDTO(
            GroupMembers gm) {
        GroupMembersDTO gmDTO = new GroupMembersDTO();
        gmDTO.setId(gm.getId());
        gmDTO.setGroups(groupsToGroupsDTO(gm.getGroups()));
        gmDTO.setUsers(userToUserDTO(gm.getUsers()));
        return gmDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param gm Entidad.
     * @return DTO.
     */
    public static GroupMembersDTO groupMembersToGroupMembersDTOLight(
            GroupMembers gm) {
        GroupMembersDTO gmDTO = new GroupMembersDTO();
        gmDTO.setId(gm.getId());
        gmDTO.setGroups(groupsToGroupsDTO(gm.getGroups()));
//        gmDTO.setUsers(userToUserDTO(gm.getUsers()));
        return gmDTO;
    }

    public static List<FuncionarioDTO>
            listaTraerUsuariosComiteLibresToTraerUsuariosComiteLibresDTO(
                    List<Funcionario> funcionarios) {
        List<FuncionarioDTO> funcionariosDTO = new ArrayList();
        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO
                    = funcionarioToFuncionarioDTO(funcionario);
            funcionariosDTO.add(funcionarioDTO);
        }
        return funcionariosDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param comiteEvaluacion Entidad.
     * @return DTO.
     */
    public static ComiteevaluacionDTO comiteEvaluacionToComiteEvaluacionDTO(
            Comiteevaluacion comiteEvaluacion) {
        ComiteevaluacionDTO comiteEvaluacionDTO = new ComiteevaluacionDTO();
        comiteEvaluacionDTO.setIdcomite(comiteEvaluacion.getIdcomite());
        comiteEvaluacionDTO.setCajacompensacion(
                cajaCompensacionToCajaCompensacionDTO(
                        comiteEvaluacion.getCajacompensacion()));
        comiteEvaluacionDTO.setNombrecomite(comiteEvaluacion.getNombrecomite());
        comiteEvaluacionDTO.setDescripcion(comiteEvaluacion.getDescripcion());
        comiteEvaluacionDTO.setFecharegistro(
                comiteEvaluacion.getFecharegistro());
        Set<IntegrantescomiteDTO> integrantescomites
                = new HashSet<IntegrantescomiteDTO>(0);

        for (Integrantescomite i : comiteEvaluacion.getIntegrantescomites()) {
            integrantescomites.add(
                    EntityToDTO.integrantesComiteToIntegrantesComiteDTO(i));
        }
        comiteEvaluacionDTO.setIntegrantescomites(integrantescomites);
        return comiteEvaluacionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param beneficiario Entidad.
     * @return DTO.
     */
    public static BeneficiarioDTO beneficiarioToBeneficiarioDto(
            Beneficiario beneficiario) {
        BeneficiarioDTO beneDTO = new BeneficiarioDTO();
        beneDTO.setIdbeneficiario(beneficiario.getIdbeneficiario());
        beneDTO.setUsers(beneficiario.getUsers());
        beneDTO.setFecharegistro(beneficiario.getFecharegistro());
        beneDTO.setPrimerapellido(beneficiario.getPrimerapellido());
        beneDTO.setSegundoapellido(beneficiario.getSegundoapellido());
        beneDTO.setEmail(beneficiario.getEmail());
        beneDTO.setTelefono(beneficiario.getTelefono());
        beneDTO.setNumerodocumento(beneficiario.getNumerodocumento());
        beneDTO.setIdbeneficiario(beneficiario.getIdbeneficiario());
        beneDTO.setPrimernombre(beneficiario.getPrimernombre());
        beneDTO.setSegundonombre(beneficiario.getSegundonombre());
        if (beneficiario.getTipodocumentoid() != null) {
            beneDTO.setTipodocumentoid(tipoDocumentoIdToTipoDocumentoDTO(
                    beneficiario.getTipodocumentoid()));
        }

        return beneDTO;
    }

    /**
     * Método para transformar una entidad a DTO..
     *
     * @param preguntas Entidad
     * @return Lista de DTO.
     */
    public static ListaasistenciaDTO lisAsistenciaToLisAsistenciaDTO(
            Listaasistencia asistencia) {
        ListaasistenciaDTO asistenciaDTO = new ListaasistenciaDTO();
        asistenciaDTO.setBeneficiario(beneficiarioToBeneficiarioDto(
                asistencia.getBeneficiario()));
        asistenciaDTO.setFecharegistro(asistencia.getFecharegistro());
        asistenciaDTO.setIdasistencia(asistencia.getIdasistencia());
        asistenciaDTO.setJustificacionInasistencia(
                asistencia.getJustificacioninasistencia());
        asistenciaDTO.setRegistroasistencia(asistencia.getRegistroasistencia());
        asistenciaDTO.setSesiones(sesionesToSesionesDTO(
                asistencia.getSesiones()));
        return asistenciaDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param asistencias Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<ListaasistenciaDTO>
            listaLisAsistenciaToListaLisAsistenciaDTO(
                    List<Listaasistencia> asistencias) {

        List<ListaasistenciaDTO> asistenciasDTO = new ArrayList();
        for (Listaasistencia lista : asistencias) {
            ListaasistenciaDTO asistenciaDTO
                    = lisAsistenciaToLisAsistenciaDTO(lista);
            asistenciasDTO.add(asistenciaDTO);
        }
        return asistenciasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param sAAT Entidad.
     * @return DTO.
     */
    public static SesionacompanamientoatDTO
            sesionAcompanamientoATToSesionAcompanamientoATDTO(
                    Sesionacompanamientoat sAAT) {
        SesionacompanamientoatDTO sesionAATDTO
                = new SesionacompanamientoatDTO();
        sesionAATDTO.setIdsesionacompanamientoat(
                sAAT.getIdsesionacompanamientoat());
        sesionAATDTO.setEstadosesion(
                estadoSesionToEstadoSesionDTO(sAAT.getEstadosesion()));
        if (sAAT.getRutaacompanamientoat() != null) {
            sesionAATDTO.setRutaacompanamientoat(
                    rutaAcompanamientoATToRutaacompanamientoatDTO(
                            sAAT.getRutaacompanamientoat()));
        }
        if (sAAT.getTemasrutaacompanamientoat() != null) {
            sesionAATDTO.setTemasrutaacompanamientoat(
                    temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(
                            sAAT.getTemasrutaacompanamientoat()));
        }
        sesionAATDTO.setFechainicio(sAAT.getFechainicio());
        sesionAATDTO.setFechafinal(sAAT.getFechafinal());
        sesionAATDTO.setFecharegistro(sAAT.getFecharegistro());
        sesionAATDTO.setObservaciones(sAAT.getObservaciones());
        sesionAATDTO.setUbicacion(sAAT.getUbicacion());
        sesionAATDTO.setFuncionario(funcionarioToFuncionarioDTO(
                sAAT.getFuncionario()));
        return sesionAATDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param rAAT Entidad.
     * @return DTO.
     */
    public static RutaacompanamientoatDTO
            rutaAcompanamientoATToRutaacompanamientoatDTO(
                    Rutaacompanamientoat rAAT) {
        RutaacompanamientoatDTO rutaAATDTO = new RutaacompanamientoatDTO();
        rutaAATDTO.setIdrutaacompanamientoat(rAAT.getIdrutaacompanamientoat());
        rutaAATDTO.setEmprendimiento(emprendimientoToEmprendimientoDTO(
                rAAT.getEmprendimiento()));
        rutaAATDTO.setFecharegistro(rAAT.getFecharegistro());
        return rutaAATDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param trAAT Entidad.
     * @return DTO.
     */
    public static TemasrutaacompanamientoatDTO
            temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(
                    Temasrutaacompanamientoat trAAT) {
        TemasrutaacompanamientoatDTO temasRutaAATDTO
                = new TemasrutaacompanamientoatDTO();
        temasRutaAATDTO.setIdtemarutaacompanamientoat(
                trAAT.getIdtemarutaacompanamientoat());
        if (trAAT.getRutaacompanamientoat() != null) {
            temasRutaAATDTO.setRutaacompanamientoat(
                    rutaAcompanamientoATToRutaacompanamientoatDTO(
                            trAAT.getRutaacompanamientoat()));
        }
        if (trAAT.getTemasevaluacion() != null) {
            temasRutaAATDTO.setTemasevaluacion(traerTemaEvaluacionDTO(
                    trAAT.getTemasevaluacion()));
        }
        temasRutaAATDTO.setFecharegistro(trAAT.getFecharegistro());
        temasRutaAATDTO.setCantidadhorasplaneadas(
                trAAT.getCantidadhorasplaneadas());
        temasRutaAATDTO.setDescripciondocumento(
                trAAT.getDescripciondocumento());
        temasRutaAATDTO.setUrldocumentotema(trAAT.getUrldocumentotema());
        return temasRutaAATDTO;
    }

    public static List<TemasrutaacompanamientoatDTO>
            listaTemasRutaAATToTemasRutaAATDTO(
                    List<Temasrutaacompanamientoat> temasRutaAAT) {
        List<TemasrutaacompanamientoatDTO> temasRutaAATDTO = new ArrayList();
        for (Temasrutaacompanamientoat temaRutaAAT : temasRutaAAT) {
            TemasrutaacompanamientoatDTO temaRutaAATDTO
                    = temasrutaAcompanamientoATToTemasrutaacompanamientoatDTO(
                            temaRutaAAT);
            temasRutaAATDTO.add(temaRutaAATDTO);
        }
        return temasRutaAATDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param m Entidad.
     * @return DTO.
     */
    public static BeneficiarioDTO datosBasicosToBeneficiarioDTO(
            MdFDatosBasicos m) {
        BeneficiarioDTO mDTO = new BeneficiarioDTO();
        TipodocumentoidDTO tipo = new TipodocumentoidDTO();
        tipo.setNombredocumento(m.getTipoDocumento());
        mDTO.setEmail(m.getCorreoElectronico());
        mDTO.setNumerodocumento(m.getNumeroDocumento());
        mDTO.setPrimernombre(m.getPrimerNombre());
        mDTO.setSegundonombre(m.getSegundoNombre());
        mDTO.setPrimerapellido(m.getPrimerApellido());
        mDTO.setSegundoapellido(m.getSegundoApellido());
        try {
            mDTO.setTelefono(Long.parseLong(m.getTelefonoContacto()));
        } catch (Exception ex) {
            mDTO.setTelefono(new Long(0));
        }
        mDTO.setTipodocumentoid(tipo);

        return mDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param datos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<BeneficiarioDTO> listDatosBasicosToListBeneficiarioDTO(
            List<MdFDatosBasicos> datos) {
        List<BeneficiarioDTO> datosDTO = new ArrayList();
        for (MdFDatosBasicos b : datos) {
            BeneficiarioDTO bene = datosBasicosToBeneficiarioDTO(b);
            datosDTO.add(bene);
        }

        return datosDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param emprendimiento Entidad.
     * @return DTO.
     */
    public static EmprendimientoDTO emprendimientoToEmprendimientoDTO(
            Emprendimiento emprendimiento) {

        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO();
        emprendimientoDTO.setIdemprendimiento(
                emprendimiento.getIdemprendimiento());
        emprendimientoDTO.setTipoemprendimiento(
                tipoEmprendimientoToTipoEmprendimientoDTO(
                        emprendimiento.getTipoemprendimiento()));
        emprendimientoDTO.setEstadoemprendimiento(
                estadoEmprendimientoToEstadoEmprendimientoDTO(
                        emprendimiento.getEstadoemprendimiento()));
        emprendimientoDTO.setNombreemprendimiento(
                emprendimiento.getNombreemprendimiento());
        emprendimientoDTO.setFecharegistro(emprendimiento.getFecharegistro());
        emprendimientoDTO.setFormalizado(emprendimiento.getFormalizado());

        Set<AsociadosDTO> asociadoses = new HashSet<AsociadosDTO>(0);
        for (Asociados a : emprendimiento.getAsociadoses()) {
            asociadoses.add(
                    EntityToDTO.asociadoToAsociadoDTONoEmprendimiento(a));
        }
        emprendimientoDTO.setAsociadoses(asociadoses);

        Set<FormalizadoDTO> formalizado = new HashSet<FormalizadoDTO>(0);
        for (Formalizado f : emprendimiento.getFormalizados()) {
            formalizado.add(EntityToDTO.formalizadoToFormalizadoDTO(f));
        }
        emprendimientoDTO.setFormalizados(formalizado);

        Set<NoestablecidoDTO> noEstablecidoDTO
                = new HashSet<NoestablecidoDTO>(0);
        for (Noestablecido n : emprendimiento.getNoestablecidos()) {
            noEstablecidoDTO.add(
                    EntityToDTO.noEstablecidoToNoEstablecidoDTO(n));
        }
        emprendimientoDTO.setNoestablecidos(noEstablecidoDTO);
        return emprendimientoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipoEmprendimiento Entidad.
     * @return DTO.
     */
    public static TipoemprendimientoDTO
            tipoEmprendimientoToTipoEmprendimientoDTO(
                    Tipoemprendimiento tipoEmprendimiento) {
        TipoemprendimientoDTO tipoemprendimientoDTO
                = new TipoemprendimientoDTO();
        tipoemprendimientoDTO.setIdtipoemprendimiento(
                tipoEmprendimiento.getIdtipoemprendimiento());
        tipoemprendimientoDTO.setNombretipoemprendimiento(
                tipoEmprendimiento.getNombretipoemprendimiento());
        tipoemprendimientoDTO.setDescripcion(
                tipoEmprendimiento.getDescripcion());
        return tipoemprendimientoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estadoemprendimiento Entidad.
     * @return DTO.
     */
    public static EstadoemprendimientoDTO
            estadoEmprendimientoToEstadoEmprendimientoDTO(
                    Estadoemprendimiento estadoemprendimiento) {
        EstadoemprendimientoDTO estadoemprendimientoDTO
                = new EstadoemprendimientoDTO();
        estadoemprendimientoDTO.setIdestadoemprendimiento(
                estadoemprendimiento.getIdestadoemprendimiento());
        estadoemprendimientoDTO.setNombreestadoemprendimiento(
                estadoemprendimiento.getNombreestadoemprendimiento());
        estadoemprendimientoDTO.setDescripcion(
                estadoemprendimiento.getDescripcion());
        return estadoemprendimientoDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param asistencias Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<ListaasistenciaaatDTO> listasAATToListaAATDTO(
            List<Listaasistenciaaat> asistencias) {
        List<ListaasistenciaaatDTO> asistenciasDTO = new ArrayList();
        for (Listaasistenciaaat lista : asistencias) {
            ListaasistenciaaatDTO asistenciaDTO = listaAATTolistaAATDTO(lista);
            asistenciasDTO.add(asistenciaDTO);
        }
        return asistenciasDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param lista Lista de entidades.
     * @return Lista de DTOs.
     */
    public static ListaasistenciaaatDTO listaAATTolistaAATDTO(
            Listaasistenciaaat lista) {
        ListaasistenciaaatDTO listaAATDTO = new ListaasistenciaaatDTO();
        listaAATDTO.setIdasistacompanamientoat(
                lista.getIdasistenciaacompanamientoat());
        listaAATDTO.setBeneficiario(beneficiarioToBeneficiarioDto(lista.getBeneficiario()));
        listaAATDTO.setSesionacompanamientoat(
                sesionAcompanamientoATToSesionAcompanamientoATDTO(
                        lista.getSesionacompanamientoat()));
        listaAATDTO.setRegistroasistencia(lista.getRegistroasistencia());
        listaAATDTO.setJustificacioninasistencia(
                lista.getJustificacioninasistencia());
        listaAATDTO.setFecharegistro(lista.getFecharegistro());
        return listaAATDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temas Entidad.
     * @return DTO.
     */
    public static TemasrutacapacitacionDTO
            temasRutaCapacitacionToTemasRutaCapacitacionDto(
                    Temasrutacapacitacion temas) {
        TemasrutacapacitacionDTO temasDTO = new TemasrutacapacitacionDTO();
        temasDTO.setCantidadhorasplaneadas(temas.getCantidadhorasplaneadas());
        temasDTO.setIdtemarutacapacitacion(temas.getIdtemarutacapacitacion());
        temasDTO.setNombretema(temas.getNombretema());
        temasDTO.setRutacapacitacion(rutaCapacitacionToRutaCapacitacionDTO(
                temas.getRutacapacitacion()));
        temasDTO.setPorcentajeAprobacion(new Short("-1"));
        return temasDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param temas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TemasrutacapacitacionDTO>
            listaTemasRutaCapacitacionToListaTemasRutaCapacitacionDTO(
                    List<Temasrutacapacitacion> temas) {
        List<TemasrutacapacitacionDTO> temasDTO = new ArrayList();
        for (Temasrutacapacitacion t : temas) {
            TemasrutacapacitacionDTO temaDTO
                    = temasRutaCapacitacionToTemasRutaCapacitacionDto(t);
            temasDTO.add(temaDTO);
        }
        return temasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param asociado Entidad.
     * @return DTO.
     */
    public static AsociadosDTO asociadoToAsociadoDTO(Asociados asociado) {
        AsociadosDTO asociadosDTO = new AsociadosDTO();
        asociadosDTO.setIdasociado(asociado.getIdasociado());
        asociadosDTO.setBeneficiario(beneficiarioToBeneficiarioDto(
                asociado.getBeneficiario()));
        asociadosDTO.setEmprendimiento(emprendimientoToEmprendimientoDTO(
                asociado.getEmprendimiento()));
        asociadosDTO.setLider(asociado.getLider());
        asociadosDTO.setFecharegistro(asociado.getFecharegistro());
        return asociadosDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param asociado Entidad.
     * @return DTO.
     */
    public static AsociadosDTO asociadoToAsociadoDTONoEmprendimiento(
            Asociados asociado) {
        AsociadosDTO asociadosDTO = new AsociadosDTO();
        asociadosDTO.setIdasociado(asociado.getIdasociado());
        asociadosDTO.setBeneficiario(beneficiarioToBeneficiarioDto(
                asociado.getBeneficiario()));
        asociadosDTO.setLider(asociado.getLider());
        asociadosDTO.setFecharegistro(asociado.getFecharegistro());
        return asociadosDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param paises Entidad.
     * @return DTO.
     */
    public static PaisesDTO paisesToPaisesDTO(Paises paises) {
        PaisesDTO paisesDTO = new PaisesDTO(paises.getIdpais(),
                paises.getNombrepais(), null);
        return paisesDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temaEvaluacion Entidad.
     * @return DTO.
     */
    public static TemasevaluacionDTO temasEvaluacionToTemasEvaluacionDTO(
            Temasevaluacion temaEvaluacion) {
        TemasevaluacionDTO temasEvaluacionDTO = new TemasevaluacionDTO();
        temasEvaluacionDTO.setIdtema(temaEvaluacion.getIdtema());
        temasEvaluacionDTO.setNombretema(temaEvaluacion.getNombretema());
        temasEvaluacionDTO.setFecharegistro(temaEvaluacion.getFecharegistro());
        temasEvaluacionDTO.setDescripcion(temaEvaluacion.getDescripcion());
        return temasEvaluacionDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param emprendimiento Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<EmprendimientoDTO>
            listaEmprendimientoToListaEmprendimientoDTO(
                    List<Emprendimiento> emprendimiento) {
        List<EmprendimientoDTO> emprendimientoDTO = new ArrayList();
        for (Emprendimiento t : emprendimiento) {
            EmprendimientoDTO emprendDTO = emprendimientoToEmprendimientoDTO(t);
            emprendimientoDTO.add(emprendDTO);
        }
        return emprendimientoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tema Entidad.
     * @return DTO.
     */
    public static TemasrutaacompanamientoatDTO
            temasAcompanamientoToTemasAcompanamientoDTO(
                    Temasrutaacompanamientoat tema) {
        TemasrutaacompanamientoatDTO temaDTO
                = new TemasrutaacompanamientoatDTO();
        temaDTO.setCantidadhorasplaneadas(tema.getCantidadhorasplaneadas());
        temaDTO.setTemasevaluacion(temasEvaluacionToTemasEvaluacionDTO2(
                tema.getTemasevaluacion()));
        temaDTO.setIdtemarutaacompanamientoat(
                tema.getIdtemarutaacompanamientoat());
        return temaDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param temas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TemasrutaacompanamientoatDTO>
            listaTemasAcompanamientoToListaTemasAcompanamientoDTO(
                    List<Temasrutaacompanamientoat> temas) {
        List<TemasrutaacompanamientoatDTO> temasDTO = new ArrayList();
        for (Temasrutaacompanamientoat t : temas) {
            TemasrutaacompanamientoatDTO temaDTO
                    = temasAcompanamientoToTemasAcompanamientoDTO(t);
            temasDTO.add(temaDTO);
        }
        return temasDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temaEvaluacion Entidad.
     * @return DTO.
     */
    public static TemasEvaluacionDTO temasEvaluacionToTemasEvaluacionDTO2(
            Temasevaluacion temaEvaluacion) {
        TemasEvaluacionDTO temasEvaluacionDTO = new TemasEvaluacionDTO();
        temasEvaluacionDTO.setIdtema(temaEvaluacion.getIdtema());
        temasEvaluacionDTO.setNombretema(temaEvaluacion.getNombretema());

        temasEvaluacionDTO.setFecharegistro(temaEvaluacion.getFecharegistro());
        temasEvaluacionDTO.setDescripcion(temaEvaluacion.getDescripcion());
        return temasEvaluacionDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param actividad Entidad.
     * @return DTO.
     */
    public static ActividadInternacionalDTO
            actInternacionalTOActInternacionalDTO(
                    Actividadinternacional actividad) {
        ActividadInternacionalDTO actividadDTO = new ActividadInternacionalDTO(
                actividad.getIdactividadinternacional(),
                actividad.getNombreactividadinternacional(),
                actividad.getDescripcion(), null);
        return actividadDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param sector Entidad.
     * @return DTO.
     */
    public static SectorproductivoDTO sectorProductivoTOSectorProductivoDTO(
            Sectorproductivo sector) {
        SectorproductivoDTO sectorDTO = new SectorproductivoDTO(
                sector.getIdsectorproductivo(),
                sector.getNombresectorproductivo(),
                sector.getNombresectorproductivo(),
                null, null);
        return sectorDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipo Entidad.
     * @return DTO.
     */
    public static TipoconstitucionlegalDTO
            tipoConstLegalToTipoConstLegalDTO(
                    Tipoconstitucionlegal tipo) {
        TipoconstitucionlegalDTO tipoDTO = new TipoconstitucionlegalDTO(
                tipo.getIdtipoconstitucionlegal(),
                tipo.getNombretipoconstitucionlegal(), tipo.getDescripcion(),
                null, null);
        return tipoDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipo Entidad.
     * @return DTO.
     */
    public static TipoemprendimientoDTO tipoEmprendimientoTOTipoEmprendimiento(
            Tipoemprendimiento tipo) {
        TipoemprendimientoDTO tipoDTO = new TipoemprendimientoDTO(
                tipo.getIdtipoemprendimiento(),
                tipo.getNombretipoemprendimiento(), tipo.getDescripcion(),
                null);
        return tipoDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param temas Entidad.
     * @return DTO.
     */
    public static TemasvaloracionindividualDTO
            temasValoracionIndToTemasValoracionIndDTO(
                    Temasvaloracionindividual temas) {
        TemasvaloracionindividualDTO temasDTO
                = new TemasvaloracionindividualDTO();
        temasDTO.setIdtema(temas.getIdtema());
        temasDTO.setNombretema(temas.getNombretema());

        return temasDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param temas Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TemasvaloracionindividualDTO>
            listaTemasindividualesToListaTemasIndividualesDTO(
                    List<Temasvaloracionindividual> temas) {
        List<TemasvaloracionindividualDTO> temasDTO = new ArrayList();
        for (Temasvaloracionindividual t : temas) {
            TemasvaloracionindividualDTO temaDTO
                    = temasValoracionIndToTemasValoracionIndDTO(t);
            temasDTO.add(temaDTO);
        }
        return temasDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param ruta Entidad.
     * @return DTO.
     */
    public static RutacapacitacionDTO rutaCapacitacionToRutaCapacitacionDTO(
            Rutacapacitacion ruta) {
        RutacapacitacionDTO rutaDTO = new RutacapacitacionDTO();
        rutaDTO.setIdrutacapacitacion(ruta.getIdrutacapacitacion());

        return rutaDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param dep Entidad.
     * @return DTO.
     */
    public static DepartamentosDTO departamentoToDepartamentoDTO(
            Departamentos dep) {

        DepartamentosDTO dto = new DepartamentosDTO(dep.getId(),
                dep.getDivipola(), dep.getNombre());
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param mun Entidad.
     * @return DTO.
     */
    public static MunicipiosDTO municipiosToMunicipiosDTO(Municipios mun) {
        MunicipiosDTO dto = new MunicipiosDTO(mun.getId(),
                departamentoToDepartamentoDTO(mun.getDepartamentos()),
                mun.getDivipola(), mun.getNombre());

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param documentos Entidad.
     * @return DTO.
     */
    public static DocumentosDTO documentoToDocumentoDTO(Documentos documentos) {
        DocumentosDTO documentosDTO = new DocumentosDTO();
        documentosDTO.setIddocumento(documentos.getIddocumento());
        documentosDTO.setBeneficiario(beneficiarioToBeneficiarioDto(
                documentos.getBeneficiario()));
        documentosDTO.setEmprendimiento(emprendimientoToEmprendimientoDTO(
                documentos.getEmprendimiento()));
        documentosDTO.setFecharegistro(documentos.getFecharegistro());
        documentosDTO.setTipodocumentos(tipoDocumentoToTipoDocumentoDTO(
                documentos.getTipodocumentos()));
        documentosDTO.setUrlarchivo(documentos.getUrlarchivo());
        return documentosDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipoD Entidad.
     * @return DTO.
     */
    public static TipodocumentosDTO tipoDocumentoToTipoDocumentoDTO(
            Tipodocumentos tipoD) {
        TipodocumentosDTO tipoDocumentosDTO = new TipodocumentosDTO();
        tipoDocumentosDTO.setIdtipodocumento(tipoD.getIdtipodocumento());
        tipoDocumentosDTO.setDescripcion(tipoD.getDescripcion());
        tipoDocumentosDTO.setNombretipodocumento(
                tipoD.getNombretipodocumento());
        return tipoDocumentosDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param sesion Entidad.
     * @return DTO.
     */
    public static SesioncomiteDTO sesionesComiteToSesionesComiteDTO(
            Sesioncomite sesion) {
        SesioncomiteDTO sesionesDTO = new SesioncomiteDTO();
        sesionesDTO.setIdsesioncomite(sesion.getIdsesioncomite());
        sesionesDTO.setComiteevaluacion(EntityToDTO
                .comiteEvaluacionToComiteEvaluacionDTO(
                        sesion.getComiteevaluacion()));
        sesionesDTO.setEstadosesion(EntityToDTO.estadoSesionToEstadoSesionDTO(
                sesion.getEstadosesion()));
        sesionesDTO.setFuncionario(funcionarioToFuncionarioDTO(
                sesion.getFuncionario()));
        sesionesDTO.setFechafinal(sesion.getFechafinal());
        sesionesDTO.setFechainicio(sesion.getFechainicio());
        sesionesDTO.setFecharegistro(sesion.getFecharegistro());
        sesionesDTO.setUrlacta(sesion.getUrlacta());
        sesionesDTO.setUbicacion(sesion.getUbicacion());

        Set<EvaluacionemprendimientoDTO> evaluacionemprendimientoses
                = new HashSet<EvaluacionemprendimientoDTO>(0);

        for (Evaluacionemprendimientos e
                : sesion.getEvaluacionemprendimientoses()) {
            if (e.getEmprendimiento().getEstadoemprendimiento()
                    .getIdestadoemprendimiento().intValue() == 4) {
                evaluacionemprendimientoses.add(EntityToDTO
                        .evaluacionEmprendimientoToEvaluacionEmprendimientoDTO(
                                e));
            }
        }

        sesionesDTO.setEvaluacionemprendimientoses(evaluacionemprendimientoses);
        return sesionesDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param integrantes Entidad.
     * @return DTO.
     */
    public static IntegrantescomiteDTO integrantesComiteToIntegrantesComiteDTO(
            Integrantescomite integrantes) {
        IntegrantescomiteDTO dto = new IntegrantescomiteDTO(integrantes
                .getIdintegrante(),
                null, EntityToDTO.funcionarioToFuncionarioDTO(integrantes
                        .getFuncionario()), integrantes.getFecharegistro());

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipo Entidad.
     * @return DTO.
     */
    public static TipofinanciacionDTO tipoFinanciacionToTipoFinanciacionDTO(
            Tipofinanciacion tipo) {
        TipofinanciacionDTO tipoDTO = new TipofinanciacionDTO();
        tipoDTO.setDescripcion(tipo.getDescripcion());
        tipoDTO.setIdtipofinanciacion(tipo.getIdtipofinanciacion());
        tipoDTO.setNombretipofinanciacion(tipo.getNombretipofinanciacion());

        return tipoDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param tipos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<TipofinanciacionDTO>
            listaTiposFinanciacionToListaTiposFinanciacionDTO(
                    List<Tipofinanciacion> tipos) {
        List<TipofinanciacionDTO> tiposDTO = new ArrayList();
        for (Tipofinanciacion t : tipos) {
            TipofinanciacionDTO tipoDTO
                    = tipoFinanciacionToTipoFinanciacionDTO(t);
            tiposDTO.add(tipoDTO);
        }
        return tiposDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param financiacion Entidad.
     * @return DTO.
     */
    public static FinanciacionDTO financiacionToFinanciacionDTO(
            Financiacion financiacion) {
        FinanciacionDTO financiacionDTO = new FinanciacionDTO();
        financiacionDTO.setCapitaltotal(financiacion.getCapitaltotal());
        financiacionDTO.setCapitaltrabajo(financiacion.getCapitaltrabajo());
        financiacionDTO.setCuotaspactadass(financiacion.getCuotaspactadass());
        financiacionDTO.setEmpleosporgenerar(
                financiacion.getEmpleosporgenerar());
        financiacionDTO.setEmpleosgenerados(financiacion.getEmpleosgenerados());
        financiacionDTO.setTipofinanciacionByIdtipofinanciacions(
                tipoFinanciacionToTipoFinanciacionDTO(financiacion
                        .getTipofinanciacionByIdtipofinanciacions()));
        financiacionDTO.setMesespuntoequilibrio(
                financiacion.getMesespuntoequilibrio());
        financiacionDTO.setMontofinanciacions(
                financiacion.getMontofinanciacions());
        financiacionDTO.setRecursospropiosae(
                financiacion.getRecursospropiosae());
        financiacionDTO.setTasaintertess(
                financiacion.getTasaintertess());
        return financiacionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param entidades Entidad.
     * @return DTO.
     */
    public static EntidadesfinancierasDTO
            entidadesFinancierasToEntidadesFinancierasDTO(
                    Entidadesfinancieras entidades) {
        EntidadesfinancierasDTO entidadesDTO = new EntidadesfinancierasDTO();
        entidadesDTO.setNombreentidad(entidades.getNombreentidad());
        entidadesDTO.setDescripcion(entidades.getDescripcion());
        entidadesDTO.setEstado(entidades.getEstado());
        entidadesDTO.setFecharegistro(entidades.getFecharegistro());
        entidadesDTO.setIdentidadesfinanciera(
                entidades.getIdentidadfinanciera());
        return entidadesDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param entidades Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<EntidadesfinancierasDTO>
            listaEntidadesFinancierasToListaEntidadesFinancierasDTO(
                    List<Entidadesfinancieras> entidades) {
        List<EntidadesfinancierasDTO> entidadesDTO = new ArrayList();
        for (Entidadesfinancieras entidad : entidades) {
            EntidadesfinancierasDTO entidadDTO
                    = entidadesFinancierasToEntidadesFinancierasDTO(entidad);
            entidadesDTO.add(entidadDTO);
        }
        return entidadesDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param financiacion Entidad.
     * @return DTO.
     */
    public static FinanciacionDTO financiacionToFinanciacionDTO2(
            Financiacion financiacion) {
        FinanciacionDTO financiacionDTO = new FinanciacionDTO();
        financiacionDTO.setCapitaltotal(financiacion.getCapitaltotal());
        financiacionDTO.setCapitaltrabajo(financiacion.getCapitaltrabajo());
        financiacionDTO.setCuotaspactadass(financiacion.getCuotaspactadass());
        financiacionDTO.setEmpleosporgenerar(
                financiacion.getEmpleosporgenerar());
        financiacionDTO.setTipofinanciacionByIdtipofinanciacions(
                tipoFinanciacionToTipoFinanciacionDTO(
                        financiacion
                                .getTipofinanciacionByIdtipofinanciacions()));
        financiacionDTO.setMesespuntoequilibrio(financiacion
                .getMesespuntoequilibrio());
        financiacionDTO.setMontofinanciacions(financiacion
                .getMontofinanciacions());
        financiacionDTO.setRecursospropiosae(financiacion
                .getRecursospropiosae());
        financiacionDTO.setTasaintertess(financiacion.getTasaintertess());
        financiacionDTO.setIdfinanciacion(financiacion.getIdfinanciacion());
        //info financiera

        financiacionDTO.setMontoa(financiacion.getMontoa());
        financiacionDTO.setTasainteresa(financiacion.getTasainteresa());
        financiacionDTO.setCuotaspactadasa(financiacion.getCuotaspactadasa());
        if (financiacion.getEntidadesfinancieras() != null) {
            financiacionDTO.setEntidadesfinancieras(
                    entidadesFinancierasToEntidadesFinancierasDTO(financiacion
                            .getEntidadesfinancieras()));
        }
        if (financiacion.getTipofinanciacionByIdtipofinanciaciona() != null) {
            financiacionDTO.setTipofinanciacionByIdtipofinanciaciona(
                    tipoFinanciacionToTipoFinanciacionDTO(financiacion
                            .getTipofinanciacionByIdtipofinanciaciona()));
        }
        return financiacionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param formalizado Entidad.
     * @return DTO.
     */
    public static FormalizadoDTO formalizadoToFormalizadoDTO(
            Formalizado formalizado) {
        FormalizadoDTO dto
                = new FormalizadoDTO(formalizado.getIdformalizacion(),
                        null,
                        EntityToDTO
                                .tipoConstLegalToTipoConstLegalDTO(
                                formalizado
                                        .getTipoconstitucionlegal()),
                        EntityToDTO.sectorProductivoTOSectorProductivoDTO(
                                formalizado
                                .getSectorproductivo()),
                        EntityToDTO.actInternacionalTOActInternacionalDTO(
                                formalizado.getActividadinternacional()),
                        formalizado.getNombreempresa(), formalizado
                        .getRepresentantelegal(),
                        formalizado.getProductoservicioofrece(), formalizado
                        .getNegociosinternet(),
                        formalizado.getNumeroregistromercantil(), formalizado
                        .getFecharenovacion(),
                        formalizado.getNit(),
                        formalizado.getFechainiciolabores(),
                        formalizado.getEmpleosdirectos(),
                        formalizado.getEmpleosindirectos(), formalizado
                        .getDireccionempresa(),
                        formalizado.getTelefonoempresa(),
                        formalizado.getMunicipio(),
                        formalizado.getEmailempresa(),
                        formalizado.getSitioweb(), null);

        Set<PaisescomercializaDTO> paisescomercializas
                = new HashSet<PaisescomercializaDTO>(0);
        for (Paisescomercializa p : formalizado.getPaisescomercializas()) {
            paisescomercializas.add(EntityToDTO
                    .paisesComercializaToPaisesComercializaDTO(p));
        }
        dto.setPaisescomercializas(paisescomercializas);

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param noEstablecido Entidad.
     * @return DTO.
     */
    public static NoestablecidoDTO noEstablecidoToNoEstablecidoDTO(
            Noestablecido noEstablecido) {
        NoestablecidoDTO dto = new NoestablecidoDTO(noEstablecido
                .getIdnoestablecido(),
                null, EntityToDTO
                        .tipoConstLegalToTipoConstLegalDTO(
                                noEstablecido.getTipoconstitucionlegal()),
                EntityToDTO.sectorProductivoTOSectorProductivoDTO(noEstablecido
                        .getSectorproductivo()),
                noEstablecido.getProductoservicioofrece(), noEstablecido
                .getCuandoinicia(),
                noEstablecido.getObservaciones());

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param pais Entidad.
     * @return DTO.
     */
    public static PaisescomercializaDTO
            paisesComercializaToPaisesComercializaDTO(Paisescomercializa pais) {
        PaisescomercializaDTO dto = new PaisescomercializaDTO(pais
                .getIdpaisescomercializa(),
                null, EntityToDTO.paisesToPaisesDTO(pais.getPaises()));

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param evaluacion Entidad.
     * @return DTO.
     */
    public static EvaluacionemprendimientoDTO
            evaluacionEmprendimientoToEvaluacionEmprendimientoDTO(
                    Evaluacionemprendimientos evaluacion) {
        EvaluacionemprendimientoDTO dto = new EvaluacionemprendimientoDTO(
                evaluacion.getIdevaluacion(),
                EntityToDTO.emprendimientoToEmprendimientoDTOpocosDatos(
                        evaluacion.getEmprendimiento()),
                EntityToDTO.tipoPrioridadToTipoPrioridadDTO(
                        evaluacion.getTipoprioridad()),
                evaluacion.getFecharegistro(), evaluacion
                .getCalificacionfinal(),
                evaluacion.getAprobado(), evaluacion.getObservaciones(),
                evaluacion.getFechaevaluacion(),
                null);

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param tipo Entidad.
     * @return DTO.
     */
    public static TipoprioridadDTO tipoPrioridadToTipoPrioridadDTO(
            Tipoprioridad tipo) {
        TipoprioridadDTO dto = new TipoprioridadDTO(tipo.getIdtipoprioridad(),
                tipo.getNombreprioridad(), tipo.getDescripcion(), null);

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param evaluacion Entidad.
     * @return DTO.
     */
    public static EvaluacionintegrantescomiteDTO
            evaluacionIntegranteToEvaluacionIntegranteDTO(
                    Evaluacionintegrantescomite evaluacion) {
        EvaluacionintegrantescomiteDTO dto = new EvaluacionintegrantescomiteDTO(
                evaluacion.getIdevaluacionintegrante(),
                EntityToDTO
                        .evaluacionEmprendimientoToEvaluacionEmprendimientoDTO(
                                evaluacion.getEvaluacionemprendimientos()),
                EntityToDTO
                        .funcionarioToFuncionarioDTO(
                                evaluacion.getFuncionario()),
                evaluacion.getFecharegistro(),
                evaluacion.getCalificacionindividual(),
                evaluacion.getObservaciones());
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param emprendimiento Entidad.
     * @return DTO.
     */
    public static EmprendimientoDTO emprendimientoToEmprendimientoDTOpocosDatos(
            Emprendimiento emprendimiento) {

        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO();
        emprendimientoDTO.setIdemprendimiento(
                emprendimiento.getIdemprendimiento());
        emprendimientoDTO.setTipoemprendimiento(
                tipoEmprendimientoToTipoEmprendimientoDTO(emprendimiento
                        .getTipoemprendimiento()));
        emprendimientoDTO.setNombreemprendimiento(
                emprendimiento.getNombreemprendimiento());
        emprendimientoDTO.setFecharegistro(emprendimiento.getFecharegistro());

        return emprendimientoDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param log Entidad.
     * @return DTO.
     */
    public static LogauditoriaDTO logToLogDTO(Logauditoria log) {
        LogauditoriaDTO logDTO = new LogauditoriaDTO();
        logDTO.setAccion(log.getAccion());
        logDTO.setFecharegistro(log.getFecharegistro());
        logDTO.setModulo(log.getModulo());
        logDTO.setUsers(userToUserDTO(log.getUsers()));
        logDTO.setIdelemento(log.getIdelemento());
        return logDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param logs Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<LogauditoriaDTO> listaLogToListaLogDTO(
            List<Logauditoria> logs) {
        List<LogauditoriaDTO> logsDTO = new ArrayList();
        for (Logauditoria l : logs) {
            LogauditoriaDTO logDTO = logToLogDTO(l);
            logsDTO.add(logDTO);
        }
        return logsDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param configuraciones Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<ConfiguracionDTO> configuracionToConfiguracionDTO(
            List<Configuracion> configuraciones) {
        List<ConfiguracionDTO> dtoList = new ArrayList();
        for (Configuracion c : configuraciones) {
            ConfiguracionDTO dto = new ConfiguracionDTO(c.getIdconfiguracion(),
                    c.getNombreconfiguracion(), c.getFechamodificacion(),
                    c.getValor());
            dtoList.add(dto);
        }
        return dtoList;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param configuracion Entidad.
     * @return DTO.
     */
    public static ConfiguracionDTO configToConfigDTO(
            Configuracion configuracion) {
        ConfiguracionDTO configuracionDTO = new ConfiguracionDTO(
                configuracion.getIdconfiguracion(),
                configuracion.getNombreconfiguracion(),
                configuracion.getFechamodificacion(), configuracion.getValor());
        return configuracionDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param institucion Entidad.
     * @return DTO.
     */
    public static InstitucionesDTO institucionesToInstitucionesDto(
            Instituciones institucion) {
        InstitucionesDTO dto = new InstitucionesDTO(institucion.getId(),
                institucion.getFechaAprobacion(),
                institucion.getCorreoElectronico(),
                institucion.getNumeroTelefono(),
                institucion.getFechaCreacion(),
                institucion.getDigitoVerificacion(),
                institucion.getNombreInstitucion(),
                institucion.getNaturalezaJuridica(),
                institucion.getFechaModificacion(), institucion.getNit(),
                institucion.getOrigen(),
                institucion.getVencimientoCertificacion(),
                institucion.getEstado(),
                institucion.getIdUsuarioCreacion(),
                institucion.getTipoDocumento(),
                institucion.getIdUsuarioModificacion(),
                institucion.getTipoInstitucionId(),
                institucion.getEstadoAprobacion(),
                institucion.getTipoCertificacion());

        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param instituciones Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<InstitucionesDTO>
            listInstitucionesToListInstitucionesDto(
                    List<Instituciones> instituciones) {
        List<InstitucionesDTO> dtos = new ArrayList<>();

        for (Instituciones i : instituciones) {
            dtos.add(institucionesToInstitucionesDto(i));
        }

        return dtos;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param sede Entidad.
     * @return DTO.
     */
    public static SedesDTO sedesToSedesDTO(Sedes sede) {
        SedesDTO dto = new SedesDTO(sede.getId(),
                departamentoToDepartamentoDTO(sede.getDepartamentos()),
                municipiosToMunicipiosDTO(sede.getMunicipios()),
                sede.getDireccion(),
                sede.getCodigo(), sede.getFechaCreacion(),
                sede.getIdUsuarioCreacion(),
                sede.getIdInstitucion(), sede.getFechaModificacion(),
                sede.getIdUsuarioModificacion(),
                sede.getNombre(), sede.isPrincipal(), sede.getEstado());
        return dto;
    }

    public static List<SedesDTO> listSedesToListSedesDTO(List<Sedes> sedes) {
        List<SedesDTO> lista = new ArrayList<>();
        for (Sedes s : sedes) {
            lista.add(sedesToSedesDTO(s));
        }
        return lista;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param capacitacion Entidad.
     * @return DTO.
     */
    public static CapacitacionprogramaDTO
            capacitacionProgramaToCapacitacionProgramaDTOFull(
                    Capacitacionprograma capacitacion) {
        CapacitacionprogramaDTO dto = new CapacitacionprogramaDTO(capacitacion
                .getIdcapacitacionprograma(),
                null, null, capacitacion.getIdoferenteinstitucion(),
                capacitacion.getNombrecapacitacionprograma(),
                capacitacion.getFecharegistro());

        if (capacitacion.getCategoria() != null) {
            dto.setCategoria(categoriaToCategoriaDTO(
                    capacitacion.getCategoria()));
        }

        if (capacitacion.getEstadocapacitacionprograma() != null) {
            dto.setEstadocapacitacionprograma(
                    estadoCapacitacionToEstadoCapacitacionDTO(capacitacion
                            .getEstadocapacitacionprograma()));
        }

        Set<ModulocicloDTO> modulos = new HashSet<ModulocicloDTO>(0);
        for (Modulociclo m : capacitacion.getModulociclos()) {
            modulos.add(moduloToModuloDTO(m));
        }

        dto.setModulociclos(modulos);

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param categoria Entidad.
     * @return DTO.
     */
    public static CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO(categoria.getIdcategoria(),
                categoria.getNombrecategoria(), categoria.getDescripcion(),
                categoria.getPorcentajeaprobacion(), categoria
                .getCalificacionaprobacion());
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estado Entidad.
     * @return DTO.
     */
    public static EstadocapacitacionprogramaDTO
            estadoCapacitacionToEstadoCapacitacionDTO(
                    Estadocapacitacionprograma estado) {
        EstadocapacitacionprogramaDTO dto = new EstadocapacitacionprogramaDTO(
                estado.getIdestadocapacitacionprograma(),
                estado.getNombreestadocapacitacionprog(),
                estado.getDescripcion());
        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param capacitaciones Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<CapacitacionprogramaDTO>
            listCapacitacionProgramaToListCapacitacionProgramaDTO(
                    List<Capacitacionprograma> capacitaciones) {
        List<CapacitacionprogramaDTO> list = new ArrayList<>();
        for (Capacitacionprograma c : capacitaciones) {
            list.add(capacitacionProgramaToCapacitacionProgramaDTO(c));
        }
        return list;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param docente Entidad.
     * @return DTO.
     */
    public static DocentesDTO docentesToDocentesDTO(Docentes docente) {
        DocentesDTO dto = new DocentesDTO(docente.getIddocente(),
                tipoDocumentoIdToTipoDocumentoDTO(docente.getTipodocumentoid()),
                estadoDocenteToEstadoDocenteDTO(docente.getEstadodocente()),
                docente.getPrimernombre(), docente.getSegundonombre(),
                docente.getPrimerapellido(),
                docente.getSegundoapellido(), docente.getEmail(),
                docente.getTelefono(),
                docente.getNumerodocumento(), docente.getFecharegistro());
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param estado Entidad.
     * @return DTO.
     */
    public static EstadodocenteDTO estadoDocenteToEstadoDocenteDTO(
            Estadodocente estado) {
        EstadodocenteDTO dto = new EstadodocenteDTO(estado.getIdestadodocente(),
                estado.getNombreestadodocente(), estado.getDescripcion());
        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param estados Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<EstadodocenteDTO>
            listEstadoDocenteToListEstadoDocenteDTO(
                    List<Estadodocente> estados) {
        List<EstadodocenteDTO> estadosDTO = new ArrayList();
        for (Estadodocente e : estados) {
            estadosDTO.add(estadoDocenteToEstadoDocenteDTO(e));
        }
        return estadosDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param docentes Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<DocentesDTO> listDocentesToListDocentesDTO(
            List<Docentes> docentes) {
        List<DocentesDTO> list = new ArrayList<>();
        for (Docentes d : docentes) {
            list.add(docentesToDocentesDTO(d));
        }
        return list;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param programacion Entidad.
     * @return DTO.
     */
    public static ProgramacionDTO programacionToProgramacionDTO(
            Programacion programacion) {
        ProgramacionDTO dto = new ProgramacionDTO(
                programacion.getIdprogramacion(),
                null, null, null, null, programacion.getIdInstitucion(),
                programacion.getFechainicioprogramacion(),
                programacion.getFechafinalrogramacion(),
                programacion.getMaxasistentes(),
                programacion.getFecharegistro(), programacion.getUbicacion());

        if (programacion.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    programacion.getFuncionario()));
        }

        if (programacion.getEstadosesion() != null) {
            dto.setEstadosesion(estadoSesionToEstadoSesionDTO(
                    programacion.getEstadosesion()));
        }

        if (programacion.getCapacitacionprograma() != null) {
            dto.setCapacitacionprograma(
                    capacitacionProgramaToCapacitacionProgramaDTOFull(
                            programacion.getCapacitacionprograma()));
        }

        if (programacion.getDocentes() != null) {
            dto.setDocentes(docentesToDocentesDTO(programacion.getDocentes()));
        }

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param programacion Entidad.
     * @return DTO.
     */
    public static ProgramacionDTO programacionToProgramacionDTOFull(
            Programacion programacion) {
        ProgramacionDTO dto = new ProgramacionDTO(
                programacion.getIdprogramacion(),
                null, null, null, null, programacion.getIdInstitucion(),
                programacion.getFechainicioprogramacion(),
                programacion.getFechafinalrogramacion(),
                programacion.getMaxasistentes(),
                programacion.getFecharegistro(), programacion.getUbicacion());

        if (programacion.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    programacion.getFuncionario()));
        }

        if (programacion.getEstadosesion() != null) {
            dto.setEstadosesion(estadoSesionToEstadoSesionDTO(
                    programacion.getEstadosesion()));
        }

        if (programacion.getCapacitacionprograma() != null) {
            dto.setCapacitacionprograma(
                    capacitacionProgramaToCapacitacionProgramaDTOFull(
                            programacion.getCapacitacionprograma()));
        }

        if (programacion.getDocentes() != null) {
            dto.setDocentes(docentesToDocentesDTO(programacion.getDocentes()));
        }

        Set<AlumnosDTO> alumnos = new HashSet<AlumnosDTO>(0);
        for (Alumnos a : programacion.getAlumnoses()) {
            alumnos.add(alumnosToAlumnosDTO(a));
        }

        dto.setAlumnoses(alumnos);
        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param programaciones Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<ProgramacionDTO> listProgramacionToListProgramacionDTO(
            List<Programacion> programaciones) {
        List<ProgramacionDTO> list = new ArrayList<>();
        for (Programacion p : programaciones) {
            list.add(programacionToProgramacionDTO(p));
        }
        return list;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param categorias Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<CategoriaDTO> listCategoriasTOListCategoriasDTO(
            List<Categoria> categorias) {
        List<CategoriaDTO> categoriasDTO = new ArrayList();
        for (Categoria c : categorias) {
            categoriasDTO.add(categoriaToCategoriaDTO(c));
        }
        return categoriasDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param estados Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<EstadocapacitacionprogramaDTO>
            listEstadoCapacitacionToListEstadoCapacitacionDTO(
                    List<Estadocapacitacionprograma> estados) {
        List<EstadocapacitacionprogramaDTO> estadosDTO = new ArrayList();
        for (Estadocapacitacionprograma e : estados) {
            estadosDTO.add(estadoCapacitacionToEstadoCapacitacionDTO(e));
        }
        return estadosDTO;

    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param modulo Entidad.
     * @return DTO.
     */
    public static ModulocicloDTO moduloToModuloDTO(Modulociclo modulo) {
        ModulocicloDTO moduloDTO = new ModulocicloDTO();
        moduloDTO.setFecharegistro(modulo.getFecharegistro());
        moduloDTO.setIdmodulociclo(modulo.getIdmodulociclo());
        moduloDTO.setIntensidadhoraria(modulo.getIntensidadhoraria());
        moduloDTO.setNombremodulociclo(modulo.getNombremodulociclo());
        moduloDTO.setCapacitacionPrograma(
                capacitacionProgramaToCapacitacionProgramaDTO(modulo
                        .getCapacitacionprograma()));
        return moduloDTO;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param modulos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<ModulocicloDTO> listModuloToListModuloDTO(
            List<Modulociclo> modulos) {
        List<ModulocicloDTO> modulosDTO = new ArrayList();
        for (Modulociclo m : modulos) {
            modulosDTO.add(moduloToModuloDTO(m));
        }
        return modulosDTO;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param alumno Entidad.
     * @return DTO.
     */
    public static AlumnosDTO alumnosToAlumnosDTO(Alumnos alumno) {
        AlumnosDTO dto = new AlumnosDTO(alumno.getIdalumno(),
                null, null, null, alumno.getFecharegistro());

        if (alumno.getBeneficiario() != null) {
            dto.setBeneficiario(beneficiarioToBeneficiarioDto(
                    alumno.getBeneficiario()));
        }

        if (alumno.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    alumno.getFuncionario()));
        }

        if (alumno.getProgramacion() != null) {
            dto.setProgramacion(programacionToProgramacionDTO(
                    alumno.getProgramacion()));
        }

        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param alumno Entidad.
     * @return DTO.
     */
    public static AlumnosDTO alumnosToAlumnosDTOFull(Alumnos alumno) {
        AlumnosDTO dto = new AlumnosDTO(alumno.getIdalumno(),
                null, null, null, alumno.getFecharegistro());

        if (alumno.getBeneficiario() != null) {
            dto.setBeneficiario(beneficiarioToBeneficiarioDto(
                    alumno.getBeneficiario()));
        }

        if (alumno.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    alumno.getFuncionario()));
        }

        if (alumno.getProgramacion() != null) {
            dto.setProgramacion(programacionToProgramacionDTO(
                    alumno.getProgramacion()));
        }

        if (alumno.getAprobacions() != null) {
            Set<AprobacionDTO> aprobaciones = new HashSet<AprobacionDTO>(0);
            for (Aprobacion a : alumno.getAprobacions()) {
                aprobaciones.add(aprobacionToAprobacionDTO(a));
            }
            dto.setAprobacions(aprobaciones);
        }
        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param alumnos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<AlumnosDTO> listAlumnosToListAlumnosDTO(
            List<Alumnos> alumnos) {
        List<AlumnosDTO> dtos = new ArrayList();
        for (Alumnos a : alumnos) {
            dtos.add(alumnosToAlumnosDTO(a));
        }
        return dtos;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param alumnos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<AlumnosDTO> listAlumnosToListAlumnosDTOFull(
            List<Alumnos> alumnos) {
        List<AlumnosDTO> dtos = new ArrayList();
        for (Alumnos a : alumnos) {
            dtos.add(alumnosToAlumnosDTOFull(a));
        }
        return dtos;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param capacitacion Entidad.
     * @return DTO.
     */
    public static CapacitacionprogramaDTO
            capacitacionProgramaToCapacitacionProgramaDTO(
                    Capacitacionprograma capacitacion) {
        CapacitacionprogramaDTO dto = new CapacitacionprogramaDTO(
                capacitacion.getIdcapacitacionprograma(),
                null, null, capacitacion.getIdoferenteinstitucion(),
                capacitacion.getNombrecapacitacionprograma(),
                capacitacion.getFecharegistro());

        if (capacitacion.getCategoria() != null) {
            dto.setCategoria(categoriaToCategoriaDTO(
                    capacitacion.getCategoria()));
        }

        if (capacitacion.getEstadocapacitacionprograma() != null) {
            dto.setEstadocapacitacionprograma(
                    estadoCapacitacionToEstadoCapacitacionDTO(capacitacion
                            .getEstadocapacitacionprograma()));
        }
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param seguimiento Entidad.
     * @return DTO.
     */
    public static SeguimientoasistenciaDTO
            seguimientoasistenciaToSeguimientoasistenciaDTO(
                    Seguimientoasistencia seguimiento) {
        SeguimientoasistenciaDTO dto = new SeguimientoasistenciaDTO(seguimiento
                .getIdseguimientoasistencia(),
                null, null, null,
                seguimiento.getCantidadhorasasistencia(), seguimiento
                .getFecharegistro());

        if (seguimiento.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(seguimiento
                    .getFuncionario()));
        }

        if (seguimiento.getAlumnos() != null) {
            dto.setAlumnos(alumnosToAlumnosDTO(seguimiento.getAlumnos()));
        }

        if (seguimiento.getModulociclo() != null) {
            dto.setModulociclo(moduloToModuloDTO(seguimiento.getModulociclo()));
        }
        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param seguimientos Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<SeguimientoasistenciaDTO>
            listSeguimientoasistenciaToListSeguimientoAsistenciaDTO(
                    List<Seguimientoasistencia> seguimientos) {
        List<SeguimientoasistenciaDTO> dtos = new ArrayList();
        for (Seguimientoasistencia a : seguimientos) {
            dtos.add(seguimientoasistenciaToSeguimientoasistenciaDTO(a));
        }
        return dtos;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param aprobacion Entidad.
     * @return DTO.
     */
    public static AprobacionDTO aprobacionToAprobacionDTOFull(
            Aprobacion aprobacion) {
        AprobacionDTO dto = new AprobacionDTO(aprobacion.getIdaprobacion(),
                null, null, aprobacion.getPorcentajeaprobacionobtenido(),
                aprobacion.getCalificacionfinal(),
                aprobacion.getCalificacionfuncionario(),
                aprobacion.getFecharegistro());

        if (aprobacion.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    aprobacion.getFuncionario()));
        }

        if (aprobacion.getAlumnos() != null) {
            dto.setAlumnos(alumnosToAlumnosDTO(aprobacion.getAlumnos()));
        }
        return dto;
    }

    /**
     * Método para transformar una entidad a un DTO.
     *
     * @param aprobacion Entidad.
     * @return DTO.
     */
    public static AprobacionDTO aprobacionToAprobacionDTO(
            Aprobacion aprobacion) {
        AprobacionDTO dto = new AprobacionDTO(aprobacion.getIdaprobacion(),
                null, null, aprobacion.getPorcentajeaprobacionobtenido(),
                aprobacion.getCalificacionfinal(),
                aprobacion.getCalificacionfuncionario(),
                aprobacion.getFecharegistro());

        if (aprobacion.getFuncionario() != null) {
            dto.setFuncionario(funcionarioToFuncionarioDTO(
                    aprobacion.getFuncionario()));
        }

        return dto;
    }

    /**
     * Método para transformar una lista de entidades a lista de DTOs.
     *
     * @param aprobaciones Lista de entidades.
     * @return Lista de DTOs.
     */
    public static List<AprobacionDTO> listAprobacionToListAprobacionDTO(
            List<Aprobacion> aprobaciones) {
        List<AprobacionDTO> dtos = new ArrayList();
        for (Aprobacion a : aprobaciones) {
            dtos.add(aprobacionToAprobacionDTOFull(a));
        }
        return dtos;
    }

}
