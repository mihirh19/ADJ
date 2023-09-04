/*
 * Created by JFormDesigner on Thu Jul 20 17:04:35 IST 2023
 */

package GUI;

import exp_4.ConnGui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author Mihir
 */
public class CurdJdbc extends JFrame {
    public CurdJdbc() {
        initComponents();
    }

    private void thisWindowClosed(WindowEvent e) {
        System.exit(0);
    }

    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
        dispose();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getItem().equals("select")){
            label1.setVisible(false);
            label2.setVisible(false);
            textField1.setVisible(false);
            textField2.setVisible(false);
            label3.setVisible(false);
            textField3.setVisible(false);
        }
        if (e.getItem().equals("insert")){
            label1.setVisible(true);
            label2.setVisible(true);
            textField1.setVisible(true);
            textField2.setVisible(true);
            textField3.setVisible(false);
            label3.setVisible(false);
        }
        if (e.getItem().equals("update")){
            label1.setVisible(true);
            label2.setVisible(false);
            textField1.setVisible(true);
            textField2.setVisible(false);
            label3.setVisible(true);
            textField3.setVisible(true);

        }
        if (e.getItem().equals("delete")){
            label1.setVisible(true);
            label2.setVisible(false);
            textField1.setVisible(true);
            textField2.setVisible(false);
            label3.setVisible(false);
            textField3.setVisible(false);

        }
    }

    private void button1(ActionEvent e) {
        Connection con = null;
        try {
            con = ConnGui.connect();
            if (comboBox1.getItemAt(comboBox1.getSelectedIndex()).equals("select")){


                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select first_name, last_name from students");
                String res = "";
                while (rs.next()){
                    res  = res.concat(rs.getString(1) + "         " + rs.getString(2) + "\n");

                }
                textArea1.setText(res);
                st.close();
                con.close();
            }
            if (comboBox1.getItemAt(comboBox1.getSelectedIndex()).equals("insert")){
                String que = "insert into students(first_name, last_name) values(?,?)";
                PreparedStatement pt= con.prepareStatement(que);
                pt.setString(1,textField1.getText());
                pt.setString(2,textField2.getText());
                int a = pt.executeUpdate();
            }
            if (comboBox1.getItemAt(comboBox1.getSelectedIndex()).equals("update")){
                String que = "update students set first_name=? where first_name=?";
                PreparedStatement pt= con.prepareStatement(que);
                pt.setString(1,textField3.getText());
                pt.setString(2,textField1.getText());
                pt.executeUpdate();
                pt.close();
            }
            if (comboBox1.getItemAt(comboBox1.getSelectedIndex()).equals("delete")){
                String sq  = "delete from students where first_name = ?";
                PreparedStatement pt = con.prepareStatement(sq);
                pt.setString(1, textField1.getText());
                pt.executeUpdate();
                pt.close();

            }
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        textField1 = new JTextField();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 275, 520, 125);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "insert",
            "delete",
            "update",
            "select"
        }));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        contentPane.add(comboBox1);
        comboBox1.setBounds(40, 15, 131, comboBox1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Execute");
        button1.setBackground(UIManager.getColor("Button.darkShadow"));
        button1.setForeground(new Color(0xff3333));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(280, 15, 128, 42);

        //---- label1 ----
        label1.setText("First_name");
        contentPane.add(label1);
        label1.setBounds(40, 80, label1.getPreferredSize().width, 36);

        //---- label2 ----
        label2.setText("Last_name");
        contentPane.add(label2);
        label2.setBounds(40, 180, 72, 36);
        contentPane.add(textField2);
        textField2.setBounds(185, 180, 207, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("New_first_name");
        contentPane.add(label3);
        label3.setBounds(30, 130, 120, 35);
        contentPane.add(textField3);
        textField3.setBounds(195, 135, 195, textField3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(195, 85, 207, textField1.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        new CurdJdbc();
    }
}
