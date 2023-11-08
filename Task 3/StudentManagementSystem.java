import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private int age;
    private double gpa;

    public Student(String studentID, String firstName, String lastName, int age, double gpa) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            student.displayStudent();
            System.out.println();
        }
    }

    public Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(String studentID) {
        Student student = findStudentByID(studentID);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    Student newStudent = new Student(studentID, firstName, lastName, age, gpa);
                    studentManagementSystem.addStudent(newStudent);
                    break;
                case 2:
                    studentManagementSystem.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter the Student ID to remove: ");
                    studentID = scanner.nextLine();
                    studentManagementSystem.removeStudent(studentID);
                    break;
                case 4:
                    System.out.println("Exiting Student Management System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}