package DataAccessObject;

import DataClass.RegistroActividad;
import Provider.UsuariosProvider;
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
public class RegistroActividadDAO {

    private final Connection conn;
    private final String FINDALL = "select ra.id, u.id, u.nombre, u.rol, ra.accion, ra.fecha\n"
            + "from RegistrosActividad ra\n"
            + "inner join Usuarios u ON ra.usuario = u.id;";
    private final String INSERT = "insert into RegistrosActividad (usuario, accion) VALUES(?,?)";
    public RegistroActividadDAO(Connection conn) {
        this.conn = conn;
    }
    public List<RegistroActividad> listAll() {
        List<RegistroActividad> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ra.id");
                int userID = rs.getInt("u.id");
                String nombre = rs.getString("u.nombre");
                String rol = rs.getString("u.rol");
                String accion = rs.getString("ra.accion");
                String fecha = rs.getString("ra.fecha");
                RegistroActividad at = new RegistroActividad(id, userID, nombre, rol, accion, fecha);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    public boolean insertActividad(String actividad) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERT);
            ps.setInt(1, UsuariosProvider.getUser().getId());
            ps.setString(2, actividad);
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
}
