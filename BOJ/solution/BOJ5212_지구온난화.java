package solution;

import java.util.*;
import java.io.*;

public class BOJ5212_지구온난화 {

    static int R, C;
    static int startR, startC, endR, endC;
    static char[][] map, afterMap;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static void afterFiftyYears() {
        afterMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    afterMap[i][j] = '.';
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        cnt++;
                        continue;
                    }
                    if (map[nr][nc] == '.') cnt++;
                }

                if (cnt >= 3) afterMap[i][j] = '.';
                else afterMap[i][j] = 'X';
            }
        }
    }

    static void checkEdge() {

        startR = R;
        startC = C;
        endR = 0;
        endC = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (afterMap[i][j] == 'X') {
                    startR = Math.min(startR, i);
                    startC = Math.min(startC, j);
                    endR = Math.max(endR, i);
                    endC = Math.max(endC, j);
                }
            }
        }
    }

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

        afterFiftyYears();

        checkEdge();

        StringBuilder ans = new StringBuilder();
        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                ans.append(afterMap[i][j]);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
