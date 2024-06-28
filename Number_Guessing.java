import java.util.Random;
import java.util.Scanner;

public class Number_Guessing{
    
    public static void main(String[] args){

        final int min_range = 1;
        final int max_range = 50;
        final int max_attempts = 10;
        final int max_rounds = 3;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalscore = 0;

        System.out.println("Welcome to Number Guessing-Game");
        System.out.println("Total number of rounds : 3");
        System.out.println("Number of attempts you have in Each round : 10\n");
        for(int i = 1; i <= max_rounds; i++){
            int number = random.nextInt(max_range) + min_range;
            int attempts = 0;

            System.out.println("Round " + i + " : Guess the number between " + min_range + " and " + max_range + " in " + max_attempts + " attempts. \n");
            while(attempts < max_attempts){

                System.out.print("Enter Your Guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if(guess_number == number){
                    int score = max_attempts - attempts;
                    totalscore = totalscore + score;
                    System.out.println("___________________________________________________________________________");
                    System.out.println("Great ! Number Guessed Successfully. Attempt = " + attempts + " Round Score = " + score +"\n");
                    System.out.println("___________________________________________________________________________");
                    break;
                }
                else if(guess_number < number){
                    System.out.println("The  number is Greater than " + guess_number + " Attempts Left = " + (max_attempts - attempts) +"\n");
                }
                else if(guess_number > number){
                    System.out.println("The  number is Less than " + guess_number + " Attempts Left = " + (max_attempts - attempts) +"\n");
                }
            }
            if(attempts == max_attempts){
                System.out.println("Round = " + i);
                System.out.println("Attempts Left = 0");
                System.out.println("The Random number is :" + number);
            }
        }
        System.out.println("...Game Over...");
        System.out.println("Total Score = " + totalscore);
        scanner.close();
    }
}