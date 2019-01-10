/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Unknown
 */
public class Login implements ActionListener{
    JFrame f;
    JPanel p;
    JTextField t1;
    JPasswordField t2;
    JLabel l1,l2;
    JButton b1,b2;
    Connection con;
    Statement st;
    String passworduser;
    
    Login()
    {
        f=new JFrame("Login");
        f.setSize(400,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        ImageIcon ficon=new ImageIcon("images/logo2.png");
        f.setIconImage(ficon.getImage());
                
        p=new JPanel(null);
        p.setBackground(new Color(204,204,204));
        f.add(p);
        
        l1=new JLabel("Username :");
        l1.setForeground(Color.BLACK);
        l1.setBounds(60,80,200,100);
        p.add(l1);
        
        l2=new JLabel("Password :");
        l2.setForeground(Color.black);
        l2.setBounds(60,140,200,100);
        p.add(l2);
        
        t1=new JTextField("Rabei");
        t1.setBounds(140,120,180,25);
        t1.setEditable(false);
        t1.setBackground(new Color(108,122,137));
        t1.setForeground(Color.GREEN);
        p.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(140,180,180,25);
        t2.setBackground(new Color(108,122,137));
        t2.setForeground(Color.WHITE);
        p.add(t2);
         
        b2=new JButton("Login");
        b2.addActionListener(this);
        b2.setBounds(240,230,80,30);
        b2.setBackground(new Color(34,167,240));
        b2.setForeground(Color.WHITE);
        p.add(b2);
        
        f.setVisible(true);
        f.setResizable(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2)
        {
            
            String p=t2.getText();
            //int p1=Integer.parseInt(p);
         
             String query="select * from login";
        String u="root";

        String url="jdbc:mysql://localhost/al_qamar_uniform";
        String passwordurl="";
        try {
           con=DriverManager.getConnection(url, u, passwordurl);
           st=con.createStatement();
           ResultSet rs=st.executeQuery(query);
           while(rs.next())
           {
               passworduser=rs.getString("password");
           }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
         
            if(p.equals(passworduser))
            {
             Menue m=new Menue();
             f.dispose();
            }        
            else{
            JOptionPane.showMessageDialog(null,"Password is incorrect");
            
            }
        }
    }
    
}
