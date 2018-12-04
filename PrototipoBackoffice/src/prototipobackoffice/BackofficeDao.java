/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;

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
