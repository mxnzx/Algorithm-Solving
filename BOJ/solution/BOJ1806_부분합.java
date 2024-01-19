package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
    static int N, S;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());    //이 합 이상
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        long sum = seq[start];
        while(start <= end) {
            if(sum >= S) {
                min = Math.min(min, end-start+1);
            }
            if(sum <= S && end < N - 1) {
                end++;
                sum += seq[end];
            } else {
                sum -= seq[start];
                start++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
}
