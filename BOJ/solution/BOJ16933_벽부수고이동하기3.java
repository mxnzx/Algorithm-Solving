package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16933_벽부수고이동하기3 {
    static class Node {
        int r,c,cnt,brokenCnt;
        boolean isDay;
        Node(int r, int c, int cnt, int brokenCnt, boolean isDay) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.brokenCnt = brokenCnt;
            this.isDay = isDay;
        }
    }
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][K+1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }
        // BFS - (1,1) 부터 탐색한다.
        System.out.println(bfs(1,1));
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c,1,0,true));
        visited[1][1][0] = true;
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.r == N && current.c == M) return current.cnt;
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if(nr<=0 || nr>N || nc<=0 || nc>M || visited[nr][nc][current.brokenCnt]) continue;
                /*
                1. 현재 낮인 경우,
                    1-1. 벽을 부술 수 있다면, 부수고 이동한다.
                    1-2. 없다면, 그냥 이동한다.

                2. 현재 밤인 경우, 현재값들로 이동한다.
                 그럼 결국 1-2와 2는 같을 수 있을지도? -> 같은 분기문 가능
                 */
                if(current.isDay && current.brokenCnt < K && map[nr][nc] == 1 && !visited[nr][nc][current.brokenCnt+1]) {
                    q.add(new Node(nr, nc, current.cnt+1, current.brokenCnt+1, !current.isDay));
                    visited[nr][nc][current.brokenCnt+1] = true;
                }
                // 방문배열을 4차원으로 쓰면, 현재가 낮이면 [0]체크, 아니면 [1]체크
                if(map[nr][nc] == 0 && !visited[nr][nc][current.brokenCnt]) {
                    q.add(new Node(nr, nc, current.cnt+1, current.brokenCnt, !current.isDay));
                    visited[nr][nc][current.brokenCnt] = true;
                }
            }
            // 밤이면 제자리 한번 큐에 넣기: 낮은 모든 가능성이 있으므로 갈 필요 없다
            if(!current.isDay) q.add(new Node(current.r, current.c, current.cnt+1, current.brokenCnt, !current.isDay));
        }
        return -1;
    }
}
