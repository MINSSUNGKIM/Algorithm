import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int[][] tree;  //  왼쪽  오른쪽 자식
    static int[] parent;  // 각 노드의 부모
    static boolean[] visited;
    static int size;  // 서브트리 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 초기화
            tree = new int[V + 1][2];  // 각 노드당 최대 2개의 자식
            parent = new int[V + 1];
            visited = new boolean[V + 1];
            
            // 간선 정보 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                if (tree[p][0] == 0) {  // 왼쪽 자식이 비어있으면
                    tree[p][0] = c;
                } else {  // 왼쪽 자식이 있으면 오른쪽 자식으로
                    tree[p][1] = c;
                }
                parent[c] = p;
            }

            // 공통 조상 찾기
            int commonAncestor = findCommonAncestor(a, b);
            
            // 서브트리 크기 계산
            size = 0;
            dfs(commonAncestor);

            System.out.println("#" + t + " " + commonAncestor + " " + size);
        }
    }

    // 두 노드의 공통 조상을 찾는 메서드
    private static int findCommonAncestor(int a, int b) {
        Set<Integer> ancestorsA = new HashSet<>();
        
        // a의 모든 조상을 저장
        int current = a;
        while (current != 0) {
            ancestorsA.add(current);
            current = parent[current];
        }

        // b에서 시작해서 처음 만나는 a의 조상이 최소 공통 조상
        current = b;
        while (!ancestorsA.contains(current)) {
            current = parent[current];
        }
        
        return current;
    }

    private static void dfs(int node) {
        visited[node] = true;
        size++;

        // 왼쪽 자식 확인
        if (tree[node][0] != 0 && !visited[tree[node][0]]) {
            dfs(tree[node][0]);
        }
        // 오른쪽 자식 확인
        if (tree[node][1] != 0 && !visited[tree[node][1]]) {
            dfs(tree[node][1]);
        }
    }
}