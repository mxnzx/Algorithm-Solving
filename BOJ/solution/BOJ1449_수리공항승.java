package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1449_수리공항승 {
    static int N, L;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pos = new int[1001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pos[Integer.parseInt(st.nextToken())]++;
        }
        int n = 1, answer = 0;
        while(n <= 1000) {
            if(pos[n] == 0) {
                n++;
                continue;
            }
            n += L;     //
            answer++;
        }
        System.out.println(answer);

    }
}
