package solution;

import java.io.*;
import java.util.*;

public class BOJ18111_마인크래프트 {

    static int N, M, B, minTime = Integer.MAX_VALUE, heightToMinTime;
    static int time, blockCnt;
    static int[][] land;

    static boolean trySameHeight(int h) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int now = land[i][j];
                if (h > now) {
                    blockCnt -= h - now;
                    time += (h - now);
                }
                if (blockCnt < 0) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        land = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 브루트포스 -모든 높이 계산
        for (int h = 0; h <= 256; h++) {
            blockCnt = B;
            time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int now = land[i][j];
                    if (h < now) {
                        blockCnt += now - h;
                        time += 2 * (now - h);
                    }
                }
            }
            if (minTime < time) continue;

            // 한번 더 수행하면서 더 작은 애들 채울 수 있는지 확인한다
            if (trySameHeight(h) && minTime >= time) {
                minTime = time;
                heightToMinTime = h;
            }
        }
        System.out.println(minTime + " " + heightToMinTime);
    }
}