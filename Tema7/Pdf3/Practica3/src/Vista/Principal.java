package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JButton bAcceso;
    private JLabel lEntidad;
    private JButton button1;
    public JPanel jPrincipal;

    public Principal() {
        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame2 = new JFrame("Acceder");
                frame2.setSize(400,400);
                frame2.setLocationRelativeTo(null);
                frame2.setContentPane(new Acceder().jAcceder);
                frame2.pack();
                frame2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().jPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


