package employee.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash(){
    
    
   
        getContentPane().setBackground(Color.WHITE);
    
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("Serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0, 90, 1160, 630);
        add(image);
        
        JButton clickhere = new JButton ("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 290, 70); 
        clickhere.setForeground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        

    
        setSize(1170, 650);
        setLocation(200,50);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
        try{
            Thread.sleep(500);
        } catch (Exception e){
        }
        heading.setVisible(true);
         try{
            Thread.sleep(500);
        } catch (Exception e){
        }
    }   }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String args[]){
    new Splash();
    }
}


    

