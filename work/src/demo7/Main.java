package demo7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("请输入习题个数:");
        n = scanner.nextInt();
        EquationRangeChecker checker = new EquationRangeChecker(0, 100);
        //生成等式
        ArrayList<Equation> equations = EquationGenerator.generate(n, checker);
        //打印题目
        Printer.printExercise(equations);
        //打印答案
        Printer.printCalculations(equations);

        //序列化等式列表
        ArrayListSerialized.serialize(equations);

    }
}
