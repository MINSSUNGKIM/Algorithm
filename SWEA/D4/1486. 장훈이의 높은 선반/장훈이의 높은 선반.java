import java.util.Scanner;

public class Solution {

	static int N, B;
	static int[] height;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();

			height = new int[N];
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
			}
			ans = 987654321;
			makeTop(0, 0);

			System.out.printf("#%d %d\n", t, ans);

		} // tc

		sc.close();
	}// main

	//
	static int ans;

	private static void makeTop(int idx, int sum) {

		if (sum >= B) {
			ans = Math.min(ans, sum - B);
			return;
		}

		if (idx == N)
			return;

		makeTop(idx + 1, sum + height[idx]);
		makeTop(idx + 1, sum);

	}

}// end