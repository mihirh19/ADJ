package com.example.javaee;

import java.sql.*;

public class MakeCon {
    private static Connection con;
    private MakeCon(){}
    public static void init() throws SQLException,ClassNotFoundException{
        con = getCon();
    }


    public static Connection getCon() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/adj","postgres","postgres");
    }

    public static ResultSet getRes(String q, String uname, String pwd) throws SQLException, ClassNotFoundException{
        init();
        PreparedStatement pstmt = con.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        pstmt.setString(1, uname);
        pstmt.setString(2, pwd);
        return pstmt.executeQuery();
    }
    public  static ResultSet getData(String q) throws SQLException{
        try {
            init();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Statement st = con.createStatement();
        return st.executeQuery(q);
    }
    public static boolean insert(String uname, String pwd){
        try{
            init();
            String q = "insert into users values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,uname);
            pstmt.setString(2,pwd);
            return pstmt.execute();
        }catch (Exception e){

        }
        return false;
    }

    public static void freeCon(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("removal")
    @Override
    public void finalize() throws Throwable
    {
        try { con.close(); }
        catch (SQLException e) {
            e.printStackTrace();
        }
        super.finalize();
        }




}
