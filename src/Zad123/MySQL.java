package Zad123;

import java.sql.*;

public class MySQL {
    static Connection connection;
    public static void connectMySQL()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/BAZA_PRODUKTOW?user=root&password=student&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "student";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error!Nie znaleziono sterownika MySQL.");
            e.printStackTrace();
            System.exit(-1);
        }

        try{
            connection = DriverManager.getConnection(url);
        }catch (SQLException ex)
        {
            System.err.println("ERROR!Nie nawiazano polaczenia z baza danych.");
            System.out.println(ex.getSQLState());
            System.exit(-1);

        }
        System.out.println("Nawiązano połączenie z baza danych");

        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("select * from produkty ");
            ResultSetMetaData meta = res.getMetaData();
            for(int i = 0; i<meta.getColumnCount();i++)
            {
                System.out.print(meta.getColumnName(i +1)+" ");
            }
            System.out.println();
            while (res.next())
            {
                for (int i=0;i<meta.getColumnCount();i++)
                {
                    System.out.print(res.getString(i+1) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("TABELA nie istnieje ");
        }
    }
}
