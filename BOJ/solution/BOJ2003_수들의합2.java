package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_수들의합2 {
    static int N, M;
    static int[] seq;
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
        // 투포인터, 누적합
        int start=0, end=0, cnt=0;
        long sum = seq[start];
        while(true) {
            if(sum == M) cnt++;
            if(start == N-1) break;
            if(sum<=M && end < N-1) {
                end++;
                sum += seq[end];
            } else {
                sum -= seq[start];
                start++;
            }
        }
        System.out.println(cnt);
    }
}
