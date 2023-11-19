import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtSalario;
    private JButton btnRegistrar;
    private JButton btnListar;
    private JList lstEmpleados;
    private JButton btnModificar;
    private JTextField txtMCedula;
    private JTextField txtMNombre;
    private JTextField txtMSalario;
    private JButton btnInforme;
    private JTextArea txtInforme;

    private RolDePagos empleados = new RolDePagos();

    private void llenarJlist(){
        List<Empleado> listEmpleados = new ArrayList<Empleado>(empleados.getSetEmpleados());
        DefaultListModel<Empleado> dlm = new DefaultListModel<Empleado>();
        for (Empleado e : listEmpleados){
            dlm.addElement(e);
        }
        lstEmpleados.setModel(dlm);
    }


    public Ventana() {

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cedula = 0;
                String nombre = "";
                double salario = 0;

                if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtSalario.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                    return;
                }

                if(txtCedula.getText().length() != 10){
                    JOptionPane.showMessageDialog(null, "La cédula debe tener 10 caracteres");
                    return;
                }

                try {
                cedula = Double.parseDouble(txtCedula.getText());
                nombre = txtNombre.getText();
                    salario = Double.parseDouble(txtSalario.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Utilice el punto {.} para decimales");
                    return;
                }

                if (empleados.agregarEmpleado(new Empleado(cedula, nombre, salario))) {
                        JOptionPane.showMessageDialog(null, "Empleado agregado con éxito");
                } else {
                        JOptionPane.showMessageDialog(null, "No fue posible agregar el empleado");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarJlist();
            }
        });

        lstEmpleados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstEmpleados.getSelectedIndex()!=-1){
                    Empleado d = (Empleado) lstEmpleados.getSelectedValue();
                    txtMCedula.setText(String.format("%.0f", d.getCedula()));
                    txtMNombre.setText(d.getNombre());
                    txtMSalario.setText(String.format("%.2f", d.getSalario()));
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cedula = 0;
                String nombre = "";
                double salario = 0;

                if (txtMCedula.getText().isEmpty() || txtMNombre.getText().isEmpty() || txtMSalario.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                    return;
                }

                try {
                    cedula = Double.parseDouble(txtMCedula.getText());
                    nombre = txtMNombre.getText();
                    salario = Double.parseDouble(txtMSalario.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Utilice el punto {.} para decimales");
                    return;
                }

                if (empleados.modificarEmpleado(new Empleado(cedula, nombre, salario))) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible actualizar los datos del empleado");
                }
                llenarJlist();
            }
        });

        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleados.calcularSeguroSocial();
                empleados.calcularImpuestoalaRenta();
                txtInforme.setText(empleados.generarInforme());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
