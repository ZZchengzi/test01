package demo15.demo16;

import java.util.Iterator;
import java.util.List;

public class Printer {
    //打印习题
    public static void printExercise(List<Equation> equations)
    {
        Iterator it = equations.iterator(); //获取equations的迭代器
        int cnt = 1;                        //记录题号

        while (it.hasNext())                //通过迭代器迭代输出等式
        {
            System.out.print(cnt++  + ":" + it.next() + "\t");
        }
    }

    //打印答案
    public static void printCalculations(List<Equation> equations){
        System.out.println("\n--------------------------------");
        System.out.println("下面是习题答案");

        Iterator it = equations.iterator();//获取equations的迭代器
        int cnt = 1;                       //记录题号
        while (it.hasNext())               //通过迭代器迭代输出答案
        {
            //获取当前等式
            Equation tmp = (Equation) it.next();

            System.out.print(cnt++  + ":" + tmp.calculate() + "\t");
        }
    }
}
