package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14501_퇴사 {
    static int N, max;
    static int[][] profit;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        profit = new int[N+1][2];    //0:기간 1:가격
        for (int i = 1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());
            profit[i][0] = Integer.parseInt(st.nextToken());
            profit[i][1] = Integer.parseInt(st.nextToken());
        }

        // sol1: bottom-up
        dp = new int[N+2]; //idx: 일수 val:해당 일수까지 받을 수 있는 최대 금액
        for (int i = 1; i <= N; i++) {
            int endDay = i + profit[i][0] - 1;
            System.out.println(endDay);
            if(endDay <= N) {
                //현재(i)일을 선택했을 때와 안했을때의 더 큰 값 고르기
                dp[endDay] = Math.max(dp[endDay], dp[i - 1] + profit[i][1]);
            }
            //내 다음값(i+1)도 갱신해준다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
            System.out.println(i + " " + Arrays.toString(dp));
        }

        // sol2: top-down
        solution(1, 0);
        System.out.println(max);
    }

    private static void solution(int day, int sumUntilYesterday) {
        if(day == N + 1) {
            max = Math.max(max, sumUntilYesterday);
            return;
        }

        if(day + profit[day][0] <= N+1) {
            // 현재 일정을 선택한다.
            solution(day+profit[day][0], sumUntilYesterday+profit[day][1]);

        }
        // 선택하지 않는다.
        solution(day+1, sumUntilYesterday);
    }
}
