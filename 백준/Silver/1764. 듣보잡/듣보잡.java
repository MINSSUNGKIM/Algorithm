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

    Set<String> neverHeared = new HashSet<>();
    Set<String> neverSeen = new HashSet<>();

    for(int i=0; i<N;i ++){
      String name = br.readLine();
      neverHeared.add(name);
      
    }


    for(int i=0; i<M;i ++){
      String name = br.readLine();
      neverSeen.add(name);

    }

    Set<String> dictionaryName = new TreeSet<>();
    
    int cnt = 0;
    for(String name : neverHeared){
      if(neverSeen.contains(name)){
        cnt++;
        dictionaryName.add(name);
      }
    }

    System.out.println(cnt);
    for(String name : dictionaryName){
      System.out.println(name);
    }

    
  }


  
}