package demo15.demo8._04test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class EquationGenerator {

    static ArrayList<Equation> list=null;

    private static EquationGenerator equationGenerator;

    public EquationGenerator() {
    }

    /*
    * 改造成单实例类，线程安全的，单独访问
    * */
    public static synchronized EquationGenerator getEquationGenerator() {
        if (equationGenerator==null){
            equationGenerator=new EquationGenerator();
        }
        return equationGenerator;
    }

    static Random random=new Random();
    void generate(int n, EquationRangeChecker checker){
        HashSet<Equation> hashSet=new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a=0,b=0,result=0;
            boolean flag;
            Equation equation;
            //约束操作数不为负，且不超过100
            while (true) {
                flag=random.nextBoolean();
                //随机加减
                if (flag) {
                    equation=new EquationFactory().getEquation("+");
                } else {
                    equation=new EquationFactory().getEquation("-");
                }
                if (!checker.check(equation)) {
                    //约束结果减法不为负数，且符合要求，随机数大于0小于100
                    continue ;
                }
                break  ;
            }
            hashSet.add(equation);
        }
        list=new ArrayList<>(hashSet);
    }

}
