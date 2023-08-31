package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ11652_카드 {
    static long[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cards = new long[(int) Math.pow(2,63)];
        System.out.println(Long.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

        }
    }
}
