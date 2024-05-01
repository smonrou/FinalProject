/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataClass;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author CRISTOPHER
 */
public class Libro implements Serializable {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String autor;
    private Date fechaPublicacion;
    private String editorial;
    private String portada;
    private int existencias;
    private String genero;
    private int visitas;

    public Libro(int id, String titulo, String descripcion, String autor, Date fechaPublicacion, String editorial, String portada, int existencias, String genero, int visitas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.portada = portada;
        this.existencias = existencias;
        this.genero = genero;
        this.visitas = visitas;
    }

    public Libro(String titulo, String descripcion, String autor, Date fechaPublicacion, String editorial, String portada, int existencias, String genero, int visitas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.portada = portada;
        this.existencias = existencias;
        this.genero = genero;
        this.visitas = visitas;
    }

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", autor=" + autor + ", fechaPublicacion=" + fechaPublicacion + ", editorial=" + editorial + ", portada=" + portada + ", existencias=" + existencias + ", genero=" + genero + ", visitas=" + visitas + '}';
    }
    
    
}
