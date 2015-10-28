import java.util.Random;

public class AIPlayer {

	public String id;

	public AIPlayer(String id) {
		this.id = id;
	}

	int[][] roundValue = new int[15][4];
	int[][] seeds = new int[15][4];

	public int AILearn(int numSticks) {
		Random gen = new Random();

		int tempNum;
		if (numSticks > 2)
			tempNum = gen.nextInt(3) + 1;
		else if(numSticks == 2)
			tempNum = gen.nextInt(2) + 1;
		else
			tempNum = 1;
		
		roundValue[numSticks][tempNum] = 1;	//used to store the round values so they can be deleted if the bot looses! REMEMBER TO 0 IT!
		seeds[numSticks][tempNum]++;
		return tempNum;
	}

	public int AIMove(int numSticks) {
		Compare3 compare = new Compare3();
		int tempNum;
		if (numSticks > 2) {
			tempNum = compare.bestChoice(seeds[numSticks][0], seeds[numSticks][1], seeds[numSticks][2]);
			roundValue[numSticks][tempNum - 1] = 1;
			seeds[numSticks][tempNum - 1]++;
			return tempNum;
		} else if (numSticks == 2) {
			tempNum = compare.bestChoice(seeds[numSticks][0], seeds[numSticks][1], -99999);
			roundValue[numSticks][tempNum - 1] = 1;
			seeds[numSticks][tempNum - 1]++;
			return tempNum;
		} else if (numSticks == 1) {
			tempNum = 1;
			roundValue[numSticks][tempNum - 1] = 1;
			seeds[numSticks][tempNum - 1]++;
			return tempNum;
		} else
			return 83;

	}
	
	public void roundEnd(){
		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 4; j++) {
				roundValue[i][j] = 0;
			}
		}
	}

	public void botLost() {
		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 4; j++) {
				if (roundValue[i][j] == 1 && seeds[i][j] != 0)
					seeds[i][j] -= 1;			}
		}
	}

	public void printSeeds() {
		for (int i = 0; i < 15; i++) {
			System.out.print(i + "-\t");
			for (int j = 1; j < 4; j++) {
				System.out.print(seeds[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public String toString() {
		return "Player" + id;
	}
}
