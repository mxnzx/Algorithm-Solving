package solution;

import java.io.*;
import java.util.*;

public class BOJ2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 위치를 옮기는 아이들의 수를 최소로
        int n = Integer.parseInt(br.readLine());
        int[] children = new int[n];
        for (int i = 0; i < n ; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }
        // 증가하는 애들을 제외한 나머지의 개수를 세면 그게 최소다.

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(children[i] > children[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        Arrays.sort(dp);
        System.out.println(n - dp[n - 1]);
    }
}
