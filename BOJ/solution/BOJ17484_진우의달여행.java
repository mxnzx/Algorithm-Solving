package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17484_진우의달여행 {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static final int[] dc = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 인풋값 작다 -> 완탐해서 최솟값 갱신
        // 한 방향으로 두번갈수없다
        for (int i = 0; i < M; i++) {
            dfs(0,i,-1, map[0][i]);
        }
        System.out.println(min);

    }

    private static void dfs(int r, int c, int dir, int cnt) {

        if(cnt > min) return;

        for (int d = 0; d < 3; d++) {
            int nr = r + 1;
            int nc = c + dc[d];

            if(nc<0 || nc >=M || dir == d) continue;

            if(nr == N) {
                min = Math.min(min, cnt);
                return;
            }

            cnt += map[nr][nc];
            dfs(nr, nc, d, cnt);
            cnt -= map[nr][nc];
        }
    }
}
