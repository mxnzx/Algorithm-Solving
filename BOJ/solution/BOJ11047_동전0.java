package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11047_동전0 {
    static int N, K;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());    //목표금액
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());    //이들은 항상 어떤 수에 대해 그 전의 수들의 배수이다.
        }
        // 1. K값이 들어갈 자리를 찾는다.
        int tmpIdx = Arrays.binarySearch(coins, K);
        // 2. 만약 동전이 이미 있다면, 1을 출력하고 멈춘다.
        if(tmpIdx >= 0) {
            System.out.println(1);
            return;
        }
        // 3. 그 전 인덱스부터 찾고 여기부터 시작한다.
        int end = -(tmpIdx+1) - 1;
        int cnt = 0;
        // 4. 몫이 0보다 크다면 가능한 애들 다 나눠버리고, 그 다음으로 넘긴다. 아니면 그냥 다음으로 넘긴다.
        while(K>0) {
            int quot = K / coins[end];
            if(quot > 0)  {
                cnt += quot;
                K -= (coins[end] * quot);
            }
            end--;
        }
        System.out.println(cnt);
    }
}
