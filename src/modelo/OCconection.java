/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OWNER
 */
public class OCconection {
    String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE";
    String pgUsuario = "EDDY";
    String pgContra = "1234";
    public Connection conex;
    
    public OCconection() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OCconection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conex = DriverManager.getConnection(cadenaConexion, pgUsuario, pgContra);
        } catch (SQLException ex) {
            Logger.getLogger(OCconection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public ResultSet consulta(String sql) {
        
        try {
            Statement at = conex.createStatement();
            return at.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OCconection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean accion(String sql) {
        //INSERT-UPDATE-DELETE

        boolean correcto;

        try {
            Statement at = conex.createStatement();
            at.execute(sql);
            at.close();//Cierro la conexion
            correcto = true;
            
        } catch (Exception e) {
            Logger.getLogger(OCconection.class.getName()).log(Level.SEVERE, null, e);
            correcto = false;
        }
        return correcto;
    }

    public Connection getConex() {
                System.out.println("conexion aporbada");
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }
}
