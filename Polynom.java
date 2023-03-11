package org.example;

import java.util.HashMap;
public class Polynom {
   private int nr;
  final  private HashMap<Integer,Monom> monoame;
    public Polynom()
    {
        nr=0;
        monoame=new HashMap<>();
    }
    public void addMonom(Monom m)
    {
        if(this.getMonoame().get(m.getGrad())!=null)
        {
            this.getMonoame().get(m.getGrad()).setCoeficient(m.getCoeficient()+this.getMonoame().get(m.getGrad()).getCoeficient());
        }
        else {
            monoame.put(m.getGrad(), m);
            this.setNr(this.getNr() + 1);
        }
    }
    public HashMap<Integer,Monom> getMonoame()
    {
        return this.monoame;
    }
    public int getMax()
    {
        int max=0;
        for(Monom m:this.monoame.values())
        {
            if(max<m.getGrad()&&m.getCoeficient()!=0) max=m.getGrad();

        }
        return max;
    }
    public String toString()
    {
        String rez="";
        for(Monom m:this.monoame.values())
        {
           rez+=m.toString();
        }
        return rez;
    }
    public void setNr(int nr)
    {
        this.nr=nr;
    }
    public int getNr(){
        return this.nr;
    }
    public void changeSign()
    {
        for(Monom m:this.monoame.values())
        {
            m.setCoeficient(-1*m.getCoeficient());
        }
    }
}
