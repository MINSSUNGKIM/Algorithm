import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 입력 받으면서 바로 정렬해주는 treeset 이용
		TreeSet<int[]> drawLine = new TreeSet<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}

		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			drawLine.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 새로운 선분이 생기는 경우 or 기존 선분이 확장되는 경우로 나뉨
		int[] init = drawLine.pollFirst();
		int first = init[0];
		int last = init[1];

		int ans = 0;
		while (!drawLine.isEmpty()) {

			int tmp[] = drawLine.pollFirst();
			// 1.기존 선분 확장
			if (last >= tmp[0]) {
				last = Math.max(last, tmp[1]);
			}
			// 2. 새로운 선분이 만들어 질 때 -> 답 갱신
			if (last < tmp[0]) {
				ans += last - first;

				first = tmp[0];
				last = tmp[1];

			}

		}
		ans += last - first;

		System.out.println(ans);
	}

}