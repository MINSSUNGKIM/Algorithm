import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();


		
		System.out.println(findidx(N, r, c));

	}

	private static int findidx(int N, int r, int c) {

		if (N == 0)
			return 0;

		int size = (int) Math.pow(2, N - 1);
		int idx = 0;

		if (r < size && c < size) {
			idx += 0;
		} else if (r < size && c >= size) {
			idx += size * size;
			c -= size;
		} else if (r >= size && c < size) {
			idx += 2 * size * size;
			r -= size;
		} else {
			idx += 3 * size * size;
			r -= size;
			c -= size;
		}

		return idx + findidx(N - 1, r, c);

	}

	static int idx;
	static int ans;

//시간초과
//	private static void draw(int startR, int startC, int size) {
//
//		if (size == 0) {
//			if (startR == r && startC == c)
//				ans = idx;
//			idx++;
//			return;
//		}
//
//		draw(startR, startC, size / 2);
//		draw(startR, startC + size, size / 2);
//		draw(startR + size, startC, size / 2);
//		draw(startR + size, startC + size, size / 2);
//	}

}