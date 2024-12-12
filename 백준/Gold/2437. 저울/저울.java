import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> chu = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			chu.add(Integer.parseInt(st.nextToken()));
		}
		chu.sort(null);
		int sum = 0;
		for (int k : chu) {
			if (k > sum + 1) {
				break;
			}

			sum += k;
		}

		System.out.println(sum + 1);

	}
}