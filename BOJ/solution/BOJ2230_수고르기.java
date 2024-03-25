package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(N, M, seq));
    }

    private static int solution(int n, int m, int[] seq) {
        Arrays.sort(seq);
        int start = 0, end = 0;
        int gap = Integer.MAX_VALUE;
        while(end < n) {
            int tmp = seq[end] - seq[start];
            if(tmp < m) {
                end++;
            } else if(tmp == m) {
                return m;
            } else {
                gap = Math.min(gap, tmp);
                start++;
            }
        }
        return gap;
    }
}
