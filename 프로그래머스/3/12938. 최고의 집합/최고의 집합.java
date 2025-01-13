class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        
        if(s<n){
            answer = new int[1];
            answer[0] =-1;
            return answer;
        }
        
        answer = new int[n];
        
        int remains = s%n;
        
        
        for(int i=0; i<n; i++){
                answer[i]=s/n;
            }
        
        if(remains !=0){
            for(int i=0; i<remains; i++){
                answer[n-1-i] +=1;
            }
        }
            
        
        
        
        return answer;
    }
}