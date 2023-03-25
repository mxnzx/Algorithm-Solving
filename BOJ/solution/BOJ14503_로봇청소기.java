/*
 * [BOJ]14503. 로봇청소기 - 구현(재귀)
 * 구현은 그냥 하나하나 잘 맞춰주자 ..
 */
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
    static class Point {
        int r, c, dir;

        public Point(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int N, M, cnt = 0;
    static int[][] map;
    //                 북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());   //1: 벽, 0: 빈칸
            }
        }
        //청소된 칸은 2로 변경
        dfs(start);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(Point p) {
        //1. 현재 칸 청소
        if (map[p.r][p.c] == 0) map[p.r][p.c] = 2;

        boolean iscleaned = true;
        for (int d = 0; d < 4; d++) {
            int nr = p.r + dr[d];
            int nc = p.c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (map[nr][nc] == 0) {
                iscleaned = false;
                break;
            }
        }
        //2. 현재 사방 칸에 청소되지 않은 빈 칸이 없는 경우
        if (iscleaned) {
            //한 칸 후진한 좌표 뽑기
            int ndir = setDir2(p.dir);
            int nr = p.r + dr[ndir];
            int nc = p.c + dc[ndir];
            if (map[nr][nc] != 1) {
                dfs(new Point(nr, nc, p.dir));
            }
        } else {     //3. 현재 칸 사방에 청소되지 않은 빈칸 있을 경우
            for (int d = 0; d < 4; d++) {

                int ndir = setDir(p.dir);   //3-1.

                int nr = p.r + dr[ndir];
                int nc = p.c + dc[ndir];

                if (map[nr][nc] == 0) {
                    dfs(new Point(nr, nc, ndir));
                    return;
                }
                p.dir = ndir;
            }
        }
    }
    //내 기준 후진
    private static int setDir2(int dir) {
        dir += 2;
        if(dir>3) dir-=4;
        return dir;
    }

    //반시계방향으로 90도 회전
    private static int setDir(int dir) {
        if (dir == 0) dir = 3;
        else dir -= 1;
        return dir;

    }
}