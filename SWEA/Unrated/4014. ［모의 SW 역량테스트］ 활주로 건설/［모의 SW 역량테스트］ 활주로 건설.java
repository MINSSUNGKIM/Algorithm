
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int X = sc.nextInt();

			int[][] map = new int[N][N];
			int[][] arr = new int[2 * N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					arr[i][j] = map[i][j];
				}
			}

			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					arr[N + j][i] = map[i][j];
				}
			}

			int ans = 0;
			int realans = 0;

			for (int i = 0; i < 2 * N; i++) {
				boolean canbuild = true;
				int index = 0;
				int len = 1;
				out: while (true) {

//					if (index == N - 1) {
//						
//						} else {
//							break out;
//						}
//					}

					if (arr[i][index] + 1 == arr[i][index + 1]) {
						if (len >= X) {
							ans++;
							index ++;
							len = 1;

						} else {
							index++;
							len = 1;
							canbuild = false;
							break out;
						}

					} else if (arr[i][index] - 1 == arr[i][index + 1]) {
						len = 0;
						int tmp = 1;
						boolean flag = false;
						while (arr[i][index + 1] == arr[i][index + tmp]) {
							len++;
							if (len >= X) {
								ans++;
								index += tmp;
								len = 0;
								flag = true;
								if (index == N - 1) {
									if (arr[i][index - 1] != arr[i][index] && X != 1) {
										canbuild = false;
										break out;
									} else {
										break out;
									}
								}
								break;
							}
							tmp++;
							if (index + tmp >= N) {
								canbuild = false;
								break out;
							}

						}
						if (!flag) {
							index++;
							len = 0;
							canbuild = false;
							break out;
						}

					} else if (arr[i][index] == arr[i][index + 1]) {
						index++;
						len++;
					} else {
						index++;
						len = 0;
						canbuild = false;
						break out;

					}

					if (index >= N - 1)
						break;

				}
				if (canbuild) {
					realans++;
				}

			}
			System.out.println("#" + t + " " + realans);

		}
	}

}
