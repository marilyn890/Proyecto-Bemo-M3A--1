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
public class Proveedor  extends Persona{
    private int prv_ID;
    private String prv_empresa;

    public Proveedor() {
        super();
    }

    public Proveedor(int prv_ID, String prv_empresa) {
        this.prv_ID = prv_ID;
        this.prv_empresa = prv_empresa;
    }

    public Proveedor(int prv_ID, String prv_empresa, int prs_ID, String prs_cedula, String prs_nombre1, String prs_nombre2, String prs_apellido1, String prs_apellido2, String prs_direccion, String prs_telefono, String prs_email) {
        super(prs_ID, prs_cedula, prs_nombre1, prs_nombre2, prs_apellido1, prs_apellido2, prs_direccion, prs_telefono, prs_email);
        this.prv_ID = prv_ID;
        this.prv_empresa = prv_empresa;
    }

    public int getPrv_ID() {
        return prv_ID;
    }

    public void setPrv_ID(int prv_ID) {
        this.prv_ID = prv_ID;
    }

    public String getPrv_empresa() {
        return prv_empresa;
    }

    public void setPrv_empresa(String prv_empresa) {
        this.prv_empresa = prv_empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "prv_ID=" + prv_ID + ", prv_empresa=" + prv_empresa + '}';
    }
    
    
    
    
}
