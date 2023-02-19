package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1868_파핑지뢰 {

    static int T, N, Ans;
    static char[][] map;
    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T ; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            //지뢰가 하나도 없는 칸을 선택하면 8개의 칸에 자동으로 숫자를 표시함
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//
//                }
//            }
        }

    }
}
