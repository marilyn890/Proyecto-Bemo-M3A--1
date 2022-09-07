/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.ClientesProveedores;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.MConexion.Modelo_Cliente;

/**
 *
 * @author Abel Gomez
 */
public class ControladorCliente {

    private Modelo_Cliente modelo;
    private ClientesProveedores vista;

    public ControladorCliente(Modelo_Cliente modelo, ClientesProveedores vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public ControladorCliente() {
    }

    public void iniciarcontrol() {

        cargardatos();
        vista.getBtncargardatoscliente().addActionListener(l -> cargardatos());
        vista.getBtnnuevocliente().addActionListener(l -> abrirDialogo(1));
        vista.getBtnmodificarcliente().addActionListener(l -> abrirDialogo(2));
        vista.getBtncancelar().addActionListener(l -> btncancelar());
        vista.getBtnagregar().addActionListener(l -> crearEditarcliente());

    }

    public void cargardatos() {
        vista.getTxtbuscarcliente().setText("");
        //  vista.getTablaclientes().setDefaultRenderer(Object.class, new ImagenTabla());
        // vista.getTablaclientes().setRowHeight(100);

        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaclientes().getModel();
        estructuratabla.setNumRows(0);
        List<Cliente> listaclientes = modelo.getclientes();

        Holder<Integer> i = new Holder<>(0);
        listaclientes.stream().forEach(cliente -> {
            estructuratabla.addRow(new Object[10]);

            vista.getTablaclientes().setValueAt(cliente.getCl_ID(), i.value, 0);
            vista.getTablaclientes().setValueAt(cliente.getPrs_ID(), i.value, 1);
            vista.getTablaclientes().setValueAt(cliente.getPrs_cedula(), i.value, 2);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre1(), i.value, 3);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre2(), i.value, 4);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido1(), i.value, 5);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido2(), i.value, 6);
            vista.getTablaclientes().setValueAt(cliente.getPrs_direccion(), i.value, 7);
            vista.getTablaclientes().setValueAt(cliente.getPrs_telefono(), i.value, 8);
            vista.getTablaclientes().setValueAt(cliente.getPrs_email(), i.value, 9);

            i.value++;

        });

    }

    private void abrirDialogo(int ope) {
        String titulo;
        if (ope == 1) {
            // limpiardatos();
            titulo = "Crear Persona";
            vista.getLbtitulo().setText("Crear Cliente");
            //   vista.getTxtidpersona().setEnabled(true);
            vista.getJdCliente().setName("C");
            vista.getJdCliente().setVisible(true);
            vista.getJdCliente().setTitle(titulo);
            vista.getJdCliente().setSize(750, 700);
            vista.getJdCliente().setLocationRelativeTo(vista);
            vista.getTxtidcliente().setText("CLI "+String.valueOf(modelo.numeroid() + 1));
            vista.getTxtidcliente().setEnabled(false);

        } else {

            titulo = "Editar Persona";
            vista.getLbtitulo().setText("Editar Cliente");

            vista.getTxtidcliente().setEnabled(false);
            vista.getJdCliente().setName("E");

            //    seleccionarfila();
            //vista.getDlgPersona().setVisible(false);
            vista.getJdCliente().setTitle(titulo);
            vista.getJdCliente().setSize(750, 700);
            vista.getJdCliente().setLocationRelativeTo(vista);
            vista.getJdCliente().setVisible(true);

        }
        //   vista.getDlgPersona().setTitle(titulo);
        // vista.getJdCliente().setSize(750, 700);
        // vista.getJdCliente().setLocationRelativeTo(vista);
    }

    public void btncancelar() {
        vista.getJdCliente().setVisible(false);

    }

    private void crearEditarcliente() {

        if (vista.getJdCliente().getName().contentEquals("C")) {
          
            int id = modelo.numeroid() + 1;

            String cedula = vista.getTxtcedula().getText();
            String nombre1 = vista.getTxtnombre().getText();
            String nombre2 = vista.getTxtsegundonombre().getText();
            String apellido1 = vista.getTxtapellido().getText();
            String apellido2 = vista.getTxtsegundoapellido().getText();
            String telefono = vista.getTxttelefono().getText();
            String direccion = vista.getTxtdireccion().getText();
            String email = vista.getTxtemail().getText();

            Modelo_Cliente clienteP = new Modelo_Cliente();

            clienteP.setCl_ID(id);
         
            clienteP.setPrs_cedula(cedula);
            clienteP.setPrs_nombre1(nombre1);
            clienteP.setPrs_nombre2(nombre2);
            clienteP.setPrs_apellido1(apellido1);
            clienteP.setPrs_apellido2(apellido2);
            clienteP.setPrs_direccion(direccion);
            clienteP.setPrs_telefono(telefono);
            clienteP.setPrs_email(email);

            
            
            
            Modelo_Cliente cliente = new Modelo_Cliente();
            
               cliente.setPrs_ID(id);
               cliente.setCl_ID(id);
               
            if (clienteP.setpersona() && cliente.setcliente()) {
                JOptionPane.showMessageDialog(vista, "Cliente registrada exitosamente");
                vista.setVisible(true);
                vista.getJdCliente().setVisible(false);

            } else {
                JOptionPane.showMessageDialog(vista, "Error , datos No guardados");

            }

        }

    }

}
