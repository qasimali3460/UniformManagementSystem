/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;
/**
 *
 * @author Unknown
 */
public class User {
          private int id;
          private String size;
          private String color;
          private String school;
          private String amount;
          private String price;
          private String product;
          private int total;
          String category="";
          String quantity="";
          String name="";
          String date="";
          User(int i,String si,String col,String sc,String am,String pr,String prd,int to)
          {
              id=i;
              size=si;
              color=col;
              school=sc;
              amount=am;
              price=pr;
              product=prd;
              total=to;
          }
          User(String cat,String si,String sc,String qu,String pr)
          {
              category=cat;
              size=si;
              school=sc;
              quantity=qu;
              price=pr;
          }
          
          User(String cat,String si,String sc,String qu,String pr,String nm,String dt)
          {
              category=cat;
              size=si;
              school=sc;
              quantity=qu;
              price=pr;
              name=nm;
              date=dt;
          }
          public String getDate()
          {
              return date;
          }
          public String getName()
          {
              return name;
          }
          public int getId()
          {
              return id;
          }
          public String getsize()
          {
              return size;
          }
          public String getcolor()
          {
              return color;
          }
          public String getschool()
          {
              return school;
          }
          public String getamount()
          {
              return amount;
          }
          public String getprice()
          {
              return price;
          }
          public String getproduct()
          {
              return product;
          }
          public int gettotal()
          {
              return total;
          }
          public String getcategory()
          {
              return category;
          }
          public String getquantity()
          {
              return quantity;
          }
          
}
