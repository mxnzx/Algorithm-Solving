package solution;

import java.util.*;
import java.io.*;

public class BOJ10819_차이를최대로 {

    static int N, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 브루트포스
        backtracking(0, 0, new boolean[N], -1);
        System.out.println(max);
    }

    private static void backtracking(int idx, int sum, boolean[] visited, int lastIdx) {
        if(idx == N) {
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            // 마지막으로 선택된 원소와 현재 원소의 차이를 계산하여 sum에 추가
            int newSum = (lastIdx == -1) ? 0 : sum + Math.abs(arr[lastIdx] - arr[i]);
            visited[i] = true;
            backtracking(idx+1, newSum, visited, i);
            visited[i] = false;
        }
    }
}
