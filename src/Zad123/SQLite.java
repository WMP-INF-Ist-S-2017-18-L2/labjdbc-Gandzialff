package Zad123;

import java.sql.*;

public class SQLite {
    static Connection connection;

    public static void connectSQLlite()
    {

        String url = "jdbc:sqlite:BAZA_PRODUKTOW.db3";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Error!Nie znaleziono sterownika SQLite.");
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
