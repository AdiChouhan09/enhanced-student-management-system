import java.util.ArrayList;
import java.util.List;

public class StudentManager implements RecordActions {

    private final List<Student> students = new ArrayList<>();

    private boolean existsRollNo(Integer rollNo) {
        for (Student s : students) {
            if (s.getRollNo().equals(rollNo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void addStudent(Student student) {
        if (existsRollNo(student.getRollNo())) {
            System.out.println("Error: Student with roll no " +
                    student.getRollNo() + " already exists.");
            return;
        }
        Thread t = new LoadingThread("Saving student");
        t.start();
        students.add(student);
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Student added successfully.\n");
    }

    @Override
    public synchronized void updateMarks(Integer rollNo, Double newMarks)
            throws StudentNotFoundException {

        Student s = findStudent(rollNo);
        Thread t = new LoadingThread("Updating marks");
        t.start();
        s.setMarks(newMarks);
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Marks updated for roll no " + rollNo + ".\n");
    }

    @Override
    public synchronized void deleteStudent(Integer rollNo)
            throws StudentNotFoundException {

        Student s = findStudent(rollNo);
        Thread t = new LoadingThread("Deleting student");
        t.start();
        students.remove(s);
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Student with roll no " + rollNo + " deleted.\n");
    }

    @Override
    public synchronized Student findStudent(Integer rollNo)
            throws StudentNotFoundException {

        for (Student s : students) {
            if (s.getRollNo().equals(rollNo)) {
                return s;
            }
        }
        throw new StudentNotFoundException(
                "Student with roll no " + rollNo + " not found.");
    }

    @Override
    public synchronized void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.\n");
            return;
        }
        System.out.println("\n---- Student Records ----");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}
