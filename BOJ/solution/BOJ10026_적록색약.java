package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026_적록색약 {
    private static class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static int N;
    private static final int[] dr = {-1,1,0,0};
    private static final int[] dc = {0,0,-1,1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        char[][] specialMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);
                map[i][j] = c;
                specialMap[i][j] = c;
                if(c == 'R') specialMap[i][j] = 'G';
            }
        }
        int normalCnt = go(0, map);
        int specialCnt = go(0, specialMap);

        System.out.println(normalCnt + " " + specialCnt);
    }

    private static int go(int cnt, char[][] map) {
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    search(i, j, map);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void search(int r, int c, char[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = current.r + dr[d];
                nc = current.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if (map[nr][nc] != map[current.r][current.c]) continue;
                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

    }
}
