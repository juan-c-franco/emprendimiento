/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Configuracion;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidadSIMPC.MdFDatosBasicos;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;

public interface BeneficiarioDAO {
    
    public static final String VALIDACION_INACTIVA = "Validación Inactiva";
    public static final String SI_CUMPLE = "Si cumple";
    public static final String NO_CUMPLE = "No cumple";

    public List<Beneficiario> getBeneficiarios() throws Exception;

    public List<Beneficiario> getBeneficiarios(
            Long idbeneficiario,
            String doc,
            String pNombre,
            String sNombre,
            String pApellido,
            String sApellido) throws Exception;

    public List<MdFDatosBasicos> getBeneficiarioPorNombreYApellido(String pNombre,
            String sNombre, String pApellido, String sApellido) throws Exception;

    public Beneficiario getBeneficiarioXId(long idBeneficiario) throws Exception;

    public Beneficiario getBeneficiario(String correo) throws Exception;

    public Beneficiario getBeneficiarioPorId(long idbeneficiario) throws Exception;

    public List<MdFDatosBasicos> consultaBeneficiario(String numDoc) throws Exception;

    public Beneficiario guardarBeneficiario(Beneficiario beneficiario)
            throws ConstraintViolationException, PersistenceException, Exception;

    public Beneficiario traerBeneficiario(String numDoc) throws Exception;

    public Beneficiario getBeneficiario(long saveIdBeneficiario) throws Exception;

    public boolean validaBeneficiario(String doc, String email) throws Exception;

    public List<Beneficiario> getNotificaBeneficiarios() throws Exception;

    public List<Temasrutaacompanamientoat> getTemasRutaAATPorDocBeneficiario(
            List<String> estadosEmprendimiento, String numeroDocumentoBen) throws Exception;

    public Object[] getBeneEmprPorDocBeneficiario(List<String> estadosEmprendimiento,
            String numeroDocumentoBen) throws Exception;

    public Beneficiario getBeneficiario(BigDecimal estadoUsuario, String userName) throws Exception;

    public List<String> verificarRequisitos(MdFDatosBasicos beneficiario, List<Configuracion> validaciones) throws Exception;
}
