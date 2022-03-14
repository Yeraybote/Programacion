package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarEvento {
    private JLabel lTitulo;
    private JTextField tfNombre;
    public JPanel jCancelar;
    private JLabel lNombre;
    private JButton bCancelar;

    public CancelarEvento() {
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Main.eliminarEvento(tfNombre.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                    Main.error = false;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CancelarEvento");
        frame.setContentPane(new CancelarEvento().jCancelar);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
