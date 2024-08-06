import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 계산 우선 순위를 뜻 하는 map 선언
		Map<Character, Integer> icpMap = new HashMap<>();
		icpMap.put('*', 2);
		icpMap.put('/', 2);
		icpMap.put('+', 1);
		icpMap.put('-', 1);
		icpMap.put('(', 3);

		Map<Character, Integer> ispMap = new HashMap<>();
		ispMap.put('*', 2);
		ispMap.put('/', 2);
		ispMap.put('+', 1);
		ispMap.put('-', 1);
		ispMap.put('(', 0);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();
			String str = sc.next();

			Stack<Integer> stackInt = new Stack<>();
			Stack<Character> stackChar = new Stack<>();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					sb.append(str.charAt(i));
				} else {
					if (stackChar.empty()) {
						stackChar.push(str.charAt(i));
						continue;
					}

					if (str.charAt(i) == ')') {
						while (stackChar.peek() != '(') {
							sb.append(stackChar.pop());
						}
						stackChar.pop();
						continue;
					}

					if (icpMap.get(str.charAt(i)) > ispMap.get(stackChar.peek())) {
						stackChar.push(str.charAt(i));
					} else {
						while (!stackChar.empty() && ispMap.get(stackChar.peek()) >= icpMap.get(str.charAt(i))) {
							sb.append(stackChar.pop());
						}
						stackChar.push(str.charAt(i));
					}

				}
			} // 후위 표기식 표기 완료
			if (!stackChar.empty()) {
				while (!stackChar.empty()) {
					sb.append(stackChar.pop());
				}
			}
			String postfixNotation = sb.toString();
			int leng = postfixNotation.length();
			for (int i = 0; i < leng; i++) {
				if (postfixNotation.charAt(i) >= '0' && postfixNotation.charAt(i) <= '9') {
					// 정수 입력처리
					stackInt.push(postfixNotation.charAt(i) - '0');
				} else {
					// 기호 입력 처리
					switch (postfixNotation.charAt(i)) {
					case '-':
						int a = stackInt.pop();
						int b = stackInt.pop();
						stackInt.push(b - a);
						break;

					case '+':
						stackInt.push(stackInt.pop() + stackInt.pop());
						break;

					case '*':
						stackInt.push(stackInt.pop() * stackInt.pop());
						break;

					case '/':

						int c = stackInt.pop();
						int d = stackInt.pop();
						stackInt.push(d / c);
						break;
					}
				}

			} // 계산완료

			System.out.println("#" + t + " " + stackInt.pop());

		}

	}

}
