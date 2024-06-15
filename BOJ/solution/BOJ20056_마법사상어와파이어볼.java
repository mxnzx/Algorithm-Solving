package solution;

import java.util.*;
import java.io.*;

public class BOJ20056_마법사상어와파이어볼 {

    static class Ball {

        int r, c, d, m, s;

        Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        void move() {
            int nr = (r + s * dr[d]) % N;
            int nc = (c + s * dc[d]) % N;

            if (nr <= 0) nr += N;
            if (nc <= 0) nc += N;

            r = nr;
            c = nc;

            tmpMap[r][c].add(this);
        }
    }

    static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;
    static List<Ball>[][] map, tmpMap;

    static void startToOrder() {
        // 임시맵 필요
        tmpMap = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tmpMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].isEmpty()) continue;
                for (Ball ball : map[i][j]) {
                    ball.move();
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (tmpMap[i][j].size() < 2) continue;
                int dm = 0;
                int ds = 0;
                int prevDir = tmpMap[i][j].get(0).d % 2;
                boolean isEvenDir = true;
                boolean isFirst = true;
                for (Ball b : tmpMap[i][j]) {
                    dm += b.m;
                    ds += b.s;
                    if (isFirst && prevDir != b.d % 2) {
                        isEvenDir = false;
                        isFirst = false;
                    }
                }

                dm /= 5;
                if (dm == 0) {
                    tmpMap[i][j].clear();
                    continue;
                }
                ds /= tmpMap[i][j].size();

                tmpMap[i][j].clear();
                for(int dir = isEvenDir ? 0 : 1; dir < 8; dir += 2) {
                    tmpMap[i][j].add(new Ball(i, j, dm, ds, dir));
                }
            }
        }
        map = tmpMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new Ball(r, c, m, s, d));
        }

        while (K-- > 0) {
            startToOrder();
        }

        long totalM = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].isEmpty()) continue;
                for(Ball b : map[i][j]) totalM += b.m;
            }
        }

        System.out.println(totalM);
    }
}
