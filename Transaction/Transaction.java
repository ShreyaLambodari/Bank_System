package Bank_sys_project.Transaction;
import Bank_sys_project.src.Connection_.*;
import Bank_sys_project.Deposit.Deposit;
import Bank_sys_project.FastCash.Fast_Cash;
import Bank_sys_project.Help.Help;
import Bank_sys_project.Withdrawl.Withdrawl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Transaction extends JFrame implements ActionListener {
    JLabel text;
    JButton deposit, withdraw, mini_statement, fast_cash, balance, help, exit;
    String pinnumber;
    JLayeredPane layeredPane;

    public Transaction() throws Exception {
        // this.pinnumber = pinnumber;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setTitle("Transaction Page");
        setLayout(null);

        // Create layered pane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900); 
        add(layeredPane);

        // Background image
        URL url = new URL("https://vunetsystems.com/wp-content/uploads/2023/12/IMG-32-1.png");
        ImageIcon i1 = new ImageIcon(url);
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label_1 = new JLabel(i3);
        label_1.setBounds(250, -40, 1000, 900);

        layeredPane.add(label_1, Integer.valueOf(0));

        JPanel componentPanel = new JPanel(null);
        componentPanel.setOpaque(false);
        componentPanel.setBounds(250, -40, 1000, 900);

        text = new JLabel("Please Select Your Transaction");
        text.setBounds(370, 60, 1000, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        componentPanel.add(text);

        deposit = createButton("Deposit", 150, 200);
        componentPanel.add(deposit);

        withdraw = createButton("Withdraw", 750, 200);
        componentPanel.add(withdraw);

        fast_cash = createButton("Fast Cash", 62, 430);
        componentPanel.add(fast_cash);

        mini_statement = createButton("Statement", 842, 430);
        componentPanel.add(mini_statement);

        balance = createButton("Balance", 150, 675);
        componentPanel.add(balance);

        help = createButton("Help", 750, 675);
        componentPanel.add(help);

        exit = new JButton("Exit");
        exit.setBounds(450, 790, 110, 40);
        exit.setFont(new Font("Raleway", Font.BOLD, 20));
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        componentPanel.add(exit);

        layeredPane.add(componentPanel, Integer.valueOf(1));

        setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 110, 40);
        btn.setFont(new Font("Raleway", Font.BOLD, 16));
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            dispose();
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            try {
                new Deposit(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == withdraw) {
            setVisible(false);
            try {
                new Withdrawl("").setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == fast_cash) {
            setVisible(false);
            try {
                new Fast_Cash("").setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==help){
            new Help();
        }
    }

    public static void main(String[] args) {
        try {
            new Transaction();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
