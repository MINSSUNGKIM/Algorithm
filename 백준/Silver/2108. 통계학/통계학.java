import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  
    public static void main(String[] args) throws IOException {
     
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[8001];
      for(int i=0; i<N; i++){
        int input = Integer.parseInt(br.readLine());
        //-4000 ~ 4000 => 1 ~ 7999
        arr[input+4000]++;
        
      }

      int mean = 0;
      int mid = 0;
      int mode = 0;
      int range = 0;
      
      int cnt =0;
      int max = -1;

      boolean isFirst = true;
      int first = 0;
      
      for(int i=0; i<8001; i++){

        // 등장하지 않은 값 pass
        if(arr[i] ==0)
          continue;


        cnt += arr[i];
        int val = i-4000;

        //mean 구하기
        mean += val * arr[i];

        //mid 구하기
        int prevCnt = cnt - arr[i];
        if(prevCnt < (N+1)/2 && cnt >= (N+1)/2)
            mid = val;

        if(arr[i]>max){
          max=arr[i];
          mode = val;
        }

        if(isFirst){
          first = val;
          isFirst = false;
        }
        
        range = val;
          
        
      }
      int maxcnt = 0;
      for(int i=0; i<8001; i++){
        if(max == arr[i]){
          maxcnt++;
          if(maxcnt == 2)
            mode = i-4000;
        }

      }
      

      range -=first;

      

      
      System.out.println(Math.round(mean * 1.0f/N));
      System.out.println(mid);
      System.out.println(mode);
      System.out.println(range);
      
      
      
    }


}