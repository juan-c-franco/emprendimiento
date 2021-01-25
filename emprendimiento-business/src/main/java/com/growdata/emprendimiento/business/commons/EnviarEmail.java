/**
 * @Author Andrés Felipe González Growdata
 */
package com.growdata.emprendimiento.business.commons;

import com.growdata.emprendimiento.persistence.DAO.AlumnosDAO;
import com.growdata.emprendimiento.persistence.DAO.Impl.AlumnosDAOImpl;
import com.growdata.emprendimiento.persistence.DAO.Impl.ListaAsistenciaDAOImpl;
import com.growdata.emprendimiento.persistence.DAO.Impl.PlantillaMailDAOImpl;
import com.growdata.emprendimiento.persistence.DAO.Impl.ProgramacionDAOImpl;
import com.growdata.emprendimiento.persistence.DAO.Impl.SesionesDAOImpl;
import com.growdata.emprendimiento.persistence.DAO.ListaAsistenciaDAO;
import com.growdata.emprendimiento.persistence.DAO.PlantillaMailDAO;
import com.growdata.emprendimiento.persistence.DAO.ProgramacionDAO;
import com.growdata.emprendimiento.persistence.DAO.SesionesDAO;
import com.growdata.emprendimiento.persistence.entidad.Alumnos;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.PlantillaMail;
import com.growdata.emprendimiento.persistence.entidad.Programacion;
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * Clase responsable de enviar correos electr�nicos.
 *
 * @author Andrés Felipe González Grow Data
 */
//@PropertySource("classpath:parametros.properties")
@PropertySource("file:${APP_CONFIG}/emprendimiento/config.properties")
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EnviarEmail extends Thread {

    /**
     * Propiedades.
     */
    private final Properties propiedades = new Properties();

    /**
     * Sesi�n.
     */
    private Session session;

    /**
     * Ambiente de propiedades.
     */
    @Autowired
    private Environment env;

    /**
     * Log de errores de email.
     */
    @Autowired
    private LoggerMail logMail;

    /**
     * Log de errores de la aplicaci�n.
     */
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Ruta de archivo de configuraci�n.
     */
    @Value("${APP_CONFIG}")
    private String configPath;

    /**
     * Plantilla.
     */
    private String plantillaMail;
    /**
     * Nombres.
     */
    private String nombres;
    /**
     * Apellidos.
     */
    private String apellidos;
    /**
     * Telefono.
     */
    private String telefono;
    /**
     * Documento.
     */
    private String documento;
    /**
     * Descripci�n de la sesi�n.
     */
    private String descripcionSesion;
    /**
     * Ubicaci�n de la sesi�n.
     */
    private String ubicacionSesion;
    /**
     * Fecha de inicio.
     */
    private String fechaInicio;
    /**
     * Fecha de fin.
     */
    private String fechaFin;
    /**
     * Tipo de sesi�n.
     */
    private String tipoSesion;
    /**
     * Usuario.
     */
    private String usuario;
    /**
     * Contrase�a.
     */
    private String contrasena;
    /**
     * Identificador del usuario.
     */
    private String iduser;
    /**
     * Identificador del emprendimiento.
     */
    private String idEmprendimiento;
    /**
     * Identificador del funcionario.
     */
    private String idFuncionario;
    /**
     * Identificador del beneficiario.
     */
    private String idBeneficiario;
    /**
     * Identificador de la encuesta.
     */
    private String idEncuesta;
    /**
     * Cantidad de meses.
     */
    private String meses;
    /**
     * Tema ruta AAT.
     */
    private String temasRuta;
    /**
     * Fecha de caducidad.
     */
    private String fechaCaducidad;
    /**
     * Horas.
     */
    private String horas;
    /**
     * Asistentes.
     */
    private String asistentes;
    /**
     * Nombre del emprendimiento.
     */
    private String nombreEmprendimiento;
    /**
     * Estado del emprendimiento.
     */
    private String nombreEstadoEmprendimiento;
    /**
     * Nombre de la empresa.
     */
    private String nombreEmpresa;
    /**
     * nit de la empresa.
     */
    private String nit;
    /**
     * N�mero de registro mercantil.
     */
    private String registroMercantil;
    /**
     * Nombre del representante legal.
     */
    private String nombreRepresentante;
    /**
     * Anexos.
     */
    private String anexo;

    /**
     * Constructor.
     */
    public EnviarEmail() {
        this.nombres = "";
        this.apellidos = "";
        this.telefono = "";
        this.documento = "";
        this.descripcionSesion = "";
        this.ubicacionSesion = "";
        this.fechaInicio = "";
        this.fechaFin = "";
        this.tipoSesion = "";
        this.usuario = "";
        this.contrasena = "";
        this.iduser = "";
        this.idEmprendimiento = "";
        this.idFuncionario = "";
        this.idBeneficiario = "";
        this.idEncuesta = "";
        this.meses = "";
        this.horas = "";
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAnexo() {
        return anexo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param anexo Valor a ser actualizado.
     */
    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreEmpresa Valor a ser actualizado.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNit() {
        return nit;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nit Valor a ser actualizado.
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getRegistroMercantil() {
        return registroMercantil;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param registroMercantil Valor a ser actualizado.
     */
    public void setRegistroMercantil(String registroMercantil) {
        this.registroMercantil = registroMercantil;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreRepresentante Valor a ser actualizado.
     */
    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEstadoEmprendimiento() {
        return nombreEstadoEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreEstadoEmprendimiento Valor a ser actualizado.
     */
    public void setNombreEstadoEmprendimiento(
            String nombreEstadoEmprendimiento) {
        this.nombreEstadoEmprendimiento = nombreEstadoEmprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreEmprendimiento Valor a ser actualizado.
     */
    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechaCaducidad Valor a ser actualizado.
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getTemasRuta() {
        return temasRuta;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasRuta Valor a ser actualizado.
     */
    public void setTemasRuta(String temasRuta) {
        this.temasRuta = temasRuta;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getMeses() {
        return meses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param meses Valor a ser actualizado.
     */
    public void setMeses(String meses) {
        this.meses = meses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idFuncionario Valor a ser actualizado.
     */
    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getIdBeneficiario() {
        return idBeneficiario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idBeneficiario Valor a ser actualizado.
     */
    public void setIdBeneficiario(String idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getIdEncuesta() {
        return idEncuesta;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idEncuesta Valor a ser actualizado.
     */
    public void setIdEncuesta(String idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getIdEmprendimiento() {
        return idEmprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idEmprendimiento Valor a ser actualizado.
     */
    public void setIdEmprendimiento(String idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getIduser() {
        return iduser;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param iduser Valor a ser actualizado.
     */
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombres Valor a ser actualizado.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param apellidos Valor a ser actualizado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param telefono Valor a ser actualizado.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param documento Valor a ser actualizado.
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcionSesion() {
        return descripcionSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param descripcionSesion Valor a ser actualizado.
     */
    public void setDescripcionSesion(String descripcionSesion) {
        this.descripcionSesion = descripcionSesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUbicacionSesion() {
        return ubicacionSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param ubicacionSesion Valor a ser actualizado.
     */
    public void setUbicacionSesion(String ubicacionSesion) {
        this.ubicacionSesion = ubicacionSesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechaInicio Valor a ser actualizado.
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechaFin Valor a ser actualizado.
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getTipoSesion() {
        return tipoSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipoSesion Valor a ser actualizado.
     */
    public void setTipoSesion(String tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param usuario Valor a ser actualizado.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param contrasena Valor a ser actualizado.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Session getSession() {
        return session;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param session Valor a ser actualizado.
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getHoras() {
        return horas;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param horas Valor a ser actualizado.
     */
    public void setHoras(String horas) {
        this.horas = horas;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getAsistentes() {
        return asistentes;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param asistentes Valor a ser actualizado.
     */
    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    /**
     * M�todo para inicializar el env�o de correos.
     */
    private void init() {

        propiedades.put("mail.smtp.host", env.getProperty("email.dominio"));
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", 587);
        propiedades.put("mail.smtp.mail.sender", env.getProperty("email.email"));
        propiedades.put("mail.smtp.user", env.getProperty("email.usuario"));
        propiedades.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(propiedades);

        try {
            //Leer plantilla html
            plantillaMail = obtenerPlantilla();
        } catch (IOException ex) {
            log.writeToLogFile(ex);
            logMail.writeToLogFile(ex);
        }

    }

    /**
     * M�todo para enviar emails.
     *
     * @param correo Direccion de correo electronico.
     * @param asunto Asunto del correo electronico.
     * @param cuerpo Mensaje del correo electronico.
     * @return Indica si se envi� satisfactoriamente el correo.
     */
    public boolean enviarEmail(String correo, String asunto, String cuerpo) {
        init();
        boolean enviado = false;
        String plantilla = plantillaMail;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) propiedades.get("mail.smtp.mail.sender")));
            String[] tokens = correo.split(";");
            for (String email : tokens) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject(asunto);
            if (plantilla != null) {
                plantilla = plantilla.replaceAll("<#host#>", env.getProperty("dominio.servidor.app"));
                plantilla = plantilla.replaceAll("<#fecha#>", obtenerFecha());
                plantilla = plantilla.replaceAll("<#mensaje#>", cuerpo);
                message.setContent(plantilla, "text/html; charset=utf-8");
            } else {
                message.setContent(cuerpo, "text/html; charset=utf-8");
            }

            Transport t = session.getTransport("smtp");
            t.connect(env.getProperty("email.email"), env.getProperty("email.password", ""));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            enviado = true;

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            logMail.writeToLogFile(ex);
        }
        return enviado;
    }

    /**
     * M�todo que valida si un email es v�lido.
     *
     * @param correo Correo electr�nico a validar.
     * @return Respuesta si es v�lido o no.
     */
    public boolean validarEmail(String correo) {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * M�todo gen�rico para notificar a los beneficiario y funcionarios ante
     * posibles cambios en las sesiones de tipo: Sensibilizaci�n, Valoraci�n,
     * Evaluaci�n y Seguimiento.
     *
     * @param idPlantilla Identificador de la Plantilla a utilizar para enviar
     * correo.
     * @param sesion Sesi�n de la cual extraer la informaci�n para notificar.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    public void notificaBeneficiariosGenerica(long idPlantilla, Sesiones sesion) throws Exception {
        List<Listaasistencia> listaAsistencia = null;
        ListaAsistenciaDAO listaAsistenciaDAO = new ListaAsistenciaDAOImpl();
        PlantillaMailDAO plantillaMailDAO = new PlantillaMailDAOImpl();
        SesionesDAO sesionesDAO = new SesionesDAOImpl();

        try {
            listaAsistencia = listaAsistenciaDAO.getLista((int) sesion.getIdsesion());
            sesion = sesionesDAO.getSesiones(sesion.getIdsesion());

            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);

            String sesionType = "";
            switch (sesion.getTiposesion().getIdtiposesion().intValue()) {
                case 1:
                    sesionType = "Sensibilizaci�n";
                    break;
                case 2:
                    sesionType = "Valoraci�n";
                    break;
                case 3:
                    sesionType = "Evaluaci�n y Financiaci�n";
                    break;
                case 4:
                    sesionType = "Puesta en Marcha";
                    break;
                default:
                    break;
            }

            String nombresAsociados = "";

            for (Listaasistencia asis : listaAsistencia) {
                String tempPlantilla = new String(plantilla.getPlantilla());
                String nombre = " <br> ";
                nombre += asis.getBeneficiario().getPrimernombre() + " " + (asis.getBeneficiario().getSegundonombre() != null ? asis.getBeneficiario().getSegundonombre() + " " : "");
                nombre += asis.getBeneficiario().getPrimerapellido() + " " + (asis.getBeneficiario().getSegundoapellido() != null ? asis.getBeneficiario().getSegundoapellido() + " " : "");
                nombresAsociados += nombre;
                nombresAsociados += " <br> ";
                tempPlantilla = tempPlantilla.replace("<#nombres#>", nombre);
                tempPlantilla = tempPlantilla.replace("<#apellidos#>", "");
                tempPlantilla = tempPlantilla.replace("<#telefono#>", String.valueOf(asis.getBeneficiario().getTelefono()));
                tempPlantilla = tempPlantilla.replace("<#documento#>", String.valueOf(asis.getBeneficiario().getNumerodocumento()));
                tempPlantilla = tempPlantilla.replace("<#descripcionSesion#>", sesion.getDescripcion());
                tempPlantilla = tempPlantilla.replace("<#ubicacionSesion#>", sesion.getUbicacion());
                tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", sesion.getFechainicio().toString());
                tempPlantilla = tempPlantilla.replace("<#fechaFin#>", sesion.getFechafinal().toString());
                tempPlantilla = tempPlantilla.replace("<#tipoSesion#>", sesionType);
                tempPlantilla = tempPlantilla.replace("<#asistentes#>", "");

                final String email = asis.getBeneficiario().getEmail();
                final String asunto = plantilla.getAsunto();
                final String plantillaFinal = tempPlantilla;
                Runnable runnable = () -> {
                    this.enviarEmail(email, asunto, plantillaFinal);
                };
                new Thread(runnable).start();
//                this.enviarEmail(email, asunto, plantillaFinal);
            }

            String tempPlantilla = plantilla.getPlantilla();
            tempPlantilla = tempPlantilla.replace("<#nombres#>", sesion.getFuncionario().getPrimerapellido() + " " + sesion.getFuncionario().getPrimernombre());
            tempPlantilla = tempPlantilla.replace("<#apellidos#>", "");
            tempPlantilla = tempPlantilla.replace("<#telefono#>", "");
            tempPlantilla = tempPlantilla.replace("<#documento#>", "");
            tempPlantilla = tempPlantilla.replace("<#descripcionSesion#>", sesion.getDescripcion());
            tempPlantilla = tempPlantilla.replace("<#ubicacionSesion#>", sesion.getUbicacion());
            tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", sesion.getFechainicio().toString());
            tempPlantilla = tempPlantilla.replace("<#fechaFin#>", sesion.getFechafinal().toString());
            tempPlantilla = tempPlantilla.replace("<#tipoSesion#>", sesionType);
            tempPlantilla = tempPlantilla.replace("<#asistentes#>", "Lista de Asistentes:<br>" + nombresAsociados);

            final String email = sesion.getFuncionario().getEmail();
            final String asunto = plantilla.getAsunto();
            final String plantillaFinal = tempPlantilla;
            Runnable runnable = () -> {
                this.enviarEmail(email, asunto, plantillaFinal);
            };
            new Thread(runnable).start();
//            this.enviarEmail(email, asunto, plantillaFinal);
        } catch (Exception ex) {
            logMail.writeToLogFile(ex);
            throw ex;
        }
    }

    /**
     * M�todo gen�rico para notificar a los beneficiario y funcionarios ante
     * posibles cambios en las programaciones.
     *
     * @param idPlantilla Identificador de la Plantilla a utilizar para enviar
     * correo.
     * @param programacion Programaci�n de la cual extraer la informaci�n para
     * notificar.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    public void notificaProgramacionGenerica(long idPlantilla, Programacion programacion) throws Exception {
        List<Alumnos> alumnos = null;
        AlumnosDAO alumnosDAO = new AlumnosDAOImpl();
        PlantillaMailDAO plantillaMailDAO = new PlantillaMailDAOImpl();
        ProgramacionDAO programacionDAO = new ProgramacionDAOImpl();

        try {
            alumnos = alumnosDAO.getLista(programacion.getIdprogramacion());
            programacion = programacionDAO.getProgramacion(programacion.getIdprogramacion());

            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);

            String nombresAsociados = "";

            for (Alumnos alumno : alumnos) {
                String tempPlantilla = plantilla.getPlantilla();
                String nombre = " <br> ";
                nombre += alumno.getBeneficiario().getPrimernombre() + " " + (alumno.getBeneficiario().getSegundonombre() != null ? alumno.getBeneficiario().getSegundonombre() + " " : "");
                nombre += alumno.getBeneficiario().getPrimerapellido() + " " + (alumno.getBeneficiario().getSegundoapellido() != null ? alumno.getBeneficiario().getSegundoapellido() + " " : "");
                nombresAsociados += nombre;
                nombresAsociados += " <br> ";
                tempPlantilla = tempPlantilla.replace("<#nombres#>", nombre);
                tempPlantilla = tempPlantilla.replace("<#apellidos#>", "");
                tempPlantilla = tempPlantilla.replace("<#titulo#>", programacion.getCapacitacionprograma().getNombrecapacitacionprograma());
                tempPlantilla = tempPlantilla.replace("<#telefono#>", String.valueOf(alumno.getBeneficiario().getTelefono()));
                tempPlantilla = tempPlantilla.replace("<#documento#>", String.valueOf(alumno.getBeneficiario().getNumerodocumento()));
                tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", programacion.getFechainicioprogramacion().toString());
                tempPlantilla = tempPlantilla.replace("<#fechaFin#>", programacion.getFechafinalrogramacion().toString());
                tempPlantilla = tempPlantilla.replace("<#asistentes#>", "");
                final String email = alumno.getBeneficiario().getEmail();
                final String asunto = plantilla.getAsunto();
                final String plantillaFinal = tempPlantilla;
                Runnable runnable = () -> {
                    this.enviarEmail(email, asunto, plantillaFinal);
                };
                new Thread(runnable).start();
//                this.enviarEmail(email, asunto, plantillaFinal);
            }

            String tempPlantilla = new String(plantilla.getPlantilla());
            tempPlantilla = tempPlantilla.replace("<#nombres#>",
                    programacion.getDocentes().getPrimerapellido() + " "
                    + programacion.getDocentes().getPrimernombre());
            tempPlantilla = tempPlantilla.replace("<#apellidos#>", "");
            tempPlantilla = tempPlantilla.replace("<#telefono#>", "");
            tempPlantilla = tempPlantilla.replace("<#documento#>", "");
            tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", programacion.getFechainicioprogramacion().toString());
            tempPlantilla = tempPlantilla.replace("<#fechaFin#>", programacion.getFechafinalrogramacion().toString());
            tempPlantilla = tempPlantilla.replace("<#titulo#>", programacion.getCapacitacionprograma().getNombrecapacitacionprograma());
            tempPlantilla = tempPlantilla.replace("<#asistentes#>", nombresAsociados);

            final String email = programacion.getDocentes().getEmail();
            final String asunto = plantilla.getAsunto();
            final String plantillaFinal = tempPlantilla;
            Runnable runnable = () -> {
                this.enviarEmail(email, asunto, plantillaFinal);
            };
            new Thread(runnable).start();
//            this.enviarEmail(email, asunto, plantillaFinal);
        } catch (Exception ex) {
            logMail.writeToLogFile(ex);
            throw ex;
        }
    }

    /**
     * M�todo generico de envio de correos a partir de un id de plantilla y un
     * email.
     *
     * @param idPlantilla Identificador de la planilla.
     * @param correo Direccion de correo electronico.
     * @return Indica si se envi� satisfactoriamente el correo.
     * @throws Exception Cualquier Exception.
     */
    public boolean notificarGenerica(long idPlantilla, String correo) throws Exception {
        try {
            PlantillaMailDAO plantillaMailDAO = new PlantillaMailDAOImpl();
            PlantillaMail plantilla = plantillaMailDAO.consultaPlantillaXId(idPlantilla);
            String tempPlantilla = new String(plantilla.getPlantilla());
            String tempParametros;
            String tempParaEncriptados;

            tempPlantilla = tempPlantilla.replace("<#temasRuta#>", temasRuta != null ? temasRuta : "");
            tempPlantilla = tempPlantilla.replace("<#meses#>", meses != null ? meses : "");
            tempPlantilla = tempPlantilla.replace("<#usuario#>", usuario != null ? usuario : "");
            tempPlantilla = tempPlantilla.replace("<#contrasena#>", contrasena != null ? contrasena : "");
            tempPlantilla = tempPlantilla.replace("<#nombres#>", nombres != null ? nombres : "");
            tempPlantilla = tempPlantilla.replace("<#apellidos#>", apellidos != null ? apellidos : "");
            tempPlantilla = tempPlantilla.replace("<#telefono#>", telefono != null ? telefono : "");
            tempPlantilla = tempPlantilla.replace("<#documento#>", documento != null ? documento : "");
            tempPlantilla = tempPlantilla.replace("<#descripcionSesion#>", descripcionSesion != null ? descripcionSesion : "");
            tempPlantilla = tempPlantilla.replace("<#ubicacionSesion#>", ubicacionSesion != null ? ubicacionSesion : "");
            tempPlantilla = tempPlantilla.replace("<#fechaInicio#>", fechaInicio != null ? fechaInicio : "");
            tempPlantilla = tempPlantilla.replace("<#fechaFin#>", fechaFin != null ? fechaFin : "");
            tempPlantilla = tempPlantilla.replace("<#tipoSesion#>", tipoSesion != null ? tipoSesion : "");
            tempPlantilla = tempPlantilla.replace("<#horas#>", horas != null ? horas : "");
            tempPlantilla = tempPlantilla.replace("<#asistentes#>", asistentes != null ? asistentes : "");
            tempPlantilla = tempPlantilla.replace("<#ip#>", env.getProperty("ip.servidor.app"));
            tempPlantilla = tempPlantilla.replace("<#nombreEmpresa#>", nombreEmpresa != null ? nombreEmpresa : "");
            tempPlantilla = tempPlantilla.replace("<#NIT#>", nit != null ? nit : "");
            tempPlantilla = tempPlantilla.replace("<#anexo#>", anexo != null ? anexo : "");
            tempPlantilla = tempPlantilla.replace("<#registroMercantil#>", registroMercantil != null ? registroMercantil : "");
            tempPlantilla = tempPlantilla.replace("<#nombreRepresentante#>", nombreRepresentante != null ? nombreRepresentante : "");
            tempPlantilla = tempPlantilla.replace("<#nombreEmprendimiento#>", nombreEmprendimiento != null ? nombreEmprendimiento : "");
            tempPlantilla = tempPlantilla.replace("<#idEmprendimiento#>", idEmprendimiento != null ? idEmprendimiento : "");
            tempPlantilla = tempPlantilla.replace("<#nombreEstadoEmprendimiento#>", nombreEstadoEmprendimiento != null ? nombreEstadoEmprendimiento : "");
            if (plantilla.getParametros() != null) {
                tempParametros = plantilla.getParametros();
                tempParametros = tempParametros.replace("<#idFuncionario#>", idFuncionario != null ? idFuncionario : "");
                tempParametros = tempParametros.replace("<#idBeneficiario#>", idBeneficiario != null ? idBeneficiario : "");
                tempParametros = tempParametros.replace("<#idEncuesta#>", idEncuesta != null ? idEncuesta : "");
                tempParametros = tempParametros.replace("<#idEmprendimiento#>", idEmprendimiento != null ? idEmprendimiento : "");
                tempParametros = tempParametros.replace("<#iduser#>", iduser != null ? iduser : "");
                tempParametros = tempParametros.replace("<#fechaCaducidad>", fechaCaducidad != null ? fechaCaducidad : "");
                tempParaEncriptados = EncriptadorUrl.encode(tempParametros);
                switch ((int) idPlantilla) {
                    case 29:
                        tempParaEncriptados = "xjzlv=" + tempParaEncriptados;
                        break;
                    case 27:
                        tempParaEncriptados = "xthewr=" + tempParaEncriptados;
                        break;
                    case 20:
                        tempParaEncriptados = "hfgrt=" + tempParaEncriptados;
                        break;
                    default:
                        break;
                }

                tempPlantilla = tempPlantilla.replace("<#parametrosEncriptados#>", tempParaEncriptados);
            }
            final String email = correo;
            final String asunto = plantilla.getAsunto();
            final String plantillaFinal = tempPlantilla;
            Runnable runnable = () -> {
                this.enviarEmail(email, asunto, plantillaFinal);
            };
            new Thread(runnable).start();
//            this.enviarEmail(email, asunto, plantillaFinal);
        } catch (Exception ex) {
            logMail.writeToLogFile(ex);
            log.writeToLogFile(ex);
            throw new Exception(Mensajes.ERROR_ENVIO_CORREO);
        }
        return true;
    }

    /**
     * M�todo que obtiene la plantilla html para envio de correo.
     *
     * @return La cadena que contiene la plantilla.
     * @throws Exception de lectura del archivo que contiene la plantilla.
     */
    private String obtenerPlantilla() throws FileNotFoundException,
            IOException {
        String path = this.configPath + "/emprendimiento/correo.html";
        StringBuilder builder = new StringBuilder();

        try (
                FileInputStream file = new FileInputStream(path)) {
            InputStreamReader reader = new InputStreamReader(file, "UTF-8");

            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        }

        return builder.toString();
    }

    /**
     * M�todo para obtener fecha.
     *
     * @return
     */
    private String obtenerFecha() {
        SimpleDateFormat format = new SimpleDateFormat("EEEEEE, "
                + "dd 'de ' MMMMM 'de ' yyyy", new Locale("es", "ES"));
        format.setTimeZone(TimeZone.getTimeZone("America/Bogota"));

        return format.format(new Date()).toUpperCase();

    }
}
