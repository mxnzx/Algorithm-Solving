//BFS + 큐에 두가지 조건 넣는 구현
//놓친 부분: 큐에 두가지 조건을 넣을 때에는 큐가 다 비어있지 않아도 나올 수 있는데, 테케를 내가 돌리는 문제에서는 큐를 초기화 매번 시켜줘야 함. static으로 선언했기 때문에 !!
package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7793_오나의여신님 {
    static class Point {
        int r, c, time;
        char val;

        public Point(int r, int c, int time, char val) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.val = val;
        }

        public Point(int r, int c, char val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    static int T,N,M,time;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] v;
    static Queue<Point> q;
    static StringBuilder sb = new StringBuilder();
    static Point D,S;
    public static void main(String[] args) throws IOException {
        //최단거리 -> BFS
        //악마의 손아귀와 수연이의 이동이 같은 시간에 발생. 악마가 갈 곳에 수연이가 못감 -> 악마가 먼저 가자
        //같은 큐에 넣자 -> 둘을 구분할 것이 필요 -> 좌표 클래스에 실제 값도 클래스 변수로 넣어 구분
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            v = new boolean[N][M];
            q = new LinkedList<>();
            time=0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') q.add(new Point(i,j,'*'));
                    if(map[i][j] == 'D') D = new Point(i,j,'D');
                    if(map[i][j] == 'S') S = new Point(i,j,'S');
                }
            }
            time = bfs();
            if(time == 0) sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
            else sb.append("#").append(tc).append(" ").append(time).append("\n");

        }
        System.out.println(sb);


    }

    private static int bfs() {
        q.add(S);
        v[S.r][S.c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            //도착여부
            if(p.r == D.r && p.c == D.c) {
                return p.time;
            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

                //물일때 + 다음이 돌도 도착도 아니면
                if(p.val == '*' && map[nr][nc] != 'X' && map[nr][nc] != 'D' && map[nr][nc] != '*') {
                    map[nr][nc] = '*';
                    q.add(new Point(nr,nc,'*'));
                }
                //수연일때 + 다음이 돌도 아니고 물도 아니면
                if(p.val == 'S' && map[nr][nc] != 'X' && map[nr][nc] != '*'&& !v[nr][nc]) {
                    q.add(new Point(nr,nc,p.time+1, 'S'));
                    v[nr][nc] = true;
                }
            }
        }
        return 0;
    }
}
