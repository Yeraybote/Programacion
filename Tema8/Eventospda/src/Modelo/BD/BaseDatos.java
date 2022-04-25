package Modelo.BD;

import java.sql.*;

public class BaseDatos {

    private static Connection con;

    public static void abrirBD() throws Exception
    {
        // setCon también es un buen nombre para este método
        // En el constructor como en el ejercicio anterior
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3307/"+"bdacontecimientos";
        con = DriverManager.getConnection(url,"root","usbw");
    }

    public static void cerrarBD() throws Exception
    {
        con.close();
    }

    public static Connection getCon()
    {
        return con;
    }
}
