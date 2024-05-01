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
public class Usuario implements Serializable {
    
    private int id;
    private String username;
    private String nombre;
    private String email;
    private String pass;
    private String telefono;
    private String rol;
    private String foto;

    public Usuario(int id, String username, String nombre, String email, String pass, String telefono, String rol, String foto) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.telefono = telefono;
        this.rol = rol;
        this.foto = foto;
    }

    public Usuario() {
    }

    public Usuario(String username, String nombre, String email, String pass, String telefono, String rol, String foto) {
        this.username = username;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.telefono = telefono;
        this.rol = rol;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email + ", pass=" + pass + ", telefono=" + telefono + ", rol=" + rol + ", foto=" + foto + '}';
    }
    
    
    
           
}
