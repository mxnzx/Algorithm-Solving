package solution;

import java.util.*;
import java.io.*;

public class BOJ1245_농장관리 {

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(searchTopArea(i, j)) ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean searchTopArea(int r, int c) {

        if(visited[r][c]) return false;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        visited[r][c] = true;

        boolean canTop = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(map[nr][nc] > map[now.r][now.c]) {
                    canTop = false;
                }

                if(visited[nr][nc]) continue;

                if(map[nr][nc] == map[now.r][now.c]) {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        return canTop;
    }
}