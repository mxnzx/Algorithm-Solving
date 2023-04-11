package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_불 {
    static class Point {
        int r,c,cnt;
        char val;

        public Point(int r, int c, int cnt, char val) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.val = val;
        }

        public Point(int r, int c, char val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    static int R, C, res;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Queue<Point> q;
    static Point start;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        v = new boolean[R][C];
        q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'F') q.add(new Point(i,j,'F'));
                if(map[i][j] == 'J') start = new Point(i,j,0,'J');
            }
        }
        //큐에는 불이 먼저 들어가있다 -> 먼저 확산시키고, 지훈 이동 -> 지훈 이동할때마다 cnt 업
        res = bfs();
        if(res == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(res);
    }

    private static int bfs() {
        q.add(start);
        v[start.r][start.c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                //내가 지훈이일때 -> 가장자리 벗어나면 현재 카운트+1 리턴 (끝)
                if(p.val == 'J' && (nr<0 || nr>=R || nc<0 || nc>= C)) {
                    return p.cnt + 1;
                }
                //불일때 -> 가장자리 벗어나거나 다음도 불이면 다음으로
                if(p.val == 'F' && (nr<0 || nr>=R || nc<0 || nc>= C || map[nr][nc] == 'F')) continue;

                //내가 불일때 -> 다음이 벽만 아니면 큐에 추가
                if(p.val == 'F' && map[nr][nc] != '#') {
                    q.add(new Point(nr,nc,'F'));
                    map[nr][nc] = 'F';  //불로 바꾼다
                }
                //내가 지훈일때 -> 다음이 지나갈 수 있고 방문하지 않았다면
                if(p.val == 'J' && map[nr][nc] == '.' && !v[nr][nc]) {
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc,p.cnt+1,'J'));
                }

            }
        }

    return 0;
    }


}
