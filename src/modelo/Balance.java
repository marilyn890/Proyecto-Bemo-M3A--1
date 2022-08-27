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
public class Balance {

    private int blc_ID;
    private Date blc_fechafacturaV;
    private Date blc_fechafacturaG;
    private double blc_totalcompras;
    private double blc_totalventas;
    private double blc_total;

    public Balance() {     
    }

    public Balance(int blc_ID, Date blc_fechafacturaV, Date blc_fechafacturaG, double blc_totalcompras, double blc_totalventas, double blc_total) {
        this.blc_ID = blc_ID;
        this.blc_fechafacturaV = blc_fechafacturaV;
        this.blc_fechafacturaG = blc_fechafacturaG;
        this.blc_totalcompras = blc_totalcompras;
        this.blc_totalventas = blc_totalventas;
        this.blc_total = blc_total;
    }

    public int getBlc_ID() {
        return blc_ID;
    }

    public void setBlc_ID(int blc_ID) {
        this.blc_ID = blc_ID;
    }

    public Date getBlc_fechafacturaV() {
        return blc_fechafacturaV;
    }

    public void setBlc_fechafacturaV(Date blc_fechafacturaV) {
        this.blc_fechafacturaV = blc_fechafacturaV;
    }

    public Date getBlc_fechafacturaG() {
        return blc_fechafacturaG;
    }

    public void setBlc_fechafacturaG(Date blc_fechafacturaG) {
        this.blc_fechafacturaG = blc_fechafacturaG;
    }

    public double getBlc_totalcompras() {
        return blc_totalcompras;
    }

    public void setBlc_totalcompras(double blc_totalcompras) {
        this.blc_totalcompras = blc_totalcompras;
    }

    public double getBlc_totalventas() {
        return blc_totalventas;
    }

    public void setBlc_totalventas(double blc_totalventas) {
        this.blc_totalventas = blc_totalventas;
    }

    public double getBlc_total() {
        return blc_total;
    }

    public void setBlc_total(double blc_total) {
        this.blc_total = blc_total;
    }
    
    
    
}
