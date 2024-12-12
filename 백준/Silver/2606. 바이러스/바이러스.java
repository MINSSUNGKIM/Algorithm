import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}

		boolean[] visited = new boolean[N + 1];

		visited[1] = true;

		List<Integer> list = new ArrayList<>();
		list.add(1);
		for (int i = 1; i <= N; i++) {
			if (adjMatrix[1][i] == 1) {
				list.add(i);
				visited[i] = true;
			}
		}

		while (!list.isEmpty()) {
			int tmp = list.remove(0);

			for (int i = 1; i <= N; i++) {
				if (adjMatrix[tmp][i] == 1 && !visited[i]) {
					list.add(i);
					visited[i] = true;
				}
			}

		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == true)
				ans++;

		}

		System.out.println(ans-1);

	}

}