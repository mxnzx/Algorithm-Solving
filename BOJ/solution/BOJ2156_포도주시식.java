package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2156_포도주시식 {
    static int[] wines,dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wines = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = wines[1];
        if(n>=2) dp[2] = wines[1] + wines[2];
        for (int i = 3; i <= n; i++) {
            // i번째를 선택하지 않을때, i-1번째를 선택하지 않고 i번째를 선택할 때, i-1번째와 i번째를 선택할 때 세가지 경우 비교
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wines[i-1]) + wines[i]);
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n]);
    }
}
