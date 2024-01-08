package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303_전쟁전투 {
    static class Node {
        int r;
        int c;
        int cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int N, M;
    static char[][] map;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int ours = 0, enemy = 0, area=0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    area = bfs(i,j,map[i][j]);
                    if(map[i][j] == 'W') ours += area;
                    else enemy += area;
                }
            }
        }
        System.out.println(ours + " " + enemy);
    }

    private static int bfs(int r, int c, char color) {
        int area = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c,1));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Node current = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if(nr<0 || nr>=M || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc] != color) continue;
                q.add(new Node(nr,nc,current.cnt+1));
                visited[nr][nc] = true;
                area++;
            }
        }
        return area*area;

    }
}
