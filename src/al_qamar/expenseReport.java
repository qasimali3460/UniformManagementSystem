
package al_qamar;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.*;
import static org.omg.CORBA.AnySeqHelper.insert;

public class expenseReport extends JPanel {
    
    JFrame f;
    JPanel p1,p2,p3,p4,p5,p6;
    JTextField f1,f2,f3,f5,f7,ctf;
    JButton b1,b2,b3,b4,b5,printb,delete,search;
    JTable t1;
    JScrollPane jp;
    Dimension d;
    TitledBorder inner;
    Border outer;
    JDateChooser cb1,cb2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l9,back,l10,cl,t;
    JComboBox san;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    int s=0,sany=0,update=0,type=0,companySelected=0;
    int date=0;
    String imeiSelected="H",statusSelected="H";
    String expenseSelected="",expenseDateSelected="";
    String []all={
        "select * from purchase where status='inStock'",
        "select * from purchase where imei=? and status='inStock'",
        "select * from purchase where company=? and status='inStock'",
        "select * from purchase where company=? and model=? and status='inStock'"
    };
    String []newm={
        "select * from purchase where type='new' and status='inStock'",
        "select * from purchase where imei=? and status='inStock'",
        "select * from purchase where company=? and type='new' and status='inStock'",
        "select * from purchase where company=? and type='new' and model=? and status='inStock'"
    };
    String []old={
        "select * from purchase where type='old' and status='inStock'",
        "select * from purchase where imei=? and status='inStock'",
        "select * from purchase where company=? and type='old' and status='inStock'",
        "select * from purchase where company=? and type='old' and model=? and status='inStock'"
    };
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

    expenseReport()
    {
        this.setLayout(new BorderLayout());
        frame();
        AutoCompleteDecorator.decorate(san);
//      AutoJComboBox autoComboBox = new AutoComboBox();
        sanUpdate();
    }
    public void sanUpdate()
    {
        update=1;
        san.removeAllItems();
        san.addItem("");
        Connection con=getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select * from purchase where status!='permanent'");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                san.addItem(rs.getString("imei"));
                san.addItem(rs.getString("company"));
                san.addItem(rs.getString("model"));
                san.addItem(rs.getString("color"));
                san.addItem(rs.getString("purchase_from"));
                san.addItem(rs.getString("ph"));
                san.addItem(rs.getString("cnic"));
                san.addItem(rs.getString("address"));
            }
            san.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(purchaseReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        update=0;
    }        
//    public void imeiUpdate()
//    {
//        update=1;
//        cb1.removeAllItems();
//        cb1.addItem("All");
//        Connection con=getConnection();
//        try {
//            PreparedStatement st=con.prepareStatement("select imei from purchase where status='inStock'");
//            ResultSet rs=st.executeQuery();
//            while(rs.next())
//            {
//                cb1.addItem(rs.getString("imei"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        cb1.setSelectedIndex(0);
//        update=0;
//    }
//    public void companyUpdate()
//    {
//        String qc=null;
//        update=1;
//        if(type==0)
//        {
//            qc="select DISTINCT company from purchase where status='inStock'";
//        }
//        if(type==1)
//        {
//            qc="select DISTINCT company from purchase where status='inStock' and type='new'";
//        }
//        if(type==2)
//        {
//            qc="select DISTINCT company from purchase where status='inStock' and type='old'";
//        }
//        cb2.removeAllItems();
//        cb2.addItem("All");
//        Connection con=getConnection();
//        try {
//            PreparedStatement st=con.prepareStatement(qc);
//            ResultSet rs=st.executeQuery();
//            while(rs.next())
//            {
//                cb2.addItem(rs.getString("company"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        cb2.setSelectedIndex(0);
//        companySelected=0;
//        update=0;
//    }
//    public void modelUpdate()
// {
//     String qc=null;
//     System.out.print("model update");
//               if(type==0)
//        {
//            qc="select DISTINCT model from purchase where company=? and status='inStock'";
//        }
//        if(type==1)
//        {
//            qc="select DISTINCT model from purchase where company=? and status='inStock' and type='new'";
//        }
//        if(type==2)
//        {
//            qc="select DISTINCT model from purchase where company=? and status='inStock' and type='old'";
//        }
//        update=1;
//        if(companySelected==1)
//        {
//            update=1;
//            cb3.removeAllItems();
//            cb3.addItem("All");
//            Connection con=getConnection();
//            try {
//                PreparedStatement st=con.prepareStatement(qc);
//                st.setString(1,cb2.getSelectedItem().toString());
//                ResultSet rs=st.executeQuery();
//                while(rs.next())
//                {
//                    cb3.addItem(rs.getString("model"));
//                }
//        } catch (SQLException ex) {
//            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            cb3.setSelectedIndex(0);
//            update=0;
//    
//    }
//        
// }
    public void frame()
    {
        f=new JFrame("Expenses Report");
        f.setSize(1280,780);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      
        menue();
        p1=new JPanel(null);
  //      p1.setBackground(Color.red);
     //   f.add(p1,BorderLayout.NORTH);
        d=p1.getPreferredSize();
        d.height=80;
        p1.setPreferredSize(d);
        ImageIcon icon=new ImageIcon("src/images/back.png");
        back=new JLabel(icon);
        back.setBounds(20,10,icon.getIconWidth(),icon.getIconHeight());
        JLabel per=new JLabel("Shani Mobile Center");
        per.setBounds(450,20,500,30);
        per.setForeground(Color.white);
        per.setFont(new Font("Times New Roman",Font.BOLD,40));
        
        p1.add(per);
        p1.add(back);
        p1.setBorder(BorderFactory.createEtchedBorder());
        
        p2=new JPanel(null);
//        f.add(p2,BorderLayout.WEST);
//        p2.setBackground(Color.yellow);
        d=p2.getPreferredSize();
        d.width=380;
        p2.setPreferredSize(d);
        inner=BorderFactory.createTitledBorder("Stock");
        outer=BorderFactory.createEmptyBorder(5,5,5,5);
        p2.setBorder(BorderFactory.createCompoundBorder(outer,inner));
        form();
        
        p3=new JPanel(new BorderLayout());
        
        p4=new JPanel();
        d=p4.getPreferredSize();
        d.height=100;
        p4.setPreferredSize(d);
        p4.setBorder(BorderFactory.createEtchedBorder());
        outer=BorderFactory.createEmptyBorder(2,2,2,2);
        inner=BorderFactory.createTitledBorder("Filter");
        p4.setBorder(BorderFactory.createCompoundBorder(outer,inner));
       
        p3.add(p4,BorderLayout.NORTH);
        
        this.add(p3,BorderLayout.CENTER);
        p3.setBackground(Color.GREEN);
         
        p5=new JPanel(new BorderLayout());
        inner=BorderFactory.createTitledBorder("Expenses");
        p5.setBorder(BorderFactory.createCompoundBorder(outer,inner));
        p5.setBackground(new Color(114,112,163));
        p3.add(p5,BorderLayout.CENTER);
        
             
        p6=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        d=p6.getPreferredSize();
        d.height=50;
        p6.setPreferredSize(d);
        printb=new JButton("Print");
        printb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t1.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        delete=new JButton("Delete");
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!imeiSelected.equals(""))
                {
                    if(JOptionPane.showConfirmDialog(null," Are you sure want to delete this purchase")==0)
                    {
                        try {
                            Connection con=getConnection();
                            PreparedStatement st=con.prepareStatement("delete * from expense where expense_name=? and expense_date=? ");
                            st.setString(1, expenseSelected);
                            st.setString(2, expenseDateSelected);
//                            st.setString(2, sdf.format(
                            if(st.executeUpdate()==1)
                            {
                                JOptionPane.showMessageDialog(null,"Expense deleted Successfully");
                                table();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(purchaseReport.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
                
        });
        l10=new JLabel("Total Expenses      :        ");
        p6.add(l10);
        p6.add(new JLabel("                                         "));
        p6.add(delete);
      //  p6.add(new JLabel("          "));
        p6.add(printb);
        //p6.add(new JLabel("         "));
        p6.setBorder(BorderFactory.createEtchedBorder());
      //  l10.setBounds(900,10,300,30);
        l10.setForeground(Color.white);
        this.add(p6,BorderLayout.SOUTH);
        
        Object[][] data={
        };
            String[] columnN={"id","IMEI","Company","Model","Price","Date"};
            DefaultTableModel mo=new DefaultTableModel(data,columnN);
            t1=new JTable(mo);
            jp=new JScrollPane(t1);
            p5.add(jp,BorderLayout.CENTER);
            p5.remove(jp);
           
        combo();
            
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//        f.setResizable(false);
        
        
        p1.setBackground(new Color(136,134,183));
        p4.setBackground(new Color(114,112,163));
        p2.setBackground(new Color(114,112,163));
        p6.setBackground(new Color(114,112,163));
    }
    public void table()
    {
        int total=0;
        p5.remove(jp);
        p5.setVisible(false);
        Object[][] data={
        };
         String[] columnN={"id","Expense name","Cost","Date"};
         DefaultTableModel mo=new DefaultTableModel(data,columnN);
         t1=new JTable(mo);
         t1.setPreferredScrollableViewportSize(new Dimension(500,50));
         t1.setFillsViewportHeight(true);
         jp=new JScrollPane(t1);
         p5.add(jp,BorderLayout.CENTER);
         ArrayList<Expense> list=getArrayList();
         DefaultTableModel model=(DefaultTableModel) t1.getModel();
         Object row[]=new Object[4];
         if(date==1)
         {
          
          Date ds=cb1.getDate();
          Date de=cb2.getDate();
          Date comp=null;
  
          for(int i=0;i<list.size();i++)
            {
              try {
                  comp=sdf.parse(list.get(i).getDate());
                  if(comp.after(ds) && comp.before(de) || sdf.format(comp).equals(sdf.format(ds))|| sdf.format(comp).equals(sdf.format(de)))
                  {
                    row[0]=1+i;
                    row[1]=list.get(i).getName();
                    row[2]=list.get(i).getCost();
                    row[3]=list.get(i).getDate();
                    model.addRow(row);
                    total=total+Integer.valueOf(list.get(i).getCost());
                  }
                  
              
              } catch (ParseException ex) {
                  Logger.getLogger(purchaseReport.class.getName()).log(Level.SEVERE, null, ex);
              }
               

            }
            l10.setText("Total Expense    :     "+total);
     
         
         }      
//      if(sany==1)
//         {
//          String sco=san.getSelectedItem().toString();
//          for(int i=0;i<list.size();i++)
//            {
//               
//                if(sco.equals(list.get(i).getImei())||sco.equals(list.get(i).getCompany())||sco.equals(list.get(i).getModel())||sco.equals(list.get(i).getName())||sco.equals(list.get(i).getColor())||sco.equals(list.get(i).getPh())||sco.equals(list.get(i).getCnic())||sco.equals(list.get(i).getAddress()))
//                {
//                    row[0]=1+i;
//                    row[1]=list.get(i).getImei();
//                    row[2]=list.get(i).getCompany();
//                    row[3]=list.get(i).getModel();
//                    row[4]=list.get(i).getColor();
//                    row[5]=list.get(i).getType();
//                    row[6]=list.get(i).getStatus();
//                    row[7]=list.get(i).getPrice();
//                    row[8]=list.get(i).getName();
//                    row[9]=list.get(i).getPh();
//                    row[10]=list.get(i).getCnic();
//                    row[11]=list.get(i).getAddress();
//                    row[12]=list.get(i).getDate();
//                    model.addRow(row);
//                    l10.setText("Total Purchases    :     "+String.valueOf(1+i));
//
//                }
//               
//
//            }
//           
//         }
//          for(int i=0;i<list.size();i++)
//            {
//                row[0]=1+i;
//                row[1]=list.get(i).getImei();
//                row[2]=list.get(i).getCompany();
//                row[3]=list.get(i).getModel();
//                row[4]=list.get(i).getColor();
//                row[5]=list.get(i).getType();
//                row[6]=list.get(i).getPrice();
//                model.addRow(row);
//                
//            }
//         
//         l10.setText("Total Products    :     "+String.valueOf(list.size()));
         p5.setVisible(true);
         t1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
       
                int a=t1.getSelectedRow();
                TableModel mo=t1.getModel();
                expenseSelected=mo.getValueAt(a, 1).toString();
                expenseDateSelected=mo.getValueAt(a,3).toString();
                
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
        
    }
    public void fclear()
    {
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f5.setText("");
        f7.setText("");
        ctf.setText("");
    }
    
    public void combo()
    {
        
        String []im=null;
        String []co={"All","Qasim","Hello"};
        String []mo={"Select company first"};
        String []ty={"All","New","Old"};
        cb1=new JDateChooser();
        cb2=new JDateChooser();
        cb1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.print("click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.print("press");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.print("release");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.print("enter");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        l1=new JLabel("From");
        l2=new JLabel("To");
        l3=new JLabel("Search");
        
        
        san=new JComboBox();
        san.addItem("qasim");
        san.addItem("Ali");
        san.addItem("Hamza");
        san.addItem("Nauman");
        
        
        search=new JButton("Search");
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb1.getDate()==null)
                {
                    if(cb2.getDate()==null)
                    {
                        if(san.getSelectedIndex()==0)
                        {
                        
                        }
                        else
                        {
                            san();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please select date correctly");
                        sanUpdate();
                    }
                }
                else
                {
                    if(cb2.getDate()==null)
                    {
                        JOptionPane.showMessageDialog(null, "Please select dates correctly");
                        sanUpdate();
                    }
                    else
                    {
                        if(cb1.getDate().after(cb2.getDate()))
                        {
                           JOptionPane.showMessageDialog(null,"Please select dates correctly");
                           sanUpdate();
                        }
                        else
                        {
                            dateSearch();
                        }
                    }
                }
            }
            
        });
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);
        
        cb1.setBounds(20,50,150,30);
        cb2.setBounds(300,50,150,30);
    
        p4.setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.insets=new Insets(5,5,5,5);
        gc.weightx=1;
        gc.gridx=0;
        gc.gridy=0;
        p4.add(l1,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        p4.add(cb1,gc);

        gc.gridx=5;
        gc.gridy=0;
        p4.add(l2,gc);
        
        gc.gridx=6;
        gc.gridy=0;
        p4.add(cb2,gc);
        gc.fill=GridBagConstraints.NONE;
        gc.gridx=7;
        gc.gridy=0;
        p4.add(search,gc);
//        
//        gc.gridx=8;
//        gc.gridy=0;
//        p4.add(san,gc);
//        
//        gc.fill=GridBagConstraints.CENTER;
//        gc.gridx=9;
//        gc.gridy=0;
//        p4.add(search,gc);
//        
//        
        san.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(update==0)
                {
                   cb1.setDate(null);
                   cb2.setDate(null);
                }
            }
        });
//        p4.add(l1);
//        p4.add(l2);
//        p4.add(l3);
//        
//        p4.add(cb1);
//        p4.add(cb2);
//        p4.add(cb3);
        
    }
    public void san()
    {
        date=0;
        sany=1;
        table();
    }
    public void dateSearch(){
        sany=0;
        sanUpdate();
        date=1;
        table();
    }
    public void form()
    {
        l4=new JLabel("IMEI/ ID :");
        l5=new JLabel("Company :");
        l6=new JLabel("Model name :");
        l7=new JLabel("Type :");
        l9=new JLabel("Price :");
        cl=new JLabel("Color");
        f1=new JTextField("",10);
        f1.setSize(20,30);
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
        
        
        f2=new JTextField("",10);
        f3=new JTextField("",10);
        f5=new JTextField("",10);
        f7=new JTextField("",10);
        ctf=new JTextField("",10);
        
        b1 = new JButton("Update");
        b2 = new JButton("Delete");
        b3 = new JButton("Sale     ");
        b4 = new JButton("Clear  ");
        
        p2.setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(30,5,5,5);
//        gc.weightx=1;
//        gc.gridheight=10;
        gc.gridwidth=1;
        gc.gridx=0;
        gc.gridy=0;
//        gc.fill=GridBagConstraints.NONE;

        p2.add(l4,gc);
        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=1;
        gc.gridy=0;
        p2.add(f1,gc);
         
//        gc.weightx=1;
//        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=1;
//        gc.anchor=GridBagConstraints.LINE_END;
        p2.add(l5,gc);
        
//        gc.anchor=GridBagConstraints.LINE_START;
        gc.gridx=1;
        gc.gridy=1;
        p2.add(f2,gc);
         
//        gc.weightx=1;
//        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy=2;
        p2.add(l6,gc);
        
//        gc.weightx=1;
//        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.LINE_START;
        gc.gridx=1;
        gc.gridy=2;
        p2.add(f3,gc);

//        gc.weightx=1;
//        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy=3;
        p2.add(l7,gc);
        
//        gc.anchor=GridBagConstraints.LINE_START;
        gc.gridx=1;
        gc.gridy=3;
        p2.add(f5,gc);
        
//        gc.weightx=1;
//        gc.weighty=0.1;
//        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy=4;
        p2.add(cl,gc);
        
//        gc.anchor=GridBagConstraints.LINE_START;
        gc.gridx=1;
        gc.gridy=4;
        p2.add(ctf,gc);
        
        gc.gridx=0;
        gc.gridy=5;
        p2.add(l9,gc);
        
        gc.gridx=1;
        gc.gridy=5;
        p2.add(f7,gc);
        gc.anchor=GridBagConstraints.CENTER;
        gc.insets=new Insets(50,50,50,50);
        gc.gridx=1;
        gc.gridy=6;
        gc.weighty=0.5;
        JPanel btnlayout3=new JPanel(new BorderLayout());
        JPanel btnlayout=new JPanel(new FlowLayout());
        btnlayout.add(b1);
        btnlayout.add(b2);
        btnlayout3.add(btnlayout,BorderLayout.NORTH);

//        gc.insets=new Insets(50,5,5,5);
        gc.gridx=1;
        gc.gridy=6;
        JPanel btnlayout2=new JPanel(new FlowLayout());
        btnlayout2.add(b3);
        btnlayout2.add(b4);
        btnlayout3.add(btnlayout2,BorderLayout.SOUTH);
        p2.add(btnlayout3,gc);
        
        btnlayout.setBackground(new Color(114,112,163));
        btnlayout2.setBackground(new Color(114,112,163));

//        gc.weightx=1;
//        gc.weighty=1;
       
//        gc.fill=GridBagConstraints.HORIZONTAL;
//        gc.anchor=GridBagConstraints.LINE_END;

//        p2.add(b1,gc);
//        
//        gc.anchor=GridBagConstraints.CENTER;
//        gc.gridx=1;
//        gc.gridy=5;
//        p2.add(b2,gc);
//        
////        gc.weightx=0;
////        gc.weighty=1;
//        gc.anchor=GridBagConstraints.LINE_END;
//        gc.gridx=0;
//        gc.gridy=6;
//        p2.add(b3,gc);
//        
//        gc.anchor=GridBagConstraints.CENTER;
//        gc.gridx=1;
//        gc.gridy=6;
//        p2.add(b4,gc);
//        
        
//        l4.setBounds(30,20,150,30);
//        p2.add(l4);
//       
//        f1.setBounds(50,50,250,30);
//        p2.add(f1);
//       
//
//        l5.setBounds(30,100,150,30);
//        p2.add(l5);
//       
//        f2.setBounds(50,140,250,30);
//        p2.add(f2);
//       
//        l6.setBounds(30,200,150,30);
//        p2.add(l6);
//        
//        f3.setBounds(50,230,250,30);
//        p2.add(f3);
//       
//        l7.setBounds(30,280,50,30);
//        p2.add(l7);
//        
//        f5.setBounds(50,310,250,30);
//        p2.add(f5);
//        
//        l9.setBounds(30,370,150,30);
//        p2.add(l9);
//        
//        f7.setBounds(50,400,250,30);
//        p2.add(f7);
//        
        
        
        b1.setBounds(40,450,120,50);
        b1.setBackground(new Color(25,169,46));
//        p2.add(b1);
//        b1.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String im=f1.getText();
//                String co=f2.getText();
//                String mo=f3.getText();
//                String ty=f5.getText();
//                String cf=ctf.getText();
//                String pi=f7.getText();
//                Connection con=getConnection();
//                PreparedStatement st=null;    
//                if(im.equals(oldImei))
//                {
//                    try {
//                        st=con.prepareStatement("update purchase set company='"+co+"',model='"+mo+"',type='"+ty+"',color='"+cf+"',purchase_price='"+pi+"' where imei='"+im+"'");
//                        if(st.executeUpdate()==1)
//                        {
//                            JOptionPane.showMessageDialog(null, "Values updated Successfully");
//                           s=0;
//                            table();
//                            update=1;
//                        }
//                        
//                    } catch (SQLException ex) {
//                        Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                else{
//                if(cimei()==true)
//                {
//                    JOptionPane.showMessageDialog(null, "Imei Already exist");
//                }
//                else
//                {
//                    try {
//                        st=con.prepareStatement("update purchase set company='"+co+"',model='"+mo+"',type='"+ty+"',color='"+cf+"',purchase_price='"+pi+"',imei='"+im+"' where imei='"+oldImei+"'");
//                    } catch (SQLException ex) {
//                        Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    try {
//                        if(st.executeUpdate()==1)
//                        {
//                            JOptionPane.showMessageDialog(null, "Values updated Successfully");
//                            s=0;
//                            table();
//                            update=1;
//                        }
//                    } catch (SQLException ex) {
//                        Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                }
//                
//                
//            }
//            
//        
//        });        
        
        b3.setBounds(40,520,120,50);
        b3.setBackground(new Color(197,24,47));
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sale");
            }
            
        });
//        p2.add(b3);
        
        b2.setBounds(180,450,120,50);
        b2.setBackground(new Color(20,180,182));
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con=getConnection();
                    PreparedStatement st=null;
                    st=con.prepareStatement("delete * from purchase where imei='"+f1.getText()+"'");
                    if(JOptionPane.showConfirmDialog(null, "Are you sure want to delete")==0)
                    {
                        if(st.executeUpdate()==1)
                        {
                            JOptionPane.showMessageDialog(null, "Deleted successfully");
                            s=0;
                            table();
                            update=1;
                        }
                       
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
//        p2.add(b2);
        
        b4.setBounds(180,520,120,50);
        b4.setBackground(new Color(216,72,2));
        
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               clearAll();
            }
            
        });
//        p2.add(b4);
    }
    public void clearAll()
    {
        fclear();
        s=0;
        table();
        update=1;
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
     ArrayList<Expense> getArrayList()
     {
         ArrayList<Expense> list=new ArrayList<Expense>();
         PreparedStatement st=null;
         Connection con=getConnection();
        try {
            st=con.prepareStatement("select * from expense where expense_name!='permanent'");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                Expense m=new Expense(rs.getString("expense_name"),rs.getString("price"),rs.getString("expense_date"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(purchaseReport.class.getName()).log(Level.SEVERE, null, ex);
        }
         
//        try {
//            if(type==0)
//            st=con.prepareStatement(all[s]);
//            if(type==1)
//            st=con.prepareStatement(newm[s]);
//            if(type==2)
//            st=con.prepareStatement(old[s]);
//            
//            if(s==0)
//            {
//  //              JOptionPane.showMessageDialog(null, "0");
//            }
//            else
//            if(s==1)
//            {
//    //            st.setString(1, cb1.getSelectedItem().toString());
//            }
//            else
//            if(s==2)
//            {
//                   st.setString(1, cb2.getSelectedItem().toString());
//            }else
//            if(s==3)
//            {
//                   st.setString(1, cb2.getSelectedItem().toString());
//                   st.setString(2, cb3.getSelectedItem().toString());
//            }
//            ResultSet rs=null;
//            rs=st.executeQuery();
//            while(rs.next())
//            {
//                Mobile m=new Mobile(rs.getString("imei"),rs.getString("company"),rs.getString("model"),rs.getString("color"),rs.getString("type"),rs.getString("purchase_price"));
//                list.add(m);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(MobileStock.class.getName()).log(Level.SEVERE, null, ex);
//        }
         
         return list;
     
     }

}
