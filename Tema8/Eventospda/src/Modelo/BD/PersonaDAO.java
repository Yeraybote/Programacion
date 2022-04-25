package Modelo.BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Modelo.UML.Persona;

public class PersonaDAO {

      /* Clase que contiene los métodos necesarios para trabajar
       con la tabla de personas  */

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;

    public static Persona queryByDni(Persona p) throws Exception{

        // con recibir el dni también es suficiente.
        BaseDatos.abrirBD();

        plantilla = "select * from personas where dni = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,p.getDni());
        resultado = sentenciaPre.executeQuery();

        if (resultado.next())
        {
            llenarObjeto(p);
        }
        else
            p =  null;

        resultado.close();
        BaseDatos.cerrarBD();
        return p;
    }

    public static void llenarObjeto(Persona p) throws Exception
    {
        // Completo el objeto recibido.
        // También se puede crear uno nuevo
        p.setNombreApellidos(resultado.getString("nombre_apellidos"));
        p.setTelefono(resultado.getString("telefono"));
        p.setEmail(resultado.getString("email"));
        // Relación Persona Empresa
        p.setE(EmpresaDAO.queryByNombre(resultado.getString("empresa")));
        // La lista de sus eventos no me interesa siempre
    }

    public static void alta(Persona p) throws Exception
    {
        BaseDatos.abrirBD();

        plantilla = "insert into personas values (?,?,?,?,?)";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,p.getDni());
        sentenciaPre.setString(2,p.getNombreApellidos());
        sentenciaPre.setString(3,p.getTelefono());
        sentenciaPre.setString(4,p.getEmail());

        sentenciaPre.setString(5,p.getE().getNombre());
        int n=sentenciaPre.executeUpdate();

        BaseDatos.cerrarBD();

        if (n != 1)
            throw new Exception("Fallo al insertar persona");

    }
}
