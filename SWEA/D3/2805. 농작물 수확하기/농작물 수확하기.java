import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int mid = N / 2;
			int sum = 0;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (Math.abs(mid - i) + Math.abs(mid - j) <= N / 2) {
						//중심으로부터 거리가 조건을 만족 하는 값 이하일 때만 저장.
						sum += map[i][j];
					}
				}
			}

			System.out.println("#" + t + " " + sum);
		}

	}

}
