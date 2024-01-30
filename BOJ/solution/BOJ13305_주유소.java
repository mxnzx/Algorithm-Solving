package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13305_주유소 {
    static int N;
    static int[] oil, dist;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        oil = new int[N];
        dist = new int[N];
        dp = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        // dp배열에 현재까지의 최소비용을 저장, 변수 하나 두어서 최소 비용값 두고, 바뀌면 갱신한다.
        int minCost = oil[0];
        dp[1] = (long) minCost * dist[1];
        for (int i = 2; i < N; i++) {
            if(minCost > oil[i-1]) minCost = oil[i-1];
            dp[i] = dp[i-1] + (long) dist[i] * minCost;
        }
        System.out.println(dp[N-1]);
    }
}
