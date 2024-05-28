package solution;

import java.util.*;
import java.io.*;

public class BOJ11559_PuyoPuyo {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int ans;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    static boolean bfs(int r, int c, char color) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        Queue<Node> passQ = new LinkedList<>();

        q.add(new Node(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            passQ.add(current);

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc]) continue;
                if (map[nr][nc] == color) {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }

        if (cnt >= 4) {
            while (!passQ.isEmpty()) {
                Node current = passQ.poll();
                map[current.r][current.c] = '.';
            }
            return true;
        }
        return false;
    }

    private static void downMap() {

        for (int i = 0; i < 6; i++) {
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < 12; j++) {
                if (map[j][i] != '.') {
                    s.push(map[j][i]);
                    map[j][i] = '.';
                }
            }
            int idx = 11;
            while (!s.empty()) {
                map[idx][i] = s.pop();
                idx--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        while (true) {
            boolean isBomb = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        if (bfs(i, j, map[i][j])) isBomb = true;
                    }
                }
            }
            if (!isBomb) break;
            downMap();
            ans++;
        }

        System.out.println(ans);
    }
}
