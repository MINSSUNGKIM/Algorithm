import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {

				if (a[0] == b[0]) {
					return a[1] - b[1];
				}

				return a[0] - b[0];

			}
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

		}

		PriorityQueue<Integer> classRoom = new PriorityQueue<>();

		classRoom.offer(0);

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();

			if (classRoom.peek() > tmp[0]) {
				classRoom.offer(tmp[1]);

			} else {
				classRoom.poll();
				classRoom.offer(tmp[1]);
			}

		}
		
		System.out.println(classRoom.size());

	}

}