import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long ans = factorial(n)/(factorial(n-k)*factorial(k));
		
		System.out.println(ans);
		

		
	}
	
	static long factorial(int N) {
		
		long ans=1;
		while (N>1) {
			ans = ans*N;
			N--;
		}
		
		return ans;
	}

}
