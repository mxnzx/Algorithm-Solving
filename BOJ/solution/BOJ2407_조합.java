package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407_조합 {

    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            n1 = n1.multiply(BigInteger.valueOf(n-i));
            n2 = n2.multiply(BigInteger.valueOf(i+1));
        }
        System.out.println(n1.divide(n2));
    }
}
