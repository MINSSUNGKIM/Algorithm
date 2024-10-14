import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int[] sumAB = new int[N * N];
        int[] sumCD = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumAB[idx] = A[i] + B[j];
                sumCD[idx++] = -C[i] - D[j];
            }
        }
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        int left = 0;
        int right = 0;
        long ans = 0; 
        while (left < N * N && right < N * N) {
            if (sumAB[left] == sumCD[right]) {
                long countA = 1;
                long countB = 1;
                
                while (left + 1 < N * N && sumAB[left] == sumAB[left + 1]) {
                    countA++;
                    left++;
                }
                
              
                while (right + 1 < N * N && sumCD[right] == sumCD[right + 1]) {
                    countB++;
                    right++;
                }
                ans += countA * countB;
                left++;
                right++;
            } else if (sumAB[left] < sumCD[right]) {
                left++;
            } else {
                right++;
            }
        }
        System.out.println(ans);
    }
}