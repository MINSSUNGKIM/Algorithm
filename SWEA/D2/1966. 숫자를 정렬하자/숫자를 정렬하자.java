import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();

			}
			int[] sortArr = new int[arr.length];
			sortArr = countingSort(arr);
			System.out.print("#" + t);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + sortArr[i]);
			}
			System.out.println();
		}
	}

	public static int[] countingSort(int[] arr) {

		int N = arr.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		// 최댓값 찾은 후, 0~최댓값을 저장할 수 있는 배열 생성
		int[] counts = new int[max + 1];

		// 개수를 세는 배열 생성
		for (int i = 0; i < N; i++) {
			counts[arr[i]]++;
		}
		// 누적 합 배열 생성
		for (int i = 1; i < max + 1; i++) {
			counts[i] += counts[i - 1];
		}
		// 결과를 저장할 배열 생성
		int[] result = new int[N];

		// 역방향으로 기존의 배열을 순회하여, 안정정렬이 이루어 질 수 있게 함.
		for (int i = N - 1; i >= 0; i--) {
			result[--counts[arr[i]]] = arr[i];
		}

		return result;

	}

}
