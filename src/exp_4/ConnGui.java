package exp_4;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnGui {
    public static Connection connect() throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adj", "postgres", "postgres");
        return con;
    }
}
