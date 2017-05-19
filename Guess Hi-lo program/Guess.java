package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>Guess.java is a driver class which is designed to play a Hi-lo game
 * with the user. The program instantiates a random object to generate a 
 * random number between 1-100 for the user to guess.  It also gives a 
 * sentinel value for the user ("0") which the user can type in at any
 * point during the game to quit the current game.  The class also tells
 * the user if their guesses are too high or too low and tells the user 
 * their total number of guess (high or low) upon completion of each game.
 * The class also prompts if the user would like to play again and will 
 * start a new game at the user's discretion with the same conditions as
 * mentioned above.</p>
 *
 * @author Steven Ma
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        final int cap = 100;
        String answer = "Y";
        do {
            int numToGuess;
            int guess = -1;
            int count = 0;
            answer = "Y";
            numToGuess = generator.nextInt(cap) + 1;           
            System.out.print("Please guess the integer number between"
                    + " 1 and 100.\nIf you wish to quit, type, \"0.\" ");
            while (guess != 0) {
                guess = scan.nextInt();
                System.out.println("Your guess was..." + guess);
                if (guess > cap || guess < 0) {
                    throw new IllegalArgumentException("Input cannot be more "
                            + "than 100 or less than 0. To quit the input must"
                            + " be -1");
                } else if (guess == 0) {
                    System.out.println("Quitting game...\n");
                } else if (guess > numToGuess) {
                    System.out.println("That number is too high.");
                    count++;
                } else if (guess < numToGuess) {
                    System.out.println("That number is too low.");
                    count++;
                } else if (guess == numToGuess) {
                    System.out.println("That was correct.");
                    guess = 0;
                    count++;
                }
                
            }
            System.out.println("Number of guesses for this game: " + count);
            System.out.println("Would you like to play again? \n\"N\" for no,"
                    + " or any other input to start a new game.");
            answer = scan.next();
        } while (!answer.equals("N"));
        System.out.println("Goodbye!");
    }
};