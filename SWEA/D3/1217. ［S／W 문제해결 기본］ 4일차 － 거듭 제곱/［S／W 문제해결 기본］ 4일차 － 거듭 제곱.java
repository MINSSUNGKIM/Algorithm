import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();

			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + T + " " + pow(N, M));
		}

	}

	static int pow(int N, int M) {
		// 기저조건
		if (M == 1)
			return N;
		// 재귀부분 : 짝수인 경우 / 홀수인 경우
		if (M % 2 == 0) {
			return pow(N, M / 2) * pow(N, M / 2);
		} else {
			return pow(N, (M - 1) / 2) * pow(N, (M - 1) / 2) * N;
		}
	}

}
