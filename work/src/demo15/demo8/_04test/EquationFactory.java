package demo15.demo8._04test;

import java.util.Random;

public class EquationFactory {
    static Random random=new Random();
    public Equation getEquation(String type){
        int a = random.nextInt();
        int b = random.nextInt();
        if ("+".equals(type)){
            return new AddEquation.AddEquationBuilder((short) a,(short) b,"+").result((short)a+(short)b).build();
        }else if ("-".equals(type)) {
            return new SubEquation.SubEquationBuilder((short) a,(short) b,"-").result((short)a-(short)b).build();
        }
        return null;
    }
}
