/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.bemo;

import Controlador.ControladorCliente;
import VIsta.ClientesProveedores;
import modelo.MConexion.Modelo_Cliente;

/**
 *
 * @author OWNER
 */
public class PROYECTOBEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        modelo.OCconection oc = new modelo.OCconection();
//        
//        oc.getConex();

     Modelo_Cliente modelo = new Modelo_Cliente();
     ClientesProveedores vista = new ClientesProveedores();
     ControladorCliente control = new ControladorCliente(modelo, vista);
     
     
     control.iniciarcontrol();
    }
    
}
