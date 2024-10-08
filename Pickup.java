package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("PICKUP SERVICES");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("CAR TYPE");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel l1 = new JLabel("DRIVER NAME :");
        l1.setBounds(50,160,150,20);
        add(l1);
        
        JLabel l2 = new JLabel("AGE :");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("CAR COMPANY");
        l4.setBounds(460,160,150,20);
        add(l4);
        
        JLabel l5 = new JLabel("CAR MODEL :");
        l5.setBounds(630,160,150,20);
        add(l5);
        
        JLabel l6 = new JLabel("AVAILABILITY :");
        l6.setBounds(740,160,150,20);
        add(l6);
        
        JLabel l7 = new JLabel("LOCATION :");
        l7.setBounds(890,160,150,20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);
        
        back = new JButton("BACK");
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query = "select * from driver where model = '"+typeofcar.getSelectedItem()+"'";                
                
                Conn conn = new Conn();
                ResultSet rs;                
                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
        setVisible(false);
        new Reception();
        }
    }
    
    public static void main(String args[]){
        new Pickup();
    }
}