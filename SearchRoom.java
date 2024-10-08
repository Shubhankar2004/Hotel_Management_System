package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("SEARCH FOR ROOM");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("BED TYPE");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        bedType = new JComboBox(new String[]{"SINGLE BED","DOUBLE BED"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("ONLY DISPLAY AVAILABLE");
        available.setBounds(650, 100, 200, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1 = new JLabel("ROOM NUMBER");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("AVAILIBILITY");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("STATUS");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("PRICE");
        l4.setBounds(6700,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("BED TYPE");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query1);
                }
                
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
        new SearchRoom();
    }
}
