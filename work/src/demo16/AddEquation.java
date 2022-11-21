package demo16;

public class AddEquation extends Equation {


    private AddEquation(AddEquationBuilder builder)
    {
        super(builder.operandA, builder.operandB, builder.operator);
    }


    public short calculate() {
        return (short) (getOperandA() + getOperandB());
    }

    //创建内部类
    public static class AddEquationBuilder
    {
        private short operandA;       //运算数A
        private short operandB;       //运算数B
        private char operator;        //运算符

        public AddEquationBuilder(){} //无参构造器

        public AddEquationBuilder operand(short operandA, short operandB, char operator){
            this.operandA = operandA;
            this.operandB = operandB;
            this.operator = operator;
            return this;
        }

        //返回最终构造的 AddEquation 对象
        public AddEquation build(){
            return new AddEquation(this);
        }
    }
}
