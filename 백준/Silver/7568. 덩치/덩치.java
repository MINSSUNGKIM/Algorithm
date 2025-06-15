import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  
    public static void main(String[] args) throws IOException {
     
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int[][] person = new int[N][2];
      for(int i=0; i<N; i++){

        StringTokenizer st = new StringTokenizer(br.readLine());

        person[i][0] = Integer.parseInt(st.nextToken());
        person[i][1] = Integer.parseInt(st.nextToken());
    
      }
      StringBuilder sb = new StringBuilder();
      for (int i=0 ; i<N ;i ++){
        int rank =1;
        for(int j=0; j<N; j++){
          if(person[j][0] > person[i][0] && person[j][1] > person[i][1]){
            rank++;
          }
        }

        sb.append(rank).append(" ");

        
        
      }

      System.out.println(sb.toString());


      
    }



}