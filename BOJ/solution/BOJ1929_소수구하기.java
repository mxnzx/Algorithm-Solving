package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1929_소수구하기 {
    static int m, n;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        // 소수 찾기 -> 에라토스테네스의 체
        isPrimeNumber();
        for (int i = m; i <= n; i++) {
            if(isPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void isPrimeNumber() {
        isPrime = new boolean[n+1];
        //일단 true 를 디폴트값으로 설정 후, 아닌 애들을 false 처리하기
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {   //2~n의 제곱근의 모든 수를 확인한다
            if(isPrime[i]) {    // 이 수가 소수라면, 해당수를 제외한 배수들 모두 false
                for (int j = i*i; j <= n; j+=i) {   //i*i 이 전의 수는 모두 검사된 것이다.
                    isPrime[j] = false;
                }
            }
        }
    }
}