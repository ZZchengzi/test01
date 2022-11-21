package demo7;

public class EquationRangeChecker implements EquationChecker {
    private int min;
    private int max;

    public EquationRangeChecker(int min, int max){
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean check(Equation equation) {
        //判断操作数A,B是否满足约束
        if (equation.getoperandA() > max || equation.getoperandA() < min || equation.getoperandB() > max || equation.getoperandB() < min)
        {
            return false;
        }
        //判断等式结果是否满足约束
        int result = equation.calculate();
        if(result > max || result < min) return false;
        return true;
    }
}
