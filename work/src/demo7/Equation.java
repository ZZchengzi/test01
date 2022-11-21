package demo7;

import java.io.Serializable;
import java.util.Objects;

public abstract class Equation implements Serializable {
    private short operandA;//运算数A
    private short operandB;//运算数B
    private char operator;//运算符

    public Equation() {
    }

    public Equation(short operandA, short operandB, char operator) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.operator = operator;
    }

    //抽象方法 计算算式结果
    public abstract short calculate();

    //覆盖实现equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return operandA == equation.operandA &&
                operandB == equation.operandB &&
                operator == equation.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operandA, operandB, operator);
    }


    @Override
    public String toString() {
        return operandA + " " + operator + " " +
                operandB + " " + "= ";
    }

    public short getoperandA() {
        return operandA;
    }

    public void setoperandA(short operandA) {
        this.operandA = operandA;
    }

    public short getoperandB() {
        return operandB;
    }

    public void setoperandB(short operandB) {
        this.operandB = operandB;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

}
