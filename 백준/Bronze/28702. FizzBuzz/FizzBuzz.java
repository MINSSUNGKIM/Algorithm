
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String first = sc.next();
		String second = sc.next();
		String third = sc.next();

		int index = 0;
		int number = 0;
		;
		int ans=0;

		if (first.charAt(0) > 47 && first.charAt(0) < 58) {
			number = Integer.valueOf(first);
			index = 1;
			ans = number + 3;
		} else if (second.charAt(0) > 47 && second.charAt(0) < 58) {
			number = Integer.valueOf(second);
			index = 2;
			ans = number + 2;
		} else if (third.charAt(0) > 47 && third.charAt(0) < 58) {
			number = Integer.valueOf(third);
			index = 3;
			ans = number + 1;
		}

		if (ans % 3 == 0 && ans % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (ans % 3 != 0 && ans % 5 == 0) {
			System.out.println("Buzz");
		} else if (ans % 3 == 0 && ans % 5 != 0) {
			System.out.println("Fizz");
		} else {
			System.out.println(ans);
		}

	}

}