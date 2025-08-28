package Bank_sys_project.Sign_up;
import Bank_sys_project.Sign_up2.Sign_up2;
import Bank_sys_project.src.Connection_.Connection_;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Sign_up extends JFrame implements ActionListener{

    JLabel name, father_name, mother_name, DOB, gender, email, status, add, ct, st, form_no, personal_details;
    JTextField name_box, father_name_box, mother_name_box, email_box, add_box, ct_box;
    JButton next, clear;
    JRadioButton male, female, other, married, single;
    ButtonGroup gender_Group, status_Group;
    String[] date, mth, yr, states;
    JComboBox<String> date_box, mth_box, yr_box, state_box;
    Random num;
    int app_num;

    public Sign_up() throws Exception {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        num = new Random();
        app_num = Math.abs((num.nextInt(9000)+1000));
        form_no = new JLabel("Application ID: "+ app_num );
        add(form_no);
        form_no.setBounds(530, 40, 750, 70);
        form_no.setFont(new Font("Raleway", Font.BOLD, 45));

        personal_details = new JLabel("Personal Details");
        add(personal_details);
        personal_details.setBounds(635, 130, 750, 45);
        personal_details.setFont(new Font("Arial", Font.BOLD, 35));
//name
        name = new JLabel("Name: ");
        add(name);
        name.setBounds(150, 238, 250, 70);
        name.setFont(new Font("Raleway", Font.BOLD, 20));

        name_box = new JTextField();
        name_box.setBounds(325, 255, 300, 35);
        name_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(name_box);
//father's name
        father_name = new JLabel("Father's Name: ");
        add(father_name);
        father_name.setBounds(150, 338, 250, 70);
        father_name.setFont(new Font("Raleway", Font.BOLD, 20));

        father_name_box = new JTextField();
        father_name_box.setBounds(325, 355, 300, 35);
        father_name_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(father_name_box);
//mother's name
        mother_name = new JLabel("Mother's Name: ");
        add(mother_name);
        mother_name.setBounds(150, 438, 250, 70);
        mother_name.setFont(new Font("Raleway", Font.BOLD, 20));
//mother's name
        mother_name_box = new JTextField();
        mother_name_box.setBounds(325, 455, 300, 35);
        mother_name_box.setFont(new Font("Arial", Font.BOLD, 19));
        add(mother_name_box);
//dob
        DOB = new JLabel("Date Of Birth: ");
        add(DOB);
        DOB.setBounds(150, 538, 250, 70);
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));

        String[] date = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        date_box = new JComboBox<>(date);
        date_box.setBounds(325,550,50,30);
        add(date_box);
        date_box.setBackground(Color.WHITE);

        String[] mth = { "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"};

        mth_box = new JComboBox<>(mth);
        mth_box.setBounds(375,550,90,30);
        add(mth_box);
        mth_box.setBackground(Color.WHITE);

        String[] yr = {"2030", "2029", "2028", "2027", "2026", "2025", "2024", "2023", "2022", "2021","2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011","2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};

        yr_box = new JComboBox<>(yr);
        yr_box.setBounds(460,550,70,30);
        yr_box.setBackground(Color.WHITE);
        add(yr_box);

        
//gender
        JLabel gender = new JLabel("Gender: ");
        add(gender);
        gender.setBounds(150, 638, 250, 70);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        gender_Group = new ButtonGroup();
        gender_Group.add(male);
        gender_Group.add(other);
        gender_Group.add(female);

        male.setBounds(325,660,80,30);
        female.setBounds(410,660,80,30);
        other.setBounds(495,660,80,30);

        add(male); add(female); add(other);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        other.setBackground(Color.WHITE);
//email
        email = new JLabel("Email: ");
        add(email);
        email.setBounds(800, 238, 250, 70);
        email.setFont(new Font("Raleway", Font.BOLD, 20));

        email_box = new JTextField();
        email_box.setBounds(980, 255, 300, 35);
        email_box.setFont(new Font("Arial", Font.BOLD, 20));
        add(email_box);
//marrital status
        status = new JLabel("Marrital Status: ");
        add(status);
        status.setBounds(800, 338, 250, 70);
        status.setFont(new Font("Raleway", Font.BOLD, 20));

        single = new JRadioButton("Single");
        married = new JRadioButton("Married");

        status_Group = new ButtonGroup();
        status_Group.add(single);
        status_Group.add(married);

        single.setBounds(980,358,100,30);
        married.setBounds(1100,358,100,30);
        add(married);  add(single);
        married.setBackground(Color.WHITE);
        single.setBackground(Color.WHITE);
//Address
        add = new JLabel("Current Address: ");
        add(add);
        add.setBounds(800, 444, 250, 70);
        add.setFont(new Font("Raleway", Font.BOLD, 20));

        add_box = new JTextField(); 
        add_box.setBounds(980, 457, 300, 35);
        add_box.setFont(new Font("Arial", Font.BOLD, 20));
        add(add_box);
//city
        ct = new JLabel("City: ");
        add(ct);
        ct.setBounds(800, 544, 250, 70);
        ct.setFont(new Font("Raleway", Font.BOLD, 20));

        ct_box= new JTextField();
        ct_box.setBounds(980, 558, 300, 35);
        ct_box.setFont(new Font("Arial", Font.BOLD, 20));
        add(ct_box);
//state
        st = new JLabel("State: ");
        add(st);
        st.setBounds(800, 644, 250, 70);
        st.setFont(new Font("Raleway", Font.BOLD, 20));

        String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar","Chhattisgarh", "Goa", "Gujarat", "Haryana","Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra","Manipur", "Meghalaya","Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};

        state_box = new JComboBox<>(states);
        state_box.setBounds(980,651,300,40);
        add(state_box);
        state_box.setBackground(Color.WHITE);

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
        String app_form_no = "" + app_num;
        String applicant_name = name_box.getText() ;
        String applicant_father = father_name_box.getText();
        String applicant_mother = mother_name_box.getText();
        String applicant_email = email_box.getText();
        String applicant_add = add_box.getText();
        String applicant_city = ct_box.getText();
        String applicant_gender= "";
        if (male.isSelected()) {
                applicant_gender ="Male";
        }else if(female.isSelected()){
                applicant_gender ="Female";
        }else{
                applicant_gender ="Other";
        }
        String applicant_status= "";
        if (single.isSelected()) {
                applicant_status ="Single";
        }else{
                applicant_status ="Married";
        }
        String applicant_date = (String) (date_box.getSelectedItem() );
        String applicant_month = (String) (mth_box.getSelectedItem() );
        String applicant_yr = (String) (yr_box.getSelectedItem() );
        String applicant_state = (String) (state_box.getSelectedItem() );

        try {
                if(applicant_name.isEmpty()){
                        JOptionPane.showMessageDialog(name, "Name is required");
                }else if(applicant_father.isEmpty()){
                        JOptionPane.showMessageDialog(father_name, "Father's Name is required");
                }else if(applicant_mother.isEmpty()){
                        JOptionPane.showMessageDialog(mother_name, "Mother's Name is required");
                }else if(applicant_email.isEmpty()){
                        JOptionPane.showMessageDialog(email, "Email is required");
                }else if(applicant_add.isEmpty()){
                        JOptionPane.showMessageDialog(add, "Address is required");
                }else if(applicant_city.isEmpty()){
                        JOptionPane.showMessageDialog(ct, "City is required");
                }else if(applicant_gender.isEmpty()){
                        JOptionPane.showMessageDialog(gender, "Gender is required");
                }else if(applicant_state.isEmpty()){
                        JOptionPane.showMessageDialog(st, "State is required");
                }else if(applicant_status.isEmpty()){
                        JOptionPane.showMessageDialog(status, "Marrital status is required");
                }else if(applicant_date.isEmpty()){
                        JOptionPane.showMessageDialog(date_box, "Date is required");
                }else if(applicant_month.isEmpty()){
                        JOptionPane.showMessageDialog(mth_box, "Month is required");
                }else if(applicant_yr.isEmpty()){
                        JOptionPane.showMessageDialog(yr_box, "Year is required");
                }else{
                        Connection_ c1 = new Connection_();
                        String query = "insert into signup values ('"+applicant_name+"', '"+applicant_father+"', '"+applicant_mother+"', '"+applicant_email+"', '"+applicant_city+"', '"+applicant_add+"', '"+applicant_gender+"', '"+applicant_status+"', '"+applicant_state+"', '"+applicant_date+"', '"+applicant_month+"', '"+applicant_yr+"', '"+app_form_no+"')";
                        // String query_log = "insert into login values('"+applicant_name+"')";
                        c1.s.executeUpdate(query);
                        // c1.s.executeUpdate(query_log);
                }
                System.out.println("Page 1 Data inserted successfully!!");
        } catch (Exception e) {
               System.out.println(e);
        }
        if (ae.getSource()==clear) {
                name_box.setText(""); father_name_box.setText(""); mother_name_box.setText("");email_box.setText(""); add_box.setText(""); ct_box.setText(""); 
        }else if(ae.getSource()==next){
                setVisible(false);
                try {
                        new Sign_up2().setVisible(true);
                } catch (Exception e) {
                        System.out.println(e);
                }
                
        }

    }

    public static void main(String[] args) {
        try {
                new Sign_up();
        } catch (Exception e) {
                System.out.println(e);
        }
    }

}
