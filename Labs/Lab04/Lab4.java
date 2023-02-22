import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class Lab4 {

    /**
     * Do not change the main method.
     * you can only change the "input.txt" to the location of your input file.
     * Before submitting change it back to "input.txt"
     */
    public static void main(String[] args) {

        Person head = null;
        head = getPersonFromDataFile("input.txt");
        System.out.println("--------------------------------------");
        System.out.println("Printing the Linked List");
        printLL(head);

        Person newPerson = new Person("newPerson_1", 888, 8.8, 8, 8);
        head = addPerson(head, newPerson, 0);
        System.out.println("\n\n--------------------------------------");
        System.out.println("Adding a new person at position 0\n");
        System.out.println("Printing the Linked List\n");
        printLL(head);

        Person newPerson2 = new Person("newPerson_2", 666, 6.6, 6, 6);
        head = addPerson(head, newPerson2, 3);
        System.out.println("\n\n--------------------------------------");
        System.out.println("Adding a new person at position 3\n");
        System.out.println("Printing the Linked List\n");
        printLL(head);

        head = deletePerson(head, 3);
        System.out.println("\n\n--------------------------------------");
        System.out.println("Deleting a person from position 3\n");
        System.out.println("Printing the Linked List\n");
        printLL(head);

        head = deletePerson(head, 0);
        System.out.println("\n\n--------------------------------------");
        System.out.println("Deleting a person from position 0\n");
        System.out.println("Printing the Linked List\n");
        printLL(head);

        System.out.println("\n\n--------------------------------------");
        System.out.println("\nThe person worked most years: ");
        workedMostYears(head);

        System.out.println("\n\n--------------------------------------");
        System.out.println("\nThe person worked least years: ");
        workedLeastYears(head);

        System.out.println("\n\n--------------------------------------");
        System.out.println("\nAverage hours worked in the last week: ");
        averageHoursWorked(head);

        System.out.println("\n\n--------------------------------------");
        System.out.println("\nTotal payment amount for each person based on hoursWorked and hourlyWage: ");
        totalPaymentToEachPerson(head);

        // Extra Credit
        System.out.println("\n\n--------------------------------------");
        Person newPerson3 = new Person("newPerson_3", 102, 8.8, 8, 8);
        head = addPersonByCheckingId(head, newPerson3, 4);
        System.out.println("Printing the Linked List\n");
        printLL(head);

        System.out.println("\n\n--------------------------------------");
        Person newPerson4 = new Person("newPerson_4", 103, 8.8, 8, 8);
        head = addPersonByCheckingId(head, newPerson4, 4);
        System.out.println("Printing the Linked List\n");
        printLL(head);

    }

    /**
     * Complete this method to print the Person Linkedlist
     * given the head of the Person LinkedList
     * 
     * @param head of the Person LinkedList
     */
    public static void printLL(Person head) {
        // You are not allowed to change the header.
        // Change the body of this method.
        System.out.println("I have not yet implemented the printLL method.");
    }

    /**
     * Change the body of this method to add a person to the linkedlist
     * 
     * @param head
     * @param newPerson
     * @param position
     * @return head of the linked list which is a object of Person class
     */
    public static Person addPerson(Person head, Person toAdd, int position) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the addPerson method.");
        return null;
    }

    /**
     * Change the body of this method to delete a person from the linkedlist
     * 
     * @param head
     * @param position
     * @return head
     */
    public static Person deletePerson(Person head, int position) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the deletePerson method.");
        return null;
    }

    /**
     * Change the body of this method to find out who worked most years from the
     * linkedlist
     * 
     * @param head
     */
    public static void workedMostYears(Person head) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the workedMostYears method.");
    }

    /**
     * Change the body of this method to find out who worked least years from the
     * linkedlist
     * 
     * @param head
     */
    public static void workedLeastYears(Person head) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the workedLeastYears method.");
    }

    /**
     * Change the body of this method to find out the average hours all employees
     * worked from the linkedlist
     * 
     * @param head
     */
    public static void averageHoursWorked(Person head) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the averageHoursWorked method.");
    }

    /**
     * Change the body of this method to find the total payment each person gets
     * from the linkedlist.
     * If a person worked<= 40 hours then he/she will get the hourlyWage for the
     * hours worked.
     * If a person worked > 40 hours then he/she will get double the hourlyWage for
     * the overtime.
     * 
     * @param head
     */
    public static void totalPaymentToEachPerson(Person head) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the totalPaymentToEachPerson method.");
    }

    /**
     * Change the body of this method to add person by checking id if aleady present
     * in the linkedlist
     * 
     * @param head
     * @param newPerson
     * @param position
     * @return head
     */
    // Extra Credit
    public static Person addPersonByCheckingId(Person head, Person newPerson, int position) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the addPersonByCheckingId method.");
        return null;
    }

    /**
     * Change the body of this method to add persons from the data file to a
     * linkedlist
     * Change the body of this method to return
     * the head of linkedlist of Person, created after reading the file.
     * 
     * @param filename
     * @return head of the created Linked List
     */
    static Person getPersonFromDataFile(String fileName) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the getPersonFromDataFile method.");
        return null;
    }

}