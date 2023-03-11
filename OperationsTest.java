package org.example;

import junit.framework.TestCase;

public class OperationsTest extends TestCase {

    public void testAdunare() {
        Monom m1=new Monom(2,1);
        Monom m2=new Monom(3,2);
        Monom m3=new Monom(1,2);
        Polynom p1=new Polynom();
        p1.addMonom(m1);
        p1.addMonom(m3);
        Polynom p2=new Polynom();
        p2.addMonom(m2);
        Polynom suma =Operations.adunare(p1,p2);
        assertEquals(suma.getMonoame().get(1).getCoeficient(),2.0);
        assertEquals(suma.getMonoame().get(2).getCoeficient(),4.0);
    }

    public void testMuliply() {
        Monom m1=new Monom(2,1);
        Monom m2=new Monom(3,2);
        Monom m3=new Monom(2,2);
        Polynom p1=new Polynom();
        p1.addMonom(m1);
        p1.addMonom(m3);
        Polynom p2=new Polynom();
        p2.addMonom(m2);
        Polynom suma =Operations.muliply(p1,p2);
        assertEquals(suma.getMonoame().get(3).getCoeficient(),6.0);
        assertEquals(suma.getMonoame().get(4).getCoeficient(),6.0);
    }

    public void testDivie() {
        Monom m1=new Monom(2,1);
        Monom m2=new Monom(3,2);
        Monom m3=new Monom(2,2);
        Polynom p1=new Polynom();
        p1.addMonom(m1);
        p1.addMonom(m3);
        Polynom p2=new Polynom();
        p2.addMonom(m2);
        Polynom []rez;
        rez=Operations.divie(p1,p2);
        assert rez != null;
        assertEquals(rez[0].getMonoame().get(0).getCoeficient(),0.6666666666666666);
        assertEquals(rez[1].getMonoame().get(1).getCoeficient(),2.0);
    }

    public void testDerivative() {
        Monom m1=new Monom(2,1);
        Monom m2=new Monom(3,2);
        Monom m3=new Monom(2,0);
        Polynom p1=new Polynom();
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        Polynom suma =Operations.derivative(p1);
        assertNull(suma.getMonoame().get(2));
        assertEquals(suma.getMonoame().get(1).getCoeficient(),6.0);
        assertEquals(suma.getMonoame().get(0).getCoeficient(),2.0);
    }

    public void testIntegration() {
        Monom m1=new Monom(2,1);
        Monom m2=new Monom(3,2);
        Monom m3=new Monom(2,0);
        Polynom p1=new Polynom();
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        Polynom suma =Operations.integration(p1);
        assertEquals(suma.getMonoame().get(1).getCoeficient(),2.0);
        assertEquals(suma.getMonoame().get(2).getCoeficient(),1.0);
        assertEquals(suma.getMonoame().get(3).getCoeficient(),1.0);
    }
}