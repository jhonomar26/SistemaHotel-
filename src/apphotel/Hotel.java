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
public class Hotel implements Serializable{

    private double valorCaja;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Servicio> servicios;
    private ArrayList<Reserva> reservas;
    private ArrayList<Factura> facturas;
    private ArrayList<Servicio> serviciosVIP;
    
    public Hotel() {
        this.valorCaja = 0;
        this.usuarios = new ArrayList();
        servicios=new ArrayList();
        serviciosVIP=new ArrayList();
        servicios.add(0,new Habitacion("Habitaciones", 1));
        servicios.add(1,new Parqueadero("Parqueadero", 2));
        servicios.add(2,new Restaurante("Restaurante", 3));
        servicios.add(3,new Bar("Bar", 4));
        this.reservas = new ArrayList();
        this.facturas = new ArrayList();
        serviciosVIP.add(0,new HabitacionesVIP("Habitaciones VIP", 4));
        serviciosVIP.add(1,new Parqueadero("Restaurante VIP", 5));
    }

    //Usuario
    public Usuario buscarUsuario(String identificacion) {
        int b = 0;
        Usuario usuario = null;
        for (int i = 0; i < usuarios.size() && b == 0; i++) {
            if (usuarios.get(i).getIdentificacion().equalsIgnoreCase(identificacion)) {
                b = 1;
                usuario = usuarios.get(i);
                
            }
        }
        return usuario;
    }

    public int posUsuario(String identificacion) {
        int b = 0;
        int posUsuario = -1;
        for (int i = 0; i < usuarios.size() && b == 0; i++) {
            if (usuarios.get(i).getIdentificacion().equalsIgnoreCase(identificacion)) {
                b = 1;
                posUsuario = i;
                
            }
        }
        return posUsuario;
    }

    public void registrarUsuario(String nombre, String telefono, String identificacion) {
        if (usuarios.size() > 0) {
            int idSiguiente = usuarios.get(usuarios.size() - 1).getIdUsuario() + 1;
            usuarios.add(new Usuario(nombre, telefono, identificacion, idSiguiente));
        } else {
            usuarios.add(new Usuario(nombre, telefono, identificacion, 1));
        }
        
    }

    public void eliminarUsuario(int posUsuario) {
        usuarios.remove(posUsuario);
    }

    public void adquirirMembresia(Membresia membresia, int posUsuario) {
        Usuario nuevoUsuarioVIP = usuarios.get(posUsuario);
        usuarios.add(posUsuario, new UsuarioVIP(nuevoUsuarioVIP.getNombre(), nuevoUsuarioVIP.getTelefono(), nuevoUsuarioVIP.getIdentificacion(), nuevoUsuarioVIP.getIdUsuario(), membresia));
    }

    public void mostrarUsuarios() {
        System.out.println("USUARIOS REGISTRADOS: " + usuarios.size());
        for (int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).mostrarUsuario();
            System.out.println("-----------------------------------------");
        }
    }
    //Servicio
    //Habitaciones.
    public void agregarHabitacion(String nombre, double precio,int cantPersonas){
        servicios.get(0).agregarProducto(nombre, precio,cantPersonas);
    }
    public void mostrarServicios() {
        System.out.println("SERVICIOS: "+servicios.size());
        for (int i = 0; i < servicios.size(); i++) {
            servicios.get(i).mostrarInf();
            System.out.println("---------------------------");
        }
    }
    public void mostrarHabitaciones() {
       servicios.get(0).mostrarInf();
   }
    public void eliminarHabitacion(int id){
        int posHabitacion=servicios.get(0).posProducto(id);
        if (posHabitacion!=-1) {
            servicios.get(0).eliminarProducto(posHabitacion);
        }else{
            System.out.println("ID invalido.");
        }
    }
    public void agregarHabitacionVIP(String nombre, double precio, int cantPersonas){
       serviciosVIP.get(0).agregarProducto(nombre, precio,cantPersonas);
    }
    public void eliminarHabitacionVIP(int id){
        int posHabitacion=serviciosVIP.get(0).posProducto(id);
        if (posHabitacion!=-1) {
            serviciosVIP.get(0).eliminarProducto(posHabitacion);
        }else{
            System.out.println("ID invalido.");
        }
    }
    public void mostrarHabitacionesVIP() {
       serviciosVIP.get(0).mostrarInf();
   }
    public void mostrarHabitacionesTotales(){
        servicios.get(0).mostrarInf();
        System.out.println("TIPO 2 DE HABITACIONES \n");
        serviciosVIP.get(0).mostrarInf();
    }
    public Producto buscarHabitacion(int idProducto){
        return servicios.get(0).buscarProducto(idProducto);
    }
    public Producto buscarHabitacionVIP(int idProducto){
        return serviciosVIP.get(0).buscarProducto(idProducto);
    }
    //Reserva
    public void reservarHabitacionNormal(Producto habitacion){
         if (reservas.size() > 0) {
            int idSiguiente = reservas.get(reservas.size() - 1).getIdReserva() + 1;
             reservas.add(new Reserva(idSiguiente,habitacion));
        } else {
              reservas.add(new Reserva(1,habitacion));
        }
       
    }
    public void reservarHabitacionVIP(Producto habitacionVIP){
         if (reservas.size() > 0) {
            int idSiguiente = reservas.get(reservas.size() - 1).getIdReserva() + 1;
             reservas.add(new Reserva(idSiguiente,habitacionVIP));
        } else {
              reservas.add(new Reserva(1,habitacionVIP));
        }
       
    }
    public void mostrarHabitacionesLibres(){
    }
    public void mostrarReservas(){
        for (int i = 0;i<reservas.size(); i++) {
            reservas.get(i).mostrarReserva();
            System.out.println("-------------------------------------------------");
        }
    }
    public Reserva buscarReserva(int id){
        Reserva reserva=null;
        int b=0;
        for (int i = 0; i <reservas.size()&&b==0; i++) {
            if (reservas.get(i).getIdReserva()==id) {
                b=1;
                reserva=reservas.get(i);
            }
            
        }
        return reserva;  
    }
    public int posReserva(int id){
        int posReserva=-1;
        int b=0;
        for (int i = 0; i <reservas.size()&&b==0; i++) {
            if (reservas.get(i).getIdReserva()==id) {
                b=1;
                posReserva=i;
            }
            
        }
        return posReserva;  
    }
    public void eliminarReserva(int posReserva){
        reservas.remove(posReserva);
    }
     public Producto buscarReserva(String identificacion){
        String identificacionbuscada=null;
        int b=0;
        Producto productoReservado=null;
        for (int i = 0; i <reservas.size()&&b==0; i++) {
           productoReservado=reservas.get(i).buscarIdentificacion(identificacion);
            if (productoReservado!=null) {
                b=1;
            }
        }
        if(b==1){
            return productoReservado;
        }else{
            return null;
        }
    }
     
     //manejo contable
     public void hacerFactura(String identificacion, Producto producto){
         if (facturas.size() > 0) {
            int numeroSiguiente = facturas.get(facturas.size() - 1).getNumero() + 1;
             facturas.add(new Factura(identificacion,numeroSiguiente,producto));
        } else {
              facturas.add(new Factura(identificacion,1,producto));
        }
     }
     public Factura consultarFactura(String identificacion){
         Factura facturaBuscada=null;
         int b=0;
         for (int i = 0; i < facturas.size()&&b==0; i++) {
             if (facturas.get(i).getIdentificacion().equalsIgnoreCase(identificacion)) {
                 facturaBuscada=facturas.get(i);
                 b=1;
             }
         }
         return facturaBuscada;
     }
     public void cancelarFactura(double  dinero){
         valorCaja+=dinero;
     }
     public void manejoContable(){
         System.out.println("Dinerjo en caja: "+valorCaja);
         System.out.println("Facturas totales: "+facturas.size());
         for (int i = 0; i < facturas.size(); i++) {
             facturas.get(i).mostrarFactura();
             System.out.println("----------------------------------------------------");
         }
     }
     public void eliminarFactura(int nro){
        facturas.remove(nro-1);
    }
}
