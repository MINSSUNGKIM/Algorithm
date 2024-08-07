import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] A;
            String[] B;

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = (N + 1) / 2; // 중간 지점을 계산

            A = new String[mid];
            B = new String[N - mid];

            for (int i = 0; i < mid; i++) {
                A[i] = st.nextToken();
            }
            for (int i = 0; i < N - mid; i++) {
                B[i] = st.nextToken();
            }

            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < mid; i++) {
                queue.add(A[i]);
                if (i < N - mid) { // B의 인덱스가 A보다 작아야 한다.
                    queue.add(B[i]);
                }
            }

            StringBuilder ans = new StringBuilder();
            while (!queue.isEmpty()) {
                ans.append(queue.poll()).append(" ");
            }

            System.out.println("#" + t + " " + ans.toString().trim());
        }
    }
}
