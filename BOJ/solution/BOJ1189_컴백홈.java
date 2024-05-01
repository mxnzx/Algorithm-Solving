package solution;

import java.util.*;
import java.io.*;

public class BOJ1189_컴백홈 {

    static int R, C, K, ans;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};

    static void backtracking(int r, int c, int cnt) {

        if(r == 0 && c == C - 1) {
            if(cnt == K) ans++;
            return;
        }

        if(cnt == K) return;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'T') continue;

            visited[nr][nc] = true;
            backtracking(nr, nc, cnt+1);
            visited[nr][nc] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        visited[R - 1][0] = true;
        backtracking(R - 1, 0, 1);

        System.out.println(ans);
    }
}
