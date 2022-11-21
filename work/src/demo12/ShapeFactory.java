package demo12;

public class ShapeFactory {
    public static Shape createShape(char type){
        if(type == 'r') return new Rectangle();
        if(type == 'c') return new Circle();
        if(type == 'e') return new Ellipse();
        return null;
    }
}
