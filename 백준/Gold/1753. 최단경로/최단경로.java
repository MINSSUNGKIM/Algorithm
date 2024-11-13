import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class NodeNode implements Comparable<NodeNode> {
	int end;
	int weight;

	public NodeNode(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(NodeNode o) {
		return this.weight - o.weight;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		int start = sc.nextInt(); // 시작 정점

		ArrayList<NodeNode>[] graph = new ArrayList[V + 1];

		// 그래프 초기화
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			graph[u].add(new NodeNode(v, w));
		}

		// 최단 경로 계산
		int[] result = dist(graph, start, V);

		// 결과 출력
		for (int i = 1; i <= V; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(result[i]);
			}
		}
	}

	public static int[] dist(ArrayList<NodeNode>[] graph, int start, int V) {
		int[] result = new int[V + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start] = 0;

		PriorityQueue<NodeNode> pq = new PriorityQueue<>();
		pq.add(new NodeNode(start, 0));

		while (!pq.isEmpty()) {
			NodeNode current = pq.poll();

			// 현재 거리가 이미 저장된 거리보다 크면 스킵
			if (result[current.end] < current.weight)
				continue;

			// 현재 노드와 연결된 모든 노드들을 확인
			for (NodeNode next : graph[current.end]) {
				int newDist = next.weight + result[current.end];

				if (newDist < result[next.end]) {
					result[next.end] = newDist;
					pq.offer(new NodeNode(next.end, newDist));
				}
			}
		}

		return result;
	}
}