import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int lastItem = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String opt = st.nextToken();
			switch (opt) {

			case "push":
				lastItem = Integer.parseInt(st.nextToken());
				queue.add(lastItem);

				break;
			case "pop":
				System.out.println(queue.size() == 0 ? -1 : queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(queue.size() == 0 ? -1 : queue.peek());

				break;
			case "back":
				System.out.println(queue.size() == 0 ? -1 : lastItem);
				break;

			}
		}

	}

}
