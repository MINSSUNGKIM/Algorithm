import java.util.*;


class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        
        int[] tmp = new int[A.length];
        for(int i=0; i<A.length; i++){
            tmp[i]=A[i];
        }
        
        
        Arrays.sort(tmp);
        Arrays.sort(B);
        
        //투포인터
        
        
        int a = 0; 
        int b = 0;
        
        while(b<A.length){
            if(tmp[a] < B[b]){
                a++;
                b++;
                answer++;
            } else{
                b++;
            }
        }
        
        
        
        
        
        
        return answer;
    }
}