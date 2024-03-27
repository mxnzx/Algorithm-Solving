package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663_N과M9 {
    static int N, M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        solution(0, new boolean[N], new int[M]);
        System.out.println(sb);

    }

    private static void solution(int p, boolean[] visited, int[] pick) {

        if(p == M) {
            for(int n : pick) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int past = -1;
        for(int i=0; i<N; i++) {
            int current = seq[i];
            if(visited[i] || current == past) continue;
            pick[p] = current;
            past = current;
            visited[i] = true;
            solution(p+1, visited, pick);
            visited[i] = false;
        }
    }
}
