/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCategoria;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGetCategorias;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCategoria;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.categoriaToCategoriaDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listCategoriasTOListCategoriasDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CategoriaDTO;
import com.growdata.emprendimiento.business.servicio.CategoriaServicio;
import com.growdata.emprendimiento.persistence.DAO.CategoriaDAO;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaDAO categoriaDAO;
    
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Método que trae todas las categorías parametrizadas en el sistema
     *
     * @return Una respuesta que contiene una lista con todas las categorías
     * parametrizadas en el sistema
     */
    @Override
    public ResponseGetCategorias getCategorias() {
        ResponseGetCategorias response = new ResponseGetCategorias();
        try {
            List<Categoria> categorias = categoriaDAO.getCategorias();
            List<CategoriaDTO> categoriaDTO = listCategoriasTOListCategoriasDTO(categorias);
            response.setCategorias(categoriaDTO);
            response.setDescripcion(Mensajes.EXITO_TRAER_CATEGORIAS);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_TRAER_CATEGORIAS);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método que crea una categoría
     *
     * @param request Contiene la categoría a crear
     * @return Una respuesta si se creó la categoría exitosamente o no
     */
    @Override
    public ResponseDTO crearCategoria(RequestCategoria request) {
        ResponseDTO response = new ResponseDTO();
        Categoria categoria = new Categoria();
        categoria.setCalificacionaprobacion(request.getCalificacionaprobacion());
        categoria.setDescripcion(request.getDescripcion());
        categoria.setNombrecategoria(request.getNombrecategoria());
        categoria.setPorcentajeaprobacion(request.getPorcentajeaprobacion());
        try {
            Categoria validacion = categoriaDAO.traerCategoriaporNombre(categoria.getNombrecategoria(), -1);
            if (validacion == null) {
                long id = categoriaDAO.crearCategoria(categoria);
                response.setDescripcion(Mensajes.EXITO_CREAR_CATEGORIA);
                response.setStatus("1");
                response.setAccion(Acciones.CREAR_CATEGORIA);
                response.setId(id);
            } else {
                response.setDescripcion(Mensajes.ERROR_CATEGORIA_REPETIDA);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_CREAR_CATEGORIA);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Método que actualiza una categoría
     *
     * @param request Contiene la categoría a actualizar
     * @return Una respuesta si se actualizó la categoría exitosamente o no
     */
    @Override
    public ResponseDTO modificarCategoria(RequestCategoria request) {
        ResponseDTO response = new ResponseDTO();
        Categoria categoria = new Categoria();
        categoria.setCalificacionaprobacion(request.getCalificacionaprobacion());
        categoria.setDescripcion(request.getDescripcion());
        categoria.setNombrecategoria(request.getNombrecategoria());
        categoria.setPorcentajeaprobacion(request.getPorcentajeaprobacion());
        categoria.setIdcategoria(request.getIdcategoria());
        try {
            Categoria validacion = categoriaDAO.traerCategoriaporNombre(categoria.getNombrecategoria(), categoria.getIdcategoria());
            if (validacion == null) {
                categoriaDAO.modificarCategoria(categoria);
                response.setDescripcion(Mensajes.EXITO_MODIFICAR_CATEGORIA);
                response.setStatus("1");
                response.setAccion(Acciones.MODIFICAR_CATEGORIA);
            } else {
                response.setDescripcion(Mensajes.ERROR_CATEGORIA_REPETIDA);
                response.setStatus("0");
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_MODIFICAR_CATEGORIA);
            response.setStatus("0");
        }
        return response;
    }

    /**
     * Metodo que trae una categoría a partir de su id
     *
     * @param request Contiene el id de la categoría a traer
     * @return Una respuesta que contiene una categoría
     */
    @Override
    public ResponseTraerCategoria traerCategoria(RequestCategoria request) {
        ResponseTraerCategoria response = new ResponseTraerCategoria();
        try {
            Categoria categoria = categoriaDAO.traerCategoria(request.getIdcategoria());
            CategoriaDTO categoriaDTO = categoriaToCategoriaDTO(categoria);
            response.setCategoria(categoriaDTO);
            response.setDescripcion(Mensajes.EXITO_TRAER_CATEGORIA);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setDescripcion(Mensajes.ERROR_TRAER_CATEGORIA);
            response.setStatus("0");
        }
        return response;
    }

}
