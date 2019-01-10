
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class MobileSale extends JPanel {
    JFrame f;
    JTextField f2,f3,f4,f5,f6,f7,f10,cat;
    MaskFormatter mask;
    JComboBox f1;
    JFormattedTextField f8,f9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,tt,ti;
    JRadioButton rb1,rb2;
    JDateChooser df;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    JPanel p1,p2,p3,p4,p5;
    Dimension d;
    JTable t1;
    JScrollPane jp;
    TitledBorder inner;
    Border outer;
    JButton b1,b2,sli,delte;
    boolean im=true ,pr=true,nm=true,pn=true,cn=true;
    int update;
    String type;
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
//        f.setJMenuBar(menu);
    }

    public void setImei(String imei)
    {
        f1.setSelectedItem(imei);
       
    }
    public MobileSale()
    {
        this.setLayout(new BorderLayout());
        frame();
        imeiUpdate();
        AutoCompleteDecorator.decorate(f1);
        
    }
    
    public void frame()
    {
        f=new JFrame("Sale");
        f.setSize(400,600);
//        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

          menue();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        p1=new JPanel(new GridBagLayout());
        p1.setBackground(new Color(136,134,183));
        
        l1=new JLabel("Scan IMEI");
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
        f1=new JComboBox();
        f1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
  
                if(update==0)
                {
                    if(f1.getSelectedItem().toString().equals(".."))
                    {
                        imeiUpdate();
                        f2.setText("");
                        f3.setText("");
                        f4.setText("");
                        f5.setText("");
                    }
                    else
                    {
                        try {
                            Connection con=getConnection();
                            PreparedStatement st=con.prepareStatement("select * from purchase where imei=? and status=?");
                            st.setString(1, f1.getSelectedItem().toString());
                            st.setString(2, "inStock");
                            ResultSet rs=st.executeQuery();
                            while(rs.next())
                            {
                                f2.setText(rs.getString("company"));
                                cat.setText(rs.getString("category"));
                                f3.setText(rs.getString("model"));
                                f4.setText(rs.getString("color"));
                                if(rs.getString("type").compareTo("new")==0)
                                {
                                    rb1.setSelected(true);
                                }
                                else
                                    rb2.setSelected(true);
                                
                            }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                        
                        
                        
//                if(f1.getText()!=null)
//                {
//                    im=true;
//                }
//                else
//                    im=false;
            }
        
        });
        f2=new JTextField("",15);
        f2.setEditable(false);
        f3=new JTextField("",15);
        f3.setEditable(false);
        f4=new JTextField("",15);
        f4.setEditable(false);
        f5=new JTextField("",15);
        f2.setEditable(false);
       
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
        
        df=new JDateChooser();
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        df.setDateFormatString("dd/MM/yyyy");
        
        df.setSize(f1.getWidth(),f1.getHeight());
        f7=new JTextField(15);
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
        b1=new JButton("Sale");
        b2=new JButton("Clear");
        
        
        rb1=new JRadioButton("New");
        rb2=new JRadioButton("2nd hand");
        
        
        ButtonGroup bg=new ButtonGroup();
        
        bg.add(rb1);
        bg.add(rb2);
        rb1.setSelected(true);
        
        rb1.setBackground(new Color(136,134,183));
        rb2.setBackground(new Color(136,134,183));
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(5,5,5,5);
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.gridx=0;
        gc.gridy=0;
        p1.add(l1,gc);
    
        gc.gridx=1;
        gc.gridy=0;
        p1.add(f1,gc);
        
        JLabel cal=new JLabel("Category");
        cal.setForeground(Color.white);
        cat=new JTextField("",15);
        cat.setEditable(false);
        
        gc.gridx=0;
        gc.gridy=1;
        p1.add(cal,gc);
    
        gc.gridx=1;
        gc.gridy=1;
        p1.add(cat,gc);

        gc.gridx=0;
        gc.gridy=2;
        p1.add(l2,gc);
    
        gc.gridx=1;
        gc.gridy=2;
        p1.add(f2,gc);

        gc.gridx=0;
        gc.gridy=3;
        p1.add(l3,gc);
    
        gc.gridx=1;
        gc.gridy=3;
        p1.add(f3,gc);
        
        gc.gridx=0;
        gc.gridy=4;
        p1.add(l4,gc);
    
        gc.gridx=1;
        gc.gridy=4;
        p1.add(f4,gc);
        
        gc.gridx=0;
        gc.gridy=5;
        p1.add(l5,gc);
    
        gc.gridx=1;
        gc.gridy=5;
        p1.add(f5,gc);
        
        gc.gridx=0;
        gc.gridy=6;
        p1.add(rb1,gc);
    
        gc.gridx=1;
        gc.gridy=6;
        p1.add(rb2,gc);
        
        sli=new JButton("Add to Sale Line");
        gc.gridx=1;
        gc.gridy=7;
        p1.add(sli,gc);
        
        sli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(f1.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please enter Imei");
                }
                else
                {
                    if(f5.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Please enter Price");
                    }
                    else
                    {
                        try {
                            String type="new";
                            if(rb2.isSelected())
                            {
                                type="old";
                            }
                            String date=null;
                            Connection con=getConnection();
                            PreparedStatement st=con.prepareStatement("insert into tsale(imei,company,model,color,type,price,category)values(?,?,?,?,?,?,?)");
                            st.setString(1,f1.getSelectedItem().toString());
                            st.setString(2,f2.getText());
                            st.setString(3,f3.getText());
                            st.setString(4,f4.getText());
                            st.setString(5,type);
                            st.setString(6,f5.getText());
                            st.setString(7, cat.getText());
                            if(st.executeUpdate()==1)
                            {
                               table();
                                
                            }
                            st=con.prepareStatement("update purchase set status=? where imei=? and status=?");
                            st.setString(1, "sli");
                            st.setString(2, f1.getSelectedItem().toString());
                            st.setString(3, "inStock");
                            st.executeUpdate();
                            update=1;
                            imeiUpdate();
                            update=0;
                        } catch (SQLException ex) {
                            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
            
        });
        
        
        gc.gridx=0;
        gc.gridy=8;
        p1.add(l6,gc);
    
        gc.gridx=1;
        gc.gridy=8;
        p1.add(df,gc);
        
        
        gc.gridx=0;
        gc.gridy=9;
        p1.add(l7,gc);
    
        gc.gridx=1;
        gc.gridy=9;
        p1.add(f7,gc);
        
        gc.gridx=0;
        gc.gridy=10;
        p1.add(l8,gc);
    
        gc.gridx=1;
        gc.gridy=10;
        p1.add(f8,gc);
        
        gc.gridx=0;
        gc.gridy=11;
        p1.add(l9,gc);
    
        gc.gridx=1;
        gc.gridy=11;
        p1.add(f9,gc);
        
        gc.gridx=0;
        gc.gridy=12;
        p1.add(l10,gc);
    
        gc.gridx=1;
        gc.gridy=12;
        p1.add(f10,gc);
   
        JPanel tp=new JPanel(new FlowLayout());
        tp.setBackground(new Color(136,134,183)); 
        tp.add(b1);
         tp.add(b2);
        gc.gridx=1;
        gc.gridy=13;
        p1.add(tp,gc);
    
        inner=BorderFactory.createTitledBorder("Sale");
        outer=BorderFactory.createEmptyBorder(5,5,5,5);
        p1.setBorder(BorderFactory.createCompoundBorder(outer,inner));
        d=p1.getPreferredSize();
        d.width=380;
        p1.setPreferredSize(d);
        this.add(p1,BorderLayout.WEST);
        p5=new JPanel(new BorderLayout());
         inner=BorderFactory.createTitledBorder("Sale Line Items");
        p5.setBorder(BorderFactory.createCompoundBorder(outer,inner));
       
        p3=new JPanel(new FlowLayout());
        d=p3.getPreferredSize();
        
        d.height=50;
        p3.setPreferredSize(d);
        ti=new JLabel("Total Items      :        ");
        p3.add(ti);
        p3.add(new JLabel("                                                           "));
        tt=new JLabel("Total Bill      :        ");
        p3.add(tt);
        delte=new JButton("Delete");
        p3.add(new JLabel("                                                           "));
        p3.add(delte);
        delte.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
////                JOptionPane.showMessageDialog(null, check);
                        if(check==1)
                        {
                                int a=t1.getSelectedRow();
                        TableModel mo=t1.getModel();
                        String imeide=mo.getValueAt(a, 1).toString();
                        
                                try {
                                    Connection con=getConnection();
                                    PreparedStatement st=con.prepareStatement("delete * from tsale where imei=? ");
                                    st.setString(1, imeide);
                                    
                                    if(st.executeUpdate()==1)
                                    {
                                       JOptionPane.showMessageDialog(null,"Removed");
                                        table();
                                    }
                                    st=con.prepareStatement("update purchase set status=? where imei=? and status=?");
                                    
                                    st.setString(1, "inStock");
                                    st.setString(2, imeide);
                                    st.setString(3, "sli");
                                    st.executeUpdate();
                                    imeiUpdate();
                                } catch (SQLException ex) {
                                    Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        
                        }
}   
        });
        
        ti.setBackground(Color.white);
        tt.setBackground(Color.white);
//   p3.add(printb);
        p3.setBorder(BorderFactory.createEtchedBorder());
        this.add(p3,BorderLayout.SOUTH);
        p3.setBackground(new Color(114,112,163));
        this.add(p5,BorderLayout.CENTER);
        p5.setBackground(new Color(136,134,183));
        Object[][] data={};
            String[] columnN={"id","IMEI","Company","Model","Color","Type","Price"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t1=new JTable(mo);
            jp=new JScrollPane(t1);
            jp.setBackground(Color.red);
            jp.setVisible(false);
            p5.add(jp,BorderLayout.CENTER);
//            p5.remove(jp);
//            table();

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(t1.getRowCount()==0)
             {
                  if(f1.getSelectedIndex()==0)
              {
                  JOptionPane.showMessageDialog(null, "Please enter imei ");
              }
              else
              {
                  if(false)
                      {
                          JOptionPane.showMessageDialog(null," This imei Exist already and is in stock");
                      }
               
                  else
                  { 
                  if(false)
                  {
                      JOptionPane.showMessageDialog(null, "please Enter Company");
                  }
                   else
                      {
                               if(false)
                      {
                         JOptionPane.showMessageDialog(null, "Please enter Model");
                      }
                      else
                      {
                          if(false)
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
                                                     // JOptionPane.showMessageDialog(null, "Your mobile is "+type);
////                                                     JOptionPane.showMessageDialog(null, t1.getRowCount());
                                                     purch();
                                                      updatePurchase();
                                                      imeiUpdate();
                                                  
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
                                                     // JOptionPane.showMessageDialog(null, "Your mobile is "+type);
                                                      purch2();
                                                      updatePurchase();
                                                      imeiUpdate();
                                                  
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
                clear();
            }
        
        });
    }
    public void clear()
    {
         imeiUpdate();
                f2.setText("");
                f3.setText("");
                f4.setText("");
                df.setDate(null);
                f5.setText("");
                f7.setText("");
                f8.setText("");
                f9.setText("");
                f10.setText("");
            
    }
     ArrayList<Mobile> getArrayList()
     {
         ArrayList<Mobile> list=new ArrayList<Mobile>();
         PreparedStatement st=null;
         Connection con=getConnection();
        try {
            st=con.prepareStatement("select * from tsale");
            ResultSet rs=null;
            rs=st.executeQuery();
            while(rs.next())
            {
                Mobile m=new Mobile(rs.getString("imei"),rs.getString("category"),rs.getString("company"),rs.getString("model"),rs.getString("color"),rs.getString("type"),rs.getString("price"));
                list.add(m);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     
     }
     int price=0;
            
    public void table()
    {
       
        p5.remove(jp);
        p5.setVisible(false);
        Object[][] data={
        };
         String[] columnN={"id","IMEI","Category","Company","Model","Color","Type","Price"};
         DefaultTableModel mo=new DefaultTableModel(data,columnN);
         t1=new JTable(mo);
         t1.setPreferredScrollableViewportSize(new Dimension(500,50));
         t1.setFillsViewportHeight(true);
         jp=new JScrollPane(t1);
         p5.add(jp,BorderLayout.CENTER);
         ArrayList<Mobile> list=getArrayList();
         DefaultTableModel model=(DefaultTableModel) t1.getModel();
         Object row[]=new Object[8];
             price=0;
            int prod=0;
            if(list.size()==0)
            {
                tt.setText("Total Bill    :   ");
                ti.setText("Total Items    :  ");
            }
         for(int i=0;i<list.size();i++)
            {
                row[0]=1+i;
                row[1]=list.get(i).getImei();
                row[2]=list.get(i).getCategory();
                row[3]=list.get(i).getCompany();
                row[4]=list.get(i).getModel();
                row[5]=list.get(i).getColor();
                row[6]=list.get(i).getType();
                row[7]=list.get(i).getPrice();
                model.addRow(row);
                prod=prod+1;
                ti.setText("Total Items      :      "+(prod));
                price=price+Integer.parseInt(list.get(i).getPrice());
                tt.setText("Total Bill      :      "+(price));
                
            }
         check=0;
//         l10.setText("Total Products    :     "+String.valueOf(list.size()));
         p5.setVisible(true);
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
    int check=0;
    public void click()
    {
        
        check=1;
//        JOptionPane.showMessageDialog(null, check);
//        f1.setText(mo.getValueAt(a, 1).toString());
//        oldImei=f1.getText();
//        f2.setText(mo.getValueAt(a, 2).toString());
//        f3.setText(mo.getValueAt(a, 3).toString());
//        ctf.setText(mo.getValueAt(a, 4).toString());
//        f5.setText(mo.getValueAt(a, 5).toString());
//        f7.setText(mo.getValueAt(a, 6).toString());
//        
    }
    
        public void imeiUpdate()
    {
        update=1;
        f1.removeAllItems();
        f1.addItem("..");
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select imei from purchase where status='inStock'");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                f1.addItem(rs.getString("imei"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        f1.setSelectedIndex(0);
        update=0;
        
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
                con=DriverManager.getConnection("jdbc:ucanaccess://C:\\db\\mobile.accdb");
            } catch (SQLException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
            } 
            return con;
        
       
    }
    public boolean cimei()
    {
        Boolean sta=null;
       Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select * from purchase where imei='"+f1.getSelectedItem().toString()+"' and status='inStock'");
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
        String date=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        date=sdf.format(df.getDate());
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("insert into sale(imei,company,model,color,sale_name,ph,cnic,sale_date,status,sale_price,type,address,purchase_price,category)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1,f1.getSelectedItem().toString());
            st.setString(2,f2.getText());
            st.setString(3,f3.getText());
            st.setString(4,f4.getText());
            st.setString(5,f7.getText());
            st.setString(6,f8.getText());
            st.setString(7,f9.getText());
            st.setString(14,cat.getText());
            st.setString(8,date);
            st.setString(9,"sold");
            st.setString(10,f5.getText());
            st.setString(11,type);
            st.setString(12,f10.getText());
            st.setString(13, purchPrice());
            if(st.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null, " Mobile Sold Successfully");
                if(JOptionPane.showConfirmDialog(null,"Slip ")==0)
                {
                    st=con.prepareStatement("update purchase set status='sold' where imei='"+f1.getSelectedItem().toString()+"' and status='inStock'");
                    st.executeUpdate();
                    print();
                    clear();
                    ti.setText("Total Item    :   ");
                    tt.setText("Total Bill     :   ");
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
        String typ="new ";
        if(rb2.isSelected())
        {
            typ="old";
        }
    String Header =
                      "******Star Mobile Center*********;\n;"
                    + "-----------------------------------------------\n; "
                    + "Name    : "+f7.getText()+"\n; "
                    + "Date    : "+sdf.format(df.getDate())+"\n; "
                
                    + "-----------------------------------------------\n; ";
                     String a="Imei                     "+"Model         "+"Type ";
                     String sp="\n;";
                     String pl=(f1.getSelectedItem().toString()+"     "+f3.getText()+"     "+typ);
                      a=a+sp; 
                     a=a+pl;    
//        String a="Imei     "+f1.getSelectedItem().toString()+"\n; "+"Model     "+f3.getText()+"\n; "+"Type     "+typ+"";
             String h=Header+a;
        String amt  =
                    "\n;-----------------------------------------------\n; "
                    + "Total Amount      Rs."+f5.getText()+"\n; "
                    + "-----------------------------------------------\n; "
                    + "-----------------------------------------------\n; "
                    + "              Contact us                \n; "
                    + "Call/Whatsapp 0345\n; "
                    + "Ground floor Saithi Plaza Sialkot\n;"
                    + "********************************\n;"
                    + "            Thank You             \n; "
                    + "_________________________________\n";
        String fin=h+amt;
        printnow p=new printnow();
        printnow.printcard(fin);
        System.out.print(fin);

    }
    public String purchPrice()
    {
    
        String pr=null;
     Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select purchase_price from purchase where imei=? and status='inStock'");
            st.setString(1, f1.getSelectedItem().toString());
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                pr=rs.getString("purchase_price");
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
        }
//        JOptionPane.showMessageDialog(null, pr);
     return pr;
    }
    public String purchasePrice(String imeiser)
    {
//        JOptionPane.showMessageDialog(null, imeiser);
        String pr="";
     Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select purchase_price from purchase where imei=? and status='sli'");
            st.setString(1, imeiser);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                pr=rs.getString("purchase_price");
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
        }
//        JOptionPane.showMessageDialog(null, pr);
     return pr;
    
    }
    public void updatePurchase()
    {
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("update purchase set status='sold' where imei ='"+f1.getSelectedItem().toString()+"' and status='inStock'");
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void purch2()
    {
        
        try {
            TableModel mo=t1.getModel();
            for(int i=0;i<t1.getRowCount();i++)
            {
                
                String date=null;
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                date=sdf.format(df.getDate());
                Connection con=getConnection();
                try {
                    PreparedStatement st=con.prepareStatement("insert into sale(imei,company,model,color,sale_name,ph,cnic,sale_date,status,sale_price,type,address,purchase_price,category)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    st.setString(1,mo.getValueAt(i, 1).toString());
                    st.setString(14,mo.getValueAt(i, 2).toString());
                    st.setString(2,mo.getValueAt(i, 3).toString());
                    st.setString(3,mo.getValueAt(i, 4).toString());
                    st.setString(4,mo.getValueAt(i, 5).toString());
                    st.setString(5,f7.getText());
                    st.setString(6,f8.getText());
                    st.setString(7,f9.getText());
                    st.setString(8,date);
                    st.setString(9,"sold");
                    st.setString(10,mo.getValueAt(i, 7).toString());
                    st.setString(11,mo.getValueAt(i, 6).toString());
                    st.setString(12,f10.getText());
                    st.setString(13, purchasePrice(mo.getValueAt(i, 1).toString()));
                    
                    st.executeUpdate();
                    st=con.prepareStatement("update purchase set status='sold' where imei ='"+mo.getValueAt(i, 1)+"' and status='sli'");
                    st.executeUpdate();
                    ti.setText("Total Items      :   ");
                    tt.setText("Total Bill     :      ");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MobilePurchase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            JOptionPane.showMessageDialog(null, " Saled Successfully");
            if(JOptionPane.showConfirmDialog(null, "Slip")==0)
            {
                print2();
            }
            Connection con=getConnection();
            PreparedStatement  st=con.prepareStatement("delete * from tsale");
            st.executeUpdate();
            clear();
            table();
        } catch (SQLException ex) {
            Logger.getLogger(MobileSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    public void print2()
    {
        String Header =
                      "******Star Mobile Center*********;\n;"
                    + "-----------------------------------------------\n; "
                    + "Name    "+f7.getText()+"\n; "
                    + "Date    "+sdf.format(df.getDate())+"\n; "
                
                    + "-----------------------------------------------\n; ";
//        String a="Imei     "+f1.getSelectedItem().toString()+"\n; "+"Company     "+f2.getText()+"\n; "+"Model     "+f3.getText()+"";
        String a="Imei                     "+"Model         "+"Type ";
        TableModel mo=t1.getModel();
        for(int i=0;i<t1.getRowCount();i++)
        {
            String sp="\n;";
             String pl=(mo.getValueAt(i, 1).toString()+"     "+mo.getValueAt(i, 4).toString())+"     "+mo.getValueAt(i, 6).toString();
            a=a+sp; 
             a=a+pl;
        }
             String h=Header+a;
        String amt  =
                    "\n;-----------------------------------------------\n; "
                    + "Total Bill      Rs."+price+"\n; "
                    + "-----------------------------------------------\n; "
                    + "-----------------------------------------------\n; "
                    + "         Contact us                \n; "
                    + "Call/Whatsapp 0340-8351689\n; "
                    + "Ground floor Saithi Plaza Sialkot\n; "
                    + "*******************************\n; "
                    + "            Thank You             \n; "
                    + "_______________________________\n";
        String fin=h+amt;
        printnow p=new printnow();
        printnow.printcard(fin);
        System.out.print(fin);

    }
    }

