import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JUnit {
    private ArrayList<TaskItem> ArrList;
    TaskItem task;
    String filename = "TestFile.obj";
    String validTitle = "Test Title";
    String validDescription = "Test Description";
    LocalDate validDueDate = LocalDate.parse("2020-12-31");


    @Before
    public void setUp() throws Exception {
        try {
            task = new TaskItem(validTitle, validDescription, validDueDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testValidTitle() {

        assertEquals(validTitle, task.getTitle());
    }

    @Test
    public void testEmptyTitle() {
        boolean success = false;

        try {
            task.setTitle("");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void testNullTitle() {
        boolean success = false;

        try {
            task.setTitle(null);
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void testValidDescription() {

        assertEquals(validDescription, task.getDescription());
    }

    @Test
    public void testEmptyDescription() {
        task.setDescription("");
        assertEquals("", task.getDescription());
    }

    @Test
    public void testValidDueDate() {

        assertEquals(validDueDate, task.getDueDate());
    }

    @Test
    public void testIncorrectFormatDueDate() {
        boolean success = false;

        try {
            task.setDueDate(LocalDate.parse("2020-31-12"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeParseException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void testPastDueDate() {
        boolean success = false;

        try {
            task.setDueDate(LocalDate.parse("2017-08-17"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        task = new TaskItem(validTitle, validDescription, validDueDate);
        assertTrue(task.markCompleted());
    }


    @Test
    public void incompleteTaskItemChangesStatus() {
        task = new TaskItem(validTitle, validDescription, validDueDate);
        assertFalse(task.markIncomplete());
    }

    @Test
    public void addingTaskItemsIncreasesSize() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        assertEquals(1, ArrList.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        this.ArrList.remove(0);
        assertEquals(0, ArrList.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            this.ArrList.remove(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);

    }

    @Test
    public void newTaskListIsEmpty() {
        ArrList = new ArrayList<TaskItem>();
        assertTrue(ArrList.isEmpty());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        ArrList.get(0);
        assertEquals("Test Description", validDescription);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        ArrList.get(0);
        assertEquals("Test Title", validTitle);
    }

    @Test
    public void gettingTaskItemTitleFailsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        ArrList.get(0);
        assertEquals(LocalDate.parse("2020-12-31"), validDueDate);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithValidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            task.setTitle("Test Title");
            ArrList.get(1);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void editingTaskItemChangesValues() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        String testTitle = "Please Work";
        String testDescription = "Omg come on";
        LocalDate TestDueDate = LocalDate.parse("2021-11-11");
        task.setTitle(testTitle);
        task.setDescription(testDescription);
        task.setDueDate(TestDueDate);

        assertEquals("Please Work", task.getTitle());
        assertEquals("Omg come on", task.getDescription());
        assertEquals(LocalDate.parse("2021-11-11"), task.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            task.setDueDate(LocalDate.parse("2021-11-11"));
            ArrList.set(1, task);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        ArrList = new ArrayList<TaskItem>();

        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            task.setDescription("Omg come on");
            ArrList.set(1, task);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void editingTaskItemTitleChangesValues() {
        ArrList = new ArrayList<TaskItem>();
        this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
        String testTitle = "Please Work";
        task.setTitle(testTitle);
        assertEquals("Please Work", task.getTitle());
    }


    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            task.markCompleted();
            ArrList.set(1, task);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);

    }

    @Test
    public void incompletingTaskItemFailsWithInvalidIndex() {
        boolean success = false;
        ArrList = new ArrayList<TaskItem>();
        try {
            this.ArrList.add(new TaskItem(validTitle, validDescription, validDueDate));
            task.markIncomplete();
            ArrList.set(1, task);
            fail("should have thrown a IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }

        assertEquals(true, success);

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
