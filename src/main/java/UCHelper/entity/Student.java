package UCHelper.entity;

/**
 *
 * @author Cecelia Lim Jie Shi RSFY2S2
 */
public class Student implements Comparable<Student> {
    private String name;
    private int studId;
    
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
 
    public Student(String name, int studId) {
        this.name = name;
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudID() {
        return studId;
    }

    public void setStudID(int studId) {
        this.studId = studId;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s", this.studId, this.name);
    }
    
    @Override
    public int compareTo(Student anotherStudent) {
        return studId - anotherStudent.getStudID();
    }
}
