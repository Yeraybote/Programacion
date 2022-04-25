package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DModificacion extends JDialog {
    private JPanel pPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pBotones;
    private JPanel pCajas;
    private JPanel pTitulo;
    private JPanel pCabecera;
    private JComboBox cbNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraInicio;
    private JTextField tfHoraFin;
    private JTextField tfAforo;


    public DModificacion(){
        setContentPane(pPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        try
        {
            ArrayList<String> nombres = Main.datosLlenarCombo();
            for(String n:nombres)
                cbNombre.addItem(n);
            cbNombre.setSelectedIndex(-1);
        }
        catch(Exception e)
        {
            System.out.println("Problemas llenando la combo");
        }



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
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        cbNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getEventoSeleccionado(cbNombre.getSelectedIndex());

                // Mostrar datos.
                tfLugar.setText(Main.getLugar());
                tfFecha.setText(Main.getFecha());
                tfHoraInicio.setText(Main.getHoraInicio());
                tfHoraFin.setText(Main.getHoraFin());
                tfAforo.setText(Main.getAforo());
            }
        });
    }

    private void onOK() {
        // Validar datos de entrada y enviar al controlador.
        try
        {
            validarLugar();
            validarFecha();
            validarHoras();
            validarAforo();
            Main.getDatosActualizados(tfLugar.getText(),fecha,horaI,horaF,aforo);
            JOptionPane.showMessageDialog(null,"Acontecimiento modificado");
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

}
