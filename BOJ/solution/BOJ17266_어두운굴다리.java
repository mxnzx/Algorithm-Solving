package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266_어두운굴다리 {
    static int N, M;
    static int[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // 굴다리 길이
        M = Integer.parseInt(br.readLine());    // 가로등 개수
        loc = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }
        // h 길이가 될 수 있는 경우의 수: 1~N
        int lo = 1, hi = N, mid = (lo + hi) / 2;
        while(lo < hi) {
            boolean isDone = false;
            int beforeRight=0;
            for (int i = 0; i < M; i++) {
                int left = loc[i] - mid;
                int right = loc[i] + mid;

                if(beforeRight < left) break;
                beforeRight = right;
                if(right >= N) {
                    isDone = true;
                    break;
                }
            }
            // N을 전부 만족하면 hi = mid;
            if(isDone) {
                hi = mid;
            } else {    // 만족하지 못하면 lo = mid + 1;
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        System.out.println(mid);
    }
}
