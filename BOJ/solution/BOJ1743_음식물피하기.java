package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1743_음식물피하기 {
    static int N, M, K, max, cnt;
    static int[][] map;
    static boolean[][] v; //방문배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //행 인덱스1~
        M = Integer.parseInt(st.nextToken());   //열 인덱스1~
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        v= new boolean[N+1][M+1];
        cnt=1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;  //음식물 표시
        }
        //음식물 만나면 bfs 돌림
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i][j] == 1) {
                    bfs(i,j,1);
                }
            }
        }
        System.out.println(max);
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    //음식물 좌표 r,c  카운팅 변수 cnt
    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        v[r][c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr>0&& nr<=N && nc>0 && nc<=M && !v[nr][nc] && map[nr][nc] == 1 ) {
                    q.offer(new Point(nr,nc));
                    cnt++;
                    v[nr][nc] = true;
                }
            }

        }
        max = max < cnt ? cnt : max;


    }

}
