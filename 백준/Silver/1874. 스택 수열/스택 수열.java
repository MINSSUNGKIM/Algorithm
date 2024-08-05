import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();

		int value = 0;
		for (int i = 0; i < N; i++) {

			if (arr[i] > value) {

				int lastvalue = value;

				value = arr[i];

				for (int j = lastvalue + 1; j <= value; j++) {
					stack.push(j);
					sb.append("+\n");
				}
			} else if (arr[i] != stack.peek()) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append("-\n");
		}

		System.out.println(sb.toString());

		br.close();

	}

}
