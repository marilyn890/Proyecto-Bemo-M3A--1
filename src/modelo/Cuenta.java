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
public class Cuenta {
    private int cnt_ID;
    private String cnt_nombreCliente;
    private String cnt_cuentaAbono;
    private double cnt_gasto;
    private double cnt_sueldo;

    public Cuenta() {
    }

    public Cuenta(int cnt_ID, String cnt_nombreCliente, String cnt_cuentaAbono, double cnt_gasto, double cnt_sueldo) {
        this.cnt_ID = cnt_ID;
        this.cnt_nombreCliente = cnt_nombreCliente;
        this.cnt_cuentaAbono = cnt_cuentaAbono;
        this.cnt_gasto = cnt_gasto;
        this.cnt_sueldo = cnt_sueldo;
    }

    public int getCnt_ID() {
        return cnt_ID;
    }

    public void setCnt_ID(int cnt_ID) {
        this.cnt_ID = cnt_ID;
    }

    public String getCnt_nombreCliente() {
        return cnt_nombreCliente;
    }

    public void setCnt_nombreCliente(String cnt_nombreCliente) {
        this.cnt_nombreCliente = cnt_nombreCliente;
    }

    public String getCnt_cuentaAbono() {
        return cnt_cuentaAbono;
    }

    public void setCnt_cuentaAbono(String cnt_cuentaAbono) {
        this.cnt_cuentaAbono = cnt_cuentaAbono;
    }

    public double getCnt_gasto() {
        return cnt_gasto;
    }

    public void setCnt_gasto(double cnt_gasto) {
        this.cnt_gasto = cnt_gasto;
    }

    public double getCnt_sueldo() {
        return cnt_sueldo;
    }

    public void setCnt_sueldo(double cnt_sueldo) {
        this.cnt_sueldo = cnt_sueldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cnt_ID=" + cnt_ID + ", cnt_nombreCliente=" + cnt_nombreCliente + ", cnt_cuentaAbono=" + cnt_cuentaAbono + ", cnt_gasto=" + cnt_gasto + ", cnt_sueldo=" + cnt_sueldo + '}';
    }
    
    
    
    
    
    
    
}
