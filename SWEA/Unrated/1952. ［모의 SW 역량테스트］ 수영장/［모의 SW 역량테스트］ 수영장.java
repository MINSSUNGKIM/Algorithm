import java.util.Scanner;

public class Solution {
	static int[] info = new int[12];

	static int[] arr = new int[15];

	static int D;
	static int M;
	static int T;
	static int Y;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();

		for (int t = 1; t <= Tc; t++) {
			D = sc.nextInt();
			M = sc.nextInt();
			T = sc.nextInt();
			Y = sc.nextInt();

			for (int i = 0; i < 12; i++) {
				info[i] = sc.nextInt();
			}

			ans = Integer.MAX_VALUE;
			permuWithRep(0);

			if (ans > Y)
				System.out.println("#" + t + " " + Y);
			else
				System.out.println("#" + t + " " + ans);

		} // tc
	}

	static void permuWithRep(int idx) {
		if (idx >= 12) {
			int sum = 0;
			for (int i = 0; i < 12; i++) {
				if (arr[i] == 1)
					sum += D * info[i];
				else if (arr[i] == 2)
					sum += M;
				else if (arr[i] == 3)
					sum += T;
			}

			if (ans > sum)
				ans = sum;
			return;
		}

		if (info[idx] == 0) {
			permuWithRep(idx + 1);
			return;
		}

		for (int i = 1; i <= 2; i++) {

			if (i == 1) {
				// 월별 이용권이 더 싸면 월별권 체크 후 다음달로
				if (info[idx] * D < M) {

					arr[idx] = 1;
					permuWithRep(idx + 1);
					arr[idx] = 0;
				} else {
					// 일일권이 더 싸면 일일권 체크후 다음달로
					arr[idx] = 2;
					permuWithRep(idx + 1);
					arr[idx] = 0;

				}
			} else if (i == 2) {

				arr[idx] = 3;
				arr[idx + 1] = 0;
				arr[idx + 2] = 0;
				permuWithRep(idx + 3);
				arr[idx] = 0;
			}

		}
	}

}
