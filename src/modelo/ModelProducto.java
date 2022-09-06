/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abel Gomez
 */
public class ModelProducto extends Productos {

    OCconection conn = new OCconection();

    public ModelProducto() {
    }

    public ModelProducto(int prd_ID, String prd_nombre, double prd_precio, String prd_nombreCategoria) {
        super(prd_ID, prd_nombre, prd_precio, prd_nombreCategoria);
    }

    public List<Productos> getproductos() {
        conn.OCconection();

        List<Productos> listaProductos = new ArrayList<>();
        String sql = "select * from productos";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setPrd_ID(rs.getInt(1));
                producto.setPrd_nombre(rs.getString(2));
                producto.setPrd_precio(rs.getDouble(3));
                producto.setPrd_nombreCategoria(rs.getString(4));

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }
}
