package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListaPersonas {
    private JLabel lLista;
    private JTextArea taLista;
    private JButton bSalir;
    private JButton bMostrar;
    public JPanel Panel2;

    public PanelListaPersonas() {
        bMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int x = 0; x < PanelPrincipal.getListapersonas().size(); x++) {
                    taLista.setText(PanelPrincipal.getListapersonas().get(x).getNombre() + " " +
                            PanelPrincipal.getListapersonas().get(x).getApellido() + " " +
                            PanelPrincipal.getListapersonas().get(x).getDni());
                }
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
        JFrame frame = new JFrame("PanelListaPersonas");
        frame.setContentPane(new PanelListaPersonas().Panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
