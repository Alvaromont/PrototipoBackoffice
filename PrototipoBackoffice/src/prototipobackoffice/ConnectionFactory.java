/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;


import java.sql.*;

/**
 *
 * @author alvaro.montero
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            /*jdbc es el protocolo
            mysql es el sub-protocolo
            localhost es el servidor (IP o nombre)
            3306 es el puerto (creado por defecto), si no es el puerto por defecto, es obligatorio
            agenda es el nombre de la BBDD
            */
            //createDatabaseIfNotExist = true;
            String url = "jdbc:mysql://localhost:3306/backoffice";
            String usuario = "root";
            String password = "root";
            
            return DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
