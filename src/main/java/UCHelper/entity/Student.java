package UCHelper.entity;

/**
 *
 * @author Cecelia Lim Jie Shi RSFY2S2
 */
public class Student implements Comparable<Student> {
    String name;
    int studID;

    public Student() {
    }

    public Student(String name, int studID) {
        this.name = name;
        this.studID = studID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    @Override
    public String toString() {
        return String.format("Student ID: %d, Student Name: %s", this.studID, this.name);
    }

    @Override
    public int compareTo(Student anotherStudent) {
        return studID - anotherStudent.getStudID();
    }
}