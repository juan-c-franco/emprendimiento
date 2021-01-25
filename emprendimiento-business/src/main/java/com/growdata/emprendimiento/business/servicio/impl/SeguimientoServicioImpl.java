package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.evaluacion.RequestRegistrarInfoFinancieraBasica;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestNoEstablecido;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestRegistrarFormalizado;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.SeguimientoServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.DAO.FormalizadoDAO;
import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.DAO.NoestablecidoDAO;
import com.growdata.emprendimiento.persistence.DAO.PaisesDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.SeguimientoDAO;
import com.growdata.emprendimiento.persistence.entidad.Actividadinternacional;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Financiacion;
import com.growdata.emprendimiento.persistence.entidad.Formalizado;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Noestablecido;
import com.growdata.emprendimiento.persistence.entidad.Observacionesseguimiento;
import com.growdata.emprendimiento.persistence.entidad.Paises;
import com.growdata.emprendimiento.persistence.entidad.Paisescomercializa;
import com.growdata.emprendimiento.persistence.entidad.Sectorproductivo;
import com.growdata.emprendimiento.persistence.entidad.Seguimiento;
import com.growdata.emprendimiento.persistence.entidad.Tipoconstitucionlegal;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 07/12/2018
 *
 * @author Juan Carlos Franco
 */
@Service
public class SeguimientoServicioImpl implements SeguimientoServicio {

    @Autowired
    private FormalizadoDAO formalizadoDAO;
    @Autowired
    private NoestablecidoDAO noestablecidoDAO;
    @Autowired
    private EmprendimientoDAO emprendimientoDAO;
    @Autowired
    private FuncionarioDAO funcionarioDAO;
    @Autowired
    private SeguimientoDAO seguimientoDAO;
    @Autowired
    private PaisesDAO paisesDAO;
    @Autowired
    private PlantillaMailDAO plantillaMailDAO;
    @Autowired
    private EnviarEmail mail;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Controlador encargado de registrar la información de un Seguimiento
     * Fromalizado.
     *
     * @param request Datos del Emprendimiento
     * @param requestFinan Datos financieros del Emprendimiento
     * @return Respuesta si fue exitóso o no el cambio.
     */
    @Override
    public ResponseDTO guardarSeguimientoFormalizado(RequestRegistrarFormalizado request, RequestRegistrarInfoFinancieraBasica requestFinan) {
        ResponseDTO response = new ResponseDTO();
        String mAccion;
        try {
            Formalizado formalizado = null;
            Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorId(request.getIdEmprendimiento());
            if (emprendimiento == null) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_NOENCONTRADO);
                return response;
            }
            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(request.getIdFuncionario());
            if (!request.checkNullsFormalizado()) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_PARAMETROS);
                return response;
            }

            if (request.getIdFormalizado() == -1) {
                formalizado = new Formalizado();
                formalizado.setIdformalizacion(-1);
            } else {
                formalizado = formalizadoDAO.getFormalizadoPorId(request.getIdFormalizado());
            }

            Tipoconstitucionlegal tipoConstLegal = new Tipoconstitucionlegal();
            tipoConstLegal.setIdtipoconstitucionlegal(request.getConstitucion());
            Sectorproductivo sectorProd = new Sectorproductivo();
            sectorProd.setIdsectorproductivo(request.getSector());
            Actividadinternacional actInter = new Actividadinternacional();
            actInter.setIdactividadinternacional(request.getActividad());
            formalizado.setEmprendimiento(emprendimiento);
            formalizado.setTipoconstitucionlegal(tipoConstLegal);
            formalizado.setSectorproductivo(sectorProd);
            formalizado.setActividadinternacional(actInter);
            formalizado.setMunicipio(request.getIdmunicipio());
            formalizado.setNombreempresa(request.getNombreEmpresa());
            formalizado.setRepresentantelegal(request.getNombreRepresentante());
            formalizado.setProductoservicioofrece(request.getProdServ());
            formalizado.setNegociosinternet(request.getNegInternet());
            formalizado.setNumeroregistromercantil(request.getnRegistroMercantil());
            formalizado.setFecharenovacion(request.getFechaRenov());
            formalizado.setNit(request.getNit());
            formalizado.setFechainiciolabores(request.getFechaInicio());
            formalizado.setEmpleosdirectos(request.getEmpDirectos());
            formalizado.setEmpleosindirectos(request.getEmpIndirectos());
            formalizado.setDireccionempresa(request.getDireccion());
            formalizado.setTelefonoempresa(request.getTelefono());
            formalizado.setEmailempresa(request.getEmail());
            formalizado.setSitioweb(request.getWeb());

            Set<Paisescomercializa> paisescomercializas = new HashSet<Paisescomercializa>(0);

            for (String p : request.getPaisesComercializa().get(0)) {
                Paises pais = paisesDAO.getPaisesPorId(Integer.valueOf(p));
                Paisescomercializa pComercializa = new Paisescomercializa(0, formalizado, pais);
                paisescomercializas.add(pComercializa);

            }
            formalizado.setPaisescomercializas(paisescomercializas);
            mAccion = Acciones.SEGUIMIENTO_FORMALIZADO;
            Seguimiento seguimiento = new Seguimiento(0, emprendimiento, funcionario,
                    '1', new Date(), null);

            Observacionesseguimiento observaciones = new Observacionesseguimiento(
                    0, funcionario, seguimiento, request.getObservacionesS(), new Date());

            Financiacion financiacion = new Financiacion();
            financiacion.setFuncionario(funcionario);
//            financiacion.setEmprendimiento(emprendimiento);
            financiacion.setCapitaltotal(requestFinan.getCapitaltotal());
            financiacion.setCapitaltrabajo(requestFinan.getCapitaltrabajo());
            financiacion.setEmpleosgenerados(requestFinan.getEmpleosgenerados());
            financiacion.setEmpleosporgenerar(requestFinan.getEmpleosporgenerar());
            financiacion.setMesespuntoequilibrio(requestFinan.getMesespuntoequilibrio());
            financiacion.setRecursospropiosae(requestFinan.getRecursospropiosae());
//            financiacion.setFecharegistro(new Date());

            long id = seguimientoDAO.guardarSeguimientoFormalizado(formalizado, observaciones,
                    seguimiento, financiacion, request.getFinalizado());

            int idPlantilla = 16;
            if (request.getRequierePlan() == 1) {
                idPlantilla = 17;
            }

            for (Asociados a : emprendimiento.getAsociadoses()) {
                Beneficiario b = a.getBeneficiario();
//                PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
//                String msg = plantilla.getPlantilla();
//                msg = msg.replace("<#nombres#>", b.getPrimernombre() + " "
//                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
//                msg = msg.replace("<#apellidos#>", b.getPrimerapellido() + " "
//                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
//                msg = msg.replace("<#nombreEmprendimiento#>", emprendimiento.getNombreemprendimiento());
//                msg = msg.replace("<#anexo#>", (request.getFinalizado() ? "Su emprendimiento ha cambiado a estado finalizado" : ""));
//                final String email = b.getEmail();
//                final String asunto = plantilla.getAsunto();
//                final String plantillaFinal = msg;
////                Runnable runnable = () -> {
////                    mail.enviarEmail(email, asunto, plantillaFinal);
////                };
////                new Thread(runnable).start();
//                mail.enviarEmail(b.getEmail(), plantilla.getAsunto(), msg);

                mail.setNombres(b.getPrimernombre() + " "
                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
                mail.setApellidos(b.getPrimerapellido() + " "
                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
                mail.setNombreEmprendimiento(emprendimiento.getNombreemprendimiento());
                mail.setAnexo((request.getFinalizado() ? "Su emprendimiento ha cambiado a estado finalizado" : ""));
                mail.notificarGenerica(idPlantilla, b.getEmail());
            }

            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CREAR_SEGUIMIENTO);
            response.setAccion(Acciones.REGISTRAR_SEGUIMIENTO + mAccion);
            response.setId(id);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(Mensajes.ERROR_CREAR_SEGUIMIENTO);
            response.setStatus("0");
        }

        return response;
    }

    /**
     * Servicio encargado de registrar la información de un Seguimiento No
     * Establecido.
     *
     * @param request Datos del Emprendimiento
     * @param requestFinan Datos financieros del Emprendimiento
     * @return Respuesta si fue exitóso o no el cambio.
     */
    public ResponseDTO guardarSeguimientoNoEstablecido(RequestNoEstablecido request,
            RequestRegistrarInfoFinancieraBasica requestFinan) {
        ResponseDTO response = new ResponseDTO();
        String mAccion;
        try {
            Noestablecido noEstablecido = null;
            Emprendimiento emprendimiento = emprendimientoDAO.getEmprendimientoPorId(request.getIdEmprendimiento());
            if (emprendimiento == null) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_NOENCONTRADO);
                return response;
            }

            Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(request.getIdFuncionario());
            if (!request.checkNullsNoEstablecido()) {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_PARAMETROS);
                return response;
            }

            if (request.getIdNoEstablecido() == new BigDecimal(-1)) {
                noEstablecido = new Noestablecido();
                noEstablecido.setIdnoestablecido(new BigDecimal(-1));
            } else {
                noEstablecido = noestablecidoDAO.getNoEstablecidoPorId(request.getIdNoEstablecido());
            }

            Tipoconstitucionlegal tipoConstLegal = new Tipoconstitucionlegal();
            tipoConstLegal.setIdtipoconstitucionlegal(request.getConstitucion());
            Sectorproductivo sectorProd = new Sectorproductivo();
            sectorProd.setIdsectorproductivo(request.getSector());

            noEstablecido.setEmprendimiento(emprendimiento);
            noEstablecido.setTipoconstitucionlegal(tipoConstLegal);
            noEstablecido.setSectorproductivo(sectorProd);
            noEstablecido.setProductoservicioofrece(request.getProdServ());
            noEstablecido.setCuandoinicia(request.getCuandoInicia());
            noEstablecido.setObservaciones(request.getObservaciones());

            mAccion = Acciones.SEGUIMIENTO_NO_FORMALIZADO;
            Seguimiento seguimiento = new Seguimiento(0, emprendimiento, funcionario,
                    '0', new Date(), null);

            Observacionesseguimiento observaciones = new Observacionesseguimiento(
                    0, funcionario, seguimiento, request.getObservacionesS(), new Date());

            Financiacion financiacion = new Financiacion();
            financiacion.setFuncionario(funcionario);
//            financiacion.setEmprendimiento(emprendimiento);
            financiacion.setCapitaltotal(requestFinan.getCapitaltotal());
            financiacion.setCapitaltrabajo(requestFinan.getCapitaltrabajo());
            financiacion.setEmpleosgenerados(requestFinan.getEmpleosgenerados());
            financiacion.setEmpleosporgenerar(requestFinan.getEmpleosporgenerar());
            financiacion.setMesespuntoequilibrio(requestFinan.getMesespuntoequilibrio());
            financiacion.setRecursospropiosae(requestFinan.getRecursospropiosae());
//            financiacion.setFecharegistro(new Date());

            long id = seguimientoDAO.guardarSeguimientoNoEstablecido(noEstablecido,
                    observaciones, seguimiento, financiacion, request.isFinalizado());

            int idPlantilla = 16;
            if (request.getRequierePlan() == 1) {
                idPlantilla = 17;
            }

            for (Asociados a : emprendimiento.getAsociadoses()) {
                Beneficiario b = a.getBeneficiario();
//                PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
//                String msg = plantilla.getPlantilla();
//                msg = msg.replace("<#nombres#>", b.getPrimernombre() + " "
//                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
//                msg = msg.replace("<#apellidos#>", b.getPrimerapellido() + " "
//                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
//                msg = msg.replace("<#nombreEmprendimiento#>", emprendimiento.getNombreemprendimiento());
//                msg = msg.replace("<#anexo#>", (request.isFinalizado() ? "Su emprendimiento ha cambiado a estado finalizado" : ""));
//                final String email = b.getEmail();
//                final String asunto = plantilla.getAsunto();
//                final String plantillaFinal = msg;
////                Runnable runnable = () -> {
////                    mail.enviarEmail(email, asunto, plantillaFinal);
////                };
////                new Thread(runnable).start();
//                mail.enviarEmail(b.getEmail(), plantilla.getAsunto(), msg);

                mail.setNombres(b.getPrimernombre() + " "
                        + (b.getSegundonombre() != null ? b.getSegundonombre() : ""));
                mail.setApellidos(b.getPrimerapellido() + " "
                        + (b.getSegundoapellido() != null ? b.getSegundoapellido() : ""));
                mail.setNombreEmprendimiento(emprendimiento.getNombreemprendimiento());
                mail.setAnexo((request.isFinalizado()? "Su emprendimiento ha cambiado a estado finalizado" : ""));
                mail.notificarGenerica(idPlantilla, b.getEmail());
            }

            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_CREAR_SEGUIMIENTO);
            response.setAccion(Acciones.REGISTRAR_SEGUIMIENTO + mAccion);
            response.setId(id);
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(Mensajes.ERROR_CREAR_SEGUIMIENTO);
            response.setStatus("0");
        }

        return response;

    }
}
