import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st =new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][N];
        dp[0][0] = R;
        dp[0][1] = G;
        dp[0][2] = B;
        for(int i=1; i<N; i++){
            st =new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            dp[i][0] = R + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = G + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = B + Math.min(dp[i-1][0],dp[i-1][1]);
            
        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));
    }
}