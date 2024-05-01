/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    private static final String BD = "project";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:33060/" + BD+ "?useSSL=false";
     private static final Connection conn = null;
     
     public static Connection obtenerConexion() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if(conn != null){
                System.out.println("Base de datos " + BD + " disponible...");
            }        
        }catch(SQLException | ClassNotFoundException e){
                    System.out.println(e);
                    }
               return conn;
    }

    public static void cerrarConexion(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
