import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] size; // 각 노드의 서브트리 크기를 저장
    static boolean[] visited;

    // DFS로 서브트리 크기 계산
    static int dfs(int current) {
        visited[current] = true;
        size[current] = 1; // 자기 자신 포함

        for (int next : tree.get(current)) {
            if (!visited[next]) {
                size[current] += dfs(next);
            }
        }
        return size[current];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();

        // 초기화
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        size = new int[N + 1];
        visited = new boolean[N + 1];

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            int U = sc.nextInt();
            int V = sc.nextInt();
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        // 루트(R)에서 시작하여 전체 트리의 크기 계산
        dfs(R);

        // 쿼리 처리
        for (int i = 0; i < Q; i++) {
            int query = sc.nextInt();
            System.out.println(size[query]);
        }
    }
}