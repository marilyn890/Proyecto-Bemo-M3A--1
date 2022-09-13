/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.VistaProveedor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.MConexion.ModeloProveedor;
//import modelo.ModeloProveedor;
//import modelo.Modelocliente;
import modelo.Proveedor;
//import vistas.VistaProveedor;

/**
 *
 * @author Abel Gomez
 */
public class ControladorProveedor {

    private ModeloProveedor modelo;
    private VistaProveedor vista;

    public ControladorProveedor(ModeloProveedor modelo, VistaProveedor vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarcontrol() {

        cargardatos();
        vista.getBtnactualzartabla().addActionListener(l -> cargardatos());
        vista.getBtnagregar().addActionListener(l -> abrirDialogo(1));
        vista.getBtnmodificar().addActionListener(l -> abrirDialogo(2));
        vista.getBtncancelar().addActionListener(l -> btncancelar());
        vista.getBtnagregar1().addActionListener(l -> crearEditarproveedor());
        vista.getBtneleminar().addActionListener(l -> eleiminarprovvedor());
        vista.getBtnlimpiar().addActionListener(l->limpiardatos());
        vista.getTxtbuscarproveedor().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscar();
            }

        });

    }

    public void cargardatos() {

        //  vista.getTablaclientes().setDefaultRenderer(Object.class, new ImagenTabla());
        // vista.getTablaclientes().setRowHeight(100);
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaproveedores().getModel();
        estructuratabla.setNumRows(0);
        List<Proveedor> listaproveedores = modelo.getproveedor();

        Holder<Integer> i = new Holder<>(0);
        listaproveedores.stream().forEach(proveddor -> {
            estructuratabla.addRow(new Object[10]);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_ID(), i.value, 0);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_cedula(), i.value, 1);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre1(), i.value, 2);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre2(), i.value, 3);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido1(), i.value, 4);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido2(), i.value, 5);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_direccion(), i.value, 6);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_telefono(), i.value, 7);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_email(), i.value, 8);
            vista.getTablaproveedores().setValueAt(proveddor.getPrv_empresa(), i.value, 9);

            i.value++;

        });

    }

    private void abrirDialogo(int ope) {
        String titulo;
        if (ope == 1) {
             limpiardatos();
            titulo = "Crear Proveedor";
            vista.getLbtitulo().setText("Crear Proveedor");
            //   vista.getTxtidpersona().setEnabled(true);
            vista.getJdialogproveedor().setName("C");
            vista.getJdialogproveedor().setVisible(true);
            vista.getJdialogproveedor().setTitle(titulo);
            vista.getJdialogproveedor().setSize(900, 850);
            vista.getJdialogproveedor().setLocationRelativeTo(vista);
            vista.getTxtidproveedor().setText(String.valueOf(modelo.numeroidperona() + 1));
            vista.getTxtidproveedor().setEnabled(false);

        } else {

            titulo = "Editar Proveedor";
            vista.getLbtitulo().setText("Editar Proveedor");

            vista.getTxtidproveedor().setEnabled(false);
            vista.getJdialogproveedor().setName("E");

            seleccionarfila();
            //vista.getDlgPersona().setVisible(false);
            vista.getJdialogproveedor().setTitle(titulo);
            vista.getJdialogproveedor().setSize(900, 850);
            vista.getJdialogproveedor().setLocationRelativeTo(vista);
            // vista.getJdialogproveedor().setVisible(true);

        }
        //   vista.getDlgPersona().setTitle(titulo);
        // vista.getJdCliente().setSize(750, 700);
        // vista.getJdCliente().setLocationRelativeTo(vista);
    }

    public void btncancelar() {
        vista.getJdialogproveedor().setVisible(false);

    }

    private void crearEditarproveedor() {
        
        
        int idperona = 0;
       // int idcliente = 0;
        if (vista.getJdialogproveedor().getName().contentEquals("C")) {
            

            if (modelo.numeroidperona() == 0) {
                idperona = 1;
            } else {
                idperona = modelo.numeroidperona() + 1;
            }
//            if (modelo.numeroidclinte() == 0) {
//
//                idcliente = 1;
//
//            } else {
//
//                idcliente = modelo.numeroidclinte() + 1;
//            }

            String cedula = vista.getTxtcedula().getText();
            String nombre1 = vista.getTxtnombre().getText();
            String nombre2 = vista.getTxtsegundonombre().getText();
            String apellido1 = vista.getTxtapellido().getText();
            String apellido2 = vista.getTxtsegundoapellido().getText();
            String telefono = vista.getTxttelefono().getText();
            String direccion = vista.getTxtdireccion().getText();
            String email = vista.getTxtemail().getText();
            String nombreempresa = vista.getTxtnombreempresa().getText();

            ModeloProveedor proveedor = new ModeloProveedor();

            proveedor.setPrs_ID(idperona);

            proveedor.setPrs_cedula(cedula);
            proveedor.setPrs_nombre1(nombre1);
            proveedor.setPrs_nombre2(nombre2);
            proveedor.setPrs_apellido1(apellido1);
            proveedor.setPrs_apellido2(apellido2);
            proveedor.setPrs_direccion(direccion);
            proveedor.setPrs_telefono(telefono);
            proveedor.setPrs_email(email);
            proveedor.setPrv_ID(idperona);
            proveedor.setPrv_empresa(nombreempresa);

//
//            Modelocliente cliente = new Modelocliente();
//            cliente.setCl_ID(3);
//            cliente.setPrs_ID(3);
            if (proveedor.setpersona() && proveedor.setproveedor()) {
                JOptionPane.showMessageDialog(vista, "Proveedor registrado exitosamente");
                vista.setVisible(true);
                vista.getJdialogproveedor().setVisible(false);
                cargardatos();
                limpiardatos();
                     
//                if (clienteP.setcliente()) {
//                    JOptionPane.showMessageDialog(vista, "Cliente registrada exitosamente");
//                    vista.setVisible(true);
//                    vista.getDialogclientes().setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(vista, "fallo cliente");
//                }

            } else {
                JOptionPane.showMessageDialog(vista, "fallo persona");

            }

        }//
        else {
            int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Actualizar este Registro?");

            if (respuesta == JOptionPane.YES_OPTION) {
                if (vista.getJdialogproveedor().getName().contentEquals("E")) {
                    int id = Integer.valueOf(vista.getTxtidproveedor().getText());
                    String cedula = vista.getTxtcedula().getText();
                    String nombre1 = vista.getTxtnombre().getText();
                    String nombre2 = vista.getTxtsegundonombre().getText();
                    String apellido1 = vista.getTxtapellido().getText();
                    String apellido2 = vista.getTxtsegundoapellido().getText();
                    String telefono = vista.getTxttelefono().getText();
                    String direccion = vista.getTxtdireccion().getText();
                    String email = vista.getTxtemail().getText();
                    String nombreempresa = vista.getTxtnombreempresa().getText();

                    ModeloProveedor proveedor = new ModeloProveedor();

                    proveedor.setPrs_ID(id);

                    proveedor.setPrs_cedula(cedula);
                    proveedor.setPrs_nombre1(nombre1);
                    proveedor.setPrs_nombre2(nombre2);
                    proveedor.setPrs_apellido1(apellido1);
                    proveedor.setPrs_apellido2(apellido2);
                    proveedor.setPrs_direccion(direccion);
                    proveedor.setPrs_telefono(telefono);
                    proveedor.setPrs_email(email);
                    proveedor.setPrv_ID(id);
                    proveedor.setPrv_empresa(nombreempresa);

                    if (proveedor.updatepersonaprovee() && proveedor.updateprovedor()) {

                        JOptionPane.showMessageDialog(vista, "Proveedor Actualizada");
                         limpiardatos();

                        cargardatos();

                        vista.getJdialogproveedor().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista, "Error , datos No Actualizados");
                        //   JOptionPane.showConfirmDialog(vista, "Error , datos No guardados");
                    }

                }

            }
        }

    }

    public void seleccionarfila() {

        // SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        try {

            int fila = vista.getTablaproveedores().getSelectedRow();

            if (fila >= 0) {
                vista.getTxtidproveedor().setText(vista.getTablaproveedores().getValueAt(fila, 0).toString());
                vista.getTxtcedula().setText(vista.getTablaproveedores().getValueAt(fila, 1).toString());
                vista.getTxtnombre().setText(vista.getTablaproveedores().getValueAt(fila, 2).toString());
                vista.getTxtsegundonombre().setText(vista.getTablaproveedores().getValueAt(fila, 3).toString());
                vista.getTxtapellido().setText(vista.getTablaproveedores().getValueAt(fila, 4).toString());
                vista.getTxtsegundoapellido().setText(vista.getTablaproveedores().getValueAt(fila, 5).toString());
                vista.getTxtdireccion().setText(vista.getTablaproveedores().getValueAt(fila, 6).toString());
                vista.getTxttelefono().setText(vista.getTablaproveedores().getValueAt(fila, 7).toString());
                vista.getTxtemail().setText(vista.getTablaproveedores().getValueAt(fila, 8).toString());
                vista.getTxtnombreempresa().setText(vista.getTablaproveedores().getValueAt(fila, 9).toString());
                vista.getJdialogproveedor().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
                vista.getJdialogproveedor().setVisible(false);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public void eleiminarprovvedor() {

        int idpersona = 0;
        try {
            int fila = vista.getTablaproveedores().getSelectedRow();

            if (fila >= 0) {
                int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Eliminar este Registro?");
                if (respuesta == JOptionPane.YES_OPTION) {

                    idpersona = Integer.valueOf(vista.getTablaproveedores().getValueAt(fila, 0).toString());

                    ModeloProveedor proveedor = new ModeloProveedor();
                    proveedor.setPrs_ID(idpersona);

                    if (proveedor.removeproveedor() && proveedor.removepersona()) {

                        JOptionPane.showMessageDialog(vista, "Dato Eliminado");
                            limpiardatos();
                        cargardatos();
                        vista.getJdialogproveedor().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista, "Error , dato no eliminado");

                    }
                } else {

                }
            } else {

                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public void buscar() {

        String filtro = vista.getTxtbuscarproveedor().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaproveedores().getModel();
        estructuratabla.setNumRows(0);
        List<Proveedor> listaproveedores = modelo.buscarproveedor(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaproveedores.stream().forEach(proveddor -> {
            estructuratabla.addRow(new Object[10]);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_ID(), i.value, 0);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_cedula(), i.value, 1);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre1(), i.value, 2);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre2(), i.value, 3);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido1(), i.value, 4);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido2(), i.value, 5);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_direccion(), i.value, 6);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_telefono(), i.value, 7);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_email(), i.value, 8);
            vista.getTablaproveedores().setValueAt(proveddor.getPrv_empresa(), i.value, 9);

            i.value++;

        });

    }

    public void limpiardatos() {

        //  vista.getTxtidcliente().setText("");
        vista.getTxtcedula().setText("");
        vista.getTxtnombre().setText("");
        vista.getTxtsegundonombre().setText("");
        vista.getTxtapellido().setText("");
        vista.getTxtsegundoapellido().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtemail().setText("");
        vista.getTxtnombreempresa().setText("");

    }

}
