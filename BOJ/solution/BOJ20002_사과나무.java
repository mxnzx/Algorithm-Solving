package solution;

import java.util.*;
import java.io.*;

public class BOJ20002_사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 구하기. 기준은 1,1 ~ x,y 직사각형의 합
        int[][] prefix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = map[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        // 총이익을 구한다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < Math.min(i, j); k++) {
                    int sum = prefix[i][j] - prefix[i - 1 - k][j] - prefix[i][j - 1 - k] + prefix[i - 1 - k][j - 1 - k];
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}
