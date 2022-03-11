package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarPersona{
    private JLabel lPersonas;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lProfesion;
    private JLabel lTelefono;
    private JButton bAceptar;
    public JPanel jPersonas;

    public RegistrarPersona() throws Exception{
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tfNombre.getText().isEmpty() && tfEdad.getText().isEmpty() && tfProfesion.getText().isEmpty() && tfTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio");
                } else {
                    Main.crearPersona(tfNombre.getText(),tfEdad.getText(),tfProfesion.getText(),tfTelefono.getText());
                    if (Main.error) {
                        tfNombre.setText("");
                        tfEdad.setText("");
                        tfProfesion.setText("");
                        tfTelefono.setText("");
                    } else {
                        // JOptionPane.showMessageDialog(null,"Persona creada correctamente");
                        tfNombre.setText("");
                        tfEdad.setText("");
                        tfProfesion.setText("");
                        tfTelefono.setText("");
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("RegistrarPersona");
        frame.setContentPane(new RegistrarPersona().jPersonas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
