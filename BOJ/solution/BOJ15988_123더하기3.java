package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988_123더하기3 {
    static int T;
    static long[] dp;
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int maxN = -1;
        int[] input = new int[T];
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            input[t] = n;
            maxN = Math.max(maxN, n);
        }
        //Bottom-up
        int size = Math.max(maxN, 3);
        dp = new long[size+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= maxN; i++) {
            //dp[i] = ((dp[i-3] + dp[i-2]) % MOD + dp[i-1]) % MOD;
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD;
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i]]).append("\n");
        }

        System.out.println(sb);
    }
}
