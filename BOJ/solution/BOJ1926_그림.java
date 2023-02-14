/*
 * [BOJ]1926_그림
 * BFS
 * 막힌 부분: 방문배열을 static으로 메인에 선언해 놓아야 함. bfs안에 선언하면 호출할 때마다 새로 되니까
 */

package solution;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926_그림 {

    static int n, m, Max;
    static int[][] painting;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //세로(행)
        m = Integer.parseInt(st.nextToken());   //가로(열)

        painting = new int[n][m];
        v = new boolean[n][m];  //방문배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Max=0;  //가장 넓은 그림넓이 갱신 변수
        int cnt = 0;    //그림 개수 카운팅 변수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(painting[i][j] == 1) {
                    cnt++;
                    bfs(i,j);
                }
            }
        }
        bw.write(cnt + "\n" + Max);
        bw.flush();
        bw.close();
        br.close();

    }
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};


    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();


        q.offer(new Point(r,c));
        v[r][c] = true;
        int size = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();
            painting[p.r][p.c] = 0;

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !v[nr][nc] && painting[nr][nc] == 1) {
                    q.offer(new Point(nr,nc));
                    v[nr][nc] = true;
                    size++;
                }
            }
        }
        Max = Math.max(Max, size);
    }
}
