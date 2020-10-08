public class Triangle extends Shape2D {
    private final double base;
    private final double height;

    public Triangle(double Base, double Height) {
        base = Base;
        height = Height;
    }

    public double getArea() {
        return ( base * height ) / 2;
    }
    public String getName(){

        return "triangle";
    }
}

