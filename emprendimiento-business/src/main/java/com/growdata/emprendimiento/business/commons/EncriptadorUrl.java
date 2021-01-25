/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.commons;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class EncriptadorUrl {

    /**
     * Aleatorio.
     */
    private static final byte[] SALT = {(byte) 0x21, (byte) 0x21, (byte) 0xF0,
        (byte) 0x55, (byte) 0xC3, (byte) 0x9F, (byte) 0x5A, (byte) 0x75};

    /**
     * Iteraciones.
     */
    private final static int ITERATION_COUNT = 31;

    /**
     * Constructor.
     */
    private EncriptadorUrl() {
    }

    /**
     * Método que encripta un texto
     *
     * @param input Cadena de texto a encriptar.
     * @return Cadena de texto encriptada.
     */
    public static String encode(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        try {

            KeySpec keySpec = new PBEKeySpec(null, SALT, ITERATION_COUNT);
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT,
                    ITERATION_COUNT);

            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
                    .generateSecret(keySpec);

            Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

            byte[] enc = ecipher.doFinal(input.getBytes());

            String res = new String(Base64.encodeBase64(enc));
            // escapes for url
            res = res.replace('+', '-').replace('/', '_').replace("%", "%25")
                    .replace("\n", "%0A");

            return res;

        } catch (Exception ex) {
            
        }

        return "";

    }

    /**
     * Método que desencripta un texto
     *
     * @param token Cadena de texto encriptada.
     * @return Cadena de texto sin encriptar.
     */
    public static String decode(String token) {
        if (token == null) {
            return null;
        }
        try {

            String input = token.replace("%0A", "\n").replace("%25", "%")
                    .replace('_', '/').replace('-', '+');

            byte[] dec = Base64.decodeBase64(input.getBytes());

            KeySpec keySpec = new PBEKeySpec(null, SALT, ITERATION_COUNT);
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT,
                    ITERATION_COUNT);

            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
                    .generateSecret(keySpec);

            Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

            byte[] decoded = dcipher.doFinal(dec);

            String result = new String(decoded);
            return result;

        } catch (Exception ex) {
            // use logger in production code
            
        }

        return null;
    }
}
