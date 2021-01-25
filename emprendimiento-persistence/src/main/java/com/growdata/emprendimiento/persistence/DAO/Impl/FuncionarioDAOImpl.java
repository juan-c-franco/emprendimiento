/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO.Impl;

import com.growdata.emprendimiento.persistence.DAO.FuncionarioDAO;
import com.growdata.emprendimiento.persistence.commons.MensajesBD;
import com.growdata.emprendimiento.persistence.entidad.Comiteevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Funcionario;
import com.growdata.emprendimiento.persistence.entidad.Integrantescomite;
import com.growdata.emprendimiento.persistence.hibernate.HibernateJdbcEmprendimiento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {

    private SessionFactory sessionFactory = HibernateJdbcEmprendimiento.getSession();

    /**
     * Metodo que trae los funcionarios de una caja de compensación a partir de
     * un id de caja de compensación
     *
     * @param idcajacompensacion El id de la caja de compensación
     * @return Una lista con los funcionarios
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public List<Funcionario> getFuncionariosPorCaja(BigDecimal idcajacompensacion) throws Exception {
        List<Funcionario> funcionarios = new ArrayList();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Funcionario where idcajacompensacion=:idcajacompensacion", Funcionario.class);
            elQuery.setParameter("idcajacompensacion", idcajacompensacion);
            //obtengo resultados del query
            funcionarios = elQuery.getResultList();
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionarios;
    }

    /**
     * Metodo que trae a un funcionario a partir de un estado y un id de usuario
     *
     * @param idUser El id del usuario
     * @param idEstado El id del estado
     * @return Un funcionario
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Funcionario getFuncionarioPorIdUser(long idUser, BigDecimal idEstado) throws Exception {
        Funcionario funcionario = new Funcionario();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Funcionario where idestadofuncionario=:idEstado and iduser=:iduser ", Funcionario.class);
            q.setParameter("iduser", idUser);
            q.setParameter("idEstado", idEstado);
            funcionario = (Funcionario) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIOS, ex);

        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionario;
    }

    /**
     * Metodo que crea un nuevo funcionario
     *
     * @param funcionario El funcionario a crear
     * @return El id del funcionario creado
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public long setFuncionario(Funcionario funcionario) throws Exception {
        long id = -1;
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            id = (long) sesion.save(funcionario);

            //obtengo resultados del query
            sesion.getTransaction().commit();

        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_REGISTRO_FUNCIONARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return id;
    }

    /**
     * DAO responsable ubicar un funcionario por idfuncionario.
     *
     * @param idfuncionario Identificador del funcionario
     * @return Funcionario Funcionario que cumple con las condiciones de
     * búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Funcionario getFuncionarioPorId(long idfuncionario) throws Exception {
        Funcionario funcionario = new Funcionario();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Funcionario where idfuncionario=:idfuncionario", Funcionario.class);
            elQuery.setParameter("idfuncionario", idfuncionario);
            //obtengo resultados del query
            funcionario = (Funcionario) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionario;
    }

    /**
     * Metodo que actualiza un funcionario
     *
     * @param funcionario El funcionario con la información a actualizar
     * @return Una respuesta que dice si se actualizó el funcionario
     * exitosamente
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public String modificarFuncionario(Funcionario funcionario) throws Exception {

        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        String resp = "";
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            sesion.update(funcionario);
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_FUNCIONARIO, ex);

        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae un funcionario a partir de su email
     *
     * @param email El email del funcionario
     * @return Un funcionario
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Funcionario getFuncionarioPorCorreo(String email) throws Exception {
        Funcionario funcionario = new Funcionario();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Funcionario where email=:email", Funcionario.class);
            elQuery.setParameter("email", email);
            //obtengo resultados del query
            funcionario = (Funcionario) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIO, ex);

        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionario;
    }

    /**
     * Metodo que trae los integrantes del comite libres de la BD
     *
     * @param lstRoles Los tipos de funcionario
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idEstado El id del estado
     * @return Una lista de funcionarios
     */
    @Override
    public List getUsuariosComiteLibres(List<String> lstRoles, BigDecimal idCajaCompensacion, BigDecimal idEstado) {
        List funcionarios = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q
                    = sesion.createQuery("select f.primernombre, f.primerapellido, gs.groupName, f.idfuncionario "
                            + "from Funcionario as f "
                            + "inner join GroupMembers as gm on f.users.username=gm.users.username "
                            + "inner join Users as u on u.username=gm.users.username and u.username=f.users.username "
                            + "inner join Groups as gs on gs.id=gm.groups.id "
                            + "inner join Comiteevaluacion as cev on cev.cajacompensacion.idcajacompensacion=f.cajacompensacion.idcajacompensacion "
                            + "left join Integrantescomite as ic on ic.comiteevaluacion.idcomite=cev.idcomite and ic.funcionario.idfuncionario=f.idfuncionario "
                            + "where "
                            + "gs.groupName in (:rol0, :rol1) "
                            + "and f.cajacompensacion.idcajacompensacion=:idCaja "
                            + "and u.enabled=:enabled "
                            + "and f.estadofuncionario.idestadofuncionario=:idEstadoFuncionario "
                            + "and ic.idintegrante is null ");
            q.setParameter("idCaja", idCajaCompensacion);
            q.setParameter("enabled", idEstado);
            q.setParameter("idEstadoFuncionario", idEstado);
            int cant = 0;
            for (String rol : lstRoles) {
                q.setParameter("rol" + cant, rol);
                cant += 1;
            }
            funcionarios = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionarios;
    }

    /**
     * Metodo que trae los integrantes del comite de una caja de compensación de
     * la BD
     *
     * @param idCajaCompensacion El id de la caja de compensación
     * @param idEstado El id del estado del funcionario
     * @return Una lista de funcionarios
     */
    @Override
    public List getUsuariosComite(BigDecimal idCajaCompensacion, BigDecimal idEstado) {
        List funcionarios = new ArrayList();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q
                    = sesion.createQuery("select "
                            + " f.primernombre as nombres, f.primerapellido as primerapellido, gs.groupName as groupName, f.idfuncionario as idfuncionario, ic.idintegrante as idintegrante "
                            + " from "
                            + " Funcionario as f, "
                            + " GroupMembers as gm, "
                            + " Groups as gs, "
                            + " Comiteevaluacion as cev, "
                            + " Integrantescomite as ic "
                            + " where "
                            + " f.users.username=gm.users.username "
                            + " and gs.id=gm.groups.id "
                            + " and cev.cajacompensacion.idcajacompensacion=f.cajacompensacion.idcajacompensacion "
                            + " and ic.comiteevaluacion.idcomite=cev.idcomite "
                            + " and ic.funcionario.idfuncionario=f.idfuncionario "
                            + " and f.cajacompensacion.idcajacompensacion=:idCaja "
                            + " and f.estadofuncionario.idestadofuncionario=:idEstadoFuncionario ");
            q.setParameter("idCaja", idCajaCompensacion);
            q.setParameter("idEstadoFuncionario", idEstado);
            funcionarios = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionarios;
    }

    /**
     * Metodo que actualiza los integrantes del comite
     *
     * @param integrantes Los integrantes del comité a actualizar
     * @return Una respuesta que dice si se actualizaron los integrantes
     * satisfactoriamente o no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public String updateIntegranteComite(List<Integrantescomite> integrantes) throws Exception {
        String resp = "";
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            for (Integrantescomite i : integrantes) {
                if (i.getIdintegrante() != null) {
                    sesion.update(i);
                } else {
                    sesion.save(i);
                }
            }

            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            sesion.getTransaction().rollback();
            throw new Exception(MensajesBD.ERROR_ACTUALIZAR_INTEGRANTES_COMITE, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que crea un integrante de comité
     *
     * @param integranteComite El integrante del comité a crear
     * @return Respuesta que dice si se creó el nuevo integrante de comite
     * exitosamente o no
     */
    @Override
    public String setIntegranteComite(Integrantescomite integranteComite) {
        String resp = "";
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(integranteComite);
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * Metodo que trae un comite de evaluacion a partir de un id de caja de
     * compensacion
     *
     * @param idCajaCompensacion El id de la caja de compensación
     * @return Un comité de evaluación
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Comiteevaluacion getComiteEvaluacion(BigDecimal idCajaCompensacion) throws Exception {
        Comiteevaluacion comiteEvaluacion = new Comiteevaluacion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Comiteevaluacion where cajacompensacion.idcajacompensacion=:idCajaCompensacion ", Comiteevaluacion.class);
            q.setParameter("idCajaCompensacion", idCajaCompensacion);
            comiteEvaluacion = (Comiteevaluacion) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_COMITE_EVALUACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return comiteEvaluacion;
    }

    /**
     * Metodo que trae un comite de evaluación a partir de su id
     *
     * @param idComite El id del comité de evaluación
     * @return Un comité de evaluación
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public Comiteevaluacion getComiteEvaluacionPorId(BigDecimal idComite) throws Exception {
        Comiteevaluacion comiteEvaluacion = new Comiteevaluacion();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Comiteevaluacion where idcomite=:idComite ", Comiteevaluacion.class);
            q.setParameter("idComite", idComite);
            comiteEvaluacion = (Comiteevaluacion) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_COMITE_EVALUACION, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return comiteEvaluacion;
    }

    /**
     * Metodo que borra los integrantes de un comite a partir del id de un
     * comite
     *
     * @param idComite El id del comité de evaluación
     * @return Una respuesta que dice si se borro el comité exitosamente o no
     * @throws Exception Cualquier Exception que pueda ser lanzada
     */
    @Override
    public String deleteIntegrantesComite(BigDecimal idComite) throws Exception {
        String resp = "";
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("delete from Integrantescomite where idcomite=:idcomite");
            q.setParameter("idcomite", idComite);
            q.executeUpdate();
            sesion.getTransaction().commit();
            resp = "1";
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_BORRAR_INTEGRANTES_COMITE, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    /**
     * DAO encargados de ubicar un funcionario por nombre de usuario.
     *
     * @param userName Nombre de usuario del Funcionario a ubicar.
     * @param idEstado Estado del Funcionario a ubicar.
     * @return Funcionario que cumple con los criterios de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public Funcionario getFuncionarioPorUserName(String userName, BigDecimal idEstado) throws Exception {
        Funcionario funcionario = new Funcionario();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("from Funcionario f where f.estadofuncionario.idestadofuncionario=:idEstado and f.users.username=:userName ", Funcionario.class);
            q.setParameter("userName", userName);
            q.setParameter("idEstado", idEstado);
            funcionario = (Funcionario) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIOS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionario;
    }

    /**
     * DAO encargado de traer todos los funcionarios de una determinada caja y 
     * tipo de funcionar. Ej. Sensibilizador.
     *
     * @param grupo Grupo al que deben pertenecer los Funcionarios
     * @param caja Caja de Compensación a la que deben pertener los Funcionarios
     * @return Lista de Funcionarios que cumplen con el criterio de búsqueda.
     * @throws Exception Cualquier Exception que pueda ser lanzada.
     */
    @Override
    public List<Funcionario> getFuncionariosPorGrupoYCaja(BigDecimal grupo, BigDecimal caja) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Funcionario> funcionarios = null;
        try {
            sesion.beginTransaction();
            Query q;

            if (grupo == null && caja == null) {
                q = sesion.createQuery("select f "
                        + "from Funcionario"
                        + " where f.estadofuncionario.idestadofuncionario = 1", Funcionario.class);
            } else if (grupo == null) {
                q = sesion.createQuery("select f "
                        + "from Funcionario f "
                        + "where f.estadofuncionario.idestadofuncionario = 1 and f.cajacompensacion.idcajacompensacion=:caja ", Funcionario.class);
                q.setParameter("caja", caja);
            } else if (caja == null) {
                q = sesion.createQuery("select f "
                        + "from Funcionario f inner join GroupMembers g on"
                        + " g.users.username=f.users.username and g.groups.id=:grupo"
                        + "  where f.estadofuncionario.idestadofuncionario = 1", Funcionario.class);
                q.setParameter("grupo", grupo.intValue());
            } else {
                q = sesion.createQuery("select f "
                        + "from Funcionario f inner join GroupMembers g on"
                        + " g.users.username=f.users.username and g.groups.id=:grupo "
                        + " where f.estadofuncionario.idestadofuncionario = 1 and f.cajacompensacion.idcajacompensacion=:caja ", Funcionario.class);
                q.setParameter("grupo", grupo.intValue());
                q.setParameter("caja", caja);
            }
            funcionarios = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIOS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionarios;

    }

    /**
     * DAO encargado de indicar si un funcionario pertenece o no a un determinado. grupo.
     *
     * @param userName Nombre de Usuario del Funcionario
     * @param grupo Grupo
     * @return Funcionario que pertenece al grupo
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public Funcionario isFuncionarioDelGrupo(String userName, String grupo) throws Exception {
        Funcionario response = new Funcionario();
        Session sesion = sessionFactory.getCurrentSession();
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select f from Funcionario f inner join GroupMembers gm on f.users.username=gm.users.username where gm.users.enabled=:idEstado and gm.users.username=:userName and gm.groups.groupName = :grupo ", Funcionario.class);
            q.setParameter("grupo", grupo);
            q.setParameter("userName", userName);
            q.setParameter("idEstado", new BigDecimal(1));
            response = (Funcionario) q.getSingleResult();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return response;
    }

    /**
     * Metodo que trae una lista de funcionarios de la BD a partir de un id de
     * caja de compensación, y un tipo de funcionario
     *
     * @param grupo El tipo de funcionario
     * @param caja El id de la caja de compensación
     * @return Una lista de funcionarios
     * @throws Exception Cualquier Exception que se pueda lanzar.
     */
    @Override
    public List getFuncionariosPorGrupoYCaja(String grupo, BigDecimal caja) throws Exception {
        Session sesion = sessionFactory.getCurrentSession();
        List<Funcionario> funcionarios = null;
        try {
            sesion.beginTransaction();
            Query q = sesion.createQuery("select f from Funcionario f inner join GroupMembers g on"
                    + " g.users.username=f.users.username where g.users.enabled=:idEstado and g.groups.groupName=:grupo and f.cajacompensacion.idcajacompensacion=:caja ", Funcionario.class);
            q.setParameter("grupo", grupo);
            q.setParameter("caja", caja);
            q.setParameter("idEstado", new BigDecimal(1));
            funcionarios = q.getResultList();
            sesion.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIOS, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionarios;
    }

    /**
     * DAO responsable de obtener la información de un funcionario por número y 
     * tipo de documento.
     *
     * @param numerodocumento Número de Documento
     * @param idtipodocumento El id del tipo de documento
     * @return Funcionario que cumpla con la condición
     * @throws Exception Cualquier Exception
     */
    @Override
    public Funcionario getFuncionarioPorDocumento(String numerodocumento, BigDecimal idtipodocumento, long idfuncionario) throws Exception {
        Funcionario funcionario = new Funcionario();
        //obtener sesion de hibernate
        Session sesion = sessionFactory.getCurrentSession();
        try {
            //empiezo la transaccion
            sesion.beginTransaction();
            // creo el query
            Query elQuery
                    = sesion.createQuery("from Funcionario where numerodocumento=:numerodocumento and idtipodocumento=:idtipodocumento and idfuncionario !=:idfuncionario", Funcionario.class);
            elQuery.setParameter("numerodocumento", numerodocumento);
            elQuery.setParameter("idtipodocumento", idtipodocumento);
            elQuery.setParameter("idfuncionario", idfuncionario);
            //obtengo resultados del query
            funcionario = (Funcionario) elQuery.getSingleResult();
            sesion.getTransaction().commit();
        } catch (NoResultException n) {
            return null;
        } catch (Exception ex) {
            throw new Exception(MensajesBD.ERROR_CARGA_FUNCIONARIO, ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return funcionario;
    }
}
