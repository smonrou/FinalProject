package DataAccessObject;

import DataClass.Comentario;
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
public class ComentarioDAO {

    private final Connection conn;
    private final String FINDBYEVENTO = "SELECT cs.id, cs.usuario , u.nombre ,cs.evento ,cs.exposicion , cs.libro AS id_libro, cs.fecha ,cs.contenido FROM ComentariosSugerencias cs JOIN Usuarios u ON cs.usuario = u.id LEFT JOIN Eventos e ON cs.evento = e.id LEFT JOIN Exposiciones ex ON cs.exposicion = ex.id LEFT JOIN Libros l ON cs.libro = l.id where cs.evento = ?";
    private final String FINDBYEXPOSICION = "SELECT cs.id , cs.usuario , u.nombre ,cs.evento ,cs.exposicion , cs.libro , cs.fecha ,cs.contenido  FROM ComentariosSugerencias cs JOIN Usuarios u ON cs.usuario = u.id LEFT JOIN Eventos e ON cs.evento = e.id LEFT JOIN Exposiciones ex ON cs.exposicion = ex.id LEFT JOIN Libros l ON cs.libro = l.id where cs.exposicion = ?";
    private final String FINDBYLIBRO = "SELECT cs.id , cs.usuario , u.nombre ,cs.evento ,cs.exposicion , cs.libro , cs.fecha ,cs.contenido FROM ComentariosSugerencias cs JOIN Usuarios u ON cs.usuario = u.id LEFT JOIN Eventos e ON cs.evento = e.id LEFT JOIN Exposiciones ex ON cs.exposicion = ex.id LEFT JOIN Libros l ON cs.libro = l.id where cs.libro = ?";
    private final String INSERTWITHEVENTO = "INSERT INTO ComentariosSugerencias (usuario, contenido, evento) VALUES(?,?,?)";
    private final String INSERTWITHEXPOSICION = "INSERT INTO ComentariosSugerencias (usuario, contenido, exposicion) VALUES(?,?,?)";
    private final String INSERTWITHLIBRO = "INSERT INTO ComentariosSugerencias (usuario, contenido, libro) VALUES(?,?,?)";
    private final String DELETE = "delete from ComentariosSugerencias where id = ?";
    public ComentarioDAO(Connection conn) {
        this.conn = conn;
    }
    public List<Comentario> findByEventoId(int id) {
        List<Comentario> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYEVENTO);
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("cs.id");
                int userID = rs.getInt("cs.usuario");
                String nombre = rs.getString("u.nombre");
                int publicacion = rs.getInt("cs.evento");
                String fecha = rs.getString("cs.fecha");
                String contenido = rs.getString("cs.contenido");
                Comentario at = new Comentario(ide, userID, nombre, publicacion, fecha, contenido);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public List<Comentario> findByExposicionId(int id) {
        List<Comentario> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYEXPOSICION);
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("cs.id");
                int userID = rs.getInt("cs.usuario");
                String nombre = rs.getString("u.nombre");
                int publicacion = rs.getInt("cs.exposicion");
                String fecha = rs.getString("cs.fecha");
                String contenido = rs.getString("cs.contenido");
                Comentario at = new Comentario(ide, userID, nombre, publicacion, fecha, contenido);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public List<Comentario> findByLibroId(int id) {
        List<Comentario> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYLIBRO);
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("cs.id");
                int userID = rs.getInt("cs.usuario");
                String nombre = rs.getString("u.nombre");
                int publicacion = rs.getInt("cs.libro");
                String fecha = rs.getString("cs.fecha");
                String contenido = rs.getString("cs.contenido");
                Comentario at = new Comentario(ide, userID, nombre, publicacion, fecha, contenido);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
    public boolean insertComentarioEvento(Comentario ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERTWITHEVENTO);
            ps.setInt(1, ev.getId_usuario());
            ps.setString(2, ev.getContenido());
            ps.setInt(3, ev.getIdPublicacion());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean insertComentarioExposicion(Comentario ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERTWITHEXPOSICION);
            ps.setInt(1, ev.getId_usuario());
            ps.setString(2, ev.getContenido());
            ps.setInt(3, ev.getIdPublicacion());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean insertComentarioLibro(Comentario ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERTWITHLIBRO);
            ps.setInt(1, ev.getId_usuario());
            ps.setString(2, ev.getContenido());
            ps.setInt(3, ev.getIdPublicacion());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean deleteComentario(int id) {
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
}
