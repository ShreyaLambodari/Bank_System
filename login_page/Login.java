package Bank_sys_project.login_page;
import Bank_sys_project.Sign_up.Sign_up;
import Bank_sys_project.Sign_up2.Sign_up2;
import Bank_sys_project.Sign_up3.Sign_up3;
import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.Connection_.Connection_;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.net.URL;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;


public class Login extends JFrame implements ActionListener{
    JButton sign_in, clear, sign_up;
    JTextField box_1;
    JPasswordField box_2;
    JLabel pin, card_no;
    Login() throws Exception{
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);
        setLayout(null);
        setTitle("Bank Login");
        URL url = new URL("https://t4.ftcdn.net/jpg/00/61/06/27/360_F_61062796_NF87GPnWV0fQ2LhoYNlyjev0PocRwZj9.jpg");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label_1 = new JLabel(i3);
        add(label_1);
        label_1.setBounds(250, 40, 100, 100);
        JLabel label_2 = new JLabel(i3);
        add(label_2);
        label_2.setBounds(1200, 40, 100, 100);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("Welcome to Bank");
        add(text);
        text.setBounds(400, 42, 800, 90);
        text.setFont(new Font("Osward", Font.BOLD, 90));

        card_no = new JLabel("Card Number: ");
        add(card_no);
        card_no.setBounds(400, 344, 250, 70);
        card_no.setFont(new Font("Raleway", Font.BOLD, 35));

        box_1 = new JTextField();
        box_1.setBounds(700, 350, 300, 50);
        box_1.setFont(new Font("Arial", Font.BOLD, 19));
        add(box_1);

        pin = new JLabel("Pin: ");
        add(pin);
        pin.setBounds(400, 444, 250, 70);
        pin.setFont(new Font("Raleway", Font.BOLD, 35));

        box_2 = new JPasswordField();
        box_2.setFont(new Font("Arial", Font.BOLD, 19));
        box_2.setBounds(700, 450, 300, 50);
        add(box_2);

        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(550, 550, 200, 40);
        add(sign_in);
        sign_in.setBackground(Color.DARK_GRAY);
        sign_in.setForeground(Color.WHITE);
        sign_in.addActionListener(this);   

        clear = new JButton("CLEAR");
        clear.setBounds(800, 550, 200, 40);
        add(clear);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(550, 650, 450, 40);
        sign_up.setBackground(Color.DARK_GRAY);
        sign_up.setForeground(Color.WHITE);
        add(sign_up);
        sign_up.addActionListener(this);
    }
    @Override
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource()==sign_in){
            Connection_ c1 = new Connection_();
            String cardnumber = box_1.getText();
            String pinnumber = box_2.getText();
            String q = "(select * from signup3 where applicant_c_number = '"+cardnumber+"' and applicant_p_number = '"+pinnumber+"')";
            try {
                c1.s.executeUpdate(q);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
               ResultSet r =c1.s.executeQuery(q);
               if (((ResultSet) r).next()) {
                   setVisible(false); 
                   new Transaction(pinnumber).setVisible(true);               
               }else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            }catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource()==clear){
            box_1.setText("");
            box_2.setText("");
        }
        else{
            setVisible(false);
            try {
                new Sign_up().setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }



    public static void main(String[] args){
        try {
            new Login();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
