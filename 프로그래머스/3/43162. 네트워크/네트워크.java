import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && !visited[j]){
                    queue.offer(j);
                    visited[j]=true;
                }
            }
              while(!queue.isEmpty()){
                        int cur = queue.poll();
                        for(int j=0; j<n; j++ ){
                           if( computers[cur][j] ==1 && !visited[j]){
                               visited[j]=true;
                               queue.offer(j);
                           }
                        }
                  if(queue.isEmpty())
                    answer++;
                }
            }
        
        return answer;
    }
}