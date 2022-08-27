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
public class Categoria {
    
    private int ctg_ID;
    private String ctg_nombre;

    public Categoria() {
    }

    

    public Categoria(int ctg_ID, String ctg_nombre) {
        this.ctg_ID = ctg_ID;
        this.ctg_nombre = ctg_nombre;
    }

    public int getCtg_ID() {
        return ctg_ID;
    }

    public void setCtg_ID(int ctg_ID) {
        this.ctg_ID = ctg_ID;
    }

    public String getCtg_nombre() {
        return ctg_nombre;
    }

    public void setCtg_nombre(String ctg_nombre) {
        this.ctg_nombre = ctg_nombre;
    }
    
    
    
}
