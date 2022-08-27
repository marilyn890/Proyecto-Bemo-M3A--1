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
public class FacturaGastoCorriente extends Factura{
    
    private String fctG_descripccion;

    public FacturaGastoCorriente() {
        super();
    }

    public FacturaGastoCorriente(String fctG_descripccion) {
        this.fctG_descripccion = fctG_descripccion;
    }

    public FacturaGastoCorriente(String fctG_descripccion, int fct_ID, double fct_subtotal, double fct_total, Date fct_fecha, int fct_cantidad, double fct_precio) {
        super(fct_ID, fct_subtotal, fct_total, fct_fecha, fct_cantidad, fct_precio);
        this.fctG_descripccion = fctG_descripccion;
    }

    public String getFctG_descripccion() {
        return fctG_descripccion;
    }

    public void setFctG_descripccion(String fctG_descripccion) {
        this.fctG_descripccion = fctG_descripccion;
    }
    
    
    
    
    
    
}
