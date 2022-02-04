package Vista;

import javax.swing.*;
import java.awt.event.*;

public class Principal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lTitulo;
    private JTextField tfNombre;
    private JTextField textField2;
    private JLabel lNombre;
    private JLabel lUnidades;
    private JPanel JNombreunidad;
    private JPanel JOperacion;
    private JPanel JCompra;
    private JPanel JVenta;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JTextField tfPrecioCompra;
    private JComboBox listaProveedor;
    private JTextField tfImporte;
    private JLabel lPreciocompra;
    private JLabel lProveedor;
    private JLabel lImporte;
    private JPanel JDescuentos;
    private JTextField tfPrecioventa;
    private JTextField tfCliente;
    private JLabel lPrecioventa;
    private JLabel lCliente;
    private JCheckBox cbVolumen;
    private JCheckBox cbProntopago;
    private JTextField tfImporteventa;
    private JLabel lImporteventa;

    public Principal() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        rbCompra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                super.focusGained(focusEvent);
                // Desactivar opciones de venta
                tfPrecioventa.setEnabled(false);
                tfCliente.setEnabled(false);
                cbProntopago.setEnabled(false);
                cbVolumen.setEnabled(false);
                tfImporteventa.setEnabled(false);

                //Activar opciones de compra
                tfPrecioCompra.setEnabled(true);
                listaProveedor.setEnabled(true);
                tfImporte.setEnabled(true);
            }
        });
        rbVenta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                super.focusGained(focusEvent);
                // Activar opciones de venta
                tfPrecioventa.setEnabled(true);
                tfCliente.setEnabled(true);
                cbProntopago.setEnabled(true);
                cbVolumen.setEnabled(true);
                tfImporteventa.setEnabled(true);

                // Desactivar opciones de compra
                tfPrecioCompra.setEnabled(false);
                listaProveedor.setEnabled(false);
                tfImporte.setEnabled(false);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Principal dialog = new Principal();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
