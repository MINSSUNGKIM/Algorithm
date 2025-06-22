import java.util.*;

import java.io.*;

import java.lang.*;

public class Main{

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());

        long B = Long.parseLong(st.nextToken());

        long C = Long.parseLong(st.nextToken());

        

        System.out.println(power(A, B, C));

    }

    

    public static long power(long a, long b, long c){

        if(b == 0){

            return 1;

        }

        

        long temp = power(a, b/2, c);

        temp = (temp * temp) % c;

        

        if(b % 2 == 1){

            temp = (temp * a) % c;

        }

        

        return temp;

    }

}