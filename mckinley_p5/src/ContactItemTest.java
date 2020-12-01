import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ContactItemTest {
    private ArrayList<ContactItem> ArrList;
    ContactItem task;
    String validFirstName = "Test Title";
    String validLastName = "Test Title";
    String validPhoneNumber = "Test Description";
    String validEmail = "Test Email";


    @Before
    public void setUp() throws Exception {
        try {
            task = new ContactItem(validFirstName, validLastName, validPhoneNumber, validEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testValidFirstName() {

        assertEquals(validFirstName, task.getFirstName());
    }

    @Test
    public void testEmptyTitle() {
        boolean success = false;

        try {
            task.setFirstName("");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true, success);
    }
    @Test
    public void testValidLastName() {

        assertEquals(validLastName, task.getLastName());
    }

    @Test
    public void testNullTitle() {
        boolean success = false;

        try {
            task.setFirstName(null);
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void testValidPhoneNumber() {

        assertEquals(validPhoneNumber, task.getPhoneNumber());
    }

    @Test
    public void testEmptyPhoneNumber() {
        task.setPhoneNumber("");
        assertEquals("", task.getPhoneNumber());
    }

    @Test
    public void testValidEmail() {

        assertEquals(validEmail, task.getEmail());
    }



}
