package UCHelper.entity;

public class Student implements Comparable<Student> {
    private String studentId;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public int compareTo(Student anotherStudent) {
        return studentId.compareTo(anotherStudent.getStudentId());
    }
}
