package solution;

import java.util.*;
import java.io.*;

public class BOJ11048_이동하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3^(10^6) 완탐하면 시초난다.
        // 현재 기준 상,좌,좌상까지의 최댓값이 나를 결정함.
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        System.out.println(dp[n][m]);
    }
}
