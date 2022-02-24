package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acceder extends JFrame {
    public JPanel jAcceder;
    private JTextField tfDni;
    private JPasswordField pfClave;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b0;
    private JLabel lDni;
    private JLabel lClave;
    private JButton bEntrar;
    private JPanel jBotones;
    private JPanel jCredenciales;

    public Acceder() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 1);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 2);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 3);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 4);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 5);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 6);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 7);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 8);
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 9);
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pfClave.setText(pfClave.getText() + 0);
            }
        });
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean existe = true;
                existe = Main.comprobarCliente(tfDni.getText(),pfClave.getText());
                if (existe == false) {
                    JOptionPane.showMessageDialog(null,"Clave o DNI erroneos");
                    pfClave.setText("");
                } else {
                    pfClave.setText("");
                    tfDni.setText("");
                    /* Abrir siguiente pestaña */
                    JFrame frame = new JFrame("Consulta");
                    frame.setContentPane(new Consulta().jConsulta);
                    frame.setSize(400,400);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Acceder");
        frame.setContentPane(new Acceder().jAcceder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
