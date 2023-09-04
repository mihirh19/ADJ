package exp_4;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurdGui extends Frame {
    Choice c;
    Button b;
    TextField first_name;
    Label first;
    Label last;
    TextField last_name;
    TextField new_first_name;
    Label new_name;
    TextArea su;
    CurdGui(){
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        c = new Choice();
        c.add("");
        c.add("Insert");
        c.add("Delete");
        c.add("update");
        c.add("select");
        c.setBounds(80,80,100,100);
        b = new Button("Execute");
        b.setBounds(200,80,50,50);
        add(b);
        add(c);
        first_name = new TextField();
        last_name = new TextField();
        first_name.setBounds(100,150,200,30);
        add(first_name);
        first = new Label("first_name");
        last = new Label("last_name");
        add(first);
        first.setBounds(40,150,60,30);
        last_name.setBounds(100,200,200,30);
        add(last_name);
        last.setBounds(40,200,60,30);
        add(last);
        new_name = new Label("New first name");
        new_name.setBounds(20,250,60,30);
        new_first_name = new TextField();
        new_first_name.setBounds(100,250,200,30);
        add(new_first_name);
        add(new_name);
        su = new TextArea();
        su.setBounds(100,300,200,200);
        add(su);

        c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (c.getItem(c.getSelectedIndex()).equals("select")){
                    first.setVisible(false);
                    first_name.setVisible(false);
                    last.setVisible(false);
                    last_name.setVisible(false);
                    new_name.setVisible(false);
                    new_first_name.setVisible(false);
                    su.setVisible(true);
                }
                if (c.getItem(c.getSelectedIndex()).equals("Insert")){
                    first.setVisible(true);
                    first_name.setVisible(true);
                    last.setVisible(true);
                    last_name.setVisible(true);
                    new_name.setVisible(false);
                    new_first_name.setVisible(false);
                    su.setVisible(true);
                }
                if (c.getItem(c.getSelectedIndex()).equals("Delete")){
                    first.setVisible(true);
                    first_name.setVisible(true);
                    last.setVisible(false);
                    last_name.setVisible(false);
                    new_name.setVisible(false);
                    new_first_name.setVisible(false);
                    su.setVisible(true);
                }
                if (c.getItem(c.getSelectedIndex()).equals("update")){
                    first.setVisible(true);
                    first_name.setVisible(true);
                    last.setVisible(false);
                    last_name.setVisible(false);
                    new_name.setVisible(true);
                    new_first_name.setVisible(true);
                    su.setVisible(true);
                }

            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();

            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    Connection con = ConnGui.connect();
                    if (c.getItem(c.getSelectedIndex()).equals("Insert")){
                        String que = "insert into students(first_name, last_name) values(?,?)";
                        PreparedStatement pt= con.prepareStatement(que);
                        pt.setString(1,first_name.getText());
                        pt.setString(2,last_name.getText());
                        int a = pt.executeUpdate();
                    }
                    if (c.getItem(c.getSelectedIndex()).equals("select")){
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from students");
                        String res = "";
                        while (rs.next()){
                            res = res.concat(rs.getString(1) + "      "  + rs.getString(2) + "\n");

                        }
                        su.setText(res);
                        st.close();
                    }
                    if (c.getItem(c.getSelectedIndex()).equals("update")){
                        String que = "update students set first_name=? where first_name=?";
                        PreparedStatement pt= con.prepareStatement(que);
                        pt.setString(1,new_first_name.getText());
                        pt.setString(2,first_name.getText());
                        pt.executeUpdate();
                        pt.close();
                    }
                    if (c.getItem(c.getSelectedIndex()).equals("Delete")){
                        String sq  = "delete from students where first_name = ?";
                        PreparedStatement pt = con.prepareStatement(sq);
                        pt.setString(1, first_name.getText());
                        pt.executeUpdate();
                        pt.close();

                    }


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        new CurdGui();
    }
}
