package solution;

import java.io.*;
import java.util.*;

public class BOJ13460_구슬탈출2 {
    static class Loc {
        int r;
        int c;

        Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Beads {
        Loc red;
        Loc blue;
        int moveCnt;

        public Beads(Loc red, Loc blue, int moveCnt) {
            this.red = red;
            this.blue = blue;
            this.moveCnt = moveCnt;
        }
    }

    static int N, M;
    static char[][] map;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static Loc red, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j); //#:장애물 .:빈칸 O:구멍
                if (map[i][j] == 'R') red = new Loc(i, j);
                if (map[i][j] == 'B') blue = new Loc(i, j);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Beads> q = new LinkedList<>();
        q.add(new Beads(red, blue, 0));

        while (!q.isEmpty()) {
            Beads cur = q.poll();
            Loc curRed = cur.red;
            Loc curBlue = cur.blue;

            if (cur.moveCnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                //쭉 간다: 현재의 방향 d에 맞춰서 가다가 #만나면 멈춤. 또는 더이상 이동안하는 구슬 만나면 멈춰
                //빨간 구슬이 가다가 구멍을 만나면 일단 대기.
                //파란 구슬이 가다가 구멍을 만나면 패스. 못만난다면 완료 > 리턴한다.
                //동시에 움직이니까 움직일 땐 상대방 R,B의 위치 고려하지 않음
                boolean isRedHole = false, isBlueHole = false;
                boolean isGoRed = true, isGoBlue = true;
                int nrR = 0, ncR = 0, nrB = 0, ncB = 0;
                int n = 1;

                // 이동
                boolean isNext = false;
                while (isGoRed || isGoBlue) {
                    // 현재 위치에서 한칸씩 이동
                    if (isGoRed) {
                        nrR = curRed.r + dr[d] * n;
                        ncR = curRed.c + dc[d] * n;
                    }
                    if (isGoBlue) {
                        nrB = curBlue.r + dr[d] * n;
                        ncB = curBlue.c + dc[d] * n;
                    }

                    if (map[nrR][ncR] == 'O') {
                        isRedHole = true;
                        isGoRed = false;
                    }
                    if (map[nrB][ncB] == 'O') {
                        isBlueHole = true;
                        isGoBlue = false;
                    }

                    if (isBlueHole) {
                        isNext = true; //파란구슬들어가면 더이상 이동하지않고 탈출한다.
                        break;
                    }

                    // 빨간구슬>> 파란구슬이 못움직이는 상황에서 겹치거나 벽을 만나면 더이상 못감
                    if ((!isGoBlue && nrR == nrB && ncR == ncB) || map[nrR][ncR] == '#') {
                        nrR = curRed.r + dr[d] * (n - 1);
                        ncR = curRed.c + dc[d] * (n - 1);
                        isGoRed = false;
                    }
                    // 빨간구슬이 있는 곳이거나 벽이 있는 곳이면 더이상 못감
                    if ((nrR == nrB && ncR == ncB) || map[nrB][ncB] == '#') {
                        nrB = curBlue.r + dr[d] * (n - 1);
                        ncB = curBlue.c + dc[d] * (n - 1);
                        //빨간색이 내가 갔을 줄 알고 내 자리에 있으면 얘도 돌려보내야 함
                        if (nrR == nrB && ncR == ncB) {
                            nrR = curRed.r + dr[d] * (n - 1);
                            ncR = curRed.c + dc[d] * (n - 1);
                            isGoRed = false;
                        }
                        isGoBlue = false;
                    }
                    n++;
                }
                if (isNext) continue;
                if(isRedHole) return cur.moveCnt + 1;
                q.add(new Beads(new Loc(nrR, ncR), new Loc(nrB, ncB), cur.moveCnt + 1));
            }
        }
        return -1;
    }
}
