package demo15.demo16;

public class EquationRangeChecker implements EquationChecker {
    private int min; //约束的最小值
    private int max; //约束的最大值

    public EquationRangeChecker(int min, int max)
    {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean check(Equation equation) {

        //判断操作数A,B是否满足约束
        if (equation.getOperandA() > max || equation.getOperandA() < min || equation.getOperandB() > max || equation.getOperandB() < min)
        {
            return false;
        }
        //判断等式结果是否满足约束
        int result = equation.calculate();
        if(result > max || result < min) return false;

        return true;
    }
}
