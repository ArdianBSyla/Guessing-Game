import java.util.Scanner;

public class GuessingGame {

    private Scanner reader;

    public GuessingGame() {
        // use only this scanner, othervise the tests do not work
        this.reader = new Scanner(System.in);
    }

    public void play(int lowerLimit, int upperLimit) {
        instructions(lowerLimit, upperLimit);
        int num = average(lowerLimit, upperLimit);
        // write the guessing logic here
        while(true){
            if(lowerLimit==upperLimit) {System.out.println("The number you're thinking of is " + num);break;}
            boolean b = isGreaterThan(num);
            if(lowerLimit==num && !b){
                //num = lowerLimit;
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
    public int average(int firstNumber, int secondNumber){
        return (firstNumber+secondNumber)/2;
    }

    public void instructions(int lowerLimit, int upperLimit) {
        int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

        System.out.println("Think of a number between " + lowerLimit + "..." + upperLimit + ".");

        System.out.println("I promise you that I can guess the number you are thinking with " + maxQuestions + " questions.");
        System.out.println("");
        System.out.println("Next I'll present you a series of questions. Answer them honestly.");
        System.out.println("");
    }

    // a helper method:
    public static int howManyTimesHalvable(int number) {
        // we create a base two logarithm  of the given value

        // Below we swap the base number to base two logarithms!
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }
}