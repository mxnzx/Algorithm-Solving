/*
 * [BOJ]3184. 양 - BFS
 * 체크하는 구간 잘 따지기.
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184_양 {

    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R,C;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int wTotal, sTotal;  //총늑대와 양의 마리수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                //양이거나 늑대이면 리스트에 넣는다
                if(map[i][j] == 'v') wTotal++;
                else if(map[i][j] == 'o') sTotal++;
            }
        }

        //땅을 찾아 늑대와 양의 개수 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //땅이고 방문하지 않은 곳 탐색
                if(map[i][j] != '#' && !v[i][j]) {
                    bfs(i,j);
                }
            }
        }
        System.out.println(sTotal + " "+ wTotal);

    }
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        v[r][c] = true;
        //한 구간에서의 양과 늑대의 개수
        int wcnt = 0;
        int scnt = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            //양이나 늑대를 만나면 개수를 센다
            //꺼내고 세야 다음에 갈 곳이 없어도 그 구간에 늑대와 양의 개수를 비교한다
            if(map[p.r][p.c] == 'v') wcnt++;
            else if(map[p.r][p.c] == 'o') scnt++;

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr<0 || nr>=R || nc<0|| nc>=C || v[nr][nc] || map[nr][nc] == '#') continue;

                v[nr][nc] = true;
                q.offer(new Point(nr,nc));
            }
        }
        //양과 늑대의 개수 비교
        if(scnt > wcnt) {   //양이 더 많다면 늑대 감소
            wTotal -= wcnt;
        } else {
            sTotal -= scnt;
        }
    }
}
