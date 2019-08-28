import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
        GuessingGame game = new GuessingGame();
        game.play(1,1000);
	System.out.println("Thank You!!!");
    }    
}
