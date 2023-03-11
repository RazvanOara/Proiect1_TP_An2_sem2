package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI {
    private static JFrame f;
    private static JTextField fpt,spt;
    private static JLabel rt;
    public static  void main(String [] args)
    {
        JButton add,sub,inte,mul,div,der,mutaRez;
        f=new JFrame("Polynom calculator");
        mutaRez=new JButton("Use the result");
        mutaRez.setOpaque(false);
        mutaRez.setContentAreaFilled(false);
        mutaRez.setBorderPainted(false);
        mutaRez.setVisible(true);
        mutaRez.setBounds(380,135,200,70);
        mutaRez.setFont(new Font("Arial", Font.BOLD, 18));
        mutaRez.setEnabled(false);
        JLabel fp=new JLabel("First Polynomial= "); fp.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel sp=new JLabel("Second Polynomial="); sp.setFont(new Font("Arial", Font.BOLD, 18));
        fp.setBounds(23,0,200,100);
        sp.setBounds(0,60,200,100);
        fp.setVisible(true);
        sp.setVisible(true);
        f.getContentPane().add(fp);
        f.getContentPane().add(sp);
        fpt=new JTextField();
        fpt.setBounds(180,38,200,30);
        fpt.setVisible(true);
        f.getContentPane().add(fpt);
        spt=new JTextField();
        spt.setBounds(180,98,200,30);
        spt.setVisible(true);
        f.getContentPane().add(spt);
        JLabel rez=new JLabel("Result="); rez.setFont(new Font("Arial", Font.BOLD, 18));
        rez.setVisible(true);
        rez.setBounds(110,120,200,100);
        f.getContentPane().add(rez);
        rt=new JLabel();
        rt.setOpaque(true);
        rt.setBounds(180,155,200,30);
        rt.setVisible(true);
        rt.setEnabled(false);
        f.getContentPane().add(rt);
        add=new JButton("Addition");  add.setBackground(Color.BLUE);add.setForeground(Color.white);
        add.setBounds(0,250,200,70);
        add.setVisible(true);
        add.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(add) ;
        sub=new JButton("Substract");sub.setBackground(Color.BLUE);sub.setForeground(Color.white);
        sub.setBounds(0,330,200,70);
        sub.setVisible(true);
        sub.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(sub) ;
        mul=new JButton("Multiply"); mul.setBackground(Color.BLUE);mul.setForeground(Color.white);
        mul.setBounds(0,410,200,70);
        mul.setVisible(true);
        mul.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(mul) ;
        div=new JButton("Divide"); div.setBackground(Color.BLUE);div.setForeground(Color.white);
        div.setBounds(220,250,200,70);
        div.setVisible(true);
        div.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(div) ;
        der=new JButton("Derive"); der.setBackground(Color.BLUE);der.setForeground(Color.white);
        der.setBounds(220,330,200,70);
        der.setVisible(true);
        der.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(der) ;
        inte=new JButton("Integrate"); inte.setBackground(Color.BLUE);inte.setForeground(Color.white);
        inte.setBounds(220,410,200,70);
        inte.setVisible(true);
        inte.setFont(new Font("Arial", Font.BOLD, 18));
        f.getContentPane().add(inte) ;
        add.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      rt.setBounds(180,155,200,30);adunare();
                                  }  });

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rt.setBounds(180,155,200,30);scadere();
            }  });
        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rt.setBounds(180,155,200,30);
               multy();
            }  });
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rt.setBounds(180,155,200,30);
              divi();
            }  });
        der.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rt.setBounds(180,155,200,30);
                deri();
            }  });
       inte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rt.setBounds(180,155,200,30);inter();
            }  });

        JMenuBar mb=new JMenuBar();
        JMenuItem about=new JMenuItem("About");
        mb.add(about);
        f.setJMenuBar(mb);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f,"<html>This is a basic polynomial calculator app, with addition,subtraction,<br/>  multiplication,derivation and integration.<br/>The correct inputs to the polynomial are the same as:<br/>-5<br/>5x<br/>3x^2-4x+2");
            }  });

        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(400,100,700,600);
        f.getContentPane().setBackground(new Color(204, 204, 0, 255));
    }
    public  static  void typoError(String t)
    {
        JOptionPane.showMessageDialog(f,t+" Polynom is typed inccorectly");
    }
public static void adunare()
{
Polynom p1= checkPoly(fpt.getText());
Polynom p2=checkPoly(spt.getText());
if(p1==null)
    typoError("First");
    else if(p2==null) typoError("Second");
       else
{
    Polynom rez=Operations.adunare(p1,p2);
    if(rez.toString().length()>25)
        rt.setBounds(180, 155, 200 + 6 * (Operations.adunare(p1, p2).toString().length() - 25), 30);

     rt.setText(rez.toString());

    if(rt.getText().charAt(0)=='0') rt.setText("0");
}

}
public static void scadere()
    {
        Polynom p1= checkPoly(fpt.getText());
        Polynom p2=checkPoly(spt.getText());
        if(p1==null)
            typoError("First");
        else if(p2==null) typoError("Second");
        else
        {
                p2.changeSign();
                Polynom rez=Operations.adunare(p1,p2);
            if(rez.toString().length()>25)
                rt.setBounds(180,155,200+6*(Operations.adunare(p1,p2).toString().length()-25),30);
            rt.setText(rez.toString());
        }

    }
public static void multy()
{
    Polynom p1= checkPoly(fpt.getText());
    Polynom p2=checkPoly(spt.getText());
    if(p1==null)
        typoError("First");
    else if(p2==null) typoError("Second");
    else{
        Polynom r1=p1;
        Polynom r2=p2;
        Polynom p=Operations.muliply(p1,p2);
        Polynom r=Operations.muliply(r1,r2);
        if(r.toString().length()>25)
            rt.setBounds(180,155,200+6*(r.toString().length()-25),30);
        rt.setText(p.toString());
        if(rt.getText().charAt(0)=='0') rt.setText("0");

    }
}
public static void divi()
{
    Polynom p1= checkPoly(fpt.getText());
    Polynom p2=checkPoly(spt.getText());
    if(p1==null)
        typoError("First");
    else if(p2==null) typoError("Second");
    else
    if(p2.getMax()>p1.getMax())
    JOptionPane.showMessageDialog(f,"First polynom grade must be higher");
    else{
        if (spt.getText().charAt(0) == '0')
            JOptionPane.showMessageDialog(f, "Can not divide by zero");
        else {
            if (p1.getNr() == 1 && p1.getMonoame().get(p1.getMax()).getCoeficient() == 0)
                rt.setText("0");
            else
            {
                Polynom r[] = new Polynom[2];
            r = Operations.divie(p1, p2);
            try {
                assert r != null;
                if(r[0].toString().length()+r[1].toString().length()>25)
                  rt.setBounds(180,155,200+6*(r[0].toString().length()+r[1].toString().length()-25),30);
              rt.setText("Q=" + r[0].toString() + "  R=" + r[1].toString());
            } catch (Exception e) {
                rt.setText("Not an Integer");
            }
        }
    }


    }
}
public  static void deri()
{
    Polynom p1= checkPoly(fpt.getText());
    if(p1==null)
        typoError("First");
    else {

        JOptionPane.showMessageDialog(f,"First Polynomial will be deriate");
        Polynom r=p1;
        r=Operations.derivative(r);
        if(r==null) rt.setText("0");
        else {
            if (r.toString().length() > 25)
                rt.setBounds(180, 155, 200 + 6 * (r.toString().length() - 25), 30);
            rt.setText(r.toString());
        }
    }
}
public  static void inter()
{
    Polynom p1= checkPoly(fpt.getText());
    if(p1==null)
        typoError("First");
    else {
        JOptionPane.showMessageDialog(f,"First Polynomial will be integrate");
        Polynom r=Operations.integration(p1);
        if(r.toString().length()>25)
            rt.setBounds(180,155,200+6*(r.toString().length()-25),30);
        if(r==null) rt.setText("0");
        else
        rt.setText(r.toString());
    }
}
public static String reverseString(String str,int i)
{
    if(i>str.length()-1) return "";
    else {
     char  ch= str.charAt(i);
       return reverseString(str,++i)+ch;
    }
}
public static Polynom checkPoly(String pol) {
        String notAlowwed="qwertyuiopasdfghjklzcvbnmQWERTYUIOPASDFGHJKLZXCVBNM[];',./{}:<>?|=_)(*&%$#@!\"\\";
    for (char c:pol.toCharArray()
         ) {
        if(notAlowwed.contains(c+"")) return  null;
    }
        Polynom p=new Polynom();
    int coef=0,grad=-1;
    try {
        Pattern pattern = Pattern.compile("x");
        Matcher matcher = pattern.matcher(pol);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int i = start - 1;
            if (i == -1 || pol.charAt(i) == '+')
                coef = 1;
            else if (pol.charAt(i) == '-') coef = -1;
            else {
                String num = "";
                while (i >= 0 && pol.charAt(i) != '+' && pol.charAt(i) != '-') {
                    num += pol.charAt(i);
                    i--;
                }
                num = reverseString(num, 0);
                coef = Integer.parseInt(num);
                if (i >= 0 && pol.charAt(i) == '-') coef = coef * -1;
            }
            i = start + 2;
            if (i > pol.length() || pol.charAt(start + 1) == '+' || pol.charAt(start + 1) == '-') grad = 1;
            else {
                String gr = "";
                while (i < pol.length() && pol.charAt(i) != '+' && pol.charAt(i) != '-') {
                    gr += pol.charAt(i);
                    i++;
                }
                grad = Integer.parseInt(gr);
            }
            Monom m = new Monom(coef, grad);
            p.addMonom(m);
        }
        int i = pol.length() - 1;
        String cf = "";
        while (i >= 0 && Character.isDigit(pol.charAt(i))) {
            cf += pol.charAt((i));
            i--;
        }
        if (i < 0 || pol.charAt(i) == '+') {
            Monom m = new Monom(Integer.parseInt(reverseString(cf, 0)), 0);
            p.addMonom(m);
        } else if (pol.charAt(i) == '-') {
            Monom m = new Monom(-Integer.parseInt(reverseString(cf, 0)), 0);
            p.addMonom(m);
        }
        return p;
    }
    catch (Exception e){return null;}
}
}
