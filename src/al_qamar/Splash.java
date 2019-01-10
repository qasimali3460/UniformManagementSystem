/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al_qamar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Splash {
public JFrame f; 
JPanel p;
public JLabel l1,l2,l3;
public JProgressBar b;

    public Splash()
    {
        f=new JFrame();
        f.setUndecorated(true);
        f.setSize(635,385);
        f.setLocationRelativeTo(null);
         ImageIcon ficon=new ImageIcon("images/logo2.png");
        f.setIconImage(ficon.getImage());
       
        p=new JPanel(null);
        p.setBackground(new Color(204,204,204));
        f.add(p);
        ImageIcon icon=new ImageIcon("images/b2.png");
        l1=new JLabel(icon);
        l1.setBounds(400,20,icon.getIconWidth(),icon.getIconHeight());
        p.add(l1);
        icon=new ImageIcon("images/logo.png");
        l2=new JLabel(icon);
        l2.setBounds(-150,-80,icon.getIconWidth(),icon.getIconHeight());
        p.add(l2);
        l3=new JLabel("Loading 100%");
        l3.setBounds(250,300,150,30);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));
        l3.setForeground(Color.white);
        p.add(l3);
        b=new JProgressBar();
        b.setValue(20);
        b.setBounds(0,351,f.getWidth(),26);
        b.setBackground(new     Color(253,253,253));
//        b.setForeground(new Color(70,180,78));
//        b.setForeground(new Color(86,98,252));
//        b.setForeground(new Color(167,98,252));
        b.setForeground(new Color(1,36,58));
        l3.setForeground(new Color(1,36,58));
        
        p.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
        
    }

}
