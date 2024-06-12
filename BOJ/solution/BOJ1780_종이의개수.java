package solution;

import java.util.*;
import java.io.*;

public class BOJ1780_종이의개수 {

    static int N;
    static int[] ans = new int[3];
    static int[][] map;

    static boolean isAllSame(int size, int sr, int sc) {
        int init = map[sr][sc];
        for (int i = sr; i < sr + size; i++) {
            for (int j = sc; j < sc + size; j++) {
                if(init != map[i][j]) return false;
            }
        }
        ans[init+1]++;
        return true;
    }

    static void solution(int size, int sr, int sc) {

        if(isAllSame(size, sr, sc)) return;

        for (int i = sr; i < sr + size; i+= size/3) {
            for (int j = sc; j < sc + size; j += size/3) {
                solution(size / 3, i, j);
            }
        }
    }
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
        solution(N, 0, 0);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }
}
