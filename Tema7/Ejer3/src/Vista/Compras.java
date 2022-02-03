package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compras {
    public JPanel Compras;
    private JLabel lCompras;
    private JLabel lProducto;
    private JTextField tfProducto;
    private JTextField tfUnidades;
    private JTextField tfPrecio;
    private JLabel lUnidades;
    private JLabel lPrecio;
    private JButton bAceptar;
    private JButton bCancelar;

    public Compras() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Aceptar
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Cancelar
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Compras");
        frame.setContentPane(new Compras().Compras);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
