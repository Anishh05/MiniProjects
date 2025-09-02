import java.util.Scanner;

class Range {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

public class Number_Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Range rg = new Range();
        int totalAttempts = 0;
        int wins = 0;

        while (true) {
            System.out.println("Enter the minimum number:");
            int min = s.nextInt();
            System.out.println("Enter the maximum number:");
            int max = s.nextInt();

            int target = rg.generate(max, min);
            int attemptsThisGame = 0;

            while (true) {
                System.out.println("Guess a number between " + min + " and " + max + ":");
                int guess = s.nextInt();
                attemptsThisGame++;

                if (guess > target) {
                    System.out.println("It's lower!");
                } else if (guess < target) {
                    System.out.println("It's greater!");
                } else {
                    System.out.println("Correct guess!");
                    wins++;
                    break;
                }
            }

            totalAttempts += attemptsThisGame;
            System.out.println("Attempts this round = " + attemptsThisGame);
            System.out.println("Total Wins = " + wins);

            double winRate = (double) wins / totalAttempts * 100;
            System.out.printf("Your win rate is %.2f%%\n", winRate);

            System.out.println("Do you want to play again (y / n)?");
            String playAgain = s.next();

            if (!playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing! Bye...");
                break;
            }
        }

        s.close();
    }
}
