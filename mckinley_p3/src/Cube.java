public class Cube extends Shape3D {
    private final double side;

    public Cube(double Side) {

        side = Side;
    }
    public double getArea(){

        return (side * side) * 6;
    }
    public double getVolume() {
        return side * side * side;
    }
    public String getName(){

        return "cube";
    }
}
