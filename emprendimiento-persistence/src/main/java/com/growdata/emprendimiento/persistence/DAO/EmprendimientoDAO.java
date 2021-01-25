package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

public interface EmprendimientoDAO {

    public Emprendimiento getEmprendimientoXIdYEstado(long idEmprendimiento,
            List<String> estados, BigDecimal idCaja) throws Exception;

    public Emprendimiento getEmprendimientoXIdYEstado2(long idEmprendimiento,
            List<String> estados, BigDecimal idCaja) throws Exception;

    public List<Emprendimiento> getEmprendimientosPorEstado(
            List<String> estadosEmprendimiento) throws Exception;

    public List<Emprendimiento> getEmprendimientosPorEdo(List<String> estados,
            BigDecimal idcajacompensacion) throws Exception;

    public Emprendimiento getEmprendimientoPorId(long idEmprendimiento) throws Exception;

    public List<Emprendimiento> getEmprendimientoPorNombre(String nombreEmprendimiento,
            List<String> estados, BigDecimal idCaja) throws Exception;

    public long guardarFormalizado(Long idFuncionario,
            BigDecimal idcajacompensacion,
            String nombreEmpresa,
            String nit,
            String nRegistroMercantil,
            String nombreRepresentante,
            String nombreEmprendimiento,
            String direccion,
            Long telefono,
            String email,
            String web,
            BigDecimal constitucion,
            BigDecimal sector,
            BigDecimal tEmprendimiento,
            List<List<String>> paisesComercializa,
            List<String> beneficiarios,
            Character negInternet,
            String prodServ,
            Date fechaRenov,
            Date fechaInicio,
            BigDecimal actividad,
            BigDecimal empDirectos,
            BigDecimal empIndirectos,
            int meses_antes,
            int idmunicipio) throws Exception;

    public long guardarNoEstablecido(Long idFuncionario,
            BigDecimal idcajacompensacion,
            String nombreEmprendimiento,
            BigDecimal tEmprendimiento,
            BigDecimal constitucion,
            BigDecimal sector,
            List<String> beneficiarios,
            String prodServ,
            Date cuandoInicia,
            String observaciones,
            int meses_antes) throws Exception;

    public Emprendimiento getEmprendimientoPorBeneficiarioYFuncionario(
            List<String> estadosEmprendimiento, String numeroDocumentoBen,
            BigDecimal idCajaCompensacion) throws Exception;

    public void updateEmprendimiento(long idemprendimiento,
            Estadoemprendimiento estadoEmprendimiento) throws HibernateException;

    public Estadoemprendimiento getEstadoEmprendimiento(BigDecimal idestadoemprendimiento)
            throws Exception;

    public List<Emprendimiento> getEmprendimientosComite(long idSesionComite,
            int estadoEmprendimiento, BigDecimal idcajacompensacion) throws Exception;

    public List<Emprendimiento> getEmprendimientosComitePorIdSesion(long idSesionComite)
            throws Exception;

}
