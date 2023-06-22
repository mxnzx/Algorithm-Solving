package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20440_니가싫어싫어어쩌고모기송 {
    static int N;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        time = new int[2100000001];
        N = Integer.parseInt(br.readLine());
        int in, out;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            in = Integer.parseInt(st.nextToken());
            out = Integer.parseInt(st.nextToken());

        }
    }
}
