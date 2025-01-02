import java.io.*;
import java.util.*;

class Main{

    public static void main(String argus[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] world = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        boolean flag =true;
        int ans=0;
        while(flag){
            flag =false;
            boolean[][] visited = new boolean[N][N];
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){

                    if(visited[i][j])
                        continue;


                    List<int[]> union = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                    int total = world[i][j];
                    union.add(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] tmp = queue.poll();

                        int r = tmp[0];
                        int c = tmp[1];

                        for(int k=0; k<4; k++){
                            
                            int nr = r+dr[k];
                            int nc = c+dc[k];

                            if(nr<0 || nr >=N || nc <0 || nc>=N || visited[nr][nc])
                                continue;
                            
                            if((int)Math.abs(world[r][c] - world[nr][nc]) <L ||(int)Math.abs(world[r][c] - world[nr][nc]) >R)
                                continue;

                            queue.offer(new int[]{nr,nc});
                            visited[nr][nc]=true;
                            total += world[nr][nc];
                            union.add(new int[]{nr,nc});
                            flag =true;                         

                        }

                    }
                    if(union.size()>1){
                        int pop = total/union.size();
   
                        for(int[] tmp : union){
                            world[tmp[0]][tmp[1]] = pop;
                    
                        }
                    }






                }
            }

            if(flag) ans++;
        }

        System.out.println(ans);
        

        br.close();
    }

}
