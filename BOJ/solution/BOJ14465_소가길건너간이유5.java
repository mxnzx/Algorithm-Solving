package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14465_소가길건너간이유5 {
    static int N, K, B;
    static boolean[] stoplight;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        stoplight = new boolean[N+1];
        for (int i = 1; i <= B; i++) {
            int n = Integer.parseInt(br.readLine());
            stoplight[n] = true;
        }

        int brokenLightCnt = 0;
        for (int i = 1; i <= K; i++) {
            if(stoplight[i]) brokenLightCnt++;
        }
        int min = brokenLightCnt;

        for (int i = K+1; i <= N; i++) {
            if(stoplight[i-K]) brokenLightCnt--;
            if(stoplight[i]) brokenLightCnt++;
            min = Math.min(min, brokenLightCnt);
        }
        System.out.println(min);

    }
}
