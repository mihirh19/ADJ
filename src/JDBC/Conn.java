package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            System.out.println("Connected successfully");


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
