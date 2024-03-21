package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9656_돌게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[0] = true;
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        for (int i = 4; i <= N; i++) {
            if(!dp[i-1] && !dp[i-3]) dp[i] = true;
        }
        System.out.println(dp[N] ? "SK" : "CY");

    }
}
