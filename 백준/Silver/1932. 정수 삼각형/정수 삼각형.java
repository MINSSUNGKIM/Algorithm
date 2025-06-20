import java.io.*;
import java.util.*;

public class Main {
    static int[][] triangle;
    static Integer[][] dp;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new Integer[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = triangle[N - 1][i];
        }
        
        System.out.println(solve(0, 0));
    }
    
    static int solve(int row, int col) {
        if (row == N - 1) return dp[row][col];
        
        if (dp[row][col] == null) {
            dp[row][col] = Math.max(solve(row + 1, col), solve(row + 1, col + 1)) + triangle[row][col];
        }
        
        return dp[row][col];
    }
}