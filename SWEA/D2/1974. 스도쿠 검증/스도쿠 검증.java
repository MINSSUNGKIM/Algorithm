import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[][] sdoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}

			int boxi = 0;
			int boxj = 0;

			boolean flag = true;
			int[][][] checkarrbox = new int[3][3][9];
			out: for (int i = 0; i < 9; i++) {
				int[] checkarrrow = new int[9];
				int[] checkarrcol = new int[9];
				// 가로줄 체크
				for (int j = 0; j < 9; j++) {
					checkarrrow[sdoku[i][j] - 1]++;

				}
				int index = 0;
				while (index < 9) {
					if (checkarrrow[index++] != 1) {
						flag = false;
						break out;
					}
				}
				// 세로줄 체크
				for (int j = 0; j < 9; j++) {
					checkarrcol[sdoku[j][i] - 1]++;

				}
				index = 0;
				while (index < 9) {
					if (checkarrcol[index++] != 1) {
						flag = false;
						break out;
					}
				}

				boxi = i / 3;
				for (int j = 0; j < 9; j++) {
					boxj = j / 3;
					checkarrbox[boxi][boxj][sdoku[i][j] - 1]++;
				}

			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int index = 0;
					while (index < 9) {
						if (checkarrbox[i][j][index++] != 1) {
							flag = false;
						}
					}
				}
			}
			if (!flag) {
				System.out.println("#" + t + " " + 0);
			} else {
				System.out.println("#" + t + " " + 1);

			}

			// 박스체크

		}

	}

}