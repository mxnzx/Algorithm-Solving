package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458_시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] zone = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            zone[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(solution(zone, B, C));
    }

    private static long solution(int[] zone, int b, int c) {

        long minCnt = 0;

        minCnt += zone.length;
        for (int i = 0; i < zone.length; i++) {
            zone[i] -= b;
        }

        for (int i = 0; i < zone.length; i++) {
            if(zone[i] <= 0) continue;
            minCnt += (zone[i] / c);
            if (zone[i] % c != 0) minCnt++;
        }
        return minCnt;


    }
}
