package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        //내림차순 정렬 - 맨 뒤가 max값
        Arrays.sort(score);
        int max = score[N - 1];
        float sum = 0;
        //형변환 주의하기
        for (int i = 0; i < N; i++) {
            sum += (float) score[i] / max * 100;
        }
        System.out.println(sum / N);
    }
}
