package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12852_1로만들기2 {
    static int N;
    static int[] dp, seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        seq = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = dp(N);
        System.out.println(ans);
        StringBuilder sb= new StringBuilder();
        int num = N;
        for (int i = 0; i <= ans; i++) {
            sb.append(num).append(" ");
            num = seq[num];
        }
        System.out.println(sb);

    }

    // bottom-up
    private static int dp(int n) {
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                seq[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                seq[i] = i / 2;
            }
            if (dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                seq[i] = i - 1;
            }
        }
        return dp[n];

    }
}
