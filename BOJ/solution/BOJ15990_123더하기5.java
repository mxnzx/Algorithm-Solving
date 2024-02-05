package solution;

import java.io.*;

public class BOJ15990_123더하기5 {
    static int T, n, max;
    static long[][] dp;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        max = -1;
        seq = new int[T];
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            seq[i] = n;
            max = Math.max(max, n);
        }
        dp = new long[max+1][4];
        dp[1][1] = 1;
        if(max>1) dp[2][2] = 1;
        if(max>2) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }
        if(max>3) {
            for (int i = 4; i <= max; i++) {
                dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
                dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
                dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
            }
        }
        for (int i = 0; i < T; i++) {
            int n = seq[i];
            sb.append((dp[n][1] + dp[n][2] + dp[n][3])% 1000000009).append("\n");
        }
        System.out.println(sb);
    }
}
