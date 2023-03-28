package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {
    static int N,res;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //메모 -> 최소비용이 N이다
        dp = new int[N][N];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        //상향식(바텀 업) R:0 G:1 B:2
        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }
        System.out.println(Math.min(Math.min(cost[N-1][0],cost[N-1][1]),cost[N-1][2]));
    }
}
