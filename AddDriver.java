package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox availablecombo,gendercombo,typecombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblroomno = new JLabel("NAME :");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,70,150,30);
        add(lblroomno);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("DRIVER AGE :");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,110,150,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);
        
        JLabel lblclean = new JLabel("GENDER :");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,150,200,30);
        add(lblclean);
        
        String genderOptions[]={"MALE","FEMALE"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblprice = new JLabel("CAR COMPANY :");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,190,150,30);
        add(lblprice);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
        JLabel lbltype = new JLabel("CAR MODEL :");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,230,120,30);
        add(lbltype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("AVAILABLE :");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
        String driverOptions[]={"AVAILABLE","BUSY"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("LOCATION :");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
        add = new JButton("ADD");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.GREEN);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.RED);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"DRIVER ADDED SUCCESSFULLY");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new AddDriver();
    }
}

