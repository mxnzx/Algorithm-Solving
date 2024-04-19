package solution;

import java.io.*;
import java.util.*;

public class BOJ15664_N과M10 {

    static int N, M;
    static int[] arr;
    static StringBuilder ans = new StringBuilder();

    static void comb(int[] pick, int p, int idx) {

        if(p == pick.length) {
            for(int n : pick) ans.append(n).append(" ");
            ans.append("\n");
            return;
        }

        int prev = 0;
        for(int i=idx; i<N; i++) {
            if(prev == arr[i]) continue;
            pick[p] = arr[i];
            prev = arr[i];
            comb(pick, p+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 중복되는 수열 여러번 안됨
        comb(new int[M], 0, 0);

        System.out.println(ans);
    }
}
