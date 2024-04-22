package solution;

import java.io.*;

public class BOJ5585_거스름돈 {
    static int cnt, rest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cnt = 0;
        rest = 1000 - n;

        solution(500);
        solution(100);
        solution(50);
        solution(10);
        solution(5);

        cnt += rest;
        System.out.println(cnt);
    }

    static void solution(int coin) {

        if (rest / coin > 0) {
            cnt += rest / coin;
            rest %= coin;
        }
    }
}
