import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static Integer[] arr;
	static int[] selected;
	static boolean[] visited;

	static int N;
	static int M;
	static int size;

	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		size = set.size();

		arr = set.toArray(new Integer[0]);

		Arrays.sort(arr);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		permuWitRep(0);
		bw.flush();
		bw.close();

	}

	static void permuWitRep(int sidx) throws IOException {
		if (sidx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			bw.write(sb.toString().trim());
			bw.newLine();
			return;
		}

		for (int i = 0; i < size; i++) {
			selected[sidx] = arr[i];
			permuWitRep(sidx + 1);
		}
	}

}