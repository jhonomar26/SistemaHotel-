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
public class Restaurante extends Servicio{
private ArrayList<Producto> menu;

    public Restaurante(String nombre, int IDservicios) {
        super(nombre, IDservicios);
        menu=new ArrayList();
    }

}
