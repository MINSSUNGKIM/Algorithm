import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();

		int[] arr = new int[W + 1];

		for (int i = 1; i <= W; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for (int j = 1; j <= H; j++) {
			int first = Integer.MAX_VALUE;
			int last = Integer.MIN_VALUE;
			int cnt = 0;
			boolean flag = false;
			for (int i = 1; i <= W; i++) {
				if (arr[i] >= j) {
					flag = true;
					cnt++;
					if (i <= first)
						first = i;
					if (i >= last)
						last = i;
				}
			}
			if (flag)
				ans += last - first - cnt + 1;

		}

		System.out.println(ans);
	}

}
