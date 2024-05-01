/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataClass;

/**
 *
 * @author CRISTOPHER
 */
public class Evento {
    private int id;
    private String nombre, descripcion, detalles, temas, fechaVigencia, portada;
    private int visitas;

    public Evento(int id, String nombre, String descripcion, String detalles, String temas, String fechaVigencia, String portada, int visitas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.temas = temas;
        this.fechaVigencia = fechaVigencia;
        this.portada = portada;
        this.visitas = visitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", detalles=" + detalles + ", temas=" + temas + ", fechaVigencia=" + fechaVigencia + ", portada=" + portada + ", visitas=" + visitas + '}';
    }
    
}
