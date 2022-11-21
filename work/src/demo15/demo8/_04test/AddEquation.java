package demo15.demo8._04test;

public class AddEquation extends Equation {

    public AddEquation(AddEquationBuilder addEquation) {
        super(addEquation);
    }

    @Override
    public int caculate() {
        return this.getA()+this.getB();
    }

    static class AddEquationBuilder{

        short a;
        short b;
        String operate;
        int result;

        public AddEquationBuilder(short a, short b,String operate) {
            this.a = a;
            this.b = b;
            this.operate=operate;
        }

        public AddEquationBuilder() {
        }

        public AddEquationBuilder result(int result) {
            this.result = result;
            return this;
        }

        public AddEquation build(){
            AddEquation addEquation=new AddEquation(this);
            return addEquation;
        }
    }
}
