import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int P = Integer.parseInt(st1.nextToken());
		// n개의 스택을 만들고 초기화
		Stack<Integer>[] stack = (Stack<Integer>[]) new Stack[N + 1];
		for (int i = 0; i < N + 1; i++) {
			stack[i] = new Stack<>();
		}

		int[] maxP = new int[N + 1];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			if (stack[n].empty()) {
				stack[n].push(p);
				cnt++;
			} else if (stack[n].peek() < p) {
				stack[n].push(p);
				cnt++;
			} else if (stack[n].peek() > p) {
				while (stack[n].peek() > p) {
					stack[n].pop();
					cnt++;
					if (stack[n].empty()) {
						stack[n].push(p);
						cnt++;
						break;
					}

					if (stack[n].peek() == p)
						break;
					else if (stack[n].peek() < p) {
						stack[n].push(p);
						cnt++;
						break;
					}
				}
			}

		}

		System.out.println(cnt);

	}

}
