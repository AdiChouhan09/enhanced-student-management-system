public class Student extends Person {
    private Integer rollNo; // wrapper types
    private String course;
    private Double marks;
    private Character grade;

    public Student(Integer rollNo, String name, String email,
            String course, Double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        setMarks(marks);
    }

    private Character calculateGrade(Double marks) {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 60)
            return 'C';
        else if (marks >= 50)
            return 'D';
        else
            return 'F';
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public Double getMarks() {
        return marks;
    }

    public Character getGrade() {
        return grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(Double marks) {
        this.marks = marks; // autoboxing
        this.grade = calculateGrade(marks); // autoboxing to Character
    }

    @Override
    public void displayInfo() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Email   : " + email);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);
        System.out.println("Grade   : " + grade);
        System.out.println("-----------------------------");
    }
}
