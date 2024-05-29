package solution;

import java.io.*;
import java.util.*;

public class BOJ1347_미로만들기 {

    static int N;
    static char[][] map = new char[101][101];
    static int dir = 2;
    static int nowR = 50, nowC = 50;
    static int sr = nowR, sc = nowC, er = nowR, ec = nowC;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};

    static void moveMaze(char op) {
        if(op == 'L') {
            dir = (dir == 0) ? 3 : dir-1;
        } else if (op == 'R') {
            dir = (dir + 1) % 4;
        } else {
            nowR += dr[dir];
            nowC += dc[dir];
            sr = Math.min(sr, nowR);
            sc = Math.min(sc, nowC);
            er = Math.max(er, nowR);
            ec = Math.max(ec, nowC);
            map[nowR][nowC] = '.';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] order = br.readLine().toCharArray();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(map[i], '#');
        }
        map[nowR][nowC] = '.';

        for (int i = 0; i < N; i++) {
            moveMaze(order[i]);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                ans.append(map[i][j]);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
