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
import modelo.OCconection;
import modelo.Proveedor;

/**
 *
 * @author Abel Gomez
 */
public class ModeloProveedor extends Proveedor {

    OCconection conexion = new OCconection();

    public ModeloProveedor() {
    }

    public ModeloProveedor(int prv_ID, String prv_empresa) {
        super(prv_ID, prv_empresa);
    }

    public ModeloProveedor(int prv_ID, String prv_empresa, int prs_ID, String prs_cedula, String prs_nombre1, String prs_nombre2, String prs_apellido1, String prs_apellido2, String prs_direccion, String prs_telefono, String prs_email) {
        super(prv_ID, prv_empresa, prs_ID, prs_cedula, prs_nombre1, prs_nombre2, prs_apellido1, prs_apellido2, prs_direccion, prs_telefono, prs_email);
    }

    public List<Proveedor> getproveedor() {
        List<Proveedor> listaproveedores = new ArrayList<Proveedor>();

        String sql = "select p.pers_id,p.pers_cedula,p.pers_nombre1,p.pers_nombre2,p.pers_apellido1,p.pers_apellido2,p.pers_direccion,p.pers_telefono,p.pers_email , pro.peove_empresa  "
                + " from proveedor pro "
                + " join persona p"
                + " on (p.pers_id = pro.prove_id)";

        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();

                proveedor.setPrs_ID(rs.getInt(1));
                proveedor.setPrs_cedula(rs.getString(2));
                proveedor.setPrs_nombre1(rs.getString(3));
                proveedor.setPrs_nombre2(rs.getString(4));
                proveedor.setPrs_apellido1(rs.getString(5));
                proveedor.setPrs_apellido2(rs.getString(6));
                proveedor.setPrs_direccion(rs.getString(7));
                proveedor.setPrs_telefono(rs.getString(8));
                proveedor.setPrs_email(rs.getString(9));
                proveedor.setPrv_empresa(rs.getString(10));

                listaproveedores.add(proveedor);
            }
        } catch (Exception e) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaproveedores;
    }

    public int numeroidperona() {
        int id = 0;
        String sql = " SELECT pers_id "
                + "   FROM persona "
                + "  WHERE pers_id ="
                + "       ("
                + "        select max(pers_id) from persona"
                + "        )";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public boolean setpersona() {
        String sql = "insert into persona (pers_id,pers_cedula,pers_nombre1,pers_nombre2,pers_apellido1,pers_apellido2,pers_direccion,pers_telefono,pers_email ) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            //  PreparedStatement ps = mpgc.
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getPrs_ID());
            ps.setString(2, getPrs_cedula());
            ps.setString(3, getPrs_nombre1());
            ps.setString(4, getPrs_nombre2());
            ps.setString(5, getPrs_apellido1());
            ps.setString(6, getPrs_apellido2());
            ps.setString(7, getPrs_direccion());
            ps.setString(8, getPrs_telefono());
            ps.setString(9, getPrs_email());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean setproveedor() {
        String sql = "insert into proveedor (prove_id,peove_empresa,pers_id) values (?,?,?)";
        try {
            //  PreparedStatement ps = mpgc.
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getPrv_ID());
            ps.setString(2, getPrv_empresa());
            ps.setInt(3, getPrs_ID());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updatepersonaprovee() {

        String sql = "update persona  set pers_cedula = ?,"
                + "pers_nombre1 =  ?,"
                + "pers_nombre2 = ?,"
                + "pers_apellido1 = ?,"
                + "pers_apellido2 = ?,"
                + "pers_direccion = ?,"
                + "pers_telefono = ?,"
                + "pers_email= ? "
                + "where pers_id = " + getPrs_ID() ;

        try {
            PreparedStatement ps = conexion.getConex().prepareStatement(sql);
            ps.setString(1, getPrs_cedula());
            ps.setString(2, getPrs_nombre1());
            ps.setString(3, getPrs_nombre2());
            ps.setString(4, getPrs_apellido1());
            ps.setString(5, getPrs_apellido2());
            ps.setString(6, getPrs_direccion());
            ps.setString(7, getPrs_telefono());
            ps.setString(8, getPrs_email());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updateprovedor() {

        String sql = " update proveedor set peove_empresa = ? "
                + " where prove_id = " + getPrs_ID() ;

        try {
            PreparedStatement ps = conexion.getConex().prepareStatement(sql);
            ps.setString(1, getPrv_empresa());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean removeproveedor() {

        String sql = "DELETE FROM  proveedor WHERE  prove_id=" + getPrs_ID() ;

        return conexion.accion(sql);
    }

    public boolean removepersona() {

        String sql = "DELETE FROM  persona WHERE  pers_id =" + getPrs_ID() ;

        return conexion.accion(sql);
    }

    public List<Proveedor> buscarproveedor(String filtro) {
        List<Proveedor> listaproveedores = new ArrayList<Proveedor>();

        String sql = "select p.pers_id,p.pers_cedula,p.pers_nombre1,p.pers_nombre2,p.pers_apellido1,p.pers_apellido2,p.pers_direccion,p.pers_telefono,p.pers_email , pro.peove_empresa  "
                + " from proveedor pro "
                + " join persona p"
                + " on (p.pers_id = pro.prove_id)"
                + " where "
                + " UPPER(p.pers_cedula) LIKE UPPER ('" + filtro + "') or"
                + " UPPER(p.pers_nombre1) LIKE UPPER ('" + filtro + "') or"
                + " UPPER(p.pers_nombre2) LIKE UPPER ('" + filtro + "') or "
                + " UPPER(p.pers_apellido1) LIKE UPPER ('" + filtro + "') or "
                + " UPPER(p.pers_apellido2) LIKE UPPER ('" + filtro + "') or "
                + " UPPER(p.pers_direccion) LIKE UPPER ('" + filtro + "') or"
                + " UPPER(pro.peove_empresa) LIKE UPPER ('" + filtro + "') ";


        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();

                proveedor.setPrs_ID(rs.getInt(1));
                proveedor.setPrs_cedula(rs.getString(2));
                proveedor.setPrs_nombre1(rs.getString(3));
                proveedor.setPrs_nombre2(rs.getString(4));
                proveedor.setPrs_apellido1(rs.getString(5));
                proveedor.setPrs_apellido2(rs.getString(6));
                proveedor.setPrs_direccion(rs.getString(7));
                proveedor.setPrs_telefono(rs.getString(8));
                proveedor.setPrs_email(rs.getString(9));
                proveedor.setPrv_empresa(rs.getString(10));

                listaproveedores.add(proveedor);
            }
        } catch (Exception e) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaproveedores;

    }

}
