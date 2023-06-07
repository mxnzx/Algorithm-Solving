package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ27211_도넛행성 {
    static int N,M, Ans;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
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
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !v[i][j]) {
                    bfs(i,j);
                    Ans++;
                }
            }
        }
        System.out.println(Ans);
    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                //가장자리로 나왔으면 연결되어 있는 애들로 넘어간다
                if (nr == -1) nr = N - 1;
                if (nc == -1) nc = M - 1;
                if (nr == N) nr = 0;
                if (nc == M) nc = 0;

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || map[nr][nc] == 1) continue;
                q.add(new Node(nr, nc));
                v[nr][nc] = true;
            }
        }
    }
}
