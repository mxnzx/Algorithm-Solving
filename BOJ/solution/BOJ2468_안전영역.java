/*
 * [BOJ]2468. 안전영역
 * 완탐, bfs
 * 놓친 부분: 임계값을 잘 확인하자 ... 제발 !!
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int N, cnt,max=1;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j]) maxHeight = map[i][j];
            }
        }
        for (int i = 1; i <= maxHeight; i++) {
            v = new boolean[N][N];
            getMaxCnt(i);
            //특정 높이가 끝날때마다 맥스값 갱신
            if(cnt>max) max=cnt;

        }
        System.out.println(max);
    }
    //특정 높이에서 탐색한 구간의 수
    private static void getMaxCnt(int height) {
        cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > height && !v[i][j]) {
                    //방문하지 않았고 특정 높이보다 높다면 들어간다(새 구간 탐색)
                    bfs(i,j,height);
                }
            }
        }
    }
    //한 구간을 돌때마다 카운팅
    private static void bfs(int r, int c, int height) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc]) continue;
                if(map[nr][nc] > height) {
                    v[nr][nc]=true;
                    q.add(new Point(nr,nc));
                }
            }
        }
        cnt++;
    }
}
