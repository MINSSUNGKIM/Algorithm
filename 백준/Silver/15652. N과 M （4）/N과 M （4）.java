import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] selected;
	static int N;
	static int M;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		selected = new int[M];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		combwithRep(0, 0);
		bw.flush();
		bw.close();
		sc.close();

	}

	static void combwithRep(int idx, int sidx) throws IOException {

		if (sidx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			bw.write(sb.toString().trim());
			bw.newLine();
			return;
		}

		for (int i = idx; i < N; i++) {

			selected[sidx] = arr[i];
			combwithRep(i, sidx + 1);
		}

	}

}