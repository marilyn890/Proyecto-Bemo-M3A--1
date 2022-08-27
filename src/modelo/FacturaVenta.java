/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Abel Gomez
 */
public class FacturaVenta extends Factura{
    
    
    private String fctV_nombreCliente;
    private String fctY_nombreProducto;
    private String fctY_detalleExtra;
    private double fctV_extra;

    public String getFctV_nombreCliente() {
        return fctV_nombreCliente;
    }

    public void setFctV_nombreCliente(String fctV_nombreCliente) {
        this.fctV_nombreCliente = fctV_nombreCliente;
    }

    public String getFctY_nombreProducto() {
        return fctY_nombreProducto;
    }

    public void setFctY_nombreProducto(String fctY_nombreProducto) {
        this.fctY_nombreProducto = fctY_nombreProducto;
    }

    public String getFctY_detalleExtra() {
        return fctY_detalleExtra;
    }

    public void setFctY_detalleExtra(String fctY_detalleExtra) {
        this.fctY_detalleExtra = fctY_detalleExtra;
    }

    public double getFctV_extra() {
        return fctV_extra;
    }

    public void setFctV_extra(double fctV_extra) {
        this.fctV_extra = fctV_extra;
    }

    @Override
    public String toString() {
        return "FacturaVenta{" + "fctV_nombreCliente=" + fctV_nombreCliente + ", fctY_nombreProducto=" + fctY_nombreProducto + ", fctY_detalleExtra=" + fctY_detalleExtra + ", fctV_extra=" + fctV_extra + '}';
    }
    
    
    
    
    
}
