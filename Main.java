import java.util.Scanner;

public class Main {

    private static Double readMarks(Scanner sc) {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                Double marks = Double.parseDouble(input); // wrapper + parsing
                if (marks < 0 || marks > 100) {
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
                return marks;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter marks again: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Enter marks again: ");
            }
        }
    }

    private static Integer readRollNo(Scanner sc) {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                Integer roll = Integer.parseInt(input);
                if (roll <= 0) {
                    throw new IllegalArgumentException("Roll number must be positive.");
                }
                return roll;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter roll no again: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Enter roll no again: ");
            }
        }
    }

    private static String readNonEmpty(Scanner sc, String fieldName) {
        while (true) {
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.print(fieldName + " cannot be empty. Enter again: ");
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("===== Enhanced Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Find Student");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                String choiceInput = sc.nextLine().trim();
                try {
                    choice = Integer.parseInt(choiceInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a number.\n");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter roll no: ");
                        Integer roll = readRollNo(sc);

                        System.out.print("Enter name: ");
                        String name = readNonEmpty(sc, "Name");

                        System.out.print("Enter email: ");
                        String email = readNonEmpty(sc, "Email");

                        System.out.print("Enter course: ");
                        String course = readNonEmpty(sc, "Course");

                        System.out.print("Enter marks (0–100): ");
                        Double marks = readMarks(sc);

                        Student student = new Student(roll, name, email, course, marks);
                        manager.addStudent(student);
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter roll no to update: ");
                        Integer rno = readRollNo(sc);
                        System.out.print("Enter new marks (0–100): ");
                        Double newMarks = readMarks(sc);
                        try {
                            manager.updateMarks(rno, newMarks);
                        } catch (StudentNotFoundException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                        }
                        break;

                    case 4:
                        System.out.print("Enter roll no to delete: ");
                        Integer dno = readRollNo(sc);
                        try {
                            manager.deleteStudent(dno);
                        } catch (StudentNotFoundException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                        }
                        break;

                    case 5:
                        System.out.print("Enter roll no to find: ");
                        Integer fno = readRollNo(sc);
                        try {
                            Student s = manager.findStudent(fno);
                            System.out.println("Student found:");
                            s.displayInfo();
                        } catch (StudentNotFoundException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.\n");
                }

            } while (true);
        } finally {
            sc.close();
            System.out.println("Application closed.");
        }
    }
}
