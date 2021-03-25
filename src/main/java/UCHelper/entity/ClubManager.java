package UCHelper.entity;

import UCHelper.adt.*;
import java.util.Iterator;

public class ClubManager {
  private BinarySearchTree<Club> clubs;

  public ClubManager() {
    this(new BinarySearchTree<Club>());
  }

  public ClubManager(BinarySearchTree<Club> clubs) {
    this.clubs = clubs;
  }

  /**
   * Find the latest registered club
   * 
   * @return the club registered latest
   */
  public Club latestClub() {
    return clubs.max();
  }

  /**
   * Find the earliest registered club
   * 
   * @return the club registered earliest
   */
  public Club earliestClub() {
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
  public boolean removeClub(int clubId) {
    return false;
  }

  /**
   * Get a club from the manager.
   * 
   * @param clubId - the id of the club.
   * @return club found in the manager, null otherwise.
   */
  public Club getClub(int clubId) {
    // An iterator to traverse the tree
    Iterator<Club> itr = clubs.traverse(BinarySearchTree.TreeTraversalOrder.InOrderTraversal);

    // Iterate through the tree
    while (itr.hasNext()) {
      Club club = (Club) itr.next();
      // If the clubId is equals, then found it
      if (club.compareTo(new Club(clubId)) == 0)
        return club;
    }

    return null;
  }
}