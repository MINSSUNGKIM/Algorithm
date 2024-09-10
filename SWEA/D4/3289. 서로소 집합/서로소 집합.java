import java.util.Scanner;

public class Solution {
	static int n, m;
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();

			parent = new int[n + 1];
			rank = new int[n + 1];

			// make - set
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				int opt = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				if (opt == 1) {
					if (findSet(A) == findSet(B)) {
						sb.append(1);
					} else
						sb.append(0);
				} else {
					union(A, B);
				}

			}

			System.out.println(sb.toString());
		}
	}

	static int findSet(int x) {

		if (x != parent[x])
			parent[x] = findSet(parent[x]);

		return parent[x];
	}

	static void union(int x, int y) {

		int rootX = findSet(x);
		int rootY = findSet(y);

		if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;

		} else if (rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		} else {
			rank[rootX]++;
			parent[rootY] = rootX;
		}

	}

}