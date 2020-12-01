import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ContactList {
    private ArrayList<ContactItem> ContactList;


    public ContactList() {
        ContactList = new ArrayList<>();
    }


    public boolean addContact() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Please enter the following details to add a Contact:");
            System.out.print("First Name: ");
            String firstName = scan.nextLine();
            if(firstName == ""){
                System.out.println("Your Name must be at least 1 character in length.");
                addContact();
            }

            System.out.print("Last Name: ");
            String lastName = scan.nextLine();

            System.out.print("Phone Number: ");
            String phoneNumber = scan.nextLine();
            if(phoneNumber == ""){
                System.out.println("Your Phone number must be at least 1 character in length.");
                addContact();
            }
            System.out.print("Email Address: ");
            String emailAddress = scan.nextLine();
            if(emailAddress == ""){
                System.out.println("Your Email must be at least 1 character in length.");
                addContact();
            }

            this.ContactList.add(new ContactItem(firstName, lastName, phoneNumber, emailAddress));

            ContactApp.showMessage("Contact has been added.", false);

            return true;
        } catch (Exception e) {
            ContactApp.showMessage(e.getMessage(), true);
            return false;
        }

    }
    public void editTask(String selectedTask) throws NullPointerException {
        try {

            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("You didn't enter a Contact number");
            }

            int taskIndex = Integer.parseInt(selectedTask);
            if (taskIndex < 0 || taskIndex > ContactList.size()) {
                throw new ArrayIndexOutOfBoundsException("Number is not a Contact.");
            }

            ContactItem contact = ContactList.get(taskIndex);

            ContactApp.showMessage("Contact " + selectedTask + "  is selected:" + contact.formattedStringOfTask(), false);

            ContactApp.editTask();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    updateTask(contact);
                    break;
                case "2":
                    ContactList.remove(contact);
                    ContactApp.showMessage("Contact " + selectedTask + " is deleted.", true);
                    break;
                default:
                    ContactApp.showMessage("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            ContactApp.showMessage(e.getMessage(), true);
        }
    }


    public boolean updateTask(ContactItem contact) {
        Scanner scan = new Scanner(System.in);
        boolean isTaskUpdated = false;

        try {
            System.out.println("Please enter the following details to update a task:\n");
            System.out.print("First Name: ");
            String firstName = scan.nextLine();
            if (!(firstName.trim().equals("") || firstName == null)) {
                contact.setFirstName(firstName);
                isTaskUpdated = true;
            }

            System.out.print("First Name: ");
            String lastName = scan.nextLine();
            if (!(lastName.trim().equals("") || lastName == null)) {
                contact.setLastName(lastName);
                isTaskUpdated = true;
            }
            System.out.print("Phone Number: ");
            String phoneNumber = scan.nextLine();
            if (!(phoneNumber.trim().equals("") || phoneNumber == null)) {
                contact.setPhoneNumber(phoneNumber);
                isTaskUpdated = true;
            }

            System.out.print("Email: ");
            String email = scan.nextLine();
            if (!(email.trim().equals("") || email == null)) {
                contact.setEmail(email);
                isTaskUpdated = true;
            }

            ContactApp.showMessage("Contact is " + (isTaskUpdated ? "updated successfully" : "NOT modified") + ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            ContactApp.showMessage(e.getMessage(), true);
            return false;
        }
    }

    public void listAllTasks(String sortBy) {

        System.out.println(
                "Total contacts = " + ContactList.size());

        String displayFormat = "%-20s %-20s %-20s %-20s %-20s";
        if (sortBy.equals("2")) {

            if (ContactList.size() > 0) {
                System.out.println(String.format(displayFormat, "Number",  "Email", "First Name","Last Name", "Phone Number"));
                System.out.println(String.format(displayFormat, "------", "-----",  "----------","---------", "------------"));
            } else {
                System.out.println("No Contacts to show");
            }

            ContactList.stream()
                    .sorted(Comparator.comparing(ContactItem::getPhoneNumber))
                    .forEach(task -> System.out.println(String.format(displayFormat, ContactList.indexOf(task), task.getEmail(), task.getFirstName(),task.getLastName(), task.getPhoneNumber())));
        } else {

            if (ContactList.size() > 0) {
                System.out.println(String.format(displayFormat, "Number", "First Name", "Last Name", "Email",  "Phone Number"));
                System.out.println(String.format(displayFormat, "------", "----------", "---------", "-----",  "------------"));
            } else {
                System.out.println("No Contacts to show");
            }

            ContactList.stream()
                    .sorted(Comparator.comparing(ContactItem::getEmail))
                    .forEach(task -> System.out.println(String.format(displayFormat, ContactList.indexOf(task), task.getFirstName(),task.getLastName(), task.getEmail(),  task.getPhoneNumber())));
        }
    }
    public void listAllTasksWithIndex() {
        String displayFormat = "%-20s %-20s %-20s %-20s %-20s";

        if (ContactList.size() > 0) {
            System.out.println(String.format(displayFormat, "Number",  "Email", "First Name","Last Name", "Phone Number"));
            System.out.println(String.format(displayFormat, "------", "-----",  "----------","---------", "------------"));
        } else {
            System.out.println("No tasks to show");
        }

        ContactList.stream()
                .forEach(task -> System.out.println(String.format(displayFormat, ContactList.indexOf(task), task.getFirstName(),task.getLastName(), task.getEmail(),  task.getPhoneNumber())));
    }





    public boolean readFromFile(String filename) {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                ContactApp.showMessage("The file " + filename + " does not exists", true);
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ContactList = (ArrayList<ContactItem>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            ContactApp.showMessage(e.getMessage(), true);
            return false;
        }
    }

    public boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(ContactList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            ContactApp.showMessage(e.getMessage(), true);
            return false;
        }
    }

    public void NewFileCreate(String newFileName) {

        try {
            File myObj = new File(newFileName);
            myObj.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



