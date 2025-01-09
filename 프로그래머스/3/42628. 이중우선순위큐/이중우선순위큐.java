import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(String opt : operations){
            String command = opt.substring(0, 1);
            String numStr = opt.substring(2);  // 나머지 전체를 숫자 문자열로
            int num = Integer.parseInt(numStr);
            
            if(command.equals("I")) {
                ts.add(num);
            } else if(command.equals("D")) {
                if(!ts.isEmpty()) {
                    if(num == 1) {
                        ts.pollLast();  // 최댓값 삭제
                    } else {
                        ts.pollFirst(); // 최솟값 삭제
                    }
                }
            }
        }
        
        if(ts.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = ts.last();    // 최댓값
            answer[1] = ts.first();   // 최솟값
        }
        
        return answer;
    }
}