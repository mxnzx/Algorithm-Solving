package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15992_123더하기7 {
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int maxN = -1, maxM = -1;
        int[][] input = new int[T][2];
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            input[tc][0] = Integer.parseInt(st.nextToken());
            input[tc][1] = Integer.parseInt(st.nextToken());
            maxN = Math.max(maxN, input[tc][0]);
            maxM = Math.max(maxM, input[tc][1]);
        }
        int size = Math.max(maxM, 3);
        long[][] dp = new long[maxN + 1][size + 1];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;
        for (int i = 4; i <= maxN; i++) {
            for (int j = 2; (i < maxM) ? j <= i : j <= maxM; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % MOD + dp[i - 3][j - 1]) % MOD;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i][0]][input[i][1]]).append("\n");
        }
        System.out.println(sb);

    }
}
