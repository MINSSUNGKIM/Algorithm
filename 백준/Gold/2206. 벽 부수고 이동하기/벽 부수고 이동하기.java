import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        // 3차원 visited: [row][col][벽부순여부]
        boolean[][][] visited = new boolean[N][M][2];

        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 0, 1, false));
        visited[0][0][0] = true;

        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};

        while(!queue.isEmpty()){
            Info cur = queue.poll();

            if(cur.r == N-1 && cur.c == M-1){
                System.out.println(cur.dist);
                return;
            }

            for(int i=0; i<4; i++){
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                // 빈 공간으로 이동
                if(map[nr][nc] == 0){
                    int wallState = cur.isTerminated ? 1 : 0;
                    if(!visited[nr][nc][wallState]){
                        visited[nr][nc][wallState] = true;
                        queue.offer(new Info(nr, nc, cur.dist + 1, cur.isTerminated));
                    }
                }
                // 벽을 부수고 이동 (아직 벽을 부순 적이 없는 경우)
                else if(map[nr][nc] == 1 && !cur.isTerminated){
                    if(!visited[nr][nc][1]){
                        visited[nr][nc][1] = true;
                        queue.offer(new Info(nr, nc, cur.dist + 1, true));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Info{
        int r, c, dist;
        boolean isTerminated;

        public Info(int r, int c, int dist, boolean isTerminated){
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.isTerminated = isTerminated;
        }
    }
}