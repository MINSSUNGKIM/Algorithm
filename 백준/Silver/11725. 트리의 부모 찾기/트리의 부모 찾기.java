import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new LinkedList[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];

        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int neighbor : graph[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }
    }
}