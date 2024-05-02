package DataAccessObject;

import DataClass.Exposicion;
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
public class ExposicionDAO {

    public ExposicionDAO(Connection conn) {
        this.conn = conn;
    }
    private final Connection conn;
    private final String FINDALL = "select * from Exposiciones";
    private final String FINDBYID = "select * from Exposiciones where id = ?";
    private final String UPDATE = "update Exposiciones set nombre = ?, descripcion = ?, informacion = ?, tema = ?, portada = ? where id = ?";
    private final String DELETE = "delete from Exposiciones where id = ?";
    private final String INSERT = "INSERT INTO Exposiciones (nombre, descripcion, informacion, tema, portada) VALUES(?,?,?,?,?)";
    private final String ADDVISIT = "update Exposiciones set visitas = ? where id = ?";
    private final String ORDERBYVISITS = "select * from Exposiciones order by visitas desc";

    public List<Exposicion> listAll() {
        List<Exposicion> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String informacion = rs.getString("informacion");
                String tema = rs.getString("tema");
                String portada = rs.getString("portada");
                int visitas = rs.getInt("visitas");
                Exposicion at = new Exposicion(id, nombre, descripcion, informacion, tema, portada, visitas);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
    public List<Exposicion> findByPopularity() {
        List<Exposicion> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String informacion = rs.getString("informacion");
                String tema = rs.getString("tema");
                String portada = rs.getString("portada");
                int visitas = rs.getInt("visitas");
                Exposicion at = new Exposicion(id, nombre, descripcion, informacion, tema, portada, visitas);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public Exposicion findById(int id) {
        Exposicion at = null;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String informacion = rs.getString("informacion");
                String tema = rs.getString("tema");
                String portada = rs.getString("portada");
                int visitas = rs.getInt("visitas");
                at = new Exposicion(ide, nombre, descripcion, informacion, tema, portada, visitas);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return at;
    }
    public boolean updateEvento(Exposicion ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(UPDATE);
            ps.setString(1, ev.getNombre());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getInformacion());
            ps.setString(4, ev.getTema());
            ps.setString(5, ev.getPortada());
            ps.setInt(6, ev.getId());
            control = ps.executeUpdate() > 0;
        }catch (SQLException e) {
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
    
    public boolean insertEstudiante(Exposicion ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERT);
            ps.setString(1, ev.getNombre());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getInformacion());
            ps.setString(4, ev.getTema());
            ps.setString(5, ev.getPortada());
            ps.setInt(6, ev.getId());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean AddVisit(int id) {
        boolean control = false;
        Exposicion evento = findById(id);
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