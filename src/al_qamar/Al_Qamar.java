/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Al_Qamar {

    
    public static void main(String[] args) throws InterruptedException {
  
        try {
            Al_Qamar q=new Al_Qamar();
//        JOptionPane.showMessageDialog(null,"hello");
//        q.startup();
           File f=new File("C://db//uniform.accdb");
           if(f.exists())
           {
           int qua=0;
           Connection con=UniformStock.getConnection();
           int tot=0;
            PreparedStatement st=con.prepareStatement("select * from tsale");
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                rs=st.executeQuery();   
                    while(rs.next())
                {
                    qua=Integer.valueOf(rs.getString("quantity"));
                    String ct=rs.getString("category");
                    String si=rs.getString("size");
                    String sc=rs.getString("school");
                        st=con.prepareStatement("select * from stock where category=? and size=? and school=?");
                        st.setString(1, ct);
                        st.setString(2, si);
                        st.setString(3, sc);
                      ResultSet rs2=st.executeQuery();
                        while(rs2.next())
                        {
                            tot=Integer.valueOf(rs2.getString("quantity"));
                        }
                        
                        st=con.prepareStatement("update stock set quantity=?  where category=? and size=? and school=?");
                        st.setString(1,String.valueOf((tot+qua)));
                        st.setString(2, ct);
                        st.setString(3, si);
                        st.setString(4, sc);
                        st.executeUpdate();
              
                }
                    
                        st=con.prepareStatement("delete * from tsale ");
                        st.executeUpdate();
                  
            }

            q.startup();
            UniformStock m=new UniformStock();

           }
                     
//    CatFrame mo=new CatFrame();
//if(f.exists())
//{
//            PreparedStatement st=con.prepareStatement("update purchase set status=? where status=?");
//            
//            st.setString(1, "inStock");
//            st.setString(2, "sli");
//            st.executeUpdate();
//            
//            st=con.prepareStatement("delete * from tsale");
//            st.executeUpdate();
//            
//    MobileStock m=new MobileStock();
////            MainFrame m=new MainFrame();
//}
//else
//{
//    File f2=new File("C://db");
//    if(!f2.exists())
//    {
//        f2.mkdir();
//    }
//    JOptionPane.showMessageDialog(null, "Please insert databse file in 'db' folder in your C Drive");
//    
//}
//     MobilePurchase m=new MobilePurchase();
//       purchaseReport p=new purchaseReport();
//       MobileSale m=new MobileSale();
//        saleReport m=new saleReport();
//        expenditure m=new expenditure();
//        expenseReport m=new expenseReport();
//        profit m=new profit();
        } catch (SQLException ex) {
            Logger.getLogger(Al_Qamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
     void startup()
   {
   splash();
  //log();
   } 
     void log()
     {
         Login l=new Login();
     }
  void splash()
    {
        s sa=new s();
        sa.setVisible(true);
                try{
          for(int i=0;i<=100;i++)
          {
              Thread.sleep(60);
              sa.val(i);
          
          }
          Thread.sleep(1000);
         sa.dispose();
       }
        catch(Exception e)
        {
            
        }

    }
    
}
