package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.Main;

public class VentanaPrincipal{
    private JPanel pPrincipal;
    private JPanel pMenuBarra;
    private JPanel pImagen;
    private JMenu mAcontecimientos;
    private JMenuItem mInsertar;
    private JButton bInsertar;
    private JButton button1;
    private JButton bCancelar;
    private JMenuItem mCancelar;
    private JButton bModificar;
    private JMenuItem mModificar;
    private JMenu mInscripciones;
    private JMenuItem mNueva;
    private JButton bInscripcion;
    private JMenuItem mConsultar;

    public VentanaPrincipal() {
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarInsertar();
            }
        });

        mInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarInsertar();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String nombre = JOptionPane.showInputDialog(null, "Teclea el nombre del evento que quieres cancelar");
                    validarNombre(nombre);
                    String datos = Main.cancelarEvento(nombre);
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar de forma definitiva el evento " + datos);
                    if (respuesta == 0) {
                        Main.borrarAcontecimiento();
                        JOptionPane.showMessageDialog(null, "Evento cancelado");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        mCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bCancelar.doClick();
            }
        });

        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.visualizarModificarEvento();
            }
        });
        mModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.visualizarModificarEvento();
            }
        });
        bInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.visualizarInscripcion();
            }
        });
    }

    public void validarNombre(String n) throws Exception
    {
        if (n.isEmpty())
            throw new Exception("El nombre es un dato obligatorio");
        // Expresión regular para comprobar letras
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }



}
