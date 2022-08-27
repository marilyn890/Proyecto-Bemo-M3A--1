/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Abel Gomez
 */
public class GastodeCuenta {
    
    
    private Date gtc_fecha;
    private String gtc_nombreProducto;
    private int gtc_cantidad;
    private double gtc_totalGasto;

    public GastodeCuenta() {
   
        
    }

    public GastodeCuenta(Date gtc_fecha, String gtc_nombreProducto, int gtc_cantidad, double gtc_totalGasto) {
        this.gtc_fecha = gtc_fecha;
        this.gtc_nombreProducto = gtc_nombreProducto;
        this.gtc_cantidad = gtc_cantidad;
        this.gtc_totalGasto = gtc_totalGasto;
    }



    public Date getGtc_fecha() {
        return gtc_fecha;
    }

    public void setGtc_fecha(Date gtc_fecha) {
        this.gtc_fecha = gtc_fecha;
    }

    public String getGtc_nombreProducto() {
        return gtc_nombreProducto;
    }

    public void setGtc_nombreProducto(String gtc_nombreProducto) {
        this.gtc_nombreProducto = gtc_nombreProducto;
    }

    public int getGtc_cantidad() {
        return gtc_cantidad;
    }

    public void setGtc_cantidad(int gtc_cantidad) {
        this.gtc_cantidad = gtc_cantidad;
    }

    public double getGtc_totalGasto() {
        return gtc_totalGasto;
    }

    public void setGtc_totalGasto(double gtc_totalGasto) {
        this.gtc_totalGasto = gtc_totalGasto;
    }

    @Override
    public String toString() {
        return "GastodeCuenta{" + "gtc_fecha=" + gtc_fecha + ", gtc_nombreProducto=" + gtc_nombreProducto + ", gtc_cantidad=" + gtc_cantidad + ", gtc_totalGasto=" + gtc_totalGasto + '}';
    }
    
    
    
    
}
