/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apphotel;

import java.io.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Usuario implements Serializable{

    private String nombre;
    private String telefono;
    private String identificacion;
    private int idUsuario;
    private Producto habitacion = null;
    private Parqueadero parqueadero = null;
    public Usuario(String nombre, String telefono, String identificacion, int idUsuario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Producto getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Producto habitacion) {
        this.habitacion = habitacion;
    }

  

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public void mostrarUsuario() {
        System.out.println("ID USUARIO: " + idUsuario);
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificacion: " + identificacion);
        System.out.println("Telefono: " + telefono);
    }
}
