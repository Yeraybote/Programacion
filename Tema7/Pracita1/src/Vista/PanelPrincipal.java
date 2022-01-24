package Vista;

import Modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPrincipal {
    private JLabel lTitulo;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JLabel lApellido;
    private JTextField textField1;
    private JLabel lDni;
    private JTextField textField2;
    public JPanel PanelPrincipal;
    private JButton bSalir;
    private JButton bAceptar;

    public static ArrayList<Persona> listapersonas;
    public PanelPrincipal() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Persona p = new Persona(lNombre.getText(),lApellido.getText(),lDni.getText());
                listapersonas.add(p);
                JOptionPane.showMessageDialog(null,"Persona creada");
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PanelPrincipal");
        frame.setContentPane(new PanelPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
