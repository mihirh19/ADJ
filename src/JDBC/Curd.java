package JDBC;
import JDBC.ConnGui;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;

public class Curd {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = ConnGui.connect();
            Statement st = con.createStatement();
            System.out.println("Select the options :");
            System.out.println("1 . select\n 2.insert \n 3.update \n 4.delete");
            int n = sc.nextInt();

            if (n==1){
                ResultSet rs = st.executeQuery("select * from students");
                while (rs.next()){
                    System.out.println(rs.getString(1) + "      "  + rs.getString(2)  + "        " + rs.getLong(3) + "      " + rs.getString(4));

                }
            } else if (n==2) {
                String que = "insert into students(first_name, last_name, mobile_no, city) values(?,?,?,?)";
                PreparedStatement pt= con.prepareStatement(que);
                System.out.println("Enter the first name :");
                String firstName = sc.next();
                System.out.println("Enter the last name :");
                String lastName =sc.next();
                System.out.println("Enter the city :");
                String city = sc.next();
                System.out.println("Enter the phone number :");
                int phoneNumber = sc.nextInt();
                pt.setString(1,firstName);
                pt.setString(2,lastName);
                pt.setInt(3,phoneNumber);
                pt.setString(4,city);
                int a = pt.executeUpdate();
            } else if (n==3) {
                
            }

            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
