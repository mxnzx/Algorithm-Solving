/*
 * [SWEA]4193. 수영대회 - BFS, 구현
 * 헛짓거리 : cnt가 갑자기 확 오르면 내가 그 자리에 있을 때 소용돌이가 다시 올 수 있음 -> 잘못된 방법이다 -> 아닌 것같으면 해보고 바로 다른 방법 생각하기
 *
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA4193_수영대회 {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int T, N, cnt;
    static boolean isDone = false;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static Point start, end;    //시작지점, 끝지점
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //최단경로 -> BFS?
        //소용돌이 ->  cnt를 통해 생길 때와 안 생길 때를 구분한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            v = new boolean[N][N];
            isDone = false;
            //min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);        //시작점
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);        //도착점

            bfs();
            if(isDone) sb.append("#").append(tc).append(" ").append(cnt).append("\n");  //도달했으면
            else sb.append("#").append(tc).append(" ").append(-1).append("\n");         //못했으면
        }
        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        v[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == end.r && p.c == end.c) {
                isDone = true;
                cnt = p.cnt;
                return;
            }

            for (int d = 0; d < 5; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc] || map[nr][nc] == 1) continue;

                //cnt가 2 5 8  .. => cnt % 3 == 2 일때 map[][]==2 도 통과할 수 있음
                if (map[nr][nc] == 0 || p.cnt % 3 == 2) {
                    q.add(new Point(nr, nc, p.cnt + 1));
                    v[nr][nc] = true;
                } else {
                    //내 다음이 소용돌이가 치고 있다면 현재 좌표를 다시 넣는다
                    q.add(new Point(p.r, p.c, p.cnt + 1));
                }
            }
        }


    }

}


