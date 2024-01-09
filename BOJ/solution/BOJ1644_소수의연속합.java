package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1644_소수의연속합 {
    static int N;
    static List<Integer> primeNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primeNums = new ArrayList<>();
        /*
        1. N보다 작거나 같은 소수의 집합을 배열에 담는다.
        2. 부분합을 구하는 알고리즘을 사용해, 두 변수를 통해 부분합으로 N을 충족할 수 있는 경우의 수를 구한다.
         */
        if (N == 1) {
            System.out.println(0);
            return;
        }
        boolean[] isPrimeNumber = searchPrimeNumber(new boolean[N + 1]);    //유클리드호제법으로 소수를 찾는다
        for (int i = 2; i <= N; i++) {
            if (isPrimeNumber[i]) primeNums.add(i);
        }
        int ans = searchContinuousSum();
        System.out.println(ans);

    }

    private static int searchContinuousSum() {
        int cnt = 0, start = 0, end = start, sum = primeNums.get(start);
        while (true) {
            if(sum == N) cnt++;
            if(start >= end && start >= primeNums.size() - 1) break;
            if (sum <= N) {
                end++;
                sum += primeNums.get(end);
            } else {
                sum -= primeNums.get(start);
                start++;
            }
        }

        return cnt;
    }

    private static boolean[] searchPrimeNumber(boolean[] isPrimeNumber) {
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isPrimeNumber[i]) continue;
            for (int j = 2 * i; j <= N; j += i) {
                isPrimeNumber[j] = false;
            }
        }
        return isPrimeNumber;
    }
}
