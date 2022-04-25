package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaAsistencia {
    private JPanel pPrincipal;
    private JPanel pEvento;
    private JPanel pEmpresa;
    private JPanel pPersona;
    private JPanel pBotones;
    private JButton bAceptar;
    private JButton bCancelar;
    private JComboBox cbEventos;
    private JLabel lFecha;
    private JLabel lHora;
    private JTextField tfDni;
    private JTextField tfNombreApellidos;
    private JTextField tfTelefono;
    private JTextField tfEmail;
    private JTextField tfNombreEmpresa;
    private JTextField tfDireccionEmpresa;

    private boolean encontrada;

    public VentanaAsistencia() {

        // LLenar la combo con eventos validos (fecha y aforo)
        try
        {
            ArrayList<String> nombres = Main.datosLlenarComboInscripcion();
            for(String n:nombres)
                cbEventos.addItem(n);
            cbEventos.setSelectedIndex(-1);
        }
        catch(Exception e)
        {
            System.out.println("Problemas llenando la combo");
        }

        cbEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getEventoSeleccionado(cbEventos.getSelectedIndex());
                lFecha.setText(Main.getFecha());
                lHora.setText(Main.getHoraInicio());
            }
        });
        tfDni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               validarBuscarDni();

            }
        });


        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (encontrada)
                        Main.inscribir();
                    else {

                        validarDatosPersona();
                        validarDatosEmpresa();
                        Main.altaEInscripcion(tfDni.getText(),tfNombreApellidos.getText(),tfTelefono.getText(),tfEmail.getText(),tfNombreEmpresa.getText(),tfDireccionEmpresa.getText());
                    }
                    JOptionPane.showMessageDialog(null,"Persona inscrita");
                    Main.volverVP();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.volverVP();
            }
        });
    }

    public void validarBuscarDni()
    {
        try
        {
           validarDni();

            // Con el dni correcto mirar si ya existe la persona.
            encontrada = Main.buscarPersona(tfDni.getText());
            if (encontrada){
                // No es la primera vez que esta persona se inscribe en un evento
                mostrarDatos();
            }
           // else tiene que escribir los datos
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void validarDni() throws Exception{
        // Validar dni
        if (tfDni.getText().isEmpty())
            throw new Exception("El dni es un dato obligatorio");

        Pattern pat = Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher mat = pat.matcher(tfDni.getText());

        if (!mat.matches())
            throw new Exception("Dni no valido");

        Character[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = Integer.parseInt(tfDni.getText().substring(0, 8)) % 23;
        if (tfDni.getText().charAt(8)!=asignacionLetra[resto])
            throw new Exception("Dni no valido");
    }
    public void validarDatosPersona() throws Exception{
        validarDni();
        // nombre y apellidos
        if (tfNombreApellidos.getText().isEmpty())
            throw new Exception("El nombre de la persona es un dato obligatorio");
        // Considero que debe tener un mínimo de 3 caracteres. 50 es el máximo establecido en la base de datos.
        if (tfNombreApellidos.getText().length()< 3 || tfNombreApellidos.getText().length() > 100 )
            throw new Exception(" Nombre no valido");

        Pattern pat = Pattern.compile("^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})+$");
        Matcher mat = pat.matcher(tfNombreApellidos.getText());
        if (!mat.matches())
            throw new Exception("Nombre no valido");

        // telefono
        if (tfTelefono.getText().isEmpty())
            throw new Exception("El teléfono es un dato obligatorio");
        pat = Pattern.compile("^[6789][0-9]{8}$");
        mat = pat.matcher(tfTelefono.getText());

        if (!mat.matches())
            throw new Exception("Teléfono no valido");

        // email
        if (tfEmail.getText().isEmpty())
            throw new Exception("El correo es un dato obligatorio");
        pat = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        mat = pat.matcher(tfEmail.getText());

        if (!mat.matches())
            throw new Exception("Email no valido");
    }
    public void validarDatosEmpresa() throws Exception{
        // Nombre
        if (tfNombreEmpresa.getText().isEmpty())
            throw new Exception("El nombre de la empresa es un dato obligatorio");

        Pattern pat = Pattern.compile("^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})*$");
        Matcher mat = pat.matcher(tfNombreApellidos.getText());
        if (!mat.matches())
            throw new Exception("Nombre de empresa no valido");
        // Dirección
        if (tfDireccionEmpresa.getText().isEmpty())
            throw new Exception("La dirección es un dato obligatorio");

        pat = Pattern.compile("^[A-Z][a-z]{2,}([ ][A-Z][a-z]{2,})*$");
        mat = pat.matcher(tfNombreApellidos.getText());
        if (!mat.matches())
            throw new Exception("Dirección no válida");

    }

    public void mostrarDatos()
    {
        tfNombreApellidos.setText(Main.getNombreApellidos());
        tfTelefono.setText(Main.getTelefono());
        tfEmail.setText(Main.getEmail());

        // Datos de la empresa
        tfNombreEmpresa.setText(Main.getNombreEmpresa());
        tfDireccionEmpresa.setText(Main.getDireccionEmpresa());
        bAceptar.requestFocus();

        // deshabilitar??
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaAsistencia");
        frame.setContentPane(new VentanaAsistencia().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
