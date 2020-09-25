import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    private static double getUserHeight()
    {
        boolean badInput =  true;
        double height;
        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.print("Enter your height in inches: ");
            height = Double.parseDouble(input.nextLine());
            if(height <= 0)
            {
                System.out.print("Please enter a positive number!\n ");
            }
            else
            return height;
        }


    }

    private static double getUserWeight()
    {
        double weight;
        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.print("Enter your weight in pounds: ");
            weight = Double.parseDouble(input.nextLine());
            if(weight <= 0)
            {
                System.out.print("Please enter a positive number!\n ");
            }
            else
                return weight;
        }
    }

    private static boolean moreInput()
    {
        Scanner input = new Scanner(System.in);
        String answer;
        boolean userChoice;

        System.out.println("Do you have any more information to enter? y/n");

        while (true)
        {
            answer = input.nextLine().trim().toLowerCase();
            if (answer.equals("y"))
            {
                userChoice = true;
                return true;
            }

            else if (answer.equals("n"))
            {
                userChoice = false;
                return false;
            }

            else
            {
                System.out.println("Please enter in this format: y/n");
            }
        }
    }
    private static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.println(bmi.bmi);
        System.out.println(bmi.category);
    }

    private static void displayBmiStatistics(ArrayList bmiData)
    {
        double placeholder = 0;
        double size = 0;
        double sum = 0;
        double avg = 0;
        size = bmiData.size();

        for(int i = 0; i < bmiData.size(); i++)
        {
            placeholder = (double) bmiData.get(i);
            sum += placeholder;
        }

       avg = sum/size;

        System.out.printf("The average of your bmi scores is: %f", avg);
    }



    public static void main(String[] args)
    {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

       displayBmiStatistics(bmiData);
    }


}