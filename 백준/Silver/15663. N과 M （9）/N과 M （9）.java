import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);
        System.out.print(sb);
        
    }

    static void dfs(int depth){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i=0; i<N; i++){
            if(!visited[i] && numbers[i] != before){
                visited[i] =true;
                arr[depth] = numbers[i];
                before = numbers[i];

                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}