package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779_게리맨더링2 {

    static int N, minDiff = Integer.MAX_VALUE, totalCnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalCnt += map[i][j];
            }
        }
        // 브루트포스. 기준점 x,y를 모두 가장자리 제외해놓고 모두 구한다
        for (int x = 1; x <= N - 2; x++) {
            for (int y = 2; y <= N - 1; y++) {
                //d1, d2를 정한다.
                for (int d2 = 1; d2 <= N - y; d2++) {
                    for (int d1 = 1; d1 <= Math.min(N - x - d2, y-1); d1++) {
                        // 선거구 1~5의 구역은 위의 변수들로 정할 수있다. 1-4를 먼저 계산하고, 나머지를 5로 생각한다.
                        if(x + d1 + d2 > N) continue;
                        int[] cnt = new int[5];
                        cnt[0] = sumArea1(x, y, d1, d2);
                        cnt[1] = sumArea2(x, y, d1, d2);
                        cnt[2] = sumArea3(x, y, d1, d2);
                        cnt[3] = sumArea4(x, y, d1, d2);
                        cnt[4] = totalCnt - cnt[0] - cnt[1] - cnt[2] - cnt[3];
                        Arrays.sort(cnt);
                        minDiff = Math.min(minDiff, cnt[4] - cnt[0]);
                    }
                }
            }
        }
        System.out.println(minDiff);
    }

    private static int sumArea4(int x, int y, int d1, int d2) {
        int cnt = 0;
        int k = 0;
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = (i<=(x+d1+d2) ? y+d2-k : y-d1+d2); j <= N; j++) {
                cnt += map[i][j];
            }
            k++;
        }
        return cnt;
    }

    private static int sumArea3(int x, int y, int d1, int d2) {
        int cnt = 0;
        int k = 0;
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < (i <= (x + d1 + d2) ? y - d1 + k : y - d1 + d2); j++) {
                cnt += map[i][j];
            }
            k++;
        }
        return cnt;
    }


    private static int sumArea2(int x, int y, int d1, int d2) {
        int cnt = 0;
        int k = 2;
        for (int i = 1; i <= x + d2; i++) {
            for (int j = (i <= x ? y + 1 : y + k); j <= N; j++) {
                cnt += map[i][j];
            }
            if (i > x) k++;
        }
        return cnt;

    }

    private static int sumArea1(int x, int y, int d1, int d2) {
        int cnt = 0;
        int k = 1;
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= (i < x ? y : y - k); j++) {
                cnt += map[i][j];
            }
            if (i >= x) k++;
        }
        return cnt;
    }
}