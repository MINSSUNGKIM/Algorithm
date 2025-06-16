import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  
    public static void main(String[] args) throws IOException {
     
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      int[] arr = new int[N+1];

      for(int i=2; i<N+1; i++){
        arr[i]=i;
      }

      for(int i=2; i<=N; i++){

        if(arr[i] == 0) continue;
        
        for(int j=i*2; j<=N; j+=i){
          arr[j] = 0;
        }
        
      }

      for(int i=0; i<N+1; i++){
        if(arr[i] != 0 && i>=M )
          System.out.println(arr[i]);
      }
      
      
      
    }


}