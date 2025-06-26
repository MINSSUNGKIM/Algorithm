import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N = str1.length();
        int M = str2.length();


        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    
                
            }
                
        }

        System.out.println(dp[N][M]);

    }
}