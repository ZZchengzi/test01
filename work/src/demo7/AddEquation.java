package demo7;

public class AddEquation extends Equation {

    public AddEquation() {
    }

    public AddEquation(short operandA, short operandB, char operator) {
        super(operandA, operandB, operator);
    }

    @Override
    public short calculate() {
        return (short) (getoperandA() + getoperandB());
    }
}
