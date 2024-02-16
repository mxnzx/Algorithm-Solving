package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16967_배열복원하기 {
    static int H,W,X,Y;
    static int[][] origin, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        origin = new int[H][W];
        B = new int[H+X][W+Y];
        /*
        0이 나오지 않을 때까지 그대로 origin에 넣는다
         */
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                    origin[i][j] = B[i][j];
            }
        }
        // 여기부터 첫 줄이 겹치는 순간
        for (int i = X; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                origin[i][j] = B[i][j];
            }
            for (int j = Y; j < W; j++) {
                origin[i][j] = B[i][j] - origin[i-X][j-Y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(origin[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
