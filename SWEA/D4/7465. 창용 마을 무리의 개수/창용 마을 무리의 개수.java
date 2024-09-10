import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	static int N, M;
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			parent = new int[N + 1];
			rank = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				parent[i] = i;
				rank[i] = 0;
			}

			// make set

			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				union(A, B);

			}

			HashSet<Integer> set = new HashSet<>();

			for (int i = 1; i <= N; i++) {
				set.add(findSet(i));
			}

			System.out.println("#" + t + " " + set.size());
		}

	}

	static int findSet(int x) {

		if (x != parent[x])
			parent[x] = findSet(parent[x]);

		return parent[x];

	}

	static void union(int x, int y) {
		int rX = findSet(x);
		int rY = findSet(y);

		if (rank[rX] < rank[rY]) {
			parent[rX] = parent[rY];

		} else if (rank[rX] > rank[rY]) {
			parent[rY] = parent[rX];

		} else {
			parent[rY] = parent[rX];
			rank[rY]++;
		}

	}

}