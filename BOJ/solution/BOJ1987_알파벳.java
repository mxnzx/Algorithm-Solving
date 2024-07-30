/*
 * [BOJ]1987. 알파벳
 * DFS
 */

package solution;

import java.io.*;
import java.util.*;

public class BOJ1987_알파벳 {
    static boolean[] alphabets = new boolean[26];
    static char[][] map;
    static int R, C, max = 1;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        alphabets[map[0][0] - 'A'] = true;
        goHorse(0, 0, 1);

        System.out.println(max);
    }

    private static void goHorse(int r, int c, int cnt) {

        max = Math.max(max, cnt);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || alphabets[map[nr][nc] - 'A']) continue;

            alphabets[map[nr][nc] - 'A'] = true;
            goHorse(nr, nc, cnt + 1);
            alphabets[map[nr][nc] - 'A'] = false;
        }
    }
}