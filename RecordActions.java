public interface RecordActions {
    void addStudent(Student student);
    void updateMarks(Integer rollNo, Double newMarks) throws StudentNotFoundException;
    void deleteStudent(Integer rollNo) throws StudentNotFoundException;
    Student findStudent(Integer rollNo) throws StudentNotFoundException;
    void viewStudents();
}
