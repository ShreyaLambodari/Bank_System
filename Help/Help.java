package Bank_sys_project.Help;

import javax.swing.JOptionPane;

import Bank_sys_project.Connection_.Connection_;

public class Help {
    public Help(){
        Connection_ c1 = new Connection_();
        JOptionPane.showMessageDialog( null, "Click on:\n Deposite: to deposit amount in your account.\n\n Withdraw: to to withdraw cash from your account\n\n Fast Cash: to wuthdraw amount (upto Rs.10,000 only)\n\n Mini-Statement: to print the statement for your transactions\n\n Balance: to check the remaining balance in the account\n\n Exit: to close the transaction window");
       
    }


}

