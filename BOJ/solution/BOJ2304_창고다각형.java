package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2304_창고다각형 {

    static int N;
    static int[] pillars;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pillars = new int[1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pillars[l] = h;
        }

        int tmpMaxHeight = -1;
        int tmpIdx = -1;
        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            if (pillars[i] == 0) continue;
            if (tmpMaxHeight <= pillars[i]) {
                if (tmpIdx != -1) {
                    // 계산한다
                    int col = i - tmpIdx;
                    ans += (col * tmpMaxHeight);
                }
                tmpIdx = i;
                tmpMaxHeight = pillars[i];
            }
        }
        ans += tmpMaxHeight;

        int maxIdx = tmpIdx;
        tmpIdx = INF;
        tmpMaxHeight = -1;
        for (int i = 1000; i > maxIdx; i--) {
            if (pillars[i] == 0) continue;
            if (tmpMaxHeight <= pillars[i]) {
                if (tmpIdx != INF) {
                    int col = tmpIdx - i;
                    ans += (col * tmpMaxHeight);
                }
                tmpIdx = i;
                tmpMaxHeight = pillars[i];
            }
        }
        if(tmpIdx != INF) ans += (tmpMaxHeight * (tmpIdx - maxIdx));

        System.out.println(ans);
    }
}
