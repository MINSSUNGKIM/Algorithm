
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		
		long ans=0;
		long r =1;
		long m = 1234567891;
		String str = sc.next();
		
		for(int i=0; i<N; ++i) {
		
			 long p =(int)str.charAt(i)-96;
			 ans += (p*r)%m;
			 r = (r*31)%m;
		}
		
		System.out.println(ans);
		
	}

}
