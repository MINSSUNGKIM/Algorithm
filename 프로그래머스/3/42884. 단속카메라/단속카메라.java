import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1]-b[1]);
        
        int cur = routes[0][1];
        int answer = 1; 
        
        for(int[] tmp : routes){
            if(cur >= tmp[0]) 
                continue;
            
            cur = tmp[1];
            answer++;
        }
        
        return answer;
    }
}