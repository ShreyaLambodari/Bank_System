package Bank_sys_project.Withdrawl;

    
import javax.swing.*;

import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.src.Connection_.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JLabel text, label_1;
    JTextField amount;
    JLayeredPane layeredPane;
    JButton withdraw, back;
    protected String pinnumber;

    public Withdrawl(String pinnumber) throws Exception{
        this.pinnumber = pinnumber;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        setTitle("Cash Withdrawl Window");

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
        text = new JLabel("Enter the amount you want to withdraw");
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

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(620, 465, 100, 25);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(withdraw, Integer.valueOf(1));
        withdraw.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(780, 465, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(back, Integer.valueOf(1));
        back.addActionListener(this);

    }
    @Override
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==withdraw) {
            String amt_number = amount.getText();
            LocalDate date = LocalDate.now();
            if (amt_number .equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                Connection_ c1 = new Connection_();
                String query = "insert into bank values('"+pinnumber+"','"+date.toString()+"' ,'"+amt_number+"', 'Withdraw')";
                
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + amt_number + " Withdrawn Successfully");
                    setVisible(false);
                    try {
                        new Transaction();
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
                new Transaction().setVisible(true);;

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Withdrawl("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
