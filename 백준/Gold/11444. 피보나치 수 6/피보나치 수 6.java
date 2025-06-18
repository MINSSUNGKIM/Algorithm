import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long[][] base = {{1L,1L}, {1L,0L}};

    long n = Long.parseLong(st.nextToken());

    System.out.println(fib(n,base));
    
    
  }

  static long fib(long n, long[][] base){

    if(n == 0L)
      return 0;

    if(n == 1L)
      return 1;


    long[][] result = powerMatrix(base, n-1);
    
    return result[0][0];
    
  }

  static long[][] powerMatrix(long[][] matrix, long n) {
      // 단위 행렬로 초기화
      long[][] result = {{1L, 0L}, {0L, 1L}};

      while (n > 0) {
          // n이 홀수면 result에 현재 matrix를 곱함
          if (n % 2 == 1) {
              result = multiplyMatrix(result, matrix);
          }
          // matrix를 제곱하고 n을 반으로 줄임
          matrix = multiplyMatrix(matrix, matrix);
          n /= 2;
      }

      return result;
  }


  // 2X2
  static long[][] multiplyMatrix(long[][] A, long[][] B){
      long[][] result = new long[2][2];

    for(int i=0; i<2; i++){
      for(int j=0; j<2; j++){
        result[i][j] = (A[i][0] * B[0][j] + A[i][1] * B[1][j]) % 1000000007;
      }
    }

    return result;

    
  }
}

