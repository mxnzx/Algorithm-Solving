package solution;

//알고리즘 분류 - 누적합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());      //온도 측정한 전체 날짜 수
        int k = Integer.parseInt(st.nextToken());      //합을 위한 연속적인 날짜의 수

        st = new StringTokenizer(br.readLine());
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = Integer.parseInt(st.nextToken());
        }

        //누적합 이용해서 풀기
        //초기 sum, max 구하기
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=tmp[i];
        }
        int max = Math.max(-10000000, sum);
        //누적합. 우측에서 다음 한 칸 더하고,맨 왼쪽 빼주고를 반복
        for (int i = 0; i < n - k; i++) {
            sum+=tmp[i+k]-tmp[i];
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }
}

