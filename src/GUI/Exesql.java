package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import JDBC.ConnGui;
public class Exesql extends Frame {
    Choice c;
    Button b;
    TextArea l;
    Exesql(){
        setLayout(null);
        setVisible(true);
        setSize(300,300);
        c = new Choice();
        c.add("first_name");
        c.add("last_name");
        c.add("city");
        l = new TextArea("Nothing");
        b = new Button("Execute");
        c.setBounds(30,80,100,100);
        b.setBounds(160,80,50,20);
        l.setBounds(20, 150,500,100);
        add(c);
        add(b);
        add(l);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    Connection con = ConnGui.connect();

                    Statement st = con.createStatement();
                    String sr = "select " +c.getItem(c.getSelectedIndex()) + " from students";
                    ResultSet rs = st.executeQuery(sr);
                    String res = "";
                    while (rs.next()){
                         res = res.concat(rs.getString(1) + "\n");
                    }
                    l.setText(res);


                }catch (Exception er){
                    System.out.println(er);
                }


            }
        });

    }

    public static void main(String[] args) {
        new Exesql();
    }
}
