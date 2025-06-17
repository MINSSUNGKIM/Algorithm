import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] tree = new int[N];
    st = new StringTokenizer(br.readLine());

    int max = -1;
    for(int i=0; i<N; i++){

      tree[i] = Integer.parseInt(st.nextToken());
      if(tree[i] > max)
        max =tree[i];
      
    }
    

    int left = 0;
    int right = max;
    int mid =0;
    int answer = 0;
    while(left <= right){
      long sum = 0l;
      mid = (left + right)/2;
      
      for(int i=0; i<N; i++){
        if(tree[i] > mid){
          sum += tree[i]-mid;
        } 
      }

      if(sum >= M){  
        answer = mid;  
        left = mid + 1;  
      } else {
        right = mid - 1;  
      }
      

      
    }

    System.out.println(answer);


  }
}
