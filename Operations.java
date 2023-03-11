package org.example;

public class Operations  {
    public  static Polynom adunare(Polynom p1, Polynom p2)
        {
        Polynom suma=p1;
        for(Monom m: p2.getMonoame().values())
        {

            if(suma.getMonoame().get(m.getGrad())==null)
            {
                suma.getMonoame().put(m.getGrad(),m); suma.setNr(suma.getNr()+1);
            }
            else
            {
                Monom nou=new Monom(m.getCoeficient()+suma.getMonoame().get(m.getGrad()).getCoeficient(),m.getGrad());
                suma.getMonoame().put(m.getGrad(),nou);
            }
        }
        System.out.println(suma);
        return suma;
    }
    public static  Polynom muliply(Polynom p1, Polynom p2)
    {
        Polynom produs=new Polynom();
        Polynom aux=new Polynom();
        Monom e=new Monom(1,1);
        for (Monom m: p1.getMonoame().values()
        ) {

            for (Monom m2: p2.getMonoame().values()
            ) {
                ;
                e = new Monom(m.getCoeficient() * m2.getCoeficient(), m.getGrad() + m2.getGrad());
                aux.getMonoame().put(m.getGrad() + m2.getGrad(), e);

            }

            produs=Operations.adunare(produs,aux);

            aux.getMonoame().clear();
        }
        return produs;
    }
    public static Polynom[] divie(Polynom p1,Polynom p2)
    {
        Polynom[] catRest=new Polynom[2];
        try {
            int grad = 0;
            double coef;
            Polynom cat = new Polynom();
            Polynom deim = p1;
            Polynom rest = new Polynom();
            while (deim.getMax() - p2.getMax() >= 0 && deim.getMonoame().get(deim.getMax()) != null && deim.getMonoame().get(deim.getMax()).getCoeficient() != 0) {
                Polynom cimp = p2;
                    grad = deim.getMax() - cimp.getMax();
                if (deim.getMonoame().get(deim.getMax()).getCoeficient() != cimp.getMonoame().get(cimp.getMax()).getCoeficient())
                    coef = deim.getMonoame().get(deim.getMax()).getCoeficient() / cimp.getMonoame().get(cimp.getMax()).getCoeficient();
                else
                    coef = 1;
                Monom nou = new Monom(coef, grad);
                Polynom paux = new Polynom();
                paux.addMonom(nou);
                cat.addMonom(nou);
                cimp = Operations.muliply(cimp,paux);
                if (deim.getMonoame().get(deim.getMax()).getCoeficient() / cimp.getMonoame().get(cimp.getMax()).getCoeficient() < 0)
                    break;
                if (deim.getMonoame().get(deim.getMax()).getCoeficient() < 0 &&
                        cimp.getMonoame().get(cimp.getMax()).getCoeficient() < 0 || deim.getMonoame().get(deim.getMax()).getCoeficient() > 0 && cimp.getMonoame().get(cimp.getMax()).getCoeficient() > 0)
                    cimp.changeSign();
                deim = Operations.adunare(deim,cimp);
                rest = deim;
            }
             catRest[0]=cat;
             catRest[1]=rest;
             return catRest;

        }
        catch (Exception e){return null;}
    }
    public static Polynom derivative(Polynom p)
    {
        Polynom rez=new Polynom();
        Monom zero=new Monom(0,1);
        if (p.getMax()==0) {
            return  null;
        }
        for(Monom m:p.getMonoame().values())
        {
            if(m.getGrad()!=0) {
                m.setCoeficient(m.getCoeficient() * m.getGrad());
                m.setGrad(m.getGrad() - 1);
                rez.addMonom(m);
            }


        }
        return rez;
    }
    public static Polynom integration(Polynom p)
    {
        Polynom rez=new Polynom();
        for(Monom m:p.getMonoame().values())
        {

            m.setCoeficient(m.getCoeficient() /( m.getGrad()+1));
            m.setGrad(m.getGrad() + 1);
           rez.addMonom(m);
            System.out.println(m);
        }
        return rez;
    }
}
