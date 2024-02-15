package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11663_선분위의점 {
    static int N, M;
    static int[] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int startIdx = Arrays.binarySearch(dots, start);
            int endIdx = Arrays.binarySearch(dots, end);

            startIdx = startIdx < 0 ? -(startIdx + 1) : startIdx;
            endIdx = endIdx < 0 ? -(endIdx + 1) : endIdx+1;
            sb.append(endIdx - startIdx).append("\n");
        }
        System.out.println(sb);

    }
}
