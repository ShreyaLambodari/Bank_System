package Bank_sys_project.Balance;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.src.Connection_.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLException;


public class Balance extends JFrame{
    JLayeredPane layeredPane;
    JLabel label_1, text;
    public Balance() throws Exception{
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        setTitle("Fast_Cash Window");
        layeredPane = getLayeredPane();

        URL url = new URL("https://img.freepik.com/premium-vector/set-realistic-atm-machine-isolated-atm-bank-cash-machine-with-interface-keypad-slot-card_320857-1122.jpg");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        label_1 = new JLabel(i3);
        label_1.setBounds(250, -50, 1000, 900);
        layeredPane.add(label_1, Integer.valueOf(0));

        text = new JLabel("Balance Enquiry");
        text.setBounds(550, 160, 500, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        text.setForeground(Color.BLACK);
        layeredPane.add(text, Integer.valueOf(1));
}
}
