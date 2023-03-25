package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562_나이트의이동 {
    static class Point {
        int r,c,cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int T,l,res;
    static int[][] map;
    static boolean[][] v;
    static Point start,end;
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            v = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            bfs();
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        v[start.r][start.c] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            //이동하려는 칸이면 현재 카운트 리턴
            if(p.r == end.r && p.c == end.c) {
                res = p.cnt;
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>= l || nc<0 || nc>=l || v[nr][nc]) continue;
                q.add(new Point(nr,nc,p.cnt+1));
                v[nr][nc] = true;
            }
        }
    }
}
