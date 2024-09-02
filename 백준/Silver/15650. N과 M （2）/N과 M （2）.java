import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	static int[] arr;
	static boolean[] visited;
	static int[] selected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		visited = new boolean[N];
		selected = new int[M];

		combination(0, 0);

	}

	static void combination(int idx, int sidx) {
		// 기저
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[sidx] = arr[i];
				combination(i, sidx + 1);
				visited[i] = false;
			}
		}
	}

}