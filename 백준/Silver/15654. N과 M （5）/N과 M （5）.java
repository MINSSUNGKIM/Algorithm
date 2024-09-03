import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] arr;
	static int[] selected;

	static boolean[] visited;

	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new int[N];
		visited = new boolean[N];
		selected = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		permutation(0);
		bw.flush();
		bw.close();

	}

	static void permutation(int sidx) throws IOException {

		if (sidx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			bw.write(sb.toString().trim());
			bw.newLine();
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