
package modelo.MConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Abel Gomez
 */
public class ModelProducto extends modelo.Productos {

    modelo.OCconection conn = new modelo.OCconection();
    modelo.Productos Mproducto = new modelo.Productos();

    public ModelProducto() {
    }

    public ModelProducto(int prd_ID, String prd_nombre, double prd_precio, String prd_nombreCategoria, int prd_IDCategoria) {
        super(prd_ID, prd_nombre, prd_precio, prd_nombreCategoria, prd_IDCategoria);
    }

    

    

    public List<modelo.Productos> getproductos() {

        List<modelo.Productos> listaProductos = new ArrayList<>();
        String sql = "select p.prod_id, p.prod_nombre, p.prod_precio, c.cat_nombre from categoria c, producto p where c.cate_id=p.cate_id order by p.prod_id asc";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                modelo.Productos producto = new modelo.Productos();
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

    public boolean setProducto() {
        String sql;
        sql = "INSERT INTO producto (prod_id, prod_nombre, prod_precio, cate_id)";
        sql += "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conex.prepareStatement(sql);
            ps.setInt(1, getPrd_ID());
            ps.setString(2, getPrd_nombre());
            ps.setDouble(3, getPrd_precio());
            ps.setInt(4, getPrd_IDCategoria());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean uptadeProducto() {
        String sql;
        sql = "UPDATE producto SET prod_id=? ,prod_nombre=?,prod_precio=?,cate_id=? "
                + "WHERE prod_id='" + getPrd_ID()+ "'";
        try {
            PreparedStatement ps = conn.conex.prepareStatement(sql);
            ps.setInt(1, getPrd_ID());
            ps.setString(2, getPrd_nombre());
            ps.setDouble(3, getPrd_precio());
            ps.setInt(4, getPrd_IDCategoria());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }

    public boolean deleteProducto() {
        String sql = "DELETE FROM producto where prod_id='" + getPrd_ID() + "'";
        return conn.accion(sql);
    }

    public boolean buscarProductos() {
        String sql = "select prod_id, prod_nombre, prod_precio, cate_id from producto "
                + "where prod_id like '" + getPrd_ID() + "%' OR lower(prod_nombre) like'" + getPrd_nombre() + "%' OR lower(cate_id) like'" + getPrd_IDCategoria() + "%'";
        return conn.accion(sql);
    }

    public void cargarCategoriaCB(JComboBox cb_categoria) {

        String sql = "select cate_id, cat_nombre from categoria order by cate_id asc";
        cb_categoria.removeAllItems();
        try {
            PreparedStatement pst = conn.getConex().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            cb_categoria.addItem("Seleccione una opcion");
            while (rs.next()) {
                cb_categoria.addItem(rs.getString("cat_nombre").trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int codProducto(String nombre) {
        String sql = "select cate_id from categoria where cat_nombre='" + nombre + "'";

        try {
            PreparedStatement pst = conn.getConex().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mproducto.setPrd_IDCategoria(rs.getInt("cate_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Mproducto.getPrd_IDCategoria();
    }

//    public String nombreCategoria() {
//        List<Productos> nombresCat = new ArrayList<>();
//        String sql = "select c.cat_nombre from categoria c, producto p where c.cate_id=p.cate_id order by p.prod_id asc";
//        ResultSet rs = conn.consulta(sql);
//        try {
//            while (rs.next()) {
//                Productos producto = new Productos();
//                producto.setPrd_nombreCategoria(rs.getString(1));
//                
//                nombresCat.add(producto);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ModelProducto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 
//    }

}
