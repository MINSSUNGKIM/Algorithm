import java.util.*;
import java.io.*;

class Main{

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int[] value = new int[N];
      
      for(int i=0; i<N; i++){
         value[i] = Integer.parseInt(br.readLine());
      }
      
      int dp[] = new int[K+1];

      dp[0] =1;

      for(int i=0; i<N; i++){
         for(int j=value[i]; j<K+1; j++){
            dp[j] += dp[j-value[i]];
         }
      }

      System.out.println(dp[K]);

   }

      
}