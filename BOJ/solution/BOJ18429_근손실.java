package solution;

import java.io.*;
import java.util.*;

public class BOJ18429_근손실 {
    static int N, K, ans;
    static int[] weights;
    static boolean[] visited;

    static void backtracking(int w, int cnt) {

        if(w < 500) return;

        if(cnt == N) {
            ans++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(w+weights[i]-K, cnt+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        // 10^6
        backtracking(500, 0);
        System.out.println(ans);


    }
}
