
public class BodyMassIndex
{
    double bmi= 0;
    String category = null;

    public BodyMassIndex(double height, double weight)
    {
        double inches = height;
        double pounds = weight;
        bmiMath(inches, pounds);
        Categorize(bmi);
    }
    public double bmiMath(double inches, double pounds)
    {
        bmi= (pounds * 703) / Math.pow(inches, 2);
        bmi = Math.round(bmi * 100.0) / 100.0;
        return bmi;
    }

    public String Categorize(double bmi)
    {
        if (bmi < 18.50)
        {
            category = "Underweight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9)
        {
            category = "Normal weight";
        }
        else if (bmi >= 25 && bmi <= 29.9)
        {
            category = "Overweight";
        }
        else if (bmi >= 30)
        {
            category = "Obesity";
        }
      return category;
    }

}
