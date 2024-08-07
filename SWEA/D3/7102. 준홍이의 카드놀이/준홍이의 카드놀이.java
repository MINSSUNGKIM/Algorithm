import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] count = new int[N + M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					count[i + j]++;
				}
			}

			int max = -1;
			for (int i = 0; i < M + N + 1; i++) {

				if (max < count[i]) {
					max = count[i];
				}
			}
			int cnt = 0;
			for (int i = 0; i < M + N + 1; i++) {
				if (max == count[i])
					cnt++;
			}
			int[] ans = new int[cnt];
			int index = 0;
			for (int i = 0; i < M + N + 1; i++) {
				if (max == count[i]) {
					ans[index++] = i;
				}
			}

			System.out.print("#" + t );
			for (int i = 0; i < ans.length; i++) {
				System.out.print(" "+ans[i]);
			}
			System.out.println();

		}

	}

}
