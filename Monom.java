package org.example;

    import java.math.BigDecimal;
    import java.math.RoundingMode;

public class Monom {
  private  double coeficient;
  private int grad;

    public  Monom( double coeficient,int grad)
    {
        this.coeficient=coeficient;
        this.grad=grad;
    }
    public double getCoeficient()
    {
        return this.coeficient;
    }
    public int getGrad()
    {
        return this.grad;
    }
    public void setCoeficient(double coeficient)
    {
        this.coeficient=coeficient;
    }
    public void setGrad(int grad)
    {
        this.grad=grad;
    }

    @Override
    public String toString() {
      this.coeficient=  BigDecimal.valueOf(this.getCoeficient())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        if(this.grad==0)
            if(this.coeficient>0)
                return "+"+this.coeficient;
            else return this.coeficient+"";
        else {
            if(this.coeficient>0)
                return "+"+this.coeficient+"x^"+this.grad;
            else if(this.coeficient==0) return "";
            else return this.coeficient+"x^"+this.grad;
        }

    }


}
