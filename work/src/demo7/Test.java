package demo7;

import java.util.ArrayList;

//测试逆序列化
public class Test {
    public static void main(String[] args) {
        ArrayList<Equation> deserialize = ArrayListSerialized.deserialize();
        Printer.printExercise(deserialize);
        Printer.printCalculations(deserialize);
    }
}
