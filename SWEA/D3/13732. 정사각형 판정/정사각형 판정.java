import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			char[][] arr = new char[N][N];

			// input array
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					arr[r] = str.toCharArray();
				}
			} // input end

			// sum
			int sum =0;
			for(int r = 0; r < N; r++) {
				for(int c =0 ; c < N; c++) {
					if (arr[r][c]=='#') {
						sum++;
					}
				}
			}
			
			
			// searching
			int rCnt = 0;
			int cCnt = 0;
			outer: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == '#') {
						int nr = r;
						int nc = c;
						while (nc < N && arr[r][nc] == '#') {
							cCnt++;
							nc++;
						}
						while (nr < N && arr[nr][c] == '#') {
							rCnt++;
							nr++;
						}
						for (int i = r; i < r + rCnt; i++) {
							for (int j = c; j < c + cCnt; j++) {
								if (arr[i][j] != '#') {
									System.out.println("#" + tc + " no");
									break outer;
								}
							}
						}
						if (cCnt == rCnt && sum == cCnt*rCnt) {
							System.out.println("#" + tc + " yes");
							break outer;
						} else {

							System.out.println("#" + tc + " no");
							break outer;
						}
					}
				}
			}
//			if (cCnt != 1 && rCnt != 1 && cCnt == rCnt) {
//				
//				System.out.println("#" + tc + " yes");
//			} else {
//				
//				System.out.println("#" + tc + " no");
//			}

		} // tc end
	} // main end

}