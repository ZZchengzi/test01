package demo5;

import java.util.Random;
import java.util.Vector;

public class demo1 {
    public static void main(String[] args) {
        Vector s = new Vector();
        printHeader();
        generateEquations(s);
        printExercise(s);
        printCalculations(s);

    }
    /*
        程序功能提示
    */
    public static void printHeader(){
        System.out.println("--------------------------------");
        System.out.println("程序输出10道100以内的加减法算术式");
        System.out.println("每次运行程序可得到一套10道题的习题及答案");
        System.out.println("--------------------------------");
    }
    /*
    产生10个算术式
    */
    public static void generateEquations(Vector s){
        Random r = new Random();
        for(int i = 0; i < 10; i ++)
        {
            //约束操作数不为负
            int result = 0, a = 0, b = 0, op = 0;
            do{
                a = r.nextInt(101);
                b = r.nextInt(101);
                op = r.nextInt(2);
                if(op == 1)
                {
                    result = a + b;
                }
                else
                {
                    result = a - b;
                }
                //约束减法结果不能为负，约束加法结果不超过100。
            }while (result < 0 || result > 100);
            s.add(a);
            s.add(op);
            s.add(b);
        }
    }
    /*
    显示该批算数式
    */
    public static void printExercise(Vector s){
        for(int i = 0; i < 10; i ++) {

            int a = (int)s.firstElement();
            s.remove(0);
            int o = (int)s.firstElement();
            s.remove(0);
            int b = (int)s.firstElement();
            s.remove(0);
            if(o == 1) s.add(a + b);
            else s.add(a - b);
            System.out.print((i + 1) + ":\t");
            System.out.println(a + " " + (o == 1 ? "+":"-") + " " + b + " " + "=");
        }
    }
    /*
    显示该批算术式结果
    */
    public static void printCalculations(Vector s){
        System.out.println("--------------------------------");
        System.out.println("下面是习题答案");
        for(int i = 0; i < 10; i ++)
        {
            System.out.print((i + 1) + ":\t");
            System.out.println(s.firstElement());
            s.remove(0);
        }
    }
}
