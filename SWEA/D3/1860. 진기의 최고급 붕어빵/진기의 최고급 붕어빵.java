import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int num = -K;
			int[] arrive = new int[N];
			for (int i = 0; i < N; i++) {
				arrive[i] = sc.nextInt();
			}
			Arrays.sort(arrive);
			int index = 0;
			for (int i = 0; i <= arrive[N - 1]; i++) {
				if (i % M == 0) {
					num += K;
				}
				if (arrive[index] == i) {

					num--;

					if (num < 0) {
						System.out.println("#" + t + " Impossible");
						break;
					}
					index++;
				}
			}
			if (num >= 0)
				System.out.println("#" + t + " Possible");

		}

	}

}
