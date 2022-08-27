/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abel Gomez
 */
public class ConexionBD {
    
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "";//poner su usuario
    private final String PASWORD = "  ";// poner su contrase
    private Connection con;

    public Connection conectar() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASWORD);

            return con;
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

    }

    public ResultSet consulta(String sql) {
        try {
            
            Statement st = con.createStatement();

            return st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("error en consulta :clase conexion" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean accion(String sql) {
        //INSERT-UPDATE-DELETE

        boolean correcto;

        try {
            Statement at = con.createStatement();
            at.execute(sql);

            at.close();//Cierro la conexion

            correcto = true;

        } catch (Exception e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
            correcto = false;
        }
        return correcto;
    }
    
}
