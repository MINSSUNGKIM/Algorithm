import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer:
		for (int t = 1; t <= T; t++) {
			String func = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String arr = br.readLine();

			// 대괄호 제거
			arr = arr.replaceAll("[\\[\\]]", "");

			String[] parts;
			int[] nums;
			// 쉼표 기준으로 split
			if (len == 0) {
				nums = new int[0];
			} else if (len == 1) {
				nums = new int[1];
				nums[0] = Integer.parseInt(arr);
			} else {
				parts = arr.split(",");
				nums = new int[parts.length];

				for (int i = 0; i < parts.length; i++) {
					nums[i] = Integer.parseInt(parts[i].trim());
				}
			}

			int start = 0;
			int last = nums.length;
			boolean isReverse = false;

			for (int index = 0; index < func.length(); index++) {
				char opt = func.charAt(index);

				if (opt == 'D') {

					if (last - start == 0) {
						System.out.println("error");
						continue outer;
					}
					if (isReverse) {
						last--;
					} else {
						start++;
					}

				}

				if (opt == 'R')
					isReverse = !isReverse;

			}
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (isReverse) {
				for (int i = last - 1; i >= start; i--) {
					sb.append(nums[i]).append(",");
				}
			} else {
				for (int i = start; i < last; i++) {
					sb.append(nums[i]).append(",");
				}
			}
			if( last-start == 0){
				sb.append("]");
			} else{
				sb.setLength(sb.length() - 1);
				sb.append("]");
			}
			System.out.println(sb);


		}

	}
}