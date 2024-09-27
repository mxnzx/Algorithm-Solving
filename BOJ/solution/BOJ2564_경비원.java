package solution;

import java.util.*;
import java.io.*;


public class BOJ2564_경비원 {

    static int N, M;
    static int[][] loc;

    static void calcLoc(int idx, int dir, int dist) {
        if (dir == 1) {
            loc[idx][0] = 0;
            loc[idx][1] = dist;
        } else if (dir == 2) {
            loc[idx][0] = M;
            loc[idx][1] = dist;
        } else if (dir == 3) {
            loc[idx][0] = dist;
            loc[idx][1] = 0;
        } else {
            loc[idx][0] = dist;
            loc[idx][1] = N;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[K + 1][2]; //0:dir 1:loc
        loc = new int[K + 1][2]; //0:r 1:c
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            calcLoc(i, map[i][0], map[i][1]);
        }
        int dgDir, dgDist;
        st = new StringTokenizer(br.readLine());
        dgDir = Integer.parseInt(st.nextToken());
        dgDist = Integer.parseInt(st.nextToken());
        calcLoc(0, dgDir, dgDist);
        boolean isNS = dgDir == 1 || dgDir == 2;
        // 서로 방향이 수작이면 그냥 뺀 값이고, 수평이면 사이값 + Math.min(본인들 값의 합, 뺀 값의 합)
        int ans = 0;
        for (int i = 1; i <= K; i++) {
            boolean nORs = map[i][0] == 1 || map[i][0] == 2;
            if (map[i][0] == dgDir) {
                ans += Math.abs(dgDist - map[i][1]);
            } else if (nORs ^ isNS) { // 수직이다
                ans += Math.abs(loc[i][0] - loc[0][0]) + Math.abs(loc[i][1] - loc[0][1]);
            } else {
                if (isNS) {
                    ans += M + Math.min(loc[i][1] + loc[0][1], N - loc[i][1] + N - loc[0][1]);
                } else {
                    ans += N + Math.min(loc[i][0] + loc[0][0], M - loc[i][0] + M - loc[0][0]);
                }
            }
        }

        System.out.println(ans);
    }
}
