package Bank_sys_project.Sign_up2;
import Bank_sys_project.Sign_up.Sign_up;
import Bank_sys_project.Sign_up3.Sign_up3;
import Bank_sys_project.src.Connection_.Connection_;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sign_up2 extends JFrame implements ActionListener{

    JLabel religion, category, qualification, occupation, additional_details, aadhar, pan, income_annual;
    JTextField religion_box, category_box, occupation_box, aadhar_box, pan_box;
    JButton next, clear;
    String[] income, exist_acc, quali;
    JComboBox<String> income_box, existing_box, qualification_box;

    public Sign_up2() throws Exception {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        additional_details = new JLabel("Additional Details");
        add(additional_details);
        additional_details.setBounds(635, 85, 750, 45);
        additional_details.setFont(new Font("Arial", Font.BOLD, 35));
//religion
        religion = new JLabel("Religion: ");
        add(religion);
        religion.setBounds(450, 170, 250, 70);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));

        religion_box = new JTextField();
        religion_box.setBounds(625, 190, 500, 35);
        religion_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(religion_box);
//category
        category = new JLabel("Category: ");
        add(category);
        category.setBounds(450, 238, 250, 70);
        category.setFont(new Font("Raleway", Font.BOLD, 20));

        category_box = new JTextField();
        category_box.setBounds(625, 255, 500, 35);
        category_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(category_box);
//qualification
        qualification = new JLabel("Qualification: ");
        add(qualification);
        qualification.setBounds(450, 300, 250, 70);
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
//qualification_box
        String[] quali = {"", "Middle School", "High School", "Graduate", "Post-Graduate"};
        qualification_box = new JComboBox<>(quali);
        qualification_box.setBounds(625, 315, 500, 35);
        qualification_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(qualification_box);
//occupation
        occupation = new JLabel("Occupation: ");
        add(occupation);
        occupation.setBounds(450, 375, 250, 70);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        
        occupation_box = new JTextField();
        occupation_box.setBounds(625, 385, 500, 35);
        occupation_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(occupation_box);
//income
        income_annual = new JLabel("Annual Income:");
        add(income_annual);
        income_annual.setBounds(450, 445, 250, 70);
        income_annual.setFont(new Font("Raleway", Font.BOLD, 20));
        String[] income = {"","Below 2 lakh per annum", "Between 2 to 3.5 lakh", "Between 3.5 to 5.5 lakh", "Between 5.5 to 8 lakh", "Above 8 lakh", "No Income Source"};
        income_box = new JComboBox<>(income);
        income_box.setBounds(625,460,500,30);
        add(income_box);
        income_box.setBackground(Color.WHITE);

// pan no       
        pan = new JLabel("Pan Number: ");
        add(pan);
        pan.setBounds(450, 510, 250, 70);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));

        pan_box = new JTextField();
        pan_box.setBounds(625, 523, 500, 35);
        pan_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(pan_box);

//aadhar no
        aadhar = new JLabel("Aadhar Number: ");
        add(aadhar);
        aadhar.setBounds(450, 570, 250, 70);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));

        aadhar_box = new JTextField();
        aadhar_box.setBounds(625, 590, 500, 35);
        aadhar_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(aadhar_box);

        
//existing account
        JLabel existing_acc = new JLabel("Existing Account: ");
        add(existing_acc);
        existing_acc.setBounds(450, 638, 250, 70);
        existing_acc.setFont(new Font("Raleway", Font.BOLD, 20));
        String[] exist_acc = {"", "YES", "NO"};
        existing_box = new JComboBox<>(exist_acc);
        existing_box.setBounds(625,654,500,30);
        add(existing_box);
        existing_box.setBackground(Color.WHITE);


        next = new JButton("NEXT");
        next.setBounds(800, 740, 100, 40);
        add(next);
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(600, 740, 100, 40);
        add(clear);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String applicant_religion = religion_box.getText() ;
        String applicant_category = category_box.getText();
        String applicant_qualification = (String)(qualification_box.getSelectedItem());
        String applicant_occupation = occupation_box.getText();
        String applicant_income = (String)(income_box.getSelectedItem());
        String applicant_aadhar = aadhar_box.getText();
        String applicant_pan = pan_box.getText();
        String applicant_existinguser = (String)(existing_box.getSelectedItem());

        try {
                if(applicant_religion.isEmpty()){
                        JOptionPane.showMessageDialog(religion, "Religion is required");
                }else if(applicant_category.isEmpty()){
                        JOptionPane.showMessageDialog(category, "Category is required");
                }else if(applicant_qualification.isEmpty()){
                        JOptionPane.showMessageDialog(qualification_box, "Qualification is required");
                }else if(applicant_occupation.isEmpty()){
                        JOptionPane.showMessageDialog(occupation_box, "Occupation is required");
                }else if(applicant_income.isEmpty()){
                        JOptionPane.showMessageDialog(income_box, "Annual Income is required");
                }else if(applicant_aadhar.isEmpty()){
                        JOptionPane.showMessageDialog(aadhar_box, "Aadhar Number is required");
                }else if(applicant_pan.isEmpty()){
                        JOptionPane.showMessageDialog(pan_box, "Pan Number is required");
                }else if(applicant_existinguser.isEmpty()){
                        JOptionPane.showMessageDialog(existing_box, "Existing user info is required");
                }else{
                        Connection_ c1 = new Connection_();
                        String query2 = "insert into signup2 values ('"+applicant_religion+"', '"+applicant_category+"', '"+applicant_qualification+"', '"+applicant_occupation+"', '"+applicant_income+"', '"+applicant_pan+"', '"+applicant_aadhar+"', '"+applicant_existinguser+"')";

                        c1.s.executeUpdate(query2);
                }
                System.out.println("Page 2 Data inserted successfully!!");
        } catch (Exception e) {
               System.out.println(e);
        }
        if (ae.getSource()==clear) {
                religion_box.setText(""); category_box.setText(""); qualification_box.setSelectedIndex(0);occupation_box.setText(""); income_box.setSelectedIndex(0); aadhar_box.setText("");pan_box.setText(""); existing_box.setSelectedIndex(0);
        }else if(ae.getSource()==next){
                setVisible(false);
                try {
                        new Sign_up3().setVisible(true);
                } catch (Exception e) {
                        System.out.println(e);
                }
                
        }



    }

    public static void main(String[] args) {
        try {
                new Sign_up2();
        } catch (Exception e) {
                System.out.println(e);
        }
    }

}

