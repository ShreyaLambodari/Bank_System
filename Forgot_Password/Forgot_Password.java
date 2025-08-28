package Bank_sys_project.Forgot_Password;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Forgot_Password extends JFrame{
    JLayeredPane layer;
    // JPanel  small_rec;

    public Forgot_Password() throws Exception{
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setLayout(null);
        setTitle("Forgot Password");
        // layer = getLayeredPane();
        // getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        JPanel bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setBounds(0 , 0 , getWidth(), getHeight());
        Color mycolor = new Color(135, 206, 235);
        bg.setBorder(new MatteBorder(90, 0 , 0 , 0, mycolor )); 
        add(bg);
        setVisible(true);         
        
        JPanel box = new JPanel(){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;      
        }
    };
    }
    
    public static void main(String[] args) {
        try {
            new Forgot_Password();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
