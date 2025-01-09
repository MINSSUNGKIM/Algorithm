import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int size = works.length;
        int total =0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<size; i++){
            
            total +=works[i];
            pq.offer(works[i]);
        }
        
        
        
        
        if(total <=n )
            return answer;
        
        for(int i=0; i<n; i++){
            
            int max = pq.poll();
            pq.offer(max - 1);
        }

        for(int i=0; i<size; i++){
            
            int tmp = pq.poll();
            if(tmp<=0)
                break;
            
            answer += tmp * tmp;
        }
        
        
        
        return answer;
    }
}