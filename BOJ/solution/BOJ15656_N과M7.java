package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656_N과M7 {
    static int N, M;
    static int[] arr;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 중복 순열
        Arrays.sort(arr);
        func(0, new int[M], new boolean[N]);
        System.out.println(answer);
    }

    private static void func(int p, int[] pick, boolean[] visited) {

        if (p == M) {
            for (int n : pick) {
                answer.append(n).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            //if(visited[i]) continue;
            pick[p] = arr[i];
            visited[i] = true;
            func(p + 1, pick, visited);
            visited[i] = false;
        }
    }
}
