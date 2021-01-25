/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.Impl;

import com.growdata.emprendimiento.business.servicio.impl.CategoriaServicioImpl;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCategoria;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.servicio.CategoriaServicio;
import com.growdata.emprendimiento.persistence.DAO.CategoriaDAO;
import com.growdata.emprendimiento.persistence.entidad.Categoria;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class CategoriaServicioImplTest {

    @Mock
    private CategoriaDAO categoriaDAO;
    @Mock
    private LoggerEmprendimiento log;

    @InjectMocks
    private CategoriaServicio categoriaServicio
            = new CategoriaServicioImpl();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba unitaria para el metodo crearCategoria PU0076-REQ-UC44
     */
    @Test
    public void crearCategoriaTest() {
        System.out.println("Start test: testCrearCategoria");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestCategoria request = new RequestCategoria();
        request.setCalificacionaprobacion(new Short("1"));
        request.setDescripcion("");
        request.setNombrecategoria("");
        request.setPorcentajeaprobacion(new Short("1"));
        try {
            //Prueba 1 categoria creada exitosamente
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(null);
            when(categoriaDAO.crearCategoria(any(Categoria.class))).thenReturn(new Long(1));
            ResponseDTO response = categoriaServicio.crearCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 la categoria existe
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(new Categoria());
            when(categoriaDAO.crearCategoria(any(Categoria.class))).thenReturn(new Long(1));
            response = categoriaServicio.crearCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(new Categoria());
            given(categoriaDAO.crearCategoria(any(Categoria.class))).willThrow(excep);
            response = categoriaServicio.crearCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testCrearCategoria");
        }
        System.out.println("End Test: testCrearCategoria");
    }

    /**
     * Prueba unitaria para el metodo modificarCategoria PU0077-REQ-UC44
     */
    @Test
    public void modificarCategoriaTest() {
        System.out.println("Start test: testModificarCategoria");
        Exception excep = new Exception("ex", new Exception("ex"));
        RequestCategoria request = new RequestCategoria();
        request.setCalificacionaprobacion(new Short("1"));
        request.setDescripcion("");
        request.setNombrecategoria("");
        request.setPorcentajeaprobacion(new Short("1"));
        try {
            //Prueba 1 categoria creada exitosamente
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(null);
            doNothing().when(categoriaDAO).modificarCategoria(any(Categoria.class));
            ResponseDTO response = categoriaServicio.modificarCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("1")));
            System.out.println("    PruebaOK #1 --> OK");
            //Prueba error 1 la categoria existe
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(new Categoria());
            doNothing().when(categoriaDAO).modificarCategoria(any(Categoria.class));
            response = categoriaServicio.modificarCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #1 --> OK");
            //Prueba error 2 lanza una exception
            when(categoriaDAO.traerCategoriaporNombre(any(String.class), any(Long.class))).thenReturn(new Categoria());
            Mockito.doThrow(excep).when(categoriaDAO).modificarCategoria(any(Categoria.class));
            response = categoriaServicio.modificarCategoria(request);
            assertThat(response, is(not(nullValue())));
            assertThat(response.getStatus(), is(equalTo("0")));
            System.out.println("    PruebaError #2 --> OK");
        } catch (Exception ex) {
            
            System.out.println("End Test (Errores): testModificarCategoria");
        }
        System.out.println("End Test: testModificarCategoria");
    }
}
