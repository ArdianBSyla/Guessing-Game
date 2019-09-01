import java.util.Scanner;
/** GameController will control the GuessingGame after asking the user
 *  for length of the interval. */
public class GameController {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
    	System.out.print("Which is the minimal number: ");
    	int min = Integer.parseInt(reader.nextLine());
    	System.out.print("Which is the maximal number: ");
    	int max = Integer.parseInt(reader.nextLine());
        GuessingGame game = new GuessingGame();
        game.play(min,max);
        System.out.println("Thank You!!!");
    }    
}
