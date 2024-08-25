package solution;

import java.io.*;
import java.util.*;

public class BOJ21736_헌내기는친구가필요해 {

    static class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean[][] visited;
    static char[][] map;
    static int N, M, meetCnt;
    static Node dyNode;

    static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c] = true;
        q.add(start);

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(map[now.r][now.c] == 'P') meetCnt++;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;

                if(map[nr][nc] == 'X') continue;

                q.add(new Node(nr, nc));
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
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'I') dyNode = new Node(i, j);
            }
        }
        bfs(dyNode);
        System.out.println(meetCnt == 0 ? "TT" : meetCnt);
    }
}
