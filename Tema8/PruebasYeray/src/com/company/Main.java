package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String user = "daw12";
            String passwd = "daw12";
            Connection conn = DriverManager. getConnection (url ,user ,passwd);

            CallableStatement c = conn. prepareCall ("{call datos_emp12_scott (?)}");

            /* Me da el siguiente error:
            * Exception in thread "main" java.sql.SQLIntegrityConstraintViolationException: ORA-02290: restricción de control (DAW12.PRU_ASA_CK) violada
             */
            Statement sentencia = conn.createStatement ();
             String s = "insert into pruebas values ( 'Yeray','Bote',3333,'A')";
             sentencia.executeUpdate (s);

            // Parametro de salida ´
           c. registerOutParameter (1, oracle.jdbc.OracleTypes.CURSOR);
           c.execute ();
           ResultSet rs = ( ResultSet )c. getObject (1);
           while(rs.next ()){
               System.out.println(rs. getString (2) + "    " + rs. getString (3) + "    " + rs. getString (6) );
             }
           rs.close ();
           c.close ();
           conn.close ();
           } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }

    }
}