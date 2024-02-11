package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15993_123더하기8 {
    static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] input = new int[T];
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        long[][] dp = new long[100000+1][2];    //0:홀, 1:짝
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;
        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i]][0]).append(" ").append(dp[input[i]][1]).append("\n");
        }
        System.out.println(sb);
    }
}
