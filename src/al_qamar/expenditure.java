/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Qasim
 */
public class expenditure extends JPanel {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField f1,f2;
    JDateChooser f3;
    JPanel p1;
    JButton b1,b2;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
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

//            @Override
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

    public expenditure()
    {
        this.setLayout(new BorderLayout());
        frame();
        
    }
    public void frame()
    {
     f=new JFrame("Expense");
     f.setSize(400,400);
  
     f.setResizable(false);
     f.setBackground(new Color(136,134,183));
     f.setLocationRelativeTo(null);
     menue();
     
     JPanel p1=new JPanel(new GridBagLayout());
     p1.setBackground(new Color(114,112,163));
     l1=new JLabel("Expense name");
     l2=new JLabel("Cost");
     l3=new JLabel("Date");
     
     f1=new JTextField(15);
     f2=new JTextField(15);
     
        f2.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if((key>=e.VK_0&&key>=e.VK_9))
                {
                    f2.setEditable(false);
                }
                else
                    f2.setEditable(true);
                 
                        }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
     f3=new JDateChooser();
     
     b1=new JButton("Add");
     b1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             if(f1.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(null, "Please Enter Expense name");
             }
             else
             {
                 if(f2.getText().equals(""))
                 {
                     JOptionPane.showMessageDialog(null, "Please Enter Expense Price");
                 }
                 else
                 {
                     String dc=((JTextField)f3.getDateEditor().getUiComponent()).getText();
                     if(dc.equals(""))
                     {
                         JOptionPane.showMessageDialog(null,"Please Enter Date");
                     }
                     else
                     {
                         exp();
                     }
                 }
             }
             
         }
         
     });
     b2=new JButton("Show all");
     b2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
                f.dispose();
                expenseReport m=new expenseReport();
         }
         
     });
     
     GridBagConstraints gc=new GridBagConstraints();
     gc.insets=new Insets(10,10,10,10);
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
     p1.add(new JLabel("        "),gc);
     
     gc.gridx=1;
     gc.gridy=3;
     p1.add(new JLabel("        "),gc);
     
     gc.fill=GridBagConstraints.NONE;
     gc.insets=new Insets(150,10,10,10);
     gc.gridx=0;
     gc.gridy=4;
   //  p1.add(b2,gc);
     
     gc.anchor=GridBagConstraints.EAST;
     gc.gridx=1;
     gc.gridy=4;
     p1.add(b1,gc);
     
     
        Dimension d = p1.getPreferredSize();
        d.width=380;
        p1.setPreferredSize(d);
        Border outer = BorderFactory.createEmptyBorder(2,2,2,2);
        TitledBorder inner = BorderFactory.createTitledBorder("Expense");
        p1.setBorder(BorderFactory.createCompoundBorder(outer,inner));
     this.add(p1,BorderLayout.WEST);
     expenseReport epr=new expenseReport();
     this.add(epr,BorderLayout.CENTER);
     
     
     
     
     
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     f.setVisible(true);
     
    }
    public void exp()
    {
        String dc=sdf.format(f3.getDate());
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("insert into expense(expense_name,expense_date,price)values(?,?,?)");
            st.setString(1, f1.getText());
            st.setString(2,dc);
            st.setString(3, f2.getText());
            if(st.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null,"New Expense Added");
            }
            f1.setText("");
            f2.setText("");
            f3.setDate(null);
        } catch (SQLException ex) {
            Logger.getLogger(expenditure.class.getName()).log(Level.SEVERE, null, ex);
        }
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
   
}
