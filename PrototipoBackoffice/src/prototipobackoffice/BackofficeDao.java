/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import sun.swing.BakedArrayList;

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
    
    
    public static void main(String[] ars){
        new BackofficeDao().insertarOrden(new Orden(0, "BS99090", "", "bbva", "BBVABIC", "PAGO", 0, "EUR", new java.util.Date(), new java.util.Date(), new java.util.Date(), "jorge", "123456789", "Alvaro", "12345678", "MT202"));
    }
                   

    public void insertarOrden(Orden orden) {

        String sql = "insert into ordenes(id_orden, tipo_orden, ref_orden, contrapartida,sentido, importe, "
                          + "divisa, fecha_entrada,fecha_valor, fecha_liquidacion,estado, corresponsal_propio, "
                          + "cuenta_corresponsal_propio) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            // prepared statement para insertar con la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //setear los valores
            stmt.setLong(1, orden.getId_orden());
            stmt.setString(2, "Individual") ;      //-------------------------------------------------------------------------------------------------------
            stmt.setString(3, "");
            stmt.setString(4, orden.getContrapartida());
            stmt.setString(5, orden.getSentido());
            stmt.setDouble(6, orden.getImporte());
            stmt.setString(7, orden.getDivisa());
            stmt.setDate(8,new java.sql.Date(orden.getFecha_Valor().getTime()));
            stmt.setDate(9, new java.sql.Date(orden.getFecha_Valor().getTime()));
            stmt.setDate(10, new java.sql.Date(orden.getFecha_Valor().getTime()));
            stmt.setString(12, "");             //-------------------------------------------------------------------------------------------------------
            stmt.setString(13, orden.getCorresponsal_Propio());
            stmt.setString(14, orden.getCuenta_Corresponsal_Propio());

            
            //ejecuta
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            long id = 0;
            if(rs.next())
                 id = rs.getLong(1);
            
            String sqlupdate = "UPDATE orden SET ref = 'ORDEN0000" + id + "' WHERE id = " + id;
            stmt = this.connection.prepareStatement(sqlupdate);            
            //ejecuta
            stmt.execute();
            
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
