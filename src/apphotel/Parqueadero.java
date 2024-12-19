/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apphotel;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Parqueadero extends Servicio{
ArrayList<Producto> parqueaderos;

    public Parqueadero(String nombre, int IDservicios) {
        super(nombre, IDservicios);
        parqueaderos=new ArrayList();
    }
    
    
}
