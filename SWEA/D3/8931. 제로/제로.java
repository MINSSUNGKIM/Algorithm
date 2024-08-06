import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			Stack<Integer> stack = new Stack<>();
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {

				int input = sc.nextInt();

				if (input == 0) {
					stack.pop();
					continue;
				}

				stack.push(input);

			}

			int ans = 0;
			int k = stack.size();

			if (stack.empty())
				ans = 0;
			else {
				for (int i = 0; i < k; i++) {
					ans += stack.pop();
				}
			}
			System.out.println("#" + t + " " + ans);

		}

	}

}
