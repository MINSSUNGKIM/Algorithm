import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] tomato = new int[M][N];
		boolean[][] visited = new boolean[M][N];

		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int day = 0;
		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			day = info[2];
			for (int i = 0; i < 4; i++) {
				int nr = info[0] + dr[i];
				int nc = info[1] + dc[i];

				if (nr < 0 || nr >= M || nc < 0 || nc >= N || tomato[nr][nc] == 1 || tomato[nr][nc] == -1)
					continue;

				tomato[nr][nc] = 1;
				queue.offer(new int[] { nr, nc, day + 1 });

			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}

			}
		}

		System.out.println(day);

	}

}