//머지

import java.util.Scanner;

public class Solution {
	static int[] arr = new int[1000000];
	static int N = 1000000; // 배열의 길이
	static int[] tmp = new int[1000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 1000000; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0, N - 1);
		System.out.println(arr[500000]);
	}

	static void mergeSort(int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	// l
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}

		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				tmp[idx++] = arr[i];
		} else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}

		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}

}
