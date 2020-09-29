import java.util.ArrayList;
import java.util.Scanner;

public class App  {

    private static double getUserHeight() {
        double height;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your height in inches: ");

            height = Double.parseDouble(input.nextLine());

            if (height <= 0) {
                System.out.print("Please enter a positive number!\n ");
            } else
                return height;
        }


    }

    private static double getUserWeight() {
        double weight;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your weight in pounds: ");

            weight = Double.parseDouble(input.nextLine());

            if (weight <= 0) {
                System.out.print("Please enter a positive number!\n ");
            } else
                return weight;
        }
    }

    private static boolean moreInput() {
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("Do you have any more information to enter? y/n");

        while (true) {
            answer = input.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                return true;
            }
            else if (answer.equals("n")) {
                return false;
            }
            else {
                System.out.println("Please enter in this format: y/n");
            }
        }
    }

    private static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.println("Your bmi is: ");
        System.out.println(bmi.bmi);
        System.out.println("Your category is: ");
        System.out.println(bmi.category);

    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        double sum = 0;
        double size = bmiData.size();

        for (int i = 0; i < bmiData.size(); i++)
        {
            sum += bmiData.get(i).bmi;
        }

        double avg = sum / size;
        System.out.printf("The average of your bmi scores is: %.2f",avg);

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