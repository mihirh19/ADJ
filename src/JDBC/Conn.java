package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");

            System.out.println("Connected successfully");

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select * from customers");

            while (res.next()) {
                System.out.println(res.getString("cname"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
