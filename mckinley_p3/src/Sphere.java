public class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double Radius) {
        radius = Radius;
    }
    public double getArea(){

        return (radius * radius)* (4 * Math.PI);
    }
    public double getVolume() {

        return Math.PI * (radius * radius * radius)* 4/3;
    }
    public String getName(){

        return "sphere";
    }
}
