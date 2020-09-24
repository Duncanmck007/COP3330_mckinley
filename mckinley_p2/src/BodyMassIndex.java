
public class BodyMassIndex
{
    public BodyMassIndex(double height, double weight)
    {
        double inches = height;
        double pounds = weight;
        double bmi = (pounds * 703) / Math.pow(inches, 2);
    }

    public void bmiCategory(double bmi)
    {

        if (bmi < 18.5)
        {

        }
        else if (bmi == 18.5 - 24.9)
        {

        }
        else if (bmi == 25 - 29.9)
        {

        }
        else if (bmi >= 30)
        {

        }

        //arraylist.size
    }
}
