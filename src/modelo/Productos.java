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
public class Productos {

    private int prd_ID;
    private String prd_nombre;
    private double prd_precio;
    private String prd_nombreCategoria;
    private int prd_IDCategoria;
    public Productos() {
    }

    public Productos(int prd_ID, String prd_nombre, double prd_precio, String prd_nombreCategoria, int prd_IDCategoria) {
        this.prd_ID = prd_ID;
        this.prd_nombre = prd_nombre;
        this.prd_precio = prd_precio;
        this.prd_nombreCategoria = prd_nombreCategoria;
        this.prd_IDCategoria = prd_IDCategoria;
    }

    
    
    
    public int getPrd_ID() {
        return prd_ID;
    }

    public void setPrd_ID(int prd_ID) {
        this.prd_ID = prd_ID;
    }

    public String getPrd_nombre() {
        return prd_nombre;
    }

    public void setPrd_nombre(String prd_nombre) {
        this.prd_nombre = prd_nombre;
    }

    public double getPrd_precio() {
        return prd_precio;
    }

    public void setPrd_precio(double prd_precio) {
        this.prd_precio = prd_precio;
    }

    public String getPrd_nombreCategoria() {
        return prd_nombreCategoria;
    }

    public void setPrd_nombreCategoria(String prd_nombreCategoria) {
        this.prd_nombreCategoria = prd_nombreCategoria;
    }

    public int getPrd_IDCategoria() {
        return prd_IDCategoria;
    }

    public void setPrd_IDCategoria(int prd_IDCategoria) {
        this.prd_IDCategoria = prd_IDCategoria;
    }



    @Override
    public String toString() {
        return "Productos{" + "prd_ID=" + prd_ID + ", prd_nombre=" + prd_nombre + ", prd_precio=" + prd_precio + ", prd_nombreCategoria=" + prd_nombreCategoria + '}';
    }
    
    
    

}
