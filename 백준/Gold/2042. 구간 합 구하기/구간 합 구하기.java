
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long arr[];
	static long tree[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//숫자개수
		int M = Integer.parseInt(st.nextToken());//업데이트수
		int K = Integer.parseInt(st.nextToken());//부분합수

		int treeHeight = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int treeSize = (int)Math.pow(2, treeHeight);

		arr = new long[N + 1];
		tree = new long[treeSize + 1];

		for (int i = 1; i <= N; i++) {
			long tmp = Long.parseLong(br.readLine());
			// System.out.println("tmp = " + tmp);
			arr[i] = tmp;
		}

		initSegTree(1, N, 1);

		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int opt = Integer.parseInt(st.nextToken());
			if (opt == 1) {

				int idx = Integer.parseInt(st.nextToken());
				long newValue = Long.parseLong(st.nextToken());

				long diff = newValue - arr[idx];
				arr[idx] = newValue;

				update(1,1,N,idx,diff);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				System.out.println(sum(1, 1, N, left, right));
			}

		}

	}

	//index 는 tree의 현재 위치, START END 는 부분합 구간
	public static long initSegTree(int start, int end, int index) {
		if (start == end) {

			return tree[index] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[index] = initSegTree(start, mid, index * 2)
			+ initSegTree(mid + 1, end, index * 2 + 1);
	}

	//index 현재 tree
	//start end 배열 시작 끝,
	//left right 누적합 시작 끝
	public static long sum(int index, int start, int end, int left, int right) {
		if (end < left || start > right)
			return 0;

		if (start >= left && end <= right)
			return tree[index];

		int mid = (start + end) / 2;

		return sum(index * 2, start, mid, left, right)
			+ sum(index * 2 + 1, mid + 1, end, left, right);
	}

	public static void update(int index, int start, int end, int idx, long diff) {

		if (idx < start || idx > end)
			return;

		tree[index] += diff;
		int mid = (start + end) / 2;
		if (start != end) {
			update(index * 2, start, mid, idx, diff);
			update(index * 2 + 1, mid + 1, end, idx, diff);
		}
	}

}
