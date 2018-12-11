/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
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

        return null;
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
        return null;
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

    public void insertarMensaje(Mensaje m, Orden orden) {

        try {
            int cantidad = 0;
            String sqlnumMensaje = "Select count(id_mensaje) cantidad from mensaje where id_orden=" + orden.getId_orden();

            PreparedStatement stmt = this.connection.prepareStatement(sqlnumMensaje);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
                cantidad++;
            }
            rs.close();

            String sql = "insert into mensaje(tipo_mensaje, estado_cruce, TRN, id_orden) values (?,?,?,?)";
            // prepared statement para insertar con la conexion
            stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, m.getTipoMensaje());      //-------------------------------------------------------------------------------------------------------
            stmt.setString(2, m.getEstadoCruce());
            stmt.setString(3, orden.getRef_Orden() + "." + cantidad);//TRN LO CALCULAMOS DEBAJO
            stmt.setInt(4, orden.getId_orden());//TRN LO CALCULAMOS DEBAJO

            //ejecuta
            stmt.execute();

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
