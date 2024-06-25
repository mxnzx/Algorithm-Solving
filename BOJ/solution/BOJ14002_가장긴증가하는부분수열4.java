package solution;

import java.util.*;
import java.io.*;

public class BOJ14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] prev = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            prev[i] = i;
            dp[i] = 1;
        }

        int maxIdx = 0, maxVal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(seq[j] < seq[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if(maxVal < dp[i]) {
                maxVal = dp[i];
                maxIdx = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int now = maxIdx;
        stack.push(seq[now]);
        while(true) {
            if(now == prev[now]) break;
            stack.push(seq[prev[now]]);
            now = prev[now];
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.empty()) {
            ans.append(stack.pop()).append(" ");
        }

        System.out.println(maxVal);
        System.out.println(ans);
    }
}
