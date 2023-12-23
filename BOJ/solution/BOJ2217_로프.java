package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217_로프 {
    static int N;
    static Integer[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new Integer[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weights, Collections.reverseOrder());
        int answer = weights[0];
        for (int i = 1; i < weights.length; i++) {
            answer = Math.max(answer, weights[i] * (i+1));

        }
        System.out.println(answer);
    }
}
