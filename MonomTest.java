package org.example;

import junit.framework.TestCase;

public class MonomTest extends TestCase {

    public void testGetCoeficient() {
        Monom m=new Monom(3,2);
        assertEquals(3.0, m.getCoeficient());
    }

    public void testGetGrad() {
        Monom m=new Monom(3,2);
        assertEquals(2, m.getGrad());
    }

    public void testSetCoeficient() {
        Monom m=new Monom(3,2);
        m.setCoeficient(4);
        assertEquals(4.0, m.getCoeficient());
    }

    public void testSetGrad() {
        Monom m=new Monom(3,2);
        m.setGrad(4);
        assertEquals(4, m.getGrad());
    }


}