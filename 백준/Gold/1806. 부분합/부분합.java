import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 1;
        int left = 1;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (right <= N) {
            sum += arr[right++];
            while (sum >= S) {
                ans = Math.min(ans, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}