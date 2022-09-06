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
public class ModelCategoria extends Categoria {

    OCconection conn = new OCconection();

    public ModelCategoria() {
    }

    public ModelCategoria(int ctg_ID, String ctg_nombre) {
        super(ctg_ID, ctg_nombre);
    }

    public List<Categoria> getcategorias() {
        conn.OCconection();

        List<Categoria> listaCategorias = new ArrayList<>();
        String sql = "select * from categoria";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                Categoria categoria = new Categoria();
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

}
