package solution;

import java.io.*;
import java.util.*;

public class BOJ17390_이건꼭풀어야해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        int[] prefixSum = new int[n];
        prefixSum[0] = seq[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + seq[i];
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            ans.append(prefixSum[e] - prefixSum[s] + seq[s]).append("\n");
        }
        System.out.println(ans);

    }
}
