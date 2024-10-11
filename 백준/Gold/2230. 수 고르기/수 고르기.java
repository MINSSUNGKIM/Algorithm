import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int target = arr[i] + M;

            // 이분 탐색으로 target 이상의 수를 찾음
            int left = i + 1, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= target) {
                    ans = Math.min(ans, arr[mid] - arr[i]);
                    right = mid - 1; // 더 작은 값을 찾기 위해 왼쪽으로 이동
                } else {
                    left = mid + 1; // 더 큰 값을 찾기 위해 오른쪽으로 이동
                }
            }
        }

        System.out.println(ans);
    }
}