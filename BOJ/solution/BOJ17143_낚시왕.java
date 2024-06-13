package solution;

import java.io.*;
import java.util.*;

public class BOJ17143_낚시왕 {

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        void move() {
            int tmp;
            if(d == 0 || d == 1) {
                tmp = s % ((map.length - 1) * 2 - 2);
            } else {
                tmp = s % ((map[0].length - 1) * 2 - 2);
            }

            while (tmp-- > 0) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr <= 0 || nr > R || nc <= 0 || nc > C) {
                    changeDir();
                    tmp++;
                    continue;
                }
                r = nr;
                c = nc;
            }
        }

        void changeDir() {
            if (d == 0) d = 1;
            else if (d == 1) d = 0;
            else if (d == 2) d = 3;
            else if (d == 3) d = 2;
        }
    }

    static int R, C, M, ans;
    static Shark[][] map;
    static Shark[] sharks;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};

    static void startFishing(int loc) {
        // 1초동안 일어나는 일
        // 낚시왕이 오른쪽으로 한칸 이동 > 낚시왕 열의 상어중 가장 가까운 상어 획득(사라짐) > 상어 이동

        for (int i = 1; i <= R; i++) {
            // 낚시왕 열의 상어중 가장 가까운 상어 획득(사라짐)
            if (map[i][loc] != null) {
                ans += map[i][loc].z;
                map[i][loc] = null;
                break;
            }
        }

        // 맵을 새로 만든다.
        Shark[][] tmpMap = new Shark[R + 1][C + 1];
        // 각 상어들 이동
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == null) continue;
                Shark sk = map[i][j];
                sk.move();
                if (tmpMap[sk.r][sk.c] != null) {
                    if (tmpMap[sk.r][sk.c].z < sk.z) tmpMap[sk.r][sk.c] = sk;
                } else {
                    tmpMap[sk.r][sk.c] = sk;
                }
            }
        }
        map = tmpMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];
        sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }

        for (int i = 1; i <= C; i++) {
            startFishing(i);
        }

        System.out.println(ans);
    }
}
