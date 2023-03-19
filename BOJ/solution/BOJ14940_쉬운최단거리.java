/*
 * [BOJ]14940. 쉬운최단거리 - BFS
 * 제발 방문배열 .. 잘 좀 주자 !!!!!
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940_쉬운최단거리 {
    static int n, m;
    static Point target;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    target = new Point(i,j,0);
                }
            }
        }

        //결국 목표지점에서부터 bfs를 돌리면 되는 문제다.
        //도착하면 cnt로 값을 바꾼다.
        //1이면 계속, 0이면 continue하고 넘기고, 다한 후에 값이 1인 애들 && 방문안했으면 -1로 교체
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] == 1) map[i][j] = -1;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

        private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(target);
        v[target.r][target.c]=true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.r][p.c] = p.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m || v[nr][nc] || map[nr][nc] == 0) continue;
                v[nr][nc]=true;
                q.add(new Point(nr,nc,p.cnt+1));

            }
        }

    }

}
