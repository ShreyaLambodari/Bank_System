package Bank_sys_project.FastCash;


import javax.swing.*;

import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.src.Connection_.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener{
    JLabel text, label_1;
    JTextField amount;
    JLayeredPane layeredPane;
    JButton Fast_Cash, back;
    protected String pinnumber;

    public Fast_Cash(String pinnumber) throws Exception{
        this.pinnumber = pinnumber;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        setTitle("Fast_Cash Window");

        // Create layered pane
        layeredPane = getLayeredPane();

        
        URL url = new URL("https://img.freepik.com/premium-vector/set-realistic-atm-machine-isolated-atm-bank-cash-machine-with-interface-keypad-slot-card_320857-1122.jpg");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

       
        label_1 = new JLabel(i3);
        label_1.setBounds(250, -50, 1000, 900);
        layeredPane.add(label_1, Integer.valueOf(0)); // background layer

        text = new JLabel("Select Withdrawl Amount (upto 10000 only)");
        text.setBounds(550, 160, 500, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        text.setForeground(Color.BLACK);
        layeredPane.add(text, Integer.valueOf(1)); // foreground layer

        amount = new JTextField();
        amount.setBounds(650, 350, 200, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        layeredPane.add(amount, Integer.valueOf(1)); // foreground layer
        setVisible(true);

        Fast_Cash = new JButton("FastCash");
        Fast_Cash.setBounds(620, 465, 100, 25);
        Fast_Cash.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(Fast_Cash, Integer.valueOf(1));
        Fast_Cash.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(780, 465, 100, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        layeredPane.add(back, Integer.valueOf(1));
        back.addActionListener(this);

    }
    @Override
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==Fast_Cash) {
            // JOptionPane.showInputDialog(null, "You can Withdraw upto Rs. 10,000 only using Fast_Cash");
            String amt_number = amount.getText();
            LocalDate date = LocalDate.now();
            int amt = Integer.parseInt(amt_number);
            int bal = 0;
             
            if (amt > 10000 || amt<=0 && bal>=amt) {
                JOptionPane.showMessageDialog(null, "You can Withdraw upto Rs. 10,000 only using Fast_Cash");
            } else {
                try {
                Connection_ c1 = new Connection_();
                String query = "insert into bank values('"+pinnumber+"','"+date.toString()+"' ,'"+amt_number+"', 'Fast_Cash')";
                
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + amt_number + " Withdrawn using fastcash successfully");
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
                new Transaction(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Fast_Cash("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

