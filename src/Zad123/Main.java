package Zad123;

public class Main {



    public static void main(String[] args)  {
        System.out.println("=====PostgreSQL=====");
        Postgresql.connectpostgressql();
        System.out.println("=====MySQL=====");
        MySQL.connectMySQL();
        System.out.println("=====SQLite=====");
        SQLite.connectSQLlite();

    }
}
