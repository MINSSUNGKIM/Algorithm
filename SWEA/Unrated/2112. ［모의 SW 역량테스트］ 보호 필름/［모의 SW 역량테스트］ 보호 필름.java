import java.util.Scanner;

public class Solution {
	static int[][] film;
	static int D, W, K;

	static int ans; // 최소 투약 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}

			ans = K;// 통과 기준인 K 만큼 쏠 수 있으므로.
			makefilm(0, 0);
			System.out.println("#" + t + " " + ans);

		} // tc
	}// main

	// idx : 약 주입 행
	// cnt : 약 주입 횟수
	private static void makefilm(int idx, int cnt) {

		if (idx == D) {
			if (vaildate())
				ans = Math.min(ans, cnt);
			return;
		}

		// 1.주입 X
		makefilm(idx + 1, cnt);

		// 원본 복사
		int[] tmp = new int[W];
		for (int i = 0; i < W; i++) {
			tmp[i] = film[idx][i];
		}

		// 2.주입 A
		yak(idx, 0);
		makefilm(idx + 1, cnt + 1);

		// 3.주입 B
		yak(idx, 1);
		makefilm(idx + 1, cnt + 1);

		// 원상복구 과정 필요 함 약품이 주입되며 film 이 바뀌므로.
		for (int i = 0; i < W; i++) {
			film[idx][i] = tmp[i];
		}
	}

	static void yak(int r, int drug) {
		for (int i = 0; i < W; i++) {
			film[r][i] = drug;
		}
	}

	// 모든 열의 연속된 특성이 K개 이상인가?
	static boolean vaildate() {
		// 열을 고정 시킨 상태에서 먼저 검사를 하겠다.
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;

			for (int r = 1; r < D; r++) {
				// 인덱스 에러처리를 잘 봐둬라!
				if (film[r][c] == film[r - 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt == K) {
					flag = true;
					break;

				}
			} // 해당열 검사 완료

			// 해당열 통과 못했으면 다음열 볼 필요 없다.
			if (!flag)
				return false;

		}
		return true;

	}

}