package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newCustomer,rooms,department,allEmployee,managerInfo,customers,searchRoom,update,roomStatus,pickup,checkout,logout;
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("NEW CUSTOMER FORM");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.CYAN);
        newCustomer.setForeground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms = new JButton("ROOMS");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.CYAN);
        rooms.setForeground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("DEPARTMENT");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.CYAN);
        department.setForeground(Color.BLACK);
        department.addActionListener(this);
        add(department);
        
        allEmployee = new JButton("ALL EMPLOYEES");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.CYAN);
        allEmployee.setForeground(Color.BLACK);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers = new JButton("CUSTMER INFO");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.CYAN);
        customers.setForeground(Color.BLACK);
        customers.addActionListener(this);
        add(customers);
        
        managerInfo = new JButton("MANAGER INFO");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.CYAN);
        managerInfo.setForeground(Color.BLACK);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout = new JButton("CHECKOUT");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.CYAN);
        checkout.setForeground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("UPDATE STATUS");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.CYAN);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("UPDATE ROOM STATUS");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.CYAN);
        roomStatus.setForeground(Color.BLACK);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup = new JButton("PICKUP SERVICE");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.CYAN);
        pickup.setForeground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom = new JButton("SEARCH ROOM");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.CYAN);
        searchRoom.setForeground(Color.BLACK);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout = new JButton("LOGOUT");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.CYAN);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30,500, 470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
        new Reception();
    }
}
