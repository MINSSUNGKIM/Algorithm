import java.util.Scanner;

class Solution {
	static int N;
	static boolean[] used;
	static int[][] score;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			used = new boolean[N];
			score = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					score[i][j] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;

			findMin(0, 0);

			System.out.println("#" + t + " " + ans);

		}

	}

	static void findMin(int idx, int cnt) {
		// 기저
		if (cnt == N / 2) {
			int Asum = 0;

			int Bsum = 0;
			for (int i = 0; i < N; i++) {
				if (used[i]) {
					for (int j = 0; j < N; j++) {
						if (i != j && used[j]) {
							Asum += score[i][j];
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (i != j && !used[j]) {
							Bsum += score[i][j];
						}
					}
				}

			}
			if (ans > Math.abs(Asum - Bsum)) {
				ans = Math.abs(Asum - Bsum);
			}

			return;

		}

		if (idx >= N)
			return;

		used[idx] = true;
		findMin(idx + 1, cnt + 1);

		used[idx] = false;
		findMin(idx + 1, cnt);
	}

}
