import java.util.Scanner;
/** Guessing Game is a game in which you guess a number
 * and the game will ask you a few questions depending
 * on the length of interval that will be set by the user.
 * After these questions the game will show you in the console
 * the number that you are thinking.
 */
public class GuessingGame {

    private Scanner reader; // scanner that will read the user input
    
    /** The GuessingGame constructor. */
    public GuessingGame() {
        this.reader = new Scanner(System.in);
    }
    
    /** play will lead the logic of the game.
     *  This method knows when to ask another question or 
     *  to show the number that the user was thinking
     * @param lowerLimit - lowerLimit
     * @param upperLimit - upperLimit
     */
    public void play(int lowerLimit, int upperLimit) {
        instructions(lowerLimit, upperLimit);
        int num = average(lowerLimit, upperLimit);
        // here we are writing the guessing logic
        while(true){
            if(lowerLimit==upperLimit) {System.out.println("The number you're thinking of is " + num);break;}
            boolean b = isGreaterThan(num);
            if(lowerLimit==num && !b){
                System.out.println("The number you're thinking of is " + num);
                break;
            }
            else if(b) {
                lowerLimit = num+1;
                num = average(lowerLimit,upperLimit);
            }
            else{
                upperLimit=num;
                num = (upperLimit+lowerLimit)/2;
            }
        }
    }

    /** This method will ask the user if his number is 
     *  greater than the number that we are asking for
     * @param value - value that we will ask the user for
     * @return true if his number is greater than value given as parameter, otherwise return false
     */
    public boolean isGreaterThan(int value){
        System.out.println("Is your number greater than " + value + " (y/n)");
        String yn = reader.nextLine();
        if(yn.equals("y")) return true;
        return false;
    }
    
    /** average calculates the average of two numbers,
     *  in this case the average of lower and upper limit
     * @param firstNumber - first number of interval
     * @param secondNumber - last number of interval
     * @return average of two number given as parameters
     */
    public int average(int firstNumber, int secondNumber){
        return (firstNumber+secondNumber)/2;
    }
    
    /** instruction will show in the console some instructions for the user
     * @param lowerLimit - lower limit of interval
     * @param upperLimit - upperlimit of interval
     */
    public void instructions(int lowerLimit, int upperLimit) {
        int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

        System.out.println("Think of a number between " + lowerLimit + "..." + upperLimit + ".");

        System.out.println("I promise you that I can guess the number you are thinking with " + maxQuestions + " questions.");
        System.out.println("");
        System.out.println("Next I'll present you a series of questions. Answer them honestly.");
        System.out.println("");
    }

    /** howManyTimesHalvable calculates how many questions will be asked. */
    public static int howManyTimesHalvable(int number) {
        // we created a base two logarithm  of the given value

        // Below we swap the base number to base two logarithms!
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }
}