package com.growdata.emprendimiento.business.commons;

/**
 * Clase contenedora de mensajes.
 *
 * @author Juan Franco
 */
public class Mensajes {

    //Encuesta
    //Errores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENCUESTA_DILIGENCIADA = "Solo puede diligenciar la encuesta una vez";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENCUESTA_VIGENCIA = "La encuesta solo puede ser diligenciada hasta 30 días después de que fue enviada,"
            + " dirijase a su caja de compensación para agendar una nueva cita de sensibilización";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENCUESTA_NO_PARAMETRIZADA = "La encuesta no ha sido parametrizada, por favor contacte al administrador de su caja de compensación";
    //Exito

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_PREGUNTAS = "Preguntas cargadas con éxito";

    //Entidades financieras
    //Errores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_PARAMETROS = "Por favor diligencie todos los campos";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_ENTIDAD_FINANCIERA = "Se presentó un error modificando la entidad financiera";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ENTIDADES_FINANCIERAS = "Error obteniendo entidades financieras de la base de datos";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_ENTIDAD_FINANCIERA = "Se presentó un error al registrar la entidad financiera";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ENTIDAD_FINANCIERA = "Se produjo un error al cargar la entidad financiera a modificar";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENTIDAD_EXIXTENTE = "Se presentó un error, ya existe una entidad con ese nombre";
    //Exito

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ENTIDADES_FINANCIERAS = "Entidades financieras cargadas con éxito";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRANDO_ENTIDAD_FINANCIERA = "Entidad financiera registrada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ENTIDAD_FINANCIERA = "Entidad a modificar cargada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_ENTIDAD_FINANCIERA = "Entidad financiera modificada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_BORRAR_ENTIDAD_FINANCIERA = "Entidad financiera borrada exitosamente";

    //Cajas de Compensacion
    //Errores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_CAJA_COMPENSACION = "Se presentó un error al registrar la caja de compensación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_CAJAS_COMPENSACION = "Se presentó un problema al cargar las cajas de compensación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_CAJA_COMPENSACION = "Se presentó un problema al cargar la caja de compensación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_CAJA_COMPENSACION = "Se presentó un error al modificar la caja de compensación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CAJA_EXIXTENTE = "Se presentó un error, ya existe una caja con ese nombre";
    //Exito

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_CAJAS_COMPENSACION = "Cajas de compensación cargadas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_CAJA_COMPENSACION = "Caja de compensación cargada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_CAJA_COMPENSACION = "Caja de compensación registrada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_CAJA_COMPENSACION = "Caja de compensación modificada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_BORRAR_CAJA_COMPENSACION = "Caja de compensación borrada exitosamente";

    //Herramientas de valoración
    //Errores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_HERRAMIENTAS_VALORACION = "Se presentó un problema al cargar las herramientas de valoración";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_HERRAMIENTA_VALORACION = "Se presentó un problema al cargar la herramienta de valoración";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TEMAS_X_CAJA_HERRAMIENTA = "Se presentó un problema al cargar los temas de evaluación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_TEMA_EVALUACION = "Se presentó un error al registrar el tema de evaluación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TEMA_EVALUACION = "Se presentó un problema al cargar el tema de evaluación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_UPDATE_TEMA_EVALUACION = "Se presentó un error al modificar el tema de evaluación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_PREGUNTAS_X_TEMA_CAJA_HERRAMIENTA = "Se presentó un problema al cargar las preguntas";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_UPDATE_PREGUNTA_TEMA = "Se presentó un error al modificar la pregunta";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_PREGUNTA_TEMA = "Se presentó un error al registrar la pregunta";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_PREGUNTA_TEMA = "Se presentó un error al cargar la pregunta";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_FUNCIONARIO = "Se presentó un error al cargar el funcionario";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_USUARIO = "Se presentó un error al cargar el usuario";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_BORRAR_TEMA_EVALUACION = "Tema de evaluación borrado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_BORRAR_PREGUNTA = "Pregunta borrada exitosamente";
    //Exito

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_HERRAMIENTAS_VALORACION = "Herramientas de valoración cargadas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_HERRAMIENTA_VALORACION = "Herramienta de valoración cargada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TEMAS_X_CAJA_HERRAMIENTA = "Temas de evaluación cargados exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_TEMA_EVALUACION = "Tema de evaluación registrado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TEMA_EVALUACION = "Tema de evaluación cargado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_TEMA_EVALUACION = "Tema de evaluación modificado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_PREGUNTAS_X_TEMA_CAJA_HERRAMIENTA = "Preguntas cargadas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_PREGUNTA_TEMA = "Pregunta modificada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_PREGUNTA_TEMA = "Pregunta registrada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_PREGUNTA_TEMA = "Pregunta cargada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_FUNCIONARIO = "Funcionario cargado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_USUARIO = "Usuario cargado exitosamente";

    //Funcionarios
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_FUNCIONARIO = "Funcionario registrados exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_FUNCIONARIOS = "Funcionarios cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_FUNCIONARIOS = "Se presentó un error al cargar los funcionarios";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NO_HAY_FUNCIONARIOS = "Esta caja no cuenta con funcionarios registrados";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ACTUALIZAR_FUNCIONARIO = "Se presentó un error al actualizar el funcionario";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ACTUALIZAR_FUNCIONARIO = "Funcionario actualizado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CORREO_EXIXTENTE = "Se presentó un error, ya existe un usuario con la dirección de correo ingresada";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DOCUMENTO_EXISTENTE = "Se presentó un error, ya existe un funcionario con el número de documento ingresado";

    //GroupMembers
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_GROUP_MEMBERS = "Se presentó un error al cargar los tipos de funcionarios";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_GROUP_MEMBERS = "Funcionarios cargados exitosamente";
    //Groups

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_GROUPS = "Se presentó un error al cargar los tipos de funcionarios";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_GROUPS = "Groups cargados exitosamente";
    //Tipo documento

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TIPO_DOCUMENTO = "Se presentó un error al cargar los tipos de documento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TIPO_DOCUMENTO = "Tipos de documento cargados exitosamente";
    //Users

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_USUARIO = "Se presentó un problema al registrar el usuario";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ACTUALIZAR_CONTRASENA = "Se presentó un problema al actualizar la contraseña";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ACTUALIZAR_CONTRASENA = "Contraseña actualizada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CONTRASENAS_NO_COINCIDEN = "Se presentó un error, las contraseñas no coinciden";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CONTRASENA_INCORRECTA = "Se presentó un error, la contraseña es incorrecta";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_USUARIO = "Usuario creado exitosamente, se han enviado a su correo electrónico sus credenciales de acceso";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_USUARIO = "Se presentó un error al crear el usuario";

    //Usuarios Comite Evaluación
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_USUARIOS_COMITE = "Usuarios comité cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_USUARIOS_COMITE = "Se presentó un error al cargar los usuarios de comité de evaluación";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_INTEGRANTES_COMITE = "Integrantes de comité cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_INTEGRANTES_COMITE = "Se presentó un error al cargar los integrantes de comité evaluación";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_INTEGRANTE_COMITE = "Integrante comité modificado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_UPDATE_INTEGRANTE_COMITE = "Se presentó un error al modificar el integrante comité";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_INTEGRANTE_COMITE = "Se presentó un problema al registrar el integrante(s) comité de evaluación";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_INTEGRANTE_COMITE = "Integrante(s) comité de evaluación registrado(s) exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_COMITE_EVALUACION = "Comité de evaluación cargado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_COMITE_EVALUACION = "Error cargando comité de evaluación. Verifique que esté conformado correctamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DELETE_INTEGRANTES_COMITE = "Se presentó un error al eliminar los integrantes comité";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_DELETE_INTEGRANTES_COMITE = "Integrantes comité eliminados exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_IS_FUNCIONARIO_GRUPO = "Se consultó el rol del funcionario exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_IS_FUNCIONARIO_GRUPO = "Se presentó un error al consultar la pertenecia del funcionario a rol";

    //Asistentes
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ASISTENTES_SESION = "Asistentes de sesión cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ASISTENTES_SESION = "Esta sesión no tiene asistentes registrados";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_SESIONES_AAT = "Sesiones de acompañamiento asistencia técnica cargadas exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_SESIONES_AAT = "Se presentó un error al cargar las sesiones de acompañamiento asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_BENEFICIARIO_EMPRENDIMIENTO = "Beneficiario emprendimiento temas de asistencia técnica cargadas exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_BENEFICIARIO_EMPRENDIMIENTO = "Se presentó un error al cargar beneficiario emprendimiento temas de asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TEMAS_RUTAS_AAT = "Temas ruta de acompañamiento de asistencia técnica cargadas exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NO_TEMAS_RUTAS_AAT = "El beneficiario presenta un emprendimiento sin Temas de Acompañamiento de Asistencia Técnica asociadas por el Valorador.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_GUARDAR_SESION_AAT = "Se presentó un problema al registrar la Sesión de Acompañamiento de Asistencia Técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_SESION_AAT = "Sesión de acompañamiento de asistencia técnica registrado(s) exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_SESION_AAT = "Sesión de acompañamiento de asistencia técnica modificado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ESTADO_SESION = "Estado sesión cargado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ESTADO_SESION = "Se presentó un error al cargar estado sesión";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_DELETE_SESION_AAT = "Sesión de acompañamiento de asistencia técnica eliminada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DELETE_SESION_AAT = "Se presentó un error al eliminar sesión acompañamiento de asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_SESION_AAT = "Sesión de acompañamiento de asistencia técnica cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_SESION_AAT = "No existe una sesión de acompañamiento de asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TEMA_RUTA_AAT = "Tema Ruta acompañamiento de asistencia técnica cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TEMA_RUTA_AAT = "No existe un Tema ruta acompañamiento de asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_RUTA_AAT = "Ruta acompañamiento de asistencia técnica cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_RUTA_AAT = "No existe un Ruta acompañamiento de asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_LISTA_AAT = "lista acompañamiento de asistencia técnica cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_LISTA_AAT = "No existe un lista acompañamiento de asistencia técnica";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_UPDATE_LISTA_AAT = "Se presentó un error al modificar lista de acompañamiento y asistencia técnica";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_LISTA_AAT = "Lista de acompañamiento y asistencia técnica modificado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_EMPRENDIMIENTOS = "Emprendimientos cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_EMPRENDIMIENTOS = "Se presentó un error al cargar Emprendimientos";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ASOCIADO = "Asociado cargado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ASOCIADO = "El beneficiario no se encuentra asociado a un emprendimiento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_EMPRENDIMIENTO_ID = "Emprendimiento cargado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_EMPRENDIMIENTO_ID = "Se presentó un error al cargar el emprendimiento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_TEMA_RUTA_AAT = "Tema Ruta AAT registrado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_TEMA_RUTA_AAT = "Tema Ruta AAT modificado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_GUARDAR_TEMA_RUTA_AAT = "Se presentó un error al guardar Tema Ruta AAT";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CONSULTAR_AVANCE = "Se presentó un error al consultar el avance";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_EMPRENDIMIENTO_NOENCONTRADO = "El beneficiario no presenta emprendimiento activo o no está vinculado a esta caja de compensación.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_GUARDAR_DOCUMENTO = "Se guardó documento exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_GUARDAR_DOCUMENTO = "Se presentó un error al guardar Documento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_DOCUMENTO = "Documento modificado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_DOCUMENTOS = "Documentos cargados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_DOCUMENTOS = "Se presentó un error al cargar Documentos";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_DELETE_DOCUMENTO = "Documento eliminado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DELETE_DOCUMENTO = "Se presentó un error al eliminar documento";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_HORAS_SUPERADAS = "Tiempo de la sesión supera el tiempo disponible del tema seleccionado";

    //Sesiones valoracion
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_SESIONES_V = "Sesiones de valoración cargadas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ASOCIACION_BENEFICIARIO_V = "Beneficiario(s) invitado satisfactoriamente a la valoración.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ASOCIACION_BENEFICIARIO_V = "Error invitando el/los beneficiario(s) a la valoración.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DESCONOCIDO_ASOCIACION_BENEFICIARIO_V = "Error desconocido.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NO_VALORACION = "Beneficiario no presenta asistencia en sesión de valoración recientemente.";

    //Beneficiarios
    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_INEXISTENTE = "No existe un beneficiario con ese nombre y apellido";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_BENEFICIARIO = "Beneficiarios consultados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_BENEFICIARIO = "No existen beneficiarios que cumplan con la condicion.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_INEXISTENTE2 = "No existe un beneficiario con ese número de documento";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_INEXISTENTE3 = "No existe un beneficiario con ese Id";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_INEXISTENTE_CORREO = "No existe un beneficiario con ese correo electrónico.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_EMPRENDIMIENTO_ACTIVO = "El beneficiario tiene un emprendimiento activo o no finalizado.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_OTRA_SESION = "El beneficiario ya está asignado a otra sesión del mismo tipo o la misma está pendiente de registrar asistencia.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TIPO_DOCUMENTO_INVALIDO = "Tipo de documento no válido.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CORREO_INVALIDO = "Correo electrónico no válido.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_BENEFICIARIO_YAEXISTE = "Beneficiario ya existe.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_BENEFICIARIO = "Beneficiario registrado.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_BENEFICIARIO = "Error registrando beneficiario.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_BENEFICIARIO2 = "Se presentó un error al cargar el beneficiario";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CORREO_NUMDOC_DUPLICADO = "Ya existe un beneficiario con el mismo número de documento y diferente correo electrónico, ó viceversa. Por favor actualice sus datos.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ES_FUNCIONARIO = "No es posible realizar el registro, el email pertenece a un funcionario";

    //Sesiones Sensibilizacion
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_VERIFICANDO_REQUISITOS = "Requisitos verificados exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_VERIFICANDO_REQUISITOS = "Error verificando requisitos.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ASOCIACION_BENEFICIARIO_SESION = "Beneficiario invitado satisfactoriamente a la sesión.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ASOCIACION_BENEFICIARIO_SESION = "Error asociando el beneficiario a la sesión.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_PROGRAMAR_SESIONES = "Sesión programada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ACTUALIZAR_SESIONES = "Sesión actualizada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ELIMINAR_SESIONES = "Sesión cancelada exitosamente.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_LIBERAR_SESIONES = "Sesión liberada exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_PROGRAMAR_SESIONES = "Error programando sesión";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_SOLAPE_SESIONES = "Error programando sesión: Existe cruce con otra sesión.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_SOLAPE_SESIONESAAT = "Sesión de acompañamiento de asistencia técnica con solapamiento de fechas";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ACTUALIZAR_SESIONES = "Error actualizado sesión.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ELIMINAR_SESIONES = "Error cancelando la sesión";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_SIN_CUPO_SESIONES = "La sesión ha llegado a su máximo de asistentes.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NO_SENSIBILIZACION = "Beneficiario no presenta asistencia en sesión de sensibilización recientemente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_SESION_NO_DISPONIBLE = "La sesión seleccionada no se encuentra disponible.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DESCONOCIDO_AGENDAR_SESION = "Error desconocido al agendar sesión: ";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_FECHA_HORA = "Error en formatos fecha u hora";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_ASISTENCIA_SENSIBILIZACION = "Asistencias de sensibilización registradas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_ASISTENCIA_VALORACION = "Asistencias de valoración registradas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_ASISTENCIA = "Asistencias registradas exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_ASISTENCIA_EVALUACION = "Asistencias de evaluación registradas exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_EMAIL_INVALIDO = "El siguiente correo electrónico es inválido: ";

    //Respuestas
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_RESPUESTAS = "Respuestas registradas exitosamente.";
    //Asociados

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ASOCIADO = "El beneficiario no esta asociado a ningún emprendimiento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ASOCIADOS = "Asociado a emprendimiento cargado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_EMPRENDIMIENTO_SIN_ASOCIADOS = "El emprendimiento no tiene asociados registrados";
    //Emprendimiento

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_EMPRENDIMIENTO = "El beneficiario no esta asociado a un emprendimiento activo";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_EMPRENDIMIENTO_INEXISTENTE = "No existe un emprendimiento con ese nombre";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_EMPRENDIMIENTO = "Emprendimiento creado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_EMPRENDIMIENTO = "Error creando emprendimiento.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_UPDATE_EMPRENDIMIENTO = "Emprendimiento actualizado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_UPDATE_EMPRENDIMIENTO = "Error actualizando emprendimiento";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ESTADO_EMPRENDIMIENTO = "Error al cargar el estado emprendimiento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ESTADO_EMPRENDIMIENTO = "Se cargo estado emprendimiento exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_DOCUMENTO = "Error al cargar documento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_DOCUMENTO = "Se cargo documento exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ESTADO_EMPRENDIMIENTO = "El beneficiario no tiene un emprendimiento en el estado necesario.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_IDEMPRENDIMIENTO_NOENCONTRADO = "Se no consigue emprendimiento con el #ID: ";

    //Ruta Capacitacion
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_RUTA = "Se presentó un error al crear la ruta de acompañamiento";
    //Temas Ruta Acompañamiento

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_TEMAS_RUTA = "Temas de capacitación creados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_TEMAS_RUTA = "Se presentó un error al crear los temas de capacitación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_TEMAS_ACOMPANAMIENTO = "Se presentó un error al crear los temas de acompañamiento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_TEMAS_ACOMPANAMIENTO = "Temas de acompañamiento creados exitosamente";

    //Hibernate Errores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_HIBERNATE = "Error en base de datos. Comuníquese con el administrador del sistema.";

    //Paises, Departamentos y Municipios
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_PAISES = "Error cargando los paises.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_PAISES = "Paises cargados exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_DEPARTAMENTOS = "Error cargando los departamentos.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_DEPARTAMENTOS = "Departamentos cargados exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_MUNICIPIOS = "Error cargando los municipios.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_MUNICIPIOS = "Municipios cargados exitosamente.";

    //Tipos Constitucion Legal
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TIPOS_CONSTITUCION_LEGAL = "Error cargando los tipos de constitucion legal.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TIPOS_CONSTITUCION_LEGAL = "Tipos de constitución legal cargados exitosamente.";

    //Sectores Productivos
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_SECTORES_PRODUCTIVOS = "Error cargando los sectores productivos.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_SECTORES_PRODUCTIVOS = "Sectores productivos cargados exitosamente.";

    //Actividades Internacionales
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_ACTIVIDADES_INTERNACIONALES = "Error cargando las actividades internacionales.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_ACTIVIDADES_INTERNACIONALES = "Actividades internacionales cargadas exitosamente.";

    //Tipos Emprendimiento
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGA_TIPOS_EMPRENDIMIENTIO = "Error cargando los tipos de emprendimiento.";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TIPOS_EMPRENDIMIENTO = "Tipos de emprendimiento cargados exitosamente.";

    //Temas individuales valoracion
    /**
     * Mensaje de error.
     */
    public static final String ERROR_TEMAS_INEXISTENTES = "No hay temas individuales en la base de datos";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGAR_TEMAS_INDIVIDUALES = "Temas individuales cargados exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_TEMAS_INDIVIDUALES = "Temas individuales creados exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TEMAS_INDIVIDUALES_YA_VALORADOS = "No es posible realizar la valoración, Solo se permite una valoración individual al dia";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TEMAS_GRUPALES_YA_VALORADOS = "No es posible realizar la valoración, Solo se permite una valoración grupal al dia";
    // Tipos de Financiacion

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_TIPOS_FINANCIACION = "Tipos de financiacion cargados exitosamente";
    // Financiacion

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_FINANCIACION = "Informacion financiera basica registrada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_FINANCIACION = "Información financiera básica cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_FINANCIACION_INEXISTENTE = "No existe información financiera para este emprendimiento";

    //Evaluacion integrantes commite
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRO_CALIFICACION_IND = "Calificación registrada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRO_CALIFICACION_IND = "Error registrando calificación.";

    //Seguimiento
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_SEGUIMIENTO = "Seguimiento guardado exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_SEGUIMIENTO = "Error guardando seguimiento.";

    //Calificacion Definitiva
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGAR_EVALUACION_INTEGRANTES = "Evaluaciones de los Integrantes cargadas exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGAR_EVALUACION_INTEGRANTES = "Error cargando evaluación de Integrantes Comité.";

    //Sesiones sensibilizacion
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGA_SESIONES_S = "Sesiones de sensibilización cargadas exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NO_HAY_SESIONES_S = "Este funcionario no tiene sesiones registradas";
    //Log Auditoria

    /**
     * Mensaje de error.
     */
    public static final String LOG_AUDITORIA_VACIO = "No se encontraron registros en el log para esas fechas";

    /**
     * Mensaje de éxito.
     */
    public static final String LOG_AUDITORIA_EXITO = "Registros del log cargados exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ENVIO_CORREO_RECUPERACION = "Recuperar contraseña ha sido procesado. Recibirá un correo electrónico con un vínculo para restaurar su contraseña.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENVIO_CORREO_RECUPERACION = "Los datos ingresados no son válidos";

    //Configuraciones
    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGAR_CONFIGURACIONES = "Error cargando configuraciones.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGAR_CONFIGURACIONES = "Configuraciones cargadas exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_GUARDAR_CONFIGURACIONES = "Error guardando configuraciones.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_GUARDAR_CONFIGURACIONES = "Configuraciones guardadas exitosamente.";

    //Controladores
    /**
     * Mensaje de error.
     */
    public static final String ERROR_ESCRIBIENDO_ARCHIVO = "Error escribiendo archivo.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ENVIO_CORREO = "Se presentó un error al enviar el email";

    //Capacitaciones
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_CAPACITACIONES = "Capacitaciones cargadas exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_CAPACITACIONES = "Error cargando capacitaciones.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_COLUMNAS_NO_COINCIDE = "Número de columnas no coincide.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_TIPO_DOCUMENTO_VACIO = "Especifique tipo de documento.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_NUMERO_DOCUMENTO_VACIO = "Especifique número de documento.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_CALIFICACION_VACIO = "Especifique calificación.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_MODULO_VACIO = "Especifique modulo.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_NUMERO_CALIFICACION_FUERA_RANGO = "La calificación puede ser 0 (Reprobado) ó 1 (Aprobado).";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_HORAS_ASISTENCIA_FUERA_RANGO = "La horas asistidas debe estar en el rango [0-999].";
    /**
     * Mensaje Aprobado.
     */
    public static final String APROBADO = "Aprobado";
    /**
     * Mensaje reprobado.
     */
    public static final String REPROBADO = "Reprobado";

    //Docentes
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_DOCENTES = "Docentes cargadas exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_DOCENTES = "Error cargando docentes.";

    //Programaciones
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_PROGRAMACIONES = "Programaciones cargadas exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_PROGRAMACIONES = "Error cargando programaciones.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_SEGUIMIENTOASISTENCIA = "Seguimiento capacitación cargado exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_SEGUIMIENTOASISTENCIA = "Error cargando seguimiento capacitación.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRANDO_ASISTENCIA_PROGRAMACIONES = "Asistencias registradas exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRANDO_ASISTENCIA_PROGRAMACIONES = "Error registrando asistencias.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_REGISTRANDO_CALIFICACION_PROGRAMACIONES = "Calificaciones registradas exitosamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_REGISTRANDO_CALIFICACION_PROGRAMACIONES = "Error registrando calificaciones.";

    //Alumnos
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_ALUMNOS = "Alumnos cargados exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_ALUMNOS = "Error cargando alumnos.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ASOCIANDO_ALUMNO = "Alumno asociado exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ASOCIANDO_ALUMNO = "Error asociando alumno.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ALUMNO_NO_EXISTE = "Alumno no existe.";

    //Instituciones
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_INSTITUCIONES = "Instituciones cargadas exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_INSTITUCIONES = "Error cargando instituciones.";

    //Sedes
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CARGANDO_SEDES = "Sedes cargadas exitósamente.";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CARGANDO_SEDES = "Error cargando sedes.";
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_ROMPIMIENTO_FASES = "Se han guardado los cambios exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_ROMPIMIENTO_FASES = "Se presentó un error al guardar los cambios";

    //Instituciones
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_INSTITUCION = "Institución creada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_INSTITUCION = "Se presentó un error al crear la institución";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_INSTITUCION_REPETIDA = "Ya existe una institución con ese nombre";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_INSTITUCION = "Institución actualizada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_INSTITUCION = "Se presentó un error al actualizar la institución";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_INSTITUCION = "Se presentó un error al cargar la institución";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_INSTITUCION = "Institución cargada exitosamente";

    //Capacitacion programa
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_CAPACITACION = "Capacitación creada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_CAPACITACION = "Se presentó un error al crear la capacitación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CAPACITACION_REPETIDA = "Ya existe una capacitación con ese nombre";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_CAPACITACION = "Capacitación actualizada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_CAPACITACION = "Se presentó un error al actualizar la capacitación";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_CAPACITACION = "Se presentó un error al cargar la capacitación";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_CAPACITACION = "Capacitación cargada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_ESTADOS_CAPACITACION = "Se presentó un error al cargar los estados de capacitación";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_ESTADOS_CAPACITACION = "Estados de capacitación cargados exitosamente";

    //Modulos ciclos
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_MODULO = "Módulo creado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_MODULO = "Se presentó un error al crear el módulo";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODULO_REPETIDO = "Ya existe un módulo con ese nombre";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_MODULO = "Módulo actualizado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_MODULO = "Se presentó un error al actualizar el módulo";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_MODULO = "Se presentó un error al cargar el módulo";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_MODULOS = "Se presentó un error al cargar los módulos";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_MODULO = "Módulo cargado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_MODULOS = "Módulos cargados exitosamente";
    //Categorias
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_CATEGORIA = "Categoría creada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_CATEGORIA = "Se presentó un error al crear la categoría";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CATEGORIA_REPETIDA = "Ya existe una categoría con ese nombre";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_CATEGORIA = "Categoría actualizada exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_CATEGORIA = "Se presentó un error al actualizar la categoría";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_CATEGORIA = "Se presentó un error al cargar la categoría";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_CATEGORIAS = "Se presentó un error al cargar las categorias";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_CATEGORIA = "Categoría cargada exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_CATEGORIAS = "Categorias cargadas exitosamente";
    //Docentes
    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_CREAR_DOCENTE = "Docente creado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_CREAR_DOCENTE = "Se presentó un error al crear el docente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DOCENTE_REPETIDO_E = "Ya existe un docente con ese email";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_DOCENTE_REPETIDO_D = "Ya existe un docente con ese tipo y número de documento";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_MODIFICAR_DOCENTE = "Docente actualizado exitosamente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_MODIFICAR_DOCENTE = "Se presentó un error al actualizar el docente";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_DOCENTES = "Se presentó un error al cargar los docentes";

    /**
     * Mensaje de error.
     */
    public static final String ERROR_TRAER_DOCENTE = "Se presentó un error al cargar el docente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_DOCENTE = "Docente cargado exitosamente";

    /**
     * Mensaje de éxito.
     */
    public static final String EXITO_TRAER_DOCENTES = "Docentes cargados exitosamente";

}
