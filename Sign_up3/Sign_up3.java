package Bank_sys_project.Sign_up3;
import Bank_sys_project.Sign_up.Sign_up;
import Bank_sys_project.Sign_up2.Sign_up2;
import Bank_sys_project.Transaction.Transaction;
import Bank_sys_project.Connection_.Connection_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Sign_up3 extends JFrame implements ActionListener {
    JLabel account_details, type, card, card_no, card_below, pin, pin_no, pin_below, generated, services;
    JRadioButton save, fixed, current, recurring;
    ButtonGroup acc_Group;
    JCheckBox s1, s2, s3, s4, s5, s6, declare;
    JButton submit, cancel;

    public Sign_up3() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        account_details = new JLabel("Account Details");
        account_details.setBounds(625, 40, 600, 50);
        account_details.setFont(new Font("Raleway", Font.BOLD, 40));
        add(account_details);

        // Account Type
        type = new JLabel("Account Type:");
        type.setBounds(380, 170, 400, 30);
        type.setFont(new Font("Raleway", Font.BOLD, 25));
        add(type);

        save = new JRadioButton("Savings Account");
        fixed = new JRadioButton("Fixed Deposit Account");
        current = new JRadioButton("Current Account");
        recurring = new JRadioButton("Recurring Deposit Account");

        save.setBounds(600, 170, 200, 30);
        fixed.setBounds(800, 170, 220, 30);
        current.setBounds(600, 210, 200, 30);
        recurring.setBounds(800, 210, 250, 30);

        save.setBackground(Color.WHITE);
        fixed.setBackground(Color.WHITE);
        current.setBackground(Color.WHITE);
        recurring.setBackground(Color.WHITE);

        acc_Group = new ButtonGroup();
        acc_Group.add(save);
        acc_Group.add(fixed);
        acc_Group.add(current);
        acc_Group.add(recurring);

        add(save); add(fixed); add(current); add(recurring);

        // Card Number
        card = new JLabel("Card Number:");
        card.setBounds(380, 270, 400, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card);

        card_no = new JLabel("XXXX-XXXX-XXXX-XXXX");
        card_no.setBounds(600, 270, 250, 30);
        card_no.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(card_no);

        card_below = new JLabel("Your card number will be of the given format");
        card_below.setBounds(600, 300, 400, 25);
        card_below.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(card_below);

        // PIN
        pin = new JLabel("PIN:");
        pin.setBounds(380, 350, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        pin_no = new JLabel("XXXX");
        pin_no.setBounds(600, 350, 250, 30);
        pin_no.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(pin_no);

        pin_below = new JLabel("Your generated PIN will be a 4-digit number");
        pin_below.setBounds(600, 380, 350, 20);
        pin_below.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(pin_below);

        // Services Required
        services = new JLabel("Services Required:");
        services.setBounds(380, 440, 200, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        add(services);

        s1 = new JCheckBox("ATM Card");
        s2 = new JCheckBox("Internet Banking");
        s3 = new JCheckBox("Mobile Banking");
        s4 = new JCheckBox("Cheque Book");
        s5 = new JCheckBox("E-Statement");
        s6 = new JCheckBox("Email & SMS Alerts");

        s1.setBounds(600, 440, 200, 30);
        s2.setBounds(900, 440, 200, 30);
        s3.setBounds(600, 470, 200, 30);
        s4.setBounds(900, 470, 200, 30);
        s5.setBounds(600, 500, 200, 30);
        s6.setBounds(900, 500, 200, 30);

        s1.setBackground(Color.WHITE);
        s2.setBackground(Color.WHITE);
        s3.setBackground(Color.WHITE);
        s4.setBackground(Color.WHITE);
        s5.setBackground(Color.WHITE);
        s6.setBackground(Color.WHITE);

        add(s1); add(s2); add(s3); add(s4); add(s5); add(s6);

        // Declaration Checkbox
        declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declare.setBounds(550, 590, 800, 30);
        declare.setBackground(Color.WHITE);
        add(declare);

        // Buttons
        submit = new JButton("SUBMIT");
        submit.setBounds(605, 690, 120, 40);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(770, 690, 120, 40);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

   @Override
    public void actionPerformed(ActionEvent ae) {
        String applicant_acctype = "";
        if(save.isSelected()){
            applicant_acctype = "Savings Account";
        }else if(fixed.isSelected()){
            applicant_acctype = "Fixed Deposit Account";
        }else if(current.isSelected()){
            applicant_acctype = "Current Account";
        }else{
            applicant_acctype = "Recurring Deposite Account";
        }
        Random random = new Random();
        long applicant_c_number = Math.abs((random.nextLong() % 900000000000L))+543645L;
        int applicant_p_number =  (Math.abs((random.nextInt() % 9000))+1000);
        String applicant_services = "";
        if(s1.isSelected()){
            applicant_services = "ATM Card";
        }else if(s2.isSelected()){
            applicant_services = "Internet Banking";
        }else if(s3.isSelected()){
            applicant_services = "Mobile Banking";
        }else if(s4.isSelected()){
            applicant_services = "Cheque Book";
        }else if(s5.isSelected()){
            applicant_services = "E-Statement";
        }else {
            applicant_services = "E-mail & SMS Alerts";
        }
        
        try {
                if(save.isSelected()==false && fixed.isSelected()== false && current.isSelected()== false && recurring.isSelected()== false){
                        JOptionPane.showInputDialog( "Account type is required");
                }
                else if(s1.isSelected()==false && s2.isSelected()== false && s3.isSelected()== false && s4.isSelected()== false && s5.isSelected()== false && s6.isSelected()== false){
                        JOptionPane.showInputDialog("Required services are important");
                }
                else if(declare.isSelected()==false){
                        JOptionPane.showInputDialog( null, "Declaration is required");
                }
                else{
                        Connection_ c1 = new Connection_();
                        String query3 = "insert into signup3 values ('"+applicant_acctype+"', '"+applicant_c_number+"', '"+applicant_p_number+"', '"+applicant_services+"')";
                        String query4 = "insert into login values('"+applicant_c_number+"', '"+applicant_c_number+"' )";
                        c1.s.executeUpdate(query3);
                        c1.s.executeUpdate(query4);
                }
                System.out.println("Page 3 Data inserted successfully!!");
        } catch (Exception e) {
               System.out.println(e);
        }
        if (ae.getSource()==cancel) {
                dispose();
                return;
        }else if(ae.getSource()==submit){
                
                try {
                        JOptionPane.showMessageDialog(null, "Account generated successfully \n Card number:" + applicant_c_number + "\n Pin:" + applicant_p_number);
                        setVisible(false);
                        new Transaction("").setVisible(true);
                        
                } catch (Exception e) {
                        System.out.println(e);
                }
                
        }

}


    public static void main(String[] args) {
        new Sign_up3();
    }
}
