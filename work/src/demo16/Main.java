package demo16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("请输入习题个数:");
        n = scanner.nextInt();
        //生成约束器
        EquationRangeChecker checker = new EquationRangeChecker(0, 100);
        //生成等式
        EquationGenerator.generate(n,checker);
        //打印题目
        Printer.printExercise(EquationGenerator.equations);
        //打印答案
        Printer.printCalculations(EquationGenerator.equations);

        //序列化等式列表
        ArrayListSerialized.serialize(EquationGenerator.equations);
        //反射
        Reflect.reflect();

        //将习题集合转换成JSON
        ToJson.toJson();
    }
}
