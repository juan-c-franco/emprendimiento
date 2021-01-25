/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

/**
 * Clase para generar contraseña aleatoria.
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
public class Contrasena {

    /**
     * Caracteres por los cuales puede estar compuesta la contraseña.
     */
    private char[] elementos;

    /**
     * Conjunto de caracteres para la contraseña.
     */
    private char[] conjunto = new char[8];

    /**
     * Cadena de caracteres de contraseña.
     */
    private String pass;

    /**
     * Constructor.
     */
    public Contrasena() {
        this.elementos = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'v', 'x', 'y', 'z'};
    }

    /**
     * Metodo que crea una contraseña aleatoria de 8 carácteres.
     *
     * @return Contraseña aleatoria
     */
    public String crearPassword() {
        for (int i = 0; i < 8; i++) {
            int elem = (int) (Math.random() * 36);
            conjunto[i] = (char) elementos[elem];
        }
        pass = new String(conjunto);
        return pass;
    }
}
