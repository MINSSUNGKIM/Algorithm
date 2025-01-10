import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
       
           if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<Pointer> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        queue.offer(new Pointer(begin,0));
        set.add(begin);
        
        while(!queue.isEmpty()){
            
            Pointer pt = queue.poll();
            
            if(pt.cur.equals(target)){
                
               answer = pt.cnt;
                break;
            }
                        
            for(String word : words){
                
                if(set.contains(word))
                    continue;
                
                int cnt =0;
                for(int i=0; i<begin.length(); i++){
                    
                    if(pt.cur.charAt(i) != word.charAt(i))
                        cnt++;
                }
                
                if(cnt ==1){
                    queue.offer(new Pointer(word, pt.cnt+1));
                    set.add(word);
                }
                    
            }
        }
        
        return answer;
        
    }
}

class Pointer{
    String cur;
    int cnt;
    
    Pointer(String cur, int cnt){
        this.cur = cur;
        this.cnt = cnt;
    }
}