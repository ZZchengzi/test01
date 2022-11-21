package demo15.demo8._04test;

/*
* 算式类
* */
abstract class Equation {

    private final short a;//required
    private final short b;//required
    private final String operate;//required
    private final int result;//optional

    public Equation(AddEquation.AddEquationBuilder addEquationBuilder) {
        this.a = addEquationBuilder.a;
        this.b = addEquationBuilder.b;
        this.operate = addEquationBuilder.operate;
        this.result=addEquationBuilder.result;
    }

    public Equation(SubEquation.SubEquationBuilder subEquationBuilder) {
        this.a = subEquationBuilder.a;
        this.b = subEquationBuilder.b;
        this.operate = subEquationBuilder.operate;
        this.result=subEquationBuilder.result;
    }
    public short getA() {
        return a;
    }

    public short getB() {
        return b;
    }

    public String getOperate() {
        return operate;
    }

    public int getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return a == equation.a && b == equation.b && operate == equation.operate;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "a=" + a +
                ", b=" + b +
                ", operate=" + operate +
                ", result=" + result +
                '}';
    }

    abstract public int caculate();
}
