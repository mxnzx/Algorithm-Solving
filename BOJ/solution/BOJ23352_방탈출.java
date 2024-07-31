package solution;

import java.io.*;
import java.util.*;

public class BOJ23352_방탈출 {

    static class Room {
        int r;
        int c;
        int length;

        Room(int r, int c, int length) {
            this.r = r;
            this.c = c;
            this.length = length;
        }
    }

    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map;
    static int N, M, maxLength, maxValue;

    static void bfs(int sr, int sc) {
        Queue<Room> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Room(sr, sc, 1));
        visited[sr][sc] = true;

        while(!q.isEmpty()) {
            Room now = q.poll();

            if(maxLength < now.length) {
                maxLength = now.length;
                maxValue = map[sr][sc] + map[now.r][now.c];
            }

            if(maxLength == now.length && maxValue < map[sr][sc] + map[now.r][now.c]) {
                maxValue = map[sr][sc] + map[now.r][now.c];
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;

                q.add(new Room(nr, nc, now.length + 1));
                visited[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 브루트포스 + bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) bfs(i, j);
            }
        }

        System.out.println(maxValue);
    }
}
