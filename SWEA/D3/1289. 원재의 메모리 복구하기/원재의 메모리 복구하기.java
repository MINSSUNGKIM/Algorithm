import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			boolean[] arr = new boolean[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) == '1' ? false : true;
			}

			int ans = 0;
			for (int i = 0; i < str.length(); i++) {
				if (arr[i])
					continue;
				else {
					int j = 0;
					while (i + j < str.length()) {
						arr[i + j] = !arr[i + j];
						j++;
					}
					ans++;

				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}

	}

}
