import java.util.Scanner;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static int[] selected;
	static int N;
	static int M;

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

		permutation(0);

	}

	static void permutation(int sidx) {

		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[sidx] = arr[i];
				permutation(sidx + 1);
				visited[i] = false;
			}

		}

	}
}