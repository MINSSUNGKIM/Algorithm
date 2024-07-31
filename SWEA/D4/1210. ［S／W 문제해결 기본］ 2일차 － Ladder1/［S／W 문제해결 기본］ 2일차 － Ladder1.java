import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			int[][] visited = new int[100][100];
			int x = 0;
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 2)
						x = c;
				}
			}
			// 우,좌,상
			int[] dr = { 0, 0, -1 };
			int[] dc = { 1, -1, 0 };
			int nr = 99;
			int nc = x;
			while (nr != 0) {

				for (int i = 0; i < 3; i++) {
					if (nc + dc[i] < 100 && nc + dc[i] >= 0 && map[nr + dr[i]][nc + dc[i]] == 1
							&& visited[nr + dr[i]][nc + dc[i]] != 1) {

						nr += dr[i];
						nc += dc[i];
						visited[nr][nc] = 1;
						break;
					}
				}

			}
			System.out.println("#" + T + " " + nc);
		}
	}

}
