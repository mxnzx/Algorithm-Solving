package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxN = -1;
        int[] input = new int[T];
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, n);
            input[tc] = n;
        }
        /*
        1로만 이루어진 경우의 수는 어차피 하나밖에 없다.
        3과 1로만 이루어진 경우의 수는 i / 3.
        이때 2가 하나 이상 들어있는 애들은 dp[i-2]에서 찾을 수 있다.
        dp배열 안에는 이 셋을 다 더해 경우의 수를 넣는다. <<1,3이 고정이라 굳이 이차원 배열을 두지 않는다.
         */
        int size = Math.max(maxN, 3);
        int[] dp = new int[size+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= maxN; i++) {
            dp[i] = 1 + dp[i-2] + i/3;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[input[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
