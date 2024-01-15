package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10844_쉬운계단수 {
    static int N;
    static long[][] dp;
    static final long MOD = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];    // 길이, 0~9
        /*
        1234567890
        1 >> 1 ~ 9
        2 >> 10  12  21   23                 87 89   98  2*9 - 1(90)>>  17
        3 >> 101 121 123, 210 213  232 234 ..
         */
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1] % MOD;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
            dp[i][9] = dp[i-1][8] % MOD;
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[N][i];
        }
        System.out.println(result % MOD);
    }
}
