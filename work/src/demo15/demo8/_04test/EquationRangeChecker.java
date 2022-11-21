package demo15.demo8._04test;

public class EquationRangeChecker implements EquationChecker {

    private int min;
    private int max;

    public EquationRangeChecker() {
    }

    public EquationRangeChecker(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean check(Equation equation) {
        if (equation.getA()>min && equation.getA()<max &&equation.getB()>min &&equation.getB()<max){
            short result;
            if (equation.getOperate().equals("+")){
                result = (short) (equation.getA() + equation.getB());
            }else {
                result=(short) (equation.getA() - equation.getB());
            }
            return result > 0 && result < 100;
        }
       return false;
    }
}