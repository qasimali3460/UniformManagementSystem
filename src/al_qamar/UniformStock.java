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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Qasim
 */
public class UniformStock {
JFrame f;
JPanel p1,p2,p3,p4,p5,p6,p7;
JTabbedPane tb;
JTextField f1,f2,f3,f4;
JLabel l1,l2,l3,l4,l5,l6;
JComboBox cb1,cb2;
JButton b1,b2,b3,b4;
Dimension d;
JTable t1;
JScrollPane jp;
TitledBorder inner = BorderFactory.createTitledBorder("Category");
Border outer = BorderFactory.createEmptyBorder(5,5,5,5);    
Connection con=getConnection();
PreparedStatement st;
ResultSet rs;
int clicked=0;

UniformStock()
{
    frame();
    catUpdate();
    cat2Update();
    table();
}
JMenuBar menu=new JMenuBar();
JMenu category=new JMenu("Category");
        
public void cat2Update()
{
        try {
        update=1;
        cb2.removeAllItems();
        cb2.addItem("");
        st=con.prepareStatement("select * from category");
        rs=st.executeQuery();
        while(rs.next())
        {
            cb2.addItem(rs.getString("cat_name"));
        }
        cb2.setSelectedIndex(0);
        update=0;
    } catch (SQLException ex) {
        Logger.getLogger(UniformStock.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    

}
public void catUpdate()
{
    try {
        update=1;
        cb1.removeAllItems();
        cb1.addItem("All");
        st=con.prepareStatement("select * from category");
        rs=st.executeQuery();
        while(rs.next())
        {
            cb1.addItem(rs.getString("cat_name"));
        }
        cb1.setSelectedIndex(0);
        update=0;
    } catch (SQLException ex) {
        Logger.getLogger(UniformStock.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}
int cate=0;
int update=0;
public void frame()
{
    f=new JFrame();
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setSize(500,500);
    menu.add(category);
    category.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            CatFrame ct=new CatFrame();
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
    f.setJMenuBar(menu);
    
    p1=new JPanel(null);
    d=p1.getPreferredSize();
    d.height=80;
    p1.setPreferredSize(d);
    p1.setBackground(new Color(114,112,163));
    JLabel per=new JLabel("Al-Qamar uniforms");
    per.setBounds(450,15,500,60);
    per.setForeground(Color.white);
    per.setFont(new Font("Times New Roman",Font.BOLD,40));
    p1.setFont(new Font("Times New Roman",Font.BOLD,40));
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    p1.add(per);
    f.add(p1,BorderLayout.NORTH);
   
    tb=new JTabbedPane();
    tb.setBackground(new Color(114,112,163));
    f.add(tb);   
    p2=new JPanel(new BorderLayout());
    p2.setName("Stock");
    p3=new JPanel(new GridBagLayout());
    p2.add(p3,BorderLayout.WEST);
    d=p3.getPreferredSize();
    d.width=380;
    inner = BorderFactory.createTitledBorder("Detail");
    outer = BorderFactory.createEmptyBorder(5,5,5,5);    
    p3.setBorder(BorderFactory.createCompoundBorder(outer,inner));
    p3.setBackground(new Color(114,112,163));
    p3.setPreferredSize(d);
    detail();
  
    p6=new JPanel(new BorderLayout());
    p2.add(p6,BorderLayout.CENTER);
    
    p4=new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
    p4.setBackground(new Color(114,112,163));
    inner = BorderFactory.createTitledBorder("Category");
    outer = BorderFactory.createEmptyBorder(5,5,5,5);    
    p4.setBorder(BorderFactory.createCompoundBorder(outer,inner));
    p6.add(p4,BorderLayout.NORTH);
    d=p4.getPreferredSize();
    d.height=100;
    p4.setPreferredSize(d);
    l1=new JLabel("Select Category");
    l1.setForeground(Color.white);
    String[] sl={"All","Shirt","Paint"};
    cb1=new JComboBox(sl);
    catUpdate();
    cb1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(update==0)
            {
                if(cb1.getSelectedIndex()==0)
                {
                    cate=0;
                    table();
                }
                else
                {
                    cate=1;
                    table();
            
                }
            }
        }
    });
    p4.add(l1);
    p4.add(cb1);
    
    
    p5=new JPanel(new BorderLayout());
    inner=BorderFactory.createTitledBorder("Products");
    p5.setBorder(BorderFactory.createCompoundBorder(outer,inner));
    p5.setBackground(new Color(114,112,163));
    p6.add(p5,BorderLayout.CENTER);
  
        Object[][] data={
        };
            String[] columnN={"id","Category","Size","Color/School","Quantity","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t1=new JTable(mo);
            jp=new JScrollPane(t1);
            p5.add(jp,BorderLayout.CENTER);
//            p5.remove(jp);
            table();

    
    tb.add(p2);
    uniformSale usl=new  uniformSale();
    usl.setName("Sale");
    tb.add(usl);
    saleReport sr=new saleReport();
    sr.setName("Sale Report");
    tb.add(sr);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    

}
public void detail()
{
    l2=new JLabel("Size");
    l3=new JLabel("Color/School");
    l4=new JLabel("Category");
    l5=new JLabel("Quantity");
    l6=new JLabel("Price");
    
    f1=new JTextField("",15);
    f2=new JTextField("",15);
    cb2=new JComboBox();
    f3=new JTextField("",15);
    f4=new JTextField("",15);
        
    b1=new JButton("Insert");
    b2=new JButton("Update");
    b3=new JButton("Delete");
    b4=new JButton("Clear");
    
    b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           if(f1.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please Enter Size");
           }
           else
           {
               if(f2.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Please Enter Color/School");
               }
               else
               {
                   if(cb2.getSelectedIndex()==0)
                   {
                       JOptionPane.showMessageDialog(null, "Please select Category");
                   }
                   else
                   {
                       if(f3.getText().equals(""))
                       {
                           JOptionPane.showMessageDialog(null, "Please Enter Quantity");
                       }
                       else
                       {
                           if(uniformSale.pc(f3.getText())&&uniformSale.pc(f4.getText()))
                           {
                                if(f4.getText().equals(""))
                           {
                               JOptionPane.showMessageDialog(null, "Please Enter Price");
                           }
                           else
                           {
                               try {
                                   st=con.prepareStatement("select * from stock where size=? and school=? and category=?");
                                   st.setString(1,f1.getText());
                                   st.setString(2,f2.getText());
                                   st.setString(3,cb2.getSelectedItem().toString());
                                   rs=st.executeQuery();
                                   if(rs.next())
                                   {
                                       JOptionPane.showMessageDialog(null, "Item exist already");
                                   }
                                   else
                                   {
                                    st=con.prepareStatement("insert into stock(size,school,category,quantity,price)values(?,?,?,?,?)");
                                    st.setString(1, f1.getText());
                                    st.setString(2, f2.getText());
                                    st.setString(3, cb2.getSelectedItem().toString());
                                    st.setString(4, f3.getText());
                                    st.setString(5, f4.getText());
                                    if(st.executeUpdate()==1)
                                    {
                                        JOptionPane.showMessageDialog(null, "Item inserted Successfully");
                                        table();
                                         f1.setText("");
                                         f2.setText("");
                                         f3.setText("");
                                         f4.setText("");
                                        cb2.setSelectedIndex(0);
           
                                    }
                                    
                                   }
                               } catch (SQLException ex) {
                                   Logger.getLogger(UniformStock.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               
                           
                           }
                       
                           }
                          }
                   }
                   
               }
               
           }
        }
    
    });
    
    b2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(clicked==1)
            {
                 if(f1.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please Enter Size");
           }
           else
           {
               if(f2.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Please Enter Color/School");
               }
               else
               {
                   if(cb2.getSelectedIndex()==0)
                   {
                       JOptionPane.showMessageDialog(null, "Please select Category");
                   }
                   else
                   {
                       if(f3.getText().equals(""))
                       {
                           JOptionPane.showMessageDialog(null, "Please Enter Quantity");
                       }
                       else
                       {
                           if(UniformStock.pc(f3.getText()))
                           {
                               
                           if(f4.getText().equals(""))
                           {
                               JOptionPane.showMessageDialog(null, "Please Enter Price");
                           }
                           else
                           {
                          //     JOptionPane.showMessageDialog(null, "clear");
                               if(UniformStock.pc(f4.getText()))
                               {
                                       try {
                                    st=con.prepareStatement("update stock set quantity=?,price=? where size=? and school=? and category=?");
                                    st.setString(3, sc);
                                    st.setString(4, qc);
                                    st.setString(5,cc);
                                    st.setString(1, f3.getText());
                                    st.setString(2, f4.getText());
                                    if(st.executeUpdate()==1)
                                    {
                                        JOptionPane.showMessageDialog(null, "Updated Successfully");
                                        table();
                                         f1.setText("");
                                         f2.setText("");
                                         f3.setText("");
                                         f4.setText("");
                                        cb2.setSelectedIndex(0);
           
                                    }
                                    
                                   
                               } catch (SQLException ex) {
                                   Logger.getLogger(UniformStock.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               
                           
                               }
                           }
                           }
                           
                       }
                   }
                   
               }
               
           }
            }
        }
    
    
    });
    b3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click==1)
            {
                TableModel mo=t1.getModel();
                int a=t1.getSelectedRow();
                try {
                    st=con.prepareStatement("delete * from stock where size=? and school=? and category=?");
                    st.setString(1, mo.getValueAt(a, 2).toString());
                    st.setString(2, mo.getValueAt(a, 3).toString());
                    st.setString(3, mo.getValueAt(a, 1).toString());
                    
                    if(JOptionPane.showConfirmDialog(null, "Sure Delete ")==0)
                    {
                        if(st.executeUpdate()==1)
                        {
                            JOptionPane.showMessageDialog(null,"Deleted");
                            table();
                            f1.setText("");
                            f2.setText("");
                            f3.setText("");
                            f4.setText("");
                            cb2.setSelectedIndex(0);
                        }
                        }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(UniformStock.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        }
    
    });
    b4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            clicked=0;
            f1.setText("");
            f2.setText("");
            catUpdate();
            cat2Update();
            f3.setText("");
            f4.setText("");
            cb1.setSelectedIndex(0);
            table();
        }
        
    });
    
    
    GridBagConstraints gc=new GridBagConstraints();
    gc.insets=new Insets(10,10,10,10);
    gc.fill=GridBagConstraints.HORIZONTAL;
    gc.gridx=0;
    gc.gridy=0;
    p3.add(l4,gc);
    gc.gridx=1;
    gc.gridy=0;
    p3.add(cb2,gc);
    gc.gridx=0;
    gc.gridy=1;
    p3.add(l3,gc);
    gc.gridx=1;
    gc.gridy=1;
    p3.add(f2,gc);
    gc.gridx=0;
    gc.gridy=2;
    p3.add(l2,gc);
    gc.gridx=1;
    gc.gridy=2;
    p3.add(f1,gc);
    gc.gridx=0;
    gc.gridy=3;
    p3.add(l5,gc);
    gc.gridx=1;
    gc.gridy=3;
    p3.add(f3,gc);
    gc.gridx=0;
    gc.gridy=4;
    p3.add(l6,gc);
    gc.gridx=1;
    gc.gridy=4;
    p3.add(f4,gc);
     f3.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
              if((key>=e.VK_0&&key<=e.VK_9||key==KeyEvent.VK_BACK_SPACE   )) {
                    f3.setEditable(true);
                }
                else
                    f3.setEditable(false);
                 
                        }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
     f4.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
              if((key>=e.VK_0&&key<=e.VK_9||key==KeyEvent.VK_BACK_SPACE   )) {
                    f4.setEditable(true);
                }
                else
                    f4.setEditable(false);
                 
                        }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
    JPanel tp=new JPanel();
    JPanel tp2=new JPanel();
    tp.setBackground(new Color(114,112,164));
    tp2.setBackground(new Color(114,112,164));
    tp.add(b1);
    tp.add(b2);
    tp2.add(b3);
    tp2.add(b4);
    gc.gridx=1;
    gc.gridy=5;
    p3.add(tp,gc);
    gc.gridx=1;
    gc.gridy=6;
    p3.add(tp2,gc);
    
    


}
public static boolean pc(String check)
    {
        boolean st=true;
        if(check.contains("!")||check.contains("@")||check.contains("#")||check.contains("$")||check.contains("%")||check.contains("^")||check.contains("&")||check.contains("*")||check.contains("(")||check.contains(")")||check.contains("_")||check.contains("-")||check.contains("+")||check.contains("=")||check.contains("/")||check.contains(".")||check.contains(",")||check.contains("?")||check.contains(">")||check.contains("<"))
        {
            st=false;
            JOptionPane.showMessageDialog(null, "Please Enter Price and Quantity Correctly");
        }
        
        return st;
    }
    
public void table()
    {
        p5.remove(jp);
        p5.setVisible(false);
        Object[][] data={
        };
         String[] columnN={"id","Category","Size","Color/School","Quantity","Price"};
         DefaultTableModel mo=new DefaultTableModel(data,columnN);
         t1=new JTable(mo);
         t1.setPreferredScrollableViewportSize(new Dimension(500,50));
         t1.setFillsViewportHeight(true);
         jp=new JScrollPane(t1);
         p5.add(jp,BorderLayout.CENTER);
         ArrayList<User> list=getArrayList();
         DefaultTableModel model=(DefaultTableModel) t1.getModel();
         Object row[]=new Object[6];
          for(int i=0;i<list.size();i++)
            {
                row[0]=1+i;
                row[1]=list.get(i).getcategory();
                row[2]=list.get(i).getsize();
                row[3]=list.get(i).getschool();
                row[4]=list.get(i).getquantity();
                row[5]=list.get(i).getprice();
                model.addRow(row);
                
            }
         
          p5.setVisible(true);
          click=0;
          t1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
             clicked=1;
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
   public static Connection getConnection()
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
         PreparedStatement st=null;
         Connection con=getConnection();
        try {
            st=con.prepareStatement("select * from stock order by category asc");
            if(cate==1)
            {
            st=con.prepareStatement("select * from stock where category=?");
            st.setString(1, cb1.getSelectedItem().toString());
            }
            ResultSet rs=null;
            rs=st.executeQuery();
            while(rs.next())
            {
                User m=new User(rs.getString("category"),rs.getString("size"),rs.getString("school"),rs.getString("quantity"),rs.getString("price"));
                list.add(m);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     
     }
   String sc="";
   String qc="";
   String cc="";
   int click=0;
    public void click()
    
    {
        click=1;
        int a=t1.getSelectedRow();
        TableModel mo=t1.getModel();
        sc=mo.getValueAt(a, 2).toString();
        qc=mo.getValueAt(a, 3).toString();
        cc=mo.getValueAt(a, 1).toString();
        f1.setText(mo.getValueAt(a, 2).toString());
        f2.setText(mo.getValueAt(a, 3).toString());
        cb2.setSelectedItem(mo.getValueAt(a, 1));
        f3.setText(mo.getValueAt(a, 4).toString());
        f4.setText(mo.getValueAt(a, 5).toString());
        
//        f3.setText(mo.getValueAt(a, 4).toString());
//        ctf.setText(mo.getValueAt(a, 5).toString());
//        f5.setText(mo.getValueAt(a, 6).toString());
//        f7.setText(mo.getValueAt(a, 7).toString());
//        
    }

}
