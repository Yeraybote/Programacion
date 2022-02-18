package Vista;

import javax.swing.*;

public class Consulta {
    public JPanel jConsulta;
    private JToolBar tbMenu;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JLabel lMovimientos;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Consulta");
        frame.setContentPane(new Consulta().jConsulta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
