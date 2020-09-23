import java.util.ArrayList;
import java.util.Scanner;


public class App
{
    private static double getUserHeight()
    {
        double height;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in inches: ");

        // User input
        height = Double.parseDouble(input.nextLine());

        // Closes the scanner
        input.close();
        return height;
    }

    private static double getUserWeight()
    {
        double weight;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in pounds: ");

        // User input
        weight = Double.parseDouble(input.nextLine());

        // Closes the scanner
        input.close();
        return weight;
    }
    //private static double displayBmiInfo()
    //{

   // return;
    //}

    
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            //BodyMassIndex bmi = new BodyMassIndex(height, weight);
            //bmiData.add(bmi);

            //displayBmiInfo(bmi);
        }

       //displayBmiStatistics(bmiData);
    }

    private static boolean moreInput()
    {
        return true;
    }


}
