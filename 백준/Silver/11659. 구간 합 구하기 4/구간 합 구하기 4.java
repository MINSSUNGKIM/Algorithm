import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N,M;

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    long[] sumArr = new long[N+1];
    st = new StringTokenizer(br.readLine());
    
    for(int i=1; i<=N; i++){
      int tmp = Integer.parseInt(st.nextToken());
        sumArr[i] = sumArr[i-1] + tmp;
    }

    
    for(int i=0; i<M; i++){
      long ans = 0;
      st = new StringTokenizer(br.readLine());
      int start, end;
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      ans = sumArr[end] - sumArr[start-1];
      System.out.println(ans);
      

    }    
    
  }


  
}