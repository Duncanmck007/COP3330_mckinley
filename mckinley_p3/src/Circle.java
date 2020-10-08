public class Circle extends Shape2D {
    private final double radius;

    public Circle(double Radius) {

        radius = Radius;
    }

    public double getArea() {
        return Math.PI * (radius * radius);
    }
    public String getName(){

        return "circle";
    }
}
