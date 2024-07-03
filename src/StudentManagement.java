import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDao();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = scanner.next();
                    System.out.print("Enter city: ");
                    String city = scanner.next();
                    Student student = new Student(0, name, rollNumber, grade, city);
                    studentDao.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID to delete: ");
                    int id = scanner.nextInt();
                    studentDao.deleteStudent(id);
                    break;
                case 3:
                    List<Student> students = studentDao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
