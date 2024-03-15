package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657_N과M8 {

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
        // 중복 조합
        Arrays.sort(arr);
        func(0, 0, new int[M]);
        System.out.println(answer);
    }

    private static void func(int idx, int p, int[] pick) {

        if (p == M) {
            for (int n : pick) {
                answer.append(n).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            pick[p] = arr[i];
            func(i+1, p + 1, pick);
        }
    }
}
