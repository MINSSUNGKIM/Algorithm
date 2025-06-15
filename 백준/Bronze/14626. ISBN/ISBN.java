import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String input = br.readLine();

      char[] isbn = new char[13];
      int starIndex = -1;

      int checkSum = 0;
      for(int i=0; i<13; i++){
        
        isbn[i] = input.charAt(i);

        if(isbn[i] == '*'){
          starIndex = i;
          continue;
        }

        if(i%2 == 0){
          checkSum += isbn[i] - '0';

        }

        if(i%2 != 0){
          checkSum += (isbn[i]-'0') *3;
        }
          
        
      }

      Map<Integer,Integer> map = new HashMap<>();
      map.put(1,7);
      map.put(2,4);
      map.put(3,1);
      map.put(4,8);
      map.put(5,5);
      map.put(6,2);
      map.put(7,9);
      map.put(8,6);
      map.put(9,3);
      map.put(0,0);
      map.put(10,0);


      System.out.println(starIndex%2 ==0 ? 10 - checkSum%10 : 
                        (int)map.get(10-checkSum%10));

      
    }
}