package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2302_극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        solution(N, vip);
    }

    private static void solution(int n, int[] vip) {
        int answer = 1;
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int start = 1;
        for (int v : vip) {
            answer *= dp[v - start];
            start = v + 1;
        }
        answer *= dp[n + 1 - start];
        System.out.println(answer);
    }
}
