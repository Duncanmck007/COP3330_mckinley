import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        TaskList TaskList = new TaskList();
        String menuChoice = "0";

            Scanner input = new Scanner(System.in);
            System.out.println("Please choose which application you want to use. 1 for Task List or 2 for Contact List");
            String firstMenuChoice = "0";
            firstMenuChoice = input.nextLine();
            switch (firstMenuChoice) {
                case "1":
                    TaskApp.main();
                    break;
                case "2":
                    ContactApp.main();
                    break;

            }
        }
    }
