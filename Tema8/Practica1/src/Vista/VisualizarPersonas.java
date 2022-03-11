package Vista;

import Modelo.Persona;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarPersonas {
    private JButton bMostrar;
    public JPanel jListaPersonas;
    private JLabel lTitulo;
    private JButton bAnterior;
    private JButton bSiguiente;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lProfesion;
    private JLabel lTelefono;


    public VisualizarPersonas() {
        bSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bAnterior.setEnabled(true);
                Persona p  = Main.recogerTodasPersonas(1);
                tfNombre.setText(p.getNombre());
                tfEdad.setText(String.valueOf(p.getEdad()));
                tfProfesion.setText(p.getProfesion());
                tfTelefono.setText(p.getTelefono());
            }
        });
        bAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Persona p  = Main.recogerTodasPersonas(0);
                tfNombre.setText(p.getNombre());
                tfEdad.setText(String.valueOf(p.getEdad()));
                tfProfesion.setText(p.getProfesion());
                tfTelefono.setText(p.getTelefono());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VisualizarPersonas");
        frame.setContentPane(new VisualizarPersonas().jListaPersonas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
