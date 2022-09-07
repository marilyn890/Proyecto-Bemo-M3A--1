/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.OCconection;

/**
 *
 * @author Abel Gomez
 */
public class Modelo_Cliente extends Cliente {

    OCconection conexion = new OCconection();

    public Modelo_Cliente(int cl_ID) {
        super(cl_ID);
    }

    public Modelo_Cliente(int cl_ID, int prs_ID, String prs_cedula, String prs_nombre1, String prs_nombre2, String prs_apellido1, String prs_apellido2, String prs_direccion, String prs_telefono, String prs_email) {
        super(cl_ID, prs_ID, prs_cedula, prs_nombre1, prs_nombre2, prs_apellido1, prs_apellido2, prs_direccion, prs_telefono, prs_email);
    }

    public Modelo_Cliente() {
    }

    public List<Cliente> getclientes() {
        List<Cliente> listaclientes = new ArrayList<Cliente>();

        String sql = " select c.cli_id,p.pers_id,p.pers_cedula,p.pers_nombre1,p.pers_nombre2,p.pers_apellido1,p.pers_apellido2,p.pers_direccion,p.pers_telefono,p.pers_email "
                + " from cliente c "
                + " join persona p "
                + " on (p.pers_id = c.pers_id)";

        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setCl_ID(rs.getInt(1));
                cliente.setPrs_ID(rs.getInt(2));
                cliente.setPrs_cedula(rs.getString(3));
                cliente.setPrs_nombre1(rs.getString(4));
                cliente.setPrs_nombre2(rs.getString(5));
                cliente.setPrs_apellido1(rs.getString(6));
                cliente.setPrs_apellido2(rs.getString(7));
                cliente.setPrs_direccion(rs.getString(8));
                cliente.setPrs_telefono(rs.getString(9));
                cliente.setPrs_email(rs.getString(10));

                listaclientes.add(cliente);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaclientes;
    }

    public int numeroid() {
        int id =0;
        String sql = "select max(pers_id) from persona";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
               id= rs.getInt(1);
            
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public boolean setpersona() {
        String sql = "insert into persona (pers_id,pers_cedula,pers_nombre1,pers_nombre2,pers_apellido1,pers_apellido2,pers_direccion,pers_telefono,pers_email )"
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
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean setcliente() {
        String sql = "insert into cliente (cli_id,pers_id) values (?,?)";
        try {
            //  PreparedStatement ps = mpgc.
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getCl_ID());
            ps.setInt(2, getPrs_ID());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updatecliente() {

        String sql = "  update  persona p INNER JOIN   cliente c "
                + "  on (p.pers_id = c.pers_id) "
                + "  set  pers_cedula = ? "
                + "  ,p.pers_nombre1= ?,p.pers_nombre2=?"
                + "  ,p.pers_apellido1=? "
                + "  ,p.pers_apellido2=? "
                + "  ,p.pers_direccion=?,"
                + "   p.pers_telefono=?"
                + "  ,p.pers_email =?"
                + "  where c.cli_id = " + getCl_ID() + ";";

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
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean removecliente() {

        String sql = "DELETE FROM  cliente WHERE  cli_id='" + getCl_ID() + "';";

        return conexion.accion(sql);
    }

    public boolean removepersona() {

        String sql = "DELETE FROM  persona WHERE  pers_id='" + getPrs_ID() + "';";

        return conexion.accion(sql);
    }

    public List<Cliente> buscarcliente(String filtro) {

        List<Cliente> listaclientes = new ArrayList<Cliente>();

        //  String sqlID = "select idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo  from  persona  where idpersona LIKE '" + filtro + "';";
        String sql = "  select c.cli_id,p.pers_id,p.pers_cedula,p.pers_nombre1,p.pers_nombre2,p.pers_apellido1,p.pers_apellido2,p.pers_direccion,p.pers_telefono,p.pers_email "
                + "    from cliente c "
                + "    join persona p "
                + "    on (p.pers_id = c.pers_id) "
                + "    where  UPPER(p.pers_nombre1) LIKE UPPER ('" + filtro + "') OR"
                + "    UPPER (p.pers_cedula) like upper ('" + filtro + "')  or "
                + "    upper (p.pers_apellido1) like upper ('" + filtro + "') or "
                + "    upper (p.pers_telefono) like upper ('" + filtro + "') ;";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCl_ID(rs.getInt(1));
                cliente.setPrs_ID(rs.getInt(2));
                cliente.setPrs_cedula(rs.getString(3));
                cliente.setPrs_nombre1(rs.getString(4));
                cliente.setPrs_nombre2(rs.getString(5));
                cliente.setPrs_apellido1(rs.getString(6));
                cliente.setPrs_apellido2(rs.getString(7));
                cliente.setPrs_direccion(rs.getString(8));
                cliente.setPrs_telefono(rs.getString(9));
                cliente.setPrs_email(rs.getString(10));

                listaclientes.add(cliente);
            }
        } catch (Exception e) {
            Logger.getLogger(OCconection.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaclientes;
    }
}
