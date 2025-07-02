import java.util.*;
import java.io.*;


public class Main{
    static int N;
    static List<Edge>[] adj;
    static int maxDistance = -1;
    static int farthestNode = -1;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 인접 리스트로 트리 구성
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            // 양방향 간선 추가
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }
        
        // 트리의 지름 구하기
        // 1단계: 1번 노드에서 가장 먼 노드 찾기
        boolean[] visited = new boolean[N+1];
        dfs(1, 0, visited);
        
        // 2단계: 찾은 노드에서 다시 가장 먼 노드 찾기
        visited = new boolean[N+1];
        maxDistance = -1;
        dfs(farthestNode, 0, visited);
        
        System.out.println(maxDistance);
    }
    
    static void dfs(int node, int distance, boolean[] visited){
        visited[node] = true;
        
        if(distance > maxDistance){
            maxDistance = distance;
            farthestNode = node;
        }
        
        for(Edge edge : adj[node]){
            if(!visited[edge.to]){
                dfs(edge.to, distance + edge.weight, visited);
            }
        }
    }
    
   static class Edge {
    int to, weight;
    
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

}