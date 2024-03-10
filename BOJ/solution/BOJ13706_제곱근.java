package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ13706_제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger start = BigInteger.ONE;
        BigInteger end = N;
        BigInteger mid;
        while(start.compareTo(end) != 1) {
            mid  = (start.add(end)).divide(BigInteger.TWO);
            int tmp = mid.multiply(mid).compareTo(N);
            if(tmp == 0) {
                System.out.println(mid);
                break;
            } else if(tmp > 0) { // 현재 값의 제곱이 더 크다면 end = mid;
                end = mid.subtract(BigInteger.ONE);
            } else {
                start = mid.add(BigInteger.ONE);
            }
        }
    }
}
