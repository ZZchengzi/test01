package demo15.demo16;

import java.util.List;

//逆序列化测试类
public class Test {
    public static void main(String[] args)
    {
        //获取文件中的等式
        List<Equation> deserialize = ArrayListSerialized.deserialize();
        //打印等式
        Printer.printExercise(deserialize);
        //打印答案
        Printer.printCalculations(deserialize);
    }
}
