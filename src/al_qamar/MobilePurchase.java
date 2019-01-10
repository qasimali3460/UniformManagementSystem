
package al_qamar;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class MobilePurchase extends JPanel{
    JFrame f;
    JTextField f2,f3,f4,f5,f6,f7,f10;
    MaskFormatter mask;
    JFormattedTextField f1,f8,f9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JRadioButton rb1,rb2,rb3,rb4;
    JDateChooser df;
    JPanel p1,p2,p3,p4;
    Dimension d;
    JButton b1,b2;
    TitledBorder inner;
    Border outer;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    boolean im=true ,pr=true,nm=true,pn=true,cn=true;
    String type;
    public MobilePurchase()
    {
        this.setLayout(new BorderLayout());
        frame();
    }
    
    public void frame()
    {
        f=new JFrame("New Purchase");
        f.setSize(400,600);
//        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        menue();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        p1=new JPanel(new GridBagLayout());
        p1.setBackground(new Color(136,134,183));
        
        l1=new JLabel("IMEI");
        l2=new JLabel("Company");
        l3=new JLabel("Model");
        l4=new JLabel("Color");
        l5=new JLabel("Price");
        l6= new JLabel("Date");
        l7=new JLabel("Name");
        l8=new JLabel("Phone#");
        l9= new JLabel("CNIC");
        l10=new JLabel("Address");
        
        
        
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);
        l4.setForeground(Color.white);
        l5.setForeground(Color.white);
        l6.setForeground(Color.white);
        l7.setForeground(Color.white);
        l8.setForeground(Color.white);
        l9.setForeground(Color.white);
        l10.setForeground(Color.white);
        
        try {
            mask=new MaskFormatter("###############");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        f1=new JFormattedTextField(mask);
        f1.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
         
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        f1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

//                if(f1.getText()!=null)
//                {
//                    im=true;
//                }
//                else
//                    im=false;
            }
        
        });
        f2=new JTextField("",15);
        f3=new JTextField("",15);
        f4=new JTextField("",15);
        f5=new JTextField("",15);
        f5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(f5.getText()!=null)
//                {
//                    pr=true;
//                }
//                else
//                    pr=false;
            }
        
        });
        f5.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if((key>=e.VK_0&&key>=e.VK_9))
                {
                    f5.setEditable(false);
                }
                else
                    f5.setEditable(true);
                 
                        }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
        df=new JDateChooser();
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        df.setDateFormatString("dd/MM/yyyy");
        
        df.setSize(f1.getWidth(),f1.getHeight());
        f7=new JTextField("",15);
        f7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(f7.getText()!=null)
//                {
//                    nm=true;
//                }
//                else
//                    nm=false;
            }
        
        });
        
        try {
            mask=new MaskFormatter("####-#######");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        f8=new JFormattedTextField(mask);
        
        try {
            mask=new MaskFormatter("#####-#######-#");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        f8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(f8.getText()!=null)
//                {
//                    pn=true;
//                }
//                else
//                    pn=false;
            }
        
        });
        
        f9=new JFormattedTextField(mask);
        f9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(f9.getText()!=null)
//                {
//                    cn=true;
//                }
//                else
//                    cn=false;
            }
        
        });
        
        f10=new JTextField("",15);
        
        b1=new JButton("Purchase");
        b2=new JButton("Clear");
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                f5.setText("");
                df.setDate(null);
                f7.setText("");
                f8.setText(""); 
                f9.setText("");
                f10.setText("");
            
            
            }
        
        });
        
        
        rb1=new JRadioButton("Distributor");
        rb2=new JRadioButton("Customer");
        
        rb3=new JRadioButton("Mobile");
        rb4=new JRadioButton("Tablet");
    
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb3);
        bg1.add(rb4);
        rb1.setSelected(true);
        rb3.setSelected(true);
        rb1.setBackground(new Color(136,134,183));
        rb2.setBackground(new Color(136,134,183));
        rb3.setBackground(new Color(136,134,183));
        rb4.setBackground(new Color(136,134,183));
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(5,5,5,5);
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.gridx=0;
        gc.gridy=0;
        p1.add(l1,gc);
    
        gc.gridx=1;
        gc.gridy=0;
        p1.add(f1,gc);
        
        gc.gridx=0;
        gc.gridy=1;
        p1.add(l2,gc);
    
        gc.gridx=1;
        gc.gridy=1;
        p1.add(f2,gc);

        gc.gridx=0;
        gc.gridy=2;
        p1.add(l3,gc);
    
        gc.gridx=1;
        gc.gridy=2;
        p1.add(f3,gc);
        
        gc.gridx=0;
        gc.gridy=3;
        p1.add(l4,gc);
    
        gc.gridx=1;
        gc.gridy=3;
        p1.add(f4,gc);
        
        gc.gridx=0;
        gc.gridy=4;
        p1.add(l5,gc);
    
        gc.gridx=1;
        gc.gridy=4;
        p1.add(f5,gc);
        
        gc.gridx=0;
        gc.gridy=5;
        p1.add(l6,gc);
    
        gc.gridx=1;
        gc.gridy=5;
        p1.add(df,gc);
        
        
        gc.gridx=0;
        gc.gridy=6;
        p1.add(rb1,gc);
    
        gc.gridx=1;
        gc.gridy=6;
        p1.add(rb2,gc);
        
        gc.gridx=0;
        gc.gridy=7;
        p1.add(rb3,gc);
    
        gc.gridx=1;
        gc.gridy=7;
        p1.add(rb4,gc);
        
        gc.gridx=0;
        gc.gridy=8;
        p1.add(l7,gc);
    
        gc.gridx=1;
        gc.gridy=8;
        p1.add(f7,gc);
        
        gc.gridx=0;
        gc.gridy=9;
        p1.add(l8,gc);
    
        gc.gridx=1;
        gc.gridy=9;
        p1.add(f8,gc);
        
        gc.gridx=0;
        gc.gridy=10;
        p1.add(l9,gc);
    
        gc.gridx=1;
        gc.gridy=10;
        p1.add(f9,gc);
        
        gc.gridx=0;
        gc.gridy=11;
        p1.add(l10,gc);
    
        gc.gridx=1;
        gc.gridy=11;
        p1.add(f10,gc);
   
        JPanel tp=new JPanel(new FlowLayout());
        tp.setBackground(new Color(136,134,183)); 
        tp.add(b1);
         tp.add(b2);
        gc.gridx=1;
        gc.gridy=12;
        p1.add(tp,gc);
        inner=BorderFactory.createTitledBorder("Purchase");
        outer=BorderFactory.createEmptyBorder(5,5,5,5);
        p1.setBorder(BorderFactory.createCompoundBorder(outer,inner));
        d=p1.getPreferredSize();
        d.width=380;
        p1.setPreferredSize(d);
        JPanel anno=new JPanel(new BorderLayout());
        purchaseReport mpr=new purchaseReport();
        anno.add(mpr,BorderLayout.CENTER);
        anno.setBackground(Color.red);
        this.add(p1,BorderLayout.WEST);
        this.add(anno,BorderLayout.CENTER);
//       f.add(p1);
        
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              if(f1.getText().equals("_______________"))
              {
                  JOptionPane.showMessageDialog(null, "Please enter imei ");
              }
              else
              {
                  if(cimei())
                      {
                          JOptionPane.showMessageDialog(null," This imei Exist already and is in stock");
                      }
               
                  else
                  { 
                  if(f2.getText().equals(""))
                  {
                      JOptionPane.showMessageDialog(null, "please Enter Company");
                  }
                   else
                      {
                               if(f3.getText().equals(""))
                      {
                         JOptionPane.showMessageDialog(null, "Please enter Model");
                      }
                      else
                      {
                          if(f4.getText().equals(""))
                          {
                            JOptionPane.showMessageDialog(null, "Please enter Color ");
                          }
                          else
                          {
                              if(f5.getText().equals(""))
                              {
                                 JOptionPane.showMessageDialog(null, "Please enter Price");
                              }
                              else
                              {
                                  if(f7.getText().equals(""))
                                  {
                                    JOptionPane.showMessageDialog(null, "Please enter Name");
                                  }
                                  else
                                  {
                                      if(f8.getText().equals("____-_______"))
                                      {
                                         JOptionPane.showMessageDialog(null, "Please enter Ph#");
                                      }
                                      else
                                      {
                                          if(f9.getText().equals("_____-_______-_"))
                                          {
                                             JOptionPane.showMessageDialog(null, "Please enter CNIC");
                                          }
                                          else
                                          {
                                              if(f10.getText().equals(""))
                                              {
                                                    JOptionPane.showMessageDialog(null,"Please enter Address");
                                              }
                                              else
                                              {
                                                  String dc=((JTextField)df.getDateEditor().getUiComponent()).getText();
                                                  if(dc.equals(""))
                                                  {
                                                      JOptionPane.showMessageDialog(null, "Please select date");
                                                  }
                                                  else
                                               {
                                                  if(rb1.isSelected())
                                                  {
                                                      type="new";
                                                 }
                                                   if(rb2.isSelected())
                                                    {
                                                         type="old";
                                                    }
//                                                      JOptionPane.showMessageDialog(null, "Your mobile is "+type);
                                                  purch();
                                                  
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
              }
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
                con=DriverManager.getConnection("jdbc:ucanaccess://C:\\db\\mobile.accdb");
            } catch (SQLException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            } 
            return con;
        
       
    }
            JMenuBar menu;
    JMenu stock,purchase,sale,expense,main,profitframe;
    JMenuItem addPurchase,allPurchase,newSale,allSale,addExpense,allExpense,printStock;

    public void menue()
    {
        menu=new JMenuBar();
        
        profitframe=new JMenu("Profit");
        profitframe.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                profit m=new profit();
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
        main=new JMenu("Main menue");
        main.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                Menue m=new Menue();
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
        stock=new JMenu("Stock");
        stock.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
//                JOptionPane.showMessageDialog(null, "hello");
                MobileStock ms=new MobileStock();
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
        purchase=new JMenu("purchase");
        addPurchase=new JMenuItem("New Purchase");
        addPurchase.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "hello");
                f.dispose();
                MobilePurchase m=new MobilePurchase();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "hello");
                f.dispose();
                MobilePurchase m=new MobilePurchase();
                        
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.print("released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            System.out.print("entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            System.out.print("exit");
            }
            
        });
        purchase.add(addPurchase);
        purchase.addSeparator();
        allPurchase=new JMenuItem("Purchases Report");
        allPurchase.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                purchaseReport m=new purchaseReport();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                f.dispose();
                purchaseReport m=new purchaseReport();
            
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
        
        purchase.add(allPurchase);
        sale=new JMenu("sale");
        newSale=new JMenuItem("New Sale");
        newSale.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                MobileSale m=new MobileSale();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                f.dispose();
                MobileSale m=new MobileSale();
            
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
        allSale=new JMenuItem("Sales Report");
        allSale.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                saleReport m=new saleReport();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                f.dispose();
                saleReport m=new saleReport();
            
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
        
        sale.add(newSale);
        sale.addSeparator();
        sale.add(allSale);
        expense=new JMenu("expense");
        addExpense=new JMenuItem("Add Expense");
        addExpense.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                expenditure m=new expenditure();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                f.dispose();
                expenditure m=new expenditure();
            
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
        allExpense=new JMenuItem("Expense Report");
        allExpense.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                expenseReport m=new expenseReport();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                f.dispose();
                expenseReport m=new expenseReport();
            
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
        
        expense.add(addExpense);
        expense.addSeparator();
        expense.add(allExpense);
//        menu.add(main);
        menu.add(stock);
        menu.add(purchase);
        menu.add(sale);
        menu.add(expense);
        menu.add(profitframe);
        f.setJMenuBar(menu);
    }

    public boolean cimei()
    {
        Boolean sta=null;
       Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select * from purchase where imei='"+f1.getText()+"' and status='inStock'");
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                sta=true;
            }
            else
                sta=false;
        } catch (SQLException ex) {
            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
        }
       return sta;
         
    }
    public void purchase()
    {
    }
    public void purch()
    {
        String cat="Mobile";
        if(rb4.isSelected())
        {
            cat="Tablet";
        }
        String date=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        date=sdf.format(df.getDate());
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("insert into purchase(imei,company,model,color,purchase_from,ph,cnic,purchase_date,status,purchase_price,type,address,category)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1,f1.getText());
            st.setString(2,f2.getText());
            st.setString(3,f3.getText());
            st.setString(4,f4.getText());
            st.setString(5,f7.getText());
            st.setString(6,f8.getText());
            st.setString(7,f9.getText());
            st.setString(8,date);
            st.setString(9,"inStock");
            st.setString(10,f5.getText());
            st.setString(11,type);
            st.setString(12,f10.getText());
            st.setString(13, cat);
            if(st.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null, "New Mobile purchased Successfully");
                if(JOptionPane.showConfirmDialog(null,"Do you want to print Slip")==0)
                {
                    print();
                }
            }
//        String a=f1.getText();
//        String b=f2.getText();
//        String c=f3.getText();
//        String d=f4.getText();
//        String e=f5.getText();
//        String f=df.getDate().toString();
//        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
//        String inserted="28/02/2018";
//        String s =sdf.format(df.getDate());
//        java.util.Date sde=null;
//        try {
//            sde=sdf2.parse(inserted);
//        
//            if(sde.compareTo(sdf.parse(s))==0)
//            {
//             JOptionPane.showMessageDialog(null, "bowled");
//                
//            }
//            else
//              JOptionPane.showMessageDialog(null, "Catched");
//             
//        } catch (ParseException ex) {
//            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        s =sdf2.format(sde);
//        JOptionPane.showMessageDialog(null, s);
////       Date dfd=Date.valueOf(f);
//        String g=f7.getText();
//        String h=f8.getText();
//        String i=f9.getText();
//        String j=f10.getText();
//
//       
////        String []values={"hello"};
////        values[1]=f5.getText().toLowerCase();
////        values[1]=f2.getText();
////        values[2]=f3.getText();
////        values[3]=f4.getText();
////        values[4]=f5.getText();
////        values[5]=df.getDate().toString();
////        values[6]=f7.getText();
////        values[7]=f8.getText();
////        values[8]=f9.getText();
////        values[9]=f10.getText();
////        for(int i=0;i<=9;i++)
////        {
////            JOptionPane.showMessageDialog(null, values[i]);
////        }
//        Connection con=getConnection();
//        try {
//
////            PreparedStatement st=con.prepareStatement("insert into purchase(imei,purchase_date)values(?,?)");
////            st.setString(1,a);
//          //  df.setDateFormatString("dd/MM/yyyy");
//  //          st.setString(2,s);
//           // st.executeUpdate();
//         //   st.executeUpdate("insert into purchase(imei,company,model,color,purchase_from,ph,cnic,purchase_date,status,purchase_price,type,address)values('"+a+"','"+b+"','"+c+"','"+d+"','"+g+"','"+h+"','"+i+"','"+((JTextField)df.getDateEditor().getUiComponent()).getText()+"','inStock','"+e+"','new','"+j+"')");
//         PreparedStatement st=con.prepareStatement("select purchase_date from purchase");
//         ResultSet rs=st.executeQuery();
//         String str="hello";
//         while(rs.next())
//         {
//             str=rs.getString("purchase_date");
//             JOptionPane.showMessageDialog(null,str);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (SQLException ex) {
            Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void print()
    {
        
       String tpe="new";
       if(rb2.isSelected())
       {
           tpe="old";
       }
    String Header =
                      "******Star Mobile Center*********;\n;"
                    + "-----------------------------------------------\n; "
                    + "Name    "+f7.getText()+"\n; "
                    + "Date    "+sdf.format(df.getDate())+"\n; "
                
                    + "-----------------------------------------------\n; ";
                    String a="Imei                     "+"Model         "+"Type ";
                     String sp="\n;";
                     String pl=(f1.getText()+"     "+f3.getText()+"     "+tpe);
                      a=a+sp; 
                     a=a+pl;    

                  
                 String h=Header+a;
        String amt  =
                    "\n;-----------------------------------------------\n; "
                    + "Total Bill      Rs."+f5.getText()+"\n; "
                    + "-----------------------------------------------\n; "
                    + "-----------------------------------------------\n; "
                    + "              Contact us                \n; "
                    + "     Call/Whatsapp 0340-8351689\n; "
                    + "Ground floor Saithi Plaza Sialkot\n; "
                    + "*********************************\n; "
                    + "            Thank You             \n; "
                    + "_________________________________\n";
        String fin=h+amt;
        printnow p=new printnow();
        printnow.printcard(fin);
        System.out.print(fin);

    
    }
    }

