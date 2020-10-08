public class Square extends Shape2D{
    private final double side;

    public Square(double Side) {

        side = Side;
    }

    public double getArea(){

        return side * side;
    }

    public String getName(){

        return "square";
    }
}

