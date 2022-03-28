package Modelo.BD;

import java.sql.Connection;

public class AsistenciasDAO {
    private static Connection con;

    public AsistenciasDAO(Connection con)
    {
        this.con = con;
    }

}
