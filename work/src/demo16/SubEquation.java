package demo16;

public class SubEquation extends Equation {

    private SubEquation(SubEquationBuilder builder)
    {
        super(builder.operandA, builder.operandB, '-');
    }

    public short calculate() {
        return (short) (getOperandA() - getOperandB());
    }

    //内部类
    public static class SubEquationBuilder
    {
        private short operandA;         //运算数A
        private short operandB;         //运算数B
        private char operator;          //运算符

        public SubEquationBuilder () {  //无参构造器

        }

        public SubEquationBuilder operand(short operandA,short operandB, char operator){
            this.operandA = operandA;
            this.operandB = operandB;
            this.operator = operator;
            return this;
        }

        //返回最终构造的 SubEquation 对象
        public SubEquation build(){
            return new SubEquation(this);
        }
    }
}
