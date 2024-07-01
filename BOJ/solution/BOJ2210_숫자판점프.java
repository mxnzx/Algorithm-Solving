package solution;

import java.util.*;
import java.io.*;

public class BOJ2210_숫자판점프 {
    static final int NUM = 5;

    static String[][] map;
    static Set<Integer> ans = new HashSet<>();
    static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    static void makeNumber(int r, int c, int cnt, String num) {


        if(cnt == 6) {
            ans.add(Integer.parseInt(num));
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= NUM || nc < 0 || nc >= NUM) continue;

            makeNumber(nr, nc, cnt+1, num + map[nr][nc]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new String[NUM][NUM];
        for (int i = 0; i < NUM; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                map[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                makeNumber(i, j, 1, map[i][j]);
            }
        }
        System.out.println(ans.size());
    }
}
