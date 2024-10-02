package solution;

import java.io.*;
import java.util.*;

public class BOJ2792_보석상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];
        long total = 0L;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            total += jewels[i];
        }


        long lo = total / N;
        long hi = total;
        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long takenCnt = 0L;

            for (int i = 0; i < M; i++) {
                takenCnt += jewels[i] % mid == 0 ? jewels[i] / mid : jewels[i] / mid + 1;
            }

            if(takenCnt <= N) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
