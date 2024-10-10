import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<Integer> hashset = new HashSet<>();

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String opt = st.nextToken();

			int k = 0;
			if (!opt.equals("all") && !opt.equals("empty")) {

				k = Integer.parseInt(st.nextToken());
			}

			switch (opt) {
			case "add":
				hashset.add(k);
				break;
			case "remove":
				hashset.remove(k);
				break;
			case "check":
				if (hashset.contains(k)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				if (hashset.contains(k)) {
					hashset.remove(k);
				} else {
					hashset.add(k);
				}
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					hashset.add(j);
				}
				break;
			case "empty":
				hashset.clear();

				break;
			}

		}
		System.out.println(sb.toString());

	}

}