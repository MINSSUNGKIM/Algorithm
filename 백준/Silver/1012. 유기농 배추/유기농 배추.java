import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T;
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    for(int t=1; t<=T; t++){
      int N,M,K;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      int[][] arr = new int[N][M];

      for(int i=0; i<K; i++){
        st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        arr[r][c] = 1;
      }

      boolean[][] visited = new boolean[N][M];
      int ans = 0;
      for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){

          if(!visited[i][j] && arr[i][j] ==1 ){
            ans++;
            dfs(arr,i,j, visited);
          }
          
        }
      }
      System.out.println(ans);
      
      
    }
    
  }

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  
  static void dfs (int[][] arr, int r, int c, boolean[][] visited){

    visited[r][c] = true;
    
    for(int i=0; i<4; i++){
      int nr = r+dr[i];
      int nc = c+dc[i];

      if(nr>=0 && nr<arr.length && nc >=0 && nc<arr[0].length &&!visited[nr][nc] && arr[nr][nc] ==1){
        dfs(arr,nr,nc,visited);
      }
      
    }

  }


  
}