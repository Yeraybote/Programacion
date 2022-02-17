package Vista;

import javax.swing.*;

public class Acceder {
    public JPanel jAcceder;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Acceder");
        frame.setContentPane(new Acceder().jAcceder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
