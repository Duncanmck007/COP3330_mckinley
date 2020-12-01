import java.util.Scanner;


public class ContactApp {

    public static String filename = "";
    public static void main() {
        ContactList ContactList = new ContactList();
        String menuChoice = "0";

        try {

            Scanner input = new Scanner(System.in);
            firstMenu();
            String firstMenuChoice= "0";
            firstMenuChoice = input.nextLine();
            switch(firstMenuChoice)
            {
                case "1":
                    System.out.println("What would you like your new File to be called? (.obj Files Only)");
                    String newFileName = input.nextLine();
                    ContactList.NewFileCreate(newFileName);
                    filename = newFileName;

                    break;
                case "2":
                    System.out.println("Please enter the name of the file (.obj Files Only)");
                    String previousFileName = input.nextLine();
                    ContactList.readFromFile(previousFileName);
                    filename = previousFileName;
            }


            showMessage("Welcome to Contact List", false);

            while (!menuChoice.equals("4")) {
                mainMenu();
                menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        TasksMenu();
                        ContactList.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        ContactList.addContact();
                        break;
                    case "3":
                        ContactList.listAllTasksWithIndex();
                        editTaskSelection();
                        ContactList.editTask(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        unknownMessage();
                }
            }

            ContactList.saveToFile(filename);
            bye();

        } catch (Exception e) {
            showMessage("Uncaught Exception", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            ContactList.saveToFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }




    public static void firstMenu(){
        System.out.println("Please use 1/2 to select an option:");
        System.out.println("(1) Create a new list");
        System.out.println("(2) Load an existing list\n");

    }

    public static void mainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("Please select an option:");
        System.out.println("(1) Show Contact List");
        System.out.println("(2) Add New Contact");
        System.out.println("(3) Edit Contact (update or remove)");
        System.out.println("(4) Save and Quit\n");
        System.out.print("Please enter your choice [1-4]: ");
    }

    public static void TasksMenu() {
        System.out.println("\nDisplay All Contact");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Contact List by Name");
        System.out.println("(2) Show Contact List by Email");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }


    public static void editTaskSelection() {
        System.out.print("Contact number - Enter: ");
    }

    public static void editTask() {
        System.out.println("\nContact Edit Options");
        System.out.println("Pick an option:");
        System.out.println("(1) Modify selected Contact");
        System.out.println("(2) Delete selected Contact");
        System.out.println("(3) Return to main menu");
        System.out.print("\nPlease enter your choice [1-3]: ");
    }

    public static void bye() {
        System.out.println("All Contacts are saved to data file");
        System.out.println("Thank you for using my Contact Manager");

    }

    public static void unknownMessage() {

        System.out.println("Please make a valid choice. ");

    }

    public static void showMessage(String message, boolean warning) {

        System.out.println(message);

    }
}