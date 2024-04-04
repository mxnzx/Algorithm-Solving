package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        //매우 큰 수 > 규칙 없음 > 분할 정복: 분할 정복을 이용한 거듭제곱
        System.out.println(power(A, B, C));
    }

    private static long power(int a, int b, int mod) {

        if(b == 1) return a % mod;

        if(b % 2 == 0) {
            long n = power(a, b/2, mod);
            return (n * n) % mod;
        } else {
            long n = power(a, (b-1)/2, mod);
            return (((n * n) % mod) * a) % mod;
        }
    }
}
