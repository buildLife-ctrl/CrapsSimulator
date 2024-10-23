import java.util.Random;
import java.util.Scanner;

public class CrapsSimulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //variable
        Random rand = new Random();
        int rollOne = 0;
        int rollTwo;
        int sum = 0;
        int point = 0;
        String continAsk;
        boolean contin = true;
        boolean game;
        int turn;

        System.out.println("Welcome to the Craps simulator!");
        System.out.println("Rule 1: If the sum of your rolls is 2, 3, or 12 it is called \"crapping out\" and the game is over with a loss.");
        System.out.println("Rule 2: If the sum is 7 or 11, it is called a \"natural\" and the game is over with a win.");
        System.out.println("Rule 3: For all other values, the sum becomes \"the point\" and you make subsequent rolls until you either roll a 7, in which case they lose, or the point sum in which case they win.");
        System.out.println();

        //game
        do {
            game = true;
            turn = 1;
            while (game) {
                rollOne = rand.nextInt(6) + 1;
                System.out.println("Roll 1: " + rollOne);

                rollTwo = rand.nextInt(6) + 1;
                System.out.println("Roll 2: " + rollTwo);

                sum = rollOne + rollTwo;
                System.out.println("Sum: " + sum);

                if (turn == 1) {
                    if (sum == 2 || sum == 3 || sum == 12) {
                        System.out.println("Sorry, you crapped out.");
                        System.out.println();
                        game = false;
                    } else if (sum == 7 || sum == 11) {
                        System.out.println("You win!");
                        System.out.println();
                        game = false;
                    } else {
                        point = sum;
                        System.out.println("Reroll. You must roll a " + point + " in order to win. A roll of 7 will result in a loss.");
                        scan.nextLine();
                        turn = 2;
                    }
                } else {
                    //if it is a reroll, it'll come back to this part and allow you to reroll until you win or lose
                    if (sum == point) {
                        System.out.println("You win!");
                        System.out.println();
                        game = false;
                    } else if (sum == 7) {
                        System.out.println("Sorry, you crapped out");
                        System.out.println();
                        game = false;
                    } else {
                        System.out.println("Reroll. You must roll a " + point + " in order to win. A roll of 7 will result in a loss.");
                        scan.nextLine();
                    }
                }
            }

            //asks if they want to continue
            System.out.println("Would you like to continue? Enter Y for yes or N for no.");
            continAsk = scan.nextLine();
            if (continAsk.equalsIgnoreCase("n")) {
                contin = false;
            }
            System.out.println();
        } while (contin);
    }
}