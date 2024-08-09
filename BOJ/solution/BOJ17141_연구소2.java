package solution;

import java.util.*;
import java.io.*;

public class BOJ17141_연구소2 {

    static class Virus {
        int r;
        int c;
        int time;
        Virus(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
    static List<Virus> virusLoc;
    static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virusLoc = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virusLoc.add(new Virus(i, j, 0));
            }
        }

        pickVirus(new int[M], 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    private static void pickVirus(int[] pick, int idx, int p) {

        if(p == pick.length) {
            int time = spread(pick);
            if(time != -1) ans = Math.min(time, ans);

            return;
        }
        for (int i = idx; i < virusLoc.size(); i++) {
            pick[p] = i;
            pickVirus(pick, i + 1, p + 1);
        }
    }

    private static int spread(int[] pick) {

        visited = new boolean[N][N];

        // 계산
        Queue<Virus> q = new LinkedList<>();
        for (int n : pick) {
            Virus virus = virusLoc.get(n);
            q.add(virus);
            visited[virus.r][virus.c] = true;
        }

        int time = 0;
        while(!q.isEmpty()) {
            Virus now = q.poll();

            time = Math.max(time, now.time);

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 1) {
                    q.add(new Virus(nr, nc, now.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        // 다 퍼졌는지 + 최소 시간 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 1) return -1;
            }
        }
        return time;
    }
}
