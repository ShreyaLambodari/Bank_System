package Bank_sys_project.Deposit;

import javax.swing.*;

import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.Connection_.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    JLabel text, label_1;
    JTextField amount;
    JLayeredPane layeredPane;
    JButton deposit, back;
    protected String pinnumber;

    public Deposit(String pinnumber) throws Exception{
        this.pinnumber = pinnumber;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        setTitle("Cash Deposit Window");

        // Create layered pane
        layeredPane = getLayeredPane();

        // Load image from URL
        URL url = new URL("https://img.freepik.com/premium-vector/set-realistic-atm-machine-isolated-atm-bank-cash-machine-with-interface-keypad-slot-card_320857-1122.jpg");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        // Background label
        label_1 = new JLabel(i3);
        label_1.setBounds(250, -50, 1000, 900);
        layeredPane.add(label_1, Integer.valueOf(0)); // background layer

        // Text
        text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(580, 160, 500, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        layeredPane.add(text, Integer.valueOf(1)); // foreground layer

        // Text field
        amount = new JTextField();
        amount.setBounds(650, 350, 200, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        layeredPane.add(amount, Integer.valueOf(1)); // foreground layer
        setVisible(true);

        deposit = new JButton("Deposite");
        deposit.setBounds(620, 465, 100, 25);
        deposit.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(deposit, Integer.valueOf(1));
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(780, 465, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(back, Integer.valueOf(1));
        back.addActionListener(this);

    }
    @Override
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==deposit) {
            String amt_number = amount.getText();
            LocalDate date = LocalDate.now();
            if (amt_number .equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                Connection_ c1 = new Connection_();
                String query = "insert into bank values('"+pinnumber+"','"+date.toString()+"' ,'"+amt_number+"', 'Deposit')";
                
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + amt_number + " Deposited Successfully");
                    setVisible(false);
                    try {
                        new Transaction(pinnumber);
                        setVisible(true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // setVisible(true);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if(ae.getSource()==back) {
            setVisible(false);
            try {
                String pinnumber = " ";
                new Transaction(pinnumber).setVisible(true);;

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Deposit("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
