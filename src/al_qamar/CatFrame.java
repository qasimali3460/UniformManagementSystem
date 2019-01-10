/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CatFrame {
JFrame f;
JPanel p1,p2,p3,p4,p5;
JTextField f1;
JLabel l1;
JButton b1,b2,b3,b4;
Dimension d;
JTable t1;
JScrollPane jp;

CatFrame()
{
    frame();
}
public void frame()
{
    f=new JFrame("Category");
    f.setSize(500,500);
    f.setLocationRelativeTo(null);
    f.setResizable(false);
    
    p1=new JPanel(new BorderLayout());
    p1.setBackground(new Color(114,112,164));
    f.add(p1);
    
    p2=new JPanel(new GridBagLayout());
    p2.setBackground(new Color(114,116,164));
    f1=new JTextField("",10);
    l1=new JLabel("Category");
    b1=new JButton("Insert");
    b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(f1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter a name");
            }
            else
            {
                Connection con=getConnection();
                PreparedStatement st;
                ResultSet rs;
                try {
                    st=con.prepareStatement("select * from category where cat_name=?");
                    st.setString(1, f1.getText());
                    rs=st.executeQuery();
                    if(rs.next())
                    {
                       JOptionPane.showMessageDialog(null,"Category already Exist");
                       
                    }
                    else
                    {
                        st=con.prepareStatement("insert into category(cat_name)values(?)");
                        st.setString(1,f1.getText());
                        if(st.executeUpdate()==1)
                        {
                            JOptionPane.showMessageDialog(null, "Value inserted Successfully");
                            f1.setText("");
                            table();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    });
    b2=new JButton("Update");
    b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!f1.getText().equals(""))
            {
                try {
                    Connection con=getConnection();
                    PreparedStatement st;
                    ResultSet rs;
                    st=con.prepareStatement("select * from category where cat_name=?");
                     st.setString(1, f1.getText());
                    rs=st.executeQuery();
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null, "Category already Exist");
                    }
                    else
                    {
                       st=con.prepareStatement("update category set cat_name=? where cat_name=?");
                       st.setString(1, f1.getText());
                       st.setString(2, old);
                       if(st.executeUpdate()==1)
                       {
                           JOptionPane.showMessageDialog(null, "Updated");
                           st=con.prepareStatement("update stock set category=? where category=?");
                           st.setString(1, f1.getText());
                           st.setString(2, old);
                           st.executeUpdate();
                           
                           table();
                       }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            else
                table();
            
            
        }
        
    });
    b3=new JButton("Delete");
    b3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click==1)
            {
               Connection con=getConnection();
                try {
                    PreparedStatement st=con.prepareStatement("delete * from category where cat_name=?");
                    st.setString(1,f1.getText());
                    if(st.executeUpdate()==1)
                    {
                        JOptionPane.showMessageDialog(null, "Deleted Successfully");
                        st=con.prepareStatement("delete * from stock where category=?");
                        st.setString(1,old);
                        st.executeUpdate();
                        table();
                    }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(CatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
    b4=new JButton("Clear");
    b4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            f1.setText("");
            table();
        }
    });
    d=p2.getPreferredSize();
    d.height=150;
    p2.setPreferredSize(d);
    
    
    GridBagConstraints gc=new GridBagConstraints();
    gc.insets=new Insets(5,5,5,5);
    gc.gridx=0;
    gc.gridy=0;
//    p2.add(l1);
    gc.gridx=1;
    gc.gridy=0;
    p2.add(f1);
    
    JPanel tp=new JPanel(new FlowLayout());
    tp.setBackground(new Color(114,116,164));
    tp.add(b1);
 //   tp.add(b2);
    tp.add(b3);
    tp.add(b4);
    
    gc.gridx=0;
    gc.gridy=2;

    p2.setBorder(BorderFactory.createEtchedBorder());
    p2.add(tp);
    p1.add(p2,BorderLayout.NORTH);
    
    p5=new JPanel(new BorderLayout());
    TitledBorder inner = BorderFactory.createTitledBorder("Products");
    Border outer=BorderFactory.createEmptyBorder(5,5,5,5);
    p5.setBorder(BorderFactory.createCompoundBorder(outer,inner));
    p5.setBackground(new Color(114,112,163));
    p1.add(p5,BorderLayout.CENTER);
     Object[][] data={
        };
            String[] columnN={"id","Category"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t1=new JTable(mo);
            jp=new JScrollPane(t1);
            p5.add(jp,BorderLayout.CENTER);
//            p5.remove(jp);
            table();
       
    
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setVisible(true);
    
}
public void table()
    {
        p5.remove(jp);
        p5.setVisible(false);
        Object[][] data={
        };
         String[] columnN={"id","Category"};
         DefaultTableModel mo=new DefaultTableModel(data,columnN);
         t1=new JTable(mo);
         t1.setPreferredScrollableViewportSize(new Dimension(500,50));
         t1.setFillsViewportHeight(true);
         jp=new JScrollPane(t1);
         p5.add(jp,BorderLayout.CENTER);
         ArrayList<User> list=getArrayList();
         DefaultTableModel model=(DefaultTableModel) t1.getModel();
         Object row[]=new Object[2];
          for(int i=0;i<list.size();i++)
            {
                row[0]=1+i;
                row[1]=list.get(i).getcategory();
                model.addRow(row);
                
            }
         
         p5.setVisible(true);
         click=0;
         t1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
             click();  
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
         
     });
    
    }
 public Connection getConnection()
    {
        
        String url="jdbc:mysql://localhost/mobile";
        String username="root";
        String pass="";
        Connection con=null;
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try {
                con=DriverManager.getConnection("jdbc:ucanaccess://C:\\db\\uniform.accdb");
            } catch (SQLException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            } 
            return con;
        
       
    }
ArrayList<User> getArrayList()
     {
         ArrayList<User> list=new ArrayList<User>();
        
    try {
        PreparedStatement st=null;
        Connection con=getConnection();
        st=con.prepareStatement("select * from category");
        ResultSet rs=null;
        rs=st.executeQuery();
        while(rs.next())
        { 
                User m=new User(rs.getString("cat_name"),"","","","");
                list.add(m);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(CatFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
     
     }
     String old="";
     int click=0;
     public void click()
    {
        click=1;
        int a=t1.getSelectedRow();
        TableModel mo=t1.getModel();
        f1.setText(mo.getValueAt(a, 1).toString());
        old=f1.getText();
    }
    
}
