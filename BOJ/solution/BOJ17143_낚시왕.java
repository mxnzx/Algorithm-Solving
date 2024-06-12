package solution;

import java.io.*;
import java.util.*;

public class BOJ17143_낚시왕 {

    static class Shark {
        int r, c, s, d, z;
        boolean isDisAppeared;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        void move() {
            int tmp = s;

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

        void goFish() {
            isDisAppeared = true;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    ", isDisAppeared=" + isDisAppeared +
                    '}';
        }
    }

    static int R, C, M, ans;
    static List<Integer>[][] map;
    static Shark[] sharks;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};

    static void startFishing(int loc) {
        // 1초동안 일어나는 일
        // 낚시왕이 오른쪽으로 한칸 이동 > 낚시왕 열의 상어중 가장 가까운 상어 획득(사라짐) > 상어 이동
        for (int i = 1; i <= R; i++) {
            // 낚시왕 열의 상어중 가장 가까운 상어 획득(사라짐)
            if (!map[i][loc].isEmpty()) {
                int idx = map[i][loc].get(0);
                if(sharks[idx].isDisAppeared) continue;
                ans += sharks[idx].z;
                sharks[idx].goFish();
                map[i][loc].clear();
                break;
            }
        }
        // 각 상어들 이동
        for (int i = 0; i < M; i++) {
            Shark sk = sharks[i];
            if (!sk.isDisAppeared) {
                // 기존에 있던 맵리스트에서 제거한다.
                map[sk.r][sk.c].remove(Integer.valueOf(i));
                sk.move();
                map[sk.r][sk.c].add(i);
            }
        }
        // 한자리에 두마리 이상의 상어가 있으면 합친다
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j].size() > 1) fightShark(i, j);
            }
        }
    }

    static void fightShark(int r, int c) {
        int maxSizeIdx = -1;
        int maxSize = -1;
        for (int n : map[r][c]) {
            Shark shark = sharks[n];
            if (maxSize < shark.z) {
                maxSize = shark.z;
                maxSizeIdx = n;
            }
        }
        // 잡힌 상태
        for (int i = 0; i < map[r][c].size(); i++) {
            sharks[map[r][c].get(i)].goFish();
        }
        map[r][c].clear();
        map[r][c].add(maxSizeIdx);
        sharks[maxSizeIdx].isDisAppeared = false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z);
            map[r][c].add(i);
        }

        for (int i = 1; i <= C; i++) {
            startFishing(i);
        }

        System.out.println(ans);
    }
}
