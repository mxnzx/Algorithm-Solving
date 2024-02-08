package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxK = -1, maxN = -1;
        int[][] input = new int[T][2];
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            maxK = Math.max(maxK, k);
            maxN = Math.max(maxN, n);
            input[i][0] = k;
            input[i][1] = n;
        }
        int[][] dp = new int[maxK+1][maxN+1];
        for (int i = 0; i <= maxK; i++) {
            for (int j = 1; j <= maxN; j++) {
                if(i == 0) dp[i][j] = j;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i][0]][input[i][1]]).append("\n");
        }
        System.out.println(sb);
    }
}
