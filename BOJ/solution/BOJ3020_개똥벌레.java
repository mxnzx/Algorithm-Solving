package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020_개똥벌레 {
    static int N, H;
    static int[] bottoms, tops;    // 장애물 개수가 들어간다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bottoms = new int[H+2];
        tops = new int[H+2];
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(i % 2 != 0) {
                bottoms[n]++;
            } else {
                tops[H-n+1]++;
            }
        }

        for (int i = 1; i <= H; i++) {
            bottoms[i] += bottoms[i-1];
        }
        for (int i = H-1; i >= 1; i--) {
            tops[i] += tops[i+1];
        }

        //첫번째~H구간까지 차례대로 장애물의 수 확인
        int min=N, cnt=0;
        for (int i = 1; i <= H; i++) {
            // 석순 개수 + 종유석 개수
            int obs = (bottoms[H] - bottoms[i-1]) + (tops[1] - tops[i+1]);
            if(obs == min) cnt++;
            if(obs < min) {
                min = obs;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
