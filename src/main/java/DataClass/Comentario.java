
package DataClass;

import java.io.Serializable;

/**
 *
 * @author CRISTOPHER
 */
public class Comentario implements Serializable{
    private int id, id_usuario;
    private String nombre;
    private int idPublicacion;
    private String fecha, contenido;

    public Comentario(int id, int id_usuario, String nombre, int idPublicacion, String fecha, String contenido) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.idPublicacion = idPublicacion;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public Comentario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", id_usuario=" + id_usuario + ", nombre=" + nombre + ", idPublicacion=" + idPublicacion + ", fecha=" + fecha + ", contenido=" + contenido + '}';
    }
   
    
}
