package demo15.demo16;

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

    //实现equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return operandA == equation.operandA &&
                operandB == equation.operandB &&
                operator == equation.operator;
    }

    public int hashCode() {
        return Objects.hash(operandA, operandB, operator);
    }


    public String toString() {
        return operandA + " " + operator + " " +
                operandB + " " + "= ";
    }

    public short getOperandA() {
        return operandA;
    }

    public void setOperandA(short operandA) {
        this.operandA = operandA;
    }

    public short getOperandB() {
        return operandB;
    }

    public void setOperandB(short operandB) {
        this.operandB = operandB;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
