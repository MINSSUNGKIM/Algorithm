class Solution {
    public int solution(int[][] triangle) {
        
        int N = triangle.length;
        int[][] maxSubtree = new int[N][N];
          int answer = 0;
        
        for(int i=0; i<N; i++){
            maxSubtree[N-1][i] = triangle[N-1][i];
        }
        
        for(int i=N-2; i>=0; i--){
            
            for(int j=0; j<i+1; j++){

                maxSubtree[i][j] = triangle[i][j] +Math.max(maxSubtree[i+1][j], maxSubtree[i+1][j+1]);
            }
            
            
        }
        
        
      answer = maxSubtree[0][0];
        return answer;
    }
}