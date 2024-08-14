import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] price = new int[N];
//			List<Integer> price = new LinkedList<>();
//			List<Integer> pricetmp = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				price[i] = (sc.nextInt());
			}
			int max;
			long sum = 0;
			max = price[N - 1];
			sum = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (max < price[i])
					max = price[i];
				else
					sum += max - price[i];
			}

			System.out.printf("#%d %d\n", t, sum);

		}

	}

}
