package al_qamar;


import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.Dimension;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class uniformSale extends JPanel {

    JPanel p1,p2,p3,p4,p5;
    JSpinner js;
    JComboBox cb1,cb2,cb3;
    JButton b1,b2,b3,b4,b5;
    JTable t1;
    Dimension d;
    JScrollPane jp;
    JTextField f1,f2,f3,f4;
    TitledBorder inner = BorderFactory.createTitledBorder("Sale");
    Border outer = BorderFactory.createEmptyBorder(5,5,5,5);    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JDateChooser df;
    Connection con=getConnection();
    PreparedStatement st;
    ResultSet rs;
    int q=0;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    int click=0;
    uniformSale()
    {
        this.setLayout(new BorderLayout());
        frame();
        catUpdate();
    }
    public static boolean pc(String check)
    {
        boolean st=true;
        System.out.print(check);
        if(check.contains("!")||check.contains("@")||check.contains("#")||check.contains("$")||check.contains("%")||check.contains("^")||check.contains("&")||check.contains("*")||check.contains("(")||check.contains(")")||check.contains("_")||check.contains("-")||check.contains("+")||check.contains("=")||check.contains("/")||check.contains(".")||check.contains(",")||check.contains("?")||check.contains(">")||check.contains("<"))
        {
            st=false;
            JOptionPane.showMessageDialog(null, "Please Enter Quantity and Price Correctly");
        }
        
        return st;
    }
    
    public void frame()
    {
        p1=new JPanel(new GridBagLayout());
        p1.setBackground(new Color(114,112,164));
        d=p1.getPreferredSize();
        d.width=380;
        p1.setPreferredSize(d);
        p1.setBorder(BorderFactory.createCompoundBorder(outer,inner));
        l1=new JLabel("Category");
        l2=new JLabel("Size");
        l3=new JLabel("Color/School");
        l4=new JLabel("Quantity");
        l5=new JLabel("Unit Price");
        l6=new JLabel("Date");
        l7=new JLabel("Name");
        
        js=new JSpinner();
        js.setValue(1);
        cb1=new JComboBox();
        cb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(update==0)
                {
                    if(cb1.getSelectedIndex()==0)
                    {
                        update=1;
                        cb2.removeAllItems();
                        cb3.removeAllItems();
                        update=0;
                    }
                    else
                    {
                        scUpdate();
                    }
                }
            }
        });
        cb2=new JComboBox();
        cb3=new JComboBox();
        cb3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(update==0)
                {
                    if(cb3.getSelectedIndex()==0)
                    {
                        update=1;
                        cb2.removeAllItems();
                        update=0;
                    }
                    else
                    {
                        siUpdate();
                    }
                }
            }
        });
        
        f1=new JTextField("",15);
         f1.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if((key>=e.VK_0&&key<=e.VK_9||key==KeyEvent.VK_BACK_SPACE   ))
                {
                    f1.setEditable(true);
                }
                else
                    f1.setEditable(false);
                 
                        }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
        f2=new JTextField("",15);
        df=new JDateChooser();
        
        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.insets=new Insets(10,10,10,10);
        gc.gridx=0;
        gc.gridy=0;
        p1.add(l1,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        p1.add(cb1,gc);
        
        gc.gridx=0;
        gc.gridy=2;
        p1.add(l2,gc);
        
        gc.gridx=1;
        gc.gridy=2;
        p1.add(cb2,gc);
        
        gc.gridx=0;
        gc.gridy=1;
        p1.add(l3,gc);
        
        gc.gridx=1;
        gc.gridy=1;
        p1.add(cb3,gc);
        
        gc.gridx=0;
        gc.gridy=3;
        p1.add(l4,gc);
        
        gc.gridx=1;
        gc.gridy=3;
        p1.add(js,gc);
        
        gc.gridx=0;
        gc.gridy=4;
        p1.add(l5,gc);
        
        gc.gridx=1;
        gc.gridy=4;
        p1.add(f1,gc);
        
        b1=new JButton("Add to Sale");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb1.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(null, "Please Select Category");
                }
                else
                {
                    if(cb3.getSelectedIndex()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Please Select Color/School");
                    }
                    else
                    {
                        if(cb2.getSelectedIndex()==0)
                        {
                         JOptionPane.showMessageDialog(null, "Please Select Size");   
                            
                        }
                        else
                        {
                            if(Integer.parseInt(js.getValue().toString())<=0)
                            {
                               JOptionPane.showMessageDialog(null, "Please Enter Quantity correctly");
                            }
                            else
                            {
                             if(UniformStock.pc(js.getValue().toString()))
                             {
                                       try {
                                    st=con.prepareStatement("select * from stock where category=? and size=? and school=?");
                                    st.setString(1,cb1.getSelectedItem().toString());
                                    st.setString(2,cb2.getSelectedItem().toString());
                                    st.setString(3,cb3.getSelectedItem().toString());
                                    rs=st.executeQuery();
                                 
                                    while(rs.next())
                                    {
                                        q=Integer.valueOf(rs.getString("quantity"));
                                    }
                                    if(q<Integer.valueOf(js.getValue().toString()))
                                    {
                                        JOptionPane.showMessageDialog(null,"limited Stock");
                                    }
                                    else
                                    {
                                     if(uniformSale.pc(f1.getText())&&uniformSale.pc(js.getValue().toString()))
                                     {
                                            if(f1.getText().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null, "Please Enter Unit Price");
                                        }
                                        else
                                        {
                                            st=con.prepareStatement("select * from tsale where category=? and size=? and school=? ");
                                            st.setString(1, cb1.getSelectedItem().toString());
                                            st.setString(2, cb2.getSelectedItem().toString());
                                            st.setString(3, cb3.getSelectedItem().toString());
                                            ResultSet rs2=st.executeQuery();
                                            int qu=0;
                                            if(rs2.next())
                                            {
                                                qu=Integer.valueOf(rs2.getString("quantity"))+Integer.valueOf(String.valueOf(js.getValue()));
                                                int tp=Integer.valueOf(js.getValue().toString())*Integer.valueOf(f1.getText());
                                                int to=Integer.valueOf(rs2.getString("price"))+tp;
                                               
                                                st=con.prepareStatement("update tsale set quantity=?,price=? where category=? and size=? and school=?");
                                                st.setString(1,String.valueOf(qu));
                                                st.setString(2,String.valueOf(to));
                                                st.setString(3,cb1.getSelectedItem().toString());
                                                st.setString(4,cb2.getSelectedItem().toString());
                                                st.setString(5,cb3.getSelectedItem().toString());
                                                st.executeUpdate();
                                                
                                            }
                                        else
                                            {
                                            st=con.prepareStatement("insert into tsale(category,size,school,quantity,price)values(?,?,?,?,?)");
                                            st.setString(1, cb1.getSelectedItem().toString());
                                            st.setString(2, cb2.getSelectedItem().toString());
                                            st.setString(3, cb3.getSelectedItem().toString());
                                            st.setString(4, js.getValue().toString());
                                            int tp=Integer.valueOf(js.getValue().toString())*Integer.valueOf(f1.getText());
                                          //  JOptionPane.showMessageDialog(null, tp);
                                            st.setString(5, String.valueOf(tp));
                                            st.executeUpdate();
                                            }
                                             st=con.prepareStatement("update stock set quantity=? where category=? and school=? and size=?");
                                             st.setString(1, String.valueOf(q-Integer.valueOf(js.getValue().toString())));
                                             st.setString(2, cb1.getSelectedItem().toString());
                                             st.setString(3, cb3.getSelectedItem().toString());
                                             st.setString(4, cb2.getSelectedItem().toString());
                                             st.executeUpdate();
                                             table();
                               
                                        }
                                     
                                     }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             
                             }
                            }
                        
                        }
                    }
                }
            }
        });
        gc.gridx=1;
        gc.gridy=5;
        p1.add(b1,gc);
        
        gc.gridx=0;
        gc.gridy=6;
        p1.add(l6,gc);
        
        gc.gridx=1;
        gc.gridy=6;
        p1.add(df,gc);
        
        gc.gridx=0;
        gc.gridy=7;
        p1.add(l7,gc);
        
        gc.gridx=1;
        gc.gridy=7;
        p1.add(f2,gc);
        
        b2=new JButton("Sale");
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getRowCount()==0)
                {
                     if(cb1.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(null, "Please Select Category");
                }
                else
                {
                    if(cb3.getSelectedIndex()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Please Select Color/School");
                    }
                    else
                    {
                        if(cb2.getSelectedIndex()==0)
                        {
                         JOptionPane.showMessageDialog(null, "Please Select Size");   
                            
                        }
                        else
                        {
                            if(Integer.parseInt(js.getValue().toString())<=0)
                            {
                               JOptionPane.showMessageDialog(null, "Please Enter Quantity correctly");
                            }
                            else
                            {
                                try {
                                    st=con.prepareStatement("select * from stock where category=? and size=? and school=?");
                                    st.setString(1,cb1.getSelectedItem().toString());
                                    st.setString(2,cb2.getSelectedItem().toString());
                                    st.setString(3,cb3.getSelectedItem().toString());
                                    rs=st.executeQuery();
                                 
                                    while(rs.next())
                                    {
                                        q=Integer.valueOf(rs.getString("quantity"));
                                    }
                                    if(q<Integer.valueOf(js.getValue().toString()))
                                    {
                                        JOptionPane.showMessageDialog(null,"limited Stock");
                                    }
                                    else
                                    {
                                        if(uniformSale.pc(f1.getText()))
                                        {
                                                  if(f1.getText().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null, "Please Enter Unit Price");
                                        }
                                        else
                                        {
                                            String dc=((JTextField)df.getDateEditor().getUiComponent()).getText();
                                            if(dc.equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null, "Please Enter Date");
                                            }
                                            else
                                            {
                                                if(f2.getText().equals(""))
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please Enter name");
                                                }
                                                else
                                                {
                                                st=con.prepareStatement("insert into sale(category,size,school,quantity,price,sale_date,sale_name)values(?,?,?,?,?,?,?)");
                                            st.setString(1, cb1.getSelectedItem().toString());
                                            st.setString(2, cb2.getSelectedItem().toString());
                                            st.setString(3, cb3.getSelectedItem().toString());
                                            st.setString(4, js.getValue().toString());
                                            int tp=Integer.valueOf(js.getValue().toString())*Integer.valueOf(f1.getText());
//                                            JOptionPane.showMessageDialog(null, tp);
                                            st.setString(5, String.valueOf(tp));
                                            st.setString(6, sdf.format(df.getDate()));
                                            st.setString(7,f2.getText());
                                            st.executeUpdate();
                                            st=con.prepareStatement("update stock set quantity=? where category=? and school=? and size=?");
                                             st.setString(1, String.valueOf(q-Integer.valueOf(js.getValue().toString())));
                                             st.setString(2, cb1.getSelectedItem().toString());
                                             st.setString(3, cb3.getSelectedItem().toString());
                                             st.setString(4, cb2.getSelectedItem().toString());
                                             st.executeUpdate();
                                             if(JOptionPane.showConfirmDialog(null, "Slip")==0)
                                             {
                                                 print();
                                                st=con.prepareStatement("delete * from tsale");
                                                st.executeUpdate();
                                                table();
                                                clear();
                                             }
                                                 
                                                }
                                            }
                                        }
                                        
                                  
                                        }
                                        else
                                        {
                                        //    JOptionPane.showMessageDialog(null, "enter price Correctly");
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                        
                        }
                    }
                }
                }
                else
                {
                    String dc=((JTextField)df.getDateEditor().getUiComponent()).getText();
                    if(dc.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "please Select Date");
                        
                    }
                    else
                    {
                        if(f2.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Please Enter name");
                        }
                        else
                        {
                        
                            TableModel mo=t1.getModel();
                            for(int i=0;i<t1.getRowCount();i++)
                            {
                                try {
                                    st=con.prepareStatement("insert into sale(category,size,school,quantity,price,sale_date,sale_name)values(?,?,?,?,?,?,?)");
                                    st.setString(1, mo.getValueAt(i, 1).toString());
                                    st.setString(2, mo.getValueAt(i, 2).toString());
                                    st.setString(3, mo.getValueAt(i, 3).toString());
                                    st.setString(4, mo.getValueAt(i, 4).toString());
                                    st.setString(5,mo.getValueAt(i, 5).toString());
                                    st.setString(6, sdf.format(df.getDate()));
                                    st.setString(7,f2.getText());
                                    st.executeUpdate();
                               
                                } catch (SQLException ex) {
                                    Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                  
                            }
                                 if(JOptionPane.showConfirmDialog(null, "Slip")==0)
                                    {
                                try {
                                    print2();
                                    st=con.prepareStatement("delete * from tsale");
                                    st.executeUpdate();
                                    table();
                                    clear();
                                } catch (SQLException ex) {
                                    Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    }
                            
                        }
                    }
                }
            }
        });
        b3=new JButton("Clear");
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        
        JPanel tp=new JPanel();
        tp.add(b2);
        tp.add(b3);
        tp.setBackground(new Color(114,112,164));
        
        gc.gridx=1;
        gc.gridy=8;
        p1.add(tp,gc);
        
        p3=new JPanel(new FlowLayout());
      
        l9=new JLabel("Total Bill");
        b4=new JButton("Delete");
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(click==1){
                    
                    try {
                        int a=t1.getSelectedRow();
                        TableModel mo=t1.getModel();
                        String ct=mo.getValueAt(a, 1).toString();
                        String si=mo.getValueAt(a, 2).toString();
                        String sc=mo.getValueAt(a, 3).toString();
//                        JOptionPane.showMessageDialog(null, ct+si+sc);
                        int qua=0;
                        int tot=0;
                        st=con.prepareStatement("select * from tsale where category=? and size=? and school=?");
                        st.setString(1, ct);
                        st.setString(2, si);
                        st.setString(3, sc);
                        rs=st.executeQuery();
                        while(rs.next())
                        {
                            qua=Integer.valueOf(rs.getString("quantity"));
                        }
                        st=con.prepareStatement("select * from stock where category=? and size=? and school=?");
                        st.setString(1, ct);
                        st.setString(2, si);
                        st.setString(3, sc);
                        rs=st.executeQuery();
                        while(rs.next())
                        {
                            tot=Integer.valueOf(rs.getString("quantity"));
                        } 
                        
                        st=con.prepareStatement("update stock set quantity=?  where category=? and size=? and school=?");
                        st.setString(1,String.valueOf((tot+qua)));
                        st.setString(2, ct);
                        st.setString(3, si);
                        st.setString(4, sc);
                        st.executeUpdate();
                        
                        st=con.prepareStatement("delete * from tsale where category=? and size=? and school=?");
                        st.setString(1, ct);
                        st.setString(2, si);
                        st.setString(3, sc);
                        st.executeUpdate();
                        table();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
            }
        });
        p3.add(l9);
        p3.add(new JLabel("                                                                                            "));
        p3.add(b4);
        p3.setBackground(new Color(114,112,164));
        
        this.add(p3,BorderLayout.SOUTH);
        
        
        p5=new JPanel(new BorderLayout());
    inner=BorderFactory.createTitledBorder("Sale Line Item");
    p5.setBorder(BorderFactory.createCompoundBorder(outer,inner));
    p5.setBackground(new Color(114,112,163));
    
    this.add(p5,BorderLayout.CENTER);
  
        Object[][] data={
        };
            String[] columnN={"id","Category","Size","Color/School","Quantity","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t1=new JTable(mo);
            jp=new JScrollPane(t1);
            p5.add(jp,BorderLayout.CENTER);
//            p5.remove(jp);
            table();

        
        this.add(p1,BorderLayout.WEST);
    }
    int update=0;
    public void clear()
    {
                     catUpdate();
                cb1.setSelectedIndex(0);
                f1.setText("");
                f2.setText("");
                df.setDate(null);
                js.setValue(1);
    }
    public void siUpdate()
    {
        
        update=1;
        cb2.removeAllItems();
        cb2.addItem("");
        try {
            st=con.prepareStatement("select * from stock where category=? and school=?");
            st.setString(1, cb1.getSelectedItem().toString());
            st.setString(2, cb3.getSelectedItem().toString());
            
            rs=st.executeQuery();
            while(rs.next())
            {
                cb2.addItem(rs.getString("size"));
            }
            cb2.setSelectedIndex(0);
            update=0;
        } catch (SQLException ex) {
            Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void scUpdate()
    {
        
        update=1;
        cb3.removeAllItems();
        cb3.addItem("");
        cb2.removeAllItems();
        try {
            st=con.prepareStatement("select * from stock where category=?");
            st.setString(1, cb1.getSelectedItem().toString());
            rs=st.executeQuery();
            while(rs.next())
            {
                cb3.addItem(rs.getString("school"));
            }
            cb3.setSelectedIndex(0);
            update=0;
        } catch (SQLException ex) {
            Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void catUpdate()
    {
        update=1;
        cb1.removeAllItems();
        cb1.addItem("");
        cb2.removeAllItems();
        cb3.removeAllItems();
        
        try {
            st=con.prepareStatement("select * from category");
            rs=st.executeQuery();
            while(rs.next())
            {
                cb1.addItem(rs.getString("cat_name"));
            }
            cb1.setSelectedIndex(0);
            update=0;
        } catch (SQLException ex) {
            Logger.getLogger(uniformSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
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
            int total=0;
         for(int i=0;i<list.size();i++)
            {
                row[0]=1+i;
                row[1]=list.get(i).getcategory();
                row[2]=list.get(i).getsize();
                row[3]=list.get(i).getschool();
                row[4]=list.get(i).getquantity();
                row[5]=list.get(i).getprice();
                total=total+Integer.valueOf(list.get(i).getprice());
                model.addRow(row);
                
            }
         l9.setText("Total Bill     :     "+total);
           click=0;
         p5.setVisible(true);
//          click=0;
          t1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                click=1;
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
      public void click()
    
    {
        click=1;
        int a=t1.getSelectedRow();
        TableModel mo=t1.getModel();
//        sc=mo.getValueAt(a, 2).toString();
//        qc=mo.getValueAt(a, 3).toString();
//        cc=mo.getValueAt(a, 1).toString();
//        f1.setText(mo.getValueAt(a, 2).toString());
//        f2.setText(mo.getValueAt(a, 3).toString());
//        cb2.setSelectedItem(mo.getValueAt(a, 1));
//        f3.setText(mo.getValueAt(a, 4).toString());
//        f4.setText(mo.getValueAt(a, 5).toString());
//        
//        f3.setText(mo.getValueAt(a, 4).toString());
//        ctf.setText(mo.getValueAt(a, 5).toString());
//        f5.setText(mo.getValueAt(a, 6).toString());
//        f7.setText(mo.getValueAt(a, 7).toString());
//        
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
         PreparedStatement st=null;
         Connection con=getConnection();
        try {
            st=con.prepareStatement("select * from tsale");
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
    
    public void print()
    {
    
    String Header =
                      "*******Al-Qamar Uniforms*********;\n;"
                    + "-----------------------------------------------\n; "
                    + "Name    :  "+f2.getText()+"\n; "
                    + "Date      :  "+sdf.format(df.getDate())+"\n; "
                
                    + "-----------------------------------------------\n; ";
                     String a="sr#   Category          size        price";
                     String sp="\n;";
                     String cat=cb1.getSelectedItem().toString();
                     String pl=("1"+"        "+cat+"\n;                                    "+cb2.getSelectedItem()+"         "+Integer.valueOf(js.getValue().toString())*Integer.valueOf(f1.getText()));
                      a=a+sp; 
                     a=a+pl;    
//        String a="Imei     "+f1.getSelectedItem().toString()+"\n; "+"Model     "+f3.getText()+"\n; "+"Type     "+typ+"";
             String h=Header+a;
        String amt  =
                    "\n;-----------------------------------------------\n; "
                    + "Total Amount      Rs."+Integer.valueOf(js.getValue().toString())*Integer.valueOf(f1.getText())+"\n; "
                    + "-----------------------------------------------\n; "
                    + "-----------------------------------------------\n; "
                    + "              Contact us                \n; "
                    + "Call/Whatsapp 0345-6830359\n; "
                    + "Main road Jamkey cheema\n;"
                    + "********************************\n;"
                    + "            Thank You             \n; "
                    + "_________________________________\n";
        String fin=h+amt;
        printnow p=new printnow();
        printnow.printcard(fin);
        System.out.print(fin);

    }
   public void print2()
   {
       
    String Header =
                      "*******Al-Qamar Uniforms*********;\n;"
                    + "-----------------------------------------------\n; "
                    + "Name    :  "+f2.getText()+"\n; "
                    + "Date      :  "+sdf.format(df.getDate())+"\n; "
                
                    + "-----------------------------------------------\n; ";
                     String a="sr#   Category          size        price";
                     TableModel mo=t1.getModel();
                     int total=0;
        for(int i=0;i<t1.getRowCount();i++)
        {
                    String sp="\n;";
                    total=total+Integer.valueOf(mo.getValueAt(i,5).toString());
                     String cat=mo.getValueAt(i, 1).toString();
                  //  String pl=(1+i+"        "+cat+""+mo.getValueAt(i, 2)+"       "+mo.getValueAt(i, 5));
                    String pl=(1+i+"        "+cat+"\n;                                    "+mo.getValueAt(i,2)+"         "+mo.getValueAt(i, 5));  
                    a=a+sp; 
                     a=a+pl;    
         }
//        String a="Imei     "+f1.getSelectedItem().toString()+"\n; "+"Model     "+f3.getText()+"\n; "+"Type     "+typ+"";
             String h=Header+a;
        String amt  =
                    "\n;-----------------------------------------------\n; "
                    + "Total Amount      Rs."+total+"\n; "
                    + "-----------------------------------------------\n; "
                    + "-----------------------------------------------\n; "
                    + "              Contact us                \n; "
                    + "Call/Whatsapp 0345-6830359\n; "
                    + "Main road Jamkey cheema\n;"
                    + "********************************\n;"
                    + "            Thank You             \n; "
                    + "_________________________________\n";
        String fin=h+amt;
        printnow p=new printnow();
            printnow.printcard(fin);
        System.out.print(fin);

   }
}
