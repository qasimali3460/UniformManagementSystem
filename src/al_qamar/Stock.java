/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Unknown
 */
public class Stock implements ActionListener{
    JFrame f;
    static int m=1;
    JLabel l1,l2,l3,l4,size,id,amount,price,school,color,add,stock,sale;
    JPanel p,p2,p3,p4,p5,p6;
    JTextField si,i,am,pr,sc,cl,ad,samount;
    JTable t,t2;
    JButton b,print,insert,delete,clear,sbutton;
    TitledBorder inner=BorderFactory.createTitledBorder("update");  
    javax.swing.border.Border outer=BorderFactory.createEmptyBorder(5,5,5,5);
    JScrollPane scrollPane;
    JTabbedPane tb;
    int tNo=0;
    
    public Stock()
    {
    f=new JFrame("Stock");
    f.setLayout(new BorderLayout());
    f.setSize(1280,740);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon ficon=new ImageIcon("images/logo2.png");
    f.setIconImage(ficon.getImage());
       
    //Border innerBorder=BorderFactory.createTitledBorder("Update");
   
    p=new JPanel(new BorderLayout());
  //  p.setBackground(Color.white);
    inner=BorderFactory.createTitledBorder("Total Stock");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            FlowLayout f2=new FlowLayout(FlowLayout.LEFT);
            p4=new JPanel(f2);
           p4.setBackground(Color.white);
            p.add(p4,BorderLayout.NORTH);
            
            ImageIcon m=new ImageIcon("images/backicon.png");
            JLabel back=new JLabel(m);
            back.setSize(m.getIconWidth(),m.getIconHeight());
            back.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            tNo=0;
            p.remove(scrollPane);
            p.setVisible(false);
            showTotalTable();
            p.setVisible(true);
           clear(); 
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
                
            });
            
    
    p4.add(back);
    p4.add(new JLabel("                                                            "));
    m=new ImageIcon("images/sc.jpg");
    p4.add(new JLabel(m));
  
    f.add(p,BorderLayout.CENTER);
   
    tb=new JTabbedPane();
    p2=new JPanel();
    p2.setName("Update");
    p6=new JPanel();
    p6.setLayout(null);
    p6.setName("Sale");
    sale=new JLabel("Enter Amount :");
    sale.setBounds(50,197,200,50);
    p6.add(sale);
    samount=new JTextField();
    samount.setBounds(150,210,200,30);
    p6.add(samount);
    sbutton=new JButton("Sale");
    sbutton.setBounds(270,270,80,30);
    sbutton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String amo=am.getText();
            String samo=samount.getText();
            if(!amo.equals("0"))
            {
               if(Integer.parseInt(samo)>Integer.parseInt(amo))
               {
                   JOptionPane.showMessageDialog(null,"Please Enter a valid value");
               }
               else{
                   int r=Integer.parseInt(amo)-Integer.parseInt(samo);
                   am.setText(String.valueOf(r));
                   update();
               }
            }
        }
        
    });
    p6.add(sbutton);
    // p2.setBackground(Color.blue);
   f.add(tb,BorderLayout.WEST);
   tb.add(p2);
   tb.add(p6);
   p6.setVisible(true); 
    Dimension d=p2.getPreferredSize();
    d.width=400;
    p2.setPreferredSize(d);
   p2.setBorder(BorderFactory.createCompoundBorder(outer,inner));
   p2.setLayout(null);
   size=new JLabel("Size:");
   id=new JLabel("Id :");
   amount=new JLabel("Amount :");
   add=new JLabel("Add");
   price=new JLabel("Price :");
   color=new JLabel("Color");
   school=new JLabel("School");
   si=new JTextField(10);
   i=new JTextField(10);
   am=new JTextField(10);
   ad=new JTextField(10);
   pr=new JTextField(10);
   cl=new JTextField(10);
   sc=new JTextField(10);
   id.setBounds(50,30,100,100);
   p2.add(id);
   i.setBounds(120,65,250,30);
   p2.add(i);
  
   size.setBounds(50,100,100,100);
   p2.add(size);
   si.setBounds(120,140,250,30);
   p2.add(si);
   amount.setBounds(50,170,100,100);
   p2.add(amount);
   am.setBounds(120,205,80,30);
   p2.add(am);
   add.setBounds(210,170,100,100);
   p2.add(add);
   ad.setBounds(250,205,120,30);
   p2.add(ad);
   price.setBounds(50,230,100,100);
   p2.add(price);
   pr.setBounds(120,270,250,30);
   p2.add(pr);
   color.setBounds(50,320,100,50);
   p2.add(color);
   cl.setBounds(120,330,250,30);
   p2.add(cl);
   school.setBounds(50,380,100,50);
   p2.add(school);
   sc.setBounds(120,390,250,30);
   p2.add(sc);
   b=new JButton("Update");
   b.setBounds(290,450,80,30);
   b.addActionListener(this);
   p2.add(b);
   insert=new JButton("Insert");
   insert.setBounds(50,450,80,30);
   p2.add(insert);
   delete=new JButton("Delete");
   delete.setBounds(175,450,80,30);
   delete.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          if(tNo!=0)
          {
              int a=JOptionPane.showConfirmDialog(null,"Delete?");
              if(a==0)
              {
                  delete();
                  clear();
          
              }
          }
       }
       
   });
   p2.add(delete);
   clear=new JButton("Clear");
   clear.setBounds(290,500,80,30);
   p2.add(clear);
   clear.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            clear();
        }
       
   });
   
   insert.addActionListener(this);
   print=new JButton("Print All");
   print.setBounds(10,550,380,30);
   p2.add(print);
   print.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                t.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
   });
   
 
    p3=new JPanel(f2);
   // p3.setBackground(Color.yellow);
    f.add(p3,BorderLayout.NORTH);
    d=p3.getPreferredSize();
    d.height=80;
    p3.setPreferredSize(d);
    p3.setBorder(BorderFactory.createEtchedBorder());
    m=new ImageIcon("images/backicon.png");        
    JLabel backf=new JLabel(m);
            backf.setSize(m.getIconWidth(),m.getIconHeight());
            backf.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            f.dispose();
            Menue m1=new Menue();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            backf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
                
            });
            p3.add(backf);
            p3.add(new JLabel("                                                                                                 "));
            m=new ImageIcon("images/name.png");
            stock=new JLabel(m);
            p3.add(stock);
        //    show_values_table();
            showTotalTable();
       if(Stock.m==2)
       {
           tb.remove(p2);
           tb.remove(p6);
           tb.add(p6);
           tb.add(p2);
       }
            
            f.setVisible(true);
    }
    public void showStable()
    {
        
     if(tNo==3||tNo==5||tNo==4||tNo==6||tNo==15)
        {
            Object[][] data={};
            String[] columnN={"id","Size","Color","Amount","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t=new JTable(mo);
            t.setPreferredScrollableViewportSize(new Dimension(500,50));
            t.setFillsViewportHeight(true);
            scrollPane=new JScrollPane(t);
            p.add(scrollPane,BorderLayout.CENTER);
            ArrayList<User> list=getUserList();
            DefaultTableModel model=(DefaultTableModel) t.getModel();
            Object[] row= new Object[5];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getsize();
                row[2]=list.get(i).getcolor();
                row[3]=list.get(i).getamount();
                row[4]=list.get(i).getprice();
                model.addRow(row);
                
            }
    
        }
        
        if(tNo==1||tNo==2||tNo==10||tNo==11||tNo==12||tNo==9||tNo==8||tNo==7||tNo==17||tNo==19)
        {
            Object[][] data={};
            String[] columnN={"id","School","Size","amount","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t=new JTable(mo);
            t.setPreferredScrollableViewportSize(new Dimension(500,50));
            t.setFillsViewportHeight(true);
            scrollPane=new JScrollPane(t);
            p.add(scrollPane,BorderLayout.CENTER);
            ArrayList<User> list=getUserList();
            DefaultTableModel model=(DefaultTableModel) t.getModel();
            Object[] row= new Object[5];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getschool();
                row[2]=list.get(i).getsize();
                row[3]=list.get(i).getamount();
                row[4]=list.get(i).getprice();
                model.addRow(row);
                
            }
       
        }
        
        if(tNo==20||tNo==14)
        {
            Object[][] data={};
            String[] columnN={"id","School","amount","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t=new JTable(mo);
            t.setPreferredScrollableViewportSize(new Dimension(500,50));
            t.setFillsViewportHeight(true);
            scrollPane=new JScrollPane(t);
            p.add(scrollPane,BorderLayout.CENTER);
            ArrayList<User> list=getUserList();
            DefaultTableModel model=(DefaultTableModel) t.getModel();
            Object[] row= new Object[4];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getschool();
                row[2]=list.get(i).getamount();
                row[3]=list.get(i).getprice();
                model.addRow(row);
                
            }
       
        
        } if(tNo==13||tNo==16||tNo==18)
        {
            Object[][] data={};
            String[] columnN={"id","color","size","amount","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t=new JTable(mo);
            t.setPreferredScrollableViewportSize(new Dimension(500,50));
            t.setFillsViewportHeight(true);
            scrollPane=new JScrollPane(t);
            p.add(scrollPane,BorderLayout.CENTER);
            ArrayList<User> list=getUserList();
            DefaultTableModel model=(DefaultTableModel) t.getModel();
            Object[] row= new Object[5];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getcolor();
                row[2]=list.get(i).getsize();
                row[3]=list.get(i).getamount();
                row[4]=list.get(i).getprice();
                model.addRow(row);
            }
       
        
        }
        
     t.addMouseListener(new MouseListener(){
         @Override
         public void mouseClicked(MouseEvent e) {
             if(tNo==16||tNo==13||tNo==18||tNo==5||tNo==4||tNo==3||tNo==6||tNo==15)
             {
                
                int a=t.getSelectedRow();
                TableModel mod=t.getModel();
                i.setText(mod.getValueAt(a,0).toString());
                si.setText(mod.getValueAt(a,1).toString());
                cl.setText(mod.getValueAt(a,2).toString());
                am.setText(mod.getValueAt(a,3).toString());
                pr.setText(mod.getValueAt(a,4).toString());
                
            }
             if(tNo==1||tNo==2||tNo==10||tNo==11||tNo==12||tNo==9||tNo==8||tNo==7||tNo==17||tNo==19)
             {
                int a=t.getSelectedRow();
                TableModel mod=t.getModel();
                i.setText(mod.getValueAt(a,0).toString());
                sc.setText(mod.getValueAt(a,1).toString());
                si.setText(mod.getValueAt(a,2).toString());
                am.setText(mod.getValueAt(a,3).toString());
                pr.setText(mod.getValueAt(a,4).toString());
                
            }if(tNo==14||tNo==20)
             {
                int a=t.getSelectedRow();
                TableModel mod=t.getModel();
                i.setText(mod.getValueAt(a,0).toString());
                sc.setText(mod.getValueAt(a,1).toString());
                am.setText(mod.getValueAt(a,2).toString());
                pr.setText(mod.getValueAt(a,3).toString());
                
            }
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
    
    public void showTotalTable()
    {
// 
            
            Object[][] data={};
            String[] columnN={"id","Product","Amount"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t=new JTable(mo);
            scrollPane=new JScrollPane(t);
            p.add(scrollPane,BorderLayout.CENTER);
            ArrayList<User> list=getUserList();
            DefaultTableModel model=(DefaultTableModel) t.getModel();
            Object[] row= new Object[3];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getproduct();
                row[2]=list.get(i).gettotal();
                model.addRow(row);
                
            }
       
            t.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
        int a=t.getSelectedRow();
        TableModel mod=t.getModel();
        tNo=Integer.parseInt(mod.getValueAt(a,0).toString());
        p.remove(scrollPane);
       p.setVisible(false);
       p.setVisible(true);
        showStable();
        getmax();
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
            
            }
            
            ); 
    }
    Connection getConnection()
    {
        
        String url="jdbc:mysql://localhost/al_qamar_uniform";
        String username="root";
        String pass="";
        try {
            Connection con=DriverManager.getConnection(url, username, pass);
            return con;
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
        return null;
    }
    public void getmax(){
        String[] query={
           "select max(id) from shirt_kt","select max(id) from college_shirt",
           "select max(id) from pant_fusebelt","select max(id) from pant_elastic",
           "select max(id) from coat","select max(id) from sweater",
           "select max(id) from jersery","select max(id) from jersery_open",
           "select max(id) from girls_suit","select max(id) from frock",
           "select max(id) from dupata","select max(id) from down_skirt",
           "select max(id) from blouse","select max(id) from sash_patti_plane",
           "select max(id) from lagie","select max(id) from belt",
           "select max(id) from logo","select max(id) from socks",
           "select max(id) from tie_plane","select max(id) from pocket_badge"
        };
        Connection con=getConnection();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query[tNo-1]);
            String max="";
            while(rs.next())
            {
                max=rs.getString("max(id)");
            }
            int m=Integer.valueOf(max);
            i.setText(String.valueOf((m+1)));
           
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
       public int[] getTotal()
       {
           int[] a=new int[20];
           Connection con=getConnection();
       String[] query={"select sum(amount) from shirt_kt","select sum(amount) from college_shirt ","select sum(amount) from pant_fuseBelt ",
       "select sum(amount) from pant_elastic ","select sum(amount) from coat ",
       "select sum(amount) from sweater ","select sum(amount) from jersery ",
       "select sum(amount) from jersery_open ","select sum(amount) from girls_suit ",
       "select sum(amount) from frock ","select sum(amount) from dupata ","select sum(amount) from down_skirt ",
       "select sum(amount) from blouse ","select sum(amount) from sash_patti_plane ","select sum(amount) from lagie ","select sum(amount) from belt ","select sum(amount) from logo ",
       "select sum(amount) from socks ","select sum(amount) from tie_plane ","select sum(amount) from pocket_badge "       
       };
       Statement st;
           for(int i=0;i<=19;i++)
           {
                try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery(query[i]);
            while(rs.next())
            {
                String ab=rs.getString("sum(amount)");
                a[i]=Integer.parseInt(ab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }
           
          return a;
       }
   ArrayList<User> getUserList()
   {
       ArrayList<User> list=new ArrayList<User>();
      
       if(tNo==0)
       {
            list=new ArrayList<User>();
            inner=BorderFactory.createTitledBorder("Total Stock");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
       Connection con=getConnection();
       String query="select * from total_stock";
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int[] a=getTotal();
            int b=0;
            while(rs.next())
            {
                User s=new User(rs.getInt("id"),"","","","","",rs.getString("products"),a[b]);
                list.add(s);
                b++;
            }
            
          
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list; 
   
           
       }
       if(tNo==3||tNo==4||tNo==5||tNo==6||tNo==15)
       {
       list=new ArrayList<User>();
       Connection con=getConnection();
       String query="l"; 
       if(tNo==5)
        {
           inner=BorderFactory.createTitledBorder("Coat");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
          query="select * from coat";
        } if(tNo==15)
        {
            inner=BorderFactory.createTitledBorder("Lagie");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
          query="select * from lagie";
        }
        if(tNo==4)
        {
            inner=BorderFactory.createTitledBorder("Pant Elastic");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from pant_elastic";
        }
        if(tNo==3)
        {
            inner=BorderFactory.createTitledBorder("Pant FuseBelt");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from pant_fusebelt";
        }if(tNo==6)
        {
            inner=BorderFactory.createTitledBorder("Sweater");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from sweater";
        }
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int[] a=getTotal();
            int b=0;
            while(rs.next())
            {
                User s=new User(rs.getInt("id"),rs.getString("size"),rs.getString("color"),"",rs.getString("amount"),rs.getString("price"),"",a[b]);
                list.add(s);
                b++;
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list; 
   
           
       }
       if(tNo==18||tNo==16||tNo==13)
       {
       list=new ArrayList<User>();
       Connection con=getConnection();
       String query="l"; 
       if(tNo==18)
        {
            inner=BorderFactory.createTitledBorder("Socks");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
          query="select * from socks";
        }
        if(tNo==16)
        {
            inner=BorderFactory.createTitledBorder("Belt");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from belt";
        }
        if(tNo==13)
        {
            inner=BorderFactory.createTitledBorder("Total B");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from blouse";
        }
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int[] a=getTotal();
            int b=0;
            while(rs.next())
            {
                User s=new User(rs.getInt("id"),rs.getString("size"),rs.getString("color"),"",rs.getString("amount"),rs.getString("price"),"",a[b]);
                list.add(s);
                b++;
            }
            
          
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list; 
   
           
       }if(tNo==20||tNo==14)
       {
       list=new ArrayList<User>();
       Connection con=getConnection();
       String query="l"; 
       if(tNo==20)
        {
            inner=BorderFactory.createTitledBorder("Pocket Badge");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
          query="select * from pocket_badge";
        }
        if(tNo==14)
        {
            inner=BorderFactory.createTitledBorder("Sash Patti Plane");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from sash_patti_plane";
        }
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int[] a=getTotal();
            int b=0;
            while(rs.next())
            {
                User s=new User(rs.getInt("id"),"","",rs.getString("school"),rs.getString("amount"),rs.getString("price"),"",a[b]);
                list.add(s);
                b++;
            }
            
          
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list; 
   
           
       }if(tNo==1||tNo==2||tNo==10||tNo==11||tNo==12||tNo==9||tNo==8||tNo==7||tNo==17||tNo==19)
       {
       list=new ArrayList<User>();
       Connection con=getConnection();
       String query="l"; 
       if(tNo==1)
        {
            inner=BorderFactory.createTitledBorder("Shirt KT");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
          query="select * from shirt_kt";
        }
        if(tNo==2)
        {
            inner=BorderFactory.createTitledBorder("College Shirt");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from college_shirt";
        }
        if(tNo==10)
        {
            inner=BorderFactory.createTitledBorder("Frock");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            query="select * from frock";
        }
        if(tNo==11)
        {
            inner=BorderFactory.createTitledBorder("Duppata");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from dupata";
        }if(tNo==12)
        {
            inner=BorderFactory.createTitledBorder("Down skirt");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from down_skirt";
        }if(tNo==9)
        {
            inner=BorderFactory.createTitledBorder("Girls Suit");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from girls_suit";
        }if(tNo==8)
        {
            inner=BorderFactory.createTitledBorder("Jersery Open");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from jersery_open";
        }if(tNo==7)
        {
            inner=BorderFactory.createTitledBorder("Jersery");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from jersery";
        }if(tNo==17)
        {
            inner=BorderFactory.createTitledBorder("Logo");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from logo";
        }if(tNo==19)
        {
            inner=BorderFactory.createTitledBorder("Tie Plane");
            p.setBorder(BorderFactory.createCompoundBorder(outer,inner));
            
            query="select * from tie_plane";
        }
       Statement st;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int[] a=getTotal();
            int b=0;
            while(rs.next())
            {
                User s=new User(rs.getInt("id"),rs.getString("size"),"",rs.getString("school"),rs.getString("amount"),rs.getString("price"),"",a[b]);
                list.add(s);
                b++;
            }
            
          
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list; 
   
           
       }
       else
      {
       
//       ArrayList<User> list=new ArrayList<User>();
//       Connection con=getConnection();
//       String query="select * total_Stock";
//       Statement st;
//        try {
//            st = con.createStatement();
//            ResultSet rs=st.executeQuery(query);
//            int total[]=getTotal();
//            int a=1;
//            while(rs.next())
//            {
//                User s=new User(a,rs.getString("size")," ",rs.getString("school"),rs.getString("amount"),rs.getString("price"),rs.getString("product"),0);
//                list.add(s);
//                a++;
//            }
//            
//          
//            
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
//        }
     return null;              
              }
   }
   public void show_values_table()
   {
       ArrayList<User> list=getUserList();
         //DefaultTableModel model=(DefaultTableModel)t.getModel();
         DefaultTableModel model=(DefaultTableModel) t.getModel();
         Object[] row= new Object[6];
            for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getId();
                row[1]=list.get(i).getsize();
                row[2]=list.get(i).getcolor();
                row[3]=list.get(i).getschool();
                row[4]=list.get(i).getamount();
                row[5]=list.get(i).getprice();
                model.addRow(row);
                
            }
       
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b)
        {
            update();
          }
        if(e.getSource()==insert)
        {
            if(tNo==16||tNo==13||tNo==18||tNo==5||tNo==4||tNo==3||tNo==6||tNo==15)
            {
               String query="";
                if(tNo==13)
                {
                    query="insert into blouse(id,size,color,amount,price)values(?,?,?,?,?)";
                }
                if(tNo==18)
                {
                    query="insert into socks(id,size,color,amount,price)values(?,?,?,?,?)";
                }
                if(tNo==16)
                {
                    query="insert into belt(id,size,color,amount,price)values(?,?,?,?,?)";
                }
                if(tNo==5)
                {
                    query="insert into coat(id,size,color,amount,price)values(?,?,?,?,?)t";
                } if(tNo==15)
                {
                    query="insert into lagie(id,size,color,amount,price)values(?,?,?,?,?)";
                }
                if(tNo==4)
                {
                    query="insert into pant_elastic(id,size,color,amount,price)values(?,?,?,?,?)";
                }
                if(tNo==3)
                {
                    query="insert into pant_fusebelt(id,size,color,amount,price)values(?,?,?,?,?)";
                 }
                if(tNo==6)
                {
                    query="insert into sweater(id,size,color,amount,price)values(?,?,?,?,?)";
                }
               String ii=i.getText();
               String sii=si.getText();
               String cli=cl.getText();
               String ami=am.getText();
               String pri=pr.getText();
               Connection con=getConnection();
                try {
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1, ii);
                    st.setString(2, sii);
                    st.setString(3, cli);
                    st.setString(4, ami);
                    st.setString(5, pri);
                    if(st.executeUpdate()==1)
                    {
                        JOptionPane.showMessageDialog(null, "inserted");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.remove(scrollPane);
                p.setVisible(false);
                showStable();
                p.setVisible(true);
            }
        if(tNo==20||tNo==14)
            {
               String query="";
                if(tNo==20)
                {
                    query="insert into pocket_badge(id,school,amount,price)values(?,?,?,?)";
                }
                if(tNo==14)
                {
                    query="insert into sash_patti_plane(id,school,color,amount,price)values(?,?,?,?)";
                }
               String ii=i.getText();
               String sci=sc.getText();
               String ami=am.getText();
               String pri=pr.getText();
                Connection con=getConnection();
                try {
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1, ii);
                    st.setString(2, sci);
                    st.setString(3, ami);
                    st.setString(4, pri);
                    if(st.executeUpdate()==1)
                    {
                        JOptionPane.showMessageDialog(null, "inserted");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.remove(scrollPane);
                p.setVisible(false);
                showStable();
                p.setVisible(true);
            }
            if(tNo==2||tNo==12||tNo==11||tNo==10||tNo==9||tNo==7||tNo==8||tNo==17||tNo==1||tNo==19)
            {
               String query="";
                if(tNo==2)
                {
                    query="insert into college_shirt(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==12)
                {
                    query="insert into down_skirt(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==11)
                {
                    query="insert into dupata(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==10)
                {
                    query="insert into forck(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==9)
                {
                    query="insert into girls_suit(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==7)
                {
                    query="insert into jersery(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==8)
                {
                    query="insert into jersery_open(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==17)
                {
                   
                    query="insert into logo(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==1)
                {
                    query="insert into shirt_kt(id,size,school,amount,price)values(?,?,?,?,?)";
                }if(tNo==19)
                {
                    query="insert into tie_plane(id,size,school,amount,price)values(?,?,?,?,?)";
                }
               String ii=i.getText();
               String sii=si.getText();
               String sci=sc.getText();
               String ami=am.getText();
               String pri=pr.getText();
               Connection con=getConnection();
                try {
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1, ii);
                    st.setString(2, sii);
                    st.setString(3, sci);
                    st.setString(4, ami);
                    st.setString(5, pri);
                    if(st.executeUpdate()==1)
                    {
                        JOptionPane.showMessageDialog(null, "inserted");
                    }
                    
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please fill All Relative Fields ");
                        }
                p.remove(scrollPane);
                p.setVisible(false);
                showStable();
                p.setVisible(true);
            }
        }
   
    }
 void clear()
 {
     i.setText("");
     am.setText("");
     si.setText("");
     cl.setText("");
     sc.setText("");
     pr.setText("");
     ad.setText("");
     if(tNo!=0)
     {
         getmax();
     }
 }
 
 void delete()
 {
    if(t.getRowCount()==1)
    {
        JOptionPane.showMessageDialog(null, "This row cannot be deleted");
        return;
    }
     if(tNo==16||tNo==13||tNo==18||tNo==3||tNo==4||tNo==5||tNo==6||tNo==15)
            {
            Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
                if(tNo==16)
                {
                    query="Delete  from belt where id="+i.getText()+"";
                }
                if(tNo==13)
                {
                    query="Delete  from blouse where id="+i.getText()+"";
                 }
                if(tNo==18)
                {
                    query="Delete  from socks where id="+i.getText()+"";
                }
                if(tNo==5)
        {
                    query="Delete  from coat where id="+i.getText()+"";
        } if(tNo==15)
        {
                    query="Delete  from lagie where id="+i.getText()+"";
        }
        if(tNo==4)
        {
                    query="Delete  from pant_elastic where id="+i.getText()+"";
        }
        if(tNo==3)
        {
                    query="Delete  from pant_fuse_belt where id="+i.getText()+"";
        }if(tNo==6)
        {
                    query="Delete  from sweater where id="+i.getText()+"";
        }
       
                st=con.prepareStatement(query);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
            JOptionPane.showMessageDialog(null, "Deleted");
            }
    if(tNo==1||tNo==2||tNo==10||tNo==11||tNo==12||tNo==9||tNo==8||tNo==7||tNo==17||tNo==19)
            {
                Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
          if(tNo==1)
          {
                    query="Delete  from shirt_kt where id="+i.getText()+"";
        }
        if(tNo==2)
        {
                    query="Delete  from college_shirt where id="+i.getText()+"";
        }
        if(tNo==10)
        {
                    query="Delete  from forck where id="+i.getText()+"";
           }
        if(tNo==11)
        {
                    query="Delete  from dupata where id="+i.getText()+"";
      }if(tNo==12)
        {
                    query="Delete  from down_skirt where id="+i.getText()+"";
       }if(tNo==9)
        {
                    query="Delete  from forck where id="+i.getText()+"";
        }if(tNo==8)
        {
                    query="Delete  from jersery_open where id="+i.getText()+"";
      }if(tNo==7)
        {
                    query="Delete  from jersery where id="+i.getText()+"";
        }if(tNo==17)
        {
                    query="Delete  from logo where id="+i.getText()+"";
        }if(tNo==19)
        {
                    query="Delete  from tie_plane where id="+i.getText()+"";
      }
                st=con.prepareStatement(query);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
             JOptionPane.showMessageDialog(null, "Deleted");
           }
    if(tNo==14||tNo==20)
            {
            Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
          if(tNo==20)
          {
                    query="Delete  from pocket_badge where id=?";
        }
        if(tNo==14)
        {
                    query="Delete  from sash_patti_plane where id=?";
        }
                
                st=con.prepareStatement(query);
               String ii=i.getText();
                st.setString(1, ii);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
            JOptionPane.showMessageDialog(null, "Deleted");
            }
        
 
 }
void update()
{
      if(tNo==16||tNo==13||tNo==18||tNo==3||tNo==4||tNo==5||tNo==6||tNo==15)
            {
                String sizeu=si.getText();
                String amountu;
                if(ad.getText().isEmpty())
                {
                        amountu=am.getText();
                   }
                else{
                     int a=t.getSelectedRow();
                    TableModel mod=t.getModel();
                   int amo=Integer.parseInt(mod.getValueAt(a,3).toString());
                   int adda=Integer.valueOf(ad.getText());
                   amountu=String.valueOf(amo+adda);
                
                }
                String priceu=pr.getText();
                String coloru=cl.getText();
            Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
                if(tNo==16)
                {
                    query="update belt set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
                }
                if(tNo==13)
                {
                 query="update blouse set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
                 }
                if(tNo==18)
                {
                    query="update socks set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
                }
                if(tNo==5)
        {
          query="update coat set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
        } if(tNo==15)
        {
          query="update lagie set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
        }
        if(tNo==4)
        {
            query="update pant_elastic set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
        }
        if(tNo==3)
        {
            query="update pant_fusebelt set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
        }if(tNo==6)
        {
            query="update sweater set amount=?, color=?, price=?, size=?    where id="+i.getText()+"";
        }
       
                st=con.prepareStatement(query);
                st.setString(1, amountu);
                st.setString(2, coloru);
                st.setString(3, priceu);
                st.setString(4, sizeu);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
            }
    if(tNo==1||tNo==2||tNo==10||tNo==11||tNo==12||tNo==9||tNo==8||tNo==7||tNo==17||tNo==19)
            {
                String sizeu=si.getText();
                String amountu;
                if(ad.getText().isEmpty())
                {
                        amountu=am.getText();
                   }
                else{
                     int a=t.getSelectedRow();
                    TableModel mod=t.getModel();
                   int amo=Integer.parseInt(mod.getValueAt(a,3).toString());
                   int adda=Integer.valueOf(ad.getText());
                   amountu=String.valueOf(amo+adda);
                
                }
                String priceu=pr.getText();
                String schoolu=sc.getText();
            Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
          if(tNo==1)
          {
            query="update shirt_kt set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
        }
        if(tNo==2)
        {
           query="update college_shirt set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
        }
        if(tNo==10)
        {
           query="update frock set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
           }
        if(tNo==11)
        {
          query="update dupata set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
      }if(tNo==12)
        {
         query="update down_skirt set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
       }if(tNo==9)
        {
         query="update girls_suit set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
        }if(tNo==8)
        {
         query="update jersery_open set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
      }if(tNo==7)
        {
         query="update jersery set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
        }if(tNo==17)
        {
         query="update logo set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
        }if(tNo==19)
        {
         query="update tie_plane set amount=?, school=?, price=?, size=?    where id="+i.getText()+"";
      }
                st=con.prepareStatement(query);
                st.setString(1, amountu);
                st.setString(2, schoolu);
                st.setString(3, priceu);
                st.setString(4, sizeu);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
            }
    if(tNo==14||tNo==20)
            {
                String sizeu=si.getText();
                String amountu;
                if(ad.getText().isEmpty())
                {
                        amountu=am.getText();
                   }
                else{
                     int a=t.getSelectedRow();
                    TableModel mod=t.getModel();
                   int amo=Integer.parseInt(mod.getValueAt(a,2).toString());
                   int adda=Integer.valueOf(ad.getText());
                   amountu=String.valueOf((amo+adda));
       
                }
                String priceu=pr.getText();
                String schoolu=sc.getText();
            Connection con=getConnection();
            PreparedStatement st;
            try {
                String query="";
          if(tNo==20)
          {
            query="update pocket_badge set amount=?, school=?, price=?     where id="+i.getText()+"";
        }
        if(tNo==14)
        {
           query="update sash_patti_plane set amount=?, school=?, price=? where id="+i.getText()+"";
        }
                st=con.prepareStatement(query);
                st.setString(1, amountu);
                st.setString(2, schoolu);
                st.setString(3, priceu);
                st.executeUpdate();
                st.close();
                p.remove(scrollPane);
                showStable();
                p.setVisible(false);
               p.setVisible(true);
               clear();
            } catch (SQLException ex) {
        System.out.print(ex);
                }
            }
        
}
}

