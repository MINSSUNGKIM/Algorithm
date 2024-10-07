import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int nCnt = 0;
		int zCnt = 0;
		int oCnt = 0;
		int pCnt = 0;

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {

			int k = Integer.parseInt(br.readLine());

			if (k < 0)
				nCnt++;
			else if (k == 0)
				zCnt++;
			else if (k == 1)
				oCnt++;
			else
				pCnt++;

			list.add(k);
		}

		Collections.sort(list);
		int ans = 0;

		// 음수 처리 과정
		if (nCnt % 2 == 0) {
			for (int i = 0; i < nCnt / 2; i++) {
				ans += list.remove(0) * list.remove(0);
			}
		} else {
			for (int i = 0; i < nCnt / 2; i++) {
				ans += list.remove(0) * list.remove(0);
			}

			if (zCnt != 0) {
				list.remove(0);
				list.remove(0);
				zCnt--;
			} else {
				ans += list.remove(0);
			}

		}

		// 남은 0 은 모두 제거
		for (int i = 0; i < zCnt; i++) {
			list.remove(0);
		}

		// 1은 모두 더하기
		for (int i = 0; i < oCnt; i++) {
			ans += list.remove(0);
		}

		// 남은 양수 곱해서 더하기
		if (pCnt % 2 == 1) {
			ans += list.remove(0);
			for (int i = 0; i < pCnt / 2; i++) {
				ans += list.remove(0) * list.remove(0);
			}
		} else {
			for (int i = 0; i < pCnt / 2; i++) {
				ans += list.remove(0) * list.remove(0);
			}
		}

		System.out.println(ans);

		br.close();

	}

}