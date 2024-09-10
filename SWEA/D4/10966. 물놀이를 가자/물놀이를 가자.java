import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N, M;
	static int[][] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			arr = new int[N][M];
			String str;
			for (int i = 0; i < N; i++) {
				str = sc.next();
				for (int j = 0; j < M; j++) {
					if (str.charAt(j) == 'W')
						arr[i][j] = 1;
					else
						arr[i][j] = 0;
				}
			}
			ans = 0;
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans += dist[i][j];
				}
			}
			System.out.println("#" + t + " " + ans);

		} // tc

	}

	static int[][] dist;

	static boolean[][] visited = new boolean[N][M];
	static int ans;

	private static void bfs() {
		visited = new boolean[N][M];
		dist = new int[N][M];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					visited[i][j] = true;
					dist[i][j] = 0;
					queue.offer(new int[] { i, j, 0 });
				} else
					dist[i][j] = Integer.MAX_VALUE;
			}
		}

		out: while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int l = curr[2];

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;

				dist[nr][nc] = Math.min(dist[nr][nc], l + 1);
				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, l + 1 });

			}

		}

	}

}