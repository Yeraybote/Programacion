package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    //Parametros de conexion
    private String login = "root";
    private String password = "usbw";
    private String url = "jdbc:mysql://localhost:3307/yeray";

    private Connection connection;

    public BaseDatos() throws Exception{
        //obtenemos el driver para mysql
        Class.forName("com.mysql.cj.jdbc.Driver");

        //obtenemos la conexión
        connection = DriverManager.getConnection(url,login,password);

        if (connection==null){
            throw new Exception("Problemas con la conexión");
        }
    }


    public Connection getConnection(){
        return connection;
    }

    public void desconectar() throws Exception{
        connection.close();
    }
}
