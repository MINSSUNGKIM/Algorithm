import java.util.Scanner;

public class Main {

	static int zero;
	static int one;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[][] dp = new int[41][2];

		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			zero = dp[N][0];
			one = dp[N][1];
			StringBuilder sb = new StringBuilder();
			sb.append(zero).append(" ").append(one);
			System.out.println(sb.toString());

		}

	}

	public static int fibo(int n) {
		if (n == 0) {
			zero++;
			return 0;
		} else if (n == 1) {
			one++;
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}

	}

}