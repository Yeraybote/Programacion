package com.company;

import Modelo.BD.AsistentesDAO;
import Modelo.BD.EmpresaDAO;
import Modelo.BD.PersonaDAO;
import Vista.VentanaPrincipal;

import javax.swing.*;
import Vista.*;
import Modelo.UML.*;
import Modelo.BD.AcontecimientosDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    private static JFrame vp;
    private static Acontecimiento a;
    private static Persona p;
    private static Empresa e;
    private static ArrayList<Acontecimiento> listaAcontecimientos;
    private static JFrame va;

    private static AcontecimientosDAO adao;

    public static void main(String[] args) {
	   mostrarVentanaPrincipal();
       // Que la aplicación empieze por el main de la ventana
    }

    public static void mostrarVentanaPrincipal()
    {
        vp = new JFrame("VentanaPrincipal");
        vp.setContentPane(new VentanaPrincipal().getpPrincipal());
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vp.pack();
        vp.setVisible(true);
    }

    public static void mostrarInsertar()
    {
        // Mostrar el JDialog que permite introducir los datos de un evento
        DInsertar dialog = new DInsertar();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }

   public static void getDatosAcontecimiento(String n, String l, LocalDate f, LocalTime hi, LocalTime hf, int af) throws Exception
   {
       // Crear objeto y mandarlo a la base de datos
       a = new Acontecimiento(n,l,f,hi,hf,af);

       // Abrir, ejecutar y cerrar
       AcontecimientosDAO.alta(a);
   }

   public static String cancelarEvento(String nombre) throws Exception
   {
       // Primero consulta
       a = AcontecimientosDAO.consultarAcontecimiento(nombre);
       return a.toString();
   }

   public static void borrarAcontecimiento() throws Exception{
        AcontecimientosDAO.borrar(a);
   }

   public static void visualizarModificarEvento()
   {
       DModificacion dialog = new DModificacion();
       dialog.pack();
       dialog.setVisible(true);
   }

   public static ArrayList<String> datosLlenarCombo() throws Exception
   {
       listaAcontecimientos = AcontecimientosDAO.consultarAcontecimientos();
       // A la ventana van solo los nombres.
        ArrayList<String> nombres = new ArrayList<>();
        for(Acontecimiento a:listaAcontecimientos)
            nombres.add(a.getNombre());
        return nombres;
   }

   public static void getEventoSeleccionado(int i)
   {
       a = listaAcontecimientos.get(i);
   }

   public static String getLugar()
   {
       return a.getLugar();
   }

    public static String getFecha()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return a.getFecha().format(formato);
    }

    public static String getHoraInicio()
    {
        return a.getHoraI().toString();
    }

    public static String getHoraFin()
    {
        return a.getHoraF().toString();
    }

    public static String getAforo()
    {
        return a.getAforo().toString();
    }

    public static void getDatosActualizados(String l, LocalDate f, LocalTime hi, LocalTime hf, int af) throws Exception
    {
        // Modificar objetoy mandarlo a la base de datos
        a.setLugar(l);
        a.setFecha(f);
        a.setHoraI(hi);
        a.setHoraF(hf);
        a.setAforo(af);

        // Abrir, ejecutar y cerrar
        AcontecimientosDAO.actualizar(a);
    }

    public static void visualizarInscripcion(){
        va = new JFrame("VentanaAsistencia");
        va.setContentPane(new VentanaAsistencia().getpPrincipal());
        va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        va.setLocationRelativeTo(null);
        va.pack();
        va.setVisible(true);
    }

    public static ArrayList<String> datosLlenarComboInscripcion() throws Exception
    {
        listaAcontecimientos = AcontecimientosDAO.consultarAcontecimientosLibres();
        // A la ventana van solo los nombres.
        ArrayList<String> nombres = new ArrayList<>();
        for(Acontecimiento a:listaAcontecimientos)
            nombres.add(a.getNombre());
        return nombres;
    }

    public static boolean buscarPersona(String dni) throws Exception{
        // Hay una persona con ese dni?
        p = new Persona();
        p.setDni(dni);
        // Se puede pasar sólo el dni
        p = PersonaDAO.queryByDni(p);
        if (p != null)
            return true;
        return false;
    }

    public static String getNombreApellidos()
    {
        return p.getNombreApellidos();
    }

    public static String getTelefono()
    {
        return p.getTelefono();
    }

    public static String getEmail()
    {
        return p.getEmail();
    }

    public static String getNombreEmpresa()
    {
        return p.getE().getNombre();
    }

    public static String getDireccionEmpresa()
    {
        return p.getE().getDireccion();
    }

    public static void inscribir() throws Exception
    {
        // Inscribir a una persona que ya existe en un evento.
        // Relaciones
        a.setListaPersona(p);
        p.setlAcontecimiento(a);

        // A la base de datos
        AsistentesDAO.alta(a,p); // También se puede pasando solo un objeto.
    }

    public static void altaEInscripcion(String dni,String na,String t, String em, String ne, String de) throws Exception
    {
        e=new Empresa(ne,de);
        p=new Persona(dni,na,t,em,e);

        EmpresaDAO.alta(e);
        PersonaDAO.alta(p);

        inscribir();
    }

    public static void volverVP()
    {
        va.dispose();
    }
}
