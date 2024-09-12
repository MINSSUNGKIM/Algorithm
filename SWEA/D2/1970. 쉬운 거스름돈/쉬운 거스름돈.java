import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();

			int money = N / 10;

			int[] change = new int[money + 1];
			int[][] count = new int[money + 1][8];

			for (int i = 0; i < money + 1; i++) {
				change[i] = Integer.MAX_VALUE;
			}

			int[] coin = { 1, 5, 10, 50, 100, 500, 1000, 5000 };

			change[0] = 0;
			for (int i = 1; i <= money; i++) {
				for (int j = 0; j < 8; j++) {
					if (i >= coin[j]) {
						if (change[i] > change[i - coin[j]] + 1) {
							change[i] = change[i - coin[j]] + 1;
							System.arraycopy(count[i - coin[j]], 0, count[i], 0, 8);
							count[i][j]++;
						}
					}
				}

			}
			System.out.println("#" + t + " ");
			for (int i = 7; i >= 0; i--) {
				System.out.print(count[money][i] + " ");
			}
			System.out.println();

		}

	}

}