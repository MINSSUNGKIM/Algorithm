import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());

    PriorityQueue<Long> pq = new PriorityQueue<>();

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      long opt = Long.parseLong(st.nextToken());
      if(opt == 0l){
        if(pq.isEmpty()){
          System.out.println(0);
        }
        if(!pq.isEmpty()){
          System.out.println(pq.poll());
        }
        
        continue;
      }

      if(opt != 0){
        pq.add(opt);
        
      }
      
    }

  }
}