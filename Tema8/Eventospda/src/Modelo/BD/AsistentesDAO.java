package Modelo.BD;

import Modelo.UML.Acontecimiento;
import Modelo.UML.Persona;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AsistentesDAO {

     /* Clase que contiene los métodos necesarios para trabajar
       con la tabla de asistencia (relación acontecimiento y persona)  */

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;

    public static int getNumeroAsistentes(String nombre) throws Exception
    {
        // No abro la conexión porque  vengo de AcontecimientosDAO

        // opcion dos: if (BaseDatos.getCon() == null) Si llamo desde varios lugares

        plantilla = "select count(*) from asistencia where nombre_acon = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,nombre);
        resultado = sentenciaPre.executeQuery();
        // Sin if y sin while. Doy por hecho que tengo una fila resultado de la consulta, aunque sea con un cero
        resultado.next();
        int numero = resultado.getInt(1);
        resultado.close();

        // cerrar conexión ??
        return numero;
    }

    public static void alta(Acontecimiento ac, Persona p) throws Exception
    {
        try
        {
            BaseDatos.abrirBD();
            plantilla = "insert into asistencia values(?,?)";
            sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
            // Se está apuntando al último del arraylist
            sentenciaPre.setString(1,p.getDni());
            sentenciaPre.setString(2,ac.getNombre());

            int n = sentenciaPre.executeUpdate();
            BaseDatos.cerrarBD();
            if (n != 1)
                throw new Exception("Insert de asistentes");
        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex)
        {
           throw new Exception("Ya estás inscrito");
        }
    }
}
