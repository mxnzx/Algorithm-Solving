package solution;

import java.util.*;
import java.io.*;

public class BOJ1749_점수따먹기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int[][] prefixSum = new int[N+1][M+1];
        // 누적 합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = map[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // (i,j) ~ (k, l)
                for (int k = i; k <= N; k++) {
                    for (int l = j; l <= M; l++) {
                        int tmp = prefixSum[k][l] - prefixSum[i-1][l] - prefixSum[k][j-1] + prefixSum[i-1][j-1];
                        maxValue = Math.max(maxValue, tmp);
                    }
                }
            }
        }
        System.out.println(maxValue);
    }
}
