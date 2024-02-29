package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922_겹치는건싫어 {

    static int N, K;
    static int[] arr, dp, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        check = new int[100001];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1, end = 1, max = -1;
        while(start > end || end <= N) {
            int n = arr[end];
            if(check[n] >= K) {
                for(int i = start; i < end; i++) {
                    check[arr[i]]--;
                    if(arr[i] == n) {
                        start = i + 1;
                        break;
                    }
                }
            }
            check[n]++;
            max = Math.max(max, end - start + 1);
            end++;
        }
        System.out.println(max);

//        int start = 1;
//        for (int end = 1; end <= N; end++) {
//            int n = arr[end];
//            if (check[n] >= K) {
//                for (int i = start; i < end; i++) {
//                    check[arr[i]]--;
//                    if (arr[i] == n) {
//                        dp[end] = dp[end - 1] - (i-start+1) + 1;
//                        start = i + 1;
//                        break;
//                    }
//                }
//            } else {
//                dp[end] = dp[end - 1] + 1;
//            }
//            check[n]++;
//        }
//        Arrays.sort(dp);
//        System.out.println(dp[N]);

    }
}
