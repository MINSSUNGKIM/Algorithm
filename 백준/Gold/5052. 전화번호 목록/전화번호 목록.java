import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for(int t = 1; t <= tc; t++){
			TrieNode root = new TrieNode();

			int N = Integer.parseInt(br.readLine());
			boolean isConsistent = true;

			String[] phoneNumbers = new String[N];

			// 전화번호 입력 받기
			for(int i = 0; i < N; i++){
				phoneNumbers[i] = br.readLine();
			}

			// 전화번호를 정렬 (더 짧은 번호가 먼저 오도록)
			java.util.Arrays.sort(phoneNumbers);

			// Trie에 전화번호 삽입하며 일관성 체크
			for(int i = 0; i < N; i++){
				TrieNode node = root;
				String str = phoneNumbers[i];

				// 이미 Trie에 있는 번호의 접두사인지 확인
				boolean isPrefix = true;

				for(int j = 0; j < str.length(); j++){
					int idx = str.charAt(j) - '0';

					if(node.children[idx] == null){
						node.children[idx] = new TrieNode();
						isPrefix = false;
					}

					node = node.children[idx];

					// 현재까지의 번호가 이미 완성된 번호라면 일관성이 없는 것
					if(node.isEnd){
						isConsistent = false;
						break;
					}
				}

				// 현재 번호가 다른 번호의 접두사라면 일관성이 없는 것
				if(isPrefix){
					isConsistent = false;
				}

				// 현재 번호의 끝을 표시
				node.isEnd = true;
				node.word = str;

				if(!isConsistent) break;
			}

			// 결과 출력
			System.out.println(isConsistent ? "YES" : "NO");
		}
	}

	static class TrieNode{
		TrieNode[] children;
		String word;
		boolean isEnd;

		public TrieNode() {
			children = new TrieNode[10];
			isEnd = false;
		}

		public TrieNode(TrieNode[] children, String word, boolean isEnd) {
			this.children = children;
			this.word = word;
			this.isEnd = isEnd;
		}

		public TrieNode(TrieNode[] children, String word) {
			this.children = children;
			this.word = word;
		}
	}
}