package org.example;

import junit.framework.TestCase;

import java.util.HashMap;

public class PolynomTest extends TestCase {

    public void testAddMonom() {
        Monom m=new Monom(2,1);
        Polynom p=new Polynom();
        p.addMonom(m);
        assertEquals(p.getMonoame().get(m.getGrad()),m);
    }

    public void testGetMonoame() {
        HashMap<Integer,Monom> hm=new HashMap<>();
        Monom m1=new Monom(1,2);
        Monom m2=new Monom(-4,0);
        hm.put(2,m1);
        hm.put(0,m2);
        Polynom p=new Polynom();
        p.addMonom(m1);
        p.addMonom(m2);
        assertEquals(p.getMonoame(),hm);
    }

    public void testGetMax() {
        Monom m1=new Monom(1,2);
        Monom m2=new Monom(-4,0);
        Polynom p=new Polynom();
        p.addMonom(m1);
        p.addMonom(m2);
        assertEquals(p.getMax(),2);
    }

    public void testSetNr() {
        Polynom p=new Polynom();
        p.setNr(5);
        assertEquals(p.getNr(),5);

    }

    public void testGetNr() {
        Polynom p=new Polynom();
        p.setNr(5);
        assertEquals(p.getNr(),5);
    }

    public void testChangeSign() {
        Monom m1=new Monom(1,2);
        Monom m2=new Monom(-4,0);
        Polynom p=new Polynom();
        p.addMonom(m1);
        p.addMonom(m2);
        p.changeSign();
       assertEquals(p.getMonoame().get(2).getCoeficient(),-1.0);
        assertEquals(p.getMonoame().get(0).getCoeficient(),4.0);


    }
}