package demo15.demo16;

import java.util.Random;

public class EquationFactory
{
    public static Equation getEquation(String type){

        Random random = new Random();
        short a = (short) random.nextInt();
        short b = (short) random.nextInt();

        if("sub".equals(type))
        {
            //用内部类生成加法等式
            return new SubEquation.SubEquationBuilder().operand(a,b,'-').build();
        }
        else
        {
            //生成减法等式
            return new AddEquation.AddEquationBuilder().operand(a,b,'+').build();
        }
    }
}
