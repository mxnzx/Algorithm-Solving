package solution;

import java.util.*;
import java.io.*;

public class BOJ18290_NM과K {

    static final int INF = Integer.MIN_VALUE;
    static int N, M, K, maxValue = INF;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static boolean canPick(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) return false;
        }

        return true;
    }

    static void backtracking(int r, int c, int sum, int p) {

        if (p == K) {
            maxValue = Math.max(sum, maxValue);
            return;
        }

        for (int i = r; i < N; i++) {
            // 같은 행이면 다음 열부터 탐색하고, 새로운 행으로 넘어가면 처음 0부터 탐색
            for (int j = (i == r ? c : 0); j < M; j++) {
                if (visited[i][j]) continue;
                if (canPick(i, j)) {
                    visited[i][j] = true;
                    backtracking(i, j, sum + map[i][j], p + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0, 0, 0);

        System.out.println(maxValue);
    }
}
