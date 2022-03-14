package Vista;

import Modelo.UML.Eventos;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrearEvento {
    public JPanel jCrearEvento;
    private JLabel jTItulo;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHinicio;
    private JTextField tfHfin;
    private JLabel jNombre;
    private JLabel lLugar;
    private JLabel lFecha;
    private JLabel lHinicio;
    private JLabel lHfin;
    private JTextField tfNpersonas;
    private JLabel lNpersonas;
    private JButton bVaciar;
    private JButton bGuardar;

    public CrearEvento() {
        bVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tfNombre.setText("");
                tfFecha.setText("");
                tfHfin.setText("");
                tfHinicio.setText("");
                tfNpersonas.setText("");
                tfLugar.setText("");
            }
        });
        bGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (tfNombre.getText().isEmpty() || tfLugar.getText().isEmpty() || tfFecha.getText().isEmpty() ||
                            tfHinicio.getText().isEmpty() || tfHfin.getText().isEmpty() || tfNpersonas.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Rellene todos los campos");
                    } else {
                        // Creación de objeto:
                        java.sql.Time hinicio = Main.pasarStringTime(tfHinicio.getText());
                        java.sql.Time hfin = Main.pasarStringTime(tfHfin.getText());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(tfFecha.getText(),formatter);
                        int npersonas = Integer.parseInt(tfNpersonas.getText());
                        Eventos evento = new Eventos(tfNombre.getText(),tfLugar.getText(),fecha,hinicio,hfin,npersonas);
                        Main.insertarDatos(evento);
                        if (Main.error) {
                            JOptionPane.showMessageDialog(null,"Evento creado correctamente");
                            tfNombre.setText("");
                            tfLugar.setText("");
                            tfFecha.setText("");
                            tfHinicio.setText("");
                            tfHfin.setText("");
                            tfNpersonas.setText("");
                        }
                    }
                } catch (HeadlessException | ParseException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CrearEvento");
        frame.setContentPane(new CrearEvento().jCrearEvento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
