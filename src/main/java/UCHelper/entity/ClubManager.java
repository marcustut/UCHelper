package UCHelper.entity;

import UCHelper.adt.*;

public class ClubManager {
  private BinarySearchTree<Club> clubs;

  public ClubManager(BinarySearchTree<Club> clubs) {
    this.clubs = clubs;
  }

  /**
   * Find the club with most members
   * 
   * @return the club with most members
   */
  public Club clubWithMostMembers() {
    return clubs.max();
  }

  /**
   * Find the club with least members
   * 
   * @return the club with least members
   */
  public Club clubWithLeastMembers() {
    return clubs.min();
  }

  /**
   * Register a new club.
   * 
   * @param club - the club to be registered to the manager.
   * @return true if successfully register, false otherwise.
   */
  public boolean registerClub(Club club) {
    return clubs.add(club);
  }

  /**
   * Remove an existing club.
   * 
   * @param club - the club to be removed from the manager.
   * @return true if successfully removed, false otherwise.
   */
  public boolean removeClub(Club club) {
    return clubs.remove(club);
  }
}