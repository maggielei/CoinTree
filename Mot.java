/**
 * The Mot class contains the main method that runs the program. It prompts the user for the starting number of pennies,
 * prompts for the difficulty, and displays the amount of ways to play the game. This class also contains the difficulty
 * mode methods that are called in the main method. 
 * 
 * @author Maggie Lei
 * ID: 1087990364
 * Recitation: 04
 * Homework #5 for CSE 214, Fall 2013
 */
import java.util.Scanner;
public class Mot {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = 0;
		System.out.println("Welcome to the game of MOT!");
		System.out.println("How many pennies should we start with (must be" +
				" at least 5)?");
		num = s.nextInt();
		while(num < 5){
			System.out.println("Invalid input.\nEnter a number greater or equal to 5.");
			num = s.nextInt();
		}
		if(num >= 5){
			GameTree g = new GameTree(num);
			System.out.println("GAME TREE CONSTRUCTED.");
			System.out.println("Total number of possible ways to play this game: " +
					g.possibleWays());
			System.out.println("What mode do you want the computer to play in: " +
					"(r)andom or (e)xpert? [r/e]");
			String ans = s.next();
			if(ans.equals("r")){
				System.out.println("Okay! Let's play!");
				randomMode(g);
			}
			else if(ans.equals("e")){
				System.out.println("Okay! Let's play!");
				expertMode(g);
			}
		}
	}
	/**
	 * This method runs all the steps the computer should take if played on Expert Mode. The computer does not lose.
	 * If the number is a multiple of 4, it takes away 3. The board will always end up with 5 pennies left over. Either
	 * way the user picks, the computer will win. This method is recursive and keeps calling itself until 5 pennies are
	 * on the board.
	 * @param gt
	 * The GameTree that is being played on Expert Mode. 
	 */
	private static void expertMode(GameTree gt) {
		Scanner x = new Scanner(System.in);
		System.out.println("Total number of pennies: " + gt.currentNumPennies());
		int startingNum = gt.currentNumPennies();
		int i = (startingNum / 4);
		if(startingNum % 4 == 0){
			System.out.println("(Computer) I will remove 3 pennies.");
			gt.removePennies(gt.currentNumPennies() - 3);
		}
		else if(startingNum != (4*i+1)){
			startingNum = startingNum - (i * 4 + 1);
			System.out.println("(Computer) I will remove " + startingNum + " pennies.");
			gt.removePennies(gt.currentNumPennies() - startingNum);
		}
		else if(gt.currentNumPennies() == 4){
			System.out.println("(Computer) I will remove 2 pennies.");
			gt.removePennies(gt.currentNumPennies() - 2);
		}
		else if(gt.currentNumPennies() == 3){
			System.out.println("(Computer) I will remove 2 pennies.");
			gt.removePennies(gt.currentNumPennies() - 2);
		}
		else if(gt.currentNumPennies() == 2){
			System.out.println("(Computer) I will remove 1 penny.");
			gt.removePennies(gt.currentNumPennies() - 1);
		}
		else{
			System.out.println("(Computer) I will remove 3 pennies.");
			gt.removePennies(gt.currentNumPennies() - 3);
		}
		System.out.println("Total number of pennies: " + gt.currentNumPennies());
		System.out.println("Human: How many pennies do you want to remove?");
		int numRem = x.nextInt();
		while(numRem > gt.currentNumPennies() || numRem > 3){
			System.out.println("Invalid input.\nEnter a valid number.");
			numRem = x.nextInt();
		}
		gt.removePennies(gt.currentNumPennies() - numRem);
		if(gt.currentNumPennies() == 0){
			System.out.println("You lose!");
		}
		else{
			expertMode(gt);
		}
	}
	/**
	 * This method runs all the steps the computer should take if played on Normal Mode. The computer randomly
	 * selects a number between 1 and 3 if there are more than 3 pennies on the board. Sometimes the computer may take 
	 * all the remaining pennies and lose. Only in random mode can the computer lose. This method is recursive. It keeps
	 * running until there is a winner.
	 * @param gt
	 * The GameTree that is being played on Random Mode.
	 */
	private static void randomMode(GameTree gt) {
		Scanner t = new Scanner(System.in);
		System.out.println("Total number of pennies: " + gt.currentNumPennies());
		int numToRemove = 0;
		if(gt.currentNumPennies() >= 3){
			numToRemove = (int)(Math.random()*3+1);
			System.out.println("(Computer) I will remove " + numToRemove + " pennies.");
			if(gt.currentNumPennies() - numToRemove == 0){
				System.out.println("I lose!");
				System.exit(0);
			}
			gt.removePennies(gt.currentNumPennies() - numToRemove);
		}	
		else if(gt.currentNumPennies() == 2){
			gt.removePennies(numToRemove);
			if(numToRemove == 1){
				System.out.println("(Computer) I will remove 1 penny.");
			}
			else{
				System.out.println("(Computer) I will remove 2 pennies.");
				System.out.println("I lose!");
				System.exit(0);
			}
		}
		else if(gt.currentNumPennies() == 1){
			System.out.println("You lose!");
			System.exit(0);
		}
		System.out.println("Total number of pennies: " + gt.currentNumPennies());
		System.out.println("Human: How many pennies do you want to remove?");
		int numRem = t.nextInt();
		while(numRem > gt.currentNumPennies() || numRem > 3 || numRem < 0){
			System.out.println("Invalid input.\nEnter a valid number.");
			numRem = t.nextInt();
		}
		gt.removePennies(gt.currentNumPennies() - numRem);
		if(gt.currentNumPennies() == 1){
			System.out.println("You win!");
		}
		else if(gt.currentNumPennies() == 0){
			System.out.println("You lose!");
		}
		else{
			randomMode(gt);
		}
	}
}
