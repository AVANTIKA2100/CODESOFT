import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("====================================");
        
        int totalRounds = 0;
        int totalWins = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            totalRounds++;
            int secretNumber = random.nextInt(100) + 1; // Random number between 1-100
            int maxAttempts = 10;
            int attempts = 0;
            boolean hasWon = false;
            
            System.out.println("\nRound " + totalRounds + " - Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts && !hasWon) {
                System.out.print("\nAttempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");
                
                try {
                    int guess = scanner.nextInt();
                    attempts++;
                    
                    if (guess == secretNumber) {
                        hasWon = true;
                        totalWins++;
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    } else if (guess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number between 1 and 100.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            if (!hasWon) {
                System.out.println("\nGame over! You've used all your attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }
            
            System.out.print("\nWould you like to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }
        
        System.out.println("\nGame Summary:");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
}




