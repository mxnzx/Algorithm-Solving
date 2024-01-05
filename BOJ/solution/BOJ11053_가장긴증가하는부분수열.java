package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053_가장긴증가하는부분수열 {
    static int n;
    static int[] seq, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        /*
        LIS(최장 증가 부분 수열) 문제.
        오름차순으로 구성 가능한 원소들을 선택하여 최대의 길이를 찾아내는 문제다.
        dp[] 배열에는 이전 값들과 비교하며 최대 길이 값을 담는다.
        현재 순회중인 i를 기준으로 0~i-1 의 애들과 값을 비교하며
        현재 i의 값이 크다면, dp[i]와 dp[j]+1을 비교해 갱신한다.
        dp 배열 중에서 가장 큰 값이 LIS 길이이다.
         */
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(seq[j] < seq[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
