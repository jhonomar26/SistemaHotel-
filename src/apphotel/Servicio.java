/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apphotel;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
class Servicio implements Serializable{
    private String nombre;
    private int IDservicio;
    private ArrayList<Producto> productos;

    public Servicio(String nombre, int IDservicios) {
        this.nombre = nombre;
        this.IDservicio = IDservicios;
        this.productos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIDservicio() {
        return IDservicio;
    }

    public void setIDservicio(int IDservicio) {
        this.IDservicio = IDservicio;
    }
    public void mostrarInf(){
        System.out.println("Nombre:  "+nombre);
        System.out.println("ID: "+IDservicio);
       
    }
public void agregarProducto(String nombre, double precio, int cantPersonas){
    
    if (productos.size() > 0) {
            int idSiguiente = productos.get(productos.size() - 1).getIDProducto() + 1;
            productos.add(new Producto(nombre,idSiguiente,precio,cantPersonas));
        } else {
             productos.add(new Producto(nombre,1,precio,cantPersonas));
        }
        
}
public void eliminarProducto(int posProducto){
}
public int posProducto(int producto){
        return -1;
}
 public Producto buscarProducto(int idProducto){
     return null;
 }   
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    

}
