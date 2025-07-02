import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long fixedX = Long.parseLong(st.nextToken());
        long fixedY = Long.parseLong(st.nextToken());
        long[] fixedVertex = new long[]{fixedX, fixedY};
    
        Queue<long[]> queue = new LinkedList<>();
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            queue.add(new long[]{x,y});
        }
        
        // N-2 개 삼각형으로 분할
        long[] v1 = queue.poll();
        long ans = 0; 
        while(!queue.isEmpty()){
            long[] v2 = queue.poll();
            ans += getTriangleSurface(v1, v2, fixedVertex);
            v1 = v2;
        }
        
        double result = Math.abs(ans) / 2.0;
        System.out.printf("%.1f", result);
    }
    
    public static long getTriangleSurface(long[] v1, long[] v2, long[] v3){
        return (v3[0] * v1[1] + v1[0] * v2[1] + v2[0] * v3[1]) 
             - (v3[1] * v1[0] + v1[1] * v2[0] + v2[1] * v3[0]);
    }
}