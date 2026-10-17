import java.util.Scanner;

public class StudentManagementSystem {

static Scanner input = new Scanner(System.in);

static String[] names;
static String[] regNumbers;
static String[] subjects;
static String[] classes;
static double[] marks;

static int numberOfStudents = 0;

// Method for teacher login
public static boolean login() {
    String username;
    String password;

    System.out.println("=== TEACHER LOGIN ===");

    System.out.print("Enter username: ");
    username = input.nextLine();

    System.out.print("Enter password: ");
    password = input.nextLine();

    if (username.equals("teacher") &&
        password.equals("1234")) {

        System.out.println("Login successful!");
        return true;

    } else {
        System.out.println("Invalid username or password.");
        return false;
    }
}

public static int readInt(String prompt) {
    while (true) {
        System.out.print(prompt);
        String inputValue = input.nextLine().trim();

        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a whole number.");
        }
    }
}

public static double readDouble(String prompt) {
    while (true) {
        System.out.print(prompt);
        String inputValue = input.nextLine().trim();

        try {
            return Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}

// Method for registering students
public static void registerStudents() {

    numberOfStudents = readInt("Enter number of students to register: ");

    if (numberOfStudents <= 0) {
        System.out.println("Enter a valid number of students.");
        numberOfStudents = 0;
        return;
    }

    names = new String[numberOfStudents];
    regNumbers = new String[numberOfStudents];
    subjects = new String[numberOfStudents];
    classes = new String[numberOfStudents];
    marks = new double[numberOfStudents];

    for (int i = 0; i < numberOfStudents; i++) {

        System.out.println("\nStudent " + (i + 1));

        System.out.print("Enter student name: ");
        names[i] = input.nextLine();

        System.out.print("Enter registration number: ");
        regNumbers[i] = input.nextLine();

        System.out.print("Enter subject: ");
        subjects[i] = input.nextLine();

        System.out.print("Enter class: ");
        classes[i] = input.nextLine();

        marks[i] = -1;
    }

    System.out.println("Students registered successfully.");
}

// Method for recording students' marks
public static void recordMarks() {

    if (numberOfStudents == 0) {
        System.out.println("Please register students first.");
        return;
    }

    for (int i = 0; i < numberOfStudents; i++) {

        System.out.println("\nStudent: " + names[i]);

        double mark = readDouble("Enter marks out of 100: ");

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid marks. Enter marks between 0 and 100.");
            i--;
        } else {
            marks[i] = mark;
        }
    }

    System.out.println("Marks recorded successfully.");
}

// Method for displaying students and their marks
public static void displayStudents() {

    if (numberOfStudents == 0) {
        System.out.println("No students have been registered.");
        return;
    }

    System.out.println("\n=== REGISTERED STUDENTS AND MARKS ===");

    for (int i = 0; i < numberOfStudents; i++) {

        System.out.println("\nStudent " + (i + 1));
        System.out.println("Name: " + names[i]);
        System.out.println("Registration Number: " + regNumbers[i]);
        System.out.println("Subject: " + subjects[i]);
        System.out.println("Class: " + classes[i]);

        if (marks[i] == -1) {
            System.out.println("Marks: Not yet recorded");
        } else {
            System.out.println("Marks: " + marks[i]);
        }
    }
}

// Main method
public static void main(String[] args) {

    if (!login()) {
        System.out.println("Access denied.");
        input.close();
        return;
    }

    int choice;

    do {
        System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
        System.out.println("1. Register Students");
        System.out.println("2. Record Marks");
        System.out.println("3. View All Students and Marks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1:
                registerStudents();
                break;

            case 2:
                recordMarks();
                break;

            case 3:
                displayStudents();
                break;

            case 4:
                System.out.println("Thank you for using the system.");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }

    } while (choice != 4);

    input.close();
}
}