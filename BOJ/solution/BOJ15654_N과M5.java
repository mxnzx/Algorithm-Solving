package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654_N과M5 {
    static int N,M;
    static int[] arr, sel;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sel = new int[M];   //길이가 M인 수열
        // 순열 뽑기
        permutation(new boolean[N], 0,0);

        System.out.println(sb);
    }
    private static void permutation(boolean[] visited, int idx, int k) {

        if(sel.length == k) {
            for(int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                sel[k] = arr[i];
                visited[i] = true;
                permutation(visited, idx+1, k+1);
                visited[i] = false;
            }
        }

    }
}
