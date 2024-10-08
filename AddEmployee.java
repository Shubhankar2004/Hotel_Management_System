package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;
    JButton submit;
    
    AddEmployee(){
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME : ");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE : ");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage= new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER : ");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,17));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280,130,100,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,17));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB : ");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        String str[] = {"FRONT DESK CLERKS","PORTERS","HOUSEKEEPING","KITCHEN STAFF","ROOM SERVICE","CHEFS","WAITERS","MANAGER","ACCOUNTANTS"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY : ");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary= new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE : ");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
        
        tfphone= new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("E-MAIL : ");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR : ");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);
        
        tfaadhar= new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,550,450);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        String gender =null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);
            
        }catch(Exception e){
            e.getStackTrace();
        }
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
