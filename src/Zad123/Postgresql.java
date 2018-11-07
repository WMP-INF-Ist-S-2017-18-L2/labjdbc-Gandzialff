package Zad123;

import java.sql.*;

public class Postgresql {
    static Connection connection;
    public static void connectpostgressql()
    {
        String url = "jdbc:postgresql://localhost:5432/BAZA_PRODUKTOW";
        String user = "postgres";
        String pass = "student";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error!Nie znaleziono sterownika PostgreSQL.");
            e.printStackTrace();
            System.exit(-1);
        }

        try{
            connection = DriverManager.getConnection(url,user,pass);
        }catch (SQLException ex)
        {
            System.err.println("ERROR!Nie nawiazano polaczenia z baza danych.");
            System.out.println(ex.getSQLState());
            System.exit(-1);

        }
        System.out.println("Nawiązano połączenie z baza danych");

        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("select * from \"produkty\" ");
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
