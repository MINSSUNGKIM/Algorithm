import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int opt = Integer.parseInt(st.nextToken());
			switch (opt) {
				case 0:

					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;

				case 1:

					boolean flag = (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())));
					String ans =
						flag ? "YES" : "NO";
					System.out.println(ans);
			}
		}

	}

	private static int find(int a) {

		if (parent[a] == a)
			return a;

		return parent[a]=find(parent[a]);

	}

	private static void union(int a, int b) {

		a = find(a);
		b = find(b);
		if(a!=b)
			parent[a] = b;

	}

}
