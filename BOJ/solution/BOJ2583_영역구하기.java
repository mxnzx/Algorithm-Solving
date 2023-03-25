package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583_영역구하기 {
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int M,N,K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r,c;
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            Point start = new Point(r, c);
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            Point end = new Point(r, c);

            for (int j = start.r; j < end.r; j++) {
                for (int k = start.c; k < end.c; k++) {
                    map[j][k] = -1;
                }
            }
        }
        //0인 애들을 찾아 구간을 나눈다. 각구역마다 1,2,..
        int area=1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    bfs(i,j,area++);
                }
            }
        }
        //area 하나 커져있음
        int[] res = new int[area];  //인덱스 1부터
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]>0) res[map[i][j]]++;
            }
        }
        Arrays.sort(res);
        sb.append(area-1).append("\n");
        for (int i = 1; i < res.length ; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);


    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    private static void bfs(int r, int c, int area) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        //넣었으면 구역 표시 처리
        map[r][c] = area;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=M || nc<0 || nc>= N || map[nr][nc] != 0) continue;
                //다음이 0인 애들만
                q.add(new Point(nr,nc));
                map[nr][nc] = area;
            }
        }

    }
    private static void print(int[][] map) {
        for (int j = 0; j <M; j++) {
            for (int k = 0; k < N; k++) {
                System.out.print(map[j][k]);
            }
            System.out.println();
        }
    }
}
