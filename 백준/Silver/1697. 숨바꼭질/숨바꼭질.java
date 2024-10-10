import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { N, 0 });
		boolean[] visited = new boolean[100001];
		visited[N] = true;

		while (queue.peek()[0] != K) {

			int[] tmp = queue.poll();

			if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {

				visited[tmp[0] - 1] = true;
				queue.add(new int[] { tmp[0] - 1, tmp[1] + 1 });

			}

			if (tmp[0] + 1 <= 100000 && !visited[tmp[0] + 1]) {

				visited[tmp[0] + 1] = true;
				queue.add(new int[] { tmp[0] + 1, tmp[1] + 1 });

			}

			if (tmp[0] * 2 <= 100000 && !visited[tmp[0] * 2]) {

				visited[tmp[0] * 2] = true;
				queue.add(new int[] { tmp[0] * 2, tmp[1] + 1 });

			}

		}

		System.out.println(queue.poll()[1]);

	}

}