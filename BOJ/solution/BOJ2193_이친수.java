package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] cnt = new long[N + 1][2];
        cnt[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            cnt[i][0] = cnt[i-1][0] + cnt[i-1][1];
            cnt[i][1] = cnt[i-1][0];
        }
        System.out.println(cnt[N][0] + cnt[N][1]);
    }
}
