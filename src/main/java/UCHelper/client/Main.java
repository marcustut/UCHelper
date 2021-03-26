package UCHelper.client;
import UCHelper.adt.BinarySearchTree;
import static UCHelper.client.EventManager.EventUI;
import java.util.Scanner;
/**
 * @description this was a simple java program that help clubs to manage their community.
 * @author Marcus Lee Kai Yang RSFY2S2, marcustutorial@hotmail.com
 * @author Cecelia Lim Jie Shi RSFY2S2, cecelialjs-wm19@student.tarc.edu.my 
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @author 
 */
public class Main {
	public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int selection = 0; 
            do{
                    
                System.out.println("------- UC Helper -------");
                System.out.println("[1] Admin");
                System.out.println("[2] Club");
                System.out.println("[3] Event");
                System.out.println("[4] Student Queue");
                System.out.println("[5] Exit");
                System.out.println("Select [1/2/3/4/5]");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("\nSelect [1/2/3/4/5]");
            }
            selection = in.nextInt();
            System.out.println("");
            switch(selection){
                case 1:
                    break;
                case 2:
                    // TODO code application logic here
//                    BinarySearchTree<Club> clubs = new BinarySearchTree<>();
//                    ClubManager clubManager = new ClubManager(clubs);
//                    clubs.add(2);
//                    clubs.add(1);
//                    clubs.add(3);
//                    clubs.add(5);
                    break;
                case 3:
                    EventUI();
                    break;
                case 4:
                    StudentQueue squ = new StudentQueue();
                    squ.studentMainPage();
                    break;
                default:
                    break;
            }
            System.out.println("");
            }while(selection >= 1 && selection <=4);
	}
}
