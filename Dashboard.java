package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("THE KASHYAP GROUP WELCOMES YOU !!!!!");
        text.setBounds(300,80,1500,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,50));
        text.setForeground(Color.CYAN);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setForeground(Color.BLACK);
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);
        
        JMenuItem addempolyee = new JMenuItem("ADD EMPLOYEE");
        addempolyee.setForeground(Color.BLACK);
        addempolyee.addActionListener(this);
        admin.add(addempolyee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.setForeground(Color.BLACK);
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.setForeground(Color.BLACK);
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String args[]){
        new Dashboard();
    }
}
