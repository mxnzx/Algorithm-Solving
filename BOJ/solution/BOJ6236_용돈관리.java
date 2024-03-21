package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236_용돈관리 {
    static int N, M;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        int maxMoney = -1;
        int totalMoney = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            maxMoney = Math.max(maxMoney, money[i]);
            totalMoney += money[i];
        }
        solution(maxMoney, totalMoney);
    }

    private static void solution(int maxMoney, int totalMoney) {
        long start = maxMoney;
        long end = totalMoney;
        long mid = (start + end) / 2;;
        while (start <= end) {
            mid = (start + end) / 2;
            int takeOutCnt = 0;
            long restMoney = 0;
            boolean isSuccess = true;
            for (int i = 0; i < N; i++) {
                if (restMoney < money[i]) {
                    takeOutCnt++;
                    restMoney = mid;
                }
                if (takeOutCnt > M) {
                    isSuccess = false;
                    break;
                }
                restMoney -= money[i];
            }
            if (isSuccess) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(mid);
    }
}
