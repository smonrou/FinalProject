/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataClass.Exposicion;
import DataClass.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class LibroDAO {

    public LibroDAO(java.sql.Connection conn) {
        this.conn = conn;
    }

    private final Connection conn;
    private final String FINDALL = "select * from Libros";
    private final String FINDBYID = "select * from Libros where id = ?";
    private final String UPDATE = "update Libros set titulo = ?, descripcion = ?, autor = ?, fechaPublicacion = ?, editorial = ?, portada = ? , genero = ? where id = ?";
    private final String DELETE = "delete from Libros where id = ?";
    private final String INSERT = "insert into Libros(titulo, descripcion, autor, fechaPublicacion, editorial, portada, existencias, genero) VALUES(?,?,?,?,?,?,?,?)";
    private final String ADDVISIT = "update Libros set visitas = ? where id = ?";

    public List<Libro> listAll() {
        List<Libro> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String autor = rs.getString("autor");
                String fechaPublicacion = rs.getString("fechaPublicacion");
                String editorial = rs.getString("editorial");
                String portada = rs.getString("portada");
                int existencias = rs.getInt("existencias");
                String genero = rs.getString("genero");
                int visitas = rs.getInt("visitas");
                Libro at = new Libro(id, titulo, descripcion, autor, fechaPublicacion, editorial, portada, existencias, genero, visitas);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
