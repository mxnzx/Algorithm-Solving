package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294_동전2 {
    static int n, k;
    static int[] coins, dp;
    static final int INF = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n+1];
        dp = new int[k+1];    //idx=금액, val=최소 사용 동전 개수
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        /*
        동전 오름차순 정렬.
        동전을 i개의 종류를 쓸 거다 -> 순회
        dp에는 이전의 동전으로 만들었던 최소 동전 개수와
        현재 동전을 추가했을 때 사용하는 동전 개수(현재 동전을 추가하는거니까 dp[k-현재동전값]+1)를 >>> DP, 값 계속 갱신
        비교하며 작은 값을 넣는다
         */
        Arrays.sort(coins);
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(coins[i] == coins[i-1]) continue;    //중복 제거
            for (int j = coins[i]; j <= k; j++) {
                //점화식: dp[n] = Math.min(dp[n], dp[n-coin[i]]+1
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[k] == INF ? -1 : dp[k]);

    }
}
