public class Pyramid extends Shape3D {
    private final double length;
    private final double width;
    private final double height;

    public Pyramid(double Length, double Width, double Height) {
        length = Length;
        width = Width;
        height = Height;
    }
    public double getArea(){
        return (length * width) + (length * Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2))) + (width * Math.sqrt(Math.pow(length / 2, 2) + Math.pow(height, 2)));
    }
    public double getVolume() {

        return (length * width * height) / 3;
    }
    public String getName(){

        return "pyramid";
    }
}
