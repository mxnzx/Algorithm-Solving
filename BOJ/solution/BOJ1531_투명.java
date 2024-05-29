package solution;

import java.util.*;
import java.io.*;

public class BOJ1531_투명 {

    static int N, M;
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            for (int i = sr; i <= er; i++) {
                for (int j = sc; j <= ec; j++) {
                    map[i][j]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(map[i][j] > M) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
