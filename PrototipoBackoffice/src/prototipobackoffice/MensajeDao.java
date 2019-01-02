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
import sun.applet.Main;

/**
 *
 * @author jorge.barjola
 */
public class MensajeDao {

    private Connection connection;
    private String cruce;

    public MensajeDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void recibirMensajeMT910(Orden orden) {

    }

    public void recibirACK(Mensaje m) {

        try {
            int idMensaje = 0;
            String estadoOrden = null;
            int idOrden = 0;
            PreparedStatement stmt = this.connection.prepareStatement("Select id_mensaje, id_orden from mensaje where bic_entidad=? and campo108=?");
            stmt.setString(1, m.getBic_entidad());
            stmt.setString(2, m.getMUR());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idMensaje = rs.getInt("id_mensaje");
                idOrden = rs.getInt("id_orden");
            }

            stmt = this.connection.prepareStatement("Select estado from ordenes where id_orden=" + idOrden);
            rs = stmt.executeQuery();
            if (rs.next()) {
                estadoOrden = rs.getString("estado");
            }

            if (estadoOrden == "Liberada") {
                if (idMensaje != 0) {
                    cruce = "Cruzada";
                    stmt = this.connection.prepareStatement("Update mensaje SET estado_cruce=? where id_mensaje=" + idMensaje);
                    stmt.setString(1, cruce);
                    stmt.execute();
                    stmt = this.connection.prepareStatement("Update ordenes SET estado=? where id_orden=" + idOrden);
                    stmt.setString(1, "ACK");
                    stmt.execute();
                } else {
                    cruce = "No Cruzada";
                    stmt = this.connection.prepareStatement("Update mensaje SET estado_cruce=? where id_mensaje=" + idMensaje);
                    stmt.setString(1, cruce);
                    stmt = this.connection.prepareStatement("Update ordenes SET estado=? where id_orden=" + idOrden);
                    stmt.setString(1, "Incidencia");
                    stmt.execute();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La orden no esta LIBERADA");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void recibirNACK(Mensaje m) {

        try {
            String estadoOrden = null;
            int idMensaje = 0;
            int idOrden = 0;
            PreparedStatement stmt = this.connection.prepareStatement("Select id_mensaje, id_orden from mensaje where bic_entidad=? and campo108=?");
            stmt.setString(1, m.getBic_entidad());
            stmt.setString(2, m.getMUR());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idMensaje = rs.getInt("id_mensaje");
                idOrden = rs.getInt("id_orden");
            }
            stmt = this.connection.prepareStatement("Select estado from ordenes where id_orden=" + idOrden);
            rs = stmt.executeQuery();
            if (rs.next()) {
                estadoOrden = rs.getString("estado");
            }

            if (estadoOrden == "Liberada") {
                if (idMensaje != 0) {
                    cruce = "Cruzada";
                    stmt = this.connection.prepareStatement("Update mensaje SET estado_cruce=?, codigoError=? where id_mensaje=" + idMensaje);
                    stmt.setString(1, cruce);
                    stmt.setString(2, "Y01");
                    stmt.execute();
                    stmt = this.connection.prepareStatement("Update ordenes SET estado=? where id_orden=" + idOrden);
                    stmt.setString(1, "ACK");
                    stmt.execute();
                } else {
                    cruce = "No Cruzada";
                    stmt = this.connection.prepareStatement("Update mensaje SET estado_cruce=?, codigoError=? where id_mensaje=" + idMensaje);
                    stmt.setString(1, cruce);
                    stmt.setString(2, "Y01");
                    stmt.execute();
                    stmt = this.connection.prepareStatement("Update ordenes SET estado=? where id_orden=" + idOrden);
                    stmt.setString(1, "Incidencia");
                    stmt.execute();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La orden no esta LIBERADA");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] ars) {

        Mensaje m = new Mensaje("BSCHESMMXXX", "MURCPCT2N16N28SP1R7STP");
        MensajeDao dao = new MensajeDao();
        dao.recibirNACK(m);

    }

    public void insertarMensajeMT202(Orden orden) {

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
                              + "bic_cuenta_contrapartida, tipo_mensaje, estado_cruce, id_orden) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setString(12, orden.getTipo_Mensaje());
            stmt.setString(13, orden.getEstado());
            stmt.setInt(14, orden.getId_orden());
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
                              + ",bic_cuenta_contrapartida, campo71A, tipo_mensaje, estado_cruce, id_orden) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setString(14, orden.getTipo_Mensaje());
            stmt.setString(15, orden.getEstado());
            stmt.setInt(16, orden.getId_orden());

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
        for (int i = 0; i < 13; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        return buffer.toString();
    }

    public String generarNumeroAleatorio() {
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789".toCharArray();
        // Longitud del array de char.
        int charsLength = chars.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 13; i++) {
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

    /*
    public String calcularCruce(Mensaje m) {
        try {
            BackofficeDao dao = new BackofficeDao();
            String ref = "";
            String sql = "Select ref_orden from ordenes where id_orden=" + m.getOrden().getId_orden();
            // prepared statement para insertar con la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ref = rs.getString("ref_orden");
            }
            Orden ordenAux = new Orden();
            ordenAux = dao.getOrden(ref);

            if (m.getBic_entidad() == ordenAux.getBic_Entidad() && m.getTrn() == ordenAux.getTrn_orden()
                              &&) {
                cruce = "Cruzada";
            } else {
                cruce = "No Cruzada";
            }

            sql = "Update mensaje SET estado_cruce='" + cruce + "'";
            // prepared statement para insertar con la conexion
            stmt = this.connection.prepareStatement(sql);

        } catch (Exception e) {
        }
        return cruce;
    }

    public void recibirMensajeMT900(Orden orden, Mensaje m) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int cantidad = 0;
            String TRN = "";
            String bic_entidad, bic_corresponsal_propio;
            String sqlnumMensaje = "Select MAX(TRN) AS trn from mensaje where id_orden=" + orden.getId_orden();

            PreparedStatement stmt = this.connection.prepareStatement(sqlnumMensaje);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TRN = rs.getString("trn");
            }
            rs.close();

            StringBuffer stbuf = new StringBuffer(orden.getBic_Entidad());
            stbuf.insert(8, "A");
            bic_entidad = stbuf.toString();

            stbuf = new StringBuffer(orden.getCorresponsal_Propio());
            stbuf.insert(8, "A");
            bic_corresponsal_propio = stbuf.toString();

            String sql = "insert into mensaje(bic_entidad_modificado,sentido_tipo_corresponsal, campo108,campo20 ,TRN, "
                              + "bic_cuenta_corresponsal_propio, valor_divisa_importe, bic_corresponsal_propio ,"
                              + "tipo_mensaje, estado_cruce, id_orden) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            // prepared statement para insertar con la conexion
            stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, bic_entidad);
            stmt.setString(2, "O" + "900" + bic_corresponsal_propio);
            stmt.setString(4, "MUR" + generarAleatorio());  //CREACION DEL MUR ALEATORIAMENTE
            stmt.setString(5, "TRN" + generarNumeroAleatorio());
            stmt.setString(6, TRN);
            stmt.setString(7, orden.getCuenta_Corresponsal_Propio());
            stmt.setString(8, sdf.format(orden.getFecha_Valor()) + orden.getDivisa() + orden.getImporte());
            stmt.setString(9, orden.getCorresponsal_Propio());
            stmt.setString(10, orden.getTipo_Mensaje()); //Modificamos debajo
            stmt.setString(11, " ");
            stmt.setInt(12, orden.getId_orden());

            //ejecuta
            stmt.execute();

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     */
}
