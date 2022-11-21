package demo10;

public class MyCircle implements Shape {
    private double radius;

    public MyCircle(double r) {
        this.radius = r;
    }

    public double getPerimeter() {
        return radius * Math.PI * 2;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return  "radius=" + radius +
                ",perimeter=" + getPerimeter() +
                ",area=" + getArea()
                ;
    }
}
