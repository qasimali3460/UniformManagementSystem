/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

/**
 *
 * @author Qasim
 */
public class Expense {
    String name;
    String cost;
    String date;
    
    Expense(String nm,String co,String da)
    {
        name=nm;
        cost=co;
        date=da;
    }
    public String getName()
    {
        return name;
    }
    public String getCost()
    {
        return cost;
    }
    public String getDate()
    {
        return date;
    }
}
