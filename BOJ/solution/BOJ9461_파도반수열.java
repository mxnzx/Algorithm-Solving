package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461_파도반수열 {
    static int T, N;
    static int[] inputs;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        inputs = new int[T];
        int max = -1;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            inputs[tc] = N;
            max = Math.max(max, N);
        }
        dp = max < 6 ? new long[5] : new long[max+1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for (int i = 6; i <= max; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[inputs[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
