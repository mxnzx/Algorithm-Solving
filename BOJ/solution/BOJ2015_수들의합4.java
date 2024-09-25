package solution;

import java.util.*;
import java.io.*;

public class BOJ2015_수들의합4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
        }

        long cnt = 0L;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        for (int i = 1; i <= N; i++) {
            cnt += prefixSum.getOrDefault(sums[i] - K, 0);
            prefixSum.put(sums[i], prefixSum.getOrDefault(sums[i], 0) + 1);
        }
        System.out.println(cnt);
    }
}
