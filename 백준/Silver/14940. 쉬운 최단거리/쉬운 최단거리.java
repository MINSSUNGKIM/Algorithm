import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] result = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					visited[i][j] = true;
					result[i][j] = 0;
					queue.add(new int[] { i, j, 0 });

				}
			}
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {

			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				result[nr][nc] = tmp[2] + 1;
				queue.offer(new int[] { nr, nc, tmp[2] + 1 });

			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (result[i][j] == 0 && arr[i][j] == 1) {
					result[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			System.out.println(sb.toString());

		}

	}

}