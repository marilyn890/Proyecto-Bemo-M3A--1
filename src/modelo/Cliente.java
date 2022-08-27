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
public class Cliente extends Persona {

    private int cl_ID;

    public Cliente(int cl_ID) {
        this.cl_ID = cl_ID;
    }

    public Cliente(int cl_ID, int prs_ID, String prs_cedula, String prs_nombre1, String prs_nombre2, String prs_apellido1, String prs_apellido2, String prs_direccion, String prs_telefono, String prs_email) {
        super(prs_ID, prs_cedula, prs_nombre1, prs_nombre2, prs_apellido1, prs_apellido2, prs_direccion, prs_telefono, prs_email);
        this.cl_ID = cl_ID;
    }

    public Cliente() {
        super();
    }

    public int getCl_ID() {
        return cl_ID;
    }

    public void setCl_ID(int cl_ID) {
        this.cl_ID = cl_ID;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cl_ID=" + cl_ID + '}';
    }

}
