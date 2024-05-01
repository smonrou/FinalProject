/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataClass;

/**
 *
 * @author CRISTOPHER
 */
public class Exposicion {
    private int id;
    private String nombre, descripcion, informacion, tema, portada;
    private int visitas;

    public Exposicion(int id, String nombre, String descripcion, String informacion, String tema, String portada, int visitas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.informacion = informacion;
        this.tema = tema;
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

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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
        return "Exposicion{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", informacion=" + informacion + ", tema=" + tema + ", portada=" + portada + ", visitas=" + visitas + '}';
    }
    
    
}
