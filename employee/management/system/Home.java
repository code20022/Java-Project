package employee.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton view, add, update, remove;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Empoloyee Management System");
        heading.setBounds(640, 20, 400, 40);
        heading.setFont(new Font("serif",Font.BOLD, 25));
        heading.setForeground(Color.lightGray);
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 60);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 60);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.addActionListener(this);
        update.setBounds(650, 160, 150, 60);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 160, 150, 60);
        remove.addActionListener(this);
        image.add(remove);
      
        
        
        setSize(1120, 630);
        setLocation(250,100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
            
        }else if (ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
          
        }else if (ae.getSource()== update){
            setVisible(false);
            new ViewEmployee();
        
        }else if (ae.getSource()== remove){
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main (String[] args){
        new Home();
    }
    
}
