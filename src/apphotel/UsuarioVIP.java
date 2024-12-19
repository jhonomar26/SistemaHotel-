/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apphotel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UsuarioVIP extends Usuario {

    private Membresia membresia=null;

    public UsuarioVIP(String nombre, String telefono, String identificacion, int idUsuario, Membresia membresia) {
        super(nombre, telefono, identificacion, idUsuario);
        this.membresia=membresia;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    public void mostrarUsuario() {
     System.out.println("**USUARIO VIP**");
       this.mostrarUsuario();
    }    

}
