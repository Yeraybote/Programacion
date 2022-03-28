package Modelo.BD;

import java.sql.Connection;

public class PersonasDAO {
    private static Connection con;

    public PersonasDAO(Connection con)
    {
        this.con = con;
    }

}
