package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ6588_골드바흐의추측 {
    static boolean[] isPrimeNumber;
    static List<Integer> inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        inputs = new ArrayList<>();
        int n, max = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            inputs.add(n);
            max = Math.max(max, n);
        }
        //2부터 돌면서 해당 숫자가 소수인지, 또 n-i의 수가 소수인지 소수이면 출력. 만약 다 돌았는데 해당하지 않으면 문장 출력.
        isPrimeNumber = new boolean[max+1];
        searchPrimeNumber(max);
        for (int i = 0; i < inputs.size(); i++) {
            boolean isSuccess = false;
            int num = inputs.get(i);
            for (int j = 2; j <= num / 2; j++) {
                if (isPrimeNumber[j] && isPrimeNumber[num - j]) {
                    sb.append(num).append(" = ").append(j).append(" + ").append(num - j).append("\n");
                    isSuccess = true;
                    break;
                }
            }
            if (!isSuccess) sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);
    }


    public static void searchPrimeNumber(int n) {
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isPrimeNumber[i]) continue;
            for (int j = i * 2; j <= n; j += i) {
                isPrimeNumber[j] = false;
            }
        }
    }
}
