import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] alphabet = new int[26];
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			alphabet[(int) input.charAt(i) - 'a']++;

		}
		for(int i=0; i<alphabet.length; i++) {
			System.out.print(alphabet[i]+" ");
			
		}
	}

}
