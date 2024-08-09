import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			char[][] arr = new char[N][M];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int min = Integer.MAX_VALUE;
			for (int a = 0; a <= N - 3; a++) {
				for (int b = a + 1; b <= N - 2; b++) {
					int cnt = 0;
					for (int i = 0; i <= a; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'W')
								cnt++; 
						}
					}
					for (int i = a + 1; i <= b; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'B')
								cnt++;
						}
					}
					for (int i = b + 1; i <= N - 1; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'R')
								cnt++;
						}
					}

					if (cnt < min)
						min = cnt;

				}
			}

			System.out.println("#" + t + " " + min);
		}
	}

}
