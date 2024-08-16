
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String[][] tree = new String[N + 1][3];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i][0] = st.nextToken();
				if (st.hasMoreTokens()) {
					tree[i][1] = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tree[i][2] = st.nextToken();
				}
			}
			System.out.print("#" + t + " ");
			inorder(tree, "1");
			System.out.println();
		}

	}

	static void inorder(String[][] tree, String root) {
		int rootI = Integer.parseInt(root);
		if (tree[rootI][1] == null) {
			System.out.print(tree[rootI][0]);
			return;
		} else if (tree[rootI][1] != null && tree[rootI][2] != null) {
			inorder(tree, tree[rootI][1]);
			System.out.print(tree[rootI][0]);
			inorder(tree, tree[rootI][2]);

		} else if (tree[rootI][1] != null && tree[rootI][2] == null) {
			inorder(tree, tree[rootI][1]);
			System.out.print(tree[rootI][0]);

		} else if (tree[rootI][1] == null && tree[rootI][2] != null) {
			System.out.print(tree[rootI][0]);
			inorder(tree, tree[rootI][2]);

		}

	}

}
