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
    private JTextField tfApellido;
    private JLabel lDni;
    private JTextField tfDni;
    public JPanel PanelPrincipal;
    private JButton bSalir;
    private JButton bAceptar;
    public static ArrayList<Persona> listapersonas = new ArrayList<>();

    public PanelPrincipal() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Persona p = new Persona(tfNombre.getText(), tfApellido.getText(), tfDni.getText());
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

    public static ArrayList<Persona> getListapersonas() {
        return listapersonas;
    }
}
