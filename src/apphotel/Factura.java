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
public class Factura implements Serializable{
private ArrayList<Producto> itemsCompras;
private boolean estado;
private String identificacion;
private int numero;
private double precio;

    public Factura(String identificacion, int numero,Producto producto) {
        this.itemsCompras = new ArrayList();
        itemsCompras.add(producto);
        this.estado = false;
        this.identificacion = identificacion;
        this.numero = numero;
        this.precio = 0;
    }

    public ArrayList<Producto> getItemsCompras() {
        return itemsCompras;
    }

    public void setItemsCompras(ArrayList<Producto> itemsCompras) {
        this.itemsCompras = itemsCompras;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
         for (int i = 0; i < itemsCompras.size(); i++) {
            precio+=itemsCompras.get(i).getPrecio();
        }
       return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void mostrarFactura(){
        System.out.println("Factura numero: "+numero);
        System.out.println("Identificacion: "+identificacion);
        for (int i = 0; i < itemsCompras.size(); i++) {
            System.out.println("Nombre: "+itemsCompras.get(i).getNombre());
            System.out.println("Precio: "+itemsCompras.get(i).getPrecio());
            precio+=itemsCompras.get(i).getPrecio();
            System.out.println("-----------------------------------------------------------");
        }
        System.out.println("Precio a cancelar en caja: "+precio);
        if (estado==true) {
            System.out.println("La factura ya ha sido cancelada.");
        }else{
            System.out.println("La factura aun no se ha cancelado. ");
        }
        
    }
    public void pagarFactura(){
        estado=true;
    }
    
}
