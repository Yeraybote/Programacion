package Modelo.BD;

import java.sql.Connection;

public class EmpresasDAO {
    private static Connection con;

    public EmpresasDAO(Connection con)
    {
        this.con = con;
    }

}
