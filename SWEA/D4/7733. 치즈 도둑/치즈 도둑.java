import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] cheese;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			cheese = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			ans = -987654321;
			for (int day = 0; day <= 100; day++) {
				visited = new boolean[N][N];
				int bulk = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {

						if (!visited[i][j] && cheese[i][j] > day) {
							bulk++;
							bfs(i, j, day);
						}
						if (ans < bulk)
							ans = bulk;
					}

				}
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	static boolean[][] visited;
	static int ans;
	static int bulk;

	private static void bfs(int row, int col, int day) {

		Queue<int[]> queue = new LinkedList<>();
		visited[row][col] = true;
		queue.offer(new int[] { row, col });

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || cheese[nr][nc] <= day)
					continue;

				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });

			}
		}

	}

}