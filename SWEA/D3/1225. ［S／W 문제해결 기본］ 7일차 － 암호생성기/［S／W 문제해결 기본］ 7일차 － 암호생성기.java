import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < 8; i++)
				queue.add(Integer.parseInt(st.nextToken()));

			out: while (queue.peek() != 0) {
				for (int i = 1; i <= 5; i++) {
					int changeNum = queue.poll();
					if (changeNum - i <= 0) {
						queue.add(0);
						break out;
					}
					queue.add(changeNum - i);
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			while (!queue.isEmpty())
				sb.append(" ").append(queue.poll());

			System.out.println(sb.toString());
		}
	}

}
