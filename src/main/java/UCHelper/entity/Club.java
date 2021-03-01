package UCHelper.entity;

public class Club implements Comparable<Club> {
    private int id;
    private String name;

    public Club(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Compare two clubs based on their id.
     *
     * @param  anotherClub - the club to be compared with.
     * @return 
     */
    @Override
    public int compareTo(Club anotherClub) {
        return id - anotherClub.id;
    }
}
