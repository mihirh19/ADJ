package exp_5;

import exp_4.ConnGui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Trans {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnGui.connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {

            con.setAutoCommit(false);

            String s = "insert into students(first_name, last_name) values(?, ?)";

            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1, "Mihir");
            ps.setString(2, "Hadavani");

            ps.executeUpdate();

            String sr = "delete from students where first_name = ?";
            PreparedStatement ps1 = con.prepareStatement(sr);
            ps1.setString(1, "Mihir");
            ps1.executeUpdate();

            con.commit();

        }catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
