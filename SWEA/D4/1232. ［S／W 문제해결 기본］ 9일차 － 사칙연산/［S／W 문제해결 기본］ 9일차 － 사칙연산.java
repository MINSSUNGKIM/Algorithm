
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			String[][] tree = new String[N + 1][3];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();

				tree[i][0] = st.nextToken();
				if (st.hasMoreElements()) {
					tree[i][1] = st.nextToken();
					tree[i][2] = st.nextToken();
				}

			}

			System.out.println("#" + t + " " + cala(tree, 1));

		}

	}

	static int cala(String[][] tree, int root) {
		if (tree[root][1] == null) {

			return Integer.parseInt(tree[root][0]);
		}
		if (tree[root][0].equals("-")) {
			return cala(tree, Integer.parseInt(tree[root][1])) - (cala(tree, Integer.parseInt(tree[root][2])));
		} else if (tree[root][0].equals("+")) {
			return cala(tree, Integer.parseInt(tree[root][1])) + (cala(tree, Integer.parseInt(tree[root][2])));
		} else if (tree[root][0].equals("*")) {
			return cala(tree, Integer.parseInt(tree[root][1])) * (cala(tree, Integer.parseInt(tree[root][2])));
		} else {
			return cala(tree, Integer.parseInt(tree[root][1])) / (cala(tree, Integer.parseInt(tree[root][2])));
		}

	}

}
