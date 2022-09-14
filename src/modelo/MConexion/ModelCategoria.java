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

/**
 *
 * @author Abel Gomez
 */
public class ModelCategoria extends modelo.Categoria {

    modelo.OCconection conn = new modelo.OCconection();

    public ModelCategoria() {
    }

    public ModelCategoria(int ctg_ID, String ctg_nombre) {
        super(ctg_ID, ctg_nombre);
    }

    public List<modelo.Categoria> getcategorias() {
        
        List<modelo.Categoria> listaCategorias = new ArrayList<>();
        String sql = "select * from categoria order by cate_ID ASC";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                modelo.Categoria categoria = new modelo.Categoria();
                categoria.setCtg_ID(rs.getInt(1));
                categoria.setCtg_nombre(rs.getString(2));
              
                listaCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategorias;
    }
    
    public boolean setCategoria() {
        String sql = "INSERT INTO categoria (cate_id, cat_nombre) "
                + "VALUES('" + getCtg_ID()+ "', '" + getCtg_nombre()+ "')";
        return conn.accion(sql);
    }
    
    public boolean uptadeCategoria() {
        String sql = "UPDATE categoria SET cate_id='" + getCtg_ID()+ "', cat_nombre='" + getCtg_nombre()+ "' WHERE cate_id='" + getCtg_ID()+ "'";
        return conn.accion(sql);
    }
    
    public boolean deleteCategoria() {
        String sql = "DELETE FROM categoria where cate_id='" + getCtg_ID()+ "'";
        return conn.accion(sql);
    }
    
    public boolean buscarCategoria() {
        String sql = "select * from categoria "
                + "where cate_id like '" + getCtg_ID()+ "%' OR lower(cat_nombre) like'" + getCtg_nombre()+ "%'";
        return conn.accion(sql);
    }
}
