/*
 * [BOJ]17829. 222풀링
 * 형태가 같고 사이즈가 작은 애들이 반복된다 -> 분할 정복 &재귀
 */

package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17829_222풀링 {
    static int N, Ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Ans = pooling(0, 0, N);
        System.out.println(Ans);

    }

    private static int pooling(int r, int c, int size) {

        if(size == 2) {
            int[] arr = {map[r][c], map[r][c+1], map[r+1][c], map[r+1][c+1]};
            Arrays.sort(arr);
            return arr[2];
        }


        int half = size / 2;
        int[] arr = {
                pooling(r, c, half),
                pooling(r, c + half, half),
                pooling(r + half, c, half),
                pooling(r + half, c + half, half)
        };
        Arrays.sort(arr);
        return arr[2];


    }
}
