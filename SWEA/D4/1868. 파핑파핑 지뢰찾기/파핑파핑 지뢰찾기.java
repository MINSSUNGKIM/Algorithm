import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static char[][] board;
	static int[][] mineCount; 
	static boolean[][] visited;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 }; 
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			mineCount = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			countMines();

			// 클릭 횟수 계산
			int clicks = countClicks();

			System.out.println("#" + t + " " + clicks);
		}
	}

	// 각 칸 주변의 지뢰 개수
	static void countMines() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '.') {
					int count = 0;
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == '*') {
							count++;
						}
					}
					mineCount[i][j] = count;
				}
			}
		}
	}

	
	static int countClicks() {
		int clicks = 0;

		// 0을 먼저 클릭
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] == '.' && mineCount[i][j] == 0) {
					clicks++;
					bfs(i, j);
				}
			}
		}

		// 남은 칸 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] == '.') {
					clicks++;
				}
			}
		}

		return clicks;
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == '.') {
					visited[nx][ny] = true;
					if (mineCount[nx][ny] == 0) {
						queue.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}
}