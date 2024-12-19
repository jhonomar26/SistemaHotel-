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
public class Reserva implements Serializable{
    Scanner Leer=new Scanner(System.in);
    private ArrayList<String>identificaciones;
    private int idReserva;
    private Producto productoReservado=null;
    public Reserva(int idReserva, Producto producto) {
        this.idReserva=idReserva;
        productoReservado=producto;
        String identificacion;
        identificaciones=new ArrayList<String>();
        for (int i = 0; i <productoReservado.getCantPersonas(); i++) {
            Leer.nextLine();
            System.out.println("Digite la identificacion de la persona "+(i+1));
            identificacion=Leer.nextLine();
            identificaciones.add(identificacion);
        }
        productoReservado.setIdentificaciones(identificaciones);
    }
    public ArrayList<String> getIdentificaciones() {
        return identificaciones;
    }
    public void setIdentificaciones(ArrayList<String> identificaciones) {
        this.identificaciones = identificaciones;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Producto getProductoReservado() {
        return productoReservado;
    }

    public void setProductoReservado(Producto productoReservado) {
        this.productoReservado = productoReservado;
    }

   public void mostrarReserva(){
       productoReservado.mostrarProducto();
       System.out.println("ID: "+idReserva);
   }
    
   public void modificarReserva(ArrayList<String> identificaciones){
       identificaciones=identificaciones;
       productoReservado.setIdentificaciones(identificaciones);
   }
   public Producto buscarIdentificacion(String identificacion){
   int b=0;
   Producto productoBuscado=null;
       for (int i = 0; i < identificaciones.size()&&b==0; i++) {
           if (identificaciones.get(i).equalsIgnoreCase(identificacion)) {
               productoBuscado=productoReservado;
               b=1;
           }   
       }
       return productoBuscado;
   }
   
   
   
   
}
