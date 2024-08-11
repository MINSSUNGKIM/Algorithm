import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int index = 0;
			int[] combarr = new int[N * (N - 1) / 2];
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					combarr[index++] = arr[i] * arr[j];
				}
			}

			Arrays.sort(combarr);
			boolean flag = false;

			for (int i = combarr.length - 1; i >= 0; i--) {
				if (increasing(combarr[i])) {
					System.out.println("#" + t + " " + combarr[i]);
					flag = true;
					break;

				}
			}
			if (!flag) {
				System.out.println("#" + t + " -1");
			}

		}

		sc.close();

	}

	static boolean increasing(int N) {

		while (N / 10 != 0) {
			int a = N % 10;
			N /= 10;
			int b = N % 10;
			if (a < b) {
				return false;
			}
		}

		return true;

	}

}
