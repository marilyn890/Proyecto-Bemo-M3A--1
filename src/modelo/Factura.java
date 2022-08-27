/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Abel Gomez
 */
public class Factura {
    
    private int fct_ID;
    private double fct_subtotal;
    private double fct_total;
    private Date fct_fecha;
    private int fct_cantidad;
    private double fct_precio;

    public Factura() {
    }

    
    

    public Factura(int fct_ID, double fct_subtotal, double fct_total, Date fct_fecha, int fct_cantidad, double fct_precio) {
        this.fct_ID = fct_ID;
        this.fct_subtotal = fct_subtotal;
        this.fct_total = fct_total;
        this.fct_fecha = fct_fecha;
        this.fct_cantidad = fct_cantidad;
        this.fct_precio = fct_precio;
    }

    public int getFct_ID() {
        return fct_ID;
    }

    public void setFct_ID(int fct_ID) {
        this.fct_ID = fct_ID;
    }

    public double getFct_subtotal() {
        return fct_subtotal;
    }

    public void setFct_subtotal(double fct_subtotal) {
        this.fct_subtotal = fct_subtotal;
    }

    public double getFct_total() {
        return fct_total;
    }

    public void setFct_total(double fct_total) {
        this.fct_total = fct_total;
    }

    public Date getFct_fecha() {
        return fct_fecha;
    }

    public void setFct_fecha(Date fct_fecha) {
        this.fct_fecha = fct_fecha;
    }

    public int getFct_cantidad() {
        return fct_cantidad;
    }

    public void setFct_cantidad(int fct_cantidad) {
        this.fct_cantidad = fct_cantidad;
    }

    public double getFct_precio() {
        return fct_precio;
    }

    public void setFct_precio(double fct_precio) {
        this.fct_precio = fct_precio;
    }

    @Override
    public String toString() {
        return "Factura{" + "fct_ID=" + fct_ID + ", fct_subtotal=" + fct_subtotal + ", fct_total=" + fct_total + ", fct_fecha=" + fct_fecha + ", fct_cantidad=" + fct_cantidad + ", fct_precio=" + fct_precio + '}';
    }
    
    
    
    
    
    
    
}
