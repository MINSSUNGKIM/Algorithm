import java.util.*;
import java.io.*;

class Main{

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      Thing[] things = new Thing[N];
      for(int i=0; i<N; i++){
         st = new StringTokenizer(br.readLine());
         int w = Integer.parseInt(st.nextToken());
         int v = Integer.parseInt(st.nextToken());
         
         things[i] = new Thing(w ,v);
      }


      int[][] dp = new int[N][K+1];

      for(int j=0; j<K+1; j++){
         if(j>= things[0].W)
            dp[0][j] = things[0].V;
      }
      
      for(int i=1; i<N; i++){
         for(int w=0; w<K+1; w++){

            //배낭 무게가 아직 부족하니까 직전까지 최적화한거 그대로
            if(things[i].W > w)
               dp[i][w] = dp[i-1][w];

            //배낭 무게 충족
            else{
               

               dp[i][w] = Math.max(
                  // 안 담을래
                  dp[i-1][w],
                  // 담을래
                  dp[i-1][w-things[i].W] + things[i].V

                  
               );
               
            }
            
         }
      }

      System.out.println(dp[N-1][K]);

      
      
   
   }

   static class Thing{
      int W;
      int V;

      Thing(int W, int V){
         this.W=W;
         this.V=V;
      }
   }
   
}