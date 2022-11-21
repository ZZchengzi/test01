package demo7;
import java.util.HashSet;
import java.util.Random;
import java.util.Vector;
public class Exercise {
    HashSet<Equation> equations = new HashSet<>();
    public Exercise(int n)
    {
        Random random = new Random();
        while(equations.size() < n)
        {
            Equation equation;
            short result = 0,a = 0, b = 0;
            char op;//运算符
            do {
                a = (short) random.nextInt(101);
                b = (short) random.nextInt(101);
                op = random.nextBoolean() ?'+':'-';
                if(op == '+')
                {
                    result = (short) (a + b);
                }
                else
                {
                    result = (short) (a - b);
                }
            }while (result < 0 || result > 100);

            if(op == '+') equation = new AddEquation(a,b,op); //new加法等式
            else equation = new SubEquation(a,b,op); //new减法等式
            equation.calculate();
            equations.add(equation);
        }
    }
}
