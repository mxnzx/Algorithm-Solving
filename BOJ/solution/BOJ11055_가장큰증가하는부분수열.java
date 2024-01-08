package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11055_가장큰증가하는부분수열 {
    static int N;
    static int[] seq, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        // 현재 i의 값이 비교 대상인 j보다 크기만 하면 그 이전 애들보다 크다는 것은 명백하다.
        for (int i = 0; i < N; i++) {
            dp[i] = seq[i];
            for (int j = 0; j < i; j++) {
                if(seq[j] < seq[i]) dp[i] = Math.max(dp[i], dp[j] + seq[i]);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
