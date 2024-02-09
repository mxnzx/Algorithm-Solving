package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15991_123더하기6 {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxN = -1;
        int[] input = new int[T];
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, n);
            input[tc] = n;
        }

        int size = Math.max(maxN, 6);
        int[] dp = new int[size+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        for (int i = 6; i <= maxN; i++) {
            dp[i] = ((dp[i-2] + dp[i-4]) % MOD + dp[i-6]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
