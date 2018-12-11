/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge.barjola
 */
public class MensajeDao {

    private Connection connection;

    public MensajeDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    String generarMensajeMT103(Orden orden) {

        try {

        } catch (Exception e) {
        }
        return null;

    }

    String generarMensajeMT202(Orden orden) {
        return "";
    }

    String generarMensajeMT900(Orden orden) {
        return "";
    }

    String generarMensajeMT910(Orden orden) {
        return "";
    }

    String generarMensaje(Orden orden) {
        String mensajeResultante;
        switch (orden.getTipo_Mensaje()) {

            case "MT103":
                mensajeResultante = generarMensajeMT103(orden);
                break;

            case "MT202":
                mensajeResultante = generarMensajeMT202(orden);
                break;
            case "MT900":
                mensajeResultante = generarMensajeMT900(orden);
                break;
            case "MT910":
                mensajeResultante = generarMensajeMT910(orden);
                break;

            default:
                JOptionPane.showMessageDialog(null, "El mensaje recibido no se corresponde con ninguno de los almacenados");

        }

        return mensajeResultante;
    }

    String getMensajeMT103() {
        return null;

    }

    String getMensajeMT202() {
        return null;

    }

    String getMensajeMT900() {
        return null;

    }

    String getMensajeMT910() {
        return null;

    }

    String getMensaje(String tipoMensaje) {
        String mensajeResultante;

        switch (tipoMensaje) {
            case "MT103":
                mensajeResultante = getMensajeMT103();
                break;

            case "MT202":
                mensajeResultante = getMensajeMT202();
                break;
            case "MT900":
                mensajeResultante = getMensajeMT900();
                break;
            case "MT910":
                mensajeResultante = getMensajeMT910();
                break;

            case "ACK":
                break;

            case "NACK":
                break;

            default:
                JOptionPane.showMessageDialog(null, "El mensaje recibido no se corresponde con ninguno de los almacenados");
        }
        return mensajeResultante;
    }

    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
