package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int[] ans = new int[N];
        int ansIdx = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                int n = q.poll();
                q.add(n);
            }
            ans[ansIdx++] = q.poll();
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        for (int n : ans) {
            answer.append(n).append(", ");
        }
        answer.replace(answer.length() - 2, answer.length(), ">");
        System.out.println(answer);
    }
}
