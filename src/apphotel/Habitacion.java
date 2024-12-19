/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apphotel;

import java.io.*;
import java.util.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Habitacion extends Servicio{

    private ArrayList<Producto> habitaciones;
    int cantPersonas;

    public Habitacion(String nombre, int IDservicios) {
        super(nombre, IDservicios);
        this.habitaciones = new ArrayList();
    }
    public void mostrarInf() {
        super.mostrarInf();
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < habitaciones.size(); i++) {
            habitaciones.get(i).mostrarIdentificaciones();
            habitaciones.get(i).mostrarProducto();
            if(habitaciones.get(i).totalIdentificaciones()==0){
                System.out.println("Habitacion desocupada. ");
            }else{
                System.out.println("Habitacion ocupada.");
            }
        }
    }
    public void agregarProducto(String nombre,double precio, int cantPersonas){
       if (habitaciones.size() > 0) {
            int idSiguiente = habitaciones.get(habitaciones.size() - 1).getIDProducto() + 1;
            habitaciones.add(new Producto(nombre,idSiguiente,precio,cantPersonas));
        } else {
             habitaciones.add(new Producto(nombre,1,precio,cantPersonas));
        }
   }
   public void eliminarProducto(int posProducto){
       habitaciones.remove(posProducto);
   }
   public int posProducto(int id){
       int b = 0;
        int posHabitacion= -1;
        for (int i = 0; i < habitaciones.size() && b == 0; i++) {
            if (habitaciones.get(i).getIDProducto()==id){
                b = 1;
                posHabitacion= i;
                
            }
        }
        return posHabitacion;
   }
   public Producto buscarProducto(int id){
       int b = 0;
       Producto habitacion= null;
        for (int i = 0; i < habitaciones.size() && b == 0; i++) {
            if (habitaciones.get(i).getIDProducto()==id){
                b = 1;
                habitacion=habitaciones.get(i);
            }
        }
        return habitacion;
   }
    public ArrayList<Producto> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(ArrayList<Producto> habitaciones) {
        this.habitaciones = habitaciones;
    }
   
   
}
