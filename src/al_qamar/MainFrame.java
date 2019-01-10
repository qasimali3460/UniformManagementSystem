/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class MainFrame {
JFrame f;    
JTabbedPane p;
JPanel p1;
Dimension d;
MainFrame()
{
    frame();
    
}
public void frame()
{
    f=new JFrame("Mobile Center");
    
        f.setSize(1280,780);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        p=new JTabbedPane();
        p.setBackground(Color.red);
        p.add(new JPanel());
        f.add(p,BorderLayout.CENTER);
        
        p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
  //      p1.setBackground(Color.red);
        f.add(p1,BorderLayout.NORTH);
        d=p1.getPreferredSize();
        d.height=80;
        p1.setPreferredSize(d);
        JLabel per=new JLabel("Shani Mobile Center");
        per.setBounds(450,20,500,30);
        per.setForeground(Color.white);
        per.setFont(new Font("Times New Roman",Font.BOLD,40));
    //    p1.setBorder(BorderFactory.createEtchedBorder());
        p1.setBackground(new Color(136,134,183));
        p1.add(per);
        f.add(p1);
        
    JPanel p2 = new JPanel();
    f.add(p2,BorderLayout.CENTER);
        
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
}



}
