import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;    // Score based on attempts
        int roundsWon = 0;     // Score based on rounds won
        int rounds = 0;
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            final int maxAttempts = 10;
            boolean guessed = false;

            System.out.println("\nNew round! You have " + maxAttempts + " attempts to guess the number between 1 and 100.");

            while (!guessed && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);  // Score based on remaining attempts
                    roundsWon++;  // Increment rounds won
                    guessed = true;
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            rounds++;
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        // Display the total score and rounds won
        System.out.println("\nGame Over! You played " + rounds + " round(s).");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total score (based on attempts): " + totalScore);
        scanner.close();
    }
}
