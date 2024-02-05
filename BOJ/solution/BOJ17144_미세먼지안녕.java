package solution;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144_미세먼지안녕 {
    static class Loc {
        int r,c,val;
        Loc(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    static int[][] map;
    static int R, C, T;
    static final int[][] dr = {{0,-1,0,1}, {0,1,0,-1}};
    static final int[][] dc = {{1,0,-1,0}, {1,0,-1,0}};
    static Queue<Loc> q;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        q = new LinkedList<>();
        Loc[] airCleaner = new Loc[2];
        int tmp = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) airCleaner[tmp++] = new Loc(i,j,-1);
                else if(map[i][j] != 0) q.add(new Loc(i,j,map[i][j]));
            }
        }
        /*
        공기청정기 - 1열에 항상 고정
        벽을 만나면 방향 바꾼다: 좌->우->상->좌->하  좌->우->하->좌->상
        큐에 미세먼지가 있는 칸들을 넣는다.(r,c,val)
        확산시킨다
        공기청정기 돌린다
         */
        int time = 0;
        while(time++ < T) {
            spreadDustAir();
            for (int i = 0; i < 2; i++) {
                moveAir(airCleaner[i], i);
            }
            // 큐에 다시 담는다
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0)  q.add(new Loc(i,j,map[i][j]));
                }
            }
        }
        int fineDustCnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) fineDustCnt += map[i][j];
            }
        }
        System.out.println(fineDustCnt);

    }

    private static void moveAir(Loc airCleaner, int order) {
        //방향 필요
        int dir = 0;
        int r = airCleaner.r;
        int c = airCleaner.c;
        int val = 0;
        while(true) {
            int nr = r + dr[order][dir];
            int nc = c + dc[order][dir];
            //만약 벽을 만나면, 방향을 바꾸고, nr,nc도 바뀌어야 한다
            if(nr<0 || nr>=R || nc<0 || nc>=C) {
                dir++;
                continue;
            }
            // 공기 청정기를 만나면 빠져나온다
            if(nr == airCleaner.r && nc == airCleaner.c) break;

            int nval = map[nr][nc];
            map[nr][nc] = val;
            val = nval;
            r = nr;
            c = nc;
        }
    }

    private static void spreadDustAir() {
        // 큐에 들어간 미세먼지를 확산
        while(!q.isEmpty()) {
            Loc current = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[0][d];
                int nc = current.c + dc[0][d];
                int nVal = (int) Math.floor(current.val / 5.0);
                if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc] == -1) continue;
                map[nr][nc] += nVal;
                map[current.r][current.c] -= nVal;
            }
        }
    }
}
