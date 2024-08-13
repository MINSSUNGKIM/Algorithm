import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			List<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				switch (st.nextToken().charAt(0)) {
				case 'I':
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}

					break;
				case 'D':

					int x2 = Integer.parseInt(st.nextToken());
					int y2 = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y2; j++) {

						list.remove(x2);
					}
					break;
				case 'A':

					int y3 = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y3; j++) {

						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.println(sb.toString().trim());
		}

	}

}
