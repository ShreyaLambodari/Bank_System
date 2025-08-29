package Bank_sys_project.login_page;
import Bank_sys_project.Forgot_Password.Forgot_Password;
import Bank_sys_project.Sign_up.Sign_up;
// import Bank_sys_project.Sign_up2.Sign_up2;
// import Bank_sys_project.Sign_up3.Sign_up3;
import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.src.Connection_.*;

import java.sql.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.net.URL;

// import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

// import com.mysql.cj.protocol.Resultset;


public class Login extends JFrame implements ActionListener{
    JButton sign_in, clear, sign_up;
    JTextField box_1;
    JPasswordField box_2;
    JLabel pin, card_no ;
    JButton  forgot_password;
    /**
     * @throws Exception
     */
    Login() throws Exception{
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);
        setLayout(null);
        setTitle("Bank Login");
        

        JPanel bg = new JPanel(){
             //JPanel class in java
        //paintComponent method which needs to be overridden
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            // here graphics is a basic class which we can explicitly typecast to Graphics2D-->> advanced drawing features
            Graphics2D g2 = (Graphics2D) g;
            Color mycolor = new Color(195, 228, 242);
             g2.setColor(mycolor);
            // next set size of this rounded rectangle
            g2.fillRoundRect(550,210,getWidth()-1090, getHeight()-300, 30,30);
            g2.setColor(Color.WHITE);
            g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,30,30);
            
            }
        };
        bg.setBounds(600,600,400,700);
        bg.setOpaque(true);
        bg.setLayout(null);
        add(bg);
        setContentPane(bg);
        getContentPane().setBackground(Color.WHITE);
        
        URL url = new URL("https://t4.ftcdn.net/jpg/00/61/06/27/360_F_61062796_NF87GPnWV0fQ2LhoYNlyjev0PocRwZj9.jpg");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label_1 = new JLabel(i3);
        bg.add(label_1);
        label_1.setBounds(250, 40, 100, 100);
        JLabel label_2 = new JLabel(i3);
        bg.add(label_2);
        label_2.setBounds(1200, 40, 100, 100);
        
        JLabel text = new JLabel("Welcome to Bank");
        bg.add(text);
        text.setBounds(400, 42, 800, 90);
        text.setFont(new Font("Osward", Font.BOLD, 90));

        card_no = new JLabel("Card Number: ");
        bg.add(card_no);
        card_no.setBounds(570, 300, 250, 40);
        card_no.setFont(new Font("Raleway", Font.BOLD, 20));

        box_1 = new JTextField();
        box_1.setBounds(720, 305, 250, 35);
        box_1.setFont(new Font("Arial", Font.BOLD, 19));
        bg.add(box_1);

        pin = new JLabel("Pin: ");
        bg.add(pin);
        pin.setBounds(570, 390, 250, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 19));

        box_2 = new JPasswordField();
        box_2.setFont(new Font("Arial", Font.BOLD, 19));
        box_2.setBounds(720, 396, 250, 35);
        bg.add(box_2);

        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(600, 500, 130, 45);
        bg.add(sign_in);
        sign_in.setBackground(Color.white);
        sign_in.setForeground(Color.black);
        sign_in.addActionListener(this);   

        clear = new JButton("CLEAR");
        clear.setBounds(810, 500, 130, 45);
        bg.add(clear);
        clear.setBackground(Color.white);
        clear.setForeground(Color.black);
        clear.addActionListener(this);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(705, 570, 130, 45);
        sign_up.setBackground(Color.white);
        sign_up.setForeground(Color.black);
        bg.add(sign_up);
        sign_up.addActionListener(this);
        
        forgot_password = new JButton("Forgot Password?");
        forgot_password.setBounds(670, 625, 200, 35); 
        forgot_password.setFont(new Font("Arial", Font.BOLD, 16));
        forgot_password.setBorderPainted(false);
        forgot_password.setContentAreaFilled(false);
        forgot_password.setFocusPainted(false);
        forgot_password.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bg.add(forgot_password);
        forgot_password.addActionListener(this);


    }
@Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == sign_in){
        Connection_ c1 = new Connection_();
        String cardnumber = box_1.getText();
        String pinnumber = box_2.getText(); 

        String q = "SELECT * FROM signup3 WHERE applicant_c_number = '"+cardnumber+"' AND applicant_p_number = '"+pinnumber+"'";
        try {
            ResultSet r = c1.s.executeQuery(q); 
            if(r.next()){ 
                setVisible(false);
                new Transaction().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    else if(ae.getSource() == forgot_password) {
        setVisible(false);
        try {
            new Forgot_Password().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    else if(ae.getSource()==clear){
        box_1.setText("");
        box_2.setText("");
    }
    else if (ae.getSource()==sign_up){
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