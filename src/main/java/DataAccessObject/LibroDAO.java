package DataAccessObject;

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
    private final String ORDERBYVISITS = "select * from Libros order by visitas desc";
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
    
    public List<Libro> listByPopularity() {
        List<Libro> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(ORDERBYVISITS);
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

    public Libro findById(int id) {
        Libro at = null;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String autor = rs.getString("autor");
                String fechaPublicacion = rs.getString("fechaPublicacion");
                String editorial = rs.getString("editorial");
                String portada = rs.getString("portada");
                int existencias = rs.getInt("existencias");
                String genero = rs.getString("genero");
                int visitas = rs.getInt("visitas");
                at = new Libro(ide, titulo, descripcion, autor, fechaPublicacion, editorial, portada, existencias, genero, visitas);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return at;
    }


    public boolean updateEvento(Libro ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(UPDATE);
            ps.setString(1, ev.getTitulo());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getAutor());
            ps.setString(4, ev.getFechaPublicacion());
            ps.setString(5, ev.getEditorial());
            ps.setString(6, ev.getPortada());
            ps.setString(7, ev.getGenero());
            ps.setInt(8, ev.getId());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean deleteEvent(int id) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(DELETE);
            ps.setInt(1, id);
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }

    public boolean insertEstudiante(Libro ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERT);
            ps.setString(1, ev.getTitulo());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getAutor());
            ps.setString(4, ev.getFechaPublicacion());
            ps.setString(5, ev.getEditorial());
            ps.setString(6, ev.getPortada());
            ps.setInt(7, ev.getExistencias());
            ps.setString(8, ev.getGenero());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
        public boolean AddVisit(int id) {
        boolean control = false;
        Libro evento = findById(id);
        int visitas = evento.getVisitas()+1;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(ADDVISIT);
            ps.setInt(1, visitas);
            ps.setInt(2, id);
            control = ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
}
