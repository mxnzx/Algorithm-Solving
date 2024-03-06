package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236_아기상어 {

    static class BabyLoc extends FishLoc {

        int size;
        int time;

        public BabyLoc(int r, int c, int size, int time, int cnt) {
            super(r, c, cnt);
            this.size = size;
            this.time = time;
        }
    }
    static class FishLoc {
        int r;
        int c;
        int cnt;

        public FishLoc(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public int getCnt() {
            return cnt;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }

    static int N, fishCnt;
    static int[][] map;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static BabyLoc baby;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    baby = new BabyLoc(i, j, 2, 0,0);
                    map[i][j] = 0;
                }
                if (map[i][j] >= 1 && map[i][j] <= 6) fishCnt++;
            }
        }
        /*
        공간에 아기상어(9) 빼고 전부 0이면 다 먹은거다 = fishCnt가 0이면 종료한다.
        아기상어 < 물고기: 지나갈수없음
        아기상어 == 물고기: 지나갈수만 있고, 물고기 먹지 못함
        아기상어 > 물고기: 지나가면서 물고기 먹음
        상어 이동 방법
        1. 더 이상 먹을 수 있는게 없으면(전부 먹었거나, 이제 먹지 못하거나) 도움을 요청하고 끝낸다.
        2. 먹을 수 있는 물고기가 1마리만 있다면 걔를 먹는다
        3. 1마리 이상이면 가장 가까운 거 먹는다. = 지나가야하는 칸의 개수가 제일 작은 애 << bfs
        4. 같은 거리만큼의 물고기가 있다면 가장 위의 물고기, 같다면 왼쪽 물고기
         */
        playStart();
    }

    private static void playStart() {
        //1. 먹을 수 있는 물고기 있는지 탐색
        while (true) {
            if(!canEat()) {
                System.out.println(baby.time);
                return;
            }
        }
    }

    private static void goEat(FishLoc targetFish) {
        baby.time += targetFish.cnt;
        baby.cnt++;
        if (baby.cnt == baby.size) {
            baby.size++;
            baby.cnt = 0;
        }
        baby.r = targetFish.r;
        baby.c = targetFish.c;
        map[targetFish.r][targetFish.c] = 0;
        fishCnt--;
    }

    private static boolean canEat() {
        PriorityQueue<FishLoc> pq = new PriorityQueue<>(Comparator.comparing(FishLoc::getCnt)
                .thenComparing(FishLoc::getR)
                .thenComparing(FishLoc::getC));

        if (fishCnt == 0) return false;

        boolean[][] visited = new boolean[N][N];

        pq.add(new FishLoc(baby.r, baby.c, 0));
        visited[baby.r][baby.c] = true;
        while (!pq.isEmpty()) {
            FishLoc current = pq.poll();

            if(map[current.r][current.c] != 0 && map[current.r][current.c] < baby.size) {
                goEat(current);
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(map[nr][nc] > baby.size) continue;
                pq.add(new FishLoc(nr, nc, current.cnt+1));
                visited[nr][nc] = true;
            }
        }

        return false;
    }

}
