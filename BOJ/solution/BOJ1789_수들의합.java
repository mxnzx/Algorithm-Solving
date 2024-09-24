package solution;

import java.util.*;
import java.io.*;

public class BOJ1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        // 서로 다른 N개의 자연수의 합의 최댓값을 구하는 문제
        // 가장 작은 수부터 더해나간다.
        long val = 1;
        long cnt = 0;
        while(true) {
            if(S - val >= 0) {
                S -= val;
                val++;
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}