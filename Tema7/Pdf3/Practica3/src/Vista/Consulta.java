package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consulta {
    public JPanel jConsulta;
    private JToolBar tbMenu;
    private JButton bResumen;
    private JButton bTarjetas;
    private JButton bInversiones;
    private JButton bMercados;
    private JButton bPrestamos;
    private JButton bSeguros;
    private JButton bServicios;
    private JButton bCuentas;
    private JLabel lTituloMov;
    private JRadioButton rbC1;
    private JRadioButton rbC2;
    private JPanel jCuentas;
    private JPanel jMovimientos;
    private JLabel lMovimientos;
    private JLabel lCliente;

    public Consulta() {
        bCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lCliente.setText(Main.aClientes.get(Main.posicionCliente).getNombreApellidos());
                jCuentas.setVisible(true);
                jMovimientos.setVisible(true);
                rbC1.setText(String.valueOf(Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(0).getNumero()));
                rbC1.setText(String.valueOf(Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(1).getNumero()));
            }
        });
        rbC1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lMovimientos.setText("");
                for (int x = 0; x < Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(0).getListaMovimientos().size(); x++) {
                    lMovimientos.setText(lMovimientos.getText() + Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(0).getListaMovimientos().get(x).getFecha()
                            + " " + Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(0).getListaMovimientos().get(x).getDescripcion()
                            + " " + Main.aClientes.get(Main.posicionCliente).getListaCuentas().get(0).getListaMovimientos().get(x).getImporte());
                }
            }
        });
        rbC2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Consulta");
        frame.setContentPane(new Consulta().jConsulta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
