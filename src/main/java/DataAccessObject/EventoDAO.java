/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataClass.Evento;
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
public class EventoDAO {

    public EventoDAO(java.sql.Connection conn) {
        this.conn = conn;
    }
    private final Connection conn;
    private final String FINDALL = "select * from Eventos";
    private final String FINDBYID = "select * from Eventos where id = ?";
    private final String UPDATE = "update Eventos set nombre = ?, descripcion = ?, detalles = ?, temas = ?, fechaVigencia = ?, portada = ? where id = ?";
    private final String DELETE = "delete from Eventos where id = ?";
    private final String INSERT = "INSERT INTO Eventos (nombre, descripcion, detalles, temas, fechaVigencia, portada) VALUES(?,?,?,?,?,?)";
    private final String ADDVISIT = "update Eventos set visitas = ? where id = ?";

    public List<Evento> listAll() {
        List<Evento> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String detalles = rs.getString("detalles");
                String temas = rs.getString("temas");
                String fechaVigencia = rs.getString("fechaVigencia");
                String portada = rs.getString("portada");
                int visitas = rs.getInt("visitas");
                Evento at = new Evento(id, nombre, descripcion, detalles, temas, fechaVigencia, portada, visitas);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public Evento findById(int id) {
        Evento at = null;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String detalles = rs.getString("detalles");
                String temas = rs.getString("temas");
                String fechaVigencia = rs.getString("fechaVigencia");
                String portada = rs.getString("portada");
                int visitas = rs.getInt("visitas");
                at = new Evento(ide, nombre, descripcion, detalles, temas, fechaVigencia, portada, visitas);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return at;
    }

    public boolean updateEvento(Evento ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(UPDATE);
            ps.setString(1, ev.getNombre());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getDetalles());
            ps.setString(4, ev.getTemas());
            ps.setString(5, ev.getFechaVigencia());
            ps.setString(6, ev.getPortada());
            ps.setInt(7, ev.getId());
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
    
    public boolean insertEstudiante(Evento ev) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERT);
            ps.setString(1, ev.getNombre());
            ps.setString(2, ev.getDescripcion());
            ps.setString(3, ev.getDetalles());
            ps.setString(4, ev.getTemas());
            ps.setString(5, ev.getFechaVigencia());
            ps.setString(6, ev.getPortada());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
    
    public boolean AddVisit(int id) {
        boolean control = false;
        Evento evento = findById(id);
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
