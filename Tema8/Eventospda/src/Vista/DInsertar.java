package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DInsertar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraInicio;
    private JTextField tfHoraFin;
    private JTextField tfAforo;
    private JLabel lTitulo;

    public DInsertar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tfFecha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfFecha.setText("");
            }
        });
        tfHoraInicio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfHoraInicio.setText("");
            }
        });
        tfHoraFin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfHoraFin.setText("");
            }
        });
    }

    private void onOK() {
        // Validar datos de entrada y enviar al controlador.
        try
        {
            validarNombre();
            validarLugar();
            validarFecha();
            validarHoras();
            validarAforo();
            Main.getDatosAcontecimiento(tfNombre.getText(),tfLugar.getText(),fecha,horaI,horaF,aforo);
            JOptionPane.showMessageDialog(null,"Acontecimiento insertado");
            dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /***************** Validaciones ***************/
    // Variables glogales para no hacer dos veces la conversión
    private LocalDate fecha;
    private LocalTime horaI;
    private LocalTime horaF;
    private int aforo;

    public void validarNombre() throws Exception
    {
        if (tfNombre.getText().isEmpty())
            throw new Exception("El nombre es un dato obligatorio");
        // Expresión regular para comprobar letras
    }

    public void validarLugar() throws Exception
    {
        if (tfLugar.getText().isEmpty())
            throw new Exception("El lugar es un dato obligatorio");
        // Expresión regular para comprobar letras
    }
    public void validarFecha() throws Exception
    {
        if (tfFecha.getText().isEmpty())
            throw new Exception("La fecha del acontecimiento es un dato obligatorio");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = LocalDate.parse(tfFecha.getText(), formato);
        if (fecha.compareTo(LocalDate.now())<=0)
            throw new Exception("La fecha no puede ser anterior al día de hoy");
    }
    public void validarHoras() throws Exception
    {
        if (tfHoraInicio.getText().isEmpty())
            throw new Exception("La hora de inicio del acontecimiento es un dato obligatorio");
        if (tfHoraFin.getText().isEmpty())
            throw new Exception("La hora de finalización del acontecimiento es un dato obligatorio");
        // La hora de finalización tiene que ser mayor que la del inicio
        horaF = LocalTime.parse(tfHoraFin.getText());
        horaI = LocalTime.parse(tfHoraInicio.getText());

        if (horaF.compareTo(horaI)<=0)
            throw new Exception("Horas no validas");
    }

    public void validarAforo() throws Exception
    {
        if (tfAforo.getText().isEmpty())
            throw new Exception("El aforo del acontecimeinto es un dato obligatorio");
        aforo = Integer.parseInt(tfAforo.getText());
        if (aforo <= 0)
            throw new NumberFormatException();
    }

    /************ Fin validaciones ************/

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DInsertar dialog = new DInsertar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
