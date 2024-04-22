package solution;

import java.io.*;
import java.util.*;

public class BOJ16198_에너지모으기 {

    static int n, max;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        weights = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, new boolean[n + 1]);
        System.out.println(max);
    }

    static void backtracking(int sum, boolean[] visited) {

        max = Math.max(max, sum);

        for (int i = 2; i < n; i++) {

            if(visited[i]) continue;

            int left = i - 1, right = i + 1;
            boolean flag = false;
            while (left > 0) {
                if (!visited[left]) {
                    flag = true;
                    break;
                }
                left--;
            }
            if (!flag) continue;

            flag = false;
            while (right <= n) {
                if (!visited[right]) {
                    flag = true;
                    break;
                }
                right++;
            }
            if (!flag) continue;

            visited[i] = true;
            backtracking(sum + (weights[left] * weights[right]), visited);
            visited[i] = false;
        }
    }
}
