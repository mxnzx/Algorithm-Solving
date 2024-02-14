package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ23971_ZOAC4 {
    static int H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int width = W % (M + 1) == 0 ? W / (M + 1) : W / (M + 1) + 1;
        int height = H % (N + 1) == 0 ? H / (N + 1) : H / (N + 1) + 1;
        int cnt = width * height;
        System.out.println(cnt);
    }
}
