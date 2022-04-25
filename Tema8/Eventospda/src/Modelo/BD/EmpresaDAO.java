package Modelo.BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Modelo.UML.Empresa;

public class EmpresaDAO {

    /* Clase que contiene los métodos necesarios para trabajar
       con la tabla de empresas  */

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;

    public static Empresa queryByNombre(String nombre) throws Exception{

        // Base de datos abierta???
        if (BaseDatos.getCon() == null)
            BaseDatos.abrirBD();

        plantilla = "select * from empresas where nombre = ?";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,nombre);
        resultado = sentenciaPre.executeQuery();
        // Doy por hecho que existe
        resultado.next();

        // Crear objeto
        Empresa e = new Empresa();
        e.setNombre(resultado.getString("nombre"));
        e.setDireccion(resultado.getString("direccion"));

        resultado.close();

        // cerrar ??
        return e;
    }

    public static void alta(Empresa e) throws Exception{
        try
        {
            BaseDatos.abrirBD();
            plantilla = "INSERT INTO empresas VALUES (?,?)";
            sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
            sentenciaPre.setString(1,e.getNombre());
            sentenciaPre.setString(2,e.getDireccion());

            sentenciaPre.executeUpdate();

            BaseDatos.cerrarBD();

        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex)
        {
            // La empresa existe, no es un problema
            // El resto de las excepciones si las relanzo
            BaseDatos.cerrarBD();
        }
    }
}
