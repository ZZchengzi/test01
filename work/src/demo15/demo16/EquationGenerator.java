package demo15.demo16;

import java.util.*;

public class EquationGenerator implements Iterator
{
    private int index = -1; //迭代器下标
    public static List<Equation> equations; //存放算式的容器

    public static void generate(int n, EquationRangeChecker checker)
    {
        //使用哈希防止生成重复的等式
        HashSet<Equation> tmp = new HashSet<Equation>();
        Random random = new Random();

        while(tmp.size() < n) //生成n个算式
        {
            Equation equation;

            do {
                if(random.nextBoolean()) //布尔值为1生成加法算式
                {
                    equation = EquationFactory.getEquation("add");
                }
                else                     //为0生成减法算式
                {
                   equation = EquationFactory.getEquation("sub");
                }
            }while (!checker.check(equation)); //约束等式

            tmp.add(equation);
        }
        //用哈希表来生成算式集合
        equations = new ArrayList<>(tmp);
    }

    //实现接口Iterator类中的 hasNext
    public boolean hasNext() {
        if(index >= equations.size() - 1)
        {
            return false;
        }else{
            index += 1;
            return true;
        }
    }

    //实现接口Iterator类中的 next
    public Equation next() {
        return equations.get(index);
    }

}
