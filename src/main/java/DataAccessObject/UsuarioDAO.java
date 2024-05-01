package DataAccessObject;

import DataClass.Usuario;
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
public class UsuarioDAO {

    private final Connection conn;
    private final String FINDALL = "select * from Usuarios";
    private final String FINDBYID = "select * from Usuarios where id = ?";
    private final String UPDATE = "update Usuarios set username = ?, nombre = ?, email = ?, pass = ?, telefono = ?, foto = ? where id = ?";
    private final String DELETE = "delete from Usuarios where id = ?";
    private final String INSERT = "insert into Usuarios (username, nombre, email, pass, telefono, foto) VALUES(?,?,?,?,?,?,?) ";
    private final String UPDATEROL = "update Usuarios set rol = ? where id = ?";

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Usuario> listAll() {
        List<Usuario> result = new ArrayList<>();
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                String telefono = rs.getString("telefono");
                String rol = rs.getString("rol");
                String foto = rs.getString("portada");
                Usuario at = new Usuario(id, username, nombre, email, pass, telefono, rol, foto);
                result.add(at);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public Usuario findById(int id) {
        Usuario at = null;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(FINDBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String username = rs.getString("username");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                String telefono = rs.getString("telefono");
                String rol = rs.getString("rol");
                String foto = rs.getString("portada");
                at = new Usuario(ide, username, nombre, email, pass, telefono, rol, foto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return at;
    }

    public boolean updateUsuario(Usuario user) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(UPDATE);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPass());
            ps.setString(5, user.getTelefono());
            ps.setString(6, user.getFoto());
            ps.setInt(7, user.getId());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }

    public boolean deletUser(int id) {
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

    public boolean insertUsuario(Usuario user) {
        boolean control = false;
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(INSERT);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPass());
            ps.setString(5, user.getTelefono());
            ps.setString(6, user.getFoto());
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }

    public boolean changeUserRol(int id) {
        boolean control = false;
        Usuario evento = findById(id);
        String rol;
        try {
            switch (evento.getRol()) {
                case "usuario_regular":
                    rol = "administrador";
                    break;
                case "administrador":
                    rol = "usuario_regular";
                    break;
                default:
                    rol = "usuario_regular";
                    break;
            }
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(UPDATEROL);
            ps.setString(1, rol);
            ps.setInt(2, id);
            control = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return control;
    }
}
