package UCHelper.entity;

import java.util.Date;

import UCHelper.adt.*;

public class Club implements Comparable<Club> {
    private int id;
    private String name;
    // private EventManager eventManager;
    // private MemberHandler memberHandler;
    private Range<Date> weeklyActivityTime;

    public Club(int id, String name, Range<Date> weeklyActivityTime) {
        this.id = id;
        this.name = name;
        this.weeklyActivityTime = weeklyActivityTime;
    }

    /**
     * Compare two clubs based on their number of members.
     *
     * @param anotherClub - the club to be compared with
     * @return 0 if equal, negative integer if lesser, positive integer if greater
     */
    @Override
    public int compareTo(Club anotherClub) {
        // TODO: Change this to number of members from memberHandler
        return id - anotherClub.id;
    }
}
