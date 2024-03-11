package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309_동물원 {
    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][3];    //0:놓지않는경우 1:첫 칸에 놓는 경우 2:둘째칸에놓는경우
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        // n번째 줄에서의 경우의 수는 3가지이다.
        // 놓지 않는 경우, 첫칸에 놓는 경우, 둘째칸에 놓는 경우
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
        System.out.println(((dp[N][0] + dp[N][1]) % MOD + dp[N][2]) % MOD);
    }
}
