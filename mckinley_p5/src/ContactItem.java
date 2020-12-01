import java.io.Serializable;

public class ContactItem implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean complete;
    private String email;


    public ContactItem( String firstName, String lastName,String phoneNumber, String email) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.complete = false;
        this.setEmail(email);
    }



    public String getFirstName() {

        return this.firstName;
    }
    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName){

        this.lastName = lastName.trim();

    }

    public void setFirstName(String firstName) throws NullPointerException {
        if (firstName.trim().equals("") || firstName == null) {
            throw new NullPointerException("Title needs to be at least one Character");
        }
        this.firstName = firstName.trim();
    }

    public String getPhoneNumber() {

        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber.trim();
    }


    public String getEmail() {

        return email;
    }

    public void setEmail(String email)  {

        this.email = email.trim();
    }

    public String formattedStringOfTask() {
        return (
                "\nFirst Name    : " + firstName + "\nLast Name    : " + lastName + "\nPhone Number   : " + phoneNumber + "\nEmail Address  : " + email + "\n");
    }

}
