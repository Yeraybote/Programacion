package Modelo.BD;

import Modelo.UML.Eventos;
import com.company.Main;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class EventosDAO {
    private static Connection con;

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

    public static void visualizarEvento (String n) throws Exception {
        /*
        Eventos ev = new Eventos();
        try {
        Statement sentencia = con.createStatement();
        String s = "select nombre,lugar,fecha,hinicio,hfin,npersonas from personas where nombre ='"+ n +"';";
        ResultSet resultado = sentencia.executeQuery(s);
        resultado.next();
        n = resultado.getString("nombre");
        String lugar = resultado.getString("lugar");
        LocalDate fecha = resultado.getDate("fecha");
        Time hini = resultado.getTime("hinicio");
        Time hfin = resultado.getTime("hfin");
        int npersonas = resultado.getInt("npersonas");
        ev.setNombre(n);
        ev.setLugar(lugar);
        ev.setFecha(fecha);
        ev.setHinicio(hini);
        ev.setHfin(hfin);
        ev.setNpersonas(npersonas);

        // 4. Cerrar
        con.close ();
        Main.error = false;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Error, vuelva a intentarlo");
    } catch (SQLException throwables) {
        JOptionPane.showMessageDialog(null,"Esa persona no existe");
            Main.error = true;
    } catch (Exception e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(null,"Error, has introducido un caracter alfanumerico en lugar de uno numerico");
            Main.error = true;
    }
        return ev; */
    }

    public void modificarEvento(Eventos ev) throws SQLException {
        Statement sentencia = con.createStatement ();
        String a = "ev.get" + Main.atributo;
        sentencia.executeUpdate ("UPDATE eventos SET " + Main.atributo + " = " + a + " WHERE nombre = '" + Main.nombev + "'");
    }

    public void eliminarEvento (String n) throws Exception {
        Statement sentencia = con.createStatement ();
        sentencia.executeUpdate ("DELETE FROM eventos WHERE nombre = '" + n + "'");
    }
}
