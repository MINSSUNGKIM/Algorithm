import java.util.Scanner;

public class Solution {
	static boolean[] used;
	static int[] arr;
	static int ans;
	static int K;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();

			used = new boolean[N];
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			powerset(0);
			System.out.println("#" + t + " " + ans);
			ans = 0;

		}

	}

	static void powerset(int idx) {
		// base
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (used[i])
					sum += arr[i];
			}
			if (sum == K)
				ans++;

			return;
		}

		used[idx] = true;
		powerset(idx + 1);

		used[idx] = false;
		powerset(idx + 1);

	}

}
