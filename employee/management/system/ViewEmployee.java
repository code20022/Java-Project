package employee.management.system;

import javax.swing.*;
import java .awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table ;
    Choice tfname;
    JButton search, print, update,back;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee Name");
        searchlbl.setBounds (20, 20, 150, 20);
        add(searchlbl);
        
        tfname = new Choice ();
        tfname.setBounds(180,20,150,20);
        add(tfname);
        
        
        
         try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
            tfname.add(rs.getString("name"));
        }
        }catch (Exception e){
            e.printStackTrace();
        }
         
        table = new JTable();
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
         
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton ("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton ("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton ("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton ("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){
           String query = "select * from employee where name = '"+tfname.getSelectedItem()+"'";
           try{
               conn c = new conn();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==print){
           try{
               table.print();
           } catch (Exception e){
               e.printStackTrace();
           }
        }else if (ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(tfname.getSelectedItem());
            
        }else{
            setVisible(false);
            new Home();
        }
    }
   public static void main (String[] args) {
       new ViewEmployee();
   }
           
}
