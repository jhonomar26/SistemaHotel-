/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apphotel;

import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HabitacionesVIP extends Habitacion{
private ArrayList<Producto> habitacionesVIP;

   public HabitacionesVIP(String nombre, int IDservicios) {
        super(nombre, IDservicios);
        habitacionesVIP=new ArrayList();
    }
   public void agregarProducto(String nombre,double precio, int cantPersonas){
       if (habitacionesVIP.size() > 0) {
            int idSiguiente = habitacionesVIP.get(habitacionesVIP.size() - 1).getIDProducto() + 1;
            habitacionesVIP.add(new Producto(nombre,idSiguiente,precio,cantPersonas));
        } else {
             habitacionesVIP.add(new Producto(nombre,1,precio,cantPersonas));
        }
   }
   public void eliminarProducto(int posProducto){
       habitacionesVIP.remove(posProducto);
   }
   public int posProducto(int id){
       int b = 0;
        int posHabitacionVIP= -1;
        for (int i = 0; i < habitacionesVIP.size() && b == 0; i++) {
            if (habitacionesVIP.get(i).getIDProducto()==id){
                b = 1;
                posHabitacionVIP= i;
                
            }
        }
        return posHabitacionVIP;
        
   }
   public void mostrarInf() {
        super.mostrarInf();
        for (int i = 0; i < habitacionesVIP.size(); i++) {
            habitacionesVIP.get(i).mostrarIdentificaciones();
            habitacionesVIP.get(i).mostrarProducto();
            if(habitacionesVIP.get(i).totalIdentificaciones()==0){
                System.out.println("Habitacion desocupada. ");
            }else{
                System.out.println("Habitacion ocupada.");
            }
            System.out.println("-------------------------------------------");
        }
    }
public Producto buscarProducto(int id){
       int b = 0;
       Producto habitacionVIP= null;
        for (int i = 0; i < habitacionesVIP.size() && b == 0; i++) {
            if (habitacionesVIP.get(i).getIDProducto()==id){
                b = 1;
                habitacionVIP=habitacionesVIP.get(i);
            }
        }
        return habitacionVIP;
   }
}
