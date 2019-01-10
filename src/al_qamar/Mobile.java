package al_qamar;
/**
 *
 * @author Unknown
 */
public class Mobile {
          private String imei="";
          private String company="";
          private String model="";
          private String color="";
          private String price="";
          private String type="";
          private String status="";
          private String name="";
          private String ph="";
          private String cnic="";
          private String address="";
          private String date="";
          String category="";
          
          Mobile(String i,String cat,String c,String mod,String co,String ty,String pr)
          {
              imei=i;
              company=c;
              model=mod;
              price=pr;
              type=ty;
              color=co;
              category=cat;
          }
          
          Mobile(String i,String cat,String c,String mod,String co,String ty,String pr,String st,String nm,String pho,String cn,String ad,String dat)
          {
              imei=i;
              company=c;
              model=mod;
              price=pr;
              type=ty;
              color=co;
              status=st;
              name=nm;
              ph=pho;
              cnic=cn;
              address=ad;
              date=dat;
              category=cat;
              
          }

          public String getImei()
          {
              return imei;
          }
          public String getCompany()
          {
              return company;
          }
          public String getModel()
          {
              return model;
          }
          public String getPrice()
          {
              return price;
          }
          public String getType()
          {
              return type;
          }
          public String getColor()
          {
              return color;
          }
          public String getStatus()
          {
              return status;
          }
          public String getDate()
          {
              return date;
          }
          public String getName()
          {
              return name;
          }
          public String getPh()
          {
              return ph;
          }
          public String getCnic()
          {
              return cnic;
          }
          public String getAddress()
          {
              return address;
          }
          public String getCategory()
          {
              return category;
          }
}
