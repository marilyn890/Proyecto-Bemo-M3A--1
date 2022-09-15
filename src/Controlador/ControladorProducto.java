/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Categorias;
import VIsta.RegistrosdeFacturasGastosBalances;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.ws.Holder;
import modelo.Categoria;
import modelo.MConexion.ModelCategoria;
import modelo.MConexion.ModelProducto;
import modelo.MConexion.ModelProducto;
import modelo.OCconection;
import modelo.Productos;

/**
 *
 * @author OWNER
 */
public class ControladorProducto {

    private modelo.MConexion.ModelProducto modeloPro;
    private VIsta.RegistrosdeFacturasGastosBalances vistaPro;
    private VIsta.Categorias vistcate = new VIsta.Categorias();

    public ControladorProducto(ModelProducto modeloPro, RegistrosdeFacturasGastosBalances vistaPro) {
        this.modeloPro = modeloPro;
        this.vistaPro = vistaPro;
        vistaPro.setVisible(true);
        cargarDatos();
        habilitarBotones();
        modeloPro.cargarCategoriaCB(vistaPro.getCbProCate());
        GenerarEditarCodigo();
    }

    public void iniciaControl() {
        vistaPro.getBtPrevisualizar().addActionListener(l-> previa());
        vistaPro.getBtVerCategoria().addActionListener(l -> abrirCategoria());
        vistaPro.getBtPronuevo().addActionListener(l -> abrirdialog(1));
        vistaPro.getBtProModif().addActionListener(l -> abrirdialog(2));
        vistaPro.getBtAgregarModi().addActionListener(l -> crearEditarProducto());
        vistaPro.getBtProdelete().addActionListener(l -> eliminarProducto());
        vistaPro.getBtSalir().addActionListener(l -> vistaPro.getJdProductos().dispose());
        vistaPro.getTbProductos().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int fila = vistaPro.getTbProductos().rowAtPoint(e.getPoint());
                int columna = vistaPro.getTbProductos().columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    vistaPro.getBtProdelete().setEnabled(true);
                    vistaPro.getBtProModif().setEnabled(true);
                } else {
                    vistaPro.getBtProdelete().setEnabled(false);
                    vistaPro.getBtProModif().setEnabled(false);
                }
            }
        });
    }

    private void cargarDatos() {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaPro.getTbProductos().getModel();
        estucturaTabla.setNumRows(0);

        List<Productos> listPro = modeloPro.getproductos();

        Holder<Integer> i = new Holder<>(0);
        listPro.stream().forEach(Pro -> {
            estucturaTabla.addRow(new Object[4]);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_ID(), i.value, 0);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_nombre(), i.value, 1);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_precio(), i.value, 2);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_nombreCategoria(), i.value, 3);

            i.value++;
        });
    }

    private void abrirdialog(int opcion) {
        TableModel modelo = vistaPro.getTbProductos().getModel();
        int indiceUltimaFila = modelo.getRowCount() - 1;
        int id_producto;
        if (indiceUltimaFila == -1) {
            id_producto = 1;
        } else {
            id_producto = Integer.parseInt(modelo.getValueAt(indiceUltimaFila, 0).toString());
            id_producto++;
        }

        if (opcion == 1) {
            vistaPro.getLbModificar().setVisible(false);
            vistaPro.getLbNuevo().setVisible(true);
            vistaPro.getJdProductos().setName("C");
            vistaPro.getJdProductos().setVisible(true);
            vistaPro.getJdProductos().setSize(600, 500);
            vistaPro.getTxtCodPro().setText(String.valueOf(id_producto));
            vistaPro.getBtAgregarModi().setText("Agregar");
            vaciasCampos();
        } else {

            vistaPro.getJdProductos().setName("E");

            int fila = vistaPro.getTbProductos().getSelectedRow();

            if (fila >= 0) {
                vistaPro.getTxtCodPro().setText(vistaPro.getTbProductos().getValueAt(fila, 0).toString());
                vistaPro.getTxtPronombre().setText(vistaPro.getTbProductos().getValueAt(fila, 1).toString());
                vistaPro.getTxtProprecio().setText(vistaPro.getTbProductos().getValueAt(fila, 2).toString());
                vistaPro.getCbProCate().setSelectedIndex(modeloPro.codProducto(vistaPro.getTbProductos().getValueAt(fila, 3).toString()));

                vistaPro.getJdProductos().setVisible(true);
                vistaPro.getJdProductos().setSize(600, 500);
                vistaPro.getLbModificar().setVisible(true);
                vistaPro.getLbNuevo().setVisible(false);

                vistaPro.getBtAgregarModi().setText("Modificar");
            }

        }
        vistaPro.getRbGenerar().setSelected(true);
    }

    public void crearEditarProducto() {
        if (vistaPro.getJdProductos().getName().contentEquals("C")) {
            int id = Integer.parseInt(vistaPro.getTxtCodPro().getText());
            String nombrePro = vistaPro.getTxtPronombre().getText().toString();
            String precio = vistaPro.getTxtProprecio().getText();

            modeloPro.setPrd_ID(id);
            modeloPro.setPrd_nombre(nombrePro);
            modeloPro.setPrd_precio(Double.parseDouble(precio));
            modeloPro.setPrd_IDCategoria(modeloPro.codProducto(vistaPro.getCbProCate().getSelectedItem().toString()));

            if (modeloPro.setProducto()) {
                JOptionPane.showMessageDialog(vistaPro, "Categoría creado!!");
                vaciasCampos();
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(vistaPro, "Error: verifique que los campos no estén vacios");
            }
        } else {
            if (vistaPro.getJdProductos().getName().contentEquals("E")) {
                int id = Integer.parseInt(vistaPro.getTxtCodPro().getText());
                String nombrePro = vistaPro.getTxtPronombre().getText().toString();
                String precio = vistaPro.getTxtProprecio().getText();

                modeloPro.setPrd_ID(id);
                modeloPro.setPrd_nombre(nombrePro);
                modeloPro.setPrd_precio(Double.parseDouble(precio));
                modeloPro.setPrd_IDCategoria(modeloPro.codProducto(vistaPro.getCbProCate().getSelectedItem().toString()));
                System.out.println(modeloPro.codProducto(vistaPro.getCbProCate().getSelectedItem().toString()));

                if (modeloPro.uptadeProducto()) {
                    JOptionPane.showMessageDialog(vistaPro, "Categoría modificada con exito!!");
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(vistaPro, "Error: revise si los datos ingresados son correctos!");
                }
            }
        }

    }

    public void eliminarProducto() {
        try {
            int fila = vistaPro.getTbProductos().getSelectedRow();

            if (fila >= 0) {
                int id = Integer.parseInt(vistaPro.getTbProductos().getValueAt(fila, 0).toString());

                modeloPro.setPrd_ID(id);

                if (vistaPro.getTbProductos().getRowSelectionAllowed()) {

                    int a = JOptionPane.showConfirmDialog(null, "Deseas eliminar " + vistaPro.getTxtPronombre().getText().toString());
                    if (a == 0) {
                        modeloPro.deleteProducto();
                        JOptionPane.showMessageDialog(vistaPro, "Se eliminado " + vistaPro.getTxtPronombre().getText().toString());
                        cargarDatos();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    private void llenar(List<Categoria> lista) {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaPro.getTbProductos().getModel();
        estucturaTabla.setRowCount(0);

        lista.stream().forEach(p1 -> {
            String[] persona1 = {String.valueOf(p1.getCtg_ID()), p1.getCtg_nombre()};
            estucturaTabla.addRow(persona1);
        });
    }

    public void GenerarEditarCodigo() {
        if (vistaPro.getRbGenerar().isSelected()) {
            vistaPro.getTxtCodPro().setEnabled(false);
        } else {
            vistaPro.getTxtCodPro().setEnabled(true);
        }
    }

    private void habilitarBotones() {
        if (vistaPro.getTbProductos().getSelectedRow() >= 1) {
            vistaPro.getBtProdelete().setEnabled(true);
            vistaPro.getBtProModif().setEnabled(true);
        } else {
            vistaPro.getBtProdelete().setEnabled(false);
            vistaPro.getBtProModif().setEnabled(false);
        }
    }

    private void abrirCategoria() {
        modelo.MConexion.ModelCategoria modcate = new modelo.MConexion.ModelCategoria();
        

        ControladorCategoria contcate = new ControladorCategoria(modcate, vistcate);
        contcate.inicioControl();
    }

    private void vaciasCampos() {
        vistaPro.getTxtPronombre().setText("");
        vistaPro.getTxtProprecio().setText("");
        vistaPro.getTxtPrevista().setText("");
    }
    
    private void previa(){
        String pv = vistaPro.getTxtCodPro().getText()+", "+vistaPro.getTxtPronombre().getText()+", "
                + ""+vistaPro.getTxtProprecio().getText()+", "+vistaPro.getCbProCate().getSelectedItem().toString();
        vistaPro.getTxtPrevista().setText(pv);
    }

}
