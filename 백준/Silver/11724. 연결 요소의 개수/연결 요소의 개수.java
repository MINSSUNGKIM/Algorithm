import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Integer>[] graph;

    graph = new List[N+1];
    for(int i=0; i<N+1; i++){
      graph[i] = new LinkedList<>();
    }

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    boolean[] visited = new boolean[N+1];

   int ans = 0;

    for(int i=1; i<N+1; i++){
      if(!visited[i]){
        ans++;
        dfs(i,graph,visited);
      }
    }

    System.out.println(ans);
    
  }

  static void dfs(int vertex,List<Integer>[] graph,boolean[] visited){

    visited[vertex] = true;

    for(int next : graph[vertex]){
      
      if(!visited[next]){
        dfs(next,graph,visited);
      }
    }
    
   
  }
}
