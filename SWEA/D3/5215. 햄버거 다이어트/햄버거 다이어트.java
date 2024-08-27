import java.io.IOException;
import java.util.Scanner;

class Ingredient {
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int score, int calories) {
		super();
		this.score = score;
		this.calories = calories;
	}

	public int score;
	public int calories;
}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int L = sc.nextInt();

//			int[] keyarr = new int[N];
//			HashMap<Integer, Integer> map = new HashMap<>();
			Ingredient[] ingredient = new Ingredient[N];
			for (int i = 0; i < N; i++) {
				ingredient[i] = new Ingredient(sc.nextInt(), sc.nextInt());
//				keyarr[i] = sc.nextInt();
//				map.put(keyarr[i], sc.nextInt());

			}
			int maxScore = Integer.MIN_VALUE;
			// 모든 버거를 다 먹어보는 BruteForce
			for (int i = 0; i < (1 << N); i++) {
				// 무슨 버거를 먹어볼지 결정하는 i

				int calSum = 0;
				int scoreSum = 0;
				// ex) i 가 5라면? 00101 -> &연산자로 3번버거랑 5번버거를 먹자
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						scoreSum += ingredient[j].score;
						calSum += ingredient[j].calories;
//						scoreSum += keyarr[j];
//						calSum += map.get(keyarr[j]);
					}
				}
				if (calSum <= L) {
					maxScore = Math.max(scoreSum, maxScore);
				}

			}

			System.out.println("#" + t + " " + maxScore);

		}

	}
}
