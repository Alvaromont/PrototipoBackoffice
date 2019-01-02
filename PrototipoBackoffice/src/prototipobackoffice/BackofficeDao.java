/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author alvaro.montero
 */
public class BackofficeDao {

    //Dao Data Access Object
    // para crear las operaciones que se realizaran con la BBDD
    private Connection connection;

    public BackofficeDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

//    public static void main(String[] ars) {
//        new BackofficeDao().insertarOrden(new Orden("Individual"," ","bbva", "PAGO", 0, "EUR",new java.util.Date(), new java.util.Date(), new java.util.Date(), new java.util.Date(), "jorge", "123456789",0, "BS99090", "BBVABIC","Alvaro", "12345678", "MT202"));
//    }
    public void insertarOrden(Orden orden) {

        String sql = "insert into ordenes(tipo_orden,BIC_entidad, ref_orden, contrapartida,BIC_contrapartida,sentido, importe, "
                          + "divisa, fecha_entrada,fecha_valor, fecha_liberacion ,fecha_liquidacion, corresponsal_propio,cuenta_corresponsal_propio,"
                          + "corresponsal_ajeno, cuenta_corresponsal_ajeno, tipo_mensaje, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            // prepared statement para insertar con la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //setear los valores
            stmt.setString(1, orden.getTipo_Orden());
            stmt.setString(2, orden.getBic_Entidad());      //-------------------------------------------------------------------------------------------------------
            stmt.setString(3, null); //LO CALCULAMOS DEBAJO
            stmt.setString(4, orden.getContrapartida());
            stmt.setString(5, orden.getBic_Contrapartida());
            stmt.setString(6, orden.getSentido());
            stmt.setDouble(7, orden.getImporte());
            stmt.setString(8, orden.getDivisa());
            stmt.setString(9, sdf.format(orden.getFecha_Entrada()));
            stmt.setString(10, sdf.format(orden.getFecha_Valor()));
            stmt.setString(11, sdf.format(orden.getFecha_Valor()));
            stmt.setString(12, sdf.format(orden.getFecha_Valor()));
            stmt.setString(13, orden.getCorresponsal_Propio());
            stmt.setString(14, orden.getCuenta_Corresponsal_Propio());
            stmt.setString(15, orden.getCorresponsal_Ajeno());
            stmt.setString(16, orden.getCuenta_Corresponsal_Ajeno());
            stmt.setString(17, orden.getTipo_Mensaje());
            stmt.setString(18, orden.getEstado());

            //ejecuta
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                asignarRef_Orden(rs.getInt(1));
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void asignarRef_Orden(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX(ref_orden) AS orden  FROM ordenes");
            ResultSet rs = stmt.executeQuery();

            String lastOrden = "";
            if (rs.next()) {
                lastOrden = rs.getString("orden");
                lastOrden = lastOrden.replaceAll("\\D+", ""); // remove las letras
            } else {
                lastOrden = "0";
            }

            int mayor = Integer.parseInt(lastOrden) + 1;
            lastOrden = "" + mayor;
            lastOrden = StringUtils.leftPad(lastOrden, 3, "0");

            String sqlupdate = "UPDATE ordenes SET ref_orden = 'ORDEN" + lastOrden + "' WHERE id_orden = " + id;
            stmt = this.connection.prepareStatement(sqlupdate);
            //ejecuta
            stmt.execute();
            stmt.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void LiberarOrden(Orden orden) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (orden.getSentido().equals("Cobro")) {
            try {
                PreparedStatement stmt = this.connection.prepareStatement("Update ordenes set estado=?, fecha_liberacion=? where ref_orden=?");
                stmt.setString(1, "ACK");
                stmt.setString(2, sdf.format(new java.util.Date()));
                stmt.setString(3, orden.getRef_Orden());

                stmt.execute();
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (orden.getSentido().equals("Pago ")) {
            MensajeDao dao = new MensajeDao();
            try {
                PreparedStatement stmt = this.connection.prepareStatement("Update ordenes set estado=?, fecha_liberacion=?, tipo_mensaje=? where ref_orden=?");
                stmt.setString(1, "Liberada");
                orden.setEstado("Liberada");
                stmt.setString(2, sdf.format(new java.util.Date()));
                stmt.setString(3, orden.getTipo_Mensaje());
                stmt.setString(4, orden.getRef_Orden());
                if (orden.getTipo_Mensaje().equals("MT103")) {
                    dao.insertarMensajeMT103(orden);
                } else {
                    dao.insertarMensajeMT202(orden);
                }
                
                stmt.execute();
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void LiquidarOrdenManual(Orden orden) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (orden.getEstado().equals("ACK")) {
                PreparedStatement stmt = this.connection.prepareStatement("Update ordenes set estado=?, fecha_liquidacion=? where ref_orden=?");
                stmt.setString(1, "LIQUIDADA");
                stmt.setString(2, sdf.format(new java.util.Date()));
                stmt.setString(3, orden.getRef_Orden());

                stmt.execute();
                stmt.close();
            } else {
                JOptionPane.showMessageDialog(null, "NO ES POSIBLE LIBERAR LA ORDEN SELECCIONADA MANUALMENTE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Orden> listarTodos(String ref_Orden) {
        ArrayList<Orden> ordenes = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            PreparedStatement stmt = this.connection.prepareStatement("Select * from ordenes where ref_orden like '%" + ref_Orden + "%'");
            ResultSet rs = stmt.executeQuery();

            //itera en el resulset 
            while (rs.next()) {
                int id = rs.getInt("id_orden");
                String tipoOrden = rs.getString("tipo_orden");
                String refOrden = rs.getString("ref_orden");
                String contrapartida = rs.getString("contrapartida");
                String sentido = rs.getString("sentido");
                double importe = rs.getDouble("importe");
                String divisa = rs.getString("divisa");
                java.util.Date fechaEntrada = sdf.parse(rs.getString("fecha_entrada"));
                java.util.Date fechaValor = sdf.parse(rs.getString("fecha_valor"));
                java.util.Date fechaLiquidacion = sdf.parse(rs.getString("fecha_liquidacion"));
                String estado = rs.getString("estado");
                String TRN = obtnerTRN("select TRN from mensaje where id_orden = " + id + " order by id_mensaje desc limit 1");
                String corresponsalPropio = rs.getString("corresponsal_propio");
                String cuentaCP = rs.getString("cuenta_corresponsal_propio");

                Orden orden = new Orden(id, tipoOrden, refOrden, contrapartida, sentido, importe, divisa, fechaEntrada, fechaValor,
                                  fechaLiquidacion, estado, TRN, corresponsalPropio, cuentaCP);
                ordenes.add(orden);
            }
            rs.close();
            stmt.close();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return ordenes;
    }

    public Orden getOrden(String ref_orden) {
        Orden orden = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //conexion con la base y el statement
            PreparedStatement stmt = this.connection.prepareStatement("Select * from ordenes where ref_orden like '%" + ref_orden + "%'");

            //ejecuta un select
            ResultSet rs = stmt.executeQuery();

            //itera en el resulset 
            while (rs.next()) {
                int idOrden = rs.getInt("id_orden");
                String tipoOrden = rs.getString("tipo_orden");
                String refOrden = rs.getString("ref_orden");
                String contrapartida = rs.getString("contrapartida");
                String sentido = rs.getString("sentido");
                double importe = rs.getDouble("importe");
                String divisa = rs.getString("divisa");
                java.util.Date fechaEntrada = sdf.parse(rs.getString("fecha_entrada"));
                java.util.Date fechaValor = sdf.parse(rs.getString("fecha_valor"));
                java.util.Date fechaLiquidacion = sdf.parse(rs.getString("fecha_liquidacion"));
                java.util.Date fechaLiberacion = sdf.parse(rs.getString("fecha_liberacion"));
                String estado = rs.getString("estado");
                String TRN = obtnerTRN("select TRN from mensaje where id_orden = " + idOrden + " order by id_mensaje desc limit 1");
                String corresponsalPropio = rs.getString("corresponsal_propio");
                String cuentaCP = rs.getString("cuenta_corresponsal_propio");
                String bic_Entidad = rs.getString("bic_entidad");
                String bic_contrapartida = rs.getString("bic_contrapartida");
                String corresponsalAjeno = rs.getString("corresponsal_ajeno");
                String cuentaCA = rs.getString("cuenta_corresponsal_ajeno");
                String tipoMensaje = rs.getString("tipo_mensaje");

                orden = new Orden(idOrden, bic_Entidad, tipoOrden, refOrden, contrapartida, sentido, importe, divisa, fechaEntrada, fechaValor,
                                  fechaLiquidacion, fechaLiberacion, estado, TRN, corresponsalPropio, cuentaCP, bic_contrapartida,
                                  corresponsalAjeno, cuentaCA, tipoMensaje);
            }
            rs.close();
            stmt.close();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return orden;
    }


    /*
    public void insertarOrden(Orden orden) {

        String sql = "insert into movil(nombre, precio, unidades) values (?,?,?)";
        try {
            // prepared statement para insertar con la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, movil.getNombre());
            stmt.setDouble(2, movil.getPrecio());
            stmt.setInt(3, movil.getUnidades());

            //ejecuta
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Movil> listaTodos() {
        return listaTodos("");
    }

    public ArrayList<Movil> listaTodos(String nombreBusqueda) {
        ArrayList<Movil> moviles = new ArrayList<>();
        try {
            //conexion con la base y el statement
            PreparedStatement stmt = this.connection.prepareStatement("Select * from movil where nombre like '%" + nombreBusqueda + "%'");

            //ejecuta un select
            ResultSet rs = stmt.executeQuery();

            //itera en el resulset 
            while (rs.next()) {
                int id = rs.getInt("idMovil");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int unidades = rs.getInt("unidades");

                Movil movil = new Movil(id, nombre, precio, unidades);
                moviles.add(movil);

            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviles;
    }

    public void editarMovil(Movil movil) {

        String sql = "update movil set nombre=?, precio=?, unidades =? where idMovil=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, movil.getNombre());
            stmt.setDouble(2, movil.getPrecio());
            stmt.setInt(3, movil.getUnidades());
            stmt.setInt(4, movil.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUnidadesMovil(Movil movil, int venta) {
        int cantidadFinal = movil.getUnidades() - venta;
        String sql = "update movil set unidades =? where idMovil=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, cantidadFinal);
            stmt.setInt(2, movil.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     */
    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String obtnerTRN(String sql) {
        String trn = "";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                trn = rs.getString("TRN");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
        }
        return trn;
    }

    private MensajeDao MensajeDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
