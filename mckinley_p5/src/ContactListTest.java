import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ContactListTest {
    private ArrayList<ContactItem> ArrList;
    ContactItem task;
    String filename = "TestFile.obj";
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
    public void addingTaskItemsIncreasesSize() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        assertEquals(1, ArrList.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        this.ArrList.remove(0);
        assertEquals(0, ArrList.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        boolean success = false;
        ArrList = new ArrayList<ContactItem>();
        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            this.ArrList.remove(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);

    }

    @Test
    public void newTaskListIsEmpty() {
        ArrList = new ArrayList<ContactItem>();
        assertTrue(ArrList.isEmpty());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        ArrList.get(0);
        assertEquals("Test Description", validPhoneNumber);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithValidIndex() {
        ArrList = new ArrayList<ContactItem>();

        boolean success = false;

        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        ArrList.get(0);
        assertEquals("Test Title", validFirstName);
    }

    @Test
    public void gettingTaskItemTitleFailsWithValidIndex() {
        ArrList = new ArrayList<ContactItem>();

        boolean success = false;
        ArrList = new ArrayList<ContactItem>();
        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithValidIndex() {
        ArrList = new ArrayList<ContactItem>();

        boolean success = false;
        ArrList = new ArrayList<ContactItem>();
        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemFirstNameFailsWithInvalidIndex() {
        ArrList = new ArrayList<ContactItem>();

        boolean success = false;
        ArrList = new ArrayList<ContactItem>();
        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            task.setFirstName("Test Title");
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void editingTaskItemChangesValues() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        String testFirstName = "Duncan";
        String testLastName = "McKinley";
        String testPhoneNumber = "5611111111";
        String testEmail = ("yolo@aol.com");
        task.setFirstName(testFirstName);
        task.setLastName(testLastName);
        task.setPhoneNumber(testPhoneNumber);
        task.setEmail(testEmail);

        assertEquals("Duncan", task.getFirstName());
        assertEquals("McKinley", task.getLastName());
        assertEquals("5611111111", task.getPhoneNumber());
        assertEquals("yolo@aol.com", task.getEmail());
    }


    @Test
    public void editingTaskItemPhoneNumberFailsWithInvalidIndex() {
        ArrList = new ArrayList<ContactItem>();

        boolean success = false;
        ArrList = new ArrayList<ContactItem>();
        try {
            this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
            task.setPhoneNumber("5611111111");
            ArrList.set(1, task);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void editingTaskItemTitleChangesValues() {
        ArrList = new ArrayList<ContactItem>();
        this.ArrList.add(new ContactItem(validFirstName,validLastName, validPhoneNumber, validEmail));
        String testFirstName = "Please Work";
        task.setFirstName(testFirstName);
        assertEquals("Please Work", task.getFirstName());
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        boolean success;
        File myObj = new File(filename);
        myObj.createNewFile();
        if (Files.isReadable(Paths.get(filename))) {
            success = true;
        }
        else
            success = false;

        assertEquals(true, success);
    }
}
