/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apphotel;

import java.io.Serializable;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
class Membresia implements Serializable{
private int diaInicio;
private int mesInicio;
private int yearInicio;
private int diaFin;
private int mesFin;
private int yearFin;
private  double  Descuento;

    public Membresia(int diaInicio, int mesInicio, int yearInicio, int diaFin, int mesFin, int yearFin, double Descuento) {
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.yearInicio = yearInicio;
        this.diaFin = diaFin;
        this.mesFin = mesFin;
        this.yearFin = yearFin;
        this.Descuento = Descuento;
    }
   
    
    
    
    


}
