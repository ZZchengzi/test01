package demo15.demo8._04test;

import java.util.ArrayList;

public class Printer {

    public Printer(ArrayList<Equation> arrayList, int n) {
        printHeader();
        printExercise(arrayList,n);
        printCalculations(arrayList,n);
    }

    public Printer() {
    }

    /*
     * 程序运行开始提示
     * */
    public static void printHeader() {
        System.out.println("--------------------------------");
        System.out.println("程序输出10道100以内的加减法算术式");
        System.out.println("每次运行程序可得到一套10道题的习题及答案");
        System.out.println("--------------------------------");
    }

    /*
     * 显示随机算数式
     * */
    public static void printExercise(ArrayList<Equation> arrayList,int n) {
        int i=1;
        for (Equation equation : arrayList) {
            System.out.print(i+":");
            if (equation.getOperate().equals("+")){
                System.out.println(equation.getA()+"+"+equation.getB()+"=");
            }else {
                System.out.println(equation.getA()+"-"+equation.getB()+"=");
            }
            i++;
        }
    }

    /*
     * 打印算式结果
     * */
    public static void printCalculations(ArrayList<Equation> arrayList,  int n) {
        System.out.println("--------------------------------");
        System.out.println("下面是习题答案");
        System.out.println("--------------------------------");
        int i=1;
        for (Equation equation : arrayList) {
            System.out.print(i+":");
            if (equation.getOperate().equals("+")){
                System.out.println(equation.getA()+equation.getB());
            }else {
                System.out.println(equation.getA()-equation.getB());
            }
            i++;
        }

    }
}
