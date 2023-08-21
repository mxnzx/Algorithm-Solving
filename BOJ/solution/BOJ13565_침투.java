package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13565_침투 {
    static int[][] map;
    static boolean[][] visited;
    static int M,N;
    static int[] dr = {1,-1,0,0};
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[M][N];
        boolean result = false;
        for (int i = 0; i < N; i++) {
            if(map[0][i] == 0 && !visited[0][i]) result = bfs(0,i);
            if(result) break;
        }

        System.out.println(result ? "YES" : "NO");

    }

    private static boolean bfs(int r, int c) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Node present = q.poll();

            if(present.r == M-1 && map[present.r][present.c] == 0) return true;

            for (int d = 0; d < 4; d++) {
                int nr = present.r + dr[d];
                int nc = present.c + dc[d];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 1) continue;
                q.add(new Node(nr,nc));
                visited[nr][nc] = true;
            }
        }
        return false;
    }
}
