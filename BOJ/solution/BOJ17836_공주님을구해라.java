package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836_공주님을구해라 {

    static class Point {
        int r, c, cnt;


        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    static int[][] map;
    static boolean[][] v;
    static int N, M, T;
    static Point gram;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 도달할수있는 최단거리 - bfs
        // 먹고 가는 경우와 안먹고 가는 경우를 두개 나누어서 계산한다 -> 방문배열 3차원!
        // 중간에 하다가 T가 되면 Fail
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v = new boolean[N][M];  // 그람을 먹으면 바로 최솟값을 구할수있으므로 3차원쓸필요없겠다
        int res = bfs();

        if(res == 0) System.out.println("Fail");
        else System.out.println(res);


    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        v[0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int val = map[p.r][p.c];    //현재 맵 값

            //T시간 확인
            if(p.cnt > T) return 0;
            // 목적지 도착 했을 때
            if(p.r == N-1 && p.c == M-1) return p.cnt;
            //만약 현재 맵값이 2이면 지금 자리 cnt 와 남은 맨해튼 거리값을 더한게 최솟값이다
            if(val == 2) {
                int dist = (N-1 - p.r) + (M-1 -p.c) + p.cnt;
                if(dist <= T) return dist;
                else return 0;
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];


                if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc] || map[nr][nc] == 1) continue;

                //System.out.println(nr + " " + nc + " " +(p.cnt+1));
                v[nr][nc] = true;
                q.add(new Point(nr,nc,p.cnt+1));

            }
        }
        return 0;
    }
}