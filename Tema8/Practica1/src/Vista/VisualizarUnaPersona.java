package Vista;

import Modelo.Persona;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarUnaPersona {
    public JPanel jVisualizarUnaPersona;
    private JTextField tfNombre;
    private JLabel lTitulo;
    private JLabel lNombre;
    private JTextArea taDatos;
    private JButton bMostrar;

    public VisualizarUnaPersona() {
        bMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Persona p = Main.recogerDatosPersona(tfNombre.getText());
                if (!Main.error){
                    taDatos.setText("");
                    taDatos.setText("Nombre: " + p.getNombre() + "\nEdad: " + p.getEdad() + "\nProfesión: " + p.getProfesion()
                            + "\nTeléfono: " + p.getTelefono());
                } else {
                    taDatos.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VisualizarUnaPersona");
        frame.setContentPane(new VisualizarUnaPersona().jVisualizarUnaPersona);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
