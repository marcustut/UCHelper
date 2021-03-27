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

    public Student(String name, int studID) {
        this.name = name;
        this.studId = studID;
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

    public void setStudID(int studID) {
        this.studId = studID;
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