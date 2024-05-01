package DataClass;

/**
 *
 * @author USUARIO
 */
public class RegistroActividad {
    private int id, userID;
    private String nombre, rol, accion, fecha;

    public RegistroActividad(int id, int userID, String nombre, String rol, String accion, String fecha) {
        this.id = id;
        this.userID = userID;
        this.nombre = nombre;
        this.rol = rol;
        this.accion = accion;
        this.fecha = fecha;
    }

    public RegistroActividad(int id, int userID, String accion, String fecha) {
        this.id = id;
        this.userID = userID;
        this.accion = accion;
        this.fecha = fecha;
    }

    public RegistroActividad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RegistroActividad{" + "id=" + id + ", userID=" + userID + ", nombre=" + nombre + ", rol=" + rol + ", accion=" + accion + ", fecha=" + fecha + '}';
    }
    
}
