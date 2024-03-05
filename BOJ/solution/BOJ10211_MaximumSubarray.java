package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10211_MaximumSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            st= new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[N+1];
            dp[1] = arr[1];
            int max = arr[1];
            for (int i = 1; i <= N; i++) {
                dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
