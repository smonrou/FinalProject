/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataClass;

import java.io.Serializable;

/**
 *
 * @author CRISTOPHER
 */
public class Comentario implements Serializable{
    
    private int id;
    private int usuario;
    private String fecha;
    private String contenido;
    private int likes;

    public Comentario(int id, int usuario, String fecha, String contenido, int likes) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.likes = likes;
    }

    public Comentario(int usuario, String fecha, String contenido, int likes) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.likes = likes;
    }

    public Comentario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", contenido=" + contenido + ", likes=" + likes + '}';
    }
    
    
    
    
}
