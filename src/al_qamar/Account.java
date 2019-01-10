/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Account {
    JFrame f;
    JPanel p;
    JPasswordField f1,f2,f3;
    JLabel l1,l2,l3,l4,l5;
    JButton b;
    Connection con;
    Statement st;
    boolean o=false,n=false;
   String passworduser="";
    public Account()
    {
        f=new JFrame("Account");
        f.setSize(350,400);
        f.setLocationRelativeTo(null);
         ImageIcon ficon=new ImageIcon("images/logo2.png");
        f.setIconImage(ficon.getImage());
       
        p=new JPanel(null);
        p.setBackground(new Color(238,238,238));
        f.add(p);
        
        l1=new JLabel("Old Password :");
        l1.setBounds(10,10,100,40);
        p.add(l1);
        
        f1=new JPasswordField();
        f1.setBounds(130,20,180,25);
        f1.setBackground(new Color(204,204,204));
        p.add(f1);
        
        l4=new JLabel("");
        l4.setForeground(Color.red);
        l4.setBounds(130,50,150,30);
        p.add(l4);
        
        l2=new JLabel("New Password :");
        l2.setBounds(10,70,100,40);
        p.add(l2);
        
        f2=new JPasswordField();
        f2.setBounds(130,80,180,25);
        f2.setBackground(new Color(204,204,204));
        p.add(f2);
        
        l3=new JLabel("Re-Enter Password:");
        l3.setBounds(5,100,120,40);
        p.add(l3);
        
        f3=new JPasswordField();
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
        f1.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String u=f1.getText();
                if(u.equals(passworduser))
                {
                   l4.setText("Old Password matches");
                   l4.setForeground(Color.GREEN);
                   o=true;
                }
                else
                {
                    l4.setText("Old Password not matches");
                    l4.setForeground(Color.red);
                    o=false;
                }
            }
        });
        f3.setBounds(130,110,180,25);
        f3.setBackground(new Color(204,204,204));
        p.add(f3);
        l5=new JLabel("");
        l5.setForeground(Color.green);
        l5.setBounds(130,140,150,30);
        f3.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(f3.getText().equals(f2.getText()))
                {
                    l5.setText("Password Matches");
                    l5.setForeground(Color.green);
                    n=true;
                }
                else
                {
                    l5.setText("Password no Matches");
                    l5.setForeground(Color.red);
                    n=false;
                }
            }
            
        });
        p.add(l5);
        b=new JButton("Change Password");
        b.setBounds(0, 250, 340, 30);
        p.add(b);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(o==true&&n==true)
                {
                    int a=JOptionPane.showConfirmDialog(null,"Aro you sure want to change Password");
                    if(a==0)
                    {
                        String query="update login set password=?";
                        PreparedStatement st;
                        try {
                            st = con.prepareStatement(query);
                            st.setString(1, f3.getText());
                            if(st.executeUpdate()==1)
                            {
                                JOptionPane.showMessageDialog(null,"Password updated Successfully");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Password not updated Successfully");
                            }
                            
                        } catch (SQLException ex) {
                            System.out.print(ex);
                        }
                    }
                }
            }
            
        });
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    
    }
}
