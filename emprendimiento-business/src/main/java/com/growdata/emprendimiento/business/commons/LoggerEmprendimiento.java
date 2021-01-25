package com.growdata.emprendimiento.business.commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Clase servicio para log de aplicación.
 *
 * @author Juan Franco
 */
@Service
public class LoggerEmprendimiento {

    /**
     * Ambiente de propiedades.
     */
    @Autowired
    private Environment env;

    /**
     * Log.
     */
    private static Logger logger = Logger.getLogger("logEmprendimiento");

    /**
     * Gestor de archivos.
     */
    private FileHandler handler;

    /**
     * Método genérico para escribir en el log con nivel SEVERE
     *
     * @param ex Exception lanzada
     * @return Indica si se escribio satisfactoriamente en el log
     */
    public boolean writeToLogFile(Exception ex) {
        return writeToLogFile(ex, 7);
    }

    /**
     * Método genérico para escribir mensajes en el log
     *
     * @param e Exception lanzada
     * @param level Nivel de importacia del mensaje
     * @return Indica si se escribio satisfactoriamente en el log.
     */
    public boolean writeToLogFile(Exception e, int level) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String dateString = format.format(new Date());
            File file = new File(env.getProperty("path.LoggerEmprendimiento"));
            file.getParentFile().mkdirs();
            handler = new FileHandler(file.getAbsolutePath() + dateString + ".log");
            logger.addHandler(handler);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            switch (level) {
                //FINEST
                case 1:
                    logger.log(Level.FINEST, e.getMessage(), e);
                    break;
                //FINER
                case 2:
                    logger.log(Level.FINER, e.getMessage(), e);
                    break;
                //FINE
                case 3:
                    logger.log(Level.FINE, e.getMessage(), e);
                    break;
                //CONFIG
                case 4:
                    logger.log(Level.CONFIG, e.getMessage(), e);
                    break;
                //INFO
                case 5:
                    logger.log(Level.INFO, e.getMessage(), e);
                    break;
                //WARNING
                case 6:
                    logger.log(Level.WARNING, e.getMessage(), e);
                    break;
                //SEVERE
                case 7:
                    logger.log(Level.SEVERE, e.getMessage(), e);
                    break;
                default:
                    logger.log(Level.SEVERE, e.getMessage(), e);
            }

            return true;
        } catch (Exception ex) {
            
            return false;
        }
    }

}
