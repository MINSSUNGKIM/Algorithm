import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();

			int[][] map = new int[N][N];
			int[][] stairs = new int[2][3];

			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						num++;
					}
				}
			}
			int idx = 0;
			int idx2 = 0;
			int[][] people = new int[num][4];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						people[idx][0] = i;
						people[idx][1] = j;
						people[idx][2] = -1;
						idx++;
						continue;
					}
					if (map[i][j] != 0) {
						stairs[idx2][0] = i;
						stairs[idx2][1] = j;
						stairs[idx2][2] = map[i][j];
						idx2++;
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << num); i++) {
				for (int j = 0; j < num; j++) {
					if ((i & (1 << j)) > 0) {
						people[j][2] = 0;
						people[j][3] = Math.abs(people[j][0] - stairs[0][0]) + Math.abs(people[j][1] - stairs[0][1]);
					} else {
						people[j][2] = 1;
						people[j][3] = Math.abs(people[j][0] - stairs[1][0]) + Math.abs(people[j][1] - stairs[1][1]);
					}
				}
				int time = 0;

				int staA = 0;
				int staB = 0;
				int cnt = num;

				Queue<Integer> Atime = new LinkedList<>();
				Queue<Integer> Btime = new LinkedList<>();

				while (true) {
					time++;

					if (staA > 0 && Atime.peek() == time) {
						while (Atime.peek() == time) {
							Atime.poll();
							staA--;

							if (staA == 0 || Atime.size() == 0)
								break;

						}
					}
					if (staB > 0 && Btime.peek() == time) {
						while (Btime.peek() == time) {
							Btime.poll();
							staB--;

							if (staB == 0 || Btime.size() == 0)
								break;

						}
					}
					for (int j = 0; j < num; j++) {
						if (people[j][3] > 0) {
							people[j][3]--;
						} else if (people[j][3] == 0) {
							if (people[j][2] == 0 && staA < 3) {

								staA++;
								people[j][3] = -1;
								cnt--;
								Atime.add(time + stairs[0][2]);
							} else if (people[j][2] == 1 && staB < 3) {

								staB++;
								people[j][3] = -1;
								cnt--;
								Btime.add(time + stairs[1][2]);
							}
						}
					}

					if (cnt == 0 && staA == 0 && staB == 0)
						break;
				}

				if (ans > time)
					ans = time;

			}
			System.out.println("#" + t + " " + ans);

		}

	}

}