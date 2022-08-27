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
public class Cotizacion_pastel {
    
    
    private String ctzp_nombreproducto;
    private int ctzp_cantidad;
    private String ctzp_descripcionextra;
    private double cztp_costoextra;
    private double cztp_totalcotizado;

    public Cotizacion_pastel() {
    }

    public Cotizacion_pastel(String ctzp_nombreproducto, int ctzp_cantidad, String ctzp_descripcionextra, double cztp_costoextra, double cztp_totalcotizado) {
        this.ctzp_nombreproducto = ctzp_nombreproducto;
        this.ctzp_cantidad = ctzp_cantidad;
        this.ctzp_descripcionextra = ctzp_descripcionextra;
        this.cztp_costoextra = cztp_costoextra;
        this.cztp_totalcotizado = cztp_totalcotizado;
    }

    public String getCtzp_nombreproducto() {
        return ctzp_nombreproducto;
    }

    public void setCtzp_nombreproducto(String ctzp_nombreproducto) {
        this.ctzp_nombreproducto = ctzp_nombreproducto;
    }

    public int getCtzp_cantidad() {
        return ctzp_cantidad;
    }

    public void setCtzp_cantidad(int ctzp_cantidad) {
        this.ctzp_cantidad = ctzp_cantidad;
    }

    public String getCtzp_descripcionextra() {
        return ctzp_descripcionextra;
    }

    public void setCtzp_descripcionextra(String ctzp_descripcionextra) {
        this.ctzp_descripcionextra = ctzp_descripcionextra;
    }

    public double getCztp_costoextra() {
        return cztp_costoextra;
    }

    public void setCztp_costoextra(double cztp_costoextra) {
        this.cztp_costoextra = cztp_costoextra;
    }

    public double getCztp_totalcotizado() {
        return cztp_totalcotizado;
    }

    public void setCztp_totalcotizado(double cztp_totalcotizado) {
        this.cztp_totalcotizado = cztp_totalcotizado;
    }
    
    
    
}
