/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge.barjola
 */
public class MensajeDao {

    private Connection connection;

    public void insertarMensajeMT202( Orden orden) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int cantidad = 0;
            String bic_entidad, bic_corresponsal_propio;
            String sqlnumMensaje = "Select count(id_mensaje) cantidad from mensaje where id_orden=" + orden.getId_orden();

            PreparedStatement stmt = this.connection.prepareStatement(sqlnumMensaje);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
                cantidad++;
            }
            rs.close();

            StringBuffer stbuf = new StringBuffer(orden.getBic_Entidad());
            stbuf.insert(8, "A");
            bic_entidad = stbuf.toString();

            stbuf = new StringBuffer(orden.getCorresponsal_Propio());
            stbuf.insert(8, "A");
            bic_corresponsal_propio = stbuf.toString();

            String sql = "insert into mensaje(bic_entidad_modificado,sentido_tipo_corresponsal, campo113, campo108, TRN,campo21, "
                              + "valor_divisa_importe, bic_entidad, bic_cuenta_corresponsal_propio,bic_cuenta_corresponsal_ajeno"
                              + "bic_cuenta_contrapartida) values (?,?,?,?,?,?,?,?,?,?,?)";
            // prepared statement para insertar con la conexion
            stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, bic_entidad);
            stmt.setString(2, "I" + "202" + bic_corresponsal_propio);
            stmt.setString(3, "NNES");
            stmt.setString(4, "MUR" + generarAleatorio());  //CREACION DEL MUR ALEATORIAMENTE

            stmt.setString(5, orden.getRef_Orden() + "." + cantidad);//TRN LO CALCULAMOS DEBAJO
            stmt.setString(6, "NONREF");
            stmt.setString(7, sdf.format(orden.getFecha_Valor()) + orden.getDivisa() + orden.getImporte());
            stmt.setString(8, orden.getBic_Entidad());
            stmt.setString(9, orden.getCorresponsal_Propio() + orden.getCuenta_Corresponsal_Propio());
            stmt.setString(10, orden.getCorresponsal_Ajeno() + orden.getCuenta_Corresponsal_Ajeno());
            if (orden.getBic_Entidad() != null) {
                stmt.setString(11, orden.getBic_Contrapartida());
            } else {
                stmt.setString(11, orden.getCuenta_Corresponsal_Ajeno());  //REVISAR-----------------------------------------------!!!!!!
            }
            //ejecuta
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarMensajeMT103(Orden orden) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int cantidad = 0;
            String bic_entidad, bic_corresponsal_propio;
            String sqlnumMensaje = "Select count(id_mensaje) cantidad from mensaje where id_orden=" + orden.getId_orden();

            PreparedStatement stmt = this.connection.prepareStatement(sqlnumMensaje);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
                cantidad++;
            }
            rs.close();

            StringBuffer stbuf = new StringBuffer(orden.getBic_Entidad());
            stbuf.insert(8, "A");
            bic_entidad = stbuf.toString();

            stbuf = new StringBuffer(orden.getCorresponsal_Propio());
            stbuf.insert(8, "A");
            bic_corresponsal_propio = stbuf.toString();

            String sql = "insert into mensaje(bic_entidad_modificado,sentido_tipo_corresponsal, campo113, campo108, TRN,campo23B,campo23E, "
                              + "valor_divisa_importe, bic_entidad, bic_cuenta_corresponsal_propio,bic_cuenta_corresponsal_ajeno"
                              + "bic_cuenta_contrapartida, campo71A) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // prepared statement para insertar con la conexion
            stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, bic_entidad);
            stmt.setString(2, "I" + "103" + bic_corresponsal_propio);
            stmt.setString(3, "NNES");
            stmt.setString(4, "MUR" + generarAleatorio() + "STP");  //CREACION DEL MUR ALEATORIAMENTE

            stmt.setString(5, orden.getRef_Orden() + "." + cantidad);//TRN LO CALCULAMOS DEBAJO
            stmt.setString(6, "CRED");
            stmt.setString(7, "SDVA");
            stmt.setString(8, sdf.format(orden.getFecha_Valor()) + orden.getDivisa() + orden.getImporte());
            stmt.setString(9, orden.getBic_Entidad());
            stmt.setString(10, orden.getCorresponsal_Propio() + orden.getCuenta_Corresponsal_Propio());
            stmt.setString(11, orden.getCorresponsal_Ajeno() + orden.getCuenta_Corresponsal_Ajeno());
            stmt.setString(12, orden.getBic_Contrapartida());
            stmt.setString(13, "OUR");

            //ejecuta
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generarAleatorio() {
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTVWYZ".toCharArray();
        // Longitud del array de char.
        int charsLength = chars.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 16; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        return buffer.toString();
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
