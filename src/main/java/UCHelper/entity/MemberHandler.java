package UCHelper.entity;

import UCHelper.adt.*;

public class MemberHandler {
    private final IterableCustomStack<Student> members = new IterableCustomStack<Student>();
    private final IterableCustomStack<Student> committees = new IterableCustomStack<Student>();
    private Student clubLead;

    public MemberHandler() {
    }

    public MemberHandler(Student clubLead) {
        this.clubLead = clubLead;
    }

    /**
     * Get the list of members of a Club
     * 
     * @return list of members
     */
    public IterableCustomStack<Student> getMembers() {
        return members;
    }

    /**
     * Get the list of committees of a Club
     * 
     * @return list of committees
     */
    public IterableCustomStack<Student> getCommittees() {
        return committees;
    }

    /**
     * Get the leader of a Club
     * 
     * @return Student object of the club lead
     */
    public Student getClubLead() {
        return clubLead;
    }

    /**
     * Change the club leader of the club
     * 
     * @param newClubLead - the new club leader
     */
    public void changeClubLead(Student newClubLead) {
        this.clubLead = newClubLead;
    }

    /**
     * Add a student to the list of members
     * 
     * @param member - the student to add
     * @return true if student is added, false otherwise
     */
    public boolean addMember(Student member) {
        return members.add(member);
    }

    /**
     * Remove a student from the list of members by its Student ID
     * 
     * @param studentId - ID of the student
     * @return the removed student, null otherwise
     */
    public Student removeMember(int studentId) {
        int found = members.findIndex(new Student("", studentId));

        // Student not found
        if (found == -1)
            return null;

        return members.remove(found);
    }

    /**
     * Find a student from the list of member and return it
     * 
     * @param studentId - ID of the student
     * @return the found student, null otherwise
     */
    public Student getMember(int studentId) {
        int found = members.findIndex(new Student("", studentId));

        if (found == -1)
            return null;

        return members.get(found);
    }
}
