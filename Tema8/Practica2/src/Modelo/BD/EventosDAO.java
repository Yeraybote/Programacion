package Modelo.BD;

import Modelo.UML.Eventos;
import com.company.Main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EventosDAO {
    private Connection con;

    public EventosDAO(Connection con)
    {
        this.con = con;
    }

    public void registrarEvento(Eventos e) throws Exception
    {
        String plantilla = "INSERT INTO eventos VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, e.getNombre());
        ps.setString(2,e.getLugar());
        ps.setDate(3, Date.valueOf(e.getFecha()));
        ps.setTime(4,e.getHinicio());
        ps.setTime(5,e.getHfin());
        ps.setInt(6,e.getNpersonas());
        int n = ps.executeUpdate();
        if (n != 1)
            throw new Exception("El número de filas actualizadas no es uno");
    }

    public void eliminarEvento (String n) throws Exception {
        Statement sentencia = con.createStatement ();
        sentencia.executeUpdate ("DELETE FROM eventos WHERE nombre = '" + n + "'");
    }
}
