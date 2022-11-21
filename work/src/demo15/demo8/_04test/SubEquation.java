package demo15.demo8._04test;

public class SubEquation extends Equation {

    public SubEquation(SubEquationBuilder subEquationBuilder) {
        super(subEquationBuilder);
    }

    @Override
    public int caculate() {
        return this.getA()-this.getB();
    }

    static class SubEquationBuilder{

        short a;
        short b;
        String operate;
        int result;

        public SubEquationBuilder() {
        }

        public SubEquationBuilder(short a, short b, String operate) {
            this.a = a;
            this.b = b;
            this.operate=operate;
        }

        public SubEquationBuilder result(int result) {
            this.result = result;
            return this;
        }

        public SubEquation build(){
            SubEquation subEquation=new SubEquation(this);
            return subEquation;
        }
    }
}
