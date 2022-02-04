package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Ventas {
    public JPanel Ventas;
    private JLabel lVentas;
    private JLabel lProducto;
    private JTextField tfProducto;
    private JLabel lUnidades;
    private JTextField tfUnidades;
    private JTextField tfImporte;
    private JLabel lImporte;
    private JButton bCancelar;
    private JButton bAceptar;

    public Ventas() {
        bAceptar.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent propertyChangeEvent) throws PropertyVetoException {

            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        tfProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent focusEvent) {
                super.focusLost(focusEvent);
                com.company.Main.validarProductos(tfProducto.getText());
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                com.company.Main.venderProductos(tfProducto.getText(),tfUnidades.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventas");
        frame.setContentPane(new Ventas().Ventas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
