import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		String T = sc.next();

		while (T.length() != S.length()) {
			int lenT = T.length();
			char last = T.charAt(lenT - 1);

			if (last == 'A') {
				T = T.substring(0, lenT - 1);
			} else if (last == 'B') {
				T = T.substring(0, lenT - 1);
				char[] arr = new char[lenT - 1];
				arr = T.toCharArray();

				for (int i = 0; i < (lenT - 1) / 2; i++) {
					char tmp = arr[i];
					arr[i] = arr[lenT - 2 - i];
					arr[lenT - 2 - i] = tmp;
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
				T = sb.toString();

			}
		}

		if (S.equals(T))
			System.out.println(1);
		else
			System.out.println(0);

	}

}
