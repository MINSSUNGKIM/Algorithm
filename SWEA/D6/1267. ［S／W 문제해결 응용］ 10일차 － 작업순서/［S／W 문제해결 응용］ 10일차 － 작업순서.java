import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int V = sc.nextInt(); // 정점의 개수 (1번부터 시작)
			int E = sc.nextInt(); // 간선의 개수
			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1]; // 진입차수를 저장할 배열
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adjArr[A][B] = 1; // 가중치는 따로 없으니까 1로 표기
				degree[B]++;// 진입차수를 증가!

			}
			// 위상정렬 큐 1장 : 진입차수가 0인 친구들을 몽땅 넣어라
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			// 위상정렬 큐 2장 : 큐가 공백상태가 될때까지 진행
			// 간선을 제거하고, 진입차수가 0이되면 새롭게 큐에 넣는다.
			while (!queue.isEmpty()) {
				int curr = queue.poll();

//			System.out.println(cook[curr]); //위상정렬 수행한 결과
				sb.append(curr).append(" ");
				for (int i = 1; i < V + 1; i++) {
					// 무향에선 인덱스의 순서가 중요치 않아!
					// 유향에선 인덱스의 순서가 중요하다
					if (adjArr[curr][i] == 1) {
						degree[i]--; // 진입차수 하나 깎아.
						adjArr[curr][i] = 0; // 이거 사실 안해도 괜찮아!
						// 만약 이번에 i 정점의 진입차수가 0이 되었다면..
						if (degree[i] == 0)
							queue.add(i);
					}
				}
			}

			System.out.println(sb);
		}

		// 밑에서 한방에 출력을 하고싶다!

	}

}