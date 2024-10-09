import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		PriorityQueue<int[]> pq = new PriorityQueue<>(

				 (a, b) -> {
		                // 종료 시간을 기준으로 오름차순 정렬
		                if (a[1] != b[1]) {
		                    return a[1] - b[1];
		                }
		                // 종료 시간이 같으면 시작 시간을 기준으로 오름차순 정렬
		                return a[0] - b[0];
		            }

		);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			pq.add(new int[] { sc.nextInt(), sc.nextInt() });

		}
		
		
		int last = pq.poll()[1];
		int ans = 1;
		for (int i = 0; i < N - 1; i++) {
			int[] tmp = pq.poll();
			if (tmp[0] >= last) {
				last = tmp[1];
				ans++;
			}
		}

		System.out.println(ans);
	}

}