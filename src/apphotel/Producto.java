/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apphotel;

import java.util.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
class Producto {

    private String nombre;
    private int IDProducto;
    private double precio;
    private ArrayList<String> identificaciones;
    private int cantPersonas;

    public Producto(String nombre, int IDProducto, double precio, int cantPersonas) {
        this.nombre = nombre;
        this.IDProducto = IDProducto;
        this.precio = precio;
        this.identificaciones = new ArrayList();
        this.cantPersonas = cantPersonas;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: "+IDProducto);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad que pueden ocupar: "+cantPersonas);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIDProducto() {
        return IDProducto;
    }
    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void mostrarIdentificaciones() {
        System.out.println("Identificaciones: " + identificaciones.size());

        for (int i = 0; i < identificaciones.size(); i++) {
            System.out.println(identificaciones.get(i));
        }

    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public int totalIdentificaciones(){
    return identificaciones.size();
}
    public ArrayList<String> getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(ArrayList<String> identificaciones) {
        this.identificaciones = identificaciones;
    }

}
