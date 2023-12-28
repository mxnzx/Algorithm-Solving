package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2293_동전1 {
    static int n, k;
    static int[] coins, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n+1];
        dp = new int[k+1];    //idx=금액, val=가능한 경우의 수
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        /*
        동전 가치가 작은 순서대로 정렬한다.
        동전 가치가 가장 작은 아이는 경우의 수가 1이다.
        동전을 1종류 쓸 경우, 2종류 쓸 경우,, ... 를 순회(i)하며 합이 되는 경우의 수(j)를 갱신한다.
        dp[i](동전 종류를 추가한 경우의 수) = dp[i](기존 동전을 쓰는 경우의 수) + dp[i-coin](현재 추가한 동전값을 뺀 값의 경우의 수)
         */
        Arrays.sort(coins);
        dp[coins[0]] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
