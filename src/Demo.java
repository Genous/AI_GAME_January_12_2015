import java.util.Scanner;
import java.util.Random;

public class Demo {

	static boolean smartBotWon = false;
	static int numSticks;
	private static Scanner sc;
	private static Random gen;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		gen = new Random();

		int player1Wins = 0;
		int AI1Choice = 0, AI2Choice = 0;
		
		AIPlayer player1 = new AIPlayer("1");
		
		for (int i = 0; i < 10000; i++) {

			numSticks = 14;
			System.out.println("-------14 STICKS--------");

			while (true) {

				smartBotWon = false;
				AI1Choice = player1.AILearn(numSticks);
				numSticks -= AI1Choice;
				System.out.println(player1 + " took " + AI1Choice + "! " + numSticks + " Sticks left!");
				if (numSticks < 1)
					break;

				smartBotWon = true;
				if (numSticks > 2)
					AI2Choice = gen.nextInt(3) + 1;
				else if (numSticks == 2)
					AI2Choice =  gen.nextInt(2) + 1;
				else
					AI2Choice = 1;

				numSticks -= AI2Choice;
				System.out.println("player2" + " took " + AI2Choice + "! " + numSticks + " Sticks left!");
				if (numSticks < 1)
					break;

			}

			if (smartBotWon) {
				
				player1Wins++;

				System.out.println("------------- Smart Bot Won! (Number of Wins: " + player1Wins + " )--------------------");
				player1.printSeeds();
				player1.roundEnd();

			} else {
				
				player1.botLost();      //BOT LOST BEFORE ROUND END!
				System.out.println("------------- Smart Bot Lost! (Number of Wins: " + player1Wins + " )-------------------");
				player1.printSeeds();
				player1.roundEnd();

			}
		}

		numSticks = 14;
		while (numSticks > 0) {
			AI1Choice = player1.AIMove(numSticks);
			numSticks -= AI1Choice;
			System.out.println(player1 + " took " + AI1Choice + "! " + numSticks + " Sticks left!");
			if (numSticks < 1)
				System.out.println("I WON!");
			
			System.out.println("Your turn!");
			int playerChoice = sc.nextInt();
			numSticks -= playerChoice;
			System.out.println("You took: " + playerChoice + "! " + numSticks + " Sticks left!");
			if (numSticks < 1)
				System.out.println("AI WON!");

		}

	}
}