import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, M, R, C, L;
    static int[][] field;
    static boolean[][] visited;

    //상, 하, 좌, 우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    // 각 구조물 타입별로 갈 수 있는 방향을 저장한 배열
    static int[][] pipeType = {
        {},          
        {0, 1, 2, 3},// 1: 상, 하, 좌, 우
        {0, 1},      // 2: 상, 하
        {2, 3},      // 3: 좌, 우
        {0, 3},      // 4: 상, 우
        {1, 3},      // 5: 하, 우
        {1, 2},      // 6: 하, 좌
        {0, 2}       // 7: 상, 좌
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            L = sc.nextInt();

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    field[i][j] = sc.nextInt();
                }
            }

            
            ans = 0;
            bfs(R, C);
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    static int ans = 0;

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC, 1 });
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            ans++;

            // 시간이 L에 도달하면 더 이상 진행하지 않음
            if (time == L)
                continue;

            int type = field[r][c]; // 현재 위치의 구조물 타입

            // 현재 구조물에서 갈 수 있는 방향 탐색
            for (int d : pipeType[type]) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (canGo(nr, nc) && !visited[nr][nc] && isConnected(d, field[nr][nc])) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc, time + 1 });
                }
            }
        }
    }

    // 범위 체크
    static boolean canGo(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    // 파이프 연결 가능 여부 확인
    static boolean isConnected(int direction, int nextType) {
        // 각 방향으로 연결 가능한 파이프 타입을 미리 정의
        int[][] validConnections = {
            { 1, 2, 5, 6 }, // 상으로 연결 가능한 파이프 타입
            { 1, 2, 4, 7 }, // 하로 연결 가능한 파이프 타입
            { 1, 3, 4, 5 }, // 좌로 연결 가능한 파이프 타입
            { 1, 3, 6, 7 }  // 우로 연결 가능한 파이프 타입
        };

        // 해당 방향으로 이동할 수 있는지 체크
        for (int type : validConnections[direction]) {
            if (type == nextType) {
                return true; // 연결 가능한 경우
            }
        }

        return false; // 연결 불가능한 경우
    }
}