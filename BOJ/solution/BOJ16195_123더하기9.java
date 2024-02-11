package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16195_123더하기9 {
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[][] input = new int[T][2];
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            input[tc][0] = Integer.parseInt(st.nextToken());
            input[tc][1] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[1000 + 1][1000 + 1];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;
        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % MOD + dp[i - 3][j - 1]) % MOD;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long ans = 0;
            for (int j = 1; j <= input[i][1]; j++) {
                ans += (dp[input[i][0]][j] % MOD);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

}
