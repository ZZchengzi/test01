package demo7;
import java.util.ArrayList;
import java.util.HashSet;
public class Printer {
    //打印习题
    public static void printExercise(ArrayList<Equation> equations){
        int cnt = 1;
        for (Equation item: equations) {
            System.out.print(cnt + ":" + item + "\t");
            cnt++;
        }
    }
    //打印答案
    public static void printCalculations(ArrayList<Equation> ans){
        System.out.println("\n--------------------------------");
        System.out.println("下面是习题答案");
        int cnt = 1;
        for (Equation i: ans){
            System.out.print(cnt + ":" + i.calculate() + "\t");
            cnt++;
        }
    }
}
