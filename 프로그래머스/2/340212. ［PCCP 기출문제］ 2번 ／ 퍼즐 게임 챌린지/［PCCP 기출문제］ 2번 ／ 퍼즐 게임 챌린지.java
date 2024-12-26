import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        
        int left = diffs[0];
        
        int level =0;
        int[] tmp = diffs.clone();
        Arrays.sort(tmp);
        int right = tmp[tmp.length-1];
        
        while(left<=right){
            level = (left+right)/2;
            long total = 0;
            //최종 시간 계산
            for(int i=0; i<times.length; i++){
                
                int diff = diffs[i];
                int time_cur = times[i];
                int time_prev = (i==0) ? 0 : times[i-1];
            
                if(diff<=level)    
                    total += time_cur;
                else    
                    total += (diff-level)*(time_cur+time_prev) + time_cur;
                
            }   
        
            if(total<=limit){
                //가능 -> level 을 낮춰볼 것
                right = level-1;
            
            }else{
                //불가능 -> level 을 높혀볼 것
                left = level+1;
            }
            
        }
        
        answer = left;
        
        
        
        
        
        return answer;
    }
}