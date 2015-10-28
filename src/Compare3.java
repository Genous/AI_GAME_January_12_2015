import java.util.Random;

public class Compare3 {
	Random gen = new Random();

	public int bestChoice(int a, int b, int c) {

		if (a == b && a == c) {
			return gen.nextInt(3) + 1; // All number are the same
		}

		else if (a == b && a != c) {
			if (a > c)
				return gen.nextInt(2) + 1; // a And b are the the largest
			else
				return 3; // c is the largest
		} else if (b == c && b != a) {
			if (b > a)
				return gen.nextInt(2) + 2; // "b And c are the largest
			else
				return 1; // a is the largest
		} else if (a == c && a != b) {
			if (a > b) {
				int temp = gen.nextInt(2);
				if (temp == 0)
					return 1; // a and c are the largest
				else
					return 3;
			} else
				return 2; // b is the largest
		} else if (a > b && a > c) {
			return 1; // a is the largest
		} else if (b > c && b > a) {
			return 2; // b is the largest
		} else if (c > a && c > b)
			return 3; // c is the largest
		else
			return 0;
	}
}


/*     testing compare3
Compare3 cmp = new Compare3();
Random   gen = new Random();
int a = 0 , b = 0, c = 0;
for(int i = 0; i < 100; i++){
	a = gen.nextInt(3) + 1;
	b = gen.nextInt(3) + 1;
	c = gen.nextInt(3) + 1;
	System.out.println("" + a + ", " + b + ", " + c + ": " + cmp.bestChoice(a,b,c));
}
*/