package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarEvento {
    private JTextField tfNombre;
    private JButton bModificar;
    private JComboBox cbAtributo;
    private JTextField tfActualizar;
    private JLabel lTitulo;
    public JPanel jModificarEvento;

    public ModificarEvento() {
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.atributo = cbAtributo.getToolTipText();
                /** ee **/
                System.out.println(cbAtributo.getInputContext());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ModificarEvento");
        frame.setContentPane(new ModificarEvento().jModificarEvento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
