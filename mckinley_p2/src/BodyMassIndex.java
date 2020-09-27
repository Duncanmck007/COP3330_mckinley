import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BodyMassIndex
{
    double bmi = 0;
    static String category = null;

    public BodyMassIndex(double height, double weight)
    {
        double inches = height;
        double pounds = weight;
        bmi = (pounds * 703) / Math.pow(inches, 2);
        Categorize(bmi);
    }

    public void Categorize(double bmi)
    {
        if (bmi < 18.50)
        {
            category = "Underweight";
        }
        else if (bmi == 18.5 - 24.9)
        {
            category = "Normal weight";
        }
        else if (bmi == 25 - 29.9)
        {
            category = "Overweight";
        }
        else if (bmi >= 30)
        {
            category = "Obesity";
        }

    }

}
