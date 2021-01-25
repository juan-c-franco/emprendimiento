package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:50:34 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class MdFDatosBasicosDTO implements java.io.Serializable {

    private long idDatosBasicos;
    private BigDecimal cargaId;
    private BigDecimal linea;
    private String codigoCcf;
    private String agenciaGestionYColocacion;
    private Date fechaRegistro;
    private Date fechaUltimaActualizacion;
    private String tipoDocumento;
    private String numeroDocumento;
    private String correoElectronico;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String sexo;
    private String libretaMilitar;
    private String tipoLibreta;
    private String numeroLibreta;
    private String telefonoContacto;
    private String estadoCivil;
    private String paisNacimiento;
    private String nacionalidad;
    private String departamentoNacimiento;
    private String municipioNacimiento;
    private String jefeHogar;
    private String poblacionFocalizada;
    private String grupoEtnico;
    private String tipoPoblacion;
    private String condicionesDiscapacidad;
    private String tipoDiscapacidad;
    private String paisResidencia;
    private String departamentoResidencia;
    private String municipioResidencia;
    private String direccionResidencia;
    private String barrioResidencia;
    private String otroTelefono;
    private String observaciones;
    private BigDecimal aspiracionSalarial;
    private String posibilidadViajar;
    private String posibilidadTrasladarse;
    private String interesOfertasTeletrabajo;
    private String situacionLaboralActual;
    private String propietarioMedioTransporte;
    private String tieneLicenciaCarro;
    private String categoriaLicenciaCarro;
    private String tieneLicenciaMoto;
    private String categoriaLicenciaMoto;

    public MdFDatosBasicosDTO() {
    }

    public MdFDatosBasicosDTO(long idDatosBasicos, BigDecimal cargaId, BigDecimal linea) {
        this.idDatosBasicos = idDatosBasicos;
        this.cargaId = cargaId;
        this.linea = linea;
    }

    public MdFDatosBasicosDTO(long idDatosBasicos, BigDecimal cargaId, BigDecimal linea, String codigoCcf, String agenciaGestionYColocacion, Date fechaRegistro, Date fechaUltimaActualizacion, String tipoDocumento, String numeroDocumento, String correoElectronico, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String sexo, String libretaMilitar, String tipoLibreta, String numeroLibreta, String telefonoContacto, String estadoCivil, String paisNacimiento, String nacionalidad, String departamentoNacimiento, String municipioNacimiento, String jefeHogar, String poblacionFocalizada, String grupoEtnico, String tipoPoblacion, String condicionesDiscapacidad, String tipoDiscapacidad, String paisResidencia, String departamentoResidencia, String municipioResidencia, String direccionResidencia, String barrioResidencia, String otroTelefono, String observaciones, BigDecimal aspiracionSalarial, String posibilidadViajar, String posibilidadTrasladarse, String interesOfertasTeletrabajo, String situacionLaboralActual, String propietarioMedioTransporte, String tieneLicenciaCarro, String categoriaLicenciaCarro, String tieneLicenciaMoto, String categoriaLicenciaMoto) {
        this.idDatosBasicos = idDatosBasicos;
        this.cargaId = cargaId;
        this.linea = linea;
        this.codigoCcf = codigoCcf;
        this.agenciaGestionYColocacion = agenciaGestionYColocacion;
        this.fechaRegistro = fechaRegistro;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correoElectronico = correoElectronico;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.libretaMilitar = libretaMilitar;
        this.tipoLibreta = tipoLibreta;
        this.numeroLibreta = numeroLibreta;
        this.telefonoContacto = telefonoContacto;
        this.estadoCivil = estadoCivil;
        this.paisNacimiento = paisNacimiento;
        this.nacionalidad = nacionalidad;
        this.departamentoNacimiento = departamentoNacimiento;
        this.municipioNacimiento = municipioNacimiento;
        this.jefeHogar = jefeHogar;
        this.poblacionFocalizada = poblacionFocalizada;
        this.grupoEtnico = grupoEtnico;
        this.tipoPoblacion = tipoPoblacion;
        this.condicionesDiscapacidad = condicionesDiscapacidad;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.paisResidencia = paisResidencia;
        this.departamentoResidencia = departamentoResidencia;
        this.municipioResidencia = municipioResidencia;
        this.direccionResidencia = direccionResidencia;
        this.barrioResidencia = barrioResidencia;
        this.otroTelefono = otroTelefono;
        this.observaciones = observaciones;
        this.aspiracionSalarial = aspiracionSalarial;
        this.posibilidadViajar = posibilidadViajar;
        this.posibilidadTrasladarse = posibilidadTrasladarse;
        this.interesOfertasTeletrabajo = interesOfertasTeletrabajo;
        this.situacionLaboralActual = situacionLaboralActual;
        this.propietarioMedioTransporte = propietarioMedioTransporte;
        this.tieneLicenciaCarro = tieneLicenciaCarro;
        this.categoriaLicenciaCarro = categoriaLicenciaCarro;
        this.tieneLicenciaMoto = tieneLicenciaMoto;
        this.categoriaLicenciaMoto = categoriaLicenciaMoto;
    }

    public long getIdDatosBasicos() {
        return this.idDatosBasicos;
    }

    public void setIdDatosBasicos(long idDatosBasicos) {
        this.idDatosBasicos = idDatosBasicos;
    }

    public BigDecimal getCargaId() {
        return this.cargaId;
    }

    public void setCargaId(BigDecimal cargaId) {
        this.cargaId = cargaId;
    }

    public BigDecimal getLinea() {
        return this.linea;
    }

    public void setLinea(BigDecimal linea) {
        this.linea = linea;
    }

    public String getCodigoCcf() {
        return this.codigoCcf;
    }

    public void setCodigoCcf(String codigoCcf) {
        this.codigoCcf = codigoCcf;
    }

    public String getAgenciaGestionYColocacion() {
        return this.agenciaGestionYColocacion;
    }

    public void setAgenciaGestionYColocacion(String agenciaGestionYColocacion) {
        this.agenciaGestionYColocacion = agenciaGestionYColocacion;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaUltimaActualizacion() {
        return this.fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLibretaMilitar() {
        return this.libretaMilitar;
    }

    public void setLibretaMilitar(String libretaMilitar) {
        this.libretaMilitar = libretaMilitar;
    }

    public String getTipoLibreta() {
        return this.tipoLibreta;
    }

    public void setTipoLibreta(String tipoLibreta) {
        this.tipoLibreta = tipoLibreta;
    }

    public String getNumeroLibreta() {
        return this.numeroLibreta;
    }

    public void setNumeroLibreta(String numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }

    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getPaisNacimiento() {
        return this.paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDepartamentoNacimiento() {
        return this.departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public String getMunicipioNacimiento() {
        return this.municipioNacimiento;
    }

    public void setMunicipioNacimiento(String municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }

    public String getJefeHogar() {
        return this.jefeHogar;
    }

    public void setJefeHogar(String jefeHogar) {
        this.jefeHogar = jefeHogar;
    }

    public String getPoblacionFocalizada() {
        return this.poblacionFocalizada;
    }

    public void setPoblacionFocalizada(String poblacionFocalizada) {
        this.poblacionFocalizada = poblacionFocalizada;
    }

    public String getGrupoEtnico() {
        return this.grupoEtnico;
    }

    public void setGrupoEtnico(String grupoEtnico) {
        this.grupoEtnico = grupoEtnico;
    }

    public String getTipoPoblacion() {
        return this.tipoPoblacion;
    }

    public void setTipoPoblacion(String tipoPoblacion) {
        this.tipoPoblacion = tipoPoblacion;
    }

    public String getCondicionesDiscapacidad() {
        return this.condicionesDiscapacidad;
    }

    public void setCondicionesDiscapacidad(String condicionesDiscapacidad) {
        this.condicionesDiscapacidad = condicionesDiscapacidad;
    }

    public String getTipoDiscapacidad() {
        return this.tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(String tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public String getPaisResidencia() {
        return this.paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getDepartamentoResidencia() {
        return this.departamentoResidencia;
    }

    public void setDepartamentoResidencia(String departamentoResidencia) {
        this.departamentoResidencia = departamentoResidencia;
    }

    public String getMunicipioResidencia() {
        return this.municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public String getDireccionResidencia() {
        return this.direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getBarrioResidencia() {
        return this.barrioResidencia;
    }

    public void setBarrioResidencia(String barrioResidencia) {
        this.barrioResidencia = barrioResidencia;
    }

    public String getOtroTelefono() {
        return this.otroTelefono;
    }

    public void setOtroTelefono(String otroTelefono) {
        this.otroTelefono = otroTelefono;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getAspiracionSalarial() {
        return this.aspiracionSalarial;
    }

    public void setAspiracionSalarial(BigDecimal aspiracionSalarial) {
        this.aspiracionSalarial = aspiracionSalarial;
    }

    public String getPosibilidadViajar() {
        return this.posibilidadViajar;
    }

    public void setPosibilidadViajar(String posibilidadViajar) {
        this.posibilidadViajar = posibilidadViajar;
    }

    public String getPosibilidadTrasladarse() {
        return this.posibilidadTrasladarse;
    }

    public void setPosibilidadTrasladarse(String posibilidadTrasladarse) {
        this.posibilidadTrasladarse = posibilidadTrasladarse;
    }

    public String getInteresOfertasTeletrabajo() {
        return this.interesOfertasTeletrabajo;
    }

    public void setInteresOfertasTeletrabajo(String interesOfertasTeletrabajo) {
        this.interesOfertasTeletrabajo = interesOfertasTeletrabajo;
    }

    public String getSituacionLaboralActual() {
        return this.situacionLaboralActual;
    }

    public void setSituacionLaboralActual(String situacionLaboralActual) {
        this.situacionLaboralActual = situacionLaboralActual;
    }

    public String getPropietarioMedioTransporte() {
        return this.propietarioMedioTransporte;
    }

    public void setPropietarioMedioTransporte(String propietarioMedioTransporte) {
        this.propietarioMedioTransporte = propietarioMedioTransporte;
    }

    public String getTieneLicenciaCarro() {
        return this.tieneLicenciaCarro;
    }

    public void setTieneLicenciaCarro(String tieneLicenciaCarro) {
        this.tieneLicenciaCarro = tieneLicenciaCarro;
    }

    public String getCategoriaLicenciaCarro() {
        return this.categoriaLicenciaCarro;
    }

    public void setCategoriaLicenciaCarro(String categoriaLicenciaCarro) {
        this.categoriaLicenciaCarro = categoriaLicenciaCarro;
    }

    public String getTieneLicenciaMoto() {
        return this.tieneLicenciaMoto;
    }

    public void setTieneLicenciaMoto(String tieneLicenciaMoto) {
        this.tieneLicenciaMoto = tieneLicenciaMoto;
    }

    public String getCategoriaLicenciaMoto() {
        return this.categoriaLicenciaMoto;
    }

    public void setCategoriaLicenciaMoto(String categoriaLicenciaMoto) {
        this.categoriaLicenciaMoto = categoriaLicenciaMoto;
    }

}
