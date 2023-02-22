
/* 
* -----------------------------------------------------------------------------------------------------------------------------
* Lab 04 - CS2401 - jaroblestos@miners.utep.edu
* -----------------------------------------------------------------------------------------------------------------------------
* Input file "input_2.txt" -> 'n' rows (farms) by 12 columns of integer values 
* -----------------------------------------------------------------------------------------------------------------------------
* - Read file
* - Create objects
* - Create LL with objects
* - Prinnt information
* -----------------------------------------------------------------------------------------------------------------------------
* 2. Methods
* -- public static void printLL(Person head)
* -- public static Person addPerson(Person head, Person toAdd, int position)
* -- public static Person deletePerson(Person head, int position) 
* -- public static void workedMostYears(Person head) -> print person who worked most years
* -- public static void workedLeastYears(Person head) -> print the least years
* -- public static void averageHoursWorked(Person head) -> print avg. hours of all
* -- public static void totalPaymentToEachPerson(Person head) -> total payment <= 40 wage, extra is double
* -- public static Person addPersonByCheckingId(Person head, Person newPerson, int position) 
* -- public static Person getPersonFromDataFile(String fileName) -> add person from data file to a LL
* -----------------------------------------------------------------------------------------------------------------------------
* 
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class Lab4_RoblesTostado_JoseA {
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

    public static void printLL(Person head) {
        while (head != null) {
            System.out.println("Name: " + head.getName());
            System.out.println("ID: " + head.getId());
            System.out.println("Hours worked: " + head.hoursWorked);
            System.out.println("Hourly wage: " + head.hourlyWage);
            System.out.println("Years worked: " + head.years);
            System.out.println();
            head = head.next;

        }
    }

    public static Person getPersonFromDataFile(String FILELOC) {

        File inputFile;
        Scanner scn;
        Person head = null;
        Person curr = null;
        boolean exists = false;
        try {
            inputFile = new File(FILELOC);
            scn = new Scanner(inputFile);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                String input_arr[] = line.split("\t");
                if (!exists) {
                    exists = true;
                    head = new Person();
                    head.setName(input_arr[0]);
                    head.setId(Integer.parseInt(input_arr[1]));
                    head.hoursWorked = Double.parseDouble(input_arr[2]);
                    head.hourlyWage = Double.parseDouble(input_arr[3]);
                    head.years = Integer.parseInt(input_arr[4]);
                    curr = head;
                } else {
                    curr.next = new Person();
                    curr = curr.next;
                    curr.setName(input_arr[0]);
                    curr.setId(Integer.parseInt(input_arr[1]));
                    curr.hoursWorked = Double.parseDouble(input_arr[2]);
                    curr.hourlyWage = Double.parseDouble(input_arr[3]);
                    curr.years = Integer.parseInt(input_arr[4]);
                    ;
                }
                if (scn.hasNextLine()) {
                    scn.nextLine();
                }

            }
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("<getPersonFromDataFile - Error: " + e + ">");
            return null;
        }
        return head;

    }

    public static Person addPerson(Person head, Person toAdd, int position) {
        if (position < 0) {
            System.out.println("Cannot have a negative position. Returning null.");
            return head;
        } else if (position == 0) {
            toAdd.next = head;
            return toAdd;
        } else {

            Person curr = head;
            int person_count = 0;
            while (curr.next != null && person_count < (position - 1)) {
                person_count++;
                curr = curr.next;
            }

            if (person_count != (position - 1)) {
                System.out.println("Position out of bounds. Adding at the end.");
                curr.next = toAdd;
            } else {
                Person tmp = curr.next;
                curr.next = toAdd;
                curr.next.next = tmp;
            }

            return head;
        }
    }

    public static Person deletePerson(Person head, int position) {
        if (position < 0) {
            System.out.println("Cannot have a negative position. Returning null.");
            return head;
        } else if (position == 0) {
            head = head.next;
            return head;
        } else {
            Person curr = head;
            int person_count = 0;
            while (curr.next != null && person_count < (position - 1)) {
                person_count++;
                curr = curr.next;
            }
            if (person_count != (position - 1)) {
                System.out.println("Position out of bounds. Could not delete.");
                return head;
            } else {
                curr.next = curr.next.next;
                return head;
            }

        }

    }

    public static void workedMostYears(Person head) {
        String name = head.getName();
        int max_years = head.years;
        head = head.next;

        while (head != null) {
            if (head.years > max_years) {
                name = head.getName();
                max_years = head.years;
            }
            head = head.next;
        }
        System.out.println("Name: " + name + " years: " + max_years);
    }

    public static void workedLeastYears(Person head) {
        String name = head.getName();
        int min_years = head.years;
        head = head.next;

        while (head != null) {
            if (head.years < min_years) {
                name = head.getName();
                min_years = head.years;
            }
            head = head.next;
        }
        System.out.println("Name: " + name + " years: " + min_years);
    }

    public static void averageHoursWorked(Person head) {
        int count = 0;
        double curr_sum = 0;
        while (head != null) {
            count++;
            curr_sum += head.hoursWorked;
            head = head.next;
        }
        System.out.println(String.format("Average hours worked: %.2f", (curr_sum / count)));

    }

    public static void totalPaymentToEachPerson(Person head) {
        while (head != null) {
            double totalPay = 0;

            totalPay += head.hoursWorked * head.hourlyWage;
            if (head.hoursWorked - 40 > 0) {
                totalPay += (head.hoursWorked - 40) * 2 * head.hourlyWage;
            }
            System.out.println("Name: " + head.getName());
            System.out.println("Hours worked: " + head.hoursWorked);
            System.out.println("Payment: " + totalPay);
            System.out.println();
            head = head.next;
        }
    }

    public static Person addPersonByCheckingId(Person head, Person newPerson, int position) {
        boolean isFound = false;
        Person curr = head;
        while (curr != null) {
            if (curr.getId() == newPerson.getId()) {
                isFound = true;
            }
            curr = curr.next;

        }
        if (isFound) {
            System.out.println("Adding Failed. Id already exist in the Linked List");
            return head;

        } else {
            System.out.println("Adding a new person at position " + position);

            return addPerson(head, newPerson, position);
        }
    }
}