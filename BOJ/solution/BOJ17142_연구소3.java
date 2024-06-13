package solution;

import java.io.*;
import java.util.*;

public class BOJ17142_연구소3 {

    static class Loc {
        int r, c;

        Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, minTime = Integer.MAX_VALUE;
    static int[][] map;
    static List<Loc> virus;


    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static boolean isDone(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static int bfs(int[][] map, Queue<Loc> q) {
        int time = 0;

        while (!isDone(map)) {
            int size = q.size();

            if (size == 0) break;
            for (int i = 0; i < size; i++) {
                Loc now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 3 || map[nr][nc] == 1) continue;
                    q.add(new Loc(nr, nc));
                    map[nr][nc] = 3;
                }
            }
            time++;
        }

        // 모든칸에 바이러스 퍼뜨렸다면 time, 아니면 -1
        if (!isDone(map)) return -1;
        return time;
    }

    static int startSpread(int[] pick) {
        // 지도 하나 복제해서 쓴다.
        int[][] copiedMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }

        Queue<Loc> q = new LinkedList<>();
        //선택된 애들 활성화시킨다. (활성화값: 3)
        for (int idx : pick) {
            Loc vi = virus.get(idx);
            q.add(new Loc(vi.r, vi.c));
            copiedMap[vi.r][vi.c] = 3;
        }

        return bfs(copiedMap, q);
    }

    static void initVirus(int idx, int p, int[] pick) {

        if (p == M) {
            // 여기서부터 얘네를 활성화 시킨다.
            int tmp = startSpread(pick);
            if (tmp != -1) minTime = Math.min(minTime, tmp);
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            pick[p] = i;
            initVirus(i + 1, p + 1, pick);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new Loc(i, j));

            }
        }
        // 어디에 바이러스를 놓을래? : 완탐(조합)
        initVirus(0, 0, new int[M]);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }
}