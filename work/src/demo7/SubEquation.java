package demo7;

public class SubEquation extends Equation {

    public SubEquation() {
    }

    public SubEquation(short operandA, short operandB, char operator) {
        super(operandA, operandB, operator);
    }

    @Override
    public short calculate() {
        return (short) (getoperandA() - getoperandB());
    }

}
