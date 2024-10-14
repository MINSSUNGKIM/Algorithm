import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Integer[] arr = Era(N);

		int left = 1;
		int right = 1;

		int sum = 0;
		int ans = 0;
		while (right < arr.length) {

			sum += arr[right++];

			while (sum > N) {

				sum -= arr[left++];
			}

			if (sum == N) {
				ans++;
			}

		}

		System.out.println(ans);

	}

	public static Integer[] Era(int N) {
		boolean[] isPrime = new boolean[N + 1];
		List<Integer> primes = new ArrayList<>();

		// 1. 모든 수를 소수로
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		// 2. 루트 N 까지 채로 거름
		for (int p = 2; p * p <= N; p++) {
			if (isPrime[p]) {
				// p의 제곱부터 P의 배수들을 모두 쳐냄
				for (int i = p * p; i <= N; i += p) {
					isPrime[i] = false;
				}
			}
		}

		// 소수 모아서 리턴
		primes.add(0);
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
		Integer[] result = primes.toArray(new Integer[0]);

		return result;
	}

}