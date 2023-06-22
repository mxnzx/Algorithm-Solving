package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010_다리놓기 {
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        System.out.println(Long.MAX_VALUE);
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            long a=1, b=1;
            int re = N > M/2 ? M-N : N;
            for (int i = 1, j = M; i <= re; i++, j--) {
                a *= j;
                b *= i;
                System.out.println("a:" + a + "  " + "b:" + b);
            }
            sb.append(a/b).append("\n");
        }
        System.out.println(sb);
    }
}
