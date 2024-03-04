package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11060_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        // 처음에 그리디로 접근해서 갈 수 있는 범위 내의 가장 큰 수가 있는 칸으로 점프하려고 했는데
        // 이건 최적해를 구해내지 못함.
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        if(N == 1) {
            System.out.println(dp[1]);
            return;
        }
        for (int i = 1; i <= N; i++) {
            int n = seq[i]; //몇칸갈수있는지
            if(dp[i] == -1) break;
            for (int j = 1; j <= n; j++) { //현 칸에서부터 몇번째 떨어졌는지;
                dp[i+j] = dp[i+j] == -1 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i+j]);
                if(i+j == N) {
                    // 가장 빨리 도착했으므로 그냥 출력하고 끝내면 됨.
                    System.out.println(dp[N]);
                    return;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
