package UCHelper.entity;

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
        return name + "\t|\t" + studID;
    }
}