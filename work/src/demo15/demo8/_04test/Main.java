package demo15.demo8._04test;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JsonProcessingException {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        EquationGenerator equationGenerator= EquationGenerator.getEquationGenerator();//单实例类
        EquationRangeChecker equationRangeChecker=new EquationRangeChecker(0,100);
        equationGenerator.generate(n, equationRangeChecker);
        //Printer printer=new Printer(generate,n);
        new PutText(EquationGenerator.list,"E:\\JavaWebTest\\test\\src\\test_01\\_04test\\operate.txt");

        //反射机制
        Reflect reflect=new Reflect();
        reflect.reflect("test_01._04test.AddEquation$AddEquationBuilder");

        //转为JOSN文件
        Json json=new Json();
        json.josnReverse(EquationGenerator.list);
    }
}
