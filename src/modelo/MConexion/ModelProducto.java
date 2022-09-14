/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Productos;

/**
 *
 * @author Abel Gomez
 */
public class ModelProducto extends modelo.Productos {

    modelo.OCconection conn = new modelo.OCconection();

    public ModelProducto() {
    }

    public ModelProducto(int prd_ID, String prd_nombre, double prd_precio, int prd_nombreCategoria) {
        super(prd_ID, prd_nombre, prd_precio, prd_nombreCategoria);
    }

    public List<Productos> getproductos() {

        List<Productos> listaProductos = new ArrayList<>();
        String sql = "select * from producto";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setPrd_ID(rs.getInt(1));
                producto.setPrd_nombre(rs.getString(2));
                producto.setPrd_precio(rs.getDouble(3));
                producto.setPrd_nombreCategoria(rs.getInt(4));

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

    public boolean setProducto() {
        String sql = "INSERT INTO producto (prod_id, prod_nombre, prod_precio, cate_id) "
                + "VALUES('" + getPrd_ID() + "', '" + getPrd_nombre() + "', '" + getPrd_precio() + "', '" + getPrd_nombreCategoria() + "')";
        return conn.accion(sql);
    }
    
    public boolean uptadeProducto() {
        String sql = "UPDATE producto SET prod_nombre='" + getPrd_nombre()+ "', "
                + "prod_precio='" + getPrd_precio()+ "', cate_id='" + getPrd_nombreCategoria()+"' WHERE prod_id='" + getPrd_ID()+ "'";
        return conn.accion(sql);
    }
    
    public boolean deleteProducto() {
        String sql = "DELETE FROM producto where prod_id='" + getPrd_ID()+ "'";
        return conn.accion(sql);
    }
    
    public boolean buscarProductos() {
        String sql = "select prod_id, prod_nombre, prod_precio, cate_id from producto "
                + "where prod_id like '" + getPrd_ID()+ "%' OR lower(prod_nombre) like'" + getPrd_nombre()+ "%' OR lower(cate_id) like'" + getPrd_nombreCategoria()+ "%'";
        return conn.accion(sql);
    }
}
