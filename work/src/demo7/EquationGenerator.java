package demo7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class EquationGenerator {
    public static ArrayList<Equation> generate(int n, EquationRangeChecker checker){
        HashSet<Equation> equations = new HashSet<Equation>();
        Random random = new Random();
        while(equations.size() < n)
        {
            Equation equation;
            short a = 0, b = 0;
            char op;//运算符
            do {
                a = (short) random.nextInt();
                b = (short) random.nextInt();
                if(random.nextBoolean())
                {
                    op = '+';
                    equation = new AddEquation(a,b,op);
                }
                else
                {
                    op = '-';
                    equation = new SubEquation(a,b,op);
                }
            }while (!checker.check(equation));
            equation.calculate();
            equations.add(equation);
        }
        return new ArrayList<Equation>(equations);
    }
}
