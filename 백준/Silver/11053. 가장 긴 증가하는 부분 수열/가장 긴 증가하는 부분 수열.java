import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];

    dp[0] = 1;


    for(int i=1; i<N; i++){

      //i 번째 수가 가장 작을 때, dp[i] = 1; -> 새로시작
      boolean minimum = true;
      for(int j=0; j<i; j++){
        if(arr[i] > arr[j]){
          minimum = false;
          break;
        }
      }
      if(minimum){
        dp[i] = 1;
        continue;
      }

      //i 번째 수가 가장 작지 않다면 -> 다른 수로부터 이어지는 증가수열
      //이전 수 중 자신보다 작은 수 중, dp가 가장 높은 수를 선택해서 연결

      int maxDP = -1;
      for(int j=0; j<i; j++){
        if(arr[i] > arr[j]){
          if(maxDP < dp[j]){
            maxDP = dp[j];
          }
        }
      }
      // 이전수에 본인 연결
      dp[i] = maxDP + 1;
      
     
      
    }

    
    int ans = -1;
    for(int i=0; i<N; i++){

      if(ans < dp[i]){
        ans = dp[i];
      }
    }

    System.out.println(ans);

    
      
  }
}
